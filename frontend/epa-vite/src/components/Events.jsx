import "../css/Events.css";
import Header from "./Header.jsx";
import EventsList from "./EventsList.jsx";

const Events = () => {
	return (
		<div className="Events">
			<Header />
			<main>
				<EventsList />
			</main>
		</div>
	);
};

export default Events;
