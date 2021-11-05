
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="header.jsp">
		<c:param name="title" value="Bienvenue sur PokeBattle" />
	</c:import>
	<c:if test="${ !sessionScope.stepTester.equals(\"is-second-selected\") }">
	<div>
		<c:if test="${ sessionScope.stepTester == null}"> 
    	<div>
    		<form method="post" action="battle-page">
        		<select name="pokemons" id="first-pokemon-select">
         	   	<c:forEach items="${ pokemonList }" var="pokemon" varStatus="status">
						<option value="${ pokemon.getId() }"><c:out value="${ pokemon.displayForListing() } !" /></option>
						</c:forEach>
       				 </select>
       			<button type="submit">... je te choisis !</button>
       			<input type="password" name="step-test" hidden="true" value="is-first-selected">
        		</form>        	
    	</div>
	</c:if>
	
	
	
   	 	<c:if test="${ sessionScope.stepTester.equals(\"is-first-selected\") }">
    		<div id="versus"></div>
    		<div>
				<form method="post" action="battle-page">>
       		 	<select name="pokemons" id="second-pokemon-select">
         		   <c:forEach items="${ pokemonList }" var="pokemon" varStatus="status">
						<option value="${ pokemon.getId() }"><c:out value="${ pokemon.displayForListing() } !" /></option>
						</c:forEach>
       				 </select>
       			<button type="submit">... à toi de jouer ! !</button>
       			<input type="password" name="step-test" hidden="true" value="is-second-selected">
        			</form>
					</div>
    	</c:if>
   
    	</div>
    </c:if>
    
    <c:if test="${ sessionScope.stepTester.equals(\"is-second-selected\") }">
	
	<c:out value="${ sessionScope }"></c:out>
	
	<div></div>
		
    </c:if>
    
</body>
</html>