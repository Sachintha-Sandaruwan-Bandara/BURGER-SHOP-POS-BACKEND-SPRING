# Burger Shop POS System

## Overview

The Burger Shop POS system is a full-stack application that facilitates the management of customers, items, and orders for a burger shop. The backend is built with Java, Spring, and MySQL. It enables users to perform CRUD operations on customers and items, place orders, and view order details.

## Technologies Used

### Backend
- Java 17
- Spring Framework (Spring Web MVC, Spring Data JPA, Hibernate)
- MySQL (Database)
- Postman (for testing API requests)
- SLF4J with Logback (for logging)

## Features

### Customer Management
- Create, Read, Update, and Delete (CRUD) operations for customers.

### Item Management
- Create, Read, Update, and Delete (CRUD) operations for items.

### Place Orders
- Functionality to place new orders by selecting customers and items.

### View Orders
- Functionality to view all existing orders and their details.

## Installation

### Prerequisites
- Java 17 or later
- Maven (for building the backend)
- MySQL (set up a database and configure connection details)
- Postman (recommended for testing API requests)

### Backend Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/Sachintha-Sandaruwan-Bandara/BURGER-SHOP-POS-BACKEND-SPRING.git
## Navigate to the backend directory:

## Run the application
The backend will start on http://localhost:8080.
### API Endpoints
## Customer Endpoints
- GET /api/v1/customer: Retrieve all customers.
- POST /api/v1/customer: Create a new customer.
- PUT /api/v1/customer: Update an existing customer.
- DELETE /api/v1/customer/{id}: Delete a customer by ID.
## Item Endpoints
- GET /api/v1/item: Retrieve all items.
- POST /api/v1/item: Create a new item.
- PUT /api/v1/item: Update an existing item.
- DELETE /api/v1/item/{id}: Delete an item by ID.
## Order Endpoints
- GET /api/v1/order: Retrieve all orders.
- POST /api/v1/placeOrder: Place a new order.
### Usage
## Customer Management
- Navigate to the "Customer" section in the frontend.
- Use the form to add, update, or delete customer information.
## Item Management
- Navigate to the "Items" section.
- Manage items using the form to add, update, or delete items.
## Place Orders
- Go to the "Order" section in the frontend.
- Select a customer and add items to create a new order.
-View Orders
- Visit the "View Orders" section.
- Review all existing orders, including their details and status.
### API Documentation
You can find detailed API documentation at the following link:

https://documenter.getpostman.com/view/34708061/2sAXxV6A19

This documentation provides information about each API endpoint, including request parameters and sample responses.

##License
MIT License
© 2024 - Present | Sachintha Sandaruwan | All Rights Reserved
