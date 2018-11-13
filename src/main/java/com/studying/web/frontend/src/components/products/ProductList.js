import React, {Component} from "react";
import axios from 'axios';
import {connect} from 'react-redux';
import '../style.css';
import {Link} from "react-router-dom";
import Store from "../workspace/Store";
import {bindActionCreators} from "redux";
import {objectActions} from "../../reducers/objects";

class ProductList extends Component {

	componentDidMount() {

		const UrlRequest = 'http://localhost:8080/api/store';

		axios.get(UrlRequest)
			.then(response => {
				this.props.objectActions.setError(false);
				this.props.objectActions.setErrorMsg('');
				this.props.objectActions.saveAll(response.data);
			})
			.catch(error => {
				this.props.objectActions.setError(true);
				this.props.objectActions.setErrorMsg(error.message);
			})
	}

	renderProducts() {
		return (
			<Store>
				{
					this.props.products.map(product =>
						<div key={product.id} className="cell col-lg-3 col-md-4 bg-dark border-right border-white rounded">
							<Link to={'/store/' + product.id} className="text-white">
								{/*<img src={require("./../images/" + product.name + "-icon.jpg")} className="product-icon"*/}
								{/*alt="product icon"/>*/}
								<p> {product.name} <br/> Price: {product.price} RUB </p>
								<p> {product.category} <br/> Price: {product.quantity} RUB </p>
							</Link>
						</div>
					)
				}
			</Store>
		);
	}

	render() {
		if (this.props.error) {
			return (<Store><p>Error occured while requesting data: {this.props.errorMsg}</p></Store>)
		}
		return this.renderProducts();
	}
}

const mapStateToProps = state => {
	return {
		products: state.objects.products,
		error: state.objects.error,
		errorMsg: state.objects.errorMsg
	}
};

const mapDispatchToProps = dispatch => {
	return {
		objectActions: bindActionCreators(objectActions, dispatch)
	}
};

export default connect(mapStateToProps, mapDispatchToProps)(ProductList);