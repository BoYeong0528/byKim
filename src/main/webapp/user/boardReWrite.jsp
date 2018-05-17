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
		$('#write').click(function(){
			if( $('input[type=text]').val().trim().length == 0 ){
				alert("제목을 입력해주세요");
				return;
			}
			if( $('textarea').val().trim().length == 0 ){
				alert("내용을 입력해주세요");
				return;
			}
			$('form').submit();
		})
		
	})
</script>
<style>
	.div{ 
		padding:20px;
	}
	input{
		width:100%;
	}
	td{
		padding:2px;
	}
	textarea{
		width:100%;
		height:400px;
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

            <form action="${pageContext.request.contextPath }/boardReWrite" method="post">
          		<div class="table-responsive">
	            	<!-- Table -->
					<div class="div" >
						<table width="100%">
							<tr>
								<td><input type="text" name="bd_title" placeholder="제목을 입력해주세요" value="${vo.bd_title }"></td>
							</tr>
							<tr>
								<td><textarea name="bd_content" placeholder="내용을 입력해주세요">${vo.bd_content }</textarea></td>
							</tr>
							<tr>
								<td><input type="file" name="att_path"></td>
							</tr>
						</table>
						<input type="hidden" name="bd_seq" value="${vo.bd_seq }">
			          <div class="right"  align="right">
			          	<button type="button" id="write">글쓰기</button>
			          </div>
					</div>
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