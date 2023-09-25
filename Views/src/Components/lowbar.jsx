import React from 'react'
import Nav from 'react-bootstrap/Nav';

// function Lowbar() {
//   return (
//     <div className="Navbar-Container" class="bg-zinc-300 text-zinc-900">
//       <div className="Navbar-Bottom" class="flex justify-around h-20 items-center pb-4">
//         <div className="Navbar-Bottom__One">Pestaña 01</div>
//         <div className="Navbar-Bottom__Two">Pestaña 02</div>
//         <div className="Navbar-Bottom__Three">Pestaña 03</div>
//         <div className="Navbar-Bottom__Four">Pestaña 04</div>
//       </div>
//     </div>
//   )
// }



function Lowbar() {
  return (
    <Nav className="lowbar" variant="underline" defaultActiveKey="/home">
      <Nav.Item>
        <Nav.Link href="/vuelos">VUELOS</Nav.Link>
      </Nav.Item>

      <Nav.Item>
        <Nav.Link href="/alojamiento">ALOJAMIENTO</Nav.Link>
      </Nav.Item>

      <Nav.Item>
        <Nav.Link href="/transporte">TRANSPORTE</Nav.Link>
      </Nav.Item>

      <Nav.Item>
        <Nav.Link href="/turismo">TURISMO</Nav.Link>
      </Nav.Item>

      <Nav.Item>
        <Nav.Link href="/paquetes">PAQUETES</Nav.Link>
      </Nav.Item>

    </Nav>
  );
}


export default Lowbar