const express = require('express')
const db = require('../db')
const utils = require('../utils')

const router = express.Router()

/////////////////LIST OF ORDERS//////////////
router.get('/orderList', (request, response) => {
  
  const statement = `select * from orders`
  const connection = db.openConnection()
  connection.query(statement, (error, records) => {
    connection.end()
    response.send(utils.createResult(error, records))
  })
})


  
/////////////////////DELETE ORDER/////////////////////////
router.delete('/delete/:id', (request, response) => {
  const { id } = request.params

  const statement = `
    delete from orders
    where
      orderId = ${id}
  `

  const connection = db.openConnection()
  connection.query(statement, (error, result) => {
    connection.end()
    response.send(utils.createResult(error, result))
  })
})
//////////////////////////////////////////////////////////


module.exports = router
