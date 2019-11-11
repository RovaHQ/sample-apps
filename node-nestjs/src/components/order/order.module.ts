import { Module } from '@nestjs/common';

import { ConfigModule } from '../config/config.module';
import { OrderService } from './order.service';

@Module({
  imports: [ConfigModule],
  providers: [OrderService],
  exports: [OrderService],
})
export class OrderModule { }

