<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<title>Sistema Pagamento RU - Extrato</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.14.0/jquery.validate.min.js"></script>
</head>
<body>

    <jsp:include page="/includes/menuUsuario.jsp" />

	<div class="container">

		<div class="page-header">
			<h1>Extrato</h1>
		</div>

		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>Operação</th>
					<th>Quantidade</th>
					<th>Data</th>
				</tr>
			</thead>
		  	<tbody>
				<c:forEach items="${transacao}" var="transacao">
					<tr>
						<td>${transacao.tipoTransacao}</td>
						<td>${transacao.quantidade}</td>
						<td>${transacao.date}</td>
						
						<td>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="5"><strong>Total de registros:</strong></td>
				 	<td><strong>${fn:length(transacao)}</strong></td>  
				</tr>
			</tfoot>
		</table>

	</div>
</body>
</html>