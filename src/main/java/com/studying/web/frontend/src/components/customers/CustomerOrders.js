import React from "react";
import '../style.css';

export const CustomerOrders = (props) => {

	return(
		props.order.orderedProductList.map(ordProduct =>
			<div className="cell col-lg-4 col-md-3 bg-dark text-white text-left border-right border-white rounded">
				<p>Order ID: {props.order.id}</p>
				<p>Date: {props.order.localDateTime}</p>
				<p>Product: {ordProduct.product.name}</p>
				<p>Quantity: {ordProduct.quantity}</p>
				<p>Price: {ordProduct.product.price}</p>
			</div>
		)
	)
};