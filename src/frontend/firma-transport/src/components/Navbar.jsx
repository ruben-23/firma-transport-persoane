
import React from "react";
import {NavLink, useNavigate} from "react-router-dom";
import PropTypes from "prop-types";

const NavbarFirma = ({ rolUser, schimbaInPersonalFirma, schimbaInPasageri }) => {
  const navigate = useNavigate();

  const handleSchimbareOptiuni  = () => {
    if (rolUser === 'staff') {
      navigate('/');
      schimbaInPasageri();
    } else {
      navigate('/');
      schimbaInPersonalFirma();
    }
  };

    return (
        <div>
          <header>
            <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
              <NavLink className="navbar-brand" to="/">
                Firma Transport Persoane
              </NavLink>
              <div className="collapse navbar-collapse" id="navbarNav">
                <ul className="navbar-nav">

                  {/*afisare butoane diferite in bara de navigare in functie de rolul userului*/}
                  {rolUser === 'pasager' ? (
                      <>
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
                      </>
                  ) : (
                      <>
                        <li className="nav-item">
                          <NavLink className="nav-link" to="/gestionare-orare">
                            Gestionare Orare si Rute
                          </NavLink>
                        </li>
                        <li className="nav-item">
                          <NavLink className="nav-link" to="/gestionare-autobuze">
                            Gestionare Autobuze
                          </NavLink>
                        </li>
                        <li className="nav-item">
                          <NavLink className="nav-link" to="/rapoarte">
                            Rapoarte
                          </NavLink>
                        </li>
                      </>
                  )}
                </ul>

               {/*buton pentru a schimba optiunile din bara de navigare */}
                <ul className="navbar-nav ms-auto">
                  {rolUser === 'pasager' ? (
                      <li className="nav-item">
                        <button className="btn btn-link nav-link" onClick={handleSchimbareOptiuni}>
                          Mergi la Personal Firma
                        </button>
                      </li>
                  ) : (
                      <li className="nav-item">
                        <button className="btn btn-link nav-link" onClick={handleSchimbareOptiuni}>
                          Mergi la Pasageri
                        </button>
                      </li>
                  )}
                </ul>
              </div>
            </nav>
          </header>
        </div>

    );
}

NavbarFirma.propTypes = {
  rolUser:  PropTypes.string.isRequired,
  schimbaInPersonalFirma: PropTypes.func.isRequired,
  schimbaInPasageri: PropTypes.func.isRequired,
};

export default NavbarFirma;