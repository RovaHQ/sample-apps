import * as dotenv from 'dotenv';

import { config } from './config';

type ConfigType = any;

export class ConfigService {
  private readonly envConfig: { [key: string]: ConfigType };

  constructor() {
    dotenv.config();
    this.envConfig = config();
  }

  get(key: string): ConfigType {
    return this.envConfig[key];
  }
}