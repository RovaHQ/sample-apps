import * as _ from 'lodash';
import { Injectable } from '@nestjs/common';
import * as dateFns from 'date-fns';

import { ConfigService } from '../config/config.service';
import { Client } from './rova';
import { OrderInterface, OrderCreateInterface } from './types';

@Injectable()
export class OrderService {
  private rovaClient;

  constructor(
    private readonly configService: ConfigService
  ) {
    this.rovaClient = new Client(this.configService.get('rovaClientId'), this.configService.get('rovaClientSecret'));
  }

  create = async (): Promise<OrderInterface> => {
    const sampleOrder = {
      vehicleType: 'car',
      deliveryCategory: 'boxes',
      orderReferenceId: 'test 123',
      pickUpDateTime: dateFns.format(dateFns.addMinutes(new Date(), 60), "yyyy-MM-dd'T'HH:mm:ss.SSSxxx"),
      pickUpAddress: {
        company: 'Jimmy\'s Soccer Emporium',
        address: '1601 5th Ave',
        address2: '',
        locality: 'WA',
        city: 'Seattle',
        instructions: 'Ask for \"Jimmy\" at the front door.',
        phone: '415-222-1111',
        name: 'Jimmy Cricket',
        name2: '',
        postalCode: '98101'
      },
      shipToAddress: {
        company: '',
        name: 'Kristina',
        address: '325 5th Ave N',
        address2: '',
        locality: 'WA',
        city: 'Seattle',
        instructions: 'Please call Kristina at arrival',
        phone: '2062221234',
        postalCode: '98109'
      },
      tips: 10,
      webhookUrl: 'https://example.com/v2/logistic/event',
    };

    const quote = await this.rovaClient.createQuote(sampleOrder);
    const { id: quoteId, cost } = quote;

    console.log('order priced @', cost);

    const order = await this.rovaClient.createOrder({
      quote: {
        id: quoteId,
      },
      ...sampleOrder,
    });

    return order;
  }

  get = async (orderId: number): Promise<OrderInterface> => {
    const order = await this.rovaClient.getOrder(orderId);
    return order;
  }

  delete = async (orderId: number): Promise<object> => {
    const result = await this.rovaClient.cancelOrder(orderId);
    return result;
  } 
}