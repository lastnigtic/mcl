<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/public/isLogin.jsp"%>
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
											<li>岗位名称 <span id="job-jobname"></span></li>
											<li>月工资 <span id="job-wage"></span></li>
											<li>类型<span id="job-type"></span></li>
											<li>学历限制 <span id="job-education"></span></li>
											<li>时间长度 <span id="job-duration"></span>月</li>
											<li>上班频率 <span id="job-workfrequency"></span>天/周</li>
											<li>职位诱惑 <span id="job-temptation"></span></li>
											<li>职位标签 <span id="job-tag"></span></li>
											<li>更新时间 <span id="job-updatetime"></span></li>
											<li>审核状态 <span id="job-checked"></span></li>
										</ul>
									</div>
									
									<div class="profile-info">
										<h4 class="heading">岗位描述</h4>
										<p id="job-description">
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
	<script src="../assets/js/public.js"></script>
	<script>
		$(function () {

            var job_id = GetQueryString('id');
			if(job_id!=null){
                $.ajax({
                    url:"/getjob.do",
                    type: "POST",
                    data:{
                        id:job_id
                    },
                    success: function(res){
                        if(res.status==0){
                            var job = res.data ;
                        	$("#job-jobname").text(job.jobname);
                        	$("#job-description").text(job.description);
                        	$("#job-duration").text(job.duration);
                        	$("#job-education").text(job.education);
                        	$("#job-tag").text(job.tag);
                        	$("#job-temptation").text(job.temptation);
                        	$("#job-type").text(job.type);
                        	$("#job-wage").text(job.wage);
                        	$("#job-updatetime").text(filterDate(job.updatetime));
                        	$("#job-workfrequency").text(job.workfrequency);
                            var c = job.checked==1?'通过':'未通过' ;
                        	$("#job-checked").text(c);

                        }
                    }
                })
			}
        })
	</script>
</body>

</html>
