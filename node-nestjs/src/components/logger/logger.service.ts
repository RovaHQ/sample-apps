import { LoggerService } from '@nestjs/common';
import { logger } from './';

export class Logger implements LoggerService {
  log(message: string) {
    logger.info(message);
  }
  error(message: string, trace: string) {
    logger.error(message);
    logger.trace(trace);
  }
  warn(message: string) {
    logger.warn(message);
  }
  debug(message: string) {
    logger.debug(message);
  }
  verbose(message: string) {
    logger.debug(message);
  }
}