
const db = require('../db')
const utils = require('../utils')
const express = require('express')



const app = express()
const bodyparser = require('body-parser')
const mysql = require('mysql')
const multer = require('multer')
const path = require('path')
 

const router = express.Router()


/////////////////LIST OF feedbacks//////////////
router.get('/feedbackList', (request, response) => {
  
  // const statement = `select u.firstname ,u.email,f.feedback from users u join 
  //  feedback f on u.userid=f.userid;`
  const statement=`select * from feedback;`
  const connection = db.openConnection()
  connection.query(statement, (error, records) => {
    connection.end()
    response.send(utils.createResult(error, records))
  })
})
/////////////////LIST OF feedbacks//////////////
// router.get('/feedbackList/:id', (request, response) => {
//   const { id } = request.params
  
//   const statement = `select u.firstname ,u.email,f.feedback from users u join 
//    feedback f on u.userid=f.userid where u.userid=${id};`
//   const connection = db.openConnection()
//   connection.query(statement, (error, records) => {
//     connection.end()
//     response.send(utils.createResult(error, records))
//   })
// })


 
 

module.exports = router
