<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<title>Free Board</title>
<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath }/css/dashboard.css" rel="stylesheet">
<%@ include file="/include/jsscript.jsp" %>
<script>
	$(function(){
		$('a').click(function(){
			var idx = $(this).attr('idx');
			$('#res').val(idx);
			var userid = $(this).attr('idid');
			$('#resId').val(userid);
			$('form').attr('action', '${pageContext.request.contextPath }/oneBoard');
			$('form').submit();
		})
	})
</script>
<style>
	a{
		text-decoration:none !important
	}
</style>
</head>
<body>

	<%@ include file='/layout/header.jsp' %>

    <div class="container-fluid">
      <div class="row">
        <%@ include file='/layout/left.jsp' %>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">${bname }</h1>

            <form action="${pageContext.request.contextPath }/user/boardWrite.jsp?cpage=${cpage}" method="post">
          		<div class="table-responsive">
	            	<!-- Table -->
						<table class="table">
							<tr>
								<th width="10%">번호</th>
								<th width="60%">제목</th>
								<th width="10%">작성자</th>
								<th width="20%">작성일시</th>
							</tr>
							<c:forEach items="${bdlist }" var="list">
								<tr>
									<td>${list.rn }</td>
									<td>
											<a href="#" idx="${list.bd_seq }" idid="${list.bd_reg_id }">${list.bd_title }</a>
									</td>
									<td>${list.bd_reg_id }</td>
									<td>${list.bd_reg_dt }</td>
								</tr>
							</c:forEach>
						</table>
			          <div class="right"  align="right">
			          <button type="submit" id="write">글쓰기</button>
			          </div>
						<div style="width:100%; text-align:center;">
							${pageNav }
						</div>
					<input type="hidden" id="res" name="bd_seq" value="">
					<input type="hidden" id="resId" name="bd_reg_id" value="">
	          </div>
          </form>
        </div>
      </div>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/holder.js"></script>


</body>
</html>