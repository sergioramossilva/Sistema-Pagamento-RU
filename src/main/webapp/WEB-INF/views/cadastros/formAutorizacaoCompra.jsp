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

		$("#formAutorizacaoCompra").validate({
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
<script type="text/javascript">
function fecharDiv(){
        window.setTimeout(function () { 
                    $("#success-alert").alert('close'); }, 2000);               
}
</script>  

</head>
<body>
	<jsp:include page="/includes/menu.jsp" />
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-md-4 col-md-offset-4">
				<div class="account-wall">

					<div class="page-header">
						<h1 class="text-center login-title">Debitar Refeição</h1>
					</div>

					<form class="form-horizontal" role="form"
						id="formAutorizacaoCompra" method="post"
						action="${pageContext.servletContext.contextPath}/TransacaoServlet">

						<input type="hidden" id="tipo" name="tipo" value="1" />

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
						<div class="alert alert-danger">
							<a class="close" data-dismiss="alert" href="#">&times;</a>
							<h3>${mensagemSaldo}</h3>
						</div>

						<div id="alertaSaldo" class="alert alert-success fade in" role="alert">
							<button class="close" data-dismiss="alert"></button>
							<a class="close" data-dismiss="alert" href="#">&times;</a>
							<h4>${mensagem}</h4>
							<br /> <label></label>
						</div>


						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-8">
								<button onclick="" type="submit" class="btn btn-primary btn-lg btn-block">Autorizar</button>
							</div>
						</div>
					</form>

				</div>
			</div>
		</div>
	</div>
</html>