// import axios from 'axios'
// import React, { useState } from 'react'
// import { Link, useNavigate } from 'react-router-dom'

// export default function AddOrders() {

//     let navigate = useNavigate()

//     const [order,setOrder] = useState({
//         firstname:"",
//         lastname:"",
//         email:"",
       
//     })

//     const{firstName,lastName,email}=order

//     const onInputChange=(e)=>{
//         setPeople({...order,[e.target.name]:e.target.value})
//     }

//     const onSubmit = async (e)=>{
//         e.preventDefault()
//         await axios.post("http://localhost:8080/order",order)
//         navigate("/")
//     }


//   return (
//     <div className='container'>
//         <div className='row'>
//             <div className='col-md-6 offset-md-3 border rounded p-4 mt-2 shadow'>
//                 <h3 className='text-center m-2 p-4'>Register</h3>

//                 <form onSubmit={(e)=> onSubmit(e)}>

//                 <div class="mb-3">
//                     <select class="form-select" required aria-label="select example">
//                     <option value="">Open this select menu</option>
//                     <option value="1">iPhone</option>
//                     <option value="2">Android</option>
//                     <option value="3">Mac</option>
//                     <option value="3">Windows</option>
//                     </select>
//                     <div class="invalid-feedback">Example invalid select feedback</div>
//                  </div>

               

//                 <div className='mb-3'>
//                     <label htmlFor='email' className='form-label'>Email</label>
//                     <input
//                         type={"text"}
//                         className='form-control'
//                         placeholder='Enter your email'
//                         name='email'
//                         value={email}
//                         onChange={(e)=>onInputChange(e)}
//                     />
//                 </div>

//                 item.map((name,index)=>(
//                     <select class="form-select" multiple aria-label="multiple select example">
//                     <option selected>Open this select menu</option>
//                     <option value="1">One</option>
//                     <option value="2">Two</option>
//                     <option value="3">Three</option>
//                     </select>
//                  ))
                
                
//                 <button type='submit' className='btn btn-outline-primary'>Submit</button>
//                 <Link className='btn btn-outline-danger mx-3' to="/">Cancel</Link>
//                 </form>

//             </div>
//         </div>
//     </div>
//   )
// }


import React, { useState, useEffect } from 'react';
import axios from 'axios';

const App = () => {
  const [products, setProducts] = useState([]);
  const [selectedProducts, setSelectedProducts] = useState([]);

  useEffect(() => {
    fetchProducts();
  }, []);

  const fetchProducts = async () => {
    try {
      const response = await axios.get('/items'); // Replace this with your backend API endpoint to fetch products
      setProducts(response.data);
    } catch (error) {
      console.error('Error fetching products:', error);
    }
  };

  const handleProductSelect = (product) => {
    setSelectedProducts((prevSelected) => [...prevSelected, product]);
  };

  const handleOrderCreate = () => {
    // Replace this with your backend API call to create a new order with selectedProducts
    console.log('Selected products:', selectedProducts);
    // Reset the selectedProducts state after creating the order if necessary
    setSelectedProducts([]);
  };

  return (
    <div className="container mt-5">
      <h1>Product Cart</h1>
      <div className="row">
        <div className="col-md-6">
          <h2>Products</h2>
          <ul className="list-group">
            {products.map((product) => (
              <li
                key={product.id}
                className="list-group-item d-flex justify-content-between align-items-center"
                onClick={() => handleProductSelect(product)}
              >
                {product.name} 
                <span className="badge bg-primary rounded-pill">Select</span>
              </li>
            ))}
          </ul>
        </div>
        <div className="col-md-6">
          <h2>Selected Products</h2>
          <ul className="list-group">
            {selectedProducts.map((product) => (
              <li
                key={product.id}
                className="list-group-item d-flex justify-content-between align-items-center"
              >
                {product.name} - ${product.price}
              </li>
            ))}
          </ul>
          <button
            className="btn btn-primary mt-3"
            onClick={handleOrderCreate}
            disabled={selectedProducts.length === 0}
          >
            Create Order
          </button>
        </div>
      </div>
    </div>
  );
};

export default App;

