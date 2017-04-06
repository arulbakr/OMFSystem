<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
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
		function checkform(){
			if($("#ddFundType").val() === "0"){
				alert("Please select a fund.");
				return false;
			}
			if($("#Amount").val() === "" || $("#Amount").val() < 1000){
				alert("Please enter some amount not less than $1000.");
				return false;
			}
			return true;
		}
	</script>
</head>
<body>
<body style="font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;">
<h2>Home</h2>
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
				<form action="./BuyingServlet" method="post" name="transactionForm" onsubmit="return checkform()">
		            <div class="row" style = "font-family: Helvetica, Arial, sans-serif;">
		                <div class="col-md-2"></div>
		                <div class="col-md-8 push-top" style="font-family: Helvetica, Arial, sans-serif; margin-top: 35px;">
		                    <p style="color: red;">
		                        ${not empty errorMessage ? errorMessage : ""} </p>
		                    <p style="color: blue;">
		                    	${not empty successMessage ? successMessage : ""}
		                    </p>
		                </div>
		                <div class="col-md-2"></div>
		            </div>
		            <div class="row" style = "font-family: Helvetica, Arial, sans-serif;">
		                <div class="col-md-2"></div>
		                <div class="col-md-8" style = "font-family: Helvetica, Arial, sans-serif;color:black;" >
		                    <div class="panel panel-default  push-top">
		                        <div class="panel-heading">
		                            <a href="#profile" data-toggle="collapse" style="color:black;text-decoration: none;"  onclick="toggle()">
		                                <span id="toggle"  class="glyphicon glyphicon-minus" aria-hidden="true"></span> <strong>
		                                    Buy Fund
		                                </strong></a>
		                        </div>
		                        <div class="panel-body  collapse in" id="profile">
		                            <table class="table" style = "font-family: Helvetica, Arial, sans-serif;color:black;">
		                                <tr>
		                                    <td>Fund:</td>
		                                    <td>
		                                    <select id="ddFundType" name="ddFundType" style="background-color: #FFFFFF; border: 1px solid; border-color: #989898; color: black; height: 34px; padding: 6px 12px; font-size: 14px; line-height: 1.42857143;">
											    <c:forEach items="${ddFundTypes}" var="option">
											        <option value="${option.key}">${option.value}</option>
											    </c:forEach>
											</select>
		                                    </td>
		                                </tr>
		                                <tr> 
		                                    <td>Amount:</td>
		                                    <td><input id="Amount" type="text" name="Amount" maxlength="20" size="20" /></td> 
		                                </tr>
		                            </table>
		                        </div>
		                    </div>
		                </div>
		                <div class="col-md-2"></div>
		            </div>
		            <div class="row" style = "font-family: Helvetica, Arial, sans-serif;">
		                <div class="col-md-2"></div>
		                <div class="col-md-8 push-bottom push-top" style = "font-family: Helvetica, Arial, sans-serif;" >
		                    <p><input type="submit" name="buyFund" value="Buy" class="btn btn-default" /></p>
		                </div>
		                <div class="col-md-2"></div>
		            </div>
	            </form>
			</div>
		</section>
	</div>
</div>
</body>
</html>