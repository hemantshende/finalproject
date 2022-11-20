const express = require('express')
const db = require('../db')
const utils = require('../utils')

const router = express.Router()

/*
/////////////////LIST OF payments//////////////
router.get('/paymentList', (request, response) => {
  
  const statement = `select * from payments`
  const connection = db.openConnection()
  connection.query(statement, (error, records) => {
    connection.end()
    response.send(utils.createResult(error, records))
  })
})
*/
///////list of payments with user info///////
router.get('/paymentList', (request, response) => {
  
  const statement = `select p.payid ,p.userid,u.firstname,u.lastname,u.email,u.phoneno, p.totalamount, p.mode, p.payTimeStamp 
  from payments p  join users u on p.userid=u.userid;`
  const connection = db.openConnection()
  connection.query(statement, (error, records) => {
    connection.end()
    response.send(utils.createResult(error, records))
  })
})
  ///////////////payment of specific user by id///////////
  router.get('/paymentList/:id', (request, response) => {
    const { id } = request.params
    const statement = `select p.payid ,p.userid,u.firstname,u.lastname,u.email,u.phoneno, p.totalamount, p.mode, p.payTimeStamp 
    from payments p  join users u on p.userid=u.userid where u.userid=${id};`
    const connection = db.openConnection()
    connection.query(statement, (error, records) => {
      connection.end()
      response.send(utils.createResult(error, records))
    })
  })
    ///////////////payment of specific user by id///////////
    router.get('/paymentList/:id', (request, response) => {
      const { id } = request.params
      const statement = `select p.payid ,p.userid,u.firstname,u.lastname,u.email,u.phoneno, p.totalamount, p.mode, p.payTimeStamp 
      from payments p  join users u on p.userid=u.userid where u.userid=${id};`
      const connection = db.openConnection()
      connection.query(statement, (error, records) => {
        connection.end()
        response.send(utils.createResult(error, records))
      })
    })
   
      ///////////////payment of specific user by name///////////
  router.get('/paymentList/:"name"', (request, response) => {
    const { name } = request.params
    const statement = `select p.payid ,p.userid,u.firstname,u.lastname,u.email,u.phoneno, p.totalamount, p.mode, p.payTimeStamp 
    from payments p  join users u on p.userid=u.userid where u.firstName=${name};`
    const connection = db.openConnection()
    connection.query(statement, (error, records) => {
      connection.end()
      response.send(utils.createResult(error, records))
    })
  })
 

//////////////UPDATE PAYMENT-STATUS////////////////
router.post('/updatePayments/:id', (request, response) => {
  const {payStatus } = request.body
  const { id } = request.params

  const statement = `
    update payments
    set 
    payStatus= '${payStatus}'
    where
    payId = ${id}
  `

  const connection = db.openConnection()
  connection.query(statement, (error, result) => {
    connection.end()
    response.send(utils.createResult(error, result))
  })
})

module.exports = router
