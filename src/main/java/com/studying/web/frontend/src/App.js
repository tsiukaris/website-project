import React from 'react';
import './components/style.css';
import NavBar from "./components/navbar/NavBar";
// import DataService from "./services/DataService";
// import AppRouter from "./routers/AppRouter";

const App = (props) => {

	const children = props.children;
	return (
		<div className="App">
			<NavBar/>
			{children}
		</div>
	);
}

export default App
