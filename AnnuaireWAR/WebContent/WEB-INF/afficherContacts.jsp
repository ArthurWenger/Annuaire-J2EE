<c:set var="pgTitle" value="Liste des contacts" />
<c:if test="${empty param.search}">
	<c:set var="menuAfficher" value="true" />
</c:if>
<%@ include file="/inc/header.jsp" %>
<%@ include file="/inc/menu.jsp" %>

<p class="info">${ succes }</p>
<table class="table table-striped table-hover" >
 <thead>
 <tr>
 	  <th>#</th>
      <th>Nom</th>
      <th>Prenom</th>
      <th>Adresse</th>
      <th>Tel</th>
      <th>Mail</th>
 </tr>
 </thead>
<c:forEach items="${listeContacts}" var="contact" varStatus="i">
	<c:set var="indexContact" value="${ empty param.search? i.index : applicationScope.annuaire.chercherIndex(contact) }"/>
	<tr>
		<th scope="row">${ i.count }</th>
		<td align="center"><c:out value="${contact.nom}" /></td>
	    <td align="center"><c:out value="${contact.prenom}" /></td>
	    <td align="center"><c:out value="${contact.adresse}" /></td>
	    <td align="center"><c:out value="${contact.tel}" /></td>
	    <td align="center"><c:out value="${contact.mail}" /></td>
	    <td>
	    	<form method="post" action="choisirModification">
	    		<button type="submit" name="modify" value="${ indexContact }" class="btn btn-secondary btn-sm" >Modifier</button>
	    	</form>
	    </td>
	    <td>
	    	<form method="post" action="supprimerContact">
	    		<button type="submit" name="delete" value="${ indexContact }" class="btn btn-secondary btn-sm">Supprimer</button>
	    	</form>
	    </td>
	</tr>
</c:forEach>
</table>

<%@ include file="/inc/footer.jsp" %>