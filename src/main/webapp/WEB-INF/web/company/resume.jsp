<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html >

<head>
    <title>Profile</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <!-- VENDOR CSS -->
    <link rel="stylesheet" href="/assets/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/vendor/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="/assets/vendor/linearicons/style.css">
    <!-- MAIN CSS -->
    <link rel="stylesheet" href="/assets/css/main.css">
    <!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
    <link rel="stylesheet" href="/assets/css/demo.css">
    <!-- GOOGLE FONTS -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
    <!-- ICONS -->
    <link rel="apple-touch-icon" sizes="76x76" href="/assets/img/apple-icon.png">
    <link rel="icon" type="image/png" sizes="96x96" href="/assets/img/favicon.png">
    <style type="text/css">
        .resume {
            display: inline-block;
            margin: 20px;
            background-color: #fff;
            border: 1px solid #eee;
            -webkit-box-shadow: 0 1px 4px rgba(0, 0, 0, 0.27), 0 0 60px rgba(0, 0, 0, 0.06) inset;
            -moz-box-shadow: 0 1px 4px rgba(0, 0, 0, 0.27), 0 0 40px rgba(0, 0, 0, 0.06) inset;
            box-shadow: 0 1px 4px rgba(0, 0, 0, 0.27), 0 0 40px rgba(0, 0, 0, 0.06) inset;
            position: relative;
            *zoom: 1;
        }

        .resume:before {
            -webkit-transform: skew(-15deg) rotate(-6deg);
            -moz-transform: skew(-15deg) rotate(-6deg);
            transform: skew(-15deg) rotate(-6deg);
            left: 15px;
        }
        .resume:after {
            -webkit-transform: skew(15deg) rotate(6deg);
            -moz-transform: skew(15deg) rotate(6deg);
            transform: skew(15deg) rotate(6deg);
            right: 15px;
        }

        .resume:before, .resume:after {
            width: 70%;
            height: 55%;
            content: ' ';
            -webkit-box-shadow: 0 8px 16px rgba(0, 0, 0, 0.3);
            -moz-box-shadow: 0 8px 16px rgba(0, 0, 0, 0.3);
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.3);
            position: absolute;
            bottom: 10px;
            z-index: -1;
        }
        .media-name{
            margin-bottom: 0.5em;
            text-align: center;
            border-bottom: 2px solid #f1f1f1;
        }
        .media-body .media-item:not(:first-child){
            padding: 5px 0;
        }
        .media-body .media-item .media-heading{
            padding-bottom: 0.5em;
            border-bottom: 1px solid #f1f1f1;
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
                <div class="panel panel-profile">
                    <div class="clearfix">
                        <!-- LEFT COLUMN -->
                        <div class="profile-left">
                            <!-- PROFILE HEADER -->
                            <div class="profile-header">
                                <div class="overlay"></div>
                                <div class="profile-main">
                                    <img src="${resume.userBaseInfo.avatarurl}" class="img-circle" alt="Avatar">
                                    <h3 class="name">${resume.userBaseInfo.realname}</h3>
                                </div>
                            </div>
                            <!-- END PROFILE HEADER -->
                            <!-- PROFILE DETAIL -->
                            <div class="profile-detail">
                                <div class="profile-info">
                                    <h4 class="heading">基本信息</h4>
                                    <ul class="list-unstyled list-justify">
                                        <li>性别 <span>${resume.userBaseInfo.gender==1?'男':'女'}</span></li>
                                        <li>生日 <span>${resume.userBaseInfo.birthday}</span></li>
                                        <li>手机 <span>${resume.userBaseInfo.phone}</span></li>
                                        <li>邮箱 <span>${resume.userBaseInfo.email}</span></li>
                                        <li>所在城市 <span>${resume.userBaseInfo.city}</span></li>
                                        <li>学历 <span>${resume.userBaseInfo.education}</span></li>
                                        <li>就读学校 <span>${resume.userBaseInfo.schoolname}</span></li>
                                        <li>专业 <span>${resume.userBaseInfo.majortype}</span></li>
                                    </ul>
                                </div>
                            </div>
                            <!-- END PROFILE DETAIL -->
                        </div>
                        <!-- END LEFT COLUMN -->
                        <!-- RIGHT COLUMN -->
                        <div class="profile-right">
                            <h4 class="heading">个人简历</h4>
                            <div class="container-fluid resume">
                                <div class="media col-md-10 col-md-offset-1">
                                    <h3 class="media-name">${resume.resumename}</h3>
                                    <div class="media-left">
                                        <img class="media-object" src="${resume.avatarurl}" alt="...">
                                    </div>
                                    <div class="media-body">
                                        <div class="media-item">
                                            <h4 class="media-heading">期望实习</h4>
                                            <br/>
                                            <ul class="list-unstyled">
                                                <li>${resume.jobapplied} | ${resume.cityapplied} | ${resume.wageapplied}元/天</li>
                                                <li>${resume.frequencyapplied}天/周 | ${resume.durationapplied}个月 </li>
                                            </ul>
                                        </div>
                                        <div class="media-item">
                                            <h4 class="media-heading">教育背景</h4>
                                            <ul class="list-unstyled list-justify">
                                                <li>学历<span>${resume.education}</span></li>
                                                <li>学校名称<span>${resume.schoolname}</span></li>
                                                <li>专业类别<span>${resume.major}</span></li>
                                                <li>毕业时间<span>${resume.graduationtime}</span></li>
                                                <li>社团经历<p>${resume.campusexp}</p></li>
                                            </ul>
                                        </div>
                                        <div class="media-item">
                                            <h4 class="media-heading">实习经历</h4>
                                            <ul class="list-unstyled list-justify">
                                                <li>公司名称<span>${resume.companyname}</span></li>
                                                <li>担任职位<span>${resume.jobname}</span></li>
                                                <li>入职时间<span>${resume.entrytime}</span></li>
                                                <li>经历描述<span>${resume.jobdesc}</span></li>
                                            </ul>
                                        </div>
                                        <div class="media-item">
                                            <h4 class="media-heading">技能爱好</h4>
                                            <p>${resume.skills}</p>
                                        </div>
                                        <div class="media-item">
                                            <h4 class="media-heading">自我评价</h4>
                                            <p>${resume.selfevaluation}</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
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
<script src="/assets/vendor/jquery/jquery.min.js"></script>
<script src="/assets/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="/assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<script src="/assets/scripts/klorofil-common.js"></script>
</body>

</html>

