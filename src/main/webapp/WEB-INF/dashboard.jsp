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
		<h1>Programming Languages</h1>
		<table class="table">
    		<thead>
        		<tr scope="row">
            		<th scope="col">Language</th>
            		<th scope="col">Creator</th>
            		<th scope="col">Version</th>
            		<th scope="col">Actions</th>
        		</tr>
    		</thead>
    		<tbody>
        		<c:forEach items="${allLang}" var="lang">
        		<tr scope="row">
            		<td scope="col"><a href="/languages/{id}"><c:out value="${lang.languageName}"/></a></td>
            		<td scope="col"><c:out value="${lang.creator}"/></td>
           			<td scope="col"><c:out value="${lang.version}"/></td>
            		<td scope="col"><a href="/languages/edit/${lang.id}">Edit </a><span>|</span><a href="/languages/delete/${lang.id}"> Delete</a></td>
        		</tr>
        		</c:forEach>
    		</tbody>
		</table>
		
		
		<h2 class="mt-5">Add a programming language...</h2>
		<form:form action="/languages/create" method="post" modelAttribute = "newLang">
			<div class="form-group my-3">
				<form:label path="languageName">Language</form:label>
				<form:errors path="languageName" class ="text-danger"/>
				<form:input type= "text" path="languageName" class="form-control"/>
			</div>
			<div class="form-group my-3">
				<form:label path="creator">Creator</form:label>
				<form:errors path="creator" class ="text-danger"/>
				<form:textarea path="creator" class="form-control"/>
			</div>
			<div class="form-group my-3">
				<form:label path="version">Version</form:label>
				<form:errors path="version" class ="text-danger"/>
				<form:input type= "text" path="version" class="form-control"/>
			</div>
			<input type="submit" value="Submit" class="my-5">
		</form:form>
		
 	</div><!-- close container -->
</body>
</html>
