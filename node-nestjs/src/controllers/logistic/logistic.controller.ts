import { Controller, Post, Get, Param, Delete } from '@nestjs/common';

import { OrderService } from '../../components/order/order.service';

@Controller('logistic')
export class LogisticController {
  constructor(
    private readonly orderService: OrderService,
  ) { }

  @Post('/')
  async createOrder(): Promise<object> {
    const order = await this.orderService.create(); 
    return {
      ...order,
    }
  }

  @Get('/:id')
  async getOrder(@Param('id') orderId: number): Promise<object> {
    const order = await this.orderService.get(orderId);
    return {
      ...order,
    };
  }

  @Delete('/:id')
  async deleteOrder(@Param('id') orderId: number): Promise<object> {
    const result = await this.orderService.delete(orderId);
    return {
      ...result,
    };
  } 
}
