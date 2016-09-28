<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<h1>All Devices</h1>
    <table>
			<thead>
				<tr>
					<th>Id</th>
					<th>DeviceName</th>
					<th>Version</th>
					<th>ExpiryDate</th>
					<th>Action</th>
				</tr>
			</thead>
		<c:forEach var="device" items="${deviceList}">
			<tr>
				<td>${device.deviceId}</td>
				<td>${device.deviceName}</td>
				<td>${device.deviceVersion}</td>
				<td>${device.expiryDate }</td>
				<td>
					
					<spring:url value="/home/${device.deviceId}/delete" var="deleteUrl" />
					<spring:url value="/home/${device.deviceId}/update" var="updateUrl" />
	
					<button onclick="location.href='${updateUrl}'">Update</button>
					 <button onclick="location.href='${deleteUrl}'">Delete</button>
	            </td>
			</tr>
		</c:forEach>

</table>

 <spring:url value="/home/adddevice" var="addDevice" />
 <button onclick="location.href='${addDevice}'">AddDevice</button>
</body>
</html>