<style>
	<%@ include file="../ressources/styles/header.css" %>
</style>
<header>
	<nav class="app-menu">
		<div class="app-menu__logo">
			<img alt="Logo Pokemon" src="https://icon-library.com/images/pokemon-ball-icon/pokemon-ball-icon-28.jpg">
		</div>
		<div class="app-menu__nav">
			<a href="/PokeBattle/">Accueil</a>
			<a href="create-ability">Creer une capacité</a>
			<a href="create-pokemon">Creer un pokemon</a>
			<a href="pokedex">Pokedex</a>
		</div>
		
	</nav>
	
	<c:if test="${ param.title != null }">
		<h1>
			<c:out value="${ param.title }">
				Titre de la page par dï¿½faut
			</c:out>
			<c:if test="${ param.image != null }">
				<img alt="Title image" src="${ param.image }" class="app-title-image" >
			</c:if>
		</h1>
	</c:if>
</header>