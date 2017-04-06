<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
	<title>Online Stock System</title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="icon" href="${pageContext.request.contextPath}/images/icon.png" type="image/png"/>
	<meta name="viewport" content="width=device-width" />
	<meta name="robots" content="index,nofollow,noarchive">
	<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet"/>
	<script src="${pageContext.request.contextPath}/scripts/jquery-3.1.1.js"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript">
		function toggle()
	    {
	        if (document.getElementById('toggle').className === "glyphicon glyphicon-plus") {
	            document.getElementById('toggle').className = "glyphicon glyphicon-minus";
	        } else if (document.getElementById('toggle').className === "glyphicon glyphicon-minus") {
	            document.getElementById('toggle').className = "glyphicon glyphicon-plus";
	        }
	    }
	</script>
</head>
<body style="font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;">
<h2>View Profile</h2>
<!-- Header -->
<nav class="navbar navbar-default navbar-fixed-top">
    <!-- <div class="container"> -->
    	<div class="container-fluid" style="padding-left: 0px; padding-right: 0px; background-color: #081a3d;">
            <div class="container">
                <div class="collapse navbar-collapse" id="oc-sub-navbar" style="padding-left: 7px; padding-right: 7px;">
                	<ul class="nav navbar-nav navbar-left navbar-nav-2" style="font-size: 12px;font-family: Helvetica,Arial,sans-serif;">
						<li style="padding-left:9px;padding-right:9px;padding-top:15px;padding-bottom:2px;color:#fff;font-size:12px;">
                            <img alt="Omf - system" src="${pageContext.request.contextPath}/images/iconSmall.png">
						</li>
					</ul>
                    <ul class="nav navbar-nav navbar-left navbar-nav-2" style="font-size: 12px;font-family: Helvetica,Arial,sans-serif;">
						<li style="padding-left:9px;padding-right:9px;padding-top:15px;padding-bottom:2px;color:#fff;font-size:12px;">
                            Welcome ${FullName} 
						</li>
					</ul>
					<ul class="nav navbar-nav navbar-right navbar-nav-2" style="font-size: 12px; font-family: Helvetica, Arial, sans-serif;">
                        <li style="padding-left: 9px; padding-right: 9px; padding-top: 2px; padding-bottom: 2px;">
                            <a style="padding-left: 7px; padding-right: 7px;" href="./HomeServlet" class="dropdown-toggle" role="button" aria-haspopup="true" aria-expanded="false">
                                HOME </a>
                        </li>
                        <li style="padding-left: 9px; padding-right: 9px; padding-top: 2px; padding-bottom: 2px;">
                            <a style="padding-left: 7px; padding-right: 7px;" href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                TRANSACTION <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a style="padding-left: 9px; padding-right: 7px; padding-top: 5px; padding-bottom: 5px;" href="./BuyingServlet">Buy</a></li>
                                <li><a style="padding-left: 9px; padding-right: 7px; padding-top: 5px; padding-bottom: 5px;" href="./RedeemingServlet">Redeem</a></li>
                            </ul>
                        </li>
                        <li style="padding-left: 9px; padding-right: 9px; padding-top: 2px; padding-bottom: 2px;">
                            <a style="padding-left: 7px; padding-right: 7px;" href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                PROFILE <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a style="padding-left: 9px; padding-right: 7px; padding-top: 5px; padding-bottom: 5px;" href="./ProfileServlet">Profile Settings</a></li>
                            </ul>
                        </li>
                        <li style="padding-left: 9px; padding-right: 9px; padding-top: 2px; padding-bottom: 2px;">
                            <a style="padding-left: 7px; padding-right: 7px;" href="./LoginServlet" class="dropdown-toggle"  aria-haspopup="true" aria-expanded="false" role="button" >
                                LOGOUT</a>
                        </li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div>
        </div>
    <!-- </div> -->
</nav>
<div class="body">
	<div id="body" role="main" class="main margin-padding-top">
		<section style = "height : 620px;background-color:#F3F2F1;">
			<div class="container">
				<div class="row" style = "font-family: Helvetica, Arial, sans-serif;">
		            <div class="col-md-2"></div>
		            <div class="col-md-8" style = "font-family: Helvetica, Arial, sans-serif;color:black;" >
		                <div class="panel panel-default  push-top">
		                    <div class="panel-heading">
		                        <a href="#profile" data-toggle="collapse" style="color:black;text-decoration: none;"  onclick="toggle()">
		                            <span id="toggle"  class="glyphicon glyphicon-minus" aria-hidden="true"></span> <strong>
                                       PROFILE             	
		                            </strong></a>
		                    </div>
		                    <div class="panel-body  collapse in" id="profile">
		
		                        <table class="table" style = "font-family: Helvetica, Arial, sans-serif;color:black;">
		                            <tr> 
		                                <td><strong>Name:</strong></td> 
		                                <td>${name}</td> 
		                            </tr>
		                            <tr> 
		                                <td><strong>ID/Passport No.:</strong></td> 
		                                <td>${passportNo}</td> 
		                            </tr>
		                            <tr> 
		                                <td><strong>Contact No.:</strong></td> 
		                                <td>${contactNo}</td> 
		                            </tr>
		                            <tr> 
		                                <td><strong>Gender:</strong></td> 
		                                <td>${genderText}</td> 
		                            </tr>
		                            <tr> 
		                                <td><strong>Address:</strong></td> 
		                                <td>${address}</td> 
		                            </tr>
		                            <tr> 
		                                <td><strong>City / Town:</strong></td> 
		                                <td>${city}</td> 
		                            </tr>
		                            <tr> 
		                                <td><strong>State / Province:</strong></td> 
		                                <td>${state}</td> 
		                            </tr>
		                            <tr> 
		                                <td><strong>Zip / Postal Code:</strong></td> 
		                                <td>${postalCode}</td> 
		                            </tr>
		                            <tr> 
		                                <td><strong>Country:</strong></td> 
		                                <td>${countryName}</td> 
		                            </tr>
		                        </table>
		                    </div>
		                </div>
		            </div>
		            <div class="col-md-2"></div>
		        </div>
		        <div class="row" style = "font-family: Helvetica, Arial, sans-serif;">
		            <div class="col-md-2"></div>
		            <div class="col-md-8 push-top" style = "font-family: Helvetica, Arial, sans-serif;" >
		                <p><a href="./ProfileServlet?edit=1" class="btn btn-default">Update Details</a></p>
		            </div>
		            <div class="col-md-2"></div>
		        </div>
			</div>
		</section>
	</div>
</div>
</body>
</html>