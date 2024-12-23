import './App.css'
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import NavbarFirma from './components/Navbar.jsx'
import OrarRute from './components/OrarRute.jsx';
import Feedback from './components/Feedback.jsx';

function App() {

  return (
    <>
      <BrowserRouter>
        <NavbarFirma />
        <Routes>
          <Route path="/" element={<OrarRute />} />
          <Route path="/orare" element={<OrarRute />} />
          <Route path="/feedback" element={<Feedback />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App
