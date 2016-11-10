<%-- 
    Document   : return_book
    Created on : Nov 3, 2016, 12:57:25 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
        <h1 align="centre">Return Book</h1>  
        <form:form method="post" action="/SpringProject/return_book">    
            <table>    
                <tr>    
                    <td>Student ID : </td>   
                    <td><form:input path="student_id"  /></td>  
                </tr>
                
                <tr>    
                    <td>Enter Book Name : </td>   
                    <td><form:input path="book_name"/></td>  
                </tr>
                <tr>    

                    <td><input type="submit" value="Save" /></td>   
                    <td><input type="reset" name="RESET"></td>
                </tr>    
            </table>
        </form:form> 
    </body>
</html>
