// require:
// - load the module
// - it requires the path of the module
const express = require('express')
const cors = require('cors')
const routerAdmin = require('./routes/admin')
 const routerItem = require('./routes/item')
 const routerTopping = require('./routes/toppings')
 const routerOrders = require('./routes/orders')
 const routerDeleverySatatus = require('./routes/deliveryStatus')
 const routerPayment = require('./routes/payments')
 const routerFeedback = require('./routes/feedback')
 const routerItemSize = require('./routes/itemSize')


// const routerPayment = require('./routes/payment')
// const routerDeliveryStatus = require('./routes/deliveryStatus')
// const routerFeedback = require('./routes/Feedback')


const app = express()

// enable CORS (Cross Origin Resource Sharing)
// needed for client to call the apis from different url
app.use(cors('*'))

// add the json parser to parse the json data sent through
// the request body
app.use(express.json())

// use the router to find all the apis related to the user
app.use('/admin', routerAdmin)

// use the router to find all the apis related to the blogs
app.use('/item', routerItem)

// use the router to find all the apis related to the itemSize
app.use('/itemSize',routerItemSize)


// use the router to find all the apis related to the comment
app.use('/toppings', routerTopping)


app.use('/orders', routerOrders)

app.use('/deliveryStatus',routerDeleverySatatus)

// use the router to find all the apis related to the rating
app.use('/payments', routerPayment)


app.use('/Feedback', routerFeedback)





app.listen(5000, () => {
  console.log(`server started on port 5000`)
})
