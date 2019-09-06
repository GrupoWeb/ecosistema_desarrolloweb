const mongoose = require('mongoose');
const { Schema } = mongoose;



// Pregunta
const QuestionSchema = Schema({
    questionName: String
   
});

// // Respuesta
// const answerSchema = Schema({
//     _id: Schema.Types.ObjectId,
//     answernName: String
// });
  
// // Encuesta
// const surveySchema = Schema({
//     _id: Schema.Types.ObjectId,
//     surveynName: String
// });
    
// // Pregunta-Encuesta
// const Question_SurveySchema = Schema({
//     _id: Schema.Types.ObjectId,
//     surveyId: [{ type: Schema.Types.ObjectId, ref: 'Survey' }],
//     questionId: [{ type: Schema.Types.ObjectId, ref: 'Question' }],
//     answerId: [{ type: Schema.Types.ObjectId, ref: 'Answer' }],
// });

  
module.exports = mongoose.model('votos', QuestionSchema);
// const Survey = mongoose.model('Survey', surveySchema);
// const Answer = mongoose.model('Answer', answerSchema);


// module.exports = Question;
// module.exports = Survey;
// module.exports = Answer;