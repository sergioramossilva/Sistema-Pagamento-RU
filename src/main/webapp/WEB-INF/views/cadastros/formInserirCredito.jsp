<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<title>Sistema Pagamento RU - Inserir Credito</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.14.0/jquery.validate.min.js"></script>

<script>
	$().ready(function() {

		$("#inserirCreditos").validate({
			rules : {
				cliente : {
					required : true
				},
				refeicao : {
					required : true,
					number : true
				}
			},
			messages : {
				cliente : {
					required : "Informe o Cliente",
				},
				refeicao : {
					required : "Informe a quantidade de Refeições",
				}
			}
		});

		$("#selecttest").validate();
	});
</script>
</head>
<body>

	<jsp:include page="/includes/menu.jsp" />

	<div class="container">

		<div class="page-header">
			<h1>Inserir Créditos</h1>
		</div>

		<form class="form-horizontal" role="form" id="inserirCreditos"
			method="post" action="${pageContext.servletContext.contextPath}/TransacaoServlet">
			
			<input type="hidden" name="tipo" value="0" />
			
			<input type="hidden" name="id" value="${transacao.id}" />

			<div class="form-group">
				<label class="col-sm-2 control-label" for="cliente">Login
					Cliente: </label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="cliente" name="cliente"
						value="${usuario.login}" placeholder="Informe login do cliente" />
				</div>
			</div>
			<div class="form-group">
				<label for="admin" class="col-sm-2 control-label">Nº
					Refeições: </label>
				<div class="col-sm-2">
					<input type="text" class="form-control" name="refeicao"
						id="refeicao">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-5">
					<button type="submit" class="btn btn-success">Salvar</button>
					<button type="reset" class="btn btn-default">Limpar</button>
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="/includes/footer.jsp" />
</body>
</html>