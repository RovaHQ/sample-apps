import { Controller, Get } from '@nestjs/common';

@Controller('heartbeat')
export class HealthzController {
  @Get()
  checkHealth(): string {
    return 'STELLAR';
  }
}
