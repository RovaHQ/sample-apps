export const config = () => ({
  env: process.env.env || 'dev',
  // rova test keys
  rovaClientId: process.env.ROVA_CLIENT_ID,
  rovaClientSecret: process.env.ROVA_CLIENT_SECRET,
});
