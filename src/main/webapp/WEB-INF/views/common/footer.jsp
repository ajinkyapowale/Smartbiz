<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
 -->
<script
	src="<c:url value="/theme/includes/bootstrap-4.1.1/js/bootstrap.min.js" />"></script>
<script
	src="<c:url value="/theme/includes/bootstrap-4.1.1/js/bootstrap.bundle.min.js" />"></script>
<script src="<c:url value="/theme/includes/jcf/js/jcf.js" />"></script>
<script src="<c:url value="/theme/includes/jcf/js/jcf.select.js" />"></script>
<script src="<c:url value="/theme/includes/jcf/js/jcf.radio.js" />"></script>
<script src="<c:url value="/theme/includes/jcf/js/jcf.checkbox.js" />"></script>
<script>
	$('document').ready(function(){
		jcf.replaceAll();
		$('[data-toggle="tooltip"]').tooltip();
	});
</script>
<script src="<c:url value="/theme/js/smartbiz_ajax_service.js" />"></script>
<script src="<c:url value="/theme/js/utility_functions.js" />"></script>