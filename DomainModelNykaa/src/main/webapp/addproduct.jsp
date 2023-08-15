<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="position: relative; left: 450px; top: 100px">
<form action=" addProductServlet">
Enter name<input type="text" name="name"><br><br>
Enter productId<input type="text" name="productId"><br><br>
Enter Category
<select name="category" id="category">
<option value="Makeup">Makeup</option>
<option value="Skin care">Skin care</option>
<option value="Hair care">Hair care</option>
<option value="Appliances">Appliances</option>
</select><br><br>
Enter price<input type="text" name="price"><br><br>
Enter offer<input type="text" name="offer"><br><br>

<input type="submit" value="add">
</div>
</form>
</body>
</html>