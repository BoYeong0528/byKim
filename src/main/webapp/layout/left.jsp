<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<!--  class="active" -->
		<c:forEach items="${bbsList }" var="bbs">
<%-- 			<li><a href="${pageContext.request.contextPath }/${bbs.bbs_name }">${bbs.bbs_name }</a></li> --%>
			<li><a href="${pageContext.request.contextPath }/board?cpage=${bbs.bbs_seq }&name=${bbs.bbs_name}">${bbs.bbs_name }</a></li>
		</c:forEach>
		${path }
	</ul>
</div>