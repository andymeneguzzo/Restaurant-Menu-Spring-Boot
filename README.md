# Restaurant Menu API

A Spring Boot REST API for managing restaurant menu items.

## Project Overview

This project implements a RESTful API for restaurant menu management. It allows for creating, reading, updating, and deleting menu items through HTTP endpoints, following standard REST principles.

## Features

- Get all menu items
- Get a specific menu item by ID
- Create new menu items
- Update existing menu items
- Delete menu items
- Custom exception handling for improved user experience

## Technology Stack

- **Java**
- **Spring Boot**: Framework for creating stand-alone, production-grade applications
- **Spring MVC**: For handling HTTP requests and responses
- **In-Memory Storage**: HashMap-based repository implementation for data persistence

## Project Structure

The project follows a layered architecture pattern:

```
com.restaurant
├── controller
│   └── MenuController.java
├── model
│   └── MenuItem.java
├── repository
│   ├── MenuRepository.java
│   └── InMemoryMenuRepository.java
├── service
│   ├── MenuService.java
│   └── MenuServiceImpl.java
└── exception
    ├── MenuItemNotFoundException.java
    └── GlobalExceptionHandler.java
```

### Components

#### 1. Model

`MenuItem.java` - Represents a menu item with the following properties:
- id: Unique identifier
- name: Name of the menu item
- description: Detailed description
- price: Cost of the item
- category: Type of food (e.g., appetizer, main course, dessert)

#### 2. Repository

`MenuRepository.java` - Interface defining data access operations.

`InMemoryMenuRepository.java` - Implementation using a HashMap for in-memory storage with:
- ID generation using AtomicLong
- Basic CRUD operations
- Sample data initialization

#### 3. Service

`MenuService.java` - Interface defining business operations.

`MenuServiceImpl.java` - Implementation with:
- Data validation logic
- Business rule enforcement
- Connection between controller and repository

#### 4. Controller

`MenuController.java` - REST endpoints:
- GET /api/menu - Retrieve all menu items
- GET /api/menu/{id} - Retrieve a specific menu item
- POST /api/menu - Create a new menu item
- PUT /api/menu/{id} - Update an existing menu item
- DELETE /api/menu/{id} - Delete a menu item

#### 5. Exception Handling

`MenuItemNotFoundException.java` - Custom exception for when a menu item is not found.

`GlobalExceptionHandler.java` - Central exception handler using @ControllerAdvice.

## API Endpoints

### Get All Menu Items
```
GET /api/menu
```
Response: Array of menu items

### Get Menu Item by ID
```
GET /api/menu/{id}
```
Response: Menu item or 404 Not Found

### Create Menu Item
```
POST /api/menu
Content-Type: application/json

{
  "name": "Caesar Salad",
  "description": "Fresh romaine lettuce with Caesar dressing",
  "price": 8.99,
  "category": "Appetizer"
}
```
Response: Created menu item with ID

### Update Menu Item
```
PUT /api/menu/{id}
Content-Type: application/json

{
  "name": "Caesar Salad Supreme",
  "description": "Fresh romaine lettuce with premium Caesar dressing and croutons",
  "price": 9.99,
  "category": "Appetizer"
}
```
Response: Updated menu item

### Delete Menu Item
```
DELETE /api/menu/{id}
```
Response: 204 No Content

## Getting Started

### Prerequisites
- Java 11 or higher
- Maven

### Running the Application

1. Clone the repository
   ```
   git clone https://github.com/yourusername/restaurant-menu-api.git
   ```

2. Navigate to the project directory
   ```
   cd restaurant-menu-api
   ```

3. Build the project
   ```
   mvn clean install
   ```

4. Run the application
   ```
   mvn spring-boot:run
   ```

5. The API will be available at `http://localhost:8080/api/menu`

## Testing

You can test the API using tools like Postman, cURL, or any HTTP client:

### cURL Examples

#### Get all menu items
```
curl -X GET http://localhost:8080/api/menu
```

#### Get a specific menu item
```
curl -X GET http://localhost:8080/api/menu/1
```

#### Create a new menu item
```
curl -X POST http://localhost:8080/api/menu \
  -H "Content-Type: application/json" \
  -d '{"name":"Spaghetti","description":"Classic pasta with tomato sauce","price":12.99,"category":"Main Course"}'
```

#### Update a menu item
```
curl -X PUT http://localhost:8080/api/menu/1 \
  -H "Content-Type: application/json" \
  -d '{"name":"Updated Dish","description":"New description","price":15.99,"category":"Main Course"}'
```

#### Delete a menu item
```
curl -X DELETE http://localhost:8080/api/menu/1
```

## Future Enhancements

- Implement persistent database storage
- Add authentication and authorization
- Create a frontend interface
- Add pagination for menu items
- Implement filtering by category
- Add image upload capability

## License

This project is licensed under the MIT License - see the LICENSE file for details.
