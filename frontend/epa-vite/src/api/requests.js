import axios from "axios";

const BASE_API_URL = "http://localhost:8080/api";

axios.defaults.baseURL = BASE_API_URL;

axios.interceptors.response.use(
	(res) => {
		console.log(res.status);
		return res.data;
	},
	(err) => {
		console.log(err);
	}
);

// Events
export const getEvents = async () => {
	const res = await axios.get(`/events`);
	return res.data;
};

export const createEvent = async (event) => {
	const res = await axios.post(`/events`, event);
	return res.data;
};

export const getEvent = async (id) => {
	const res = await axios.get(`/events/${id}`);
	return res.data;
};

export const updateEvent = async (id, event) => {
	const res = await axios.put(`/events/${id}`, event);
	return res.data;
};

export const deleteEvent = async (id) => {
	const res = await axios.delete(`/events/${id}`);
	return res.data;
};

export const addVendor = async (eventId, vendorId) => {
	const res = await axios.post(`/events/${eventId}/vendors/${vendorId}`);
	return res.data;
};

export const getEventInTimeRange = async (start, end) => {
	const res = await axios.get(`/events/range`, {
		params: {
			start,
			end,
		},
	});
	return res.data;
};

// Vendors

export const getVendors = async () => {
	const res = await axios.get(`/vendors`);
	return res.data;
};

export const createVendor = async (vendor) => {
	const res = await axios.post(`/vendors`, vendor);
	return res.data;
};

export const getVendor = async (id) => {
	const res = await axios.get(`/vendors/${id}`);
	return res.data;
};

export const updateVendor = async (id, vendor) => {
	const res = await axios.put(`/vendors/${id}`, vendor);
	return res.data;
};

export const deleteVendor = async (id) => {
	const res = await axios.delete(`/vendors/${id}`);
	return res.data;
};

export const getVendorByCategory = async (category) => {
	const res = await axios.get(`/vendors/category/${category}`);
	return res.data;
};

// Tasks

export const getTasks = async () => {
	const res = await axios.get(`/tasks`);
	return res.data;
};

export const createTask = async (task) => {
	const res = await axios.post(`/tasks`, task);
	return res.data;
};

export const getTask = async (id) => {
	const res = await axios.get(`/tasks/${id}`);
	return res.data;
};

export const updateTask = async (id, task) => {
	const res = await axios.put(`/tasks/${id}`, task);
	return res.data;
};

export const deleteTask = async (id) => {
	const res = await axios.delete(`/tasks/${id}`);
	return res.data;
};

export const getTasksByEvent = async (eventId) => {
	const res = await axios.get(`/tasks/event/${eventId}`);
	return res.data;
};

export const getTasksByUser = async (userId) => {
	const res = await axios.get(`/tasks/user/${userId}`);
	return res.data;
};

export const getTasksByStatus = async (status) => {
	const res = await axios.get(`/tasks/status/${status}`);
	return res.data;
};

// Users
export const getUsers = async () => {
	const res = await axios.get(`/users`);
	return res.data;
};

export const createUser = async (user) => {
	const res = await axios.post(`/users`, user);
	return res.data;
};

export const getUser = async (id) => {
	const res = await axios.get(`/users/${id}`);
	return res.data;
};

export const updateUser = async (id, user) => {
	const res = await axios.put(`/users/${id}`, user);
	return res.data;
};

export const deleteUser = async (id) => {
	const res = await axios.delete(`/users/${id}`);
	return res.data;
};
