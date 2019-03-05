<c:set var="pgTitle" value="Exercice 2" />
<%@ include file="/inc/header.jsp" %>

<table class="table-striped table-bordered table-hover" align="center" style="width:50%" border="1">
<c:forEach var="n" begin="1" end="40" step="1">
	<tr><td align="center"> <c:out value="${n}" /></td>
		<td align="center"> <c:choose><c:when test="${ n%2==0 }"> pair </c:when>
					   <c:otherwise> impair </c:otherwise>
			 </c:choose>
		</td>
	</tr>
</c:forEach>
</table>


<%@ include file="/inc/footer.jsp" %>




