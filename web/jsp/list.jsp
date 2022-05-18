<%-- 
    Document   : list
    Created on : Mar 28, 2021, 2:30:24 PM
    Author     : MR TU
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/list.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>

        <div>
            <c:forEach items="${list}" var="i">
                <div class="all">
                    <div class="item">
                        <h2 class="name">${i.name}</h2>
                        <p class="attribute">ID: ${i.id}</p>
                        <p class="attribute">DOB: ${i.dob}</p>
                        <p class="attribute">Address: ${i.address}</p>
                        <p class="attribute">Email: ${i.email}</p>
                        <p class="attribute">Phone: ${i.phone}</p>
                    </div>
                </div>
            </c:forEach>
        </div>
        
    </body>
</html>
