<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<c:set var="APP_ROOT" value="/GesUser3"></c:set>

   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>GesUser | Acceuil</title>

	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="css/style.css">
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    
</head>
<body>
<c:import url="entete.jsp"></c:import>

<div class="container">
  <div class="row align-items-start">
    <div class="col">
    </div>
    <div class="col ">
		<h1><span class="badge bg-secondary">Gestion des Utilisateurs </span></h1>
    </div>
    <div class="col">
    </div>
  </div>
  <div class="row align-items-center">
  	<div class="col">
  	<c:choose>
  		<c:when test="${!empty requestScope.user}">
  			<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">Id</th>
		      <th scope="col">Nom</th>
		      <th scope="col">Prenom</th>
		      <th scope="col">Username</th>
		      <th scope="col">Password</th>
		      <th scope="col">Action</th>
		      <th scope="col">Action</th>
		    </tr>
		  </thead>
		  <tbody>
    		<c:forEach items="${requestScope.user}"  var="u">
				    <tr>
				      <th scope="row"><c:out value="${u.id}"></c:out></th>
				      <td><c:out value="${u.nom }"></c:out></td> 
				      <td><c:out value="${u.prenom }"></c:out></td>
				      <td><c:out value="${u.username }"></c:out></td>
				      <td><c:out value="${u.password }"></c:out></td>
				      <td><a class="op"  href="${APP_ROOT}/update?id=${u.id }" >Modifier</a></td>
				      <td><a class="op" href="${APP_ROOT}/delete?id=${u.id}">Supprimer</a></td>
				    </tr>
				   
		    </c:forEach>
		  </tbody>
		</table>
  		</c:when>
  		<c:otherwise>
				<div class="col ">
					<h1><span class="badge bg-secondary">Le tableau est vide</span></h1>
    			</div>  		
    	</c:otherwise>
  	</c:choose>
  		
  	
  	
  		
    </div>
		  
  </div>
  
</div>


<c:import url="pied.jsp"></c:import>
</body>
</html>