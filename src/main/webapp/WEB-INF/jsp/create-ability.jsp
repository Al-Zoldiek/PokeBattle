<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Creation capacité</title>
	<style>
		<%@ include file="../ressources/styles/global.css" %>
	</style>
</head>
<body>
	<c:import url="header.jsp">
		<c:param name="title" value="Creez une capacité" />
	</c:import>
	<main>
		<div>
			<form method ="post" action="create-ability">
				<p>
					<label> Nom de la capacité :</label>
					<input type="text" id="ability-name" name="ability-name" placeholder="entrez un texte" required>
				</p>
				<p>
					<label> Puissance de la capacité :</label>
					<input type="number" id="ability-power" name="ability-power" placeholder="entrez un nombre" required>
				</p>
				<p>Type de la capacité</p>
				<p>
					<label for="water">Eau</label> 
					<input type="radio" name="elem-type" value="water"  id="water" required > 
					
					<label for="fire">Feu</label>
					<input type="radio" name="elem-type" value="fire" id="fire" required >
					 
					<label for="plant">Plante</label> 
					<input type="radio" name="elem-type" value="plant" id="plant" required >
				</p>
				<p>
				<button type="submit">Creer la capacité</button>
				</p>
			</form>
		</div>
	</main>
</body>
</html>