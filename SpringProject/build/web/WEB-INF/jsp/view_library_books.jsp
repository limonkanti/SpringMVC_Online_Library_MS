<%-- 
    Document   : view_library_books
    Created on : Nov 2, 2016, 1:04:50 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Books</title>
    </head>
    <body>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
        <h1>Welcome to You Library Books.</h1>
        <table border="2" width="70%" cellpadding="2">  
            <tr><th>Book_ID</th><th>Book_Name</th><<th>Author</th><th>Publisher</th><th>Quantity</th></tr>

            <c:forEach var="viewBooks" items="${list}">  
                <tr>

                    <td>${viewBooks.book_id}</td>




                    <td>${viewBooks.book_name}</td>




                    <td>${viewBooks.author}</td>


                    <td>${viewBooks.publisher}</td>


                    <td>${viewBooks.quantity}</td>
                </tr>
            </c:forEach>

        </table>

    </body>
</html>
