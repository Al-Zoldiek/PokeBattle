<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Pokedex</title>
</head>
<body>
	<h1>Bienvenue sur le pokedex</h1>
	<h2>Liste des pokemons :</h2>
	<div>
		<table>
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
			            <td><c:out value="${pokemon.getElemType()}"/></td>
			            <td><c:out value="${pokemon.getAbilty().getName()}"/></td>
			            <td><c:out value="${pokemon.getAbilty().getPower()}"/></td>
			            <td><c:out value="${pokemon.getAbilty().getElemType()}"/></td>
			        </tr>	
				</c:forEach>
			</tbody>
		</table>
	</div>
	<h2>Supprimer un pokemon :</h2>
	<div>
		<form method="" action="">
			<select name="pets" id="pet-select">
				<option value="">-- Choisis un pokemon à supprimer --</option>
				<c:forEach items="${allPokemons}" var="pokemon">
					<option value="${pokemon.getName()}"><c:out value="${pokemon.getName()}"/></option>
				</c:forEach>
    		</select>
    		<button type="submit">Valider</button>
		</form>
	</div>
</body>
</html>