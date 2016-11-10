<%-- 
    Document   : store_books
    Created on : Nov 3, 2016, 12:12:27 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Store Books</title>
    </head>
    <body>
       <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
        <h1>Stock Available To The Library Books.</h1>
        <table border="2" width="70%" cellpadding="2">  
            <tr><th>Book_ID</th><th>Book_Name</th><<th>Author</th><th>Publisher</th><th>Quantity</th><th>Issued</th><th>Store Books</th></tr>

            <c:forEach var="storeBooks" items="${list}">  
                <tr>

                    <td>${storeBooks.book_id}</td>




                    <td>${storeBooks.book_name}</td>




                    <td>${storeBooks.author}</td>


                    <td>${storeBooks.publisher}</td>


                    <td>${storeBooks.quantity}</td>
                    
                    
                    <td>${storeBooks.issued}</td>


                    <td>${storeBooks.store_book}</td>
                    
                    
                    
                </tr>
            </c:forEach>

        </table>

    </body>
</html>
