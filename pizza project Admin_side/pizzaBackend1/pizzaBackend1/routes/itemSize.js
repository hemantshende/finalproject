const express = require('express')
const db = require('../db')
const utils = require('../utils')

const router = express.Router()

/////////////////LIST OF items with there Sizes//////////////
router.get('/itemSizeList', (request, response) => {
  

  const statement = `select i.itemId,i.type,i.itemName,i.description,s.size,s.price 
  from item i  join itemSize s on i.itemid=s.itemid ;`
  const connection = db.openConnection()
  connection.query(statement, (error, records) => {
    connection.end()
    response.send(utils.createResult(error, records))
  })
})
/////////////////////////details of specific size pizza/////////////////
router.get('/itemsizeId/:id', (request, response) => {
    const { id } = request.params
    const statement = `select sizeId,size,price 
    from itemSize where itemId='${id}';
    `
    const connection = db.openConnection()
    connection.query(statement, (error, records) => {
      connection.end()
      if (records.length > 0) {
        response.send(utils.createResult(error, records))
      } else {
        response.send(utils.createResult('item does not exist'))
      }
    })
  })

///////////////////////INSERT ITEMSize/////////////////////
router.post('/addItemSize', (request, response) => {
  const { itemId, size, price} = request.body
  //sizeId | itemId | size  | price
  const statement = `
    insert into itemSize
      ( itemId, size, price)
    values 
      ('${itemId}', '${size}', '${price}')
  `

  const connection = db.openConnection()
  connection.query(statement, (error, result) => {
    connection.end()
    response.send(utils.createResult(error, result))
  })
})
//////////////UPDATE item size and price from sizeid////////////////
router.put('/updateItemSize/:id', (request, response) => {
  const {size, price } = request.body
  const { id } = request.params

  const statement = `
    update itemSize
    set 
    size = '${size}', 
    price = '${price}' 
  
    where
    sizeid = ${id}
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
    delete from itemSize
    where
      sizeid = ${id}
  `

  const connection = db.openConnection()
  connection.query(statement, (error, result) => {
    connection.end()
    response.send(utils.createResult(error, result))
  })
})
//////////////////////////////////////////////////////////


module.exports = router
