<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="br.edu.utfpr.cm.pi.daos.FuncionarioDao" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
	<!-- Bootstrap core CSS -->
		<link href="dist/css/bootstrap.min.css" rel="stylesheet">

	<!-- Custom styles for this template -->
		<link href="dashboard.css" rel="stylesheet">

	<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
	<!--[if lt IE 9]><script src="assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
		<script src="assets/js/ie-emulation-modes-warning.js"></script>

	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

<script src="Jquery.js" type="text/javascript"></script>
<script src="../../css/Jquery.validade.js" type="text/javascript"></script>

</head>

<body>

	<!-- Wrap all page content here -->
	<div id="wrap">


		<!-- Begin page content -->
		<div class="container">

			<div class="page-header">
				<h1>Cadastro de Funcionario</h1>
			</div>

			<p class="lead">Sistema Pagamento RU</p>
		<form id="cadFuncionario" class="form-horizontal" role="form"
		method="post" action="controlador?acao=salvar">
				<input type="hidden" name="acao" value="salvar" />
				<input type="hidden" name="id" value="${fun.id}" />


				<div class="form-group">
					<label for="nome" class="col-sm-2 control-label">Nome</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="nome" name="nome"
							value="${fun.nome}" placeholder="Informe um nome">
					</div>
				</div>

				<div class="form-group">
					<label for="cpf" class="col-sm-2 control-label">CPF</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="cpf" name="nome"
							value="${fun.cpf}" placeholder="Informe seu Cpf">
					</div>
				</div>

				<div class="form-group">
					<label for="login" class="col-sm-2 control-label">Login</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="login" name="login"
							value="${fun.login}" placeholder="Informe seu Login">
					</div>
				</div>

				<div class="form-group">
					<label for="senha" class="col-sm-2 control-label">Senha</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="senha" name="senha"
							value="${fun.senha}" placeholder="Informe sua Senha">
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-5">
						<button type="submit" class="btn btn-success">Salvar</button>
						<a href="" class="btn btn-default">Cancelar</a> 
						<a href="/cadastros/funcionario/controlador"
						class="btn btn-default">Listar Funcionarios</a>
					</div>
				</div>

			</form>



			<div id="footer">
				<div class="container">
					<p class="text-muted">
						Sistema Pagamento RU<strong>  Projeto Integrador</strong>.
					</p>
				</div>
			</div>
			<!-- Bootstrap core JavaScript
    ================================================== -->
			<!-- Placed at the end of the document so the pages load faster -->
			<script
				src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
			<script src="dist/js/bootstrap.min.js"></script>
			<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
			<script src="assets/js/vendor/holder.js"></script>
			<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
			<script src="assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
