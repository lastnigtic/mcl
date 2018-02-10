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
		table td:not(:first-child),
		table th:not(:first-child){
			text-align: center
		}
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
									<h3 class="panel-title">消息列表
										<div class="dropdown status-select">
											<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true" style="padding: 6px 16px;">
												状态筛选
												<span class="caret"></span>
											</button>
											<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
												<li><a href="/comp/msglist.html">全部</a></li>
												<li><a href="/comp/msglist.html?status=0">未读</a></li>
												<li><a href="/comp/msglist.html?status=1">已读</a></li>
											</ul>
										</div>
									</h3>
								</div>
								<div class="panel-body">
									<table class="table table-striped">
										<thead>
											<tr>
												<th>#</th>
												<th>标题</th>
												<th>类型</th>
												<th>详情</th>
												<th>更新时间</th>
												<th>状态</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody id="table-body">
										<c:choose>

										<c:when test="${pageInfo!=null}">
											<c:forEach items="${pageInfo.list}" var="msg" varStatus="xh" >
												<tr>
													<td>${xh.count}</td>
													<td>${msg.title}</td>
													<c:choose>
														<c:when test="${msg.type == 1}">
															<td>系统消息</td>
														</c:when>
														<c:otherwise>
															<td>岗位消息</td>
														</c:otherwise>
													</c:choose>
													<td class="J-len">${msg.content}</td>
													<td class="J-Date">${msg.updatetime}</td>
													<c:choose>
														<c:when test="${msg.status==0}">
															<td><span class="label label-danger">未读</span></td>
														</c:when>
														<c:when test="${msg.status==1}">
															<td><span class="label label-success">已读</span></td>
														</c:when>
													</c:choose>
													<td>
														<a href="#" class="J-detail" style="cursor: pointer" data-toggle="modal" data-target="#msgModal" data-id="${msg.id}">详情</a> &nbsp;
														<a href="#" class="J-delete" data-id="${msg.id}" style="cursor: pointer">删除</a>
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
										<jsp:param name="url" value="/comp/msglist.html"></jsp:param>
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
		<!-- Modal -->
		<div class="modal fade" id="msgModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="msgTitle"></h4>
					</div>
					<div class="modal-body">
						<p id="msgContent"></p>
					</div>
			</div>
		</div>
		<!-- Modal-end -->
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
		$(function(){
//		   已读消息消息
            $('.J-detail').on('click',function(e){
                var tar = $(e.target);
                var id = tar.data('id');
                $.post('/comp/readmsg.do',{id: id},function(res){
                    if(res.status === 0){
						var label = $(tar.parent().prev().find('.label'));
						label.removeClass('label-danger');
						label.addClass('label-success').text('已读');
						$.post('/comp/getmsg.do', {id: id},function(res){
						    if(res.status === 0){
						        var title = res.data.title;
						        var content = res.data.content;
						        $('#msgTitle').text(title);
						        $('#msgContent').text(content);
							}
						})
					}
                })
            })
//		   删除消息
			$('.J-delete').on('click',function(e){
			    var tar = $(e.target);
			    var id = tar.data('id');
			    $.post('delmsg.do',{id: id},function(res){
				if(res.status === 0){
                    tar.closest('tr').remove();
                    window.alert('删除成功')
                }else{
				    window.alert('操作失败，请重试')
				}
				})
			})
		})
	</script>
</body>

</html>
