const mysql = require('mysql')
//const mysql2 = require('mysql2/promise')

const openConnection = () => {
  const connection = mysql.createConnection({
    port: 3306,
    host: 'localhost',
    user: 'root',
    password: 'Mysql@95',
    database: 'pizzafinal',
  })

  connection.connect()

  return connection
}

const openConnection2 = async () => {
  const connection = await mysql2.createConnection({
    port: 3306,
    host: 'localhost',
    user: 'root',
    password: 'ysql@95',
    database: 'pizzafinal',
  })

  return connection
}

module.exports = {
  openConnection,
  openConnection2,
}
