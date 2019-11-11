import { Module } from '@nestjs/common';

import { LogisticController } from './logistic.controller';
import { OrderModule } from '../../components/order/order.module';

@Module({
  imports: [
    OrderModule,
  ],
  controllers: [LogisticController],
})
export class LogisticModule { }
