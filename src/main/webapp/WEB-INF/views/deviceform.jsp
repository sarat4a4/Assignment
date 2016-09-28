<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<form:form modelAttribute="device" method="post" action="/Assignment/home/adddevice" commandName="device">  
     
     //<form:hidden path="deviceId" id="name" placeholder="abcd"/>
     <spring:bind path="deviceName">
       <label>device Name:</label>
       <form:input path="deviceName" id="name" placeholder="abcd"/>
       <form:errors path="deviceName"/>  
     </spring:bind>
     
     <spring:bind path="deviceVersion">
       <label>Version:</label>
       <form:input path="deviceVersion" id="version" placeholder="123"/>
       <form:errors path="deviceVersion"/>  
     </spring:bind>
    
     
          <label>Date:</label>    
          <input type="date" name="expiryDate"/>
          
       
      <form:button type="submit">AddDevice</form:button>

</form:form>