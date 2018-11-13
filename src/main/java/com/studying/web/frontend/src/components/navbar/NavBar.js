import React, {Component} from 'react';
import '../style.css'
import logo1 from '../../images/logo1.png';
import {Link} from "react-router-dom";

const NavBar = (props) => {

	return (
		<div>
			<nav id="gradient" className="navbar navbar-expand-lg">
				<div className="container">
					<img id="logo" src={logo1} alt={"Logo.png"}/>
					<div className="navbar-brand">
						<Link to='/'>SmartStuff</Link>
					</div>
					<button className="navbar-toggler border-0" type="button" data-toggle="collapse"
					        data-target="#exCollapsingNavbar">
						&#9776;
					</button>
					<div className="collapse navbar-collapse position-relative" id="exCollapsingNavbar">
						<ul className="nav navbar-nav ml-auto">
							<li className="nav-item">
								<button type="button" className="btn btn-transparent"><Link to="/store"
								                                                            className="nav-link"
								                                                            role="button">Store</Link>
								</button>
							</li>
							<li className="nav-item">
								<button type="button" className="btn btn-transparent"><Link to="/store/cart"
								                                                            className="nav-link"
								                                                            role="button">Your cart</Link>
								</button>
							</li>
							<li className="nav-item">
								<button type="button" className="btn btn-transparent"><Link to="/store/addDbProduct"
								                                                            className="nav-link"
								                                                            role="button">Create product</Link>
								</button>
							</li>
							<li className="nav-item">
								<button type="button" className="btn btn-transparent"><Link to="/customers"
								                                                            className="nav-link"
								                                                            role="button">Customers</Link>
								</button>
							</li>
						</ul>

						<ul className="nav navbar-nav flex-row justify-content-between ml-0">
							<li className="dropdown order-1">
								<button type="button" id="dropdownMenu1" data-toggle="dropdown"
								        className="btn btn-outline-secondary dropdown-toggle text-white">Login <span
									className="caret"/></button>
								<ul className="dropdown-menu dropdown-menu-right mt-2">
									<li className="px-3 py-2 mt-2">
										<form className="form">
											<div className="form-group">
												<input id="emailInput" placeholder="Email"
												       className="form-control form-control-sm" type="text"
												       required=""/>
											</div>
											<div className="form-group">
												<input id="passwordInput" placeholder="Password"
												       className="form-control form-control-sm" type="text"
												       required=""/>
											</div>
											<div className="form-group">
												<button type="submit" className="btn btn-secondary btn-block">Login
												</button>
											</div>
											<div className="form-group">
												<small>
													<Link to="/" id="forgot" data-toggle="modal"
													      data-target="#modalPassword">Forgot password?</Link>
												</small>
											</div>
										</form>
									</li>
								</ul>
							</li>
						</ul>
					</div>
				</div>
			</nav>
			<div id="modalPassword" className="modal fade" tabIndex="-1" role="dialog" aria-labelledby="myModalLabel"
			     aria-hidden="true">
				<div className="modal-dialog">
					<div className="modal-content">
						<div className="modal-header">
							<h3>Forgot password</h3>
							<button type="button" className="close font-weight-light" data-dismiss="modal"
							        aria-hidden="true">?
							</button>
						</div>
						<div className="modal-body">
							<p>Reset your password..</p>
						</div>
						<div className="modal-footer">
							<button className="btn" data-dismiss="modal" aria-hidden="true">Close</button>
							<button className="btn btn-primary">Save changes</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	)

};
export default (NavBar);