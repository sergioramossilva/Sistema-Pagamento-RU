
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<title>Sistema Pagamento RU - Autorização de Compra</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.14.0/jquery.validate.min.js"></script>
<script>
	$().ready(function() {

		$("#cadUsuario").validate({
			rules : {
				nome : "required",
			},
			messages : {
				nome : "Por favor informe seu Usuário.",
			}
		});
		
		$("#senha").validate({
			rules : {
				nome : "required",
			},
			messages : {
				nome : "Por favor informe sua senha.",
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
			<h1>Autorização de Compra</h1>
		</div>

		<form class="form-control" role="form" id="cadUsuario" method="post"	action="">
			<input type="hidden" name="acao" value="salvar" /> 
			<input type="hidden" name="id" value="${usuario.id}" />
			<div class="form-group">
				<label class="col-sm-2 control-label" for="nome">Usuário: </label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="nome" name="nome"
						value="${usuario.nome}" placeholder="Informe seu Usuário" />
					</div>
			</div>
			<label class="col-sm-2 control-label" id="senha" for="nome">Senha: </label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="senha" name="senha"
						value="${usuario.senha}" placeholder="Informe sua senha" />
					</div>
				<div>
				<br></br>
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