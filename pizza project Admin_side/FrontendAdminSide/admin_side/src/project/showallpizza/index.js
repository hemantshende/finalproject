import axios from 'axios'
import { useEffect, useState } from 'react'
import Home from '../Home'
import './index.css'
import {URL} from '../../config'
import { Navigate, useLocation, useNavigate } from 'react-router-dom'


const ProductPage = () => {
  const url = 'http://localhost:5000/item/itemList'
  const [products, setProducts] = useState([])
const navigate=useNavigate()

const location = useLocation();
  console.log(location);

  useEffect(() => {
    getProducts()
  }, [],[location])

  const getProducts = () => {
    axios.get(url).then((response) => {
      const result = response.data
      console.log(result)
      if (result['status'] == 'success') {
        setProducts(result['data'])
      }
    })
  }
  const edit = ()=>{
    navigate('/editpizza')
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
function deletesize(itemid){
  const url =`${URL}/item/deleteAll/${itemid}`
  axios.delete(url).then((response)=>{
    window.location.reload(false);

  })
}

  return (
      <>
            <Home />
      
        <div className="outerdiv-emp-form">
          
          {products.map((product) => {
            return (
              <p>
                
                <p><b>ID :</b> {product['itemid']}</p>
                
                <p><strong>Product Type :</strong> {product['type']}</p>
                 <p><strong>Product Name :</strong> {product['itemName']}</p>
                <p><strong>Description :</strong> {product['description']}</p>
             
                <div className='update'>
              
                <button type="button" onClick={()=>(navigate('/editpizza',{state:{itemId:product['itemid']}}))} class="btn btn-sm btn-success">Update</button>           
                {/* <button type="button" onClick={()=>deletesize(product['itemid'])} class="btn btn-danger mx-3">delete</button> */}
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
