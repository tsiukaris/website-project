import React, {Component} from "react";
import axios from 'axios';
import {connect} from 'react-redux';
import '../style.css';
import Store from "../workspace/Store";
import {bindActionCreators} from "redux";
import {objectActions} from "../../reducers/objects";
import {CustomerOrders} from "./CustomerOrders";
import {CustomerPageDumb} from "./CustomerPageDumb";
import * as _ from 'lodash';
import App from "../../App";

class CustomerPage extends Component {

	constructor() {
		super();

		this.state = {
			shown: false,
		}
	}

	componentDidMount() {

		const id = this.props.match.params.id;
		const UrlRequest = 'http://localhost:8080/api/customers/' + id;
		axios.get(UrlRequest)
			.then(response => {
				this.props.objectActions.setError(false);
				this.props.objectActions.setErrorMsg('');
				this.props.objectActions.setActualCustomer(response.data);
			})
			.catch(error => {
				this.props.objectActions.setError(true);
				this.props.objectActions.setErrorMsg(error.message);
			})
	}

	loadOrders(){
		return _.map(this.props.actualCustomer.orders,
				order => <CustomerOrders order={order}/> );
	};

	handleShowOrders(){
		this.setState({ shown: true });
	};

	render() {
		if (this.props.error) {
			return <p>Error occured while requesting data: {this.props.errorMsg}</p>
		}

		let shown = {
			display: this.state.shown ? "block" : "none",
		};

		let orders = (<div style={ shown }>{this.loadOrders()}</div>);
		const customer = this.props.actualCustomer;
		return (
			<App>
				<div className="container">
					<CustomerPageDumb customer={customer}/>
					<div>
						<button className="btn btn-primary" onClick={this.handleShowOrders.bind(this)}>Show orders</button><br/><br/>
						{orders}
					</div>
				</div>
			</App>
		);
	}
}

const mapStateToProps = state => {
	return {
		actualCustomer: state.objects.actualCustomer,
		error: state.objects.error,
		errorMsg: state.objects.errorMsg
	}
};

const mapDispatchToProps = dispatch => {
	return {
		objectActions: bindActionCreators(objectActions, dispatch)
	}
};

export default connect(mapStateToProps, mapDispatchToProps)(CustomerPage);