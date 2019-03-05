<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="pgTitle" value="Exercice 6" />
<%@ include file="/inc/header.jsp" %>

 <c:if test="${pageContext.request.method=='POST'}">
            <jsp:useBean id="beanEmploi" class="tp3.beans.Emploi" scope="application"/>
            <jsp:useBean id="beanCours" class="tp3.beans.Cours" scope="page"/>
            <fmt:parseDate  var="date" value="${currWinDateStr}" pattern="MM/dd/yyyy"/>
                 
            <c:set target="${beanCours}" property="nom" value="${param.nomCours}" />
            <c:set target="${beanCours}" property="date" value="${param.dateCours}" />
            <c:set target="${beanCours}" property="duree" value="${param.dureeCours}" />
            <c:set target="${beanCours}" property="intervenant" value="${param.intervenantCours}" />
            <c:set target="${beanEmploi}" property="ceCours" value="${beanCours}"/>
</c:if>
<h4>Liste des cours</h4>
<table class="table-striped table-bordered table-hover" style="width:66%" border="1">
    <tr bgcolor="#0000FF">
        <td >label</td>
        <td >date</td>
        <td >duree</td>
        <td >debut</td>
    </tr>
<c:forEach var="c" items="${beanEmploi.listeCours}" >
  <tr>
      <td ><c:out value="${c.nom}"/></td>
      <td ><c:out value="${c.intervenant}"/></td>
      <td ><c:out value="${c.duree}"/>h</td>
      <td ><c:out value="${c.date}"/></td>
  </tr>
</c:forEach>
</table>

<br>   
    <form method="post">
    <fieldset>
        <legend>Ajout d'un cours:</legend>

        <label for="nomCours">Nom <span class="requis">*</span></label>
        <input type="text" id="nomCours" name="nomCours" size="20" maxlength="20" />
        <br />
        
        <label for="dateCours">Date <span class="requis">*</span></label>
        <input type="text" id="dateCours" name="dateCours" size="20" maxlength="20" />
        <br />

        <label for="dureeCours">Durée <span class="requis">*</span></label>
        <input type="text" id="dureeCours" name="dureeCours" size="20" maxlength="20" />
        <br />

        <label for="intervenantCours">Intervenant <span class="requis">*</span></label>
        <input type="text" id="intervenantCours" name="intervenantCours" size="20" maxlength="20" />
        <br />
        
        <input type="submit" value="Ajouter" class="sansLabel"  />
    	<input type="reset" value="Remettre à zéro" /> 
    	<br />
    </fieldset>
</form>
    
<%@ include file="/inc/footer.jsp" %>




