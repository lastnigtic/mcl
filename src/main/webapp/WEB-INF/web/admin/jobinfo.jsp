<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<!doctype html>
<html lang="en">

<head>
	<title>Profile</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<!-- VENDOR CSS -->
	<link rel="stylesheet" href="/assets/vendor/bootstrap/css/bootstrap.min.css">
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
	<style type="text/css">
		.media{
			padding: 20px 0;
		}
		.media-heading{
			padding: 16px 0;
		}
		.media-head-info{
			padding-bottom: 22px;
			border-bottom: 2px solid #ededed;
		}
		.media-main-info .title{
			padding: 20px 0;
		}
	</style>
</head>

<body>
	<!-- WRAPPER -->
	<div id="wrapper">
		<%@ include file="/public/top_nav.jsp"%><!--管理员的侧边栏和顶栏需要另外抽出来-->
		<%@ include file="/public/admin_left_sidebar.jsp"%>
		<!-- MAIN -->
		<div class="main">
			<!-- MAIN CONTENT -->
			<div class="main-content">
				<div class="container-fluid">
					<div class="panel panel-profile">
						<div class="clearfix">
							<div class="media col-md-8 col-md-offset-2">
								<div class="media-body">
									<h2 class="media-heading">${job.jobname}</h2>
									<div class="media-head-info">
										<p>2018-01-28 更新</p>
										<p>120元/天 &nbsp;|&nbsp; 成都 &nbsp;|&nbsp; 本科 &nbsp;|&nbsp; 4天／周 &nbsp;|&nbsp; 实习6个月</p>
										<p>职位诱惑：有爱团队，领先实习薪资，快速成长</p>
									</div>
									<div class="media-main-info">
										<h3 class="title">职位描述</h3>
										<p class="detial">
											工作内容<br>
											撰写教学讲义<br>
											制作&录入教学数据<br>
											负责校对中英文字幕<br>
									  	岗位要求<br>
											高校在校生<br>
											中英文功底扎实（六级500+／专八60+／雅思6.5分+／托福90分+）<br>
											主动性强、有责任心、做事细致、有条理<br>
											良好的沟通能力和团队协作能力<br>
											这样的你更加分哟<br>
											有字幕组工作经验<br>
											有留学或交换经历<br>
											爱看美剧、外国综艺<br>
											</p>
										<h3 class="title">截止时间</h3>
										<p class="detail">2018-03-03</p>
									</div>
								</div>
								<div class="media-right">
									<a href="#">
										<img class="media-object" src="assets/img/user-medium.png" alt="...">
										<h3 class="text-center">百词斩<h3>
										</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- END MAIN CONTENT -->
			</div>
			<!-- END MAIN -->
			<div class="clearfix"></div>
			<footer>
				<div class="container-fluid">
					<p class="copyright">Copyright &copy; 2017.Company name All rights reserved.</p>
				</div>
			</footer>
		</div>
		<!-- END WRAPPER -->
		<!-- Javascript -->
		<script src="/assets/vendor/jquery/jquery.min.js"></script>
		<script src="/assets/vendor/bootstrap/js/bootstrap.min.js"></script>
		<script src="/assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
		<script src="/assets/scripts/klorofil-common.js"></script>
	</body>

	</html>