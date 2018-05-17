<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath }/css/signin.css" rel="stylesheet">
<%@ include file="/include/jsscript.jsp" %>
<script>
	$(function(){
		function login(){
			if( $('#mem_id').val().trim().length==0 ){
				alert("아이디를 입력해주세요");
				return;
			}
			if( $('#mem_pass').val().trim().length==0 ){
				alert("비번을 입력해주세요");
				return;
			}
			
			$('form').attr('action', '${pageContext.request.contextPath }/userLogin')
					   .submit();
		}
		
		$('#loginbtn').click(function(){
			login();
		})
		
		$("input").keypress(function (key) {
	        if(key.keyCode == 13){//키가 13이면 실행 (엔터는 13)
	        	login();
	        }
	    })
	})
</script>
<style>
	.form-signin-heading{
		text-align: center;
	}
	a:link  { text-decoration: none;}
</style>
</head>
<body>

    <div class="container">

	      <form class="form-signin" method="post">
		        <h2 class="form-signin-heading">로&nbsp;&nbsp;&nbsp;그&nbsp;&nbsp;&nbsp;인</h2>
		        <label for="inputEmail" class="sr-only">I D</label>
		        <input type="text" id="mem_id" class="form-control" name="mem_id" placeholder="아이디를 입력해주세요" required autofocus>
		        <label for="inputPassword" class="sr-only">P W</label>
		        <input type="password" id="mem_pass" class="form-control" name="mem_pass" placeholder="비밀번호를 입력해주세요" required>
		        <button id="loginbtn" class="btn btn-lg btn-primary btn-block" type="button">로그인</button>
		        <a href="https://www.naver.com" class="nav navbar-right">회원가입&nbsp;&nbsp;&nbsp;&nbsp;</a>
	      </form>

    </div> 

  </body>
</html>
