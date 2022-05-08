<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../../../header.jsp"></jsp:include>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-4">
			<div class="card">
				<div class="card-header">
					<h3>Formulaire d'ajout d'une catégorie</h3>
				</div>
				<div class="card-body">
					<form action="Categorie" method="post">
						<div class="form-group">
							<label>Libelle catégorie</label>
							<input type="text" name="libelle" value="${cat.libelle }" class="form-control" required="required">
						</div><br>
						
						<div class="form-group">
							<button type="submit" class="btn btn-outline-success">Ajouter</button>
							<button type="reset" class="btn btn-outline-danger">Annuler</button>
							
						</div>
					</form>
			</div>
		</div>
		</div>
		
	<!-- Liste des utilisateurs -->
	<div class="col-md-8">
			<div class="card">
				<div class="card-header">
					<h3 class="card-title-center">Liste des catégories</h3>
				</div>
				<div class="card-body">
					<table class="table table-striped table-bordered">
						<tr>
							<th>ID</th>
							<th>Libellé</th>
							<th>Action</th>
							<th>Action</th>
							<th>Action</th>
						</tr>
						
						<c:forEach items="${list_Categorie}" var="cat">
						
							<tr>
								<td>${cat.id}</td>
								<td>${cat.libelle}</td>
								<td>Voir</td>
								<td><a href="User?page=edit&id=${cat.id}">Modifier</a></td>
								<td><a onclick="return confirm('Voulez-vous supprimer cette categorie')" href="Categorie?page=delete&id=${cat.id }">Supprimer</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
		</div>
		</div>
	
	</div>
	
	
	
	
</div>
<jsp:include page="../../../footer.jsp"></jsp:include>