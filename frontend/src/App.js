import './App.css';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Navbar from './layout/Navbar';
import Home from './pages/Home';
import { Route, BrowserRouter as Router, Routes } from 'react-router-dom';

import EditPeople from './people/EditPeople';
import AddPeople from './people/AddPeople';

function App() {
  return (
    <div className="App">
      <Router>
        <Navbar/>

        <Routes>
          <Route exact path="/" element={<Home />} />
          <Route exact path="/addpeople" element={<AddPeople />} />
          <Route exact path="/editpeople/:personId" element={<EditPeople />} />
        </Routes>

      </Router>
      
    </div>
  )
  
}

export default App;