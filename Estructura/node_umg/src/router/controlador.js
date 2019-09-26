const router = require('express').Router();


router.get('/', (req, res) => {
    res.send('router');
});

module.exports = router;
