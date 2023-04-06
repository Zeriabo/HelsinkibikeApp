import "./App.css";
import Asemat from "./Pages/Asemat/Asemat";

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
      <Asemat />
    </div>
  );
}

export default App;
