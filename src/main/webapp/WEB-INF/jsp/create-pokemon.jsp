<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Creation pokemon</title>
	<style>
		<%@ include file="../ressources/styles/global.css" %>
	</style>
</head>
<body>
	<c:import url="header.jsp">
		<c:param name="title" value="Bienvenue sur PokeBattle" />
	</c:import>
	<main>
		<div>
			<form method="post" action="create-pokemon">
				<p>
					<label for="pkmn-name">Nom du pokemon :</label> <input type="text"
						name="pkmn-name" placeholder="Tapez un texte ici" required />
				</p>
				<p>
					<label for="lifepoints" >Nombre de points de vie :</label> <input type="number"
						name="lifepoints" placeholder="Entrez un nombre ici" required />
				</p>
				<p>
					<label for="attack">Attaque :</label> <input type="number" name="attack"
						placeholder="Entrez un nombre ici" required />
				<p>
					<label for="defense">Defense :</label> <input type="numeric" name="defense"
						placeholder="Entrez un nombre ici" required />
				</p>
				<p>
					<label for="speed">Vitesse :</label> <input type="numeric" name="speed"
						placeholder="Entrez un nombre ici" required />
				</p>
				
				<p>Choix du type du pokemon :</p>
				<p>
					<label for="water">Eau</label> 
					<input type="radio" name="elem-type" value="water"  id="water" required > 
					
					<label for="fire">Feu</label>
					<input type="radio" name="elem-type" value="fire" id="fire" required >
					 
					<label for="plant">Plante</label> 
					<input type="radio" name="elem-type" value="plant" id="plant" required >
				</p>
				
				<p>Choix de capacité (même type que le pokemon)</p>
	
				
				<p>
				<button type="submit">Creer le pokemon</button>
				</p>
			</form>
		</div>
	</main>
</body>
</html>