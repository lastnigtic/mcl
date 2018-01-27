<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html lang="en" class="fullscreen-bg">
<head>
	<title>注册 | Life+</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<!-- VENDOR CSS -->
	<link rel="stylesheet" href="/assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="/assets/vendor/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="/assets/vendor/linearicons/style.css">
	<!-- MAIN CSS -->
	<link rel="stylesheet" href="/assets/css/main.css">
	<!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
	<link rel="stylesheet" href="/assets/css/demo.css">
	<!-- GOOGLE FONTS -->
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
	<!-- ICONS -->
	<link rel="apple-touch-icon" sizes="76x76" href="/assets/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="assets/img/life.png">
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
</head>
<body>
	<!-- WRAPPER -->
	<div id="wrapper">
		<div class="vertical-align-wrap">
			<div class="vertical-align-middle">
				<div class="auth-box ">
					<div class="left">
						<div class="content">
							<div class="header">
								<%--<div class="logo text-center"><img src="/assets/img/life__.png" alt="Klorofil Logo"></div>--%>
								<p class="lead">欢迎注册大学生活 —— 企业端</p>
							</div>
							<form class="form-auth-small" action="/login.do" method="post" id="login-form">
								<div class="form-group">
									<label for="signin-uanme" class="control-label sr-only">账号</label>
									<input name="uname"  class="form-control" id="signin-uanme" value="" placeholder="账号">
								</div>
								<div class="form-group">
									<label for="signin-password" class="control-label sr-only">密码</label>
									<input name="upass" type="password" class="form-control" id="signin-password" value="" placeholder="密码">
								</div>
								<div class="form-group">
									<label for="signin-password" class="control-label sr-only">确认密码</label>
									<input  type="password" class="form-control" id="signin-password-again" value="" placeholder="确认密码">
								</div>
								<button type="submit" class="btn btn-primary btn-lg btn-block" id="button-login">注册</button>
								<c:if test="${!empty msg}">
									<br/>
									<p style="color: red">错误:${msg}</p>
								</c:if>
							</form>
						</div>
					</div>
					<div class="right">
						<div class="overlay"></div>
						<div class="content text">
							<h1 class="heading">大学生活</h1>
							<p>为您提供特别的服务</p>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
	<!-- END WRAPPER -->
</body>
</html>
<script>
	$(function(){
        $("#button-login").click(function(){
            var name = $("#signin-uanme").val();
            var pass = $("#signin-password").val();
            if(name==null||pass==null||name==''||pass==''){
                alert("未输入账号密码");
                return ;
            }
            $("form").submit();
        });
        
    })
</script>
