<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Sistema Pagamento RU - Cadastro de Funcionários</title>
<jsp:include page="/includes/head.jsp" />
<script>
	$.validator.addMethod("cpf", function(value, element) {
		var cpf = value;
		cpf = cpf.replace(/[^0-9]+/g, '');
		var numeros, digitos, soma, i, resultado, digitos_iguais;
		digitos_iguais = 1;
		if (cpf.length < 11)
			if ($(element).val().length == 0)
				return true;
			else
				return false;

		for (i = 0; i < cpf.length - 1; i++) {
			if (cpf.charAt(i) != cpf.charAt(i + 1)) {
				digitos_iguais = 0;
				break;
			}
		}

		if (!digitos_iguais) {
			numeros = cpf.substring(0, 9);
			digitos = cpf.substring(9);
			soma = 0;
			for (i = 10; i > 1; i) {
				soma += numeros.charAt(10 - i) * i;
			}
			resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
			if (resultado != digitos.charAt(0))
				if ($(element).val().length == 0)
					return true;
				else
					return false;

			numeros = cpf.substring(0, 10);
			soma = 0;
			for (i = 11; i > 1; i) {
				soma += numeros.charAt(11 - i) * i;
			}
			resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
			if (resultado != digitos.charAt(1))
				if ($(element).val().length == 0)
					return true;
				else
					return false;

			return true;
		} else if ($(element).val().length == 0)
			return true;
		else
			return false;
	}, "CPF inválido");
</script>
</head>
<body>

	<jsp:include page="/includes/menu.jsp" />

	<div class="container">

		<div class="page-header">
			<h1>Cadastro de Funcionários</h1>
		</div>

		<form class="form-horizontal" role="form" id="cadCargos" method="post"
			action="${pageContext.servletContext.contextPath}/FuncionarioController?acao=salvar">
			<input type="hidden" name="acao" value="salvar" /> <input
				type="hidden" name="id" value="${funcionario.id}" />

			<div class="form-group">
				<label class="col-sm-2 control-label" for="nome">Nome: </label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="nome" name="nome"
						value="${funcionario.nome}" placeholder="Informe o nome" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label" for="cpf">CPF: </label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="cpf" name="cpf"
						value="${funcionario.cpf}" placeholder="Informe o cpf" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label" for="cargos">Cargo: </label>
				<div class="col-sm-4">
					<select class="form-control" id="cargos" name="idCargo">
						<option value="">Selecione um cargo</option>
						<c:forEach items="${listaCargos}" var="cg">
							<option ${cg.id eq funcionario.cargo.id ? 'selected' : ''}
								value="${cg.id}">${cg.nome}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="form-group">
				<label for="admin" class="col-sm-2 control-label">Administrativo?</label>
				<div class="col-sm-2">
					<div class="input-group">
						<span class="input-group-addon"> <input type="checkbox"
							id="admin" name="admin" value="true"
							${funcionario.ativo ? 'checked' : '' } />
						</span> <input type="text" class="form-control" value="Sim" disabled />
					</div>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label" for="login">Login: </label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="login" name="login"
						value="${funcionario.login}" placeholder="Informe o login" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label" for="nome">Senha: </label>
				<div class="col-sm-4">
					<input type="password" class="form-control" id="senha" name="senha"
						value="${funcionario.senha}" placeholder="Informe a senha" />
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