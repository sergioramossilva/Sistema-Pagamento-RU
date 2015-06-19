<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <title>Sistema Pagamento RU - Lista de Funcionários</title>
    <jsp:include page="/includes/head.jsp" />
</head>
<body>

	<jsp:include page="/includes/menu.jsp" />

	<div class="container">

		<div class="page-header">
			<h1>Lista de Funcionários</h1>
		</div>

		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>Nome</th>
					<th>CPF</th>
					<th>Cargo</th>
					<th>Ativo</th>
					<th>Data cadastro</th>
					<th>Opções</th>
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
						<a class="btn btn-warning" href="FuncionarioController?acao=alterar&id=${funcionario.id}">Alterar</a>
						<a class="btn btn-danger" href="FuncionarioController?acao=excluir&id=${funcionario.id}">Excluir</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="5"><strong>Total de registros:</strong></td>
					<td><strong>${fn:length(lista)}</strong></td>
				</tr>
			</tfoot>
		</table>

	</div>
</body>
</html>