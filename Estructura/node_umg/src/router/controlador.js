const router = require('express').Router();

const voto = require('../models/votos');

router.get('/', (req, res) => {
    res.send('ok');
})

router.post('/add', async (req, res) => {
    // const { title, description } = req.query; 
    const { questionName } = req.query; 
    const errors = [];
    if(!questionName){
        errors.push({text: 'Please Write a questionName'});
    }
    // if(!description){
    //     errors.push({text: 'Please Write a Description'});
    // }
    if(errors.length > 0){
        console.log(errors)
    }else{
        // const newVotos = new voto({ title, description});
        const newVotos = new voto({ questionName });
        await newVotos.save();
        console.log(newVotos);
        res.send('ok');
    }

});

module.exports = router;
