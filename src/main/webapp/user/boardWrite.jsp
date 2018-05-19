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
<script src="${pageContext.request.contextPath}/SE2/js/HuskyEZCreator.js"></script>
<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath }/css/dashboard.css" rel="stylesheet">
<%@ include file="/include/jsscript.jsp" %>
<script>
	$(function(){
		var oEditors = []; // 개발되어 있는 소스에 맞추느라, 전역변수로 사용하였지만, 지역변수로 사용해도 전혀 무관 함.

		$(document).ready(function() {
			// Editor Setting
			nhn.husky.EZCreator.createInIFrame({
				oAppRef : oEditors, // 전역변수 명과 동일해야 함.
				elPlaceHolder : "smarteditor", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
				sSkinURI : "${pageContext.request.contextPath}/SE2/SmartEditor2Skin.html", // Editor HTML
				fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
				htParams : {
					// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
					bUseToolbar : true,
					// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
					bUseVerticalResizer : true,
					// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
					bUseModeChanger : true, 
				}
			});
		})	
		$('#write').click(function(){
			if( $('input[type=text]').val().trim().length == 0 ){
				alert("제목을 입력해주세요");
				return;
			}
			var contents = $.trim(oEditors[0].getContents());
			if(contents === '<p>&nbsp;</p>' || contents === ''){
				alert("내용을 입력하세요.");
				return;
			}
			oEditors.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);
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

            <form action="${pageContext.request.contextPath }/boardWrite" method="post" enctype="multipart/form-data">
<%--             <form action="${pageContext.request.contextPath }/boardWrite?cpage=<%=request.getParameter("cpage") %>" method="post"> --%>
          		<input type="hidden" name="pbd_seq" value="${BD_SEQ }">
          		<div class="table-responsive">
	            	<!-- Table -->
					<div class="div" >
						<table width="100%">
							<tr>
								<td><input type="text" name="bd_title" placeholder="제목을 입력해주세요" ></td>
							</tr>
							<tr>
								<td><textarea name="bd_content" id="smarteditor"></textarea></td>
							</tr>
							<tr>
								<td>
									<input type="file" name="att_path">
									<input type="file" name="att_path">
									<input type="file" name="att_path">
									<input type="file" name="att_path">
									<input type="file" name="att_path">
								</td>
							</tr>
						</table>
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