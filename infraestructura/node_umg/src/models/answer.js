const mongoose = require('mongoose');
const { Schema } = mongoose;



// // Respuesta
const answerSchema = Schema({
    answernName: String
});

module.exports = mongoose.model('Answer', answerSchema);

