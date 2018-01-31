<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<title>Home</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<!-- VENDOR CSS -->
	<link rel="stylesheet" href="/assets/vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="/assets/vendor/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="/assets/vendor/linearicons/style.css">
	<link rel="stylesheet" href="/assets/vendor/toastr/toastr.min.css">
	<!-- MAIN CSS -->
	<link rel="stylesheet" href="/assets/css/main.css">
	<!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
	<link rel="stylesheet" href="/assets/css/demo.css">
	<!-- GOOGLE FONTS -->
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
	<!-- ICONS -->
	<link rel="apple-touch-icon" sizes="76x76" href="/assets/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="/assets/img/favicon.png">
	<style>
		#wrapper td{
			vertical-align: middle;
		}
		.J-Ctrl{
			cursor: pointer;
		}
	</style>
</head>

<body>
	<!-- WRAPPER -->
	<div id="wrapper">
		<%@ include file="/public/top_nav.jsp"%>
		<%@ include file="/public/left_sidebar.jsp"%>
		<!-- END LEFT SIDEBAR -->
		<!-- MAIN -->
		<div class="main">
			<!-- MAIN CONTENT -->
			<div class="main-content">
				<div class="container-fluid">
					<!-- OVERVIEW -->
					<div class="panel panel-headline">
						<div class="panel-heading">
							<h3 class="panel-title">信息审核</h3>
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-md-3 J-Ctrl" data-idx="0">
									<div class="metric">
										<span class="icon"><i class="lnr lnr-user"></i></span>
										<p>
											<span class="number">1,252</span>
											<span class="title">企业实名信息审核</span>
										</p>
									</div>
								</div>
								<div class="col-md-3 J-Ctrl" data-idx="1">
									<div class="metric">
										<span class="icon"><i class="fa fa-shopping-bag"></i></span>
										<p>
											<span class="number">203</span>
											<span class="title">企业实习岗位信息审核</span>
										</p>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- END OVERVIEW -->
					<div class="row" id="information"  style="display: none">
						<div class="col-md-12">
							<!-- RECENT PURCHASES -->
							<div class="panel">
								<div class="panel-heading">
									<h3 class="panel-title">企业实名信息审核</h3>
									<div class="right">
										<button type="button" class="btn-toggle-collapse"><i class="lnr lnr-chevron-up"></i></button>
									</div>
								</div>
								<div class="panel-body no-padding">
									<table class="table table-striped">
										<thead>
											<tr>
												<th>企业名称</th>
												<th>企业头目</th>
												<th>实名信息</th>
												<th>所属行业</th>
												<th>所属地区</th>
												<th>申请时间</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td><a href="#">世纪龙</a></td>
												<td>郑泳智</td>
												<td>不需要</td>
												<td>IT</td>
												<td>广州市番禺区锦官城</td>
												<td>2018-01-27</td>
												<td>
													<button data-type="information" class="btn btn-success btn-xs J-pass">通过</button>
													<button data-type="information" class="btn btn-danger btn-xs J-reject">拒绝</button>
												</td>
											</tr>
											<tr>
												<td><a href="#">世纪虫</a></td>
												<td>郑智</td>
												<td>不需要</td>
												<td>IT</td>
												<td>广州市番禺区锦官城</td>
												<td>2018-01-27</td>
												<td>
													<button data-type="information" class="btn btn-success btn-xs J-pass">通过</button>
													<button data-type="information" class="btn btn-danger btn-xs J-reject">拒绝</button>
												</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
							<!-- END RECENT PURCHASES -->
						</div>
					</div>
					<div class="row" id="job">
						<div class="col-md-12">
							<!-- RECENT PURCHASES -->
							<div class="panel">
								<div class="panel-heading">
									<h3 class="panel-title">企业实习岗位信息审核</h3>
									<div class="right">
										<button type="button" class="btn-toggle-collapse"><i class="lnr lnr-chevron-up"></i></button>
									</div>
								</div>
								<div class="panel-body no-padding">
									<table class="table table-striped">
										
										<thead>
											<tr>
												<th>所属企业</th>
												<th>实习名称</th>
												<th style="text-align: center">实习描述</th>
												<th>实习工资</th>
												<th>实习天数</th>
												<th>实习月数</th>
												<th>招聘结束时间</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td><a href="#">世纪龙</a></td>
												<td>Java开发</td>
												<td style="width: 40%">要特别骚的人,骚的出水的，像泳智大神一样骚的男人，最重要的是爱着君要特别骚的人,骚的出水的，像泳智大神一样骚的男人，最重要的是爱着君要特别骚的人,骚的出水的，像泳智大神一样骚的男人，最重要的是爱着君要特别骚的人,骚的出水的，像泳智大神一样骚的男人，最重要的是爱着君要特别骚的人,骚的出水的，像泳智大神一样骚的男人，最重要的是爱着君</td>
												<td>200</td>
												<td>4</td>
												<td>6</td>
												<td>2020-06-06</td>
												<td>
													<button data-type="job" class="btn btn-success btn-xs J-pass">通过</button>
													<button data-type="job" class="btn btn-danger btn-xs J-reject">拒绝</button>
												</td>
											</tr>
											<tr>
												<td><a href="#">世纪龙</a></td>
												<td>Java开发</td>
												<td>要特别骚的人</td>
												<td>200</td>
												<td>4</td>
												<td>6</td>
												<td>2020-06-06</td>
												<td>
													<button data-type="job" class="btn btn-success btn-xs J-pass">通过</button>
													<button data-type="job" class="btn btn-danger btn-xs J-reject">拒绝</button>
												</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
							<!-- END RECENT PURCHASES -->
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
	<script src="/assets/vendor/toastr/toastr.min.js"></script>
	<script src="/assets/scripts/klorofil-common.js"></script>
	<script>
		$(function() {
			var tableArr = ['information', 'job']
		// 显示列表
		$('.J-Ctrl').on('click', function(e){
			var tar = $(e.currentTarget),
			idx = tar.data('idx');
			for(var i = 0, len = tableArr.length; i < len; i++){
				if(i === idx){
					$('#' + tableArr[i]).show();
				}else{
					$('#' + tableArr[i]).hide();
				}
			}
		})
		// 通过，拒绝
		$('.J-pass').on('click', function(e){
			var tar = $(e.currentTarget);
			if(tar.data('type') === 'information'){
				toastr.success('通过一项企业实名审核', '世纪龙', {timeOut: 2000})
			}else if(tar.data('type') === 'job'){
				toastr.success('通过一项实习岗位审核', 'java开发', {timeOut: 2000})
			}
		})
		$('.J-reject').on('click', function(e){
			var tar = $(e.currentTarget);
			if(tar.data('type') === 'information'){
				toastr.error('拒绝一项企业实名审核', '世纪龙', {timeOut: 2000})
			}else if(tar.data('type') === 'job'){
				toastr.error('拒绝一项实习岗位审核', 'java开发', {timeOut: 2000})
			}
		})
	});
</script>
</body>

</html>
