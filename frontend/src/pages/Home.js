import React, { useEffect, useState } from 'react'
import axios from 'axios'
import { Link, useParams } from 'react-router-dom'

export default function Home() {

  const [people,setPeople] = useState([])

  const {personId}= useParams()

  useEffect(() =>{
    loadPeople()
  }, [])

  const loadPeople = async () =>{
    const result = axios.get("http://localhost:8080/returnpeople")
    setPeople((await result).data)
  }

  const peopleDelete = async (personId)=>{
    await axios.delete(`http://localhost:8080/people/${personId}`)
    loadPeople()
  }

  return (
    <div className='container'>
        <div className='py-4'>
        <table className="table border shadow">
        <thead>
          <tr>
            <th scope="col">ID</th>
            <th scope="col">First Name</th>
            <th scope="col">Last Name</th>
            <th scope="col">Email</th>            
          </tr>
        </thead>
        <tbody>

          {
            people.map((people,index)=>(
            <tr>
              <th scope="row" key={index}>{people.personId}</th>
              <td>{people.firstName}</td>
              <td>{people.lastName}</td>
              <td>{people.email}</td>              
              <td> 
                <Link className='btn btn-outline-primary mx-3' to={"/addorders/" }>Order</Link>             
                <Link className='btn btn-outline-primary mx-3' to={`/editpeople/${people.personId}`}>Edit</Link>
                <button className='btn btn-danger mx-2' onClick={()=> peopleDelete(people.personId)}>Delete</button>
              </td>
            </tr>
            ))
          }
          
        
        </tbody>
</table>
        </div>
    </div>
  )
}