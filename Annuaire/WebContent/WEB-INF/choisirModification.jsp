<c:set var="pgTitle" value="Création d'un contact" />
<%@ include file="/inc/header.jsp" %>
<%@ include file="/inc/menu.jsp" %>

<form method="post" action="<c:url value="/modifierContact" />">
    <fieldset>
        <legend>Informations contact:</legend>

        <label for="nomContact">Nom <span class="requis">*</span></label>
        <input type="text" id="nomContact" name="nomContact" value="<c:out value="${ oldContact.nom }${ contact.nom }"/>" size="20" maxlength="20" />
        <span class="erreur">${ form.erreurs['nomContact'] }</span>
        <br />
        
        <label for="prenomContact">Prénom </label>
        <input type="text" id="prenomContact" name="prenomContact" value="<c:out value="${ oldContact.prenom }${ contact.prenom }" />" size="20" maxlength="20" />
        <br />

        <label for="adresseContact">Adresse <span class="requis">*</span></label>
        <input type="text" id="adresseContact" name="adresseContact" value="<c:out value="${ oldContact.adresse }${ contact.adresse }" />" size="20" maxlength="20" />
        <span class="erreur">${ form.erreurs['adresseContact'] }</span>
        <br />

        <label for="telephoneContact">Numéro de téléphone </label>
        <input type="text" id="telephoneContact" name="telephoneContact" value="<c:out value="${ oldContact.tel }${ contact.tel }" />" size="20" maxlength="20" />
        <br />
        
        <label for="emailContact">Adresse email <span class="requis">*</span></label>
        <input type="email" id="emailContact" name="emailContact" value="<c:out value="${ oldContact.mail }${ contact.mail }"/>" size="20" maxlength="60" />
        <span class="erreur">${ form.erreurs['emailContact'] }</span>
        <br />
        <input type="hidden" name="index" value="${ sessionScope.indexModify }" />
        <input type="submit" value="Valider" class="sansLabel"  <c:if test="${ empty sessionScope.indexModify}">disabled</c:if> />
    	<input type="reset" value="Remettre à zéro" /> 
    	<br />
        <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${ form.resultat }</p>
    </fieldset>

</form>

<%@ include file="/inc/footer.jsp" %>