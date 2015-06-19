<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Sistema Pagamento RU</a>
		</div>

		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">Cadastros<span
						class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<!-- <li class="dropdown-header">Principais</li> -->
						<li><a
							href="${pageContext.servletContext.contextPath}/CargoController?acao=incluir">Cargos</a></li>
						<li class="divider"></li>
						<li><a
							href="${pageContext.servletContext.contextPath}/FuncionarioController?acao=incluir">Funcionários</a></li>
					</ul></li>

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">Listas<span
						class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<!-- <li class="dropdown-header">Principais</li> -->
						<li><a
							href="${pageContext.servletContext.contextPath}/CargoController">Listar
								Cargos</a></li>
						<li class="divider"></li>
						<li><a
							href="${pageContext.servletContext.contextPath}/FuncionarioController">Listar
								Funcionários</a></li>
					</ul></li>

			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a
					href="${pageContext.servletContext.contextPath}/logout.jsp">Sair</a></li>
			</ul>
		</div>
	</div>
</nav>