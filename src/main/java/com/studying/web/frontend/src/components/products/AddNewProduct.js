import React, {Component} from "react"
import Store from "../workspace/Store";
import axios from "axios";
import {connect} from "react-redux";
import {bindActionCreators} from "redux";
import {objectActions} from "../../reducers/objects";

class AddNewProduct extends Component {

	constructor(){
		super();
		this.state = {
			name: '',
			category: '',
			description: '',
			price: 0,
			quantity: 0
		}
	}

	handleProdName(event) {
		this.setState({ name: event.target.value })
	}

	handleCategory(event) {
		this.setState({ category: event.target.value })
	}

	handleDescription(event) {
		this.setState({ description: event.target.value })
	}

	handlePrice(event) {
		this.setState({ price: event.target.value })
	}

	handleQuantity(event) {
		this.setState({ quantity: event.target.value })
	}


	postProductHandler = () => {
		axios.post('http://localhost:8080/api/store/addDbProduct', this.state)
			.then(() => {
				this.props.objectActions.setError(false);
				this.props.objectActions.setErrorMsg('');
				this.props.history.push('/store');
			})
			.catch(error => {
				console.log(error);
				this.props.objectActions.setError(true);
				this.props.objectActions.setErrorMsg(error.message);
			})
	};


	render() {
		return (
			<Store>
				<p>Add new product to the DB:</p><br/><br/>
				<div className="single-column">
					<p>Name:</p>
					<p>Category:</p>
					<p>Description:</p>
					<p>Price (number):</p>
					<p>Quantity (number):</p>
				</div>
				<div>
					<input type="text" required onChange={(event) => this.handleProdName(event)}/><br/>
					<input type="text" required onChange={(event) => this.handleCategory(event)}/><br/>
					<input type="text" required onChange={(event) => this.handleDescription(event)}/><br/>
					<input type="text" required onChange={(event) => this.handlePrice(event)}/><br/>
					<input type="text" required onChange={(event) => this.handleQuantity(event)}/><br/><br/>
				</div>
				<button className="btn btn-primary" onClick={this.postProductHandler}>
					Create product
				</button>
				<p>{this.props.error ? this.props.errorMsg : ""}</p>
			</Store>
		)
	}
}

const mapStateToProps = state => {
	return {
		error: state.objects.error,
		errorMsg: state.objects.errorMsg
	}
};

const mapDispatchToProps = dispatch => {
	return {
		objectActions: bindActionCreators(objectActions, dispatch)
	}
};

export default connect(mapStateToProps, mapDispatchToProps)(AddNewProduct);
