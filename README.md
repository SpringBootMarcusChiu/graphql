# Running Instructions
<code>mvn clean install</code>  
<code>mvn spring-boot:run</code>

H2 - MySQL database embedded within this application. To see H2 console goto http://localhost:8080/h2-console. Make sure <code>JDBC url</code> is  <code>jdbc:h2:mem:testdb</code>


#### GraphQL Schema 
http://localhost:8080/graphql/schema.json  

#### Sample Queries
http://localhost:8080/graphql?query=%7BcountBooks%7D  
http://localhost:8080/graphql?query=%7BfindAllBooks%7Bid%20title%7D%7D


# GraphIQL UI
http://localhost:8080/graphiql

findAllBooks

    {
      findAllBooks {
        id
        isbn
        title
        pageCount
        author {
          firstName
          lastName
        }
      }
    }
    
create new book

    mutation {
      newBook(title: "Java: The Complete Reference, Tenth Edition", isbn: "1259589331", author: 1) {
        id
        title
      }
    }

update page count 

    mutation {
      updateBookPageCount(pageCount: 1344, id: 2) {
        id pageCount
      }
    }
    
delete book

    mutation {
      deleteBook(id:2)
    }