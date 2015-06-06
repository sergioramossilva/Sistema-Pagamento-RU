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
						<li><a href="${pageContext.servletContext.contextPath}/cadastros/formCargo.jsp">Cargos</a></li>
						<li class="divider"></li>
						<li><a href="${pageContext.servletContext.contextPath}/cadastros/formFuncionario.jsp">Funcionários</a></li>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Sair</a></li>
			</ul>
		</div>
	</div>
</nav>