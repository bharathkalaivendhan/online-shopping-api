A REST API that will act as backend for simple online shopping application.
User can store, retrieve, update and delete various things like users, products, sellers, orders,reviews. 
It works as backend service for simple online shopping application.
I used the concepts of Spring Framework, Spring Boot, Spring RESTful API, Spring Data JPA(in persistance layer) and MySQL(database).

Endpoints:

-(hostname)/seller
    -/add
        to adding/creating a seller details.
    -/add-all
        to adding/creating many seller details at once.
    -/get-all
        to retrieving/getting all seller details at once.
    -/get-by-id/{id}
        to retrieving/getting a seller details using seller id.
    -/update-seller/{id}
        to update a seller details using seller id.
    -/update-rating/{id}/{rating}
        to update a seller rating using seller id.
    -/delete-by-id/{id}
        to delete a seller details using seller id.
    -/delete-all
        to delete all seller details at once.

-(hostname)/product
    -/add/{sellerId}
        to adding/creating a product details with seller details.
    -/add-all/{sellerId}
        to adding/creating many product details with seller details at once.
    -/get-all
        to retrieving/getting all product details at once.
    -/get-by-id/{id}
        to retrieving/getting a product details using product id.
    -/update-product/{id}
        to update a product details using product id.
    -/update-rating/{id}/{rating}
        to update a product rating using product id.
    -/delete-by-id/{id}
        to delete a product details using product id.
    -/delete-all
        to delete all product details at once.

-(hostname)/user
    *yet to develop

-(hostname)/order
    *yet to develop