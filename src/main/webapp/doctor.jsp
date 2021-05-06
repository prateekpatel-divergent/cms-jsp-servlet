<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Doctor</title>

<script src="resources/js/bootstrap.min.js"></script>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>


	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-6">
						<form class="form-horizontal" action="doctorController"
							method="POST">
							<fieldset>

								<!-- Form Name -->
								<legend>Doctor Add</legend>


								<!-- Text input-->
								<div class="form-group">
									<label class="col-md-4 control-label" for="name">Name</label>
									<div class="col-md-4">
										<input id="name" name="name" type="text" placeholder=""
											class="form-control input-md">

									</div>
								</div>

								<!-- Text input-->
								<div class="form-group">
									<label class="col-md-4 control-label" for="speciality">Speciality</label>
									<div class="col-md-4">
										<input id="speciality" name="speciality" type="text" placeholder=""
											class="form-control input-md">

									</div>
								</div>

								<div class="form-group">
									<label class="col-md-4 control-label" for="contactno">Contact No</label>
									<div class="col-md-4">
										<input id="contactno" name="contactno" type="number" placeholder=""
											class="form-control input-md">

									</div>
								</div>

								<div class="form-group">
									<label class="col-md-4 control-label" for="fee">Fee</label>
									<div class="col-md-4">
										<input id="fee" name="fee" type="number" placeholder=""
											class="form-control input-md">

									</div>
								</div>

								<div class="form-group">
									<label class="col-md-4 control-label" for="degree">Degree</label>
									<div class="col-md-4">
										<input id="degree" name="degree" type="text" placeholder=""
											class="form-control input-md">

									</div>
								</div>

								<!-- Button -->
								<div class="form-group">
									<label class="col-md-4 control-label" for="add"></label>
									<div class="col-md-4">
										<input type="submit" class="btn btn-info" value="Add Doctor">
									</div>
								</div>

							</fieldset>
						</form>
					</div>
					<div class="col-md-6"></div>
				</div>

				<div class="row">
					<div class="col-md-6">
						<legend>Doctor List</legend>
						<div class="table-responsive">
							<table id="example" class="table table-striped table-bordered">
								<thead>
									<tr>
										<th>Id</th>
										<th>Name</th>
										<th>Speciality</th>
										<th>Contact No</th>
										<th>Fee</th>
										<th>Degree</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${allDoctor}" var="doctor">
										<tr>
											<td><c:out value="${doctor.id}" /></td>
											<td><c:out value="${doctor.name}" /></td>
											<td><c:out value="${doctor.speciality}" /></td>
											<td><c:out value="${doctor.contactno}" /></td>
											<td><c:out value="${doctor.fee}" /></td>
											<td><c:out value="${doctor.degree}" /></td>
											<td><a href="doctorController?id=${doctor.id}"
												class="btn btn-danger" type="button">Delete</a></td>
											<td><a href="doctorController?id=${doctor.id}"
												class="btn btn-danger" type="button">Search</a></td>

										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<div class="col-md-6"></div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>