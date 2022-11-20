const express = require('express')
const db = require('../db')
const utils = require('../utils')
const cryptoJs = require('crypto-js')

// used this for adding the promise support for executing the db queries
//const mysql2 = require('mysql2/promise')

// router which helps user module to add all the routes to the main app
const router = express.Router()

// async is a keyword added by JS to execute functionality asynchronously
// mandatory to use await keyword inside a function
async function checkEmailExist(email) {
  // wait till the mysql connection gets opened
  const connection = await db.openConnection2()

  const emailStatement = `select email from user where email = '${email}'`

  // wait till the query gets executed
  const [emails] = await connection.execute(emailStatement)

  connection.end()
  return emails.length > 0
}
/////////////SIGNUP ADMIN//////////////////////////////////////

router.post('/signup', (request, response) => {
 
  const { firstname, lastname,email,phoneNo,password,role } = request.body

  const connection = db.openConnection()

  // check if the email sent by user already exists in the table
  const emailStatement = `select email from users where email = '${email}'`
  connection.query(emailStatement, (error, emails) => {
    if (error) {
      // if error is generated while executing the query
      response.send(utils.createResult(error))
    } else {
      if (emails.length == 0) {
        // encrypt the password

       const encryptedPassword = cryptoJs.SHA512(password)

        // there is no user registered with this email
        const statement = `
        insert into users (firstname, lastname, email, phoneNo, password, role) 
        values ('${firstname}', '${lastname}', '${email}', '${phoneNo}', '${encryptedPassword}', '${role}')`
        connection.query(statement, (error, result) => {
          connection.end()
          response.send(utils.createResult(error, result))
        })
      } else {
        // at least one user exists with this email address
        connection.end()
        response.send(
          utils.createResult('email address already exists, please use another')
        )
      }
    }
  })
})

////////////////////////////SIGNIN//////////////////////////////////////////

router.post('/signin', (request, response) => {
  const { email, password } = request.body

  const connection = db.openConnection()

   //encrypt the password
  const encryptedPassword = cryptoJs.SHA512(password)

  const statement = 
  `select 
    userId, firstName, lastName ,email ,phoneNo from users 
  where 
    email = '${email}' and 
    password = '${password}'`
   // password = '${encryptedPassword}'
   console.log(email);
   console.log(password);

  connection.query(statement, (error, users) => {
    

console.log(users);
console.log(statement);


    if (error) {
      response.send(utils.createResult(error))
    } else if (users.length == 0) {
      // there is no user matching the criteria
      response.send(utils.createResult('user not found'))
    } else {

      const user = users[0]
      console.log(user);
      response.send(utils.createResult(null, user))
      
    }
    connection.end()

  })
})

////////////////////////////GET specific USER DETAILS///////////////////////////////////////////////
router.get('/profile', (request, response) => {
  const { id } = request.params
  const statement = `
  select * from users where role = 'User' ;
  `
  const connection = db.openConnection()
  connection.query(statement, (error, records) => {
    connection.end()
    if (records.length > 0) {
      response.send(utils.createResult(error, records))
    } else {
      response.send(utils.createResult('user does not exist'))
    }
  })
})
//////////////UPDATE userdetails////////////////
router.put('/updateUser/:id', (request, response) => {
  // firstname | lastname | email         | phoneNo   | password 
  const {firstname, lastname, email,phoneNo,password } = request.body
  const { id } = request.params

   //encrypt the password
   const encryptedPassword = cryptoJs.SHA512(password)

  const statement = `
    update users
    set 
    firstname = '${firstname}', 
    lastname = '${lastname}', 
    email = '${email}',
    phoneNo = '${phoneNo}',
    password = '${encryptedPassword}'
    
    where
    userid = ${id}
  `

  const connection = db.openConnection()
  connection.query(statement, (error, result) => {
    connection.end()
    response.send(utils.createResult(error, result))
  })
})
 
// used to export the router which has all the apis added
module.exports = router
