const mongoose = require('mongoose');
const { Schema } = mongoose;

const VotosShema = new Schema({
    title: { type: String, required: true },
    description: { type: String, required: true },
});

module.exports = mongoose.model('VotosShema', VotosShema)