<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		$(document).ready(function () {
		    //Gender radio checked code
		    if ($("#genderNow").val() === "M") {
		        $("#GenderM").prop("checked", true);
		    }
		    else if ($("#genderNow").val() === "F") {
		        $("#GenderF").prop("checked", true);
		    }
		});
		function checkform(registration2)
        {
            //if (registration2.email.value === "") {
                //alert("Please enter your Email Address.");
                //registration2.email.focus();
                //return false;
            //}
            
            if (registration2.Name.value === "") {
                alert("Please enter your name.");
                registration2.Name.focus();
                return false;
            }

            if (registration2.PassportNo.value === "") {
                alert("Please enter your Passport No.");
                registration2.PassportNo.focus();
                return false;
            }

            if (registration2.ContactNo.value === "") {
                alert("Please enter your Contact No.");
                registration2.ContactNo.focus();
                return false;
            }
            if (registration2.Address.value === "") {
                alert("Please enter your address.");
                registration2.Address.focus();
                return false;
            }

            if (registration2.City.value === "") {
                alert("Please enter your city.");
                registration2.City.focus();
                return false;
            }

            if (registration2.PostalCode.value === "") {
                alert("Please enter your postal code.");
                registration2.PostalCode.focus();
                return false;
            }

            if (registration2.State.value === "") {
                alert("Please enter your state.");
                registration2.State.focus();
                return false;
            }
            return true;
        }
	</script>
</head>
<body style="font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;">
<h2>Edit Profile</h2>
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
		<section style = "height : 720px;background-color:#F3F2F1;">
			<div class="container">
				<form action="./ProfileServlet" method="post" name="updateprofile" onsubmit="return checkform(this)">
		            <div class="row" style = "font-family: Helvetica, Arial, sans-serif;">
		                <div class="col-md-2"></div>
		                <div class="col-md-8 push-top" style="font-family: Helvetica, Arial, sans-serif; margin-top: 35px;">
		                    <p style="color: red;">
		                        ${errorMessage} </p>
		                    <p style="color: blue;">
		                    	${successMessage}
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
		                                    PROFILE
		                                </strong></a>
		                        </div>
		                        <div class="panel-body  collapse in" id="profile">
		                            <table class="table" style = "font-family: Helvetica, Arial, sans-serif;color:black;">
		                                <tr>
		                                    <td>Full Name:</td>
		                                    <td><input type="text" name="Name" id="Name" size="30" maxlength="100" value="${name}" /></td>
		                                </tr>
		                                <tr> 
		                                    <td>ID/Passport No.:</td>
		                                    <td><input id="PassportNo" type="text" name="PassportNo" size="20" maxlength="20" value="${passportNo}" /></td> 
		                                </tr> 
		                                <tr> 
		                                    <td>Contact No.:</td>
		                                    <td><input id="ContactNo" type="text" name="ContactNo" maxlength="20" size="20" value="${contactNo}" /></td> 
		                                </tr>
		                                <tr> 
		                                    <td>Gender:</td>
		                                    <td>
		                                        <input type="hidden" id="genderNow" value="${gender}"/>
		                                        <input type="radio" id="GenderM" name="Gender" value="M" style=
		                                               "background-color: #FFFFFF; border: 1px solid; border-color: #989898; color: black;"/>Male
		                                        <input type="radio" id="GenderF" name="Gender" value="F" style=
		                                               "background-color: #FFFFFF; border: 1px solid; border-color: #989898; color: black;"/>Female
		                                    </td>
		                                </tr> 
		                                <tr> 
		                                    <td>Address:</td>
		                  	              <td><textarea rows="4" cols="25" id="Address" name="Address" maxlength="100">${address}</textarea></td> 
		                                </tr> 
		                                <tr> 
		                                    <td>City / Town: </td>
		                                    <td><input id="City" type="text" name="City" size="25" maxlength="25" value="${city}"/></td> 
		                                </tr> 
		                                <tr> 
		                                    <td>State / Province: </td>
		                                    <td><input id="State" type="text" name="State" size="25" maxlength="25" value="${state}"/></td> 
		                                </tr> 
		                                <tr> 
		                                    <td>Zip / Postal Code: </td>
		                                    <td><input id="PostalCode" type="text" name="PostalCode" size="25" maxlength="25" value="${postalCode}"/></td> 
		                                </tr> 
		                                <tr>
		                                    <td>Country:</td>
		                                    <td>
		                                    <select id="ddCountry" name="ddCountry" style="background-color: #FFFFFF; border: 1px solid; border-color: #989898; color: black; height: 34px; padding: 6px 12px; font-size: 14px; line-height: 1.42857143;">
											    <c:forEach items="${ddCountries}" var="option">
											        <option value="${option.key}" ${countryName == option.value ? 'selected' : ''}>${option.value}</option>
											    </c:forEach>
											</select>
		                                    </td>
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
		                    <p><input type="submit" name="updateprofile" value="Update" class="btn btn-default" /></p>
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