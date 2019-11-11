import request from 'request-promise';

import { camelCase } from './deepCamelCase';
import { OrderInterface, OrderCreateInterface } from './types';

const BASE_URL = 'https://api.rovahq.com';

interface AuthInterface {
  accessToken: string
  tokenType: string
  expiresIn: number
  refreshToken: string
  scope: Array<string>
}

export class Client {
  private clientId: string = '';
  private clientSecret: string = '';
  private auth: AuthInterface = {
    accessToken: '',
    tokenType: '',
    expiresIn: 0,
    refreshToken: '',
    scope: [],
  };

  constructor(clientId: string = '', clientSecret: string = '') {
    this.clientId = clientId;
    this.clientSecret = clientSecret;
    return this;
  }

  init = async() => {
    await this.oauth();
    return this;
  }

  oauth = async() => {
    const { clientId, clientSecret } = this;
    try {
      const code = await request({
        method: 'GET',
        url: `${BASE_URL}/v2/oauth/authorize?client_id=${clientId}&response_type=code&scope=delivery`,
        followRedirect: false,
      })
        .catch((err) => {
          const { statusCode, headers } = err.response;
          switch (statusCode) {
            case 302:
              return headers.location.replace(/.*?code=/, '');
            default:
              throw err;
          }
        });

      const oauth = await request({
        method: 'POST',
        url: `${BASE_URL}/v2/oauth/token`,
        json: true,
        formData: {
          client_id: clientId,
          client_secret: clientSecret,
          code,
          grant_type: 'authorization_code',
        },
      });

      const {
        // @ts-ignore
        accessToken, tokenType, expiresIn, refreshToken, scope,
      } = camelCase(oauth);

      this.auth = {
        accessToken,
        tokenType,
        expiresIn,
        refreshToken,
        scope,
      };

      return this;
    } catch (err) {
      throw err;
    }
  }

  regenerateToken = async() => {
    const { clientId, clientSecret, auth } = this;

    try {
      const { refreshToken } = auth;
      const oauth = await request({
        method: 'POST',
        url: `${BASE_URL}/v2/oauth/token`,
        json: true,
        formData: {
          client_id: clientId,
          client_secret: clientSecret,
          refresh_token: refreshToken,
          grant_type: 'refresh_token',
        },
      });

      const {
        // @ts-ignore
        accessToken, tokenType, expiresIn, refreshToken: newRefreshToken, scope,
      } = camelCase(oauth);

      this.auth = {
        accessToken,
        tokenType,
        expiresIn,
        refreshToken: newRefreshToken || refreshToken,
        scope,
      };

      return this;
    } catch (err) {
      const { statusCode = 401 } = err.response || {};
      // last resort to regenerate a key
      if (statusCode === 401) {
        await this.init();
        return this;
      }
      throw err;
    }
  }

  createOrder = async (body: OrderCreateInterface, retry: boolean = true): Promise<OrderInterface> => {
    const { accessToken } = this.auth;

    try {
      const result = await request({
        method: 'POST',
        url: `${BASE_URL}/v2/entity/orders`,
        headers: {
          Authorization: `Bearer ${accessToken}`,
          'Content-Type': 'application/json',
        },
        json: true,
        body,
      });
      return result;
    } catch (err) {
      console.log(err.response);
      if (!retry) throw err;

      const { statusCode } = err.response;
      switch (statusCode) {
        case 401: {
          await this.regenerateToken();
          const res = await this.createOrder(body, false);
          return res;
        }
        default:
          throw err;
      }
    }
  }

  createQuote = async (body: OrderCreateInterface, retry: boolean = true): Promise<OrderInterface> => {
    const { accessToken } = this.auth;
    try {
      const result = await request({
        method: 'POST',
        url: `${BASE_URL}/v2/entity/orders/quote`,
        headers: {
          Authorization: `Bearer ${accessToken}`,
          'Content-Type': 'application/json',
        },
        json: true,
        body,
      });

      return result;
    } catch (err) {
      if (!retry) throw err;

      const { statusCode } = err.response;
      switch (statusCode) {
        case 401: {
          await this.regenerateToken();
          const res = await this.createQuote(body, false);
          return res;
        }
        default:
          throw err;
      }
    }
  }

  cancelOrder = async(orderId : number, retry: boolean = true) => {
    const { accessToken } = this.auth;

    try {
      const result = await request({
        method: 'PUT',
        url: `${BASE_URL}/v2/entity/orders/${orderId}/status`,
        headers: {
          Authorization: `Bearer ${accessToken}`,
          'Content-Type': 'application/json',
        },
        json: true,
        body: {
          deliveryStatus: 'cancelled',
        },
      });

      return result;
    } catch (err) {
      if (!retry) throw err;

      const { statusCode } = err.response;
      switch (statusCode) {
        case 401: {
          await this.regenerateToken();
          const res = await this.cancelOrder(orderId, false);
          return res;
        }
        default:
          throw err;
      }
    }
  }

  getOrder = async (orderId: number, retry: boolean = true): Promise<OrderInterface> => {
    const { accessToken } = this.auth;
    try {
      const order = await request({
        method: 'GET',
        url: `${BASE_URL}/v2/entity/orders/${orderId}`,
        headers: {
          Authorization: `Bearer ${accessToken}`,
          'Content-Type': 'application/json',
        },
        json: true,
      });
      return order;
    } catch (err) {
      if (!retry) throw err;
      const { statusCode } = err.response;
      switch (statusCode) {
        case 401: {
          await this.regenerateToken();
          const res = await this.getOrder(orderId, false);
          return res;
        }
        default:
          throw err;
      }
    }
  }

  updateOrder = async (order: OrderInterface, retry: boolean = true) => {
    const { accessToken } = this.auth;
    const {
      pickUpDateTime,
      pickUpAddress,
      shipToAddress,
      vehicleType,
      tips,
      items,
    } = order;

    try {
      const modified = await request({
        method: 'PUT',
        url: `${BASE_URL}/v2/entity/orders/${order.id}`,
        headers: {
          Authorization: `Bearer ${accessToken}`,
          'Content-Type': 'application/json',
        },
        json: true,
        body: {
          pickUpDateTime,
          pickUpAddress,
          shipToAddress,
          vehicleType,
          tips,
          items,
        },
      });

      return modified;
    } catch (err) {
      if (!retry) throw err;
      const { statusCode } = err.response;
      switch (statusCode) {
        case 401: {
          await this.regenerateToken();
          const res = await this.updateOrder(order, false);
          return res;
        }
        default:
          throw err;
      }
    }
  }
}
