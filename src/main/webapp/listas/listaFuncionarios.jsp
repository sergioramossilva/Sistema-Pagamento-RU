<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Sistema Pagamento RU - Lista de Funcionários</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <h1>Lista de Funcionários</h1>
    <table>
        <thead>
            <tr>
                <td>Nome</td>
                <td>CPF</td>
                <td>Cargo</td>
                <td>Ativo</td>
                <td>Data cadastro</td>
                <td>Opções</td>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${lista}" var="obj">
              <tr>
                <td>${obj.nome}</td>
                <td>${obj.admin ? 'Sim' : 'Não'}</td>
                <td>
                <a href="CargoController?acao=alterar&id=${obj.id}">Alterar</a>
                <a href="CargoController?acao=excluir&id=${obj.id}">Excluir</a>
                </td>
              </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>