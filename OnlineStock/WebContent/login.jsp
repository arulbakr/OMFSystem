<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Online Stock System</title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="icon" href="${pageContext.request.contextPath}/images/icon.png" type="image/png"/>
	<meta name="viewport" content="width=device-width" />
	<meta name="robots" content="index,nofollow,noarchive">
	<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet"/>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
</head>
<body style="font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;">
<div class="body">
	<div id="body" role="main" class="main margin-padding-top">
		<section id="loginForm" style="height : 620px; background-color: #EEEEEE;background-size : 1920px; background-position: center;background-repeat: 
			no-repeat;">
			<div class="container">
				<form method="post" action="LoginServlet">
					<div class="row" style="margin-top: 65px;">
	   					<div class="col-md-4"></div>
	   					<div class="col-md-5"></div>
	   					<div class="col-md-3 push-top push-bottom highlightShadow" style = "font-family: Helvetica, Arial, sans-serif;
	               			padding-top: 5px;padding-bottom: 5px;background-color: rgba(255, 255, 255, 1);">
	           				<h2 class="push-top" style="text-align:center;font-size: 26px;"><strong>Investor Login</strong></h2>
	           				<p class="input-group">
	                        <span class="input-group-addon input-group-sm" id="sizing-addon1">
	                            <span class="glyphicon glyphicon-user" aria-hidden="true"></span>   
	                        </span>
	                        <input aria-describedby="sizing-addon1" class="form-control" tabindex="1"
	                            id="Email" type="text" name="Email" placeholder="Mail ID" size="30" maxlength="45" 
	                            style = "background-color : #FFFFFF;border-style: solid; border-color: #989898;color:black;"
								onfocus="focusFunction()" />
	                    	</p>
	                    	<p class="input-group">
	                        <span class="input-group-addon input-group-sm" id="sizing-addon2">
	                            <span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
	                        </span>
	                        <input aria-describedby="sizing-addon2" class="form-control" tabindex="2"
	                                id="Password" type="password" name="Password" placeholder="Password" size="30" maxlength="45" 
	                                style = "background-color : #FFFFFF;border-style: solid; border-color: #989898;color:black;"/>
	                    	</p>
	                    	<p style="text-align:right;">
	                        	<input class="btn btn-default" type="submit" name="login" value="Log In" tabindex="3"/>
	                    	</p>
                            <p style="color:red;">${not empty errorMessage ? errorMessage : ""}							
                                    </p>
						</div>
					</div>                 				
	          	</form>
			</div>
		</section>
	</div>
</div>
</body>
</html> 