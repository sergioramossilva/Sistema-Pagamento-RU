<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<title>Sistema Pagamento RU - Cadastro de Funcionario</title>
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
function validarCPF(cpf) {
	cpf = remove(cpf, ".");
	cpf = remove(cpf, "-");

	if (cpf.length != 11 || cpf == "00000000000" || cpf == "11111111111"
			|| cpf == "22222222222" || cpf == "33333333333"
			|| cpf == "44444444444" || cpf == "55555555555"
			|| cpf == "66666666666" || cpf == "77777777777"
			|| cpf == "88888888888" || cpf == "99999999999") {
		window.alert("CPF inválido. \nInforme um CPF válido.");
		document.getElementById("cpf").value = "";
		return false;
	}

	soma = 0;
	for (i = 0; i < 9; i++) {
		soma += parseInt(cpf.charAt(i)) * (10 - i);
	}

	resto = 11 - (soma % 11);
	if (resto == 10 || resto == 11) {
		resto = 0;
	}
	if (resto != parseInt(cpf.charAt(9))) {
		window.alert("CPF inválido. \nInforme um CPF válido.");
		document.getElementById("cpf").value = "";
		return false;
	}

	soma = 0;
	for (i = 0; i < 10; i++) {
		soma += parseInt(cpf.charAt(i)) * (11 - i);
	}
	resto = 11 - (soma % 11);
	if (resto == 10 || resto == 11) {
		resto = 0;
	}

	if (resto != parseInt(cpf.charAt(10))) {
		window.alert("CPF inválido. \nInforme um CPF válido.");
		document.getElementById("cpf").value = "";
		return false;
	}

	return true;
}

function remove(str, sub) {
	i = str.indexOf(sub);
	r = "";
	if (i == -1)
		return str;
	{
		r += str.substring(0, i) + remove(str.substring(i + sub.length), sub);
	}

	return r;
}

function mascara(o, f) {
	v_obj = o
	v_fun = f
	setTimeout("execmascara()", 1)
}

function execmascara() {
	v_obj.value = v_fun(v_obj.value)
}

function cpf_mask(v) {
	v = v.replace(/\D/g, "") 
	v = v.replace(/(\d{3})(\d)/, "$1.$2") 
											
	v = v.replace(/(\d{3})(\d)/, "$1.$2")
											
	v = v.replace(/(\d{3})(\d)/, "$1-$2") 
	return v
}
</script>
</head>
<body>

	<jsp:include page="/includes/menu.jsp" />

	<div class="container">

		<div class="page-header">
			<h1>Cadastro de Funcionários</h1>
		</div>

		<form class="form-horizontal" role="form" id="cadCargos" method="post"
			action="salvarFuncionario">
			<input type="hidden" name="acao" value="salvar" /> <input
				type="hidden" name="id" value="${funcionario.id}" />

			<div class="form-group">
				<label class="col-sm-2 control-label" for="nome">Nome: </label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="nome" name="nome" required="required"
						value="${funcionario.nome}" placeholder="Informe o nome" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label" for="cpf">CPF: </label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="cpf" name="cpf"
						value="${funcionario.cpf}" placeholder="Informe o cpf" 
						required="required" maxlength="14" onblur="validarCPF(this.value)" 
						onkeypress="mascara(this, cpf_mask)"/>
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
					<input type="text" class="form-control" id="login" name="login" required="required"
						value="${funcionario.login}" placeholder="Informe o login" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label" for="nome">Senha: </label>
				<div class="col-sm-4">
					<input type="password" class="form-control" id="senha" name="senha" required="required"
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
