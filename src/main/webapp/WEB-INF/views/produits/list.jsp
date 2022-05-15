<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../../../header.jsp"></jsp:include>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-4">
			<div class="card">
				<div class="card-header">
					<h3>Formulaire d'ajout de produit</h3>
				</div>
				<div class="card-body">
					<form action="Produit" method="post">
						<div class="form-group">
							<label>Nom du produit</label>
							<input type="text" class="form-control" name="nomProduit" required="required">
						</div>
					
						<div class="form-group">
							<label>Prix unitaire</label>
							<input type="number" class="form-control" name="prix" required="required">
						</div>
						
						<div class="form-group">
							<label>Quantité stock</label>
							<input type="number" class="form-control" name="qte" required="required">
						</div>
						
						<div class="form-group">
							<label>Date d'expiration</label>
							<input type="date" class="form-control" name="date" required="required">
						</div>
						
						 <div class="form-group">
						    <label for="exampleFormControlSelect1">Catégorie du produit</label>
						    <select class="form-control" name="categorie" required="required">
						    <option selected>Selectionner la categorie</option>
						    <c:forEach items="${list_categories}" var="cat">
						   	  
						      <option value="${car.id}">${cat.libelle}</option>
						    </c:forEach>
						    </select>
						  </div>
						
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
					<h3 class="card-title-center">Liste des produits</h3>
				</div>
				<div class="card-body">
					<table class="table table-striped table-bordered">
						<tr>
							<th>Nom produit</th>
							<th>Prix unitaire</th>
							<th>Qte en stock</th>
							<th>Date exp</th>
							<th>Categorie</th>
							<th>Action</th>
							<th>Action</th>
						</tr>
						<c:forEach items="${list_produits}" var="p">
							<tr>
								<td>${p.nomProduit }</td>
								<td>${p.prixUnitaire }</td>
								<td>${p.qteStock }</td>
								<td>${p.dateExpiration }</td>
								<td>${p.idCat }</td>
								<td>Editer</td>
								<td>Supprimer</td>
							</tr>
						</c:forEach>
					</table>
				</div>
		</div>
		</div>
	
	</div>
	
	
	
	
</div>
<jsp:include page="../../../footer.jsp"></jsp:include>