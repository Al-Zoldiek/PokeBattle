<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test : affichage des capacités</title>
</head>
<body>
		<div>
		<table>
			<thead>
		        <tr>
		            <th>Capacité (nom)</th>
		            <th>Capacité (pouvoir)</th>
		            <th>Capacité (élément)</th>
		        </tr>
		    </thead>
	    	<tbody>
				<c:forEach items="${allAbilities}" var="ability">
					<tr>
			            <td><c:out value="${ability.getName()}"/></td>
			            <td><c:out value="${ability.getPower()}"/></td>
			            <td><c:out value="${ability.getElemType()}"/></td>
			        </tr>	
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>