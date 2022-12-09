### Team RED
- book-info-service
    - sorin t (lead)
    - alex

- Project structure
  - Model : [Book](C:\dev\edc-pps-book-project\book-info-service\src\main\java\com\edc\pps\info\model\Book.java)
  - Service : [BookService](C:\dev\edc-pps-book-project\book-info-service\src\main\java\com\edc\pps\info\service\BookService.java),
  - Dto : [BookMapper](C:\dev\edc-pps-book-project\book-info-service\src\main\java\com\edc\pps\info\dto\BookMapper.java) + Request & Response
  - Controller : [BookController](C:\dev\edc-pps-book-project\book-info-service\src\main\java\com\edc\pps\info\controller\BookController.java)
  - Config, Aop, Exception Handling, Repository

- Api requests available:
  - CRUD operations: save book, find all books, update book , delete book, find all books by author , finad all books by title

# Endpoints
[POST](http://localhost:8084//api/books)
save new book
[GET](http://localhost:8084//api/books)
get all books
[DELETE](http://localhost:8084//api/books/find/)
delete a book by id
[GET](http://localhost:8084//api/books/author/)
get all books by author
[GET](http://localhost:8084//api/books/title/)
get all books by title
[PATCH](http://localhost:8084//api/books/)
update a book title and author by book id
[PUT](http://localhost:8084//api/books/)
update average rating for a book

- Technology stack:
  - Spring boot web
  - Spring boot data jpa
  - Spring boot test
  - Spring boot validation
  - Lombok
  - Swagger ui
  - Rest Assured
