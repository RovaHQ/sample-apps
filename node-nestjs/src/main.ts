import { NestFactory } from '@nestjs/core';
import { AppModule } from './app.module';
import helmet from 'helmet';

import { Logger } from './components/logger/logger.service';

async function bootstrap() {
  const app = await NestFactory.create(AppModule, {
    logger: new Logger(),
  });
  const options = {
    origin: true,
    method: 'GET,HEAD,PUT,PATCH,POST,DELETE',
    optionsSuccessStatus: 200,
    allowedHeaders: '*',
    maxAge: 86400,
  };

  app.use(helmet());
  app.enableCors(options);
  app.setGlobalPrefix('v1');
  await app.listen(3000);
}
bootstrap();
