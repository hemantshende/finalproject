const express = require('express')
const db = require('../db')
const utils = require('../utils')

const router = express.Router()

/////////////////LIST OG TOPPINGS//////////////
router.get('/toppingList', (request, response) => {
  

  const statement = `select * from toppings`
  const connection = db.openConnection()
  connection.query(statement, (error, records) => {
    connection.end()
    response.send(utils.createResult(error, records))
  })
})
router.get('/toppingListbyId/:id', (request, response) => {
  
  const { id } = request.params
  const statement = `select * from toppings where toppingId=${id}`
  const connection = db.openConnection()
  connection.query(statement, (error, records) => {
    connection.end()
    response.send(utils.createResult(error, records))
  })
})

///////////////////////INSERT TOPPINGS/////////////////////
router.post('/addToppings', (request, response) => {
  const { toppingName , price} = request.body
  
  const statement = `
    insert into toppings
      (toppingName , price)
    values 
      ('${toppingName}','${price}')
  `
//toppingName  | price
  const connection = db.openConnection()
  connection.query(statement, (error, result) => {
    connection.end()
    response.send(utils.createResult(error, result))
  })
})
//////////////UPDATE TOPPINGS////////////////
router.put('/updateTopping/:id', (request, response) => {
  const {toppingName, price} = request.body
  const { id } = request.params

  const statement = `
    update toppings
    set 
    toppingName ='${toppingName}',
    price = '${price}'
    where
    toppingId = ${id}
  `

  const connection = db.openConnection()
  connection.query(statement, (error, result) => {
    connection.end()
    response.send(utils.createResult(error, result))
  })
})
/////////////////////DELETE TOPPINGS/////////////////////////
router.delete('/delete/:id', (request, response) => {
  const { id } = request.params

  const statement = `
    delete from toppings
    where
      toppingId = ${id}
  `

  const connection = db.openConnection()
  connection.query(statement, (error, result) => {
    connection.end()
    response.send(utils.createResult(error, result))
  })
})
//////////////////////////////////////////////////////////


module.exports = router
