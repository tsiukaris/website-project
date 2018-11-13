import * as React from 'react';
import {Provider} from 'react-redux';
import AppRouter from "./routers/AppRouter";
import {ConnectedRouter} from "connected-react-router";
// import {ConnectedRouter} from "react-router-redux";
// import {Store} from "redux";


const AppConst = ({store, history}) => (
	<Provider store={store}>
		<ConnectedRouter history={history}>
			<AppRouter/>
		</ConnectedRouter>
	</Provider>
);

export default AppConst;