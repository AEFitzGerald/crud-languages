<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
	<title>Programming Languages</title>	
</head>

<body>
	<div class = "container-sm mx-auto mt-5">
		<h2>Edit programming language...</h2>
		<form:form action="/languages/update/${lang.id}" method="post" modelAttribute="lang">
			<div class="form-group">
				<p>
					<form:label path="languageName">Language</form:label>
					<form:errors path="languageName" class ="text-danger"/>
					<form:input type= "text" path="languageName" class="form-control"/>
				</p>
			</div>
			<div class="form-group">
				<p>
					<form:label path="creator">Creator</form:label>
					<form:errors path="creator" class ="text-danger"/>
					<form:textarea path="creator" class="form-control"/>
				</p>
			</div>
			<div class="form-group">
				<p>
					<form:label path="version">Version</form:label>
					<form:errors path="version" class ="text-danger"/>
					<form:input type= "text" path="version" class="form-control"/>
				</p>
			</div>
			<input type="submit" value="Submit">
		</form:form>	
 	</div><!-- close container -->
</body>
</html>
