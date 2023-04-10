import "./App.css";
import Asemat from "./Pages/Asemat/Asemat";
import Jouneys from "./Pages/Journeys";
import Home from "./Layouts/Main";
import {
  BrowserRouter as Router,
  Route,
  Routes,
  Switch,
} from "react-router-dom";
import Asema from "./Pages/AsemaPage/AsemaPage";
import AsematList from "./Components/AsematList";
function App() {
  return (
    <div className="App">
      <header className="App-header">
        <p>Helsinki bike app</p>
      </header>
      <Router>
        <Routes>
          <Route path="/" element={<Home />}></Route>
          <Route path="/asemat" element={<AsematList />}></Route>
          <Route path="/asema" element={<Asema />}></Route>
          <Route path="/journeys" element={<Jouneys />}></Route>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
