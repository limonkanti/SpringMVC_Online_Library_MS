<%-- 
    Document   : question
    Created on : Aug 1, 2016, 12:13:07 AM
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
        <h1 align="centre">Store Books in The Library</h1>  
        <form:form method="post" action="/SpringProject/store_library_books">    
            <table>    
                <tr>    
                    <td>Enter Book ID : </td>   
                    <td><form:input path="book_id"  /></td>  
                </tr>
                
                <tr>    
                    <td>Enter Book Name : </td>   
                    <td><form:input path="book_name"/></td>  
                </tr>
                <tr>    
                    <td>Enter Author Name : </td>   
                    <td><form:input path="author" /></td>  
                </tr>
                
                <tr>    
                    <td>Enter Publisher: </td>   
                    <td><form:input path="publisher"  /></td>  
                </tr>
                <tr>    
                    <td>Enter Quantity: </td>   
                    <td><form:input path="quantity"  /></td>  
                </tr>
               
                <tr>    

                    <td><input type="submit" value="Save" /></td>   
                    <td><input type="reset" name="RESET"></td>
                </tr>    
            </table>
        </form:form> 
    </body>
</html>
