<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>meals new</title>
</head>
<body>
<h2>meals</h2>

<table>
    <tr>
        <th>dateTime</th>
        <th>description</th>
        <th>calories</th>
    </tr>

    <c:forEach items="${list}" var="personlist">
        <tr>
            <td>${personlist.dateTime}</td>
            <td>${personlist.description}</td>
            <td>${personlist.calories}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
