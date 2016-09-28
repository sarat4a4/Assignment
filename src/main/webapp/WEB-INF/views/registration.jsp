<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html><h1>SignUp Form</h1></html>
<form:form modelAttribute="user" method="post" action="signup" commandName="user">
     <spring:bind path="userName">
       <label>User Name:</label>
       <form:input path="userName" type="text" id="name" placeholder="abcd"/>
       <form:errors path="userName"/>  
     </spring:bind>
     
     <spring:bind path="phoneNumber">
       <label>phone Number:</label>
       <form:input path="phoneNumber" type="text" id="name" placeholder="12345"/>
       <form:errors path="phoneNumber"/>  
     </spring:bind>
    
     <spring:bind path="password">
          <label>Password:</label>    
          <form:input path="password" type="password" id="password"/>
          <form:errors path="password"/>
     </spring:bind>

      <form:button type="submit" value="Submit">SignUp</form:button>

</form:form>