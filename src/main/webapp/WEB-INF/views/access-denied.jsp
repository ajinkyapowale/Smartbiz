<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div role="main" class="container">
	<div class="jumbotron  d-none d-md-block">
		<div class="row">
			<div class="col-auto">
				<i class="fa fa-map-signs fa-10x text-secondary"></i>
			</div>
			<div class="col">
				<h1 class="display-4 text-danger">
					<spring:message code="message.unauth"></spring:message>
		        </h1>
				<p class="lead">
					<spring:message code="message.unauth.desc"></spring:message>
				</p>
				<hr class="my-4">
				<p>
					<spring:message code="message.help_admin"></spring:message>
		        </p>
			</div>
		</div>
	</div>
	<div class="jumbotron d-block d-md-none">
		<h1 class="font-weight-normal text-danger text-center">
			<spring:message code="message.unauth"></spring:message>
		</h1>

		<div class="row  justify-content-md-center">
			<div class="col-auto">
				<i class="fa fa-map-signs fa-5x text-secondary"></i>
			</div>
			<div class="col">
				<p class="lead">
					<spring:message code="message.unauth.desc"></spring:message>
				</p>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<hr class="my-4">
				<p>
					<spring:message code="message.help_admin"></spring:message>
		        </p>
			</div>
		</div>
	</div>
</div>