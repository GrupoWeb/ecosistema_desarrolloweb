FROM node:10

COPY ["package.json" , "/usr/src/"]

# WORKDIR /usr/src/app
WORKDIR /usr/src/app

RUN npm install

COPY ["." ,"/usr/src/"]

EXPOSE 3000

CMD ["npx", "nodemon", "src/index.js"]

