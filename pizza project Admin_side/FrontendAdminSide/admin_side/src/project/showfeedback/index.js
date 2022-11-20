import axios from 'axios'
import { useEffect, useState } from 'react'
import Home from '../Home'

import {URL} from '../../config'


const ProductPage = () => {
  const url = 'http://localhost:5000/Feedback/feedbackList'
  const [products, setProducts] = useState([])

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
                
                {/* <p><b>Name :</b> {product['firstname']}</p> */}
                
                <p><strong>Email Id :</strong> {product['email']}</p>
                 <p><strong>feedback :</strong> {product['feedback']}</p>
  
                <ColoredLine color="black" />
                </p>
               

            )
          })}
      </div>
     
   
    </>
  )
}

export default ProductPage
