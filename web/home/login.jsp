<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <%
            String msg = (String) request.getAttribute("msg");
            
            if (msg != null) { %>
            <script>
                alert("<%= msg %>");
            </script> 
        <% } %>
        
        <h1>Login</h1>
        <form action="<%= request.getContextPath()%>/home?task=login" method="post">
            
            <label for="id">ID:</label>
            <input type="text" id="id" name="id" pattern="\d+" title="apenas digitos" required>
            <br/>
            
            <label for="id">Senha:</label>
            <input type="password" id="senha" name="senha" required>
            <br/>
            
            <input type="submit" value="Login">
            
        </form>
    </body>
</html>
