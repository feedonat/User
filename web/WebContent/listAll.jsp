<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>user List</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
 <link href="css/bootstrap.css" rel="stylesheet">
 <script src="js/bootstrap.min.js"></script>
 <script src="js/bootstrap.js"></script>
</head>
<body>
<div class="row col-md-8 col-md-offset-2">
            <br>
             <a href="/web/addNew.html" class="btn btn-primary btn-xs pull-left"><b>+</b> Add New User</a><br>
            
            <table class="table table-striped custab">
            
                <tr>
                    <th>full name</th>
                    <th>username</th>
                    <th>role</th>
                    <th>address</th>
                    <th>email</th>
                    <th>Action</th>
                </tr>
                <c:forEach items="${userlist}" var="p">
                    <tr>
                        <td>${p.fullname}</td>
                        <td>${p.username}</td>
                        <td>${p.role}</td>
                        <td>${p.address}...</td>
                        <td>${p.email}</td>
                        <td>
                         <a class='btn btn-info btn-xs' href="editPage?username=${p.username}"><span class="glyphicon glyphicon-edit"></span> Edit</a> <a href="deleteUser?username=${p.username}" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>


</body>
</html>