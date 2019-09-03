const mongoose = require('mongoose');


return mongoose.connect('mongodb://172.20.0.9:27017/votos',{
    useCreateIndex: true,
    useNewUrlParser: true,
    useFindAndModify: false
})
    .then(dv => console.log('DB is connect'))
    .catch(err => console.log(err));
