<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Pokedex</title>
	<style>
		<%@ include file="../ressources/styles/global.css" %>
	</style>
</head>
<body>
	<c:import url="header.jsp">
		<c:param name="title" value="Pokedex" />
		<c:param name="image" value="data:image/png;base64,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" />
	</c:import>
	<main>
		<h2>Liste des Pokemons :</h2>
		<table class="app-table">
			<thead>
		        <tr>
		        	<th>Name</th>
		            <th>Vie</th>
		            <th>Attaque</th>
		            <th>Défense</th>
		            <th>Vitesse</th>
		            <th>Elément</th>
		            <th>Capacité (nom)</th>
		            <th>Capacité (pouvoir)</th>
		            <th>Capacité (élément)</th>
		        </tr>
		    </thead>
	    	<tbody>
				<c:forEach items="${allPokemons}" var="pokemon">
					<tr>
						<td><c:out value="${pokemon.getName()}"/></td>
			            <td><c:out value="${pokemon.getLifepoints()}"/></td>
			            <td><c:out value="${pokemon.getAttack()}"/></td>
			            <td><c:out value="${pokemon.getDefense()}"/></td>
			            <td><c:out value="${pokemon.getSpeed()}"/></td>
			            
		            	<c:choose>
							<c:when test="${ pokemon.getElemType().equalsIgnoreCase('Eau') }">
								<td class="app-table__td--water"><c:out value="${pokemon.getElemType()}"/></td>
							</c:when>
							<c:when test="${ pokemon.getElemType().equalsIgnoreCase('Feu') }">
								<td class="app-table__td--fire"><c:out value="${pokemon.getElemType()}"/></td>
							</c:when>
							<c:when test="${ pokemon.getElemType().equalsIgnoreCase('Plante') }">
								<td class="app-table__td--plant"><c:out value="${pokemon.getElemType()}"/></td>
							</c:when>
							<c:otherwise>
								<td><c:out value="${pokemon.getElemType()}"/></td>
							</c:otherwise>
						</c:choose>
			            	
			            <td><c:out value="${pokemon.getAbilty().getName()}"/></td>
			            <td><c:out value="${pokemon.getAbilty().getPower()}"/></td>
			            
			            <c:choose>
							<c:when test="${ pokemon.getAbilty().getElemType().equalsIgnoreCase('Eau') }">
								<td class="app-table__td--water"><c:out value="${pokemon.getElemType()}"/></td>
							</c:when>
							<c:when test="${ pokemon.getAbilty().getElemType().equalsIgnoreCase('Feu') }">
								<td class="app-table__td--fire"><c:out value="${pokemon.getElemType()}"/></td>
							</c:when>
							<c:when test="${ pokemon.getAbilty().getElemType().equalsIgnoreCase('Plante') }">
								<td class="app-table__td--plant"><c:out value="${pokemon.getElemType()}"/></td>
							</c:when>
							<c:otherwise>
								<td><c:out value="${pokemon.getAbilty().getElemType()}"/></td>
							</c:otherwise>
						</c:choose>
						
						<td>
							<form method="POST" action="pokemon-delete">
								<input type="hidden" name="idPokemonToDelete" value="${pokemon.getId()}" />
								<button type="submit" class="app-button--critical app-button--into-table">Supprimer</button>
							</form>
						</td>
			        </tr>	
				</c:forEach>
			</tbody>
		</table>
	</main>
</body>
</html>