<%-- 
    Document   : issue_book
    Created on : Nov 2, 2016, 11:55:44 PM
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
        <h1 align="centre">Issue Book</h1>  
        <form:form method="post" action="/SpringProject/issue_book">    
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
                    <td>Enter Student Name : </td>   
                    <td><form:input path="student_name" /></td>  
                </tr>
                
                <tr>    
                    <td>Enter Student ID </td>   
                    <td><form:input path="student_id"  /></td>  
                </tr>
                <tr>    
                    <td>Issue Date </td>   
                    <td><form:input path="issue_date"  /></td>  
                </tr>
               
                <tr>    

                    <td><input type="submit" value="Save" /></td>   
                    <td><input type="reset" name="RESET"></td>
                </tr>    
            </table>
        </form:form> 
    </body>
</html>
