<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">          
    <a class="navbar-brand" href='<c:url value = "/Acceuil"/>'>Acceuil</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <c:choose>
        	<c:when test="${ empty sessionScope.utilisateur }">
        		<li class="nav-item">
		          <a class="nav-link" href='<c:url value = "/login"/>'>Connexion</a>
		        </li>
		          
        	</c:when>
        	<c:otherwise>
        		<li class="nav-item">
		          <a class="nav-link" href='<c:url value = "/Ajout"/>'>Ajouter un utilisateur</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href='<c:url value = "/logout"/>'>Deconnexion</a>
		        </li>
        	</c:otherwise>
        </c:choose>
        
        
      </ul>
      
    </div>
  </div>
</nav>