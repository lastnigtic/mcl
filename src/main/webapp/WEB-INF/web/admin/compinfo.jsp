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
							<!-- LEFT COLUMN -->
							<div class="col-md-12">
								<!-- PROFILE HEADER -->
								<div class="profile-header">
									<div class="overlay"></div>
									<div class="profile-main">
										<img src="${comp.imgurl}" class="img-circle" alt="Avatar">
										<h3 class="name">${comp.companyname}</h3>
									</div>
									<div class="profile-stat">
										<div class="row">
											<div class="col-md-4 stat-item">
												${comp.city}
											</div>
											<div class="col-md-4 stat-item">
												${comp.companysize}
											</div>
											<div class="col-md-4 stat-item">
												${comp.industry}
											</div>
										</div>
									</div>
								</div>
								<!-- END PROFILE HEADER -->
							</div>
							<!-- END LEFT COLUMN -->
							<!-- RIGHT COLUMN -->
							<div class="col-md-12">
								<!-- TABBED CONTENT -->
								<%--<div class="custom-tabs-line tabs-line-bottom  text-center">--%>
									<%--<ul class="nav row" role="tablist" style="display: block">--%>
										<%--<li class="active col-md-6"><a href="#tab-bottom-left1" role="tab" data-toggle="tab">企业信息</a></li>--%>
										<%--<li class="col-md-6"><a href="#tab-bottom-left2" role="tab" data-toggle="tab">在招职位</a></li>--%>
									<%--</ul>--%>
								<%--</div>--%>
								<div class="tab-content">
									<div class="tab-pane fade in active" id="tab-bottom-left1">
										<h3>企业介绍</h3>
										<p style="line-height: 2em">${comp.introduction}</p>
										<h3>企业网址</h3>
										<span>${comp.companyname}:<span>
										<a href="${comp.website}">${comp.website}</a>
										<h3>工商信息</h3>
										<ul class="list-unstyled">
											<li>注册号：${comp.companylicense}</li>
											<li>成立日期：<span class="J-Date">${comp.setuptime}</span></li>
											<li>融资阶段：${comp.financingstage}</li>
										</ul>
									</div>
									<%--<div class="tab-pane fade" id="tab-bottom-left2">--%>
										<%--<div class="table-responsive">--%>
											<%--<table class="table project-table">--%>
												<%--<thead>--%>
													<%--<tr>--%>
														<%--<th>实习名称</th>--%>
														<%--<th>地区</th>--%>
														<%--<th>工资</th>--%>
														<%--<th>天数</th>--%>
														<%--<th>月数</th>--%>
														<%--<th>更新日期</th>--%>
													<%--</tr>--%>
												<%--</thead>--%>
												<%--<tbody>--%>
													<%--<tr>--%>
														<%--<td>百词斩编辑</td>--%>
														<%--<td>成都</td>--%>
														<%--<td>120/天</td>--%>
														<%--<td>4天</td>--%>
														<%--<td>6月</td>--%>
														<%--<td>2018-01-27 更新</td>--%>
													<%--</tr>--%>
													<%--<tr>--%>
														<%--<td>百词斩编辑</td>--%>
														<%--<td>成都</td>--%>
														<%--<td>120/天</td>--%>
														<%--<td>4天</td>--%>
														<%--<td>6月</td>--%>
														<%--<td>2018-01-27 更新</td>--%>
													<%--</tr>--%>
												<%--</tbody>--%>
											<%--</table>--%>
										<%--</div>--%>
									<%--</div>--%>
								</div>
								<!-- END TABBED CONTENT -->
							</div>
							<!-- END RIGHT COLUMN -->
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
