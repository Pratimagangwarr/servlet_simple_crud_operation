<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Insert title here</title>

<style>

body{

	font-family:Arial,sans-serif;

	background-color:#f9f9f9;

	margin:0;

	padding:0;

}

h3{

text-align: center;

color: #333;

margin-bottom: 0px;

}

form{

margin-bottom: 10px;

width:200px;

margin:100px auto;

padding:15px;

border: 1px solid #ccc;

border-radius:5px;

background-color: #fff;

}

label{

display: block;

margin:10px 0 5px;

font-weight: bold;

}

input[type="text"],

input[type="email"],

input[type="number"],

input[type="date"],{

width: 100%;

padding:8px;

margin-bottom: 10px;

border: 1px solid #ccc;

border-radius: 4px;

}

input[type="submit"]:hover{

background-color: #45a049;

}

</style>

</head>

<body>



<h3>Registration-Form</h3>

<div>

 <form action="userRegistration" method="get">

<label> USER-ID:</label><br>

<input type="number" placeholder="Enter user id" name="userId"><br>

<label> USER-Name:</label><br>

<input type="text" placeholder="Enter user name" name="userName"><br>

<label> USER-Email:</label><br>

<input type="email" placeholder="Enter user email" name="userEmail"><br>

<label> USER-Password:</label><br>

<input type="password" placeholder="Enter user password" name="password"><br>


<label> USER-DOB:</label><br>

<input type="date"  name="userDOB"><br>

<label> USER-Gender:</label><br>

<input type="radio" name="gender" value="male">Male

<input type="radio" name="gender" value="female">Female<br>

<input type="submit" value="register">

</form>

</div>

</body>

</html>

