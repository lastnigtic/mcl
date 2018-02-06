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
									<h3 class="panel-title">评分列表</h3>
								</div>
								<div class="panel-body">
									<table class="table table-striped">
										<thead>
											<tr>
												<th>#</th>
												<th>岗位</th>
												<th>评分者</th>
												<th>评论</th>
												<th>信用分</th>
												<th>环境</th>
												<th>氛围</th>
												<th>薪资</th>
												<th>更新时间</th>
											</tr>
										</thead>
										<tbody id="table-body">
										<c:choose>

										<c:when test="${pageInfo!=null&&pageInfo.size!=0}">
											<c:forEach items="${pageInfo.list}" var="rate" varStatus="xh" >
												<tr>
													<td>${xh.count}</td>
													<td></td>
													<td></td>
													<td>${rate.comment}</td>
													<td>${rate.creditrate}</td>
													<td>${rate.environmentrate}</td>
													<td>${rate.atmosphererate}</td>
													<td>${rate.wagerate}</td>
													<td class="J-Date">${rate.updatetime}</td>
												</tr>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<tr>
												<td colspan="9">暂无数据</td>
											</tr>
										</c:otherwise>
										</c:choose>

										</tbody>
									</table>

									<jsp:include page="/public/page.jsp">
										<jsp:param name="url" value="/comp/ratelist.html"></jsp:param>
									</jsp:include>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- END MAIN CONTENT -->
		</div>
		<!-- Modal -->
		<div class="modal fade" id="msgModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel">点评(1~5分)</h4>
					</div>
					<div class="modal-body">
						<label>组织能力</label>
						<input type="number" name="organizationability" class="form-control J-limit" placeholder="请输入分数...">
						<br>
						<label>沟通能力</label>
						<input type="number" name="communicateability" class="form-control J-limit" placeholder="请输入分数...">
						<br>
						<label>学习能力</label>
						<input type="number" name="learnability" class="form-control J-limit" placeholder="请输入分数...">
						<br>
						<label>创新能力</label>
						<input type="number" name="innovationability" class="form-control J-limit" placeholder="请输入分数...">
						<br>
						<label>适应能力</label>
						<input type="number" name="adaptability" class="form-control J-limit" placeholder="请输入分数...">
						<br>
						<label>技术能力</label>
						<input type="number" name="technicalability" class="form-control J-limit" placeholder="请输入分数...">
						<br>
						<label>文字点评</label>
						<input name="comment" class="form-control" placeholder="请输入您对他(她)的表现的简短点评">
						<br>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="button" class="btn btn-primary" id="evaluateSubmit">提交</button>
					</div>
				</div>
			</div>
		</div>
		<!-- Modal-end -->
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
</body>

</html>
