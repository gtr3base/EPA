import logo from "../img/logo.png";
import "../css/Header.css";

const Header = () => {
	return (
		<header>
			<div>
				<img src={logo} alt="site logo" />
			</div>
			<nav>
				<p>Dashboard</p>
				<p>Event Planner</p>
				<p>Vendor Hub</p>
				<p>Task Manager</p>
			</nav>
			<div></div>
		</header>
	);
};

export default Header;
