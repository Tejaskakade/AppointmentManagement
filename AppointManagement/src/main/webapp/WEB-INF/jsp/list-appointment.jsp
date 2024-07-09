<%@ include file="common/header.jspf"%>

<%@include file="common/navigation.jspf"%>

<div class="container mt-3">

	<div>

		<a type="button" class="btn btn-primary btn-md"
			href="/add-appointment">Appointment</a>

	</div>

	<br>

	<div class="panel panel-primary">

		<div class="panel-heading">

			<h3>List of Appointment</h3>

		</div>

		<div class="panel-body">

			<table class="table table-striped">

				<thead>

					<tr>

						<th width="40%">Description</th>

						<th width="40%">Target Date</th>

						<th width="20%"></th>


					</tr>

				</thead>

				<tbody>

					<c:forEach items="${appointments}" var="appointment">

						<tr>

							<td>${appointment.description}</td>
							<td><fmt:formatDate value="${appointment.targetDate}"
									pattern="dd/MM/yyyy" /></td>

							<td><a type="button" class="btn btn-success"
								href="/update-appointment-form?id=${appointment.id}">Update</a> <a type="button"
								class="btn btn-warning" href="/delete-appointment?id=${appointment.id}">Delete</a></td>

						</tr>

					</c:forEach>



				</tbody>

			</table>

		</div>

	</div>

</div>

<%@include file="common/footer.jspf"%>


