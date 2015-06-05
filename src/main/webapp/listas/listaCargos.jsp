<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Sistema Pagamento RU - Lista de Cargos</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">

		<div class="page-header">
			<h1>Lista de Cargos</h1>
		</div>

		<table class="table table-striped table-hover">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Administrativo</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
		    <c:forEach items="${lista}" var="cargo">
		      <tr>
                <td>${cargo.nome}</td>
                <td>${cargo.admin ? 'Sim' : 'Não'}</td>
                <td>
                <a class="btn btn-warning" href="CargoController?acao=alterar&id=${cargo.id}">Alterar</a>
                <a class="btn btn-danger" href="CargoController?acao=excluir&id=${cargo.id}">Excluir</a>
                </td>
              </tr>
		    </c:forEach>
		</tbody>
		<tfoot>
		  <tr>
		      <td colspan="2"><strong>Total de registros:</strong></td>
		      <td><strong>${fn:length(lista)}</strong></td>
		  </tr>
		</tfoot>
	</table>
	</div>
</body>
</html>