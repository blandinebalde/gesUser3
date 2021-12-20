<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <c:set var="APP_ROOT" value="/GesUser2"></c:set>
   
<!DOCTYPE html>
<html lang="en">
<head>
	<title>GesUser | Login</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!--===============================================================================================-->
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--=================================== Footer ============================================================-->
	
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="css/style.css">
    
<!--===============================================================================================-->
</head>
<body>

<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
  <div class="container-fluid">
    <a class="navbar-brand" href='${APP_ROOT }'>Connexion</a> 
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="true" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
   
    	
   </div>
</nav>
<div class="container">
<c:if test="${ !empty param.login }">
		<div id="statusBoxMessage" class="alert alert-danger">
			<span id="control" onclick="hideMessageBox()" title="fermer">x</span>
			Echec de l'authentification : login ou mot passe incorrect !
		</div>
		
</c:if>
		<div class="row align-items-center">
		  	<div class="col">
				<div class="card">
				  
				  <div class="card-body">
					<div class="container-contact100">
						<div class="wrap-contact100">
							<form class="contact100-form validate-form" method="post" action="/GesUser3/login">
								<span class="contact100-form-title">
									Connexion
								</span>
				
								<div class="wrap-input100 validate-input" data-validate="Name is required">
									<span class="label-input100">Username</span>
									<input class="input100" type="text" name="username" placeholder="@Username" value ='<c:out value="${param.login}"></c:out>'>
									<span class="focus-input100"></span>
								</div>
				
								<div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
									<span class="label-input100">Password</span>
									<input class="input100" type="password" name="password" placeholder="@password">
									<span class="focus-input100"></span>
								</div>
				
								<div class="container-contact100-form-btn">
									<div class="wrap-contact100-form-btn">
										<div class="contact100-form-bgbtn"></div>
										<button class="contact100-form-btn">
											<span>
												Submit
												<i class="fa fa-long-arrow-right m-l-7" aria-hidden="true"></i>
											</span>
										</button>
									</div>
								</div>
							</form>
						</div>
					</div>
			
					
				</div>
				
				</div>
			
			</div>
		  </div>
</div>			  
	
	
   
<div class="footer-dark">
        <footer>
                <div class="col item social"><a href="#"><i class="icon ion-social-facebook"></i></a><a href="#"><i class="icon ion-social-twitter"></i></a><a href="#"><i class="icon ion-social-snapchat"></i></a><a href="#"><i class="icon ion-social-instagram"></i></a></div>
                <p class="copyright">Buil with &heartsuit; by blandiine &middot; ©  2021</p>
            
        </footer>
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>

</body>
</html>
