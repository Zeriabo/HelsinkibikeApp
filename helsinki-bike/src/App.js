import "./App.css";
import Asemat from "./Pages/Asemat/Asemat";
import {
  BrowserRouter as Router,
  Route,
  Routes,
  Switch,
} from "react-router-dom";
import Asema from "./Pages/AsemaPage/AsemaPage";
function App() {
  // fetch("http://localhost:8080/asema/")
  //   .then((response) => response.json())
  //   .then((data) => console.log(data))
  //   .catch((err) => {
  //     console.log(err);
  //   });
  return (
    <div className="App">
      <header className="App-header">
        <p>Helsinki bike app</p>
      </header>
      <Router>
        <Routes>
          <Route path="/" element={<Asemat />}></Route>
          <Route path="/asema" element={<Asema />}></Route>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
