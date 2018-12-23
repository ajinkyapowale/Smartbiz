<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<link href="<c:url value="/theme/includes/datatables/datatables.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/theme/css/admin/vendorList.css" />"
	rel="stylesheet">
	

<fmt:setBundle basename="messages" />
<fmt:message key="message.password" var="noPass" />

<div role="main" class="container">

	<div class="floatingActionPanel">
		<div class="floatingConfirmButton disabled" id=""></div>
		<div class="floatingCancelButton" id=""></div>
		<div class="floatingActionDrawerButton" id=""></div>
		<div class="floatingActionButton" id="addVendorBtn"
			data-toggle="modal" data-target="#vendorFormModal"
			data-toggle="tooltip" data-placement="bottom" title="Add">
			<i class="fa fa-plus "></i>
		</div>
		<div class="floatingActionButton" id="editVendorBtn"
			data-toggle="tooltip" data-placement="bottom" title="Edit">
			<i class="fas fa-pencil-alt "></i>
		</div>
		<div class="floatingActionButton" id="deleteVendorBtn"
			data-toggle="tooltip" data-placement="bottom" title="Delete">
			<i class="fa fa-trash "></i>
		</div>
	</div>

	<div class="table-responsive">
		<c:choose>
			<c:when test="${fn:length(vendors) gt 0}">
				<table id="vendorTbl" class="table table-striped table-hover">
					<thead class="thead-light">
						<tr>
							<th class="singleSelect"></th>
							<th class="multiSelect"></th>
							<th>Sr No.</th>
							<th>Vendor Name</th>
							<th>Date Added</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${vendors}" var="vendor" varStatus="status">
							<tr vid="${vendor.vid}">
								<td class="singleSelect"><input type="radio"
									name="selectedVendor" value="${vendor.vid}"
									vName="${vendor.name}" /></td>
								<td class="multiSelect"><input type="checkbox"
									name="selectedVendors" value="${vendor.vid}"
									vName="${vendor.name}" /></td>
								<td>${status.count}</td>
								<td>${vendor.name}</td>
								<td><fmt:formatDate pattern="dd/MM/yyyy"
										value="${vendor.createdOn}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:otherwise>
				<h5 class="text-center">No Vendors to show.</h5>
			</c:otherwise>
		</c:choose>
	</div>

</div>

<!-- Vendor Form Modal -->
<div class="modal fade" id="vendorFormModal" tabindex="-1" role="dialog"
	aria-labelledby="vendorFormModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="vendorFormModalLabel"></h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form id="vendorForm" class="">
					<input type="hidden" name="vid" />
					<div class="form-group col-sm-6 col-md-4 col-lg-3">
						<label for="vendorName">Vendor name</label> <input type="text"
							class="form-control " id="vendorName"
							aria-describedby="vendorNameError"
							placeholder="Enter vendor name" name="name"> <label
							id="vendorNameError" class=""></label>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
				<button type="submit" class="btn btn-primary" id="saveVendorBtn">Save
					changes</button>
			</div>
		</div>
	</div>
</div>

<!-- Vendor View Modal -->
<div class="modal fade" id="vendorViewModal" tabindex="-1" role="dialog"
	aria-labelledby="vendorViewModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title " id="vendorFormModalLabel">
					<i class="fa fa-info-circle text-info"></i> Vendor - <span
						class="modalVendorName"></span>
				</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="form-group col-sm-6 col-md-4 col-lg-3">
						<label for="name">Vendor name</label> <label id="name"
							class="formValue"></label>
					</div>
					<div class="form-group col-sm-6 col-md-4 col-lg-3">
						<label for="createdOn">Date of Joining</label> <label
							id="createdOn" class="formValue"></label>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-info" data-dismiss="modal">OK</button>
			</div>
		</div>
	</div>
</div>

<!-- Warning Modal -->
<div class="modal fade" id="deleteVendorWarning" tabindex="-1"
	role="dialog" aria-labelledby="deleteVendorLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="deleteModal">
					<i class="fa fa-exclamation-triangle text-warning"></i> Confirm
					Delete
				</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				Do you really want to delete "<strong id="modalVendorName"></strong>"?
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-danger" data-dismiss="modal"
					id="deleteVendorConfirmBtn">Yes</button>
				<button type="button" class="btn btn-warning" data-dismiss="modal">No</button>
			</div>
		</div>
	</div>
</div>

<%-- <script src="<c:url value="/theme/includes/datatables/datatables.min.js" />"></script> --%>
<script src="<c:url value="/theme/includes/jquery.validate.1.17.0/jquery.validate.min.js" />"></script>
<script src="<c:url value="/theme/js/fab.js" />"></script>
<script src="<c:url value="/theme/js/admin/vendorList.js" />"></script>