# Attornatus-peopleManagementAPI
People Management API for Attornatus Practice Test

- It is a simple people management API that meets the following requirements, developed with Spring boot and using in-memory database with H2:
  - Create a person
  - Update a person
  - list people
  - consult a person
  - Create address for person
  - List person addresses
  - Be able to inform which address is the person's main
  
- People have the following attributes:
  - Long id;
  - String name;
  - Date birthDate;
  - Long mainAddressId; (Relationship with entity address)
- Addresses have the following attributes:
  - Long id
  - String publicPlace
  - String zipCode
  - int number
  - String city
  - Long peopleId
  
#### We use FlyWay for versioning database structures.

<hr/>

## Testing the API:

To use this API, just clone the remote repository in a local folder and boot from an IDE ready to run Spring boot projects. (We suggest InteliJ or Eclipse).
After that, just start the application from Spring, through the "Application" class, available in the "src/main/java" directory.
 
## Using API endpoints:

This API does not have Swagger, however, all usable methods are contained in the collection next to the project, just open it with an API client, such as postman for example, after successfully initializing the application.

The base URL is:

http://localhost:8080/

always check if port 8080 is available before starting the application, if it is in use, it will be necessary to change the service port and query methods or to overthrow the service that is currently consuming the port.

### All methods in this api have unit tests

Thanks for the visit! I accept feedbacks
