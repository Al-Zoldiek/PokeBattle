<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Creation capacité</title>
</head>
<body>
	<c:import url="header.jsp">
		<c:param name="title" value="Creez une capacité" />
	</c:import>
	
		<form method ="post" action="create-ability">
			<p>
				<label> Nom de la capacité :</label>
				<input type="text" id="abilityName" name="abilityName" placeholder="entrez un texte">
			</p>
			<p>
				<label> Puissance de la capacité :</label>
				<input type="numeric" id="abilityPower" name="abilityPower" placeholder="entrez un nombre">
			</p>
			<p>
			<button type="submit"/>Creer la capacité
			</p>
		</form>
</body>
</html>