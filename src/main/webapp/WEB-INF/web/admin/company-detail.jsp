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
										<img src="assets/img/user-medium.png" class="img-circle" alt="Avatar">
										<h3 class="name">百词斩</h3>
										<span class="status-available">让天下人爱学习</span>
									</div>
									<div class="profile-stat">
										<div class="row">
											<div class="col-md-4 stat-item">
												成都
											</div>
											<div class="col-md-4 stat-item">
												50-150人
											</div>
											<div class="col-md-4 stat-item">
												互联网
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
								<div class="custom-tabs-line tabs-line-bottom  text-center">
									<ul class="nav row" role="tablist" style="display: block">
										<li class="active col-md-6"><a href="#tab-bottom-left1" role="tab" data-toggle="tab">企业信息</a></li>
										<li class="col-md-6"><a href="#tab-bottom-left2" role="tab" data-toggle="tab">在招职位</a></li>
									</ul>
								</div>
								<div class="tab-content">
									<div class="tab-pane fade in active" id="tab-bottom-left1">
										<h3>企业介绍</h3>
										<p style="line-height: 2em">成都超有爱科技成立于 2012 年,以背单词 App 百词斩切入了在线教育市场。<br>
											目前的产品分为 App 软件和软件周边实体用品两个类别,其中App“百词斩” 的用户3000万+,日活跃100万+,领
											目前所有的在线教育创业公司。而由核心业务衍生出的周边实体电商业务则为公司提供了稳定的现金流,配合 A 轮 “经纬中国”、B轮 “中国文化产业投资基金”融资,目前公司正稳定而快速的发展中。<br>
											超有爱科技独有的企业文化和成都地区强有竞争力的薪酬体系，吸引了大批来自知名互联网公司的资深员工鼎力支持，在相当长的时间内，我们都专注于做好用户体验，专注于员工的自我实现。期待信念相同的你：） 
										</p>
										<h3>企业资料</h3>
										<p>成都超有爱科技有限公司<p>
										<a href="www.baicizhan.com/hello">www.baicizhan.com/hello</a>
										<h3>工商信息</h3>
										<ul class="list-unstyled">
											<li>公司类型：其他有限责任公司</li>
											<li>注册号：510109000161814</li>
											<li>成立日期：2011-01-20</li>
											<li>注册资本：222.8893 万元人民币</li>
										</ul>
									</div>
									<div class="tab-pane fade" id="tab-bottom-left2">
										<div class="table-responsive">
											<table class="table project-table">
												<thead>
													<tr>
														<th>实习名称</th>
														<th>地区</th>
														<th>工资</th>
														<th>天数</th>
														<th>月数</th>
														<th>更新日期</th>
													</tr>
												</thead>
												<tbody>
													<tr>
														<td>百词斩编辑</td>
														<td>成都</td>
														<td>120/天</td>
														<td>4天</td>
														<td>6月</td>
														<td>2018-01-27 更新</td>
													</tr>
													<tr>
														<td>百词斩编辑</td>
														<td>成都</td>
														<td>120/天</td>
														<td>4天</td>
														<td>6月</td>
														<td>2018-01-27 更新</td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
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
