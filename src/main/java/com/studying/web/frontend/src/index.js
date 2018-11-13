import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';

import createHashHistory from "history/es/createHashHistory";
import {applyMiddleware, createStore} from "redux";
import {connectRouter, routerMiddleware} from "connected-react-router";
import reducers from "./reducers"
import {composeWithDevTools} from "redux-devtools-extension";
import AppConst from "./AppConst";

// import registerServiceWorker from './registerServiceWorker';
// import AppRouter from "./routers/AppRouter";


const history = createHashHistory();

const store = createStore(
	connectRouter(history)(reducers),
	{},
	composeWithDevTools(
		applyMiddleware(
			routerMiddleware(history))));

ReactDOM.render(<AppConst history={history} store={store}/>, document.getElementById('root'));
// registerServiceWorker();
