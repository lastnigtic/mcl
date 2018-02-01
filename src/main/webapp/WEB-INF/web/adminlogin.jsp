<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html class="fullscreen-bg">

<head>
	<title>Login</title>
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
	<link rel="icon" type="image/png" sizes="96x96" href="/assets/img/favicon.png">
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
								<p class="lead">欢迎登陆大学生活 —— 管理端</p>
							</div>
							<div class="form-auth-small">
								<form action="/adminlogin.html" method="post">
									<div class="form-group">
										<label for="username" class="control-label sr-only">账号</label>
										<input id="username" name="id" class="form-control" placeholder="请输入账号名">
									</div>
									<div class="form-group">
										<label for="password" class="control-label sr-only">密码</label>
										<input type="password" name="pass" class="form-control" id="password" placeholder="请输入密码">
									</div>
									<div class="text-danger" style="display:none">账号或者密码输入错误</div>
									<button type="submit" class="btn btn-primary btn-lg btn-block" id="login">登录</button>
								</form>
							</div>
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
	<script type="text/javascript" src="/assets/vendor/jquery/jquery.min.js"></script>
	<script type="text/javascript">
//		$(function(){
//			$('#login').on('click', function(){
//				var id = $('#username');
//				if(!id.val()){
//					 id.parent().addClass('has-error')
//				}else{
//					id.parent().removeClass('has-error')
//				}
//				var pass = $('#password');
//				if(!pass.val()){
//					 pass.parent().addClass('has-error')
//				}else{
//					pass.parent().removeClass('has-error')
//				}
//				if(id && pass){
//
//					window.location.href = './charts.html'
//
//					$.get('http://139.199.209.108/mcl/admin/login.do?id='+id.val()+'&pass='+pass.val(), function(res){
//						if(res.status === 0){
//							console.log('登陆成功');
//							$(this).parent().find('.text-danger')[0].style.display = 'none';
//						}else{
//							$(this).parent().find('.text-danger')[0].style.display = 'block';
//						}
//					})
//				}
//			})
//		})
	</script>
</body>

</html>
