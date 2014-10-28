<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add New Car</title>
</head>
<body>
<div><h1>Add your car to the List</h1></div>
<div style="margin-left: 50px; margin-top: 50px; width: 150px;">
    <form name="input" action="AddCarServlet">
        Registration Number: <input type="text" name="reg"><br>
        Make: 	<select name="make">
        <option value="volvo">Volvo</option>
        <option value="saab">Saab</option>
        <option value="fiat">Fiat</option>
        <option value="audi">Audi</option>
    </select>
        Model: <input type="text" name="model"><br>
        Year: <input type="text" name="year"><br>
        Price: <input type="text" name="price"><br>
        <input type="hidden" name="status" value="0"><br>
        <input type="submit" value="Submit">
    </form>
</div>
</body>
</html>