const express = require('express')
const db = require('../db')
const utils = require('../utils')

const router = express.Router()

/////////////////LIST OF ITEMS//////////////
router.get('/itemList', (request, response) => {
  

  const statement = `select * from item`
  const connection = db.openConnection()
  connection.query(statement, (error, records) => {
    connection.end()
    response.send(utils.createResult(error, records))
  })
})

router.get('/latest', (request, response) => {
  

  const statement = `select itemId from item order by itemId desc limit 1;`
  const connection = db.openConnection()
  connection.query(statement, (error, records) => {
    connection.end()
    response.send(utils.createResult(error, records))
  })
})

///////////////////////INSERT ITEM/////////////////////
router.post('/addItem', (request, response) => {
  const { type, itemName, description} = request.body
  // itemId | type | itemName | description     | size  | price
  const statement = `
    insert into item
       (type, itemName, description)
    values 
      ('${type}', '${itemName}', '${description}');`
  
console.log(statement)
  const connection = db.openConnection()
  connection.query(statement, (error, result) => {

    connection.end()
    response.send(utils.createResult(error, result))
  })
})
//////////////UPDATE ITEM////////////////
router.put('/updateItem/:id', (request, response) => {
  const {type, itemName, description } = request.body
  const { id } = request.params

  const statement = `
    update item
    set 
    type = '${type}', 
    itemName = '${itemName}', 
    description = '${description}'
    
    where
    itemid = ${id}
  `

  const connection = db.openConnection()
  connection.query(statement, (error, result) => {
    connection.end()
    response.send(utils.createResult(error, result))
  })
})
/////////////////////DELETE ITEM/////////////////////////
router.delete('/delete/:id', (request, response) => {
  const { id } = request.params

  const statement = `
    delete from item
    where
      itemid = ${id}
  `

  const connection = db.openConnection()
  connection.query(statement, (error, result) => {
    connection.end()
    response.send(utils.createResult(error, result))
  })
})
router.delete('/deleteAll/:id', (request, response) => {
  const { id } = request.params

  const statement = `
  delete  item,itemsize from item inner join itemSize where item.itemId=itemSize.itemId and 
      item.itemid = ${id}
  `

  const connection = db.openConnection()
  connection.query(statement, (error, result) => {
    connection.end()
    response.send(utils.createResult(error, result))
  })
})
/////////////////////////sort items(pizza) by price/////////////////////////////////
router.get('/sortPizzaList', (request, response) => {
  

  const statement = `
  select i.itemname,s.size,s.price from item i
   join itemsize s on i.itemid=s.itemid where i.itemname like'%pizza' order by s.price;`
  const connection = db.openConnection()
  connection.query(statement, (error, records) => {
    connection.end()
    response.send(utils.createResult(error, records))
  })
})
/////////////////////////sort items(colddrink) by price/////////////////////////////////
router.get('/sorCDList', (request, response) => {
  

  const statement = `select i.itemname,s.size,s.price from item i 
  join itemsize s on i.itemid=s.itemid where i.itemname like '%colddrink%' order by s.price;`
  const connection = db.openConnection()
  connection.query(statement, (error, records) => {
    connection.end()
    response.send(utils.createResult(error, records))
  })
})
///////////sort pizza by non-veg//////////
router.get('/sortVegPizza', (request, response) => {
  

  const statement = `select itemName from item where type="non-veg";`
  const connection = db.openConnection()
  connection.query(statement, (error, records) => {
    connection.end()
    response.send(utils.createResult(error, records))
  })
})
router.get('/getbyid/:id', (request, response) => {
  
  const { id } = request.params
  const statement = `select * from item where itemId=${id}`
  const connection = db.openConnection()
  connection.query(statement, (error, records) => {
    connection.end()
    response.send(utils.createResult(error, records))
  })
})


module.exports = router
