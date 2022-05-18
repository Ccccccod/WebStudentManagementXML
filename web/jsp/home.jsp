<%-- 
    Document   : home
    Created on : Mar 28, 2021, 1:14:17 PM
    Author     : MR TU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/home.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="content">
            <form action="HomeController" method="POST">
                <ul class="form">
                    <li>
                        <label>ID </label>
                        <input type="email" name="id" class="field-long" />
                    </li>
                    <li>
                        <label>Name </label>
                        <input type="email" name="name" class="field-long" />
                    </li>
                    <li>
                        <label>DOB </label>
                        <input type="email" name="dob" class="field-long" />
                    </li>
                    <li>
                        <label>Address </label>
                        <input type="email" name="address" class="field-long" />
                    </li>
                    <li>
                        <label>Email </label>
                        <input type="email" name="email" class="field-long" />
                    </li>
                    <li>
                        <label>Phone </label>
                        <input type="email" name="phone" class="field-long" />
                    </li>
                    <li>
                        <input type="submit" name="show" value="Add" />
                    </li>
                    <li>
                        <input type="submit" name="show" value="Update" />
                    </li>
                    <li>
                        <input type="submit" name="show" value="Delete" />
                    </li>
                    <li>
                        <input type="submit" name="show" value="Search" />
                    </li>
                    <li>
                        <input type="submit" name="show" value="Show" />
                    </li>
                </ul>
            </form>
        </div>
    </body>
</html>
