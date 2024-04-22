<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
    font-family: Arial, sans-serif;
    background-color: black;
    margin: 0;
    padding: 0;
}

.container {
    width: 800px;
    margin: 50px auto;
    background-color: grey;
    padding: 20px;	
    border-radius: 5px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

h1 {
    text-align: center;
}

.form-group {
    margin-bottom: 20px;
}

label {
    display: block;
    margin-bottom: 5px;
}

input[type="file"] {
    border: 1px solid #ccc;
    border-radius: 3px;
    padding: 5px;
    width: 100%;
}

.btn {
    background-color: #007bff;
    color: #fff;
    border: none;
    padding: 10px 20px;
    border-radius: 3px;
    cursor: pointer;
    margin:10px;
    min-width: 130px;
}

.btn:hover {
    background-color: #0056b3;
}


h3{
color: green;
margin-top: 20px;
}

</style>
<meta charset="UTF-8">
<title>RK Image</title>
</head>
<body>
    <div class="container">
        <h1>Upload & Display Images using JSP</h1>
        <form action="ServletCon" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="file">Select image to upload:</label>
                <input type="file" name="file" id="file">
            </div>		
            <input type="submit" value="↑ Upload Image" name="submit" class="btn">
        </form>				
        <form action="DisplayImage" method="post">
            <input type="submit" value="👁 Show Image" name="submit" class="btn">
        </form>					
        <h3><% if(request.getParameter("message") != null) { %>
    <%= request.getParameter("message") %>
<% } %> </h3> 
    </div>
    				
    
</body>
</html>
