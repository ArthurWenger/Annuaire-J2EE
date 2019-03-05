<nav class="navbar navbar-default">
	<div class="container-fluid">
	  <div class="navbar-header navbar-brand">Annuaire</div>
	  <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		
	  <ul class="nav navbar-nav">
			
			<!-- option pour Revenir a l'accueil -->
	  		<li class="${ !empty menuAccueil ? 'active' : '' }"><a href="accueil">Accueil</a></li>
	  		
	  		<!-- option pour Afficher tous les contacts -->
	        <li class="${ !empty menuAfficher ? 'active' : '' }"><a href="afficherContacts">Afficher tous les contacts</a></li>
	        
	        <!-- option pour Ajouter un contact -->
	        <li class="${ !empty menuAjouter ? 'active' : '' }"><a href="creerContact">Ajouter un contact</a></li>
	        
	        <!-- option pour effectuer une Recherche avancée -->
	        <li class="${ !empty menuRecherche ? 'active' : '' }"><a href="criteresRecherche">Recherche avancée</a></li>

      </ul>
				<!-- Recherche d'un contact -->
			   <form class="navbar-form navbar-left" method="post" action="<c:url value="/chercherContact" />">
		        <div class="form-group">
		          <input type="text" class="form-control"  name="search" placeholder="Rechercher un contact...">
		        </div>
		        <button type="submit" class="btn btn-default" name="search">Valider</button>
		      </form>

		  </div><!-- /.navbar-collapse -->
     </div><!-- /.container-fluid -->
</nav>