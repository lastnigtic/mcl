<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<!doctype html>
<html lang="en">

<head>
	<title></title>
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
		.result{
			margin-top: 30px;
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
					<h3 class="page-title">信息检索</h3>
					<div class="col-md-10 col-md-offset-1">
						<div class="col-md-2" style="padding-left: 0">
							<select class="form-control" id="searchType">
								<option value="company">企业</option>
								<option value="user">用户</option>
								<option value="job">兼职</option>
							</select>
						</div>
						<div class="input-group col-md-10">
							<input class="form-control" type="text">
							<span class="input-group-btn"><button class="btn btn-primary" type="button">搜索</button></span>
						</div>
					</div>
					<div class="col-md-10 col-md-offset-1 result">
						<div class="panel">
							<div class="panel-body">
								<!-- 结果 -->
								<div class="col-md-12">
									<!-- 企业 -->
									<table class="table table-hover" id="company">
										<thead>
											<tr>
												<th>企业名称</th>
												<th>企业头目</th>
												<th>企业地区</th>
												<th>企业联系方式</th>
												<th>企业详情</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>世纪龙</td>
												<td>郑泳智</td>
												<td>广州</td>
												<td>烧香拜佛</td>
												<td><a href="./company-detail.html">查看</a></td>
											</tr>
										</tbody>
									</table>
									<!-- 用户 -->
									<table class="table table-hover" id="user" style="display: none">
										<thead>
											<tr>
												<th>用户姓名</th>
												<th>用户地区</th>
												<th>用户学历</th>
												<th>用户联系方式</th>
												<th>用户详情</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>这泳智</td>
												<td>广州</td>
												<td>教授</td>
												<td>烧香拜佛</td>
												<td><a href="./user-detail.html">查看</a></td>
											</tr>
										</tbody>
									</table>
									<!-- 兼职 -->
									<table class="table table-hover" id="job" style="display: none">
										<thead>
											<tr>
												<th>兼职名称</th>
												<th>发布企业</th>
												<th>工资</th>
												<th>结束时间</th>
												<th>兼职详情</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>Java开发</td>
												<td>世纪龙</td>
												<td>2000</td>
												<td>2018-03-03</td>
												<td><a href="./job-detail.html">查看</a></td>
											</tr>
										</tbody>
									</table>
								</div>
								<!-- 分页 -->
								<nav class="col-md-offset-4">
									<ul class="pagination">
										<li>
											<a href="#" aria-label="Previous">
												<span aria-hidden="true">&laquo;</span>
											</a>
										</li>
										<li><a href="#">1</a></li>
										<li><a href="#">2</a></li>
										<li><a href="#">3</a></li>
										<li><a href="#">4</a></li>
										<li><a href="#">5</a></li>
										<li>
											<a href="#" aria-label="Next">
												<span aria-hidden="true">&raquo;</span>
											</a>
										</li>
									</ul>
								</nav>
							</div>
						</div>
					</div>
					<!-- END MAIN CONTENT -->
				</div>
			</div>
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
	<script type="text/javascript">
	var company = $('#company');
	var user = $('#user');
	var job = $('#job');
	var el = {
		company: company,
		user: user,
		job: job
	}
	$('#searchType').on('change', function(e){
		var idx = this.selectedIndex;
		var val = this.options[idx].value;
		for(var i in el){
			if(i === val){
				el[i].show();
			}else{
				el[i].hide()
			}
		}
	})
	</script>
</body>

</html>
