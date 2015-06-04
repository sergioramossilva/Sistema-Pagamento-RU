<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Sistema Pagamento RU - Cadastro de Cargos</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
		<h1>Cadastro de Cargos</h1>
		<form id="cadCargos" method="post" action="${pageContext.servletContext.contextPath}/CargoController?acao=salvar">
			<input type="hidden" name="acao" value="salvar" /> 
			<input type="hidden" name="id" value="${cargo.id}" />

			<div>
				<label for="nome">Nome: </label> 
				<input type="text" id="nome" name="nome" value="${cargo.nome}" placeholder="Informe um nome" />
			</div>

			<div>
				<label for="admin">Administrador? </label> 
				<input type="checkbox" id="admin" name="admin" value="true" ${cargo.admin ? 'checked' : '' } />
			</div>

			<div>
				<button type="submit">Salvar</button>
				<button type="reset">Limpar</button>
			</div>
		</form>
</body>
</html>