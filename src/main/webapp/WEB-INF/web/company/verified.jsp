<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
	<title>公司实名认证</title>
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
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
		.img-thumbnail{
			width: 360px
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
						<div class="col-md-offset-1 col-md-6">
							<c:choose>
								<c:when test="${company.checked == 2}">
									<h4>您已通过认证</h4><div style="margin-bottom:20px">
								<div style="margin-bottom:20px">
									<img src="/image/getlicenseimg.do?imgpath=${empty path?company.companylicense:path}" class="img-thumbnail" alt="认证资料图片">
								</div>
								</c:when>
								<c:when test="${company.checked == 3}">
									<!-- INPUTS -->
									<div class="panel">
										<h4>您的认证未通过</h4>
										<form enctype="multipart/form-data" method="post" action="/comp/compverified.do">
										<div class="panel-body">
											<h3 class="page-title">上传公司认证资料</h3>
											<br>
											<div style="margin-bottom:20px">
												<img src="/image/getlicenseimg.do?imgpath=${empty path?company.companylicense:path}" class="img-thumbnail" alt="认证资料图片">
											</div>
											<input type="file" name="uploadfile" multiple="" value="上传图片"  />
											<button id="button-upload" type="submit" class="btn btn-primary" style="float: right">提交</button>
											<c:if test="${!empty msg}">
												<p style="color: red">错误：${msg}</p>
											</c:if>
										</div>
										</form>
									</div>
									<!-- END INPUTS -->
								</c:when>
								<c:when test="${company.checked == 1}">
									<h2>审核中……</h2>
									<div style="margin-bottom:20px">
										<img src="/image/getlicenseimg.do?imgpath=${empty path?company.companylicense:path}" class="img-thumbnail" alt="认证资料图片">
									</div>
								</c:when>
								<c:when test="${company.checked == 0}">
									<h2>请提交认证资料……</h2>
									<form enctype="multipart/form-data" method="post" action="/comp/compverified.do">
										<div class="panel-body">
											<h3 class="page-title">上传公司认证资料</h3>
											<br>
											<div style="margin-bottom:20px">
												<img src="/image/getlicenseimg.do?imgpath=${empty path?company.companylicense:path}" class="img-thumbnail" alt="认证资料图片">
											</div>
											<input type="file" name="uploadfile" multiple="" value="上传图片"  />
											<button id="button-upload" type="submit" class="btn btn-primary" style="float: right">提交</button>
											<c:if test="${!empty msg}">
												<p style="color: red">错误：${msg}</p>
											</c:if>
										</div>
									</form>
								</c:when>
							</c:choose>
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
	<script>
		$(function () {
//			$("#button-upload").click(function () {
//				$.ajax({
//					url:"/comp/verified.do",
//					type:"POST",
//                    contentType : "multipart/form-data",
//                    data:$("form").serialize(),
//					success:function (res) {
//						if(res.status==0){
//						    alert('上传成功');
//						}else {
//						    alert(res.msg);
//						}
//                        $(window).attr("location","/comp/verified");
//                    }
//
//				})
//            })verified
        })
	</script>
</body>

</html>
