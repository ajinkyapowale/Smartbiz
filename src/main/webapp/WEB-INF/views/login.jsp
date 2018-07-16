<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%-- <%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%> --%>
<%-- <div class="container">
	<p>
		<font color="red">${errorMessage}</font>
	</p>
	<form action="/login" method="POST">
		<fieldset class="form-group">
			<label>Name</label> <input name="name" type="text"
				class="form-control" />
		</fieldset>
		<fieldset class="form-group">
			<label>Password</label> <input name="password" type="password"
				class="form-control" />
		</fieldset>
		<button type="submit" class="btn btn-success">Submit</button>
	</form>

</div> --%>

<fmt:setBundle basename="messages" />
<fmt:message key="message.password" var="noPass" />
<fmt:message key="message.username" var="noUser" />

<div role="main" class="container">
	<div class="row justify-content-md-center">
		<div class="col-lg-6 col-md-8 col-xs-12">
			<div class="card">
				<div class="card-header bg-primary text-white">
					<div class="row justify-content-start">
						<div class="col-auto">
							<img src="theme/images/icons/NoBackground/web_hi_res_512.png"
								style="height: 36px;" />
						</div>
						<div class="col">
							<h5 class="font-weight-normal" style="margin: 4px 0 0 0;">Sign
								in</h5>
						</div>
					</div>
				</div>
				<div class="card-body">
					<form action="login" method="POST">
						<div class="form-group">
							<label for="username">User name</label> <input type="text"
								class="form-control" id="username" name="username"
								placeholder="Email Id">
						</div>
						<div class="form-group">
							<label for="password">Password</label> <input type="password"
								class="form-control" id="password" name="password"
								placeholder="Password">
						</div>
						<div class="form-group">
							<input type="checkbox" id="rememberMeChk" checked="checked" name="remember-me"/> <label
								title="RememberMe" for="chk1">Remember Me</label>
						</div>

						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<button type="submit"
							class="btn btn-lg btn-block btn-outline-primary">Login</button>
					</form>
				</div>
			</div>
			<c:if test="${param.error != null}">
			    <div class="text-danger text-center" id="error">
			        <spring:message code="message.badCredentials">   
			        </spring:message>
			       <!--  Invalid User name or password! -->
			    </div>
			</c:if>
			<%-- <p>
				<font color="red">${errorMessage}</font>
			</p> --%>
		</div>
	</div>
</div>

<%-- <%@ include file="common/footer.jspf"%> --%>
