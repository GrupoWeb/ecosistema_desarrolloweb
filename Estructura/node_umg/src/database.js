const mongoose = require('mongoose');

mongoose.connect('mongodb://localhost/votos',{
    useCreateIndex: true,
    useNewUrlParser: true,
    useFindAndModify: false
})
    .then(dv => console.log('DB is connect'))
    .catch(err => console.log(err));

