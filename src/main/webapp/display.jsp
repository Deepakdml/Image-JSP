<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Display Images</title>
    <style>
    h1{
    	text-align : center;
    }
    </style>
</head>
<body>
    <h1>Images</h1>
    <%
        List<byte[]> imagesList = (List<byte[]>) request.getAttribute("imagesList");
        for (byte[] imageBytes : imagesList) {
            String base64Image = java.util.Base64.getEncoder().encodeToString(imageBytes);
    %>
            <img src="data:image/jpeg;base64,<%= base64Image %> " height=250px margin=10px/>
    <%
        }
    %>
</body>
</html>
