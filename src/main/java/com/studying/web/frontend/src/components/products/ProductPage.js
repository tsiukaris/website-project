import React, {Component} from 'react'
import axios from "axios";
import Store from "../workspace/Store";
import '../style.css';
import {bindActionCreators} from "redux";
import {objectActions} from "../../reducers/objects";
import {connect} from "react-redux";

class ProductPage extends Component {

	componentDidMount() {

		const id = this.props.match.params.id;
		const UrlRequest = 'http://localhost:8080/api/store/' + id;

		axios.get(UrlRequest)
			.then( response => {
				this.props.objectActions.setError(false);
				this.props.objectActions.setErrorMsg('');
				this.props.objectActions.saveProduct(response.data);
			})
			.catch(error => {
				this.props.objectActions.setError(true);
				this.props.objectActions.setErrorMsg(error.message);
			})
	}

	handlePurchase = () => {
		this.props.objectActions.addToCart([ this.props.actualProduct ]);
	};

	render() {
		if(this.props.error) {
			return <p>Error occured while requesting data: {this.props.errorMsg}</p>
		}
		const product = this.props.actualProduct;

		return (
			<Store>
				<p>Name: {product.name}</p>
				<p>Category: {product.category}</p>
				<p>Description: {product.description}</p>
				<p>Price: {product.price}</p>
				<p>Quantity: {product.quantity}</p><br/><br/>
				<button className="btn btn-primary" onClick={this.handlePurchase}>Add to cart</button>
			</Store>
		);
	}
}

const mapStateToProps = state => {
	return {
		actualProduct: state.objects.actualProduct,
		error: state.objects.error,
		errorMsg: state.objects.errorMsg
	}
};

const mapDispatchToProps = dispatch => {
	return {
		objectActions: bindActionCreators(objectActions, dispatch)
	}
};

export default connect(mapStateToProps, mapDispatchToProps)(ProductPage);