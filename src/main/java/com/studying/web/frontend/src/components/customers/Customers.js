import React, {Component} from "react";
import axios from 'axios';
import {connect} from 'react-redux';
import '../style.css';
import {Link} from "react-router-dom";
import Store from "../workspace/Store";
import {bindActionCreators} from "redux";
import {objectActions} from "../../reducers/objects";
import App from "../../App";

class Customers extends Component {

	componentDidMount() {

		const UrlRequest = 'http://localhost:8080/api/customers';

		axios.get(UrlRequest)
			.then(response => {
				this.props.objectActions.setError(false);
				this.props.objectActions.setErrorMsg('');
				this.props.objectActions.setCustomers(response.data);
			})
			.catch(error => {
				this.props.objectActions.setError(true);
				this.props.objectActions.setErrorMsg(error.message);
			})
	}

	renderCustomers() {
		return (
			<App>
				<div className="container">
					{
						this.props.customers.map(customer =>
							<div key={customer.id} className="cell col-lg-3 col-md-4 bg-dark border-right border-white rounded">
								<Link to={'/customers/' + customer.id} className = "text-white">
									<p> {customer.firstname} <br/> {customer.lastname} </p>
									<p> {customer.email} <br/> Password: {customer.password} </p>
									<p>Phonenumber: {customer.phonenumber} </p>
								</Link>
							</div>
						)
					}
				</div>
			</App>
		);
	}

	render() {
		if (this.props.error) {
			return (<App><p>Error occured while requesting data: {this.props.errorMsg}</p></App>)
		}
		return this.renderCustomers();
	}
}

const mapStateToProps = state => {
	return {
		customers: state.objects.customers,
		error: state.objects.error,
		errorMsg: state.objects.errorMsg
	}
};

const mapDispatchToProps = dispatch => {
	return {
		objectActions: bindActionCreators(objectActions, dispatch)
	}
};

export default connect(mapStateToProps, mapDispatchToProps)(Customers);