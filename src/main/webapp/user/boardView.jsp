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
		$('form').attr('action', '${pageContext.request.contextPath }/oneBoardEdit');
		
		$('#modify').click(function(){
			$('#yn').val('modify');
			$('form').submit();
		})
		$('#delete').click(function(){
			$('#yn').val('delete');
			$('form').submit();
		})
		$('#reply').click(function(){
			$('form').attr('action', '${pageContext.request.contextPath }/boardReply');
			$('form').submit();
		})
		$('#setRP').click(function(){
			if($('.tea').val().trim().length==0) {
				alert("댓글을 작성해주세요");
				return;
			}
			$('form').attr('action', '${pageContext.request.contextPath }/reply');
			$('form').submit();
		})
		$('.rebutton').click(function(){
			var rp_seq =$(this).attr('idx');
			$('#rp_seq').val(rp_seq);
			$('form').attr('action', '${pageContext.request.contextPath }/replyYN');
			$('form').submit();
		})
		$('#replyarea').keyup(function(e){
			  var content = $(this).val();
	          $('#sap').text(content.length + '/500');
	    });
	    $('#replyarea').keyup();
	})
</script>
<style>
	.table-stripeds tbody tr:nth-of-type(even){
		background-color:rgba(0,0,0,0.1);
	}
	.table-dark {color:#3a3a3a;background-color:#cccccc}
	.div{ 
		padding:20px;
	}
	input{
		width:100%;
	}
	td{
		padding:2px;
	}
	.textarea{
		width:100%;
		height:400px;
	}
	.tea{
		width:90%;
		height:50px;
		vertical-align: middle;
	}
	.bt{
		width:9%;
		height:50px;
		vertical-align: middle;
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

            
          		<div class="table-responsive">
	            	<!-- Table -->
					<div class="div" >
					<form action="${pageContext.request.contextPath }/oneBoardEdit" method="post">
						<input type="hidden" name="pbd_seq" value="${vo.bd_seq }">
						<input type="hidden" name="userid" value="${vo.bd_reg_id }">
						<input type="hidden" name="cpage" value="${vo.bd_bbs_seq }">
						<input type="hidden" name="rp_seq" value="" id="rp_seq">
						<input type="hidden" name="yn" value="" id="yn">
						<table width="100%">
							<tr>
								<td><label>${vo.bd_title }</label></td>
							</tr>
							<tr>
								<td>작성자 : ${vo.bd_reg_id } &nbsp;&nbsp;&nbsp; 작성일시 : ${vo.bd_reg_dt }</td>
							</tr>
							<tr>
								<td><textarea class="textarea" name="bd_content" readonly="readonly">${vo.bd_content }</textarea></td>
							</tr>
							<tr>
							<c:forEach items="${attlist }" var="atlist">
								<img src="${pageContext.request.contextPath }/images/${atlist.att_path}" width="100px;" height="auto">
							</c:forEach>
							</tr>
						</table>
			          <div class="right"  align="right">
			          	<button type="button" id="reply">답글</button>&nbsp;
			          	<c:if test="${userId eq vo.bd_reg_id}">
			          		<button type="button" id="modify">수정</button>&nbsp;
				          	<button type="button" id="delete">삭제</button>&nbsp;
			          	</c:if>
			          </div>
			          <div width="100%" style="padding: 5px">
			          		<textarea maxlength="10" id="replyarea" class="tea" name="rp_content"></textarea>
			          		<button class="bt" type="button" id="setRP" >댓글등록</button>
			          		<p>남은 글자 : <span id="sap">100</span></p>
			          </div>
					  <table class="table table-stripeds table-dark">
					  	<c:forEach items="${rplist }" var="list">
					  		<tr>
					  			<td width="10%">${list.rp_mem_id }</td>
					  			<td width="55%">${list.rp_content }</td>
					  			<td width="15%" align="right">${list.rp_reg_dt }</td>
					  			<td width="15%" align="right">
					  				<c:if test="${userId eq list.rp_mem_id}">
<!-- 						  				<button class="btn btn-primary btn-sm"  type="button" id="repmodify">수정</button>&nbsp; -->
					          			<button class="btn btn-primary btn-sm rebutton" type="button" idx="${list.rp_seq }">삭제</button>&nbsp;
				          			</c:if>
					  			</td>
					  		</tr>
					  	</c:forEach>
					  </table>
					</form>
					</div>
	          </div>
         
        </div>
      </div>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/holder.js"></script>


</body>
</html>