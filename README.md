#Contacts Application API-

This is a backend of Contacts application based on Spring Boot that provides a RESTful API for fetching contacts data. It allows you to create contacts with their full name, date of birth, and address, and provides endpoints to retrieve contacts and filter them by postal code.

#Setup and Running the Application-

1.Clone this repository to your local machine or download the source code.
2.Open the project in your preferred IDE.
3.Build the project using Maven. 
4.The application will start and the RESTful API will be available at http://localhost:8080.

#API Endpoints (Controllers) -

1.Retrieve All Contacts
Endpoint: /api/contact/getAll
Description: Retrieves all existing contacts.
Response Body:json
[
    {
        "id": 1,
        "name": "Ankit Milmile",
        "dob": "07-FEB-1999",
        "address": {
            "id": 1,
            "city": "Mumbai",
            "postalCode": "400615"
        }
    },
    {
        "id": 2,
        "name": "Mark Zukerburg",
        "dob": "07-FEB-1980",
        "address": {
            "id": 2,
            "city": "harvard",
            "postalCode": "22222"
        }
    },
    {
        "id": 3,
        "name": "Elon Musk",
        "dob": "07-FEB-1970",
        "address": {
            "id": 3,
            "city": "stanford",
            "postalCode": "22222"
        }
    }
]

2.Filter Contacts by Postal Code
Endpoint: /api/contact?postalCode=22222
Description: Retrieves contacts filtered by the given postal code.
Response Body:json
[
    {
        "id": 2,
        "name": "Mark Zukerburg",
        "dob": "07-FEB-1980",
        "address": {
            "id": 2,
            "city": "harvard",
            "postalCode": "22222"
        }
    },
    {
        "id": 3,
        "name": "Elon Musk",
        "dob": "07-FEB-1970",
        "address": {
            "id": 3,
            "city": "stanford",
            "postalCode": "22222"
        }
    }
]

3.Create a New Contact
Endpoint: /api/contact/create
Description: Creates a new contact with the provided details.
Request Body:json
{
    "name": "mark zukerburg",
    "dob": "07-FEB-1970",
    "address": {
        "city": "harvard",
        "postalCode": "22222"
    }
}

Response Body:json
{
    "id": 2,
    "name": "mark zukerburg",
    "dob": "07-FEB-1970",
    "address": {
        "id": 2,
        "city": "harvard",
        "postalCode": "22222"
    }
}

Data Storage-
This application uses an in-memory H2 database to persist contacts. The database is automatically started along with the application and is populated with sample data upon startup. The data is volatile and will be reset every time the application is restarted.

Logging-
Each time a contact is created, the application logs a message with the contact's ID using the SLF4J logging framework.
