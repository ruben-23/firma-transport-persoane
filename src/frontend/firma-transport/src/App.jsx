import './App.css'
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import NavbarFirma from './components/Navbar.jsx'
import OrarRute from './components/OrarRute.jsx';
import Feedback from './components/Feedback.jsx';
import {useState} from "react";
import InformatiiFirma from "./components/InformatiiFirma.jsx";
import GestionareOrareRute from "./components/GestionareOrareRute.jsx";

function App() {
  const [rolUser, setRolUser] = useState('pasager');

  const schimbaInPersonalFirma = () => {
    setRolUser('staff');
  };

  const schimbaInPasageri = () => {
    setRolUser('pasager');
  };


  return (

      <BrowserRouter>
        <NavbarFirma
            rolUser={rolUser}
            schimbaInPersonalFirma={schimbaInPersonalFirma}
            schimbaInPasageri={schimbaInPasageri}
        />
        <div className="app">
          <Routes>
            <Route path="/" element={<InformatiiFirma/>}/>
            <Route path="/orare" element={<OrarRute/>}/>
            <Route path="/feedback" element={<Feedback/>}/>
            <Route path="/gestionare-orare" element={<GestionareOrareRute/>}/>
            {/*<Route path="/gestionare-autobuze" element={<GestionareAutobuze />} />*/}
            {/*<Route path="/rapoarte" element={<Rapoarte />} />*/}
          </Routes></div>
      </BrowserRouter>

)
  ;
}

export default App
