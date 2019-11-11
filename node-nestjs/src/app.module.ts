import { Module, NestModule, MiddlewareConsumer } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';

import { LoggerMiddleware } from './middlewares/logger.middleware';
import { HealthzModule } from './controllers/healthz/healthz.module';
import { LogisticModule } from './controllers/logistic/logistic.module';

@Module({
  imports: [
    HealthzModule,
    LogisticModule,
  ],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule implements NestModule {
  configure(consumer: MiddlewareConsumer) {
    consumer
      .apply(LoggerMiddleware)
      .forRoutes('*');
  }
}
