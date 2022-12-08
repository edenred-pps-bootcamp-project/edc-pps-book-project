### Team GREEN
- book-catalog-service
    - Sorin (Lead)
    - Daria

This module brings together functionalities from all other modules: **book-info** and **book-rating**.
</br></br> All modules must run in parallel on different ports. This one uses requests handled with rest template to communicate between them and saves merged items in the database known as **catalog items**.
</br></br> 
- Project structure
  - Model : [User](C:\dev\edc-pps-book-project\book-catalog-service\src\main\java\com\edc\pps\catalog\model\User.java)
  - Service : [BookService](C:\dev\edc-pps-book-project\book-catalog-service\src\main\java\com\edc\pps\catalog\service\BookService.java),
  [RatingService](C:\dev\edc-pps-book-project\book-catalog-service\src\main\java\com\edc\pps\catalog\service\RatingService.java),
  [UserService](C:\dev\edc-pps-book-project\book-catalog-service\src\main\java\com\edc\pps\catalog\service\UserService.java)
  - Dto : [CatalogItem](C:\dev\edc-pps-book-project\book-catalog-service\src\main\java\com\edc\pps\catalog\dto\CatalogItem.java),
  [UserMapper](C:\dev\edc-pps-book-project\book-catalog-service\src\main\java\com\edc\pps\catalog\dto\UserMapper.java) + Request & Response
  - Controller : [UserController](C:\dev\edc-pps-book-project\book-catalog-service\src\main\java\com\edc\pps\catalog\controller\UserController.java)
  - Config, Aop, Exception Handling, Repository

- Api requests available:
  - CRUD operations: save, find all, update, delete
  - Save catalog item (uses databases from the info/rating applications)

- Technology stack:
  - Spring boot web
  - Spring boot data jpa
  - Spring boot test
  - Spring boot validation
  - Lombok
  - Swagger ui
