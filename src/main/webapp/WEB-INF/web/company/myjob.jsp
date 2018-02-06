<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<!doctype html>
<html lang="en">
<head>
	<title>我的招聘信息</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<!-- VENDOR CSS -->
	<link rel="stylesheet" href="/assets/vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="/assets/vendor/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="/assets/vendor/linearicons/style.css">
	<link rel="stylesheet" href="/assets/vendor/chartist/css/chartist-custom.css">
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
		td:not(:first-child),
		th:not(:first-child){
			text-align: center;
		}
		table tr td:only-child{ text-align: center;}
		.status-select{
			width: auto;
			float:right;
			display: inline-block;
		}
		.dropdown-menu{
			min-width: 110px
		}
	</style>
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
									<h3 class="panel-title">我发布的岗位
										<div class="dropdown status-select">
											<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true" style="padding: 6px 16px;">
												状态筛选
												<span class="caret"></span>
											</button>
											<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
												<li><a href="/comp/myjob.html">全部</a></li>
												<li><a href="/comp/myjob.html?checked=0">未审核</a></li>
												<li><a href="/comp/myjob.html?checked=1">通过</a></li>
												<li><a href="/comp/myjob.html?checked=2">未通过</a></li>
												<li><a href="/comp/myjob.html?checked=3">过期</a></li>
											</ul>
										</div>
									</h3>
								</div>
								<div class="panel-body">
									<table class="table table-striped">
										<thead>
											<tr>
												<th>#</th>
												<th>名称</th>
												<th>工资</th>
												<th>审核态</th>
												<th>更新时间</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody id="table-body">
										<c:choose>

										<c:when test="${pageInfo.list!=null&&pageInfo.list.size()!=0}">
											<c:forEach items="${pageInfo.list}" var="job" varStatus="xh" >
												<tr>
													<td>${xh.count}</td>
													<td>${job.jobname}</td>
													<td>${job.wage}</td>
													<td>
														<c:choose>
															<c:when test="${job.checked==0}">
																<span class="label label-danger">未审核</span>
															</c:when>
															<c:when test="${job.checked==1}">
																<span class="label label-success">通过</span>
															</c:when>
															<c:when test="${job.checked==2}">
																<span class="label label-danger">未通过</span>
															</c:when>
															<c:when test="${job.checked==3}">
																<span class="label label-danger">过期</span>
															</c:when>
														</c:choose>
													</td>
													<td class="J-Date">${job.updatetime}</td>
													<td>
														<a href="/comp/jobinfo.html?id=${job.id}">详情</a> &nbsp;
														<c:choose>
															<c:when test="${job.checked == 1}">
																<a href="/comp/jobresume.html?id=${job.id}" style="cursor: pointer">简历</a> &nbsp;
															</c:when>
														</c:choose>
														<a style="cursor: pointer" data-id="${job.id}" class="deljob">删除</a>
													</td>
												</tr>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<tr>
												<td colspan="6">暂无数据</td>
											</tr>
										</c:otherwise>
										</c:choose>

										</tbody>
									</table>

									<jsp:include page="/public/page.jsp">
										<jsp:param name="url" value="/comp/myjob.html"></jsp:param>
									</jsp:include>
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
	<script src="/assets/scripts/klorofil-common.js"></script>
	<script src="/assets/js/public.js"></script>
	<script src="/assets/js/tool.js"></script>
	<script>
		$(function () {
			$(".deljob").click(function () {
				if(confirm("是否确认删除")){
				    $.ajax({
                        url:'/comp/deljob.do',
                        type:'POST',
                        data:{
                            id:$(this).data('id')
                        },
						success:function (res) {
							if(res.status==0){
							    alert('删除成功');
							}else {
                                alert('删除失败');
							}
							$(window).attr('location','/comp/myjob.html');
                        }
					})
				}
            })
        })
	</script>
</body>

</html>
