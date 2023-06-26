import axios from 'axios'
import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'

export default function AddPeople() {

    let navigate = useNavigate()

    const [order,setPeople] = useState({
        firstname:"",
        lastname:"",
        email:"",
       
    })

    const{firstName,lastName,email}=order

    const onInputChange=(e)=>{
        setPeople({...order,[e.target.name]:e.target.value})
    }

    const onSubmit = async (e)=>{
        e.preventDefault()
        await axios.post("http://localhost:8080/order",order)
        navigate("/")
    }


  return (
    <div className='container'>
        <div className='row'>
            <div className='col-md-6 offset-md-3 border rounded p-4 mt-2 shadow'>
                <h3 className='text-center m-2 p-4'>Register</h3>

                <form onSubmit={(e)=> onSubmit(e)}>

                <div class="mb-3">
                    <select class="form-select" required aria-label="select example">
                    <option value="">Open this select menu</option>
                    <option value="1">iPhone</option>
                    <option value="2">Android</option>
                    <option value="3">Mac</option>
                    <option value="3">Windows</option>
                    </select>
                    <div class="invalid-feedback">Example invalid select feedback</div>
                 </div>

                <div className='mb-3'>
                    <label htmlFor='firstName' className='form-label'>First Name</label>
                    <input
                        type={"text"}
                        className='form-control'
                        placeholder='Enter your first name'
                        name='firstName'
                        value={firstName}
                        onChange={(e)=>onInputChange(e)}
                    />
                </div>

                <div className='mb-3'>
                    <label htmlFor='lastName' className='form-label'>Last Name</label>
                    <input
                        type={"text"}
                        className='form-control'
                        placeholder='Enter your last name'
                        name='lastName'
                        value={lastName}
                        onChange={(e)=>onInputChange(e)}
                    />
                </div>

                <div className='mb-3'>
                    <label htmlFor='email' className='form-label'>Email</label>
                    <input
                        type={"text"}
                        className='form-control'
                        placeholder='Enter your email'
                        name='email'
                        value={email}
                        onChange={(e)=>onInputChange(e)}
                    />
                </div>

                
                <button type='submit' className='btn btn-outline-primary'>Submit</button>
                <Link className='btn btn-outline-danger mx-3' to="/">Cancel</Link>
                </form>

            </div>
        </div>
    </div>
  )
}