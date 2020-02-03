<html>
<head>
    <title>Update</title>
</head>
<body>
<form method="post" action="/save">
        <input type="text" name="id" readonly="readonly" value="<c:out value="${invoice.id}"/>">
        <input type="text" name="sum" value="<c:out value="${invoice.sum}"/>">
        <input type="text" name="paid" value="<c:out value="${invoice.paid}"/>">
    <input type="submit" value="ok" name="update">
</form>
</body>
</html>
