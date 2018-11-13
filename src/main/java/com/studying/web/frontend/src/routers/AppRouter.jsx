import React from 'react';
import {BrowserRouter, HashRouter} from "react-router-dom";
import {Route, Switch} from "react-router";
import Home from "../components/homepage/Home";
import ProductPage from "../components/products/ProductPage";
import ProductList from "../components/products/ProductList";
import AddNewProduct from "../components/products/AddNewProduct"
import Cart from "../components/customers/CustomerCart";
import Customers from "../components/customers/Customers";
import CustomerPage from "../components/customers/CustomerPage";

const AppRouter = () => {

	return (
		<BrowserRouter>
			<Switch>
				<Route exact path="/" component={Home}/>
				<Route exact path="/store" component={ProductList}/>
				<Route exact path="/store/cart" component={Cart}/>
				<Route exact path="/store/addDbProduct" component={AddNewProduct}/>
				<Route exact path="/customers" component={Customers}/>
				<Route path="/customers/:id" component={CustomerPage}/>
				<Route path="/store/:id" component={ProductPage}/>
			</Switch>
		</BrowserRouter>
	)
};



export default AppRouter;