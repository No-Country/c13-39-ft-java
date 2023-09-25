import React from "react";
import { Link } from "react-router-dom";

function Card ({destino}) {
  
  return (
    <div className="col">
      <div className="card shadow-sm">
        {/* <img
          width="100%"
          src={destino.image}
          alt="Img destino"
        /> */}
        {/* <h3 className="m-2 text-center text-dark">{destino.name}</h3> */}
        <div className="card-body">
          <p className="card-text">
           Acá va la descripción.
          </p>
          <div className="d-flex justify-content-between align-items-center">
            <div className="btn-group">
              <button
                type="button"
                className="btn btn-sm btn-outline-secondary"
              >
                <Link to={`/`} className="nav-link px-2 text-secondary">Detalle</Link>
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}


export default Card