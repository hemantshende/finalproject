
import axios from "axios";
import { useEffect, useState } from "react";
import './index.css'
import { URL } from '../../config'
import { useNavigate, useLocation,Link } from "react-router-dom";
import { toast } from "react-toastify";
import Home from '../Home'
import Pizzaimage from '../pizzaimage'

const Addpizzasize = () => {
    const {state} = useLocation()
    const {itemid} = state

    const [itemId , setitemid]= useState("")
    const [size , setsize]= useState("")
    const [price , setprice]= useState("0.0")
    
    const url = 'http://localhost:5000/item/latest'
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
    function addpizzasize ()  {
         if(itemId==="")
        alert("Enter itemid")
        else if(size==="")
        alert("Enter pizza size")
        else if(price==="")
        alert("Enter pizza price")
        else{
            const body = {
                itemId,
                size,
                price,
                
            }
           
           
            const url=`${URL}/itemSize/addItemSize`

            axios.post(url,body).then((response)=> {
                const result = response.data
                console.log(result)
                if(result['status']=='success'){
                    toast.success('pizza size and price Added successfully')
                    navigate('/showallpizza')
                   // reload()
                }else{
                    toast.error(result['error'])
                }
            })
   
           
            
        }
    }
   
 
    return(
        <>
        <Home />
        <div className="outerdiv-emp-form">

        {products.map((product) => {
            return (
              <p>
                <p>enter the id below in item id: {itemid}</p>
                
                
                <ColoredLine color="black" />
                </p>
               

            )
          })}
                <div className="mb-3">
                    <label for="exampleFormControlInput1" className="form-label">Enter item id</label>
                    <br />
                    <input type="text" value={itemId} onChange={(e) => setitemid(e.target.value)}   className="form-control form-control-sm" id="exampleFormControlInput1" placeholder="Enter item id" />
                </div>

                <div className="mb-3">
                    <label for="exampleFormControlInput1" className="form-label">Enter Product size</label>
                    <br />
                    <select className="form-select form-select-sm" onChange={(e) => setsize(e.target.value)} aria-label="Default select example">
                    <option value={setsize}>choose Size</option>
                        <option >Small</option>
                        <option >Regular</option>
                        <option >Large</option>
                        <option value="200ml">200ml</option>
                        <option value="500ml">500ml</option>
                        <option value="750ml">750ml</option>
                    </select>
                    {/* <input type="text" value={size} onChange={(e) => setsize(e.target.value)} className="form-control form-control-sm" id="exampleFormControlInput1" placeholder="Enter pizza size" /> */}
                </div>

                <div className="mb-3">
                    <label for="exampleFormControlInput1" className="form-label">Enter Product price</label>
                    <br />
                    <input type="number" value={price} onChange={(e) => setprice(e.target.value)} className="form-control form-control-sm" id="exampleFormControlInput1" placeholder="Enter pizza price" />
                </div>
               
                <br />
                <button  onClick={addpizzasize} className="btn btn-primary mx-3 ">Add Product size</button>
                    
            </div></>
    
    )

}
export default Addpizzasize;