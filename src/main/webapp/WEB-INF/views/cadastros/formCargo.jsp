<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<title>Sistema Pagamento RU - Cadastro de Cargos</title>
<%-- <jsp:include page="/includes/head.jsp" /> --%>
<!-- <script>
	$().ready(function() {

		$("#cadCargos").validate({
			rules : {
				nome : "required",
			},
			messages : {
				nome : "Por favor informe o nome do cargo.",
			}
		});
		$("#selecttest").validate();
	});
</script> -->
</head>
<body>

<%-- 	<jsp:include page="/includes/menu.jsp" /> --%>

	<div class="container">

		<div class="page-header">
			<h1>Cadastro de Cargos</h1>
		</div>

		<form class="form-horizontal" role="form" id="cadCargos" method="post"
			action="salvarCargo">
			<input type="hidden" name="id" value="${cargo.id}" />

			<div class="form-group">
				<label class="col-sm-2 control-label" for="nome">Nome: </label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="nome" name="nome"
						value="${cargo.nome}" placeholder="Informe o cargo" />
				</div>
			</div>
			<div class="form-group">
				<label for="admin" class="col-sm-2 control-label">Administrativo?</label>
				<div class="col-sm-2">
					<div class="input-group">
						<span class="input-group-addon"> <input type="checkbox"
							id="admin" name="admin" value="true"
							${cargo.admin ? 'checked' : '' } />
						</span> <input type="text" class="form-control" value="Sim" disabled />
					</div>
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
<%-- 	<jsp:include page="/includes/footer.jsp" /> --%>
</body>
</html>