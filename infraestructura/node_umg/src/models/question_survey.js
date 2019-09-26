const mongoose = require('mongoose');
const { Schema } = mongoose;



// Pregunta-Encuesta
const Question_SurveySchema = Schema({
    surveyId: [{ type: Schema.Types.ObjectId, ref: 'Survey' }],
    questionId: [{ type: Schema.Types.ObjectId, ref: 'Question' }],
    answerId: [{ type: Schema.Types.ObjectId, ref: 'Answer' }],
});

  
module.exports = mongoose.model('Question_Survey', Question_SurveySchema);

