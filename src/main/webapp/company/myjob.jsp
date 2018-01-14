<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<title>我的招聘信息</title>
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
						<div class="col-md-12">
							<div class="panel">
								<div class="panel-heading">
									<h3 class="panel-title">我发布的岗位</h3>
								</div>
								<div class="panel-body">
									<table class="table table-striped">
										<thead>
											<tr>
												<th>#</th>
												<th>名称</th>
												<th>收到的简历</th>	
												<th>审核态</th>
												<th>更新时间</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>1</td>
												<td>JavaScript前端开发</td>
												<td>30份</td>
												<td><span class="label label-danger">未通过</span></td>
												<td>2017-01-04</td>
												<td><a href="/company/jobinfo.jsp">查看</a> &nbsp; <a href="#">删除</a></td>
											</tr>
											<tr>
												<td>2</td>
												<td>Java Web后端</td>
												<td>30份</td>
												<td><span class="label label-danger">未通过</span></td>
												<td>2017-01-03</td>
												<td><a href="#">查看</a> &nbsp; <a href="#">删除</a></td>
											</tr>
											<tr>
												<td>3</td>
												<td>Python开发工程师</td>
												<td>30份</td>
												<td><span class="label label-danger">未通过</span></td>
												<td>2017-01-02</td>
												<td><a href="#">查看</a> &nbsp; <a href="#">删除</a></td>
											</tr>
											<tr>
												<td>4</td>
												<td>JavaScript前端开发</td>
												<td>30份</td>
												<td><span class="label label-success">通过</span></td>
												<td>2017-01-04</td>
												<td><a href="#">查看</a> &nbsp; <a href="#">删除</a></td>
											</tr>
											<tr>
												<td>5</td>
												<td>Java Web后端</td>
												<td>30份</td>
												<td><span class="label label-danger">未通过</span></td>
												<td>2017-01-03</td>
												<td><a href="#">查看</a> &nbsp; <a href="#">删除</a></td>
											</tr>
											<tr>
												<td>6</td>
												<td>Python开发工程师</td>
												<td>30份</td>
												<td><span class="label label-danger">未通过</span></td>
												<td>2017-01-02</td>
												<td><a href="#">查看</a> &nbsp; <a href="#">删除</a></td>
											</tr>
											<tr>
												<td>7</td>
												<td>JavaScript前端开发</td>
												<td>30份</td>
												<td><span class="label label-danger">未通过</span></td>
												<td>2017-01-04</td>
												<td><a href="#">查看</a> &nbsp; <a href="#">删除</a></td>
											</tr>
											<tr>
												<td>8</td>
												<td>Java Web后端</td>
												<td>30份</td>
												<td><span class="label label-danger">未通过</span></td>
												<td>2017-01-03</td>
												<td><a href="#">查看</a> &nbsp; <a href="#">删除</a></td>
											</tr>
											<tr>
												<td>9</td>
												<td>Python开发工程师</td>
												<td>30份</td>
												<td><span class="label label-danger">未通过</span></td>
												<td>2017-01-02</td>
												<td><a href="#">查看</a> &nbsp; <a href="#">删除</a></td>
											</tr>
											<tr>
												<td>10</td>
												<td>Python开发工程师</td>
												<td>30份</td>
												<td><span class="label label-danger">未通过</span></td>
												<td>2017-01-02</td>
												<td><a href="#">查看</a> &nbsp; <a href="#">删除</a></td>
											</tr>
										</tbody>
									</table>
									<ul class="pagination">
									    <li><a href="#">&laquo;</a></li>
									    <li class="active"><a href="#">1</a></li>
									    <li class="disabled"><a href="#">2</a></li>
									    <li><a href="#">3</a></li>
									    <li><a href="#">4</a></li>
									    <li><a href="#">5</a></li>
									    <li><a href="#">&raquo;</a></li>
									</ul>
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
	<script src="../assets/vendor/jquery/jquery.min.js"></script>
	<script src="../assets/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="../assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<script src="../assets/scripts/klorofil-common.js"></script>
</body>

</html>
