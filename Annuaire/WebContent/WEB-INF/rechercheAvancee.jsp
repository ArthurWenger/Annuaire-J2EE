<c:set var="pgTitle" value="Options de recherche" />
<c:set var="menuRecherche" value="true" />
<%@ include file="/inc/header.jsp" %>
<%@ include file="/inc/menu.jsp" %>

<c:choose>
	<c:when test="${!empty sessionScope.searchOptions}" >
		<c:set var="options" value="${ sessionScope.searchOptions.getOptions() }"/>
	</c:when>
	<c:otherwise>
		<c:set var="defaultOptions" value="checked"/>
	</c:otherwise>
</c:choose>

<form action="criteresRecherche" method="post">
	<div class="row">
        <div class="col-xs-6 col-xs-offset-2">
            <h3 class="text-center">Criteres de recherche</h3>
            <div class="well" style="max-height: 300px;overflow: auto;">
            	<ul class="list-group checked-list-box">
                  <li class="list-group-item"><label><input type="checkbox" name="check_list[]" value="nom" ${ pageScope.options.get("nom") ? "checked" : ""}${ pageScope.defaultOptions }> Inclure les Noms</label></li>
                  <li class="list-group-item"><label><input type="checkbox" name="check_list[]" value="prenom" ${ pageScope.options.get("prenom") ? "checked" : ""}${ pageScope.defaultOptions }> Inclure les Prenoms</label></li>
                  <li class="list-group-item"><label><input type="checkbox" name="check_list[]" value="adresse" ${ pageScope.options.get("adresse") ? "checked" : ""}${ pageScope.defaultOptions }> Inclure les Adresses</label></li>
                  <li class="list-group-item"><label><input type="checkbox" name="check_list[]" value="tel" ${ pageScope.options.get("tel") ? "checked" : ""}${ pageScope.defaultOptions }> Inclure les Telephones</label></li>
                  <li class="list-group-item"><label><input type="checkbox" name="check_list[]" value="mail" ${ pageScope.options.get("mail") ? "checked" : ""}${ pageScope.defaultOptions }> Inclure les Mails</label></li>            
                </ul>
                <br />
                <button class="btn btn-primary col-xs-12" type="submit">Valider les options</button>
            </div>
        </div>
	</div>
</form>

<%@ include file="/inc/footer.jsp" %>