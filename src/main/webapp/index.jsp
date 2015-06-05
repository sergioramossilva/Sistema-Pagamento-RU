<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Sistema Pagamento RU - Autenticação</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <h1>Autenticação</h1>
    <form method="post" action="LoginServlet">
        <div>
            <label for="login">Login: </label>
            <input id="login" name="login" type="text" value="${funcionario.login}" placeholder="Digite seu login" />
        </div>

        <div>
            <label for="senha">Senha: </label>
            <input id="senha" name="senha" type="password" value="${funcionario.senha}" placeholder="Digite sua senha" />
        </div>

        <div>
            <button type="submit">Entrar</button>
        </div>
    </form>
</body>
</html>