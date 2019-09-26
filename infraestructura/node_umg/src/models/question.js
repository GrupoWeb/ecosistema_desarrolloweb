const mongoose = require('mongoose');
const { Schema } = mongoose;



// Pregunta
const QuestionSchema = Schema({
    
    questionName: String
   
});

  
module.exports = mongoose.model('Question', QuestionSchema);