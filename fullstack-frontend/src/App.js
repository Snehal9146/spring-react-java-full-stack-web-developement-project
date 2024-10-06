import "./App.css";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import NavBar from "./LayOut/NavBar";
import HomePage from "./Pages/HomePage";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import AddUser from "./Users/AddUser";
import EditUser from "./Users/EditUser";
import ViewUser from "./Users/ViewUser";

function App() {
  return (
    <div className="App">
      <Router>
        <NavBar />

        <Routes>
        <Route exact path="/" element={<HomePage />}/>
        <Route exact path="/adduser" element={<AddUser />}/>
        <Route exact path="/edituser/:id" element={< EditUser />}/>
        <Route exact path="/viewUser/:id" element={<ViewUser />}/>
       
        </Routes>
       
      </Router>
    </div>
  );
}

export default App;
