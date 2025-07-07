import logo from "/img/logo.png";
import "../css/Header.css";

const Header = () => {
	return (
		<header>
			<div>
				<img src={logo} alt="site logo" />
			</div>
			<nav>
				<p>
					<button className="btnDashboard">Dashboard</button>
				</p>
				<p>
					<button className="btnEventPlanner">Event Planner</button>
				</p>
				<p>
					<button className="btnVendorHub">Vendor Hub</button>
				</p>
				<p>
					<button className="btnTaskManager">Task Manager</button>
				</p>
			</nav>
			<div></div>
		</header>
	);
};

export default Header;
