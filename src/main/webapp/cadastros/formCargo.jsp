<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Sistema Pagamento RU - Cadastro de Funcionários</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="../resources/css/bootstrap.min.css" rel="stylesheet">
    <script src="../resources/js/bootstrap.min.js"></script>
</head>
<body>

   <div class="container">
	
	<div class="page-header">
	   <h1>Cadastro de Cargos</h1>
	</div>
	
	<form class="form-horizontal" role="form" id="cadCargos" method="post" action="${pageContext.servletContext.contextPath}/CargoController?acao=salvar">
		<input type="hidden" name="acao" value="salvar" /> 
		<input type="hidden" name="id" value="${cargo.id}" />

		<div class="form-group">
			<label class="col-sm-2 control-label" for="nome">Nome: </label>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="nome" name="nome" value="${cargo.nome}" placeholder="Informe o cargo" />
			</div>
		</div>

            <div class="form-group">
                <label for="admin" class="col-sm-2 control-label">Administrativo?</label>
                <div class="col-sm-2">
                    <div class="input-group">
                        <span class="input-group-addon">
                          <input type="radio" id="admin" name="admin" value="true" ${cargo.admin ? 'checked' : '' } />
                        </span> 
                        <input type="text" class="form-control" value="Sim" disabled />
                    </div>
                </div>
                    <div class="col-sm-2">
                    <div class="input-group">
                        <span class="input-group-addon">
                          <input type="radio" id="admin" name="admin" value="false" ${!cargo.admin ? 'checked' : '' } />
                        </span> 
                        <input type="text" class="form-control" value="Não" disabled />
                    </div>
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
</body>
</html>