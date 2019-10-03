const router = require('express').Router();
const express = require('express');
const Keycloak = require('keycloak-connect');
const session = require('express-session');
const app = express();

//initial const for keycloak

var memoryStore = new session.MemoryStore();

//create keycloak

app.use(session({
    secret: 'mySecret',
    resave: false,
    saveUninitialized: true,
    store: memoryStore
}));


var keycloak = new Keycloak({ store: memoryStore });

app.use(keycloak.middleware({
    logout: '/logout',
    admin: '/',
    protected: '/protected/resource'
  }));


  const keycloakHost = '172.20.0.8';
  const keycloakPort = '8080';
  const realmName = 'dev';
  
  // check each request for a valid bearer token
  app.use((req, res, next) => {
    // assumes bearer token is passed as an authorization header
    if (req.headers.authorization) {
            // configure the request to your keycloak server
            const options = {
                method: 'GET',
                url: `https://${keycloakHost}:${keycloakPort}/auth/realms/${realmName}/protocol/openid-connect/userinfo`,
                headers: {
                // add the token you received to the userinfo request, sent to keycloak
                Authorization: req.headers.authorization,
                },
            };
  
            // send a request to the userinfo endpoint on keycloak
            request(options, (error, response, body) => {
                if (error) throw new Error(error);
        
                // if the request status isn't "OK", the token is invalid
                if (response.statusCode !== 200) {
                res.status(401).json({
                    error: `unauthorized`,
                });
                }
                // the token is valid pass request onto your next function
                else {
                next();
                }
            });
    } else {
            // there is no token, don't process request further
            res.status(401).json({
            error: `unauthorized`,
            });
  };
});

  // configure your other routes
  app.use('/some-route', (req, res) => {
    /*
    * api route logic
    */
  });
  
  
  // catch 404 and forward to error handler
  app.use((req, res, next) => {
    const err = new Error('Not Found');
    err.status = 404;
    next(err);
  });







router.get('/web/index', keycloak.protect(), (req, res) => {
    res.send('router');
});


router.get('/',(req, res) => {
    res.send('root');
});

module.exports = router;
