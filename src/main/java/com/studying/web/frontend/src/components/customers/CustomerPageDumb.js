import React from "react";
import '../style.css';

export const CustomerPageDumb = (props) => {
	return(
		<div className="container single-column">
			<p>Id: {props.customer.id}</p>
			<p>First Name: {props.customer.firstname}</p>
			<p>LastName: {props.customer.lastname}</p>
			<p>Email: {props.customer.email}</p>
			<p>Password: {props.customer.password}</p><br/><br/>
		</div>
	)
};