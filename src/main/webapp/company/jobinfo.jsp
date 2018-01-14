<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<title>招聘信息详情</title>
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
					<div class=""><!--这里两个class被我删了-->
						<div class="">
							<!-- LEFT COLUMN -->
							<div class="profile-left" style="width: 40%">
								
								<!-- PROFILE DETAIL -->
								<div class="profile-detail">
									<div class="profile-info">
										<h4 class="heading">岗位信息</h4>
										<ul class="list-unstyled list-justify">
											<li>岗位名称 <span>JavaScript前端开发</span></li>
											<li>月工资 <span>2500</span></li>
											<li>类型<span>IT</span></li>
											<li>学历限制 <span>大专</span></li>
											<li>时间长度 <span>3个月</span></li>
											<li>上班频率 <span>5天/周</span></li>
											<li>职位诱惑 <span>五险一金</span></li>
											<li>职位标签 <span>周末双休</span></li>
											<li>更新时间 <span>2017-05-03</span></li>
											<li>审核状态 <span>通过</span></li>
										</ul>
									</div>
									
									<div class="profile-info">
										<h4 class="heading">岗位描述</h4>
										<p>职位职责：
											工作职责
											在移动设备上，追求极致的⽤户体验
											负责开发与⽤户和服务器的交互界面
											建设企业级和移动前端的技术和工程架构
											知识分享者，善于总结、乐于对内外分享
											低级别⼯程师的导师，辅导新人

											基本要求
											2年以上前端领域开发经验
											熟练阅读英⽂原版技术⽂档和书刊
											深⼊掌握HTML+CSS+JavaScript等前端技术，代码符合W3C标准、兼容主流浏览器
											熟练使⽤⾄少⼀种JS框架，掌握其原理
											掌握⾄少⼀种其他语⾔（如Java/PHP/Python/Ruby/Go），有实战经验
											本科及以上学历，计算机相关专业毕业（或计算机基础⾮常扎实）
											做事认真细心，有一份用心的简历

											优先条件
											熟悉Mobile Web/Hybrid Web App/小程序开发/基于Canvas的游戏等开发
											利⽤开源代码打造⾃有效率⼯具的经验
											熟悉Linux/Unix/Mac平台下的软件开发环境
											多终端的开发经验（Android/iOS/Mac/Windows）
											Nodejs下项目开发经验
											技术社区的活跃份⼦
											品质优秀的开源作品
											妥善经营的技术博客
											团队管理经验
										</p>
									</div>
									<div class="text-center"><a href="#" class="btn btn-primary">修改</a></div>
								</div>
								<!-- END PROFILE DETAIL -->
							</div>
							<!-- END LEFT COLUMN -->
							<!-- RIGHT COLUMN -->
							<div class="profile-right" style="width: 60%">
								<!-- TABBED CONTENT -->
								<div class="custom-tabs-line tabs-line-bottom left-aligned">
									<ul class="nav" role="tablist">										
										<li><a href="#tab-bottom-left2" role="tab" data-toggle="tab">收到的简历 <span class="badge">7</span></a></li>
									</ul>
								</div>
								<div class="tab-content">
									
									<div class="tab-pane fade in active" id="tab-bottom-left2">
										<div class="table-responsive">
											<table class="table project-table">
												<thead>
													<tr>
														<th>#</th>
														<th>姓名</th>
														<th>学历</th>
														<th>投递时间</th>
														<th>状态</th>
													</tr>
												</thead>
												<tbody>
													<tr>
														<td>1</td>
														<td><a href="#">王谋</a></td>
														<td>本科</td>
														<td>2017-05-04</td>
														<td><span class="label label-success">已查看</span></td>
													</tr>
													<tr>
														<td>2</td>
														<td><a href="#">王谋</a></td>
														<td>本科</td>
														<td>2017-05-04</td>
														<td><span class="label label-default">未查看</span></td>
													</tr>	
													<tr>
														<td>3</td>
														<td><a href="#">王谋</a></td>
														<td>本科</td>
														<td>2017-05-04</td>
														<td><span class="label label-default">未查看</span></td>
													</tr>	
													<tr>
														<td>4</td>
														<td><a href="#">王谋</a></td>
														<td>本科</td>
														<td>2017-05-04</td>
														<td><span class="label label-default">未查看</span></td>
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
	<script src="../assets/vendor/jquery/jquery.min.js"></script>
	<script src="../assets/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="../assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<script src="../assets/scripts/klorofil-common.js"></script>
</body>

</html>
