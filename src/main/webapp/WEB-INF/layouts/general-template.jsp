<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<sec:csrfMetaTags />

<link rel="icon shortcut"
	href="<c:url value="/theme/images/icons/Square/web_hi_res_512.png " />">

<title><tiles:getAsString name="title" /></title>
<!-- Bootstrap core CSS -->
<link
	href="<c:url value="/theme/includes/bootstrap-4.1.1/css/bootstrap.min.css" />"
	rel="stylesheet">

<!-- Third-party styles -->
<link
	href="<c:url value="/theme/includes/fontawesome-free-5.0.13/css/fontawesome-all.min.css" />"
	rel="stylesheet">
<!-- <link href="https://use.fontawesome.com/releases/v5.0.1/css/all.css" rel="stylesheet">-->
<link
	href="<c:url value="/theme/includes/jcf/css/theme-minimal/jcf.css" />"
	rel="stylesheet">

<!-- Custom styles -->
<link href="<c:url value="/theme/css/flatit.css" />" rel="stylesheet">
<link href="<c:url value="/theme/css/theme.css" />" rel="stylesheet">

<script src="<c:url value="/theme/js/jquery-3.3.1.min.js" />"></script>

</head>
<body>
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="menu" />
	<!-- Alerts -->
	<div class="alert" id="pageAlert"></div>
	
	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="footer" />
</body>
</html>