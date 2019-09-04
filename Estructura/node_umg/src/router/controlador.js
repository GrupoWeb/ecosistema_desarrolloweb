const router = require('express').Router();

const voto = require('../models/votos');

router.post('/add', async (req, res) => {
    const { title, description } = req.query;
    const errors = [];
    
    // console.log(title);
    if(!title){
        errors.push({text: 'Please Write a Title'});
    }
    if(!description){
        errors.push({text: 'Please Write a Description'});
    }
    if(errors.length > 0){
        console.log(errors)
    }else{
        const newVotos = new voto({ title, description});
        await newVotos.save();
        console.log(newVotos);
        res.send('ok');
    }
    
});

module.exports = router;
