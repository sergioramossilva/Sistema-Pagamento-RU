<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<title>Sistema Pagamento RU - Lista de Cargos</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.14.0/jquery.validate.min.js"></script>
</head>
<body>

    <jsp:include page="/includes/menu.jsp" />

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
		    <c:forEach items="${cargos}" var="cargo">
		      <tr>
                <td>${cargo.nome}</td>
                <td>${cargo.admin ? 'Sim' : 'Não'}</td>
                <td>
                <a class="btn btn-warning" href="alterarCargo?id=${cargo.id}">Alterar</a>
                <a class="btn btn-danger" href="excluirCargo?id=${cargo.id}">Excluir</a>
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