# ADP3-MyWebsitePracticeBackend
This was a class task that was asked to be completed for the modelling of a basic backend with MySQL configuration in Java. Its primary purpose was for the construction of a backend that uses the MVC architecture to create the SpringBoot backend. It includes:
- a Domain: which has a customer and home_address (as a means o understanding composition and aggregation),
- a Factory: a factory sees to the validation of the instances being built from our domain object. Through the use of a Builder, and a Helper class all instances can be build with the parameters passed into the method of the domains factory,
- a Repository: this is where we extend the Spring Data JPA as a means of covering persistence within our applications rather than using collection classes,
- a Service: our services extend the data from the client side and all the business logic is then processed within our services as a means of passing that to our backend, and finally,
- a Controller: a REST controller allows for the representational state transfer of JSON object data into our application and uses the ORM to then map the data according to its relative objective through the use of annotations such as @RequestBody
