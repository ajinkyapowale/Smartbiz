<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-primary">
	<a class="navbar-brand text-uppercase" href="#"> <img
		src="<c:url value="/theme/images/icons/NoBackground/web_hi_res_512.png" />" />smartBiz
	</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarCollapse" aria-controls="navbarCollapse"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarCollapse">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item">
				<%-- <security:authorize access="hasAnyAuthority('ADMIN')">
					<a class="nav-link" href="<c:url value="/admin" />">Home <!-- <span class="sr-only">(current)</span> --></a>
				</security:authorize>
				<security:authorize access="hasAnyAuthority('SALES_PERSON')">
					<a class="nav-link" href="<c:url value="/sp" />">Home <!-- <span class="sr-only">(current)</span> --></a>
				</security:authorize> --%>
				
			</li>
			<!-- <li class="nav-item"><a class="nav-link" href="#">Link</a></li>
			<li class="nav-item"><a class="nav-link disabled" href="#">Disabled</a>
			</li> -->
		</ul>
		<form class="form-inline mt-2 mt-md-0">
			<input class="form-control mr-sm-2 nav-search" type="text"
				placeholder="&#xF002;" aria-label="Search" />
		</form>
		<ul class="navbar-nav navbar-right">
			<%-- <li><security:authorize access="isAuthenticated()"> 
					Howdy <security:authentication property="principal.firstName" />! 
				</security:authorize></li> --%>
			<li class="nav-item"><a class="nav-link"
				href="<c:url value="/logout" />" data-toggle="tooltip"
				data-placement="bottom" title="Logout"><i
					class="fa fa-lg fa-sign-out-alt"></i></a></li>
		</ul>
	</div>
</nav>