<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

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
							<img src="<c:url value="/theme/images/icons/NoBackground/web_hi_res_512.png" />"
								style="height: 36px;" />
						</div>
						<div class="col">
							<h5 class="font-weight-normal" style="margin: 4px 0 0 0;">
								<spring:message code="message.signin"></spring:message>
							</h5>
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
							<input type="checkbox" id="rememberMeChk" name="remember-me"/> <label
								title="RememberMe" for="chk1">Remember Me</label>
						</div>

						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<button type="submit"
							class="btn btn-lg btn-block btn-outline-primary"><spring:message code="message.login"></spring:message></button>
					</form>
				</div>
			</div>
			<c:if test="${param.error != null}">
			    <div class="text-danger text-center" id="error">
			        <spring:message code="message.badCredentials">   
			        </spring:message>
			    </div>
			</c:if>
		</div>
	</div>
</div>
