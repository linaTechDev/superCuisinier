import './App.css';
import {Route, Routes} from "react-router-dom";
import PageNotFound from "./components/PageNotFound";
import HomePage from "./components/HomePage";
import PageUtilisateur from "./components/utilisateur/PageUtilisateur";

function App() {
  return (
    <div>
      <h1>Super cuisinier</h1>
      <Routes>
          <Route path="/home" element={<HomePage/>} />
          <Route path="*" element={<PageNotFound/>} />
          <Route path="/" element={<PageUtilisateur/>} />
      </Routes>
    </div>
  );
}

export default App;
