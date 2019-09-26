const mongoose = require('mongoose');
const { Schema } = mongoose;




  
// // Encuesta
const surveySchema = Schema({
    surveynName: String
});
    
  
module.exports = mongoose.model('survey', surveySchema);

