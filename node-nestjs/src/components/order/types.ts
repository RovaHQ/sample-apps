export interface ItemInterface {
  name: string
  quantity: number
};

export type DeliveryCategories = 'print' | 'boxes' | 'food' | 'retail' | 'food' | 'others';

export interface OrderCreateInterface {
  quote?: {
    id: string
  }
  items?: Array<ItemInterface>
  pickUpDateTime: string
  pickUpAddress: {
    address: string
    address2: string
    company: string
    city: string
    instructions: string
    locality: string
    name: string
    name2: string
    phone: string
    postal_code: string
  },
  shipToAddress: {
    address: string
    address2: string
    company: string
    city: string
    instructions: string
    locality: string
    name: string
    name2: string
    phone: string
    postal_code: string
  },
  vehicleType: 'car' | 'van'
  webhookUrl?: string
  tips: number
  deliveryCategory: DeliveryCategories
};

export type OrderInterface = OrderCreateInterface & {
  id: number
}

export type CourierInterface = {
  name: string
  phone: string
};

export type QuoteInterface = {
  cost: number
  tips: number
  travelDistance: number
  travelTimeEta: number
};

export type Event = {
  id: string,
  object: 'event',
  apiVersion: string
  created: number // iso 8601
  data: {
    orderId: number
    orderUUID: string
    status: string
    timestamp: string
    trackingLink: string
    metadata?: any,
    courier?: CourierInterface,
    quote?: QuoteInterface,
  },
  livemode: true | false,
  request: {
    id?: string
  },
  type: 'customer.order.created' | 'customer.order.cancelled' | 'customer.order.delivering' | 'customer.order.delivered' | 'customer.order.accepted',
};
