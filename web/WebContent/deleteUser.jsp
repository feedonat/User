<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
 <link href="css/bootstrap.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>delete user</title>
</head>
<body>
<h3 align="center">Delete User</h3>
       
        
                   <c:forEach items="${user}" var="p">
                <form action="deleteUser" method="post" class="form-horizontal">
                   
                   <div class="form-group">
  <label class="col-md-4 control-label" for="username">User Name :</label>  
  <div class="col-md-4">
  <input id="username" name="username" type="text" class="form-control input-md" value="${p.username}">
    
  </div>
</div>
 <div class="form-group">
  <label class="col-md-4 control-label" for="password">Password :</label>  
  <div class="col-md-4">
  <input  name="password" type="text" class="form-control input-md" value="${p.password}">
    
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="role">Select Role :</label>
  <div class="col-md-4">
    <select id="role" name="role" class="form-control">
    <option value="${p.role}">${p.role}</option>
      <option value="Admin">Admin</option>
      <option value="user">user</option>
      <option value="Staff">Staff</option>
      <option value="other">other</option>
    </select>
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="fullname">Full Name :</label>  
  <div class="col-md-4">
  <input  name="fullname" type="text" class="form-control input-md" value="${p.fullname}">
    
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="address">Address :</label>  
  <div class="col-md-4">
  <input  name="address" type="text" class="form-control input-md" value="${p.address}">
    
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="email">Email :</label>  
  <div class="col-md-4">
  <input  name="email" type="text" class="form-control input-md" value="${p.email}"><br>
    <button  class="btn btn-danger">Delete user</button>
  </div>
</div>
 
</form>
            </c:forEach>
       
</body>
</html>