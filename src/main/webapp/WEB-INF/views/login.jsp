<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html><h1>Login Here</h1></html>
<form:form modelAttribute="user" method="post" action="login">
     <spring:bind path="username">
       <label>User Name:</label>
       <form:input path="username" type="text" id="name" placeholder="abcd"/>
       <form:errors path="username"/>  
     </spring:bind>
    
     <spring:bind path="password">
          <label>Password:</label>    
          <form:input path="password" type="password" id="password"/>
          <form:errors path="password"/>
     </spring:bind>
     <form:button>login</form:button>

</form:form>