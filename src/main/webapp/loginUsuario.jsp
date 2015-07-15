<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<title>Sistema Pagamento RU</title>
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

		$("#formLogin").validate({
			rules : {
				login : "required",
				senha : "required",
			},
			messages : {
				login : "Por favor digite seu login",
				senha : "Por favor digite sua senha",
			},
		});

	});
</script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-md-4 col-md-offset-4">
				<div class="account-wall">

					<div class="page-header">
						<h1 class="text-center login-title">Autenticação do Usuário</h1>
					</div>

					<form class="form-horizontal" role="form" id="formLogin"
						method="post" action="LoginUsuarioServlet">

						<div class="form-group">
							<label class="col-sm-2 control-label" for="login">Login:
							</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="login" name="login"
									placeholder="Informe seu login" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="senha">Senha:
							</label>
							<div class="col-sm-8">
								<input type="password" class="form-control" id="senha"
									name="senha" placeholder="Digite sua senha" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-8">
								<button type="submit" class="btn btn-primary btn-lg btn-block">Entrar</button>
							</div>
						</div>
					</form>
					<div class="alert alert-success">
						<h3>${mensagem}</h3>
					</div>
					
					<div class="alert" style="display: none">
						<a class="close" onclick="$('.alert').hide()">×</a> <strong>Warning!</strong>
						Best check yo self, you're not looking too good.
					</div>

					<a href="#" onclick="$('alert').show()">show</a>
				</div>
			</div>
		</div>
	</div>
</html>