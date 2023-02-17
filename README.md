# Hogwarts Houses - Spring Boot Backend Application
What if I told you that magic is real? What if I told you that wizards, witches, and everything from the world of Harry Potter is real, and they need you now?

In our fast-paced, modern world, they can't solve everything with spells and potions anymore. That's why now more than ever, Hogwarts School of Witchcraft and Wizardry needs a little bit of Muggle technology, to make the management of this enormous castle less of a headache. Of course, since witches and wizards have no idea about technology, you'll disguise your API as a set of more wizard-friendly spells, so that it's more intuitive for the target audience.

![background](/src/main/resources/static/img/background.jpg)

Let the techno... ahem, magic, begin!

This is a Spring Boot application for managing information about Hogwarts Houses in the Wizarding World. The application uses Spring APIs, JPA Repository, and PostgreSQL database.

## Getting Started
To get started with this project, you will need to have the following tools installed on your local machine:

- Java 11 or higher
- Apache Maven
- PostgreSQL database

## API Endpoints
The following API endpoints are available in the application:

- GET /rooms: A list of all rooms is returned.
- POST /rooms: A new room can be added.
- GET /rooms/{roomId}: The room with the specified ID is returned.
- DELETE /rooms/{roomID}: The room with the specified ID is deleted.
- PUT /rooms/{roomId}: The room with the specified ID is updated.
- GET /rooms/available: A list of all available rooms is returned.
- GET /rooms/rat-owners: A list of rooms, residents of which have no cats or owls, is returned.


## Technologies Used
- **Spring Boot**
- **Spring APIs**
- **JPA Repository**
- **PostgreSQL database** 

## Acknowledgements
This project was created as part of my learning journey to become a better Spring developer. Special thanks to J.K. Rowling for creating the magical world of Harry Potter.
