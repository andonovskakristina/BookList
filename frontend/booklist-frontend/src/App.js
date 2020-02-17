import React from 'react';
import logo from './logo.svg';
import './App.css';
import Header from "./components/Header";
import {BrowserRouter as Router, Redirect, Route, Switch} from 'react-router-dom'
import Books from "./components/Books";
import CreateNewBook from "./components/CreateNewBook";
import EditBook from "./components/EditBook";

function App() {
  return (
    <div className="App">
        <Router>
            <Header/>
            <Switch>
                <Route path={"/books/:ISBN/edit"} component={EditBook}/>
                <Route path={"/books"} exact component={Books}/>
                <Route path={"/books/new"} component={CreateNewBook}/>
            </Switch>
        </Router>
    </div>
  );
}

export default App;
