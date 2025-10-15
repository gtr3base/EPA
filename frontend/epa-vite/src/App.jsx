import Header from "./components/Header";
import { getEvents } from "./api/requests.js";
import "./App.css";
import { useEffect } from "react";

function App() {
	useEffect(() => {
		getEvents();
	}, []);

	return (
		<>
			<div className="App">
				<Header />
			</div>
		</>
	);
}

export default App;
