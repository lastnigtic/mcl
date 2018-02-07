<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
	<title>发布招聘信息</title>
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
									<h3 class="page-title">编辑发布信息信息</h3>
									<label>岗位名称</label>
									<input type="text" name="jobname" id="jobname" class="form-control" placeholder="请输入岗位名称...">
									<br>
									<label>工作地点</label>
									<input type="text" name="address" id="address" class="form-control" placeholder="请输入工作地点...">
									<br/>
									<label>职位诱惑</label>
									<input type="text" name="temptation" id="temptation" class="form-control" placeholder="请输入职位诱惑...">
									<br>
									<label>月薪</label>
									<input type="number" name="wage"  id="wage" class="J-positiveNum form-control" placeholder="请输入月薪...">
									<br>
									<label>工作时长</label>
									<input type="number" name="duration" id="duration" class="J-positiveNum form-control" placeholder="请输入工作时长（单位：月）..." >
									<br>
									<label>工作城市</label>
									<select class="form-control" name="city" id="city">
										<c:forEach items="${cityproperty}" var="item">
											<option value="${item}">${item}</option>
										</c:forEach>
									</select>
									<br>
									<label>学历限制</label>
									<select class="form-control" name="education" id="education">
										<c:forEach items="${eduproperty}" var="item">
											<option value="${item}">${item}</option>
										</c:forEach>
									</select>
									<br>
									<label>上班频率</label>
									<select class="form-control" name="workfrequency" id="workfrequency">
										<c:forEach varStatus="xh" begin="1" end="7">
											<option value="${xh.count}">${xh.count}天/周</option>
										</c:forEach>
									</select>
									<br>
									<label>岗位类型</label>
									<select class="form-control" name="type" id="type">
										<c:forEach items="${jobtypeproperty}" var="item">
											<option value="${item}">${item}</option>
										</c:forEach>
									</select>
									<br>
									<label>岗位标签</label>
									<c:forEach items="${jobtagproperty}" var="item">
										<label class="fancy-checkbox">
											<input type="checkbox" name="tag" value="${item}">
											<span>${item}</span>
										</label>
									</c:forEach>
									<br>
									<label>岗位描述</label>
									<textarea class="form-control" id="description" name="description" placeholder="请输入岗位描述..." rows="4"></textarea>
									<br>
									<label>任职要求</label>
									<textarea class="form-control" id="requirements" name="requirements" placeholder="请输入任职要求..." rows="4"></textarea>
									<br>
									<button id="button-add" type="button" class="btn btn-primary" style="float: right">提交</button>
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
			$("#button-add").click(function () {

                var checkbox = $("input[name='tag']:checked");
                var tag = "";
                checkbox.each(function(){
                    tag += $(this).val()+",";
                })


			    var jobname = $("#jobname").val();
			    var temptation = $("#temptation").val();
			    var type = $("#type").val();
			    var wage = $("#wage").val();
			    var city = $("#city").val();
			    var address = $("#address").val();
			    var education = $("#education").val();
			    var duration = $("#duration").val();
			    var workfrequency = $("#workfrequency").val();
			    var description = $("#description").val();
			    var requirements = $("#requirements").val();

				if(isBlank(jobname)||isBlank(temptation)||isBlank(type)||isBlank(wage)
					||isBlank(city)||isBlank(address)||isBlank(education)||isBlank(workfrequency)||isBlank(description)||isBlank(requirements)){
				    alert("信息不全！无法提交！");
				    return;
				}

				$.ajax({
					url:'/comp/addjob.do',
					type:'POST',
					data:{
                        jobname : jobname ,
						temptation : temptation ,
						type : type ,
						wage : wage ,
						city : city ,
						address : address ,
						tag :tag ,
						education : education ,
						duration : duration ,
						workfrequency : workfrequency ,
						description : description ,
						requirements : requirements
					},
					success:function (res) {
						if(res.status==0){
						    alert('新增成功!');
						    $(window).attr('location','/comp/myjob.html');
						}else{
                            alert(res.msg);
                            $(window).attr('location','/comp/addjob.html');
						}
                    }
				})
            });

			function isBlank(str) {
				if(str==null||str=='')
				    return true ;
				return false;
            }
        })
	</script>
</body>

</html>
