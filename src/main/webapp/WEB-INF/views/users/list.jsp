<jsp:include page="../../../header.jsp"></jsp:include>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-4">
			<div class="card">
				<div class="card-header">
					<h3>Ajouter un utilisateur</h3>
				</div>
				<div class="card-body">
					<form action="">
						<div class="form-group">
							<label>Nom</label>
							<input type="text" class="form-control" required="required">
						</div>
					
						<div class="form-group">
							<label>Prenom</label>
							<input type="text" class="form-control" required="required">
						</div>
						
						<div class="form-group">
							<label>Login</label>
							<input type="email" class="form-control" required="required">
						</div>
						
						<div class="form-group">
							<label>Mot de passe</label>
							<input type="password" class="form-control" required="required">
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
							<th>Action</th>
						</tr>
					</table>
				</div>
		</div>
		</div>
	
	</div>
	
</div>
<jsp:include page="../../../footer.jsp"></jsp:include>