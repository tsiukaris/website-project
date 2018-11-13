import React from 'react';
import App from "../../App";
import '../style.css';
import Toolbar from "../toolbar/Toolbar";
// import Toolbar from "../toolbar/Toolbar";

const Store = (props) => {

		const children = props.children;
		return (
			<App>
				<div className="container">
					<div className="row">
						<Toolbar/>
						{/*<div className="col-3">*/}
							{/*<p>_</p>*/}
						{/*</div>*/}
						<div className="store-content col-9">
							{children}
						</div>
					</div>
				</div>
			</App>
		)
};


export default Store;