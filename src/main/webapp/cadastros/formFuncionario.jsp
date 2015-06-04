<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Sistema Pagamento RU - Cadastro de Funcionárioss</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<h1>Cadastro de Funcionários</h1>
	<form id="cadCargos" method="post" action="${pageContext.servletContext.contextPath}/FuncionarioController?acao=salvar">
		<input type="hidden" name="acao" value="salvar" /> 
		<input type="hidden" name="id" value="${funcionario.id}" />

		<div>
			<label for="nome">Nome: </label> 
			<input type="text" id="nome" name="nome" value="${funcionario.nome}" placeholder="Informe um nome" />
		</div>

		<div>
			<label for="cpf">CPF: </label> 
			<input type="text" id="cpf" name="cpf" value="${funcionario.cpf}" placeholder="informe um cpf" />
		</div>

		<div>
			<label for="cargo">Cargo: </label> 
			<select id="cargo" name="cargo">
				<option value="">Selecione um cargo</option>
				<c:forEach items="${cargos}" var="cg">
                    <option ${cg.id eq funcionario.cargo.id ? 'selected' : ''} value="${cg.id}">${cg.nome}</option>
                </c:forEach>
			</select>
		</div>

		<div>
			<label for="ativo">Ativo? </label> 
			<input type="checkbox" id="ativo" name="ativo" value="true" ${funcionario.ativo ? 'checked' : '' } />
		</div>
		
		<div>
            <label for="dataCadastro">Data cadastro: </label> 
            <input type="date" id="dataCadastro" name="dataCadastro" value="" />
        </div>
        
        <div>
            <label for="login">Login: </label> 
            <input type="text" id="login" name="login" value="${funcionario.login}" placeholder="Informe um login" />
        </div>

        <div>
            <label for="senha">Senha: </label> 
            <input type="password" id="senha" name="senha" value="${funcionario.senha}" placeholder="informe uma senha" />
        </div>

		<div>
			<button type="submit">Salvar</button>
			<button type="reset">Limpar</button>
		</div>
	</form>
</body>
</html>