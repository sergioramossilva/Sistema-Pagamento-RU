<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <div>
        <h1>Autenticação</h1>
        <form method="post" action="LoginServlet">
            <ul>
                <li>
                    <label for="login">Login: </label>
                    <input id="login" name="login" type="text" value="${funcionario.login}" placeholder="Digite seu login" />
                </li>
                <li>
                    <label for="senha">Senha: </label>
                    <input id="senha" name="senha" type="password" value="${funcionario.senha}" placeholder="Digite sua senha" />
                </li>
                <li>
                    <button type="submit">Entrar</button>
                </li>
            </ul>
        </form>
    </div>
</body>
</html>