const express = require('express');
const path  = require('path');

//-------------------- EUREKA CONFIG---------------------------
var bodyParser = require('body-parser');

const Eureka = require('eureka-js-client').Eureka;
const eureka = new Eureka({
    instance: {
      app: 'node-mongo',
      hostName: 'node-mongo',
      ipAddr: '127.0.0.1',
      statusPageUrl: 'http://172.20.0.12:3000',
      port: {
        '$': 3000,
        '@enabled': 'true',
      },
      vipAddress: 'localhost',
      dataCenterInfo: {
        '@class': 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo',
        name: 'MyOwn',
      }
    },
    eureka: {
      host: '172.20.0.5',
      port: 8761,
      servicePath: '/eureka/apps/'
    }
  });
  // eureka.logger.level('debug');
  // eureka.start(function(error){
  //   console.log(error || 'complete');
  // });
//-------------------------------------------------------

// Initilizations
const app = express();
require('./database');

app.use(bodyParser.urlencoded({extended: false}));
app.use(bodyParser.json());

// Settings
app.set('port', process.env.PORT || 3000);
app.set('views', path.join(__dirname, 'views'));

// Moddlewares

// Global Variables

// Router
app.use(require('./router/controlador'))

// Static Files

// Server run

app.listen(app.get('port'), () => {
    console.log('Server on port', app.get('port'));
});