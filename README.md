# Event Planning Assistant API Documentation

## Base URL

```
http://localhost:8080/api
```

## Authentication

All endpoints require **Basic Authentication**, unless otherwise specified.

---

## Events

### Get All Events

- **URL**: `/events`
- **Method**: `GET`
- **Response**: List of all events

**Example Response**:
```json
[
  {
    "id": 1,
    "name": "Company Conference",
    "description": "Annual company conference",
    "startTime": "2023-12-15T09:00:00",
    "endTime": "2023-12-15T17:00:00",
    "location": "Grand Ballroom",
    "budget": 10000.00
  }
]
```

---

### Create Event

- **URL**: `/events`
- **Method**: `POST`
- **Request Body**:
```json
{
  "name": "Product Launch",
  "description": "New product launch event",
  "startTime": "2023-11-20T18:00:00",
  "endTime": "2023-11-20T21:00:00",
  "location": "Convention Center",
  "budget": 5000.00
}
```
- **Response**: Created event

---

### Get Event by ID

- **URL**: `/events/{id}`
- **Method**: `GET`
- **Response**: Event details

**Example Response**:
```json
{
  "id": 2,
  "name": "Product Launch",
  "description": "New product launch event",
  "startTime": "2023-11-20T18:00:00",
  "endTime": "2023-11-20T21:00:00",
  "location": "Convention Center",
  "budget": 5000.00
}
```

---

### Update Event

- **URL**: `/events/{id}`
- **Method**: `PUT`
- **Request Body**:
```json
{
  "name": "Product Launch (Updated)",
  "description": "New product launch event with updates",
  "startTime": "2023-11-20T18:00:00",
  "endTime": "2023-11-20T22:00:00",
  "location": "Convention Center - Room A",
  "budget": 6000.00
}
```
- **Response**: Updated event

---

### Delete Event

- **URL**: `/events/{id}`
- **Method**: `DELETE`
- **Response**: `200 OK`

---

### Add Vendor to Event

- **URL**: `/events/{eventId}/vendors/{vendorId}`
- **Method**: `POST`
- **Response**: Updated event with the new vendor

---

### Get Events in Time Range

- **URL**: `/events/range?start={startDateTime}&end={endDateTime}`
- **Method**: `GET`
- **Response**: Events within specified time range

---

## Vendors

### Get All Vendors

- **URL**: `/vendors`
- **Method**: `GET`
- **Response**: List of all vendors

**Example Response**:
```json
[
  {
    "id": 1,
    "name": "Gourmet Catering",
    "category": "CATERING",
    "contactInfo": "contact@gourmet.com",
    "rating": 4.8
  }
]
```

---

### Create Vendor

- **URL**: `/vendors`
- **Method**: `POST`
- **Request Body**:
```json
{
  "name": "Elite AV Solutions",
  "category": "AUDIO_VISUAL",
  "contactInfo": "info@eliteav.com",
  "rating": 4.5
}
```
- **Response**: Created vendor

---

### Get Vendor by ID

- **URL**: `/vendors/{id}`
- **Method**: `GET`
- **Response**: Vendor details

---

### Update Vendor

- **URL**: `/vendors/{id}`
- **Method**: `PUT`
- **Request Body**:
```json
{
  "name": "Elite AV Solutions",
  "category": "AUDIO_VISUAL",
  "contactInfo": "sales@eliteav.com",
  "rating": 4.7
}
```
- **Response**: Updated vendor

---

### Delete Vendor

- **URL**: `/vendors/{id}`
- **Method**: `DELETE`
- **Response**: `200 OK`

---

### Get Vendors by Category

- **URL**: `/vendors/category/{category}`
- **Method**: `GET`
- **Response**: List of vendors in the specified category

---

## Tasks

### Get All Tasks

- **URL**: `/tasks`
- **Method**: `GET`
- **Response**: List of all tasks

**Example Response**:
```json
[
  {
    "id": 1,
    "name": "Book venue",
    "description": "Reserve the conference room",
    "status": "COMPLETED",
    "deadline": "2023-10-15T23:59:00"
  }
]
```

---

### Create Task

- **URL**: `/tasks`
- **Method**: `POST`
- **Request Body**:
```json
{
  "name": "Send invitations",
  "description": "Email invitations to all attendees",
  "status": "NOT_STARTED",
  "deadline": "2023-11-01T23:59:00",
  "eventId": 1,
  "assignedToId": 2
}
```
- **Response**: Created task

---

### Get Task by ID

- **URL**: `/tasks/{id}`
- **Method**: `GET`
- **Response**: Task details

---

### Update Task

- **URL**: `/tasks/{id}`
- **Method**: `PUT`
- **Request Body**:
```json
{
  "name": "Send invitations (updated)",
  "description": "Email and mail invitations to all attendees",
  "status": "IN_PROGRESS",
  "deadline": "2023-11-05T23:59:00",
  "eventId": 1,
  "assignedToId": 2
}
```
- **Response**: Updated task

---

### Delete Task

- **URL**: `/tasks/{id}`
- **Method**: `DELETE`
- **Response**: `200 OK`

---

### Get Tasks by Event

- **URL**: `/tasks/event/{eventId}`
- **Method**: `GET`
- **Response**: List of tasks for specified event

---

### Get Tasks by User

- **URL**: `/tasks/user/{userId}`
- **Method**: `GET`
- **Response**: List of tasks assigned to specified user

---

### Get Tasks by Status

- **URL**: `/tasks/status/{status}`
- **Method**: `GET`
- **Response**: List of tasks with specified status

---

## Users

### Get All Users

- **URL**: `/users`
- **Method**: `GET`
- **Response**: List of all users

**Example Response**:
```json
[
  {
    "id": 1,
    "username": "admin",
    "email": "admin@company.com",
    "role": "ADMIN"
  }
]
```

---

### Create User

- **URL**: `/users`
- **Method**: `POST`
- **Request Body**:
```json
{
  "username": "event_manager",
  "email": "manager@company.com",
  "password": "securepassword123",
  "role": "EVENT_PLANNER"
}
```
- **Response**: Created user (password not returned)

---

### Get User by ID

- **URL**: `/users/{id}`
- **Method**: `GET`
- **Response**: User details

---

### Update User

- **URL**: `/users/{id}`
- **Method**: `PUT`
- **Request Body**:
```json
{
  "username": "senior_manager",
  "email": "senior.manager@company.com",
  "password": "newsecurepassword456",
  "role": "EVENT_PLANNER"
}
```
- **Response**: Updated user

---

### Delete User

- **URL**: `/users/{id}`
- **Method**: `DELETE`
- **Response**: `200 OK`

---

## Error Responses

### Resource Not Found (404)
```json
{
  "timestamp": "2023-10-10T14:30:00.123",
  "message": "Event not found with id: 999"
}
```

### Internal Server Error (500)
```json
{
  "timestamp": "2023-10-10T14:30:00.123",
  "message": "An error occurred"
}
```

### Unauthorized (401)

Empty response when authentication fails

---

## Enumerations

### TaskStatus

- `NOT_STARTED`
- `IN_PROGRESS`
- `COMPLETED`
- `BLOCKED`

### UserRole

- `ADMIN`
- `EVENT_PLANNER`
- `VENDOR`
- `GUEST`

### Vendor Categories

(Defined as per your system's specifications)
