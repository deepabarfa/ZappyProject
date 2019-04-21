<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-client_id" content="739662502499-lord64ar5nj7b1irpm4k438b3ls8p8oh.apps.googleusercontent.com">
<title>Insert title here</title>

<style type="text/css">

$shadow1 : 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);
$shadow2 : 0 3px 6px rgba(0,0,0,0.16), 0 3px 6px rgba(0,0,0,0.23);
$shadow3 : 0 10px 20px rgba(0,0,0,0.19), 0 6px 6px rgba(0,0,0,0.23);
$shadow4 : 0 14px 28px rgba(0,0,0,0.25), 0 10px 10px rgba(0,0,0,0.22);
$shadow5 : 0 19px 38px rgba(0,0,0,0.30), 0 15px 12px rgba(0,0,0,0.22);

*, *:before, *:after {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	color: white;
	display: flex;
	padding: 20px;
	min-height: 100vh;
	position: relative;
	flex-direction: column;
	justify-content: center;
	font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
	background-color: #a06060;
	background: linear-gradient(130deg, #a06060 20%, #aaa 100%) no-repeat center center fixed;
}

.box {
	width: 100%;
	margin: auto;
	padding: 10px;
	max-width: 400px;
	border-radius: 2px;
	box-shadow: $shadow2;
	background-color: rgba(0,0,0,0.2);
}

h1 {
	font-weight: 100;
	letter-spacing: 1px;
	margin: 10px 0 20px 10px;
}

.input-group {
	font-size: 22px;
	padding: 5px 10px;
	padding-top: 30px;
	position: relative;
	border-radius: 2px;
	margin-bottom: 10px;
	box-shadow: $shadow1;
	background-color: rgba(0,0,0,0.1);
	
	input {
		width: 100%;
		border: none;
		outline: none;
		display: block;
		font-weight: 300;
		letter-spacing: 1px;
		background-color: transparent;
		
		&:focus,
		&.active {
			+ label {
				top: 5px;
				left: 5px;
				font-size: 16px;
			}
		}
	}
	
	label {
		top: 30px;
		left: 10px;
		opacity: 0.7;
		font-weight: 100;
		position: absolute;
		letter-spacing: 2px;
		pointer-events: none;
		transition: all 0.2s ease-in;
	}
}

input[type="submit"] {
	border: none;
	float: right;
	outline: none;
	padding: 10px;
	font-weight: 300;
	border-radius: 2px;
	letter-spacing: 1px;
	box-shadow: $shadow1;
	text-transform: uppercase;
	background-color: rgba(255,255,255,0.2);
	transition: all 0.2s ease-in;
	
	&:hover,
	&:focus {
		box-shadow: $shadow3;
	}
	
</style>

</head>
<body>
<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<script>
function checkInput(input) {
	if (input.value.length > 0) {
		input.className = 'active';
	} else {
		input.className = '';
	}
}
</script>

<center>
<h1>
<%
String s=(String)request.getAttribute("msg");
if(s!=null)
	out.print(s);
%></h1>
<h1><%
String s1=(String)request.getAttribute("msg1");
if(s1!=null)
	out.print(s1);
%></h1>
<div class="box">
	<h1>Welcome to Customer Login</h1>
	<form action="CustomerController" method="post">
		<div class="input-group">
			<input type="text" name="email" id="username" autocomplete="off" onblur="checkInput(this)" required/>
			<label for="username">Username</label>
		</div>
		<div class="input-group">
			<input type="password" name="password" id="password" onblur="checkInput(this)" required/>
			<label for="password">Password</label>
		</div>
		<input type="submit" value="Enter" />
		<h3><a href ="Forgetpassword.jsp">Forget Password</a></h3>
        <h3><a href ="registration.jsp">Sign up</a></h3>
	</form><p1>
<form action="index.jsp" method="get">
<input type="submit" value="cancel" />

</form>
<fb:login-button scope="public_profile,email" onlogin="checkLoginState();">
</fb:login-button>

<div class="g-signin2" data-onsuccess="onSignIn" id="myP"></div>
<img id="myImg"><br>
<p id="name"></p>  
</p1>
<br/><br/></div>

<script>
  // This is called with the results from from FB.getLoginStatus().
  function statusChangeCallback(response) {
    console.log('statusChangeCallback');
    console.log(response);
    // The response object is returned with a status field that lets the
    // app know the current login status of the person.
    // Full docs on the response object can be found in the documentation
    // for FB.getLoginStatus().
    if (response.status === 'connected') {
      // Logged into your app and Facebook.
      testAPI();
    } else {
      // The person is not logged into your app or we are unable to tell.
      document.getElementById('status').innerHTML = 'Please log ' +
        'into this app.';
    }
  }

  // This function is called when someone finishes with the Login
  // Button.  See the onlogin handler attached to it in the sample
  // code below.
  function checkLoginState() {
    FB.getLoginStatus(function(response) {
      statusChangeCallback(response);
    });
  }

  window.fbAsyncInit = function() {
  FB.init({
    appId      : '204340146780010',
    cookie     : true,  // enable cookies to allow the server to access 
                        // the session
    xfbml      : true,  // parse social plugins on this page
    version    : 'v2.8' // use graph api version 2.8
  });

  // Now that we've initialized the JavaScript SDK, we call 
  // FB.getLoginStatus().  This function gets the state of the
  // person visiting this page and can return one of three states to
  // the callback you provide.  They can be:
  //
  // 1. Logged into your app ('connected')
  // 2. Logged into Facebook, but not your app ('not_authorized')
  // 3. Not logged into Facebook and can't tell if they are logged into
  //    your app or not.
  //
  // These three cases are handled in the callback function.

  FB.getLoginStatus(function(response) {
    statusChangeCallback(response);
  });

  };

  // Load the SDK asynchronously
  (function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "https://connect.facebook.net/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'facebook-jssdk'));

  // Here we run a very simple test of the Graph API after login is
  // successful.  See statusChangeCallback() for when this call is made.
  function testAPI() {
    console.log('Welcome!  Fetching your information.... ');
    FB.api('/me', function(response) {
//FB.api( '/me?fields=id,name,about,age_range,bio,birthday,email', 'get', { access_token : "663296514059578|3XiCB_NjOoRu9XgFgXqx3rXITnY" },function(response) { 
	   //Handle Data Here it will arrive in a Json object in the response 
   //}
 	   
	console.log('Successful login for: ' + response.id);
    console.log('Successful login for: ' + response.name);
    console.log('Successful login for: ' + response.email);
    console.log('Successful login for: ' + response.about);
    console.log('Successful login for: ' + response.age_range);
    console.log('Successful login for: ' + response.bio);
    console.log('Successful login for: ' + response.birthday);
    var email=response.email;
    var name=response.name;
    var about=response.about;
    
//      document.getElementById('status').innerHTML ='<p> Welcome '+response.name+'<a href=fblog.jsp?user_name='+response.name+'>Check</a>';
    window.location = 'http://localhost:8080/FileUploadDemo/CHome.jsp';  
    
    //  'Thanks for logging in, ' + response.name + '!';
    });
  }
</script>




<script type="text/javascript">
			function onSignIn(googleUser) {
			// window.location.href='success.jsp';

				
			
				  var profile = googleUser.getBasicProfile();
				  var imagurl=profile.getImageUrl();
				  var name=profile.getName();
				  var email=profile.getEmail();
				     document.getElementById("myImg").src = imagurl;
				  document.getElementById("name").innerHTML = name;

				  document.getElementById("myP").style.visibility = "hidden";
				  
 
				  document.getElementById("status").innerHTML = 'Welcome '+name+'!<a href=CHome.jsp?email='+email+'&name='+name+'/>Continue with Google login</a></p>'

				   
				   
			 }
</script>

<button onclick="myFunction()">Sign Out</button>

<script>
function myFunction() {
	gapi.auth2.getAuthInstance().disconnect();
    location.reload();
}
</script>

</body>
</html>