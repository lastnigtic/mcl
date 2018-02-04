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
		th, td{
			text-align: center;
		}
	</style>
</head>

<body>
	<!-- WRAPPER -->
	<div id="wrapper">
		<%@ include file="/public/top_nav.jsp"%><!--管理员的侧边栏和顶栏需要另外抽出来-->
		<%@ include file="/public/admin_left_sidebar.jsp"%>
		<!-- END LEFT SIDEBAR -->
		<!-- MAIN -->
		<div class="main">
			<!-- MAIN CONTENT -->
			<div class="main-content">
				<div class="container-fluid">
					<div class="row" id="information">
						<div class="col-md-12">
							<!-- RECENT PURCHASES -->
							<div class="panel">
								<div class="panel-heading">
									<h3 class="panel-title">岗位待审核列表</h3>
									<div class="right">
										<button type="button" class="btn-toggle-collapse"><i class="lnr lnr-chevron-up"></i></button>
									</div>
								</div>
								<div class="panel-body">
									<table class="table table-striped">
										<thead>
											<tr>
												<th>岗位名称</th>
												<th>岗位类型</th>
												<th>月工资</th>
												<th>工作地点</th>
												<th>城市</th>
												<th>学历限制</th>
												<th>更新时间</th>
												<th>操作</th>
											</tr>
										</thead>
										<c:choose>
											<c:when test="${pageInfo!=null}">
												<c:forEach items="${pageInfo.list}" var="job" varStatus="xh" >
													<tr>
														<td>${job.jobname}</td>
														<td>${job.type}</td>
														<td>${job.wage}</td>
														<td>${job.address}</td>
														<td>${job.city}</td>
														<td>${job.education}</td>
														<td class="J-Date">${job.updatetime}</td>
														<td>
															<a href="/admin/jobinfo.html?id=${job.id}">查看</a>
															<a data-name="${job.jobname}" data-id="${job.id}" class="J-pass">通过</a>
															<a data-name="${job.jobname}" data-id="${job.id}" data-type="job" class="J-reject">拒绝</a>
														</td>
													</tr>
												</c:forEach>
											</c:when>
											<c:otherwise>
												<tr>
													<td colspan="9">暂无数据</td>
												</tr>
											</c:otherwise>
										</c:choose>
										<%--<tbody id="informationBody">--%>
										<%--</tbody>--%>
									</table>
									<jsp:include page="/public/page.jsp">
										<jsp:param name="url" value="/admin/reviewjob.html"></jsp:param>
									</jsp:include>
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
	<script src="/assets/js/tool.js"></script>
	<script>
        $(function() {
            // 通过，拒绝
            $('.J-pass').on('click', function(e){
                var tar = $(e.currentTarget);
                    if(window.confirm('通过 '+tar.data('name') +' 岗位认证?')){
                        $.post('/admin/passjob.do?id='+tar.data('id')+'&checked=1',{
                        },function(res){
                            if(res.status === 0){
                                toastr.success('通过一项实习岗位审核', tar.data('name'), {timeOut: 2000});
                                var tr = tar.closest('tr');
                                tr.remove();
                            }else{
                                toastr.warning('提交失败请重试', {timeOut: 2000})
                            }
                        })
                    }
            })
            $('.J-reject').on('click', function(e){
                var tar = $(e.currentTarget);
                    if(window.confirm('拒绝 '+tar.data('name') +' 岗位认证?')) {
                        $.post('/admin/passjob.do?id=' + tar.data('id') + '&checked=2', {}, function (res) {
                            if (res.status === 0) {
                                toastr.success('拒绝一项实习岗位审核', tar.data('name'), {timeOut: 2000});
                                var tr = tar.closest('tr');
                                tr.remove();
                            } else {
                                toastr.warning('提交失败请重试', {timeOut: 2000})
                            }
                        })
                    }
            })
        });
	</script>

</body>

</html>
