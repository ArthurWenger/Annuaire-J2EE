<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<c:set var="pgTitle" value="Exercice 5" />
<%@ include file="/inc/header.jsp" %>

<c:import url="WEB-INF/web.xml" varReader="documentXML" >

	<x:parse var="doc" doc="${documentXML}" />
	
	<%-- On doit utiliser la syntaxe *[local-name()='Noeud'] pour ignorer le namespace du xmlns ! --%>
	<h1><x:out select="$doc/*[local-name()='web-app']/*[local-name()='display-name']" /></h1>
	<x:forEach var="element" select="$doc/*[local-name()='web-app']/*[local-name()!='display-name']">
		<p>
		<strong><x:out select="name($element)" /></strong>:<br/>
		<x:forEach var="element_childs" select="$element/*">
		   <x:out select="$element_childs" /><br/>
		</x:forEach>
		</p>
	</x:forEach>

</c:import>

<%@ include file="/inc/footer.jsp" %>




