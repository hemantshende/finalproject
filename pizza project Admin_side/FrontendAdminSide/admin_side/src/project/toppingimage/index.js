
import Home from '../Home'
import axios from 'axios';
 
import React,{Component, useState} from 'react';
import { useLocation,state, useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';
 

const UploadToppingImg=(props)=> {
    const {state} = useLocation()
    const {itemId} = state
    const navigate =useNavigate()
    
      // Initially, no file is selected
    const[selectedFile,setSelectedFile] = useState()

    
    // On file select (from the pop up)
    const onFileChange = (event) => {
    
      // Update the state
      const img = ( event.target.files[0]) ;
      setSelectedFile(img)
    
    };
    
    // On file upload (click the upload button)
    const onFileUpload = () => {
        
      // Create an object of formData
      const formData = new FormData();
    
      // Update the formData object
      formData.append(
        "data",
        selectedFile,
        //selectedFile.name,
        
      );
    
      // Details of the uploaded file
      console.log(selectedFile);
    
      // Request made to the backend api
      // Send formData object
   
      var url=`http://localhost:8080/toppingImages/add/${itemId}`
      axios.post(url, formData);
     toast.success('image added')
     navigate('/addpizzasize')
    };
    
    // File content to be displayed after
    // file upload is complete
//    const fileData = () => {
    
//       if (selectedFile) {
        
         
//         return (
//           <div>
//             <h2>File Details:</h2>
             
// <p>File Name: {selectedFile.name}</p>
 
             
// <p>File Type: {selectedFile.type}</p>
 
             
// <p>
//               Last Modified:{" "}
//               {selectedFile.lastModifiedDate.toDateString()}

//             </p>
           
//           </div>
          
//         );
//       } else {
//         return (
//           <div>
//             <br />
//             <h4>Choose before Pressing the Upload button</h4>
//           </div>
//         );
//       }
//     };
// (event)=>setSelectedFile(event.target.files['0'])

    
      return (
          <><div>
              <Home />
          </div><div className="outerdiv-emp-form">

                  <div>
                      <input type="file" onChange={onFileChange} />
                      <button onClick={onFileUpload}>
                          Upload
                      </button>
                  </div>
                  {/* {fileData()} */}
              </div></>
      );
    }
  

 
  export default UploadToppingImg;