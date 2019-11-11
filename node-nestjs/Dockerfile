FROM node:12.3-alpine

RUN mkdir -p /node-nestjs

WORKDIR /node-nestjs

ADD ./package.json /var/has/node-nestjs/package.json

RUN apk add --no-cache --virtual .gyp \
  python \
  make \
  g++ \
  && npm i \
  && apk del .gyp

EXPOSE 3000
