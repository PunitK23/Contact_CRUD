<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>Enter Contact</h2>
	<form:form action="saveContact?contactId=${contact.contactId}" modelAttribute="contact"  method="POST">
		<table>
			<tr>
				<td>Contact Name</td>
				<td><form:input path="contactName"/></td>
				<td><form:errors path = "contactName" /></td>
			</tr>
			<tr>
				<td>Contact Email</td>
				<td><form:input path="contactEmail"/></td>
				<td><form:errors path = "contactEmail" /></td>
			</tr>
			<tr>
				<td>Contact Phno</td>
				<td><form:input path="contactPhno"/></td>
				<td><form:errors path = "contactPhno" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Save" /></td>
			</tr>	
		
		</table>
		
		<p><font color ="green">${succMsg}</font></p>
		<p><font color ="red">${errMsg}</font></p>
		
	</form:form>
		
		<a href="viewContacts">View AllContacts</a>
		

</body>
</html>