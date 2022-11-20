import axios from 'axios'
import { useEffect, useState } from 'react'
import Home from '../Home'

import {URL} from '../../config'
import { useNavigate } from 'react-router-dom'


const ProductPage = () => {
  const url = 'http://localhost:5000/toppings/toppingList'
  const [products, setProducts] = useState([])

  const navigate=useNavigate()

  useEffect(() => {
    getProducts()
  }, [])

  const getProducts = () => {
    axios.get(url).then((response) => {
      const result = response.data
      if (result['status'] == 'success') {
        setProducts(result['data'])
        //  var person = result['data'];

        // localStorage.setItem('person', JSON.stringify(person)); //stringify object and store
        // var retrievedPerson = JSON.parse(localStorage.getItem('person')); //retrieve the object
        // localStorage.removeItem("person")

      }
    })
  }
 
  function deletetopping(toppingId){
    const url =`${URL}/toppings/delete/${toppingId}`
    axios.delete(url).then((response)=>{
      window.location.reload(false);
  
    })
  }

  const ColoredLine = ({ color }) => (
    <hr
        style={{
            color: color,
            backgroundColor: color,
            height: 3
        }}
    />
);

  return (
      <>
            <Home />
      
        <div className="outerdiv-emp-form">
          
          {products.map((product) => {
            return (
              <p>
                  <p><strong>Topping Name  :</strong> {product['toppingName']}</p>
                 <p><strong>Topping Price :</strong> {product['price']}</p>
                 
                <div className='update'>
              
              <button type="button" onClick={()=>(navigate('/edittoppings',{state:{toppingId:product['toppingId']}}))} class="btn btn-sm btn-success">Update</button>   
              <button onClick={()=>deletetopping(product['toppingId'])} class="btn btn-danger mx-3">delete</button>        
              {/* <button onClick={()=>deletesize(product['itemId'])} class="btn btn-danger mx-3">delete</button> */}
              </div>
  
                <ColoredLine color="black" />
                </p>
               

            )
          })}
      </div>
     
   
    </>
  )
}

export default ProductPage
