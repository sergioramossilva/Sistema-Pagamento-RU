<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Sistema Pagamento RU - Lista de Cargos</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<h1>Lista de Cargos</h1>
	<table>
		<thead>
			<tr>
				<td>Nome</td>
				<td>Administrativo</td>
				<td>Opções</td>
			</tr>
		</thead>
		<tbody>
		    <c:forEach items="${lista}" var="cargo">
		      <tr>
                <td>${cargo.nome}</td>
                <td>${cargo.admin ? 'Sim' : 'Não'}</td>
                <td>
                <a href="CargoController?acao=alterar&id=${cargo.id}">Alterar</a>
                <a href="CargoController?acao=excluir&id=${cargo.id}">Excluir</a>
                </td>
              </tr>
		    </c:forEach>
		</tbody>
	</table>
</body>
</html>