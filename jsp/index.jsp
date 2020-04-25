<%@ page import="java.util.Date" %>

<title>JSP example</title>

<html>
<body>

<h2>Hello, today is <%= new Date() %>

<%

        if(request.getParameter("command") != null) {
                if(request.getParameter("command").equals("list_accounts")) {
                        out.println("<h1>The accounts are: 1234, 5678, 78932</h1><br><br>");
                }
                if(request.getParameter("command").equals("delete_account")) {
                        out.println("<h1>The account " + request.getParameter("account_to_delete") + " has been deleted</h1>");
                }
        }

%>

<form action="" method="get">
        <input type="hidden" name="command" value="list_accounts">
        <button type="submit">List accounts</button>
</form>

<br><br>

<form action="" method="get">
        <input type="hidden" name="command" value="delete_account">
        Account to delete: <input type="textfield" name="account_to_delete">
        <button type="submit">Delete account</button>
</form>

</body>
</html>
