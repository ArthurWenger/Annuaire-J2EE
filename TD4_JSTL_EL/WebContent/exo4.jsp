<%-- on utilise la librairie fmt de jstl ainsi qu'un objet contenant les phrases en francais/anglais --%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en"/>
<fmt:setBundle basename="com.resources.Example"/>
<c:set var="pgTitle" value="Exercice 4" />
<%@ include file="/inc/header.jsp" %>

<h1><fmt:message key="page.titre"/></h1>
<h2><fmt:message key="page.bienvenue"/></h2>
<p>Locale = <%= request.getHeader("Accept-language") %></p>
      

<table class="table-striped table-bordered table-hover" align="center" style="width:50%" border="1">
<c:forEach var="n" begin="1" end="40" step="1">
	<tr><td align="center"> <c:out value="${n}" /></td>
		<td align="center"> <c:set var="premier" value="true"/>
		<c:forEach var="i" begin="2" end="${n-1}">
			<c:if test="${n%i==0}" >
				<c:set var="premier" value="false" />
			</c:if>
		</c:forEach>
				<c:choose><c:when test="${premier}"><fmt:message key="nombre.premier"/></c:when>
					<c:otherwise>X</c:otherwise>
		</c:choose>
		</td>
	</tr>
</c:forEach>
</table>


<%@ include file="/inc/footer.jsp" %>




