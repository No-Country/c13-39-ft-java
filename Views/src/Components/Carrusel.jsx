import React from 'react';
import { Carousel } from 'react-bootstrap';

const Carrusel = () => {
  return (
    <Carousel className="carrusel" fade id="carousel-home">
      
      <Carousel.Item className="carousel-item">
        <img src="/public/carrusel/1.png" alt="foto1" />
       
      </Carousel.Item>

      <Carousel.Item className="carousel-item">
        <img src="/public/carrusel/2.png" alt="foto2" />
       
      </Carousel.Item>

      <Carousel.Item className="carousel-item">
        <img src="/public/carrusel/3.png" alt="foto3" />
       
      </Carousel.Item>
      <Carousel.Item className="carousel-item">
        <img src="/public/carrusel/4.png" alt="foto4" />
       
      </Carousel.Item>


    </Carousel>
  );
};

export default Carrusel;