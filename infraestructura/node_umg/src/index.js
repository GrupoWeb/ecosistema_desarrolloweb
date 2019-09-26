const express = require('express');
const path  = require('path');

// Initilizations
const app = express();
require('./database')

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