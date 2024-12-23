
import React from "react";
import { NavLink } from "react-router-dom";

const NavbarFirma = () => {
    return (
      <div>
        <header>
          <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
            <a className="navbar-brand" href="/">
              Firma Transport Persoane
            </a>
            <div className="collapse navbar-collapse" id="navbarNav">
              <ul className="navbar-nav">
                <li className="nav-item">
                  <NavLink className="nav-link" to="/orare">
                    Orare si Rute
                  </NavLink>
                </li>
                <li className="nav-item">
                  <NavLink className="nav-link" to="/feedback">
                    Feedback
                  </NavLink>
                </li>
              </ul>
            </div>
          </nav>
        </header>
      </div>
    );
} 

export default NavbarFirma;