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
									<h3 class="panel-title">企业实名信息待审核列表</h3>
									<div class="right">
										<button type="button" class="btn-toggle-collapse"><i class="lnr lnr-chevron-up"></i></button>
									</div>
								</div>
								<div class="panel-body">
									<table class="table table-striped" id="compTable">
										<thead>
											<tr>
												<th>企业名称</th>
												<th>公司规模</th>
												<th>法人代表</th>
												<th>所属行业</th>
												<th>所属城市</th>
												<th>融资阶段</th>
												<th>注册资本</th>
												<th>成立时间</th>
												<th>操作</th>
											</tr>
										</thead>
										<c:choose>
											<c:when test="${pageInfo!=null&&pageInfo.list.size()>0}">
												<c:forEach items="${pageInfo.list}" var="comp" varStatus="xh" >
													<tr>
														<td>${comp.companyname}</td>
														<td>${comp.companysize}</td>
														<td>${comp.legalrepresentative}</td>
														<td>${comp.industry}</td>
														<td>${comp.city}</td>
														<td>${comp.financingstage}</td>
														<td>${comp.registeredcapital}</td>
														<td class="J-Date">${comp.setuptime}</td>
														<td>
															<a href="/admin/compinfo.html?id=${comp.id}">查看</a>
															<a class="J-pass" data-name="${comp.companyname}" data-id="${comp.id}">通过</a>
															<a class="J-reject" data-name="${comp.companyname}" data-id="${comp.id}">拒绝</a>
														</td>
													</tr>
												</c:forEach>
											</c:when>
											<c:otherwise>
												<tr>
													<td colspan="10">暂无数据</td>
												</tr>
											</c:otherwise>
										</c:choose>
										<%--<tbody id="informationBody">--%>
										<%--</tbody>--%>
									</table>

									<jsp:include page="/public/page.jsp">
										<jsp:param name="url" value="/admin/reviewcomp.html"></jsp:param>
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
			    if(window.confirm('通过 '+tar.data('name') +' 实名认证?')){
					$.post('/admin/passcompany.do?companyid='+tar.data('id')+'&checked=2',{
					},function(res){
					    if(res.status === 0){
                            toastr.success('通过一项企业实名审核', tar.data('name'), {timeOut: 2000});
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
			    if(window.confirm('拒绝 '+tar.data('name') +' 实名认证?')){
                    $.post('/admin/passcompany.do?companyid='+tar.data('id')+'&checked=3',{
                    },function(res){
                        if(res.status === 0){
                            toastr.success('拒绝一项企业实名审核', tar.data('name'), {timeOut: 2000});
                            var tr = tar.closest('tr');
                            tr.remove();
                        }else{
                            toastr.warning('提交失败请重试', {timeOut: 2000})
                        }
                    })
			}
		})
	});
</script>
</body>

</html>
