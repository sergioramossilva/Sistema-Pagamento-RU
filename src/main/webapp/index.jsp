<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<title>Sistema Pagamento RU - Autenticação</title>
<jsp:include page="includes/head.jsp" />
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
			}
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
						<h1 class="text-center login-title">Autenticação</h1>
					</div>

					<form class="form-horizontal" role="form" id="formLogin"
						method="post" action="LoginServlet">

						<div class="form-group">
							<label class="col-sm-2 control-label" for="login">Login:
							</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="login" name="login"
									value="${func.login}" placeholder="Informe seu login" />
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label" for="senha">Senha:
							</label>
							<div class="col-sm-8">
								<input type="password" class="form-control" id="senha"
									name="senha" value="${func.senha}"
									placeholder="Digite sua senha" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-8">
								<button type="submit" class="btn btn-primary btn-lg btn-block">Entrar</button>
							</div>
						</div>
					</form>

				</div>
			</div>
		</div>
	</div>
	<jsp:include page="includes/footer.jsp" />
</body>
</html>