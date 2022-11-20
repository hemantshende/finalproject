const express = require('express')
const db = require('../db')
const utils = require('../utils')

const router = express.Router()

//////////////UPDATE status////////////////
router.post('/dStatus/:id', (request, response) => {
  const {deliverystatus } = request.body
  const { id } = request.params

  const statement = `
    update deliverystatus
    set 
    deliverystatus = '${deliverystatus}'
    where
    deliveryId = ${id}
  `
  const connection = db.openConnection()
  connection.query(statement, (error, result) => {
    connection.end()
    response.send(utils.createResult(error, result))
  })
})


module.exports = router
