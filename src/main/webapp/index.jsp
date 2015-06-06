<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Sistema Pagamento RU - Autenticação</title>
    <jsp:include page="includes/head.jsp" />
</head>
<body>
     
   <div class="container">
   
    <div class="page-header">
       <h1>Autenticação</h1>
    </div>
    
    <form class="form-horizontal" role="form" id="formLogin" method="post" action="LoginServlet">
   
            <div class="form-group">
                <label class="col-sm-2 control-label" for="login">Login: </label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="login" name="login" value="${funcionario.login}" placeholder="Informe seu login" />
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label" for="senha">Senha: </label>
                <div class="col-sm-4">
                    <input type="password" class="form-control" id="senha" name="senha" value="${funcionario.senha}" placeholder="Digite sua senha" />
                </div>
            </div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-4">
				<button type="submit" class="btn btn-primary btn-lg btn-block">Entrar</button>
			</div>
		</div>
	</form>
	</div>
</body>
</html>