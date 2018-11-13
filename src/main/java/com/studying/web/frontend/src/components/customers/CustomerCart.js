import React, {Component} from 'react'
import App from "../../App";
import axios from "axios";
import '../style.css';
import {bindActionCreators} from "redux";
import {objectActions} from "../../reducers/objects";
import {connect} from "react-redux";

class Cart extends Component {
	constructor(){
		super();
		this.state ={
			customerId: 0
		}
	}

	handleClick = () => {
		const requestMap = {};
			this.props.cart.map(product => { requestMap[product.id] = 1 }); //1 is quantity of product
		//server get request for new order in java.util.Map representation where
		// field of json obj is an id of product and the value is quantity
		const UrlRequest = 'http://localhost:8080/api/newOrder/' + this.state.customerId;

		axios.post(UrlRequest, requestMap)
			.then( () => { this.props.history.push('/customers/' + this.state.customerId); })
			.catch(error => {
				this.props.objectActions.setError(true);
				this.props.objectActions.setErrorMsg(error.message);
			});
	};

	handleCustomerId(event) {
		this.setState({ customerId: event.target.value })
	}

	render() {
		const cart = this.props.cart;
		return (
			<App>
				<div className="container">
					<p>Type customer ID (int):</p><br/>
					<input type="text" required onChange={this.handleCustomerId.bind(this)}/> <br/><br/><br/><br/>
					{ cart.map(product =>
							<div key={ product.id } className="text-center">
								<p>Name: { product.name }</p>
								<p>Category: { product.category }</p>
								<p>Description: { product.description }</p>
								<p>Price: { product.price }</p>
								<p>Quantity: { product.quantity }</p><br/><br/>
							</div>)
					}
					<button className="btn btn-primary" onClick={this.handleClick}>Purchase (post order)
					</button>
					<p>DO NOT REFRESH PAGE!</p>
				</div>
			</App>
		)
	}
}


const mapStateToProps = state => {
	return {
		cart: state.objects.cart,
	}
};

const mapDispatchToProps = dispatch => {
	return {
		objectActions: bindActionCreators(objectActions, dispatch)
	}
};

export default connect(mapStateToProps, mapDispatchToProps)(Cart);