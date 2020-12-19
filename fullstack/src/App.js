import React from 'react';
import './App.css';
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom';
import "bootstrap/dist/css/bootstrap.min.css";
import StudentList from './Component/StudentList'
import CreateStudent from './Component/CreateStudent'
import EditStudent from './Component/EditStudent'
function App() {
  return (
    <div className="App">
      <Router>
        <div>
        <nav className="navbar navbar-expand navbar-dark bg-dark">
          <div className="navbar-nav mr-auto">
            <li>
              Team 7 Demo
            </li>
            <li className="nav-item">
              <Link to={"/StudentList"} className="nav-link">
                Students
              </Link>
            </li>
            <li className="nav-item">
              <Link to={"/CreateStudent"} className="nav-link">
                Add 
              </Link>
            </li>
          </div>
        </nav>
        </div>
        <div className="container mt-3">
        <Switch>
          <Route exact path='/CreateStudent' component={CreateStudent} />
          <Route exact path='/StudentList' component={StudentList} />
          <Route path='/students/:id' component={EditStudent} />
        </Switch>
</div>
      </Router>
    </div>
  );
}
export default App;  