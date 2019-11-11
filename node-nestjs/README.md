# Nodejs Example (using nestjs and typescript)

This example app should be able to provide a quick run down on creating, retreiving and deleting an rova order.

Most of the useful implentations can be found under `src/components/order`

## Setup and Requirements
Requires
```
docker
node >=12.3
```

Create a file named `env` inside this folder
```
touch env
```

Add your rova test client ids and secret, it can be found under https://portal.rovahq.com/workspace

```
ROVA_CLIENT_ID=XXXXXX
ROVA_CLIENT_SECRET=XXXXXX
```

install node packages
```
npm i
```

start it up
```
docker-compose up
```