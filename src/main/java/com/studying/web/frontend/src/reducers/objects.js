export const SAVE_ALL = 'SAVE_ALL';
export const SAVE_PRODUCT = 'SAVE_PRODUCT';
export const ADD_TO_CART = 'ADD_TO_CART';
export const SET_CUSTOMERS = 'SET_CUSTOMERS';
export const SET_CUSTOMER = 'SET_CUSTOMER';

export const SET_ERROR = 'SET_ERROR';
export const SET_ERRORMSG = 'SET_ERRORMSG';

const init = {
	products: [],
	actualProduct: {},
	customers: [],
	actualCustomer: {},
	cart: [],
	error: false,
	errorMsg: ''
};

const reducer = (state = init, action) => {
	if (action === undefined) return state;
	switch (action.type) {
		case SAVE_ALL: {
			return {...state, products: action.payload};
		}
		case SAVE_PRODUCT: {
			return {...state, actualProduct: action.payload};
		}
		case ADD_TO_CART: {
			return {...state, cart: [...state.cart, ...action.payload]};
		}
		case SET_CUSTOMERS: {
			return {...state, customers: action.payload};
		}
		case SET_CUSTOMER: {
			return {...state, actualCustomer: action.payload};
		}
		case SET_ERROR: {
			return {...state, error: action.payload};
		}
		case SET_ERRORMSG: {
			return {...state, errorMsg: action.payload};
		}

		default: {
			return state;
		}
	}
};

const actions = {
	saveAll: prods => {
		return {
			type: SAVE_ALL,
			payload: prods
		}
	},
	saveProduct: actualProduct => {
		return {
			type: SAVE_PRODUCT,
			payload: actualProduct
		}
	},
	setCustomers: customers => {
		return {
			type: SET_CUSTOMERS,
			payload: customers
		}
	},
	setActualCustomer: customer => {
		return {
			type: SET_CUSTOMER,
			payload: customer
		}
	},
	setError: error => {
		return {
			type: SET_ERROR,
			payload: error
		}
	},
	setErrorMsg: errorMsg => {
		return {
			type: SET_ERRORMSG,
			payload: errorMsg
		}
	},
	addToCart: product => {
		return {
			type: ADD_TO_CART,
			payload: product
		}
	}
};

export {
	reducer as objects,
	actions as objectActions
}
