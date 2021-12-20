<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<c:set var="APP_ROOT" value="/GesUser2"></c:set>
<!DOCTYPE html>
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

<c:if test="${!empty form }">
		<div id="statusBoxMessage" class="alert alert-${fomr.status ? 'succes' : 'danger'  }">
			<span id="control" onclick="hideMessageBox()" title="fermer">x</span>
			${ form.statusMessage }
		</div>
</c:if>

  <div class="row align-items-start">
    <div class="col">
    </div>
    <div class="col ">
		<h1><span class="badge bg-secondary">Modifier Utilisateur </span></h1>
    </div>
    <div class="col">
    </div>
  </div>
  <div class="row align-items-center">
  	<div class="col">
		<div class="card">
		  <div class="card-header">
		    Featured
		  </div>
		  <div class="card-body">
		  <c:if test="${!empty requestScope.user}">
			<form class="row g-3" method="post" action="/GesUser3/update">
			  <div class="col-md-6">
			    <label for="inputEmail4" class="form-label">Nom</label>
			    <input type="text" class="form-control" id="inputEmail4" placeholder="@nom" name ="nom" value="<c:out value="${user.nom}  " default=" ${form.utilisateur.nom }"></c:out>">
			  	<span style="color : red">${ form.erreurs.nom }</span>
			  	
			  </div>
			  <div class="col-md-6">
			    <label for="inputPassword4" class="form-label">Prenom</label>
			    <input type="text" class="form-control" id="inputPassword4" placeholder="@prenom" name = "prenom" value="<c:out value="${user.prenom}"></c:out>">
			  			    <span style="color : red">${ form.erreurs.prenom }</span>
			  
			  </div>
			  <div class="col-md-6">
			    <label for="inputAddress" class="form-label">Username</label>
			    <input type="text" class="form-control" id="inputAddress" placeholder="@username" name ="username"  value="<c:out value="${user.username}"></c:out>">
			  			    <span style="color : red">${ form.erreurs.username }</span>
			  
			  </div>
			  <div class="col-md-6">
			    <label for="inputAddress" class="form-label">Password</label>
			    <input type="password" class="form-control" id="inputAddress" placeholder="@pwd" name ="pwd" >
			    			    <span style="color : red">${ form.erreurs.pwd }</sp an>
			    
			  </div>			  
			  <div class="col-12">
			    <button type="submit" class="btn btn-primary">Modifier</button>
			  </div>
			</form>
		</c:if>
		</div>
		
		</div>
	
	</div>
  </div>
		  
  </div>
  
<c:import url="pied.jsp"></c:import>
</body>
</html>