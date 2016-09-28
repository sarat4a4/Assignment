<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<body>
<h1>User Detail</h1>
<div >
	<label >ID</label>
    <div>${device.id}</div>
</div>
<div >
	<label >DeviceName</label>
    <div>${device.deviceName}</div>
</div>
<div >
	<label >Version</label>
    <div>${device.version}</div>
</div>
<div >
	<label >Expiry Date</label>
    <div>${device.expiryDate}</div>
</div>

	
</body>
</html>