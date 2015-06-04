<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


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

		
			  <p>Lista de C. <a href="CargoController?acao=incluir">Incluir um novo registro</a>.</p>
                
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <td>Nome</td>
	                        <td>Admin</td>
                            <td>Opções</td>
                        </tr>
                    </thead>
                    
                    <tbody>
                        <c:forEach items="${lista}" var="obj">
                            <tr>
                                <td>${obj.nome}</td>
                                <td>${obj.admin}</td>
                                <td>
                                    <a href="CargoController?acao=alterar&id=${obj.id}" class="btn btn-default">Alterar</a>
                                    <a href="CargoController?acao=excluir&id=${obj.id}" class="btn btn-danger">Excluir</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                    
                </table>

            </div>
        </div>
			
			
			
			
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
