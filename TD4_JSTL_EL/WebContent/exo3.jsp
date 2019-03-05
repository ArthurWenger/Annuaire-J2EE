<c:set var="pgTitle" value="Exercice 3" />
<%@ include file="/inc/header.jsp" %>

<table class="table-striped table-bordered table-hover" align="center" style="width:50%" border="1">

<%-- on exclu le 1 de la boucle de test car il n'est pas premier ! --%>
<tr>
	<td align="center">1</td>
	<td align="center">X</td>
</tr>

<c:forEach var="n" begin="2" end="40" step="1">
	<tr><td align="center"> <c:out value="${n}" /></td>
		<td align="center"> <c:set var="premier" value="true"/>
		<c:forEach var="i" begin="2" end="${n-1}">
			<c:if test="${ n%i==0 }" >
				<c:set var="premier" value="false" />
			</c:if>
		</c:forEach>
		<c:choose><c:when test="${premier}">premier</c:when>
					<c:otherwise>X</c:otherwise>
		</c:choose>
		</td>
	</tr>
</c:forEach>
</table>


<%@ include file="/inc/footer.jsp" %>




