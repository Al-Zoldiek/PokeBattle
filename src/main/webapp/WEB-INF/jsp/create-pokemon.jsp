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
						name="pkmn-name" value="${sessionScope.inputPkmnData.getPkmnName()}" placeholder="Tapez un texte ici" required />
				</p>
				<p>
					<label for="lifepoints" >Nombre de points de vie :</label> <input type="number"
						name="lifepoints" value="${sessionScope.inputPkmnData.getLifepoints()}" placeholder="Entrez un nombre ici" required />
				</p>
				<p>
					<label for="attack">Attaque :</label> <input type="number" name="attack" 
					value="${sessionScope.inputPkmnData.getAttack()}" 
						placeholder="Entrez un nombre ici" required />
				<p>
					<label for="defense">Defense :</label> <input type="numeric" name="defense"
					value="${sessionScope.inputPkmnData.getDefense()}" 
						placeholder="Entrez un nombre ici" required />
				</p>
				<p>
					<label for="speed">Vitesse :</label> <input type="numeric" name="speed"
						value="${sessionScope.inputPkmnData.getSpeed()}" 
						placeholder="Entrez un nombre ici" required />
				</p>
				
				<p>Choix du type du pokemon :</p>
				<p>
					<label for="water">Eau</label> 
					<input type="radio" name="elem-type" value="water"  id="water" required> 
					
					<label for="fire">Feu</label>
					<input type="radio" name="elem-type" value="fire" id="fire" required>
					 
					<label for="plant">Plante</label> 
					<input type="radio" name="elem-type" value="plant" id="plant" required>
				</p>
				
				<p>Capacité (attention, celle-ci doit etre du même type que le pokemon)</p>
				<select name="abilities" id="abilities-select">
					<c:forEach items="${allAbilities}" var="ability">
						<option value="${ability.getId()}">
							<c:out value="${ability.getName()} (type ${ability.getElemType()})"/>
						</option>
					</c:forEach>
	    		</select>
				
				<p>
				<button type="submit">Creer le pokemon</button>
				</p>
			</form>
		</div>
	</main>
</body>
</html>