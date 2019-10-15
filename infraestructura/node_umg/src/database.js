const mongoose = require('mongoose');

// const MONGO_USERNAME = 'sammy';
// const MONGO_PASSWORD = 'your_password';
// const MONGO_HOSTNAME = '172.20.0.10';
// const MONGO_PORT = '27017';
// const MONGO_DB = 'sharkinfo';

// const url = `mongodb://${MONGO_USERNAME}:${MONGO_PASSWORD}@${MONGO_HOSTNAME}:${MONGO_PORT}/${MONGO_DB}?authSource=admin`;

// mongoose.connect(url, {
//     useNewUrlParser: true,
//     useCreateIndex: true,
//     useNewUrlParser: true,
//     useFindAndModify: false
// })
// .then(dv => console.log('DB is connect'))
// .catch(err => console.log(err));
// const connectDb = () => {
return mongoose.connect('mongodb://mongodb:27017/votos',{
// return mongoose.connect('mongodb://172.20.0.9:27017/votos',{
// return mongoose.connect('mongodb://172.20.0.10:8081//votos',{
    useCreateIndex: true,
    useNewUrlParser: true,
    useFindAndModify: false
})
    .then(dv => console.log('DB is connect'))
    .catch(err => console.log(err));
// }
// module.exports = connectDb;