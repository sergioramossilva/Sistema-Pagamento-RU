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
			<c:forEach items="${lista}" var="funcionario">
				<tr>
					<td>${funcionario.nome}</td>
					<td>${funcionario.cpf}</td>
					<td>${funcionario.cargo.nome}</td>
					<td>${funcionario.ativo ? 'Sim' : 'Não'}</td>
					<td>${funcionario.dataCadastro}</td>
					<td>
					   <a href="CargoController?acao=alterar&id=${funcionario.id}">Alterar</a>
					   <a href="CargoController?acao=excluir&id=${funcionario.id}">Excluir</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>