<c:set var="pgTitle" value="Informations saisies" />
<c:set var="menuAjouter" value="true" />
<%@ include file="/inc/header.jsp" %>
<%@ include file="/inc/menu.jsp" %>

<%-- Affichage de la cha�ne "message" transmise par la servlet --%>
        <p class="info">${ resultat }</p>
        <%-- Puis affichage des donn�es enregistr�es dans le bean "contact" transmis par la servlet --%>
        <c:if test="${ !erreur }" >
        <p>Nom : <c:out value="${ contact.nom }" /></p>
        <p>Pr�nom : <c:out value="${ contact.prenom }" /></p>
        <p>Adresse : <c:out value="${ contact.adresse }" /></p>
        <p>Num�ro de t�l�phone : <c:out value="${ contact.tel }" /></p>
        <p>Email : <c:out value="${ contact.mail }" /></p>
        </c:if>
<%@ include file="/inc/footer.jsp" %>