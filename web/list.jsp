<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Invoices</title>
</head>
<body>
<table>
    <tr>
        <td>id</td>
        <td>name</td>
    </tr>
    <c:forEach items="${list}" var="list">
        <tr>
            <th>${list.id}</th>
            <th>${list.name}</th>
            <th><a href="/save?action=update&id=<c:out value="${list.id}"/>">update</a> </th>
            <th><a href="/save?action=print&id=${list.id}">print</a> </th>
            <th><a href="/save?action=delete&id=${list.id}">delete</a> </th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
