<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<title>编辑公司信息</title>
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
						<div class="col-md-offset-3 col-md-6">
							<!-- INPUTS -->
							<div class="panel">
								
								<div class="panel-body">
									<h3 class="page-title">编辑公司信息</h3>
									<form enctype="multipart/form-data" method="post" action="/comp/compimg.do">
									<label>公司商标</label>
										<input type="file" name="uploadfile" multiple="" value="上传图片"  />
										<button id="button-upload" type="submit" class="btn btn-primary" style="display: none">提交</button>
									</form>
									<br>
									<label>公司名称</label>
									<input type="text" class="form-control" name="companyname" id="companyname" value="${company.companyname}" placeholder="请输入公司名称...">
									<br>
									<label>公司地址</label>
									<input class="form-control" name="address" id="address" value="${company.address}" placeholder="请输入公司地址...">
									<br>
									<label>成立时间</label>
									<input type="date" class="J-positiveNum form-control" data-date="${company.setuptime}" id="setuptime" name="setuptime" value="" />

									<br>
									<label>注册资本</label>
									<input  class="form-control" name="registeredcapital" id="registeredcapital" type="text" value="${company.registeredcapital}">
									<br>
									<label>法人代表</label>
									<input class="form-control" name="legalrepresentative" id="legalrepresentative" type="text" value="${company.legalrepresentative}">
									<br>
									<label>公司官网</label>
									<input class="form-control" name="website" id="website" type="text" value="${company.website}">
									<br>
									<label>所在城市</label>
									<select class="form-control" name="city" id="city">
										<c:forEach items="${city}" var="item">
										<option value="${item}" <c:if test="${item eq company.city}">selected</c:if>>${item}</option>
									</c:forEach>
								</select>
								<br>
								<label>公司规模</label>
								<select class="form-control" name="companysize" id="companysize">
									<c:forEach items="${compsize}" var="item">
									<option value="${item}" <c:if test="${item eq company.companysize}">selected</c:if>>${item}</option>
								</c:forEach>
							</select>
							<br>
							<label>融资阶段</label>
							<select class="form-control" name="financingstage" id="financingstage">
								<c:forEach items="${financings}" var="item">
								<option value="${item}" <c:if test="${item eq company.financingstage}">selected</c:if>>${item}</option>
							</c:forEach>
						</select>
						<br>
						<label>公司行业</label>
						<select class="form-control" name="industry" id="industry">
							<c:forEach items="${industry}" var="item">
							<option value="${item}" <c:if test="${item eq company.industry}">selected</c:if>>${item}</option>
						</c:forEach>
					</select>
					<br>
					<label>公司简介</label>
					<textarea class="form-control" name="introduction" id="introduction" placeholder="请输入公司简介..." rows="4">${company.introduction}</textarea>
					<br>
					<input type="hidden" id="companyid" name="id" value="${company.id}"/>
					<button type="button" id="button-update" class="btn btn-primary" style="float: right">提交</button>
				</div>
			</div>
			<!-- END INPUTS -->
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
<script src="/assets/js/tool.js"></script>
<script>
	$(function () {
	    var date = $('#setuptime').data('date');
        function filterDate(str){
            var date = new Date(str),
                year = date.getFullYear(),
                month = date.getMonth() + 1,
                day = date.getDate();
            return year + '-' + _fix(month) + '-' + _fix(day)
        }
        function _fix(n) {
            if (n < 10) {
                return '0' + n
            }
            return n
        }
        $('#setuptime').val(filterDate(date));
		// 点击后先上传文件后上传其它信息
		$("#button-update").click(function(){
		    upBasic()
		});
		function uploadImg(){
            var file = $('#imgurl').prop('files')[0];
            if(!file){
                window.alert('请上传商标')
            }
            var form = new FormData();
            form.append("uploadfile", file);
            $.ajax({
                url: '/comp/compimg.do',
                method: 'POST',
                data: form,
				// 告诉jQuery不要去处理发送的数据
                processData : false,
				// 告诉jQuery不要去设置Content-Type请求头
                contentType : false,
                success: function(res){
                    if(res.status === 0){
                        window.alert('上传成功')
                        $(window).attr('location','/comp/index.html');
                    }else{
                        window.alert('上传失败请重试')
                    }
                }
            })
		}
		function upBasic(){
			var companyname = $("#companyname").val();
			var address = $("#address").val();
			var setuptime = $("#setuptime").val();
			var registeredcapital = $("#registeredcapital").val();
			var city = $("#city").val();
			var introduction = $("#introduction").val();
			var legalrepresentative = $("#legalrepresentative").val();
			var id = $("#companyid").val();
			var industry = $("#industry").val();
			var financingstage = $("#financingstage").val();
			var companysize = $("#companysize").val();
			var website = $("#website").val();

			$.ajax({
				url:'/comp/saveorupdatecompany.do',
				type:'POST',
				data:{
					id:id,
					companyname:companyname,
					address:address,
					setuptime:setuptime,
					registeredcapital:registeredcapital,
					city:city,
					introduction:introduction,
					legalrepresentative:legalrepresentative,
					industry:industry,
					financingstage:financingstage,
					companysize:companysize,
					website:website
				},
				success:function (res) {

					if(res.status==0){
					    $('#button-upload').click();
					}else{
                        window.alert('上传失败请重试')
					}
				}
			});
		}
		function isBlank(str) {
			if(str==null||str=='')
				return true ;
			return false;
		}
	})
</script>x
</body>

</html>
