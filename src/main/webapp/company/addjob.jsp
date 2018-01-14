<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<title>发布招聘信息</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<!-- VENDOR CSS -->
	<link rel="stylesheet" href="../assets/vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="../assets/vendor/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="../assets/vendor/linearicons/style.css">
	<link rel="stylesheet" href="../assets/vendor/chartist/css/chartist-custom.css">
	<!-- MAIN CSS -->
	<link rel="stylesheet" href="../assets/css/main.css">
	<!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
	<link rel="stylesheet" href="../assets/css/demo.css">
	<!-- GOOGLE FONTS -->
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
	<!-- ICONS -->
	<link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="../assets/img/favicon.png">
</head>

<body>
	<!-- WRAPPER -->
	<div id="wrapper">
		<%@ include file="/public/top_nav.jsp"%>      
		<%@ include file="/public/left_sidebar.jsp"%>  
		<!-- MAIN -->
		<div class="main">
			<!-- MAIN CONTENT -->
			<div class="main-content">
				<div class="container-fluid">
					
					<div class="row">
						<div class="col-md-offset-3 col-md-6">
							<!-- INPUTS -->
							<div class="panel">
								
								<div class="panel-body">
									<h3 class="page-title">编辑发布信息信息</h3>
									<label>岗位名称</label>
									<input type="text" class="form-control" placeholder="请输入公司名称...">
									<br>
									<label>职位诱惑</label>
									<input type="text" class="form-control" placeholder="请输入职位诱惑...">
									<br>
									<label>月工资</label>
									<input type="number" class="form-control" placeholder="请输入月工资...">
									<br>
									<label>工作时长</label>
									<input type="number" class="form-control" placeholder="请输入工作时长（n个月）...">
									<br>
									<label>学历限制</label>
									<select class="form-control">
										<option value="cheese">大专</option>
										<option value="tomatoes">本科</option>
										<option value="mozarella">硕士</option>
										<option value="mushrooms">博士</option>
									</select>
									<br>
									<label>上班频率</label>
									<select class="form-control">
										<option value="cheese">3天/周</option>
										<option value="tomatoes">3天/周</option>
										<option value="mozarella">3天/周</option>
										<option value="mushrooms">3天/周</option>
									</select>
									<br>
									<label>类型</label>
									<select class="form-control">
										<option value="cheese">互联网</option>
										<option value="tomatoes">通信</option>
										<option value="mozarella">金融</option>
									</select>
									<br>
									<label>岗位标签</label>
									<label class="fancy-checkbox">
										<input type="checkbox">
										<span>五险一金</span>
									</label>
									<label class="fancy-checkbox">
										<input type="checkbox">
										<span>周末双休</span>
									</label>
									<label class="fancy-checkbox">
										<input type="checkbox">
										<span>美女如云</span>
									</label>
									<br>
									<label>岗位描述</label>
									<textarea class="form-control" placeholder="请输入公司简介..." rows="4"></textarea>
									<br>
									<button type="button" class="btn btn-primary" style="float: right">提交</button>
								</div>
							</div>
							<!-- END INPUTS -->
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
	<script src="../assets/vendor/jquery/jquery.min.js"></script>
	<script src="../assets/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="../assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<script src="../assets/scripts/klorofil-common.js"></script>
</body>

</html>
