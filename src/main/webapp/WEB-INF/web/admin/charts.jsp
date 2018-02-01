<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<!doctype html>
<html lang="en">

<head>
	<title>Charts</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<!-- VENDOR CSS -->
	<link rel="stylesheet" href="/assets/vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="/assets/vendor/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="/assets/vendor/linearicons/style.css">
	<link rel="stylesheet" href="/assets/vendor/chartist/css/chartist-custom.css">
	<link rel="stylesheet" href="/assets/vendor/chartist/css/chartist-tooltips.css">
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
					<h3 class="page-title">数据统计</h3>
					<div class="row">
						<div class="col-md-6">
							<div class="panel">
								<div class="panel-heading">
									<h3 class="panel-title">实习数量统计</h3>
								</div>
								<div class="panel-body">
									<div id="practice-count-chart" class="ct-chart"></div>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="panel">
								<div class="panel-heading">
									<h3 class="panel-title">实习申请数量统计</h3>
								</div>
								<div class="panel-body">
									<div id="practice-apply-chart" class="ct-chart"></div>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="panel">
								<div class="panel-heading">
									<h3 class="panel-title">普通用户数量统计</h3>
								</div>
								<div class="panel-body">
									<div id="user-count-chart" class="ct-chart"></div>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="panel">
								<div class="panel-heading">
									<h3 class="panel-title">企业用户数量统计</h3>
								</div>
								<div class="panel-body">
									<div id="company-count-chart" class="ct-chart"></div>
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
	<script src="/assets/vendor/chartist/js/chartist.min.js"></script>
	<script src="/assets/vendor/chartist/js/chartist-tooltips.js"></script>
	<script src="/assets/scripts/klorofil-common.js"></script>
	<script>
		$(function() {
			var options;

			var data = {
				labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
				series: [
				[200, 380, 350, 320, 410, 450, 570, 400, 555, 620, 750, 900],
				]
			};

		// 实习数量统计
		options = {
			height: "300px",
			showPoint: true, // 是否显示圆点
			axisX: {
				showGrid: false
			},
			lineSmooth: false,
			plugins: [
			Chartist.plugins.tooltip({
				tooltipFnc:function(index){
					return tip
				},
				transformTooltipTextFnc:function(e){
					tip = '总计: ' + e + ' 人';
					return tip;
				},
				appendToBody: true
			})
			]
		};

		new Chartist.Line('#practice-count-chart', data, options);

		// 实习申请数量统计
		options = {
			height: "300px",
			axisX: {
				showGrid: false
			},
			plugins:  [
			Chartist.plugins.tooltip({
				tooltipFnc:function(index){
					return tip
				},
				transformTooltipTextFnc:function(e){
					tip = '总计: ' + e + ' 人';
					return tip;
				},
				appendToBody: true
			})
			]
		};

		new Chartist.Bar('#practice-apply-chart', data, options);


		
		// 实习数量统计
		options = {
			height: "300px",
			showPoint: true, // 是否显示圆点
			axisX: {
				showGrid: false
			},
			lineSmooth: false,
			plugins: [
			Chartist.plugins.tooltip({
				tooltipFnc:function(index){
					return tip
				},
				transformTooltipTextFnc:function(e){
					tip = '总计: ' + e + ' 人';
					return tip;
				},
				appendToBody: true
			})
			]
		};

		new Chartist.Line('#user-count-chart', data, options);

		// 实习申请数量统计
		options = {
			height: "300px",
			axisX: {
				showGrid: false
			},
			plugins:  [
			Chartist.plugins.tooltip({
				tooltipFnc:function(index){
					return tip
				},
				transformTooltipTextFnc:function(e){
					tip = '总计: ' + e + ' 人';
					return tip;
				},
				appendToBody: true
			})
			]
		};

		new Chartist.Bar('#company-count-chart', data, options);

	});
</script>
</body>

</html>
