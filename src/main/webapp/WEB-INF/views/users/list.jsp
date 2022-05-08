<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../../../header.jsp"></jsp:include>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-4">
			<div class="card">
				<div class="card-header">
					<h3>Ajouter un utilisateur</h3>
				</div>
				<div class="card-body">
					<form action="User" method="post">
						<div class="form-group">
							<label>Nom</label>
							<input type="text" name="nom" class="form-control" required="required">
						</div>
					
						<div class="form-group">
							<label>Prenom</label>
							<input type="text" name="prenom" class="form-control" required="required">
						</div>
						
						<div class="form-group">
							<label>Login</label>
							<input type="email" name="login" class="form-control" required="required">
						</div>
						
						<div class="form-group">
							<label>Mot de passe</label>
							<input type="password" name="password" class="form-control" required="required">
						</div><br>
						
						<div class="form-group">
							<button type="submit" class="btn btn-outline-success">Ajouter</button>
							<button type="reset" class="btn btn-outline-danger">Annuler</button>
						</div>
						<c:if test="${message != null}">
							<c:if test="${message == 1 }">
								<div class="alert alert-success">Utilisateur ajouté avec succes</div>
							</c:if>
							<c:if test="${message == 0 }">
								<div class="alert alert-danger">Erreur donnée non ajoutée</div>
							</c:if>
						</c:if>
					</form>
			</div>
		</div>
	</div>
		
	<!-- Liste des utilisateurs -->
	<div class="col-md-8">
			<div class="card">
				<div class="card-header">
					<h3 class="card-title-center">Liste des utilisateurs</h3>
				</div>
				<div class="card-body">
					<table class="table table-striped table-bordered">
						<tr>
							<th>Nom</th>
							<th>Prenom</th>
							<th>Login</th>
							<th>Action</th>
							<th>Action</th>
							
						</tr>
						
						<c:forEach items="${users }" var="u">
 							<tr>
								<td>${u.nom }</td>
								<td>${u.prenom }</td>
								<td>${u.login }</td>
								<td>Modifier</td>
								<td><a onclick="return confirm('Voulez-vous supprimer cet utilisateur ?')" href="User?page=delete
								&id=${u.id }">Supprimer</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	
	</div>
	
</div>
<jsp:include page="../../../footer.jsp"></jsp:include>