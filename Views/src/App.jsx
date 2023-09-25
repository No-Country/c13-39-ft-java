import { BrowserRouter, Link, Route, Routes } from 'react-router-dom';
import { useState } from 'react'
import './App.css'
import Home from './Pages/Home'
import Navbar from './Components/navbar'
import SignIn from './Pages/Signin';
import SignUp from './Pages/SignUp';
import Lowbar from './Components/lowbar';
import 'bootstrap/dist/css/bootstrap.min.css';
import Vuelos from './Pages/Vuelos';
import Alojamientos from './Pages/Alojamientos';
import Paquetes from './Pages/Paquetes';
import Turismo from './Pages/Turismo';
import Transporte from './Pages/Transporte';

function App() {
  const [count, setCount] = useState(0)

  return (
    <div>
      <BrowserRouter>
      <Navbar/>
      <Lowbar/>


      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/signIn" element={<SignIn />} />
        <Route path="/signUp" element={<SignUp />} />

        <Route path="/vuelos" element={<Vuelos />} />
        <Route path="/alojamiento" element={<Alojamientos />} />
        <Route path="/transporte" element={<Transporte />} />
        <Route path="/turismo" element={<Turismo />} />
        <Route path="/paquetes" element={<Paquetes />} />

      </Routes>
      </BrowserRouter>
    </div>
  )
}

export default App
