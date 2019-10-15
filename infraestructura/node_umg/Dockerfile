FROM node

COPY ["package.json" , "/usr/src/"]

WORKDIR /usr/src/app

COPY ["." ,"/usr/src/"]

EXPOSE 3000


CMD ["npx", "nodemon", "src/index.js"]


RUN npm install