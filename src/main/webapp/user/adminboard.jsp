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
		$('.ynchange').click(function(){
			var idx = $(this).attr('idx');
			$('#res').val(idx);
			$('#frm').submit();
		})
	})

</script>
</head>
<body>

	<%@ include file='/layout/header.jsp' %>

    <div class="container-fluid">
      <div class="row">
        <%@ include file='/layout/left.jsp' %>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">게시판 관리</h1>
          <div class="table-responsive">
			<form action="${pageContext.request.contextPath }/chageyn" method="post" id="frm">
	          	<table class="table">
	          		<tr>
	          			<th>번호</th>
	          			<th>게시판이름</th>
	          			<th>게시일자</th>
	          			<th>활성화여부</th>
	          			<th></th>
	          		</tr>
	            	<c:forEach items="${adminbbslist }" var="list">
	            		<tr>
	            			<td>${list.rownum }</td>
	            			<td>${list.bbs_name }</td>
	            			<td>${list.bbs_dt }</td>
	            			<td>${list.bbs_yn }</td>
	            			<td>
								<c:choose>
									    <c:when test="${list.bbs_yn eq 'Y'}">
									        <input type="button" value="비활성화 하기" class="ynchange" idx="${list.bbs_seq }">
									    </c:when>
									    <c:otherwise>
									        <input type="button" value="활성화 하기" class="ynchange" idx="${list.bbs_seq }">
									    </c:otherwise>
								</c:choose>
							</td>
	            		</tr>
	            	</c:forEach>
	            </table>
				<input type="hidden" value="${list.bbs_seq }" id="res" name="bbs_seq">
	            </form>
	            <form action="${pageContext.request.contextPath }/user/addbbs.jsp" >
		            <div align="right">
		            	<button type="submit" >게시판 추가</button>
		            </div>
	            </form>
          </div>
        </div>
      </div>
    </div>
	
	
	
	
	
	
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/holder.js"></script>


</body>
</html>