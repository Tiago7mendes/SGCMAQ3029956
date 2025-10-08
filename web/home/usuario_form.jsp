<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuario</title>
    </head>
    <body>
        <%
            Usuario tp = null;
            String action = request.getParameter("action");
            if (action == null) {
                action = "create";
            } else {
                if (action.equals("update")) {
                    int id = Integer.valueOf(request.getParameter("id"));
                    
                    tp = new Usuario();
                    tp.setId(id);
                    tp.load();
                }
            }
        %>
        <h1>Usuario!</h1>
        <form action="<%= request.getContextPath()%>/home/usuario?action=<%= action%>" method="post">
            
            <label for="id">ID:</label>
            <input type="text" id="id" name="id" pattern="\d+" title="apenas dígitos" value="<%= (tp != null) ? tp.getId() : "" %>" <%= (tp != null) ? "readonly" : ""%> required>
            <br>
            
            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="nome" value="<%= ((tp != null) && (tp.getNome() != null)) ? tp.getNome() : ""%>">
            <br>
            
            <label for="senha">Senha:</label>
            <input type="text" id="senha" name="senha" value="<%= ((tp != null) && (tp.getSenha()!= null)) ? tp.getSenha(): ""%>">
            <br>
            
            <label for="cpf">CPF:</label>
            <input type="text" id="cpf" name="cpf" value="<%= ((tp != null) && (tp.getCpf() != null)) ? tp.getCpf(): ""%>">
            <br>
            
            <label for="tipoUsuario">Tipo Usuario:</label>
            <input type="text" id="tipoUsuario" name="tipoUsuario" pattern="\d+" title="apenas dígitos" value="<%= (tp != null) ? tp.getTipoUsuarioId(): "" %>" <%= (tp != null) ? "readonly" : ""%> required>
            <br>
            
            <input type="submit" name="Salvar" value="Salvar">
        </form>
    </body>
</html>