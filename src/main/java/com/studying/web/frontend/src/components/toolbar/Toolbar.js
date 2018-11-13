import React from 'react';
import {Link} from "react-router-dom";
import smartIcon from "../../images/smartphone-icon.png";
import laptopIcon from "../../images/laptop-icon.png";
import otherIcon from "../../images/more.png";

const Toolbar = () => {
	return (
		<div className="category-navigation col-3">
			<Link to="/store/smartphones" className="row categories">
				<img src={smartIcon} className="category-icons" alt="SmartIcon"/>
				<span className="float-center">Smartphones</span>
			</Link>
			<Link to="/store/laptops" className="row categories">
				<img src={laptopIcon} className="category-icons" alt="LaptopIcon"/>
				<span className="float-center">Laptops</span>
			</Link>
			<Link to="/store/other" className="row categories">
				<img src={otherIcon} className="category-icons" alt="Other"/>
				<span className="float-center">Other stuff</span>
			</Link>
		</div>
	)
};

export default Toolbar
