import { Routes, Route } from "react-router";
import "../css/App.css";
import Events from "./Events.jsx";

const App = () => {
	return (
		<div className="App">
			<Routes>
				<Route path="/" element={<Events />} />
				<Route path="events" element={<Events />} />
				<Route path="vendors" element={<Events />} />
				<Route path="tasks" element={<Events />} />
			</Routes>
		</div>
	);
};

export default App;
