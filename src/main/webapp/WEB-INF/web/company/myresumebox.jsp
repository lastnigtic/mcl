<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>我的简历箱</title>
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
                    <div class="col-md-12">
                        <div class="panel">
                            <div class="panel-heading">
                                <h3 class="panel-title">收到的简历</h3>
                            </div>
                            <div class="panel-body">
                                <table class="table table-striped">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>姓名</th>
                                        <th>学校</th>
                                        <th>学历</th>
                                        <th>岗位</th>
                                        <th>毕业时间</th>
                                        <th>更新时间</th>
                                        <th>简历状态</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody id="table-body">
                                    <c:choose>
                                        <c:when test="${resumelist!=null}">
                                        <c:forEach items="${resumelist}" var="item" varStatus="xh">
                                            <tr>
                                                <td>${xh.count}</td>
                                                <td>${item.userBaseInfo.realname}</td>
                                                <td>${item.schoolname}</td>
                                                <td>${item.education}</td>
                                                <td>${item.jobname}</td>
                                                <td class="J-Date">${item.graduationtime}</td>
                                                <td class="J-Date">${item.updatetime}</td>
                                                    <c:choose>
                                                        <c:when test="${item.resDeliverStatus.status==1}">
                                                            <td><span class="label label-success">被查看</span></td>
                                                        </c:when>
                                                        <c:when test="${item.resDeliverStatus.status==2}">
                                                            <td><span class="label label-success">邀约面试</span></td>
                                                        </c:when>
                                                        <c:when test="${item.resDeliverStatus.status==3}">
                                                            <td><span class="label label-success">面试通过</span></td>
                                                        </c:when>
                                                        <c:when test="${item.resDeliverStatus.status==4}">
                                                            <td><span class="label label-danger">不合适</span></td>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <td><span class="label label-danger">其他</span></td>
                                                        </c:otherwise>
                                                    </c:choose>

                                                <td><a href="/comp/resume.html?resumeid=${item.id}&id=${item.resDeliverStatus.id}">查看</a></td>
                                            </tr>
                                        </c:forEach>
                                        </c:when>
                                        <c:otherwise>
                                            <tr>
                                                <td colspan="8">暂无数据</td>
                                            </tr>
                                        </c:otherwise>

                                    </c:choose>
                                    </tbody>
                                </table>
                                <jsp:include page="/public/page.jsp">
                                    <jsp:param name="url" value="/comp/myresumebox.html"></jsp:param>
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

    })
</script>
</body>

</html>
