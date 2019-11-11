import { Injectable, NestMiddleware } from '@nestjs/common';
import { Request, Response } from 'express';
import uuid from 'uuid/v4';
import { logger } from '../components/logger';

@Injectable()
export class LoggerMiddleware implements NestMiddleware {
  use(req: Request, res: Response, next: Function) {
    const startAt = Date.now();
    const { url } = req;
    let { method } = req;

    const reqId = req.get('x-request-id') || uuid();
    // @ts-ignore
    req.__reqId = reqId;
    // @ts-ignore
    logger.child({ reqId });
    res.once('finish', () => {
      const timeEllapsed = Date.now() - startAt;
      const status = res.statusCode || undefined;
      method = (method || '').toUpperCase();
      logger.info({
        reqId,
        method,
        status,
        timeEllapsed,
        url,
      }, `${method} ${url} ${timeEllapsed}ms ${status}`);
    });
    next();
  }
}
