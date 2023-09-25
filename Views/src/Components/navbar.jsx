import React from 'react'
import { BrowserRouter, Link, Route, Routes } from 'react-router-dom';
import Container from 'react-bootstrap/Container';
import Navbar from 'react-bootstrap/Navbar';


function TextLinkExample() {
  return (
    <Navbar className="bg-body-tertiary">
            <Link
        to="/"
        className="link-logo"
        aria-label="Wanderlust Travel"
      ><img src="/public/logotexto.png" alt='Wanderlust Travel' />
      </Link>
      <Container>


        <Navbar.Toggle />
        <Navbar.Collapse className="justify-content-end">
          <Navbar.Text className="usuario-logueado">
            Hola de nuevo: <a href="#login">Juan Pérez</a>
          </Navbar.Text>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}

export default TextLinkExample;