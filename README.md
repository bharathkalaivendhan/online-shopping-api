A REST API that will act as backend for simple online shopping application.\
User can store, retrieve, update and delete various things like users, products, sellers, orders,reviews.\
It works as backend service for simple online shopping application.

I developed to project to practice the concepts of Spring Framework, Spring Boot, RESTful API, Spring Data JPA(in persistance layer) and MySQL(database).

I used,\
    Spring Boot(for backend),\
    RESTful API concepts,\
    Spring Data JPA(for data accessing layer or persistence layer),\
    Hibernate(spring data jpa uses hibernate as ORM(Object Relational Mapping) as default),\
    MySQL(Database(RDBMS))

Endpoints:

(hostname)/seller\
    /add\
        to adding/creating a seller details.\
    /add-all\
        to adding/creating many seller details at once.\
    /get-all\
        to retrieving/getting all seller details at once.\
    /get-by-id/{id}\
        to retrieving/getting a seller details using seller id.\
    /update-seller/{id}\
        to update a seller details using seller id.\
    /update-rating/{id}/{rating}\
        to update a seller rating using seller id.\
    /delete-by-id/{id}\
        to delete a seller details using seller id.\
    /delete-all\
        to delete all seller details at once.

(hostname)/product\
    /add/{sellerId}\
        to adding/creating a product details with seller details.\
    /add-all/{sellerId}\
        to adding/creating many product details with seller details at once.\
    /get-all\
        to retrieving/getting all product details at once.\
    /get-by-id/{id}\
        to retrieving/getting a product details using product id.\
    /update-product/{id}\
        to update a product details using product id.\
    /update-rating/{id}/{rating}\
        to update a product rating using product id.\
    /delete-by-id/{id}\
        to delete a product details using product id.\
    /delete-all\
        to delete all product details at once.\
    /search-by-name/{productName}?orderBy=(ASC OR DESC)\
        to search product by product name and order result by ascending or descending.\
    /search-by-category/{category}?minPrice=(minimum price amount)&maxPrice=(maximum price amount)&orderBy=(ASC OR DESC)\
        to search product by product category, minimum price amount, maximum price amount and order result by ascending or descending.

(hostname)/user\
    /add\
        to adding/creating a user details.\
    /add-all\
        to adding/creating many user details at once.\
    /get-all\
        to retrieving/getting all user details at once.\
    /get-by-id/{id}\
        to retrieving/getting a user details using user id.\
    /update-user/{id}\
        to update a user details using user id.\
    /delete-by-id/{id}\
        to delete a user details using user id.\
    /delete-all\
        to delete all user details at once.

(hostname)/order\
    /{productId}?userId=(id of user)&orderedQuantity=(quantity of item ordered)\
        to order a product using product id and its quantity.\
    /get-by-id/{orderId}\
        to get order details by using order id.\
    /get-all
        to get all orders details at once.
    
