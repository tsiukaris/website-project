import React from 'react';
import {Link} from "react-router-dom";
import App from "../../App";
import '../style.css';

const Home = () => {
	return (
		<App>
			<div className="container text-center">
				<button className="btn btn-outline-success visit-btn">
					<Link to="/store">GO TO STORE!</Link>
				</button>
			</div>
		</App>
	)
};

export default (Home);