
import axios from "axios";
import { useEffect, useState } from "react";
import './index.css'
import { URL } from '../../config'
import { useNavigate, useLocation,Link } from "react-router-dom";
import { toast } from "react-toastify";
import Home from '../Home'

const Addpizza = () => {
    const [type,settype] = useState("")
    const [itemName , setitemName]= useState("")
    const [description , setdescription]= useState("")
 
    

   
    const navigate=useNavigate()

    function savePizza  ()  {
        if(type==="")
        alert("Enter  type of Product")
        else if(itemName==="")
        alert("Enter the Product name")
        else if(description==="")
        alert("Enter Product description")
       
        else{
            const body = {
                type,
                itemName,
                description,
               
                
            }
            const url = `${URL}/item/addItem`
            
            
            axios.post(url,body).then((response)=> {
                const result = response.data
                console.log(result)
                if(result['status']=='success'){
                    toast.success('Product Added successfully')
                    navigate ('/Addpizzasize')
                 
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
                <div className="mb-3">
                    <label for="exampleFormControlInput1" className="form-label">Enter Product type</label>
                    <br />
                     <select className="form-select form-select-sm" onChange={(e) => settype(e.target.value)} aria-label="Default select example">
                    <option value={settype}>choose Type</option>
                        <option value="veg">Veg</option>
                        <option value="Nonveg">NonVeg</option>
                        <option value="Beverages">Beverages</option>
                    </select>
                     
                     {/* <input type="text" value={type} onChange={(e) => settype(e.target.value)} className="form-control form-control-sm" id="exampleFormControlInput1" placeholder="Enter Product Type" /> */}
                </div> 

                <div className="mb-3">
                    <label for="exampleFormControlInput1" className="form-label">Enter Product name</label>
                    <br />
                    <input type="text" value={itemName} onChange={(e) => setitemName(e.target.value)} className="form-control form-control-sm" id="exampleFormControlInput1" placeholder="Enter Product name" />
                </div>

                <div className="mb-3">
                    <label for="exampleFormControlInput1" className="form-label">Enter Product desription</label>
                    <br />
                    <input type="text" value={description} onChange={(e) => setdescription(e.target.value)} className="form-control form-control-sm " id="exampleFormControlInput1" placeholder="Enter Product desription" />
                </div>

               
                <button type="button" onClick={savePizza} class="btn btn-sm btn-success">Add</button>
                   
            </div></>
    
    )

}
export default Addpizza;