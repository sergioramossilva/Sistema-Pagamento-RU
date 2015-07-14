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
							href="${pageContext.servletContext.contextPath}/incluirCargo">Cargos</a></li>
						<li class="divider"></li>
						<li><a
							href="incluirFuncionario">Funcionários</a></li>
					</ul></li>

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">Listas<span
						class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<!-- <li class="dropdown-header">Principais</li> -->
						<li><a
							href="listarCargos">Listar
								Cargos</a></li>
						<li class="divider"></li>
						<li><a
							href="${pageContext.servletContext.contextPath}/listarFuncionarios">Listar
								Funcionários</a></li>
					</ul>
				</li>
				
				<li class="dropdown">
				<a
					href="${pageContext.servletContext.contextPath}/TransacaoServlet">Inserir Crédito
				</a>
				</li>
				
				<li class="dropdown">
				<a
					href="/cadastros/formAutorizacaoCompra.jsp">Autorização de Compra
				</a>
				</li>

			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a
					href="${pageContext.servletContext.contextPath}/logout.jsp">Sair</a></li>
			</ul>
		</div>
	</div>
</nav>