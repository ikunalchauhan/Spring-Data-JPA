
# Spring-Data-JPA

This is integeration of Spring-Data-JPA with spring boot application using mysql workbench to handle a simple database.

Controllers with proper service class are designed with standard way of coding for standard code implementation.

Entity and JPA repository is designed for proper synchronisation of SQL database and Entity instances.


## API Reference

#### Add Multiple Users

```http
  POST /addUsers
```


#### Add Single User

```http
  POST /addUser
```


#### Get All User

```http
  GET /getAllUsers
```

#### Get User by ID

```http
  GET /getUserById/{id}
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int`    | **Required**. Id of User to fetch |


#### Get User by Name

```http
  GET /getUserByName/{name}
```
| Parameter | Type     | Description                         |
| :-------- | :------- | :---------------------------------- |
| `name`    | `String` | **Required**. Name of User to fetch |


#### Get User by City

```http
  GET /getUserByCity/{city}
```
| Parameter | Type     | Description                         |
| :-------- | :------- | :---------------------------------- |
| `city`    | `String` | **Required**. City of User to fetch |



#### Get User by Name and Status

```http
  GET /getUserByNameAndStatus/{name}/{status}
```
| Parameter | Type     | Description                           |
| :-------- | :------- | :------------------------------------ |
| `name`    | `String` | **Required**. Name of User to fetch   |
| `status`  | `String` | **Required**. Status of User to fetch |


#### Get User Matching specific Status

```http
  GET /getUsersMatchingStatus/{status}
```
| Parameter | Type     | Description                           |
| :-------- | :------- | :------------------------------------ |
| `status`  | `String` | **Required**. Status of User to fetch |


#### Delete all users

```http
  DELETE /deleteUsers
```


#### Delete user using id

```http
  DELETE /deleteUser/{id}
```
| Parameter | Type     | Description                         |
| :-------- | :------- | :---------------------------------- |
| `id`      | `int`    | **Required**. Id of User to fetch   |


#### Update existing-user info using id

```http
  UPDATE /updateUser/{id}
```
| Parameter | Type     | Description                         |
| :-------- | :------- | :---------------------------------- |
| `id`      | `int`    | **Required**. id of User to fetch   |



## Maven Dependencies
 

```
  Spring Web
  Spring Data JPA
  MySQL Driver
  Spring Boot DevTools
```

## Tech Stack


**Backend:** SpringBoot

**Database:** MySQL

**Tools:** MySQL Workbench



## FAQ

#### Should developer need to create Database ?

No, in application.properties file we have dll auto generation command which will auto-create the tables.



![App Screenshot](https://hocspringboot.net/wp-content/uploads/2021/08/spring-data-jpa.png)

