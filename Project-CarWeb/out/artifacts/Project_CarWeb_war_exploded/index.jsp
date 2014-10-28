<%--
  Created by IntelliJ IDEA.
  User: lmanuelcb
  Date: 10/25/2014
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
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
    <form name="input" action="">
        Make: 	<select name="make">
        <option value="volvo">Volvo</option>
        <option value="saab">Saab</option>
        <option value="fiat">Fiat</option>
        <option value="audi">Audi</option>
    </select>
        Model: <input type="text" name="model"><br>
        Year: <input type="text" name="year"><br>
        Engine Size: <input type="text" name="enginesize"><br>
        <input type="radio" name="fuel" value="diesel">Diesel<br>
        <input type="radio" name="fuel" value="petrol">Petrol<br>
        Price: <input type="text" name="price"><br>
        Other Info: <input type="text" name="otherinfo"><br>
        <input type="submit" value="Submit">
    </form>
</div>
</body>
</html>
