import logo from "/img/logo.png";
import { NavLink } from "react-router";
import "../css/Header.css";

const Header = () => {
	return (
		<header>
			<div>
				<img src={logo} alt="site logo" />
			</div>
			<nav>
				<p>
					<NavLink className="btnDashboard" to="/">
						Dashboard
					</NavLink>
				</p>
				<p>
					<NavLink className="btnEventPlanner" to="/events">
						Event Planner
					</NavLink>
				</p>
				<p>
					<NavLink className="btnVendorHub" to="/vendors">
						Vendor Hub
					</NavLink>
				</p>
				<p>
					<NavLink className="btnTaskManager" to="/tasks">
						Task Manager
					</NavLink>
				</p>
			</nav>
			<div></div>
		</header>
	);
};

export default Header;
