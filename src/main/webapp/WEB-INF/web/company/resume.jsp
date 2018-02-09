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
        .ctrl-box{
            margin-bottom: 28px;
        }
        .ctrl-box .form-control{
            display: inline-block;
            height: auto;
            width: auto;
            padding: 2px 16px;
            vertical-align: middle;
            margin-left: 16px;
        }
        .title{
            font-size: 20px;
            vertical-align: middle;
        }
        .resume {
            display: inline-block;
            max-width: 830px;
            margin: 20px;
            background-color: #fff;
            border: 1px solid #eee;
            -webkit-box-shadow: 0 1px 4px rgba(0, 0, 0, 0.27), 0 0 60px rgba(0, 0, 0, 0.06) inset;
            -moz-box-shadow: 0 1px 4px rgba(0, 0, 0, 0.27), 0 0 40px rgba(0, 0, 0, 0.06) inset;
            box-shadow: 0 1px 4px rgba(0, 0, 0, 0.27), 0 0 40px rgba(0, 0, 0, 0.06) inset;
            position: relative;
            *zoom: 1;
        }
        img{
            width: 80px;
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
        input[type=date].form-control{
            line-height: 1.4em;
        }
        .resume span,
        .resume p{
            color: #5c5c5c;
            font-weight:bold;
        }
        /*评分*/
        .star-wrapper img{
            width: 30px;
            height: 30px;
            margin-left: 6px;
        }
        /*打印简历*/
        .pdf-wrapper{
            position: fixed;
            top: 50%;
            left: 50%;
            background: white;
        }
        .pdf-wrapper table{
            width: 100%;
            height: 100%;
            font-size: 14px;
            text-align: center;
        }
        .pdf-wrapper table .avatar{
            width: 10%;
            height: auto;
        }
        .pdf-wrapper table .title{
            text-align: center;
            color: black;
            font-weight: bold;
            font-size: 18px;
        }
        .pdf-wrapper table .sub-title{
            text-align: center;
            color: #5c5c5c;
            font-size: 16px;
            font-weight: bold;
        }
        .pdf-wrapper table .pdf-wrapper{
            position: fixed;
            top: 50%;
            left: 50%;
            background-color: white;
        }
        .pdf-wrapper table td{
            padding: 0 16px;
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
                    <%--操作--%>
                    <div class="ctrl-box">
                        <span class="title">简历状态: </span>
                        <select class="form-control" id="statusList" data-openid="${resume.userBaseInfo.openid}" data-id="${id}" data-joid="${resume.resDeliverStatus.joid}" data-status="${resume.resDeliverStatus.status}">
                        </select>
                        <input id="msg" class="form-control" placeholder="请输入邀约信息" style="display: none;">
                        <input id="entryTime" type="date" class="form-control" title="请选择入职时间" style="display: none;">
                        <button id="changeStatus" class="btn btn-primary form-control" style="height: auto; padding: 2px 16px;">确认</button>
                        <button id="toEvaluate" style="height: auto; padding: 2px 16px;float:right;" class="btn btn-primary form-control" data-toggle="modal" data-target="#evaluateModal">进行点评</button>
                    </div>
                    <div class="panel panel-profile">
                        <div class="clearfix">
                            <!-- LEFT COLUMN -->
                            <div class="profile-left" style="position: relative">
                                <!-- PROFILE HEADER -->
                                <div class="profile-header">
                                    <div class="overlay"></div>
                                    <div class="profile-main">
                                        <img src="/image/getimg.do?imgpath=${resume.userBaseInfo.avatarurl}" class="img-circle" alt="Avatar">
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
                                            <li>生日 <span class="J-Date">${resume.userBaseInfo.birthday}</span></li>
                                            <li>手机 <span>${resume.userBaseInfo.phone}</span></li>
                                            <li>邮箱 <span>${resume.userBaseInfo.email}</span></li>
                                            <li>所在城市 <span>${resume.userBaseInfo.city}</span></li>
                                            <li>学历 <span>${resume.userBaseInfo.education}</span></li>
                                            <li>就读学校 <span>${resume.userBaseInfo.schoolname}</span></li>
                                            <li>专业 <span>${resume.userBaseInfo.majortype}</span></li>
                                        </ul>
                                        <h4 class="heading">用户评分</h4>
                                        <div class="evaluation" id="evaluation"></div>
                                    </div>
                                </div>
                                <!-- END PROFILE DETAIL -->
                            </div>
                            <!-- END LEFT COLUMN -->
                            <!-- RIGHT COLUMN -->
                            <div class="profile-right">
                                <h4 class="heading" style="padding-bottom: 20px">个人简历
                                    <button id="downPDF" class="form-control" style="float:right; width: auto">下载简历</button>
                                </h4>
                                <div class="container-fluid resume" id="resume">
                                    <div class="media col-md-10 col-md-offset-1">
                                        <h3 class="media-name">${resume.resumename}</h3>
                                        <div class="media-left">
                                            <img class="media-object" src="/image/getimg.do?imgpath=${resume.avatarurl}" alt="...">
                                        </div>
                                        <div class="media-body">
                                            <div class="media-item">
                                                <h4 class="media-heading">期望实习</h4>
                                                <br/>
                                                <ul class="list-unstyled">
                                                    <li><span>${resume.jobapplied}</span> | <span>${resume.cityapplied} | <span>${resume.wageapplied}</span>元/天</li>
                                                    <li><span>${resume.frequencyapplied}</span>天/周 | <span>${resume.durationapplied}</span>个月 </li>
                                                </ul>
                                            </div>
                                            <div class="media-item">
                                                <h4 class="media-heading">教育背景</h4>
                                                <ul class="list-unstyled list-justify">
                                                    <li>学历<span>${resume.education}</span></li>
                                                    <li>学校名称<span>${resume.schoolname}</span></li>
                                                    <li>专业类别<span>${resume.major}</span></li>
                                                    <li>毕业时间<span class="J-Date">${resume.graduationtime}</span></li>
                                                    <li>社团经历<p>${resume.campusexp}</p></li>
                                                    <li>获奖经历<p>${resume.awards}</p></li>
                                                    <li>证书<p>${resume.certificate}</p></li>
                                                </ul>
                                            </div>
                                            <div class="media-item">
                                                <h4 class="media-heading">实习经历</h4>
                                                <ul class="list-unstyled list-justify">
                                                    <li>公司名称<span>${resume.companyname}</span></li>
                                                    <li>担任职位<span>${resume.jobname}</span></li>
                                                    <li>入职时间<span class="J-Date">${resume.entrytime}</span></li>
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
        <!-- Modal -->
        <div class="modal fade" id="evaluateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">点评</h4>
                    </div>
                    <div class="modal-body">
                        <label>组织能力</label>
                        <div class="star-wrapper" score="5">
                            <img  src="/public/star.png">
                            <img  src="/public/star.png">
                            <img  src="/public/star.png">
                            <img  src="/public/star.png">
                            <img  src="/public/star.png">
                        </div>
                        <br>
                        <label>沟通能力</label>
                        <div class="star-wrapper" score="5">
                            <img  src="/public/star.png">
                            <img  src="/public/star.png">
                            <img  src="/public/star.png">
                            <img  src="/public/star.png">
                            <img  src="/public/star.png">
                        </div>
                        <br>
                        <label>学习能力</label>
                        <div class="star-wrapper" score="5">
                            <img  src="/public/star.png">
                            <img  src="/public/star.png">
                            <img  src="/public/star.png">
                            <img  src="/public/star.png">
                            <img  src="/public/star.png">
                        </div>
                        <br>
                        <label>创新能力</label>
                        <div class="star-wrapper" score="5">
                            <img  src="/public/star.png">
                            <img  src="/public/star.png">
                            <img  src="/public/star.png">
                            <img  src="/public/star.png">
                            <img  src="/public/star.png">
                        </div>
                        <br>
                        <label>适应能力</label>
                        <div class="star-wrapper" score="5">
                            <img  src="/public/star.png">
                            <img  src="/public/star.png">
                            <img  src="/public/star.png">
                            <img  src="/public/star.png">
                            <img  src="/public/star.png">
                        </div>
                        <br>
                        <label>技术能力</label>
                        <div class="star-wrapper" score="5">
                            <img  src="/public/star.png">
                            <img  src="/public/star.png">
                            <img  src="/public/star.png">
                            <img  src="/public/star.png">
                            <img  src="/public/star.png">
                        </div>
                        <br>
                        <label>文字点评</label>
                        <input name="comment" id="comment" class="form-control" placeholder="请输入您对他(她)的表现的简短点评">
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
    <!-- WRAPPER -->
    <div id="pdfWrapper" class="pdf-wrapper" style="display: none">
        <table>
            <tr><td><img src="/image/getimg.do?imgpath=${resume.avatarurl}" class="avatar"></td></tr>
            <tr><td class="title">个人信息</td></tr>
            <tr><td>名字：${resume.userBaseInfo.realname} &nbsp;|&nbsp; 性别：<span>${resume.userBaseInfo.gender==1?'男':'女'}</span> &nbsp;|&nbsp; 生日：<span class="J-Date">${resume.userBaseInfo.birthday}</span> &nbsp;|&nbsp; 专业：${resume.userBaseInfo.majortype}</td></tr>
            <tr><td>手机：${resume.userBaseInfo.phone} &nbsp;|&nbsp; 邮箱：${resume.userBaseInfo.email}</td></tr>
            <tr><td class="title">教育背景</td></tr>
            <tr><td>学历：${resume.education} &nbsp;|&nbsp; 学校名称：${resume.schoolname}</td></tr>
            <tr><td>专业类别：${resume.major} &nbsp;|&nbsp; 毕业时间：<span class="J-Date">${resume.graduationtime}</span></td></tr>
            <c:choose>
            <c:when test="${resume.campusexp!=null}">
            <tr><td class="sub-title">社团经历</td></tr>
            <tr><td>${resume.campusexp}</td></tr>
        </c:when>
    </c:choose>

    <c:choose>
    <c:when test="${resume.awards!=null}">
    <tr><td class="sub-title">获奖经历</td></tr>
    <tr><td>${resume.awards}</td></tr>
</c:when>
</c:choose>

<c:choose>
<c:when test="${certificate!=null}">
<tr><td class="sub-title">证书</td></tr>
<tr><td>${resume.certificate}</td></tr>
</c:when>
</c:choose>
<tr><td class="title">期望实习</td></tr>
<tr><td>期望职位:${resume.jobapplied} &nbsp;|&nbsp; 期望城市：${resume.cityapplied}</td></tr>
<tr><td>期望工作天数：${resume.frequencyapplied}天/周 &nbsp;|&nbsp; 期望工作长度：${resume.durationapplied}个月</td></tr>
<tr><td>期望薪资：${resume.wageapplied}元/天 &nbsp;|&nbsp; 预计入职时间：<span class="J-Date">${resume.entrytime}</span></td></tr>
<c:choose>
<c:when test="${resume.jobname!=null}">
<tr><td class="title">实习经历</td></tr>
<tr><td>公司名称：${resume.companyname} &nbsp;|&nbsp; 担任职位：${resume.jobname}</td></tr>
<tr><td>入职时间：<span class="J-Date">${resume.jobstarttime}</span> &nbsp;|&nbsp; 离职时间：<span class="J-Date">${resume.jobendtime}</span></td></tr>
<tr><td class="sub-title">经历描述</td></tr>
<tr><td>${resume.jobdesc}</td></tr>
</c:when>
</c:choose>
<c:choose>
<c:when test="${resume.skills!=null}">
<tr><td class="title">技能爱好</td></tr>
<tr><td>${resume.skills}</td></tr>
</c:when>
</c:choose>
<c:choose>
<c:when test="${resume.selfevaluation!=null}">
<tr><td class="title">自我评价</td></tr>
<tr><td>${resume.selfevaluation}</td></tr>
</c:when>
</c:choose>
</table>
</div>
<!-- END WRAPPER -->
<!-- Javascript -->
<script src="/assets/vendor/jquery/jquery.min.js"></script>
<script src="/assets/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="/assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<script src="/assets/vendor/echarts/echarts.min.js"></script>
<script src="/assets/vendor/jspdf/jsPdf.debug.js"></script>
<script src="/assets/vendor/jspdf/html2canvas.js"></script>
<script src="/assets/scripts/klorofil-common.js"></script>
<script src="/assets/js/tool.js"></script>
<script>
    $(function(){
        var staBox = $('#statusList');
        var msgInp = $('#msg');
        var entryTimeInp = $('#entryTime');
//        拿到所需数据
function params(){
    var _status = staBox.data('status');
    var _id = staBox.data('id');
    var _joid = staBox.data('joid');
    var _openid = staBox.data('openid');
    if(_status === 1){
        doChangeStatus(true, _id, _joid, 2);
        _status = 2;
    }
    params = function(str){
        if(str === 'id'){
            return _id;
        }if(str === 'status'){
            return _status
        }if(str === 'joid'){
            return _joid
        }if(str === 'openid'){
            return _openid
        }
    }
}
params();
//       邀约面试时显示信息输入框(邀约面试需要邀请消息,通过面试设置入职时间)
staBox.on('change', function(e){
    var status = staBox.find("option:selected")[0].value;
    if( status== 3 && params('status') !== 3){
        msgInp.css('display','inline-block');
        entryTimeInp.hide();
    }else if(status == 4 && params('status') !== 4){
        entryTimeInp.css('display','inline-block');
        msgInp.hide();
    }
    else{
        msgInp.hide();
        entryTimeInp.hide();
    }
})
//        初始化状态组件
function initCtrl(n){
    var statArr = ['已投递','被查看','邀约面试','面试通过','不合适'];
    var i = n - 1,
    len = statArr.length;
    statArr[i] += '(当前)';
    for(; i < len; i++){
        staBox.append('<option value='+ (Number(i)+1) +'>'+ statArr[i] +'</option>')
    }
    if(n == 4){
       $(staBox.find('option:last-child')).remove()
   }
}
initCtrl(params('status'));

//      提交状态改变
$('#changeStatus').on('click', function(){
    var status = staBox.find("option:selected")[0].value,
    id = params('id'),
    joid = params('joid'),
    msg,
    entrytime;
    if(status == 3){
        msg = msgInp.val();
    }else if(status == 4){
        entrytime = entryTimeInp.val();
    }

    doChangeStatus(false, id, joid, status, msg, entrytime)
})
function doChangeStatus(isInit, id, joid, status, msg, entrytime){
    var data={
        id: id,
        status: status,
        joid: joid
    }
    if(status == 3){
        if(!msg){
            return window.alert('请输入邀约信息')
        }
        data.msg = msg
    }else if(status == 4){
        if(!entrytime){
            return window.alert('请设置入职时间')
        }
        data.entrytime = entrytime
    }
    $.post('/comp/changeresumestatus.do',data, function(res){
        if(res.status === 0){
            if(!isInit){
                window.alert('操作成功');
                setTimeout(function(){
                    window.location.reload(true);
                },1000)
            }
        }else{
            if(!isInit){
                window.alert('操作失败，请重试')
            }
        }
    })
}
//        用户能力六维图

//        获取用户能力数值
var openid = params('openid');
var eva = document.getElementById('evaluation');
var ablityArr = [
{name:'organizationability'},
{name:'communicateability'},
{name:'learnability'},
{name:'innovationability'},
{name:'adaptability'},
{name:'technicalability'},
]
$.post('/comp/getuseravgability.do',{
    openid: openid
},function (res) {
    if(res.status === 0){
        drawRadia(res.data)
    }else{
        eva.innerText = '暂无数据'
    }
})
function drawRadia(data){
    eva.style.height = eva.offsetWidth + 'px';
    var myChart = echarts.init(eva);
    var value = [];
    $(ablityArr).each(function(idx, item){
        value.push(data[item.name])
    });
    var option = {
        radar: {
            name: {
                textStyle: {
                    color: '#fff',
                    backgroundColor: '#999',
                    borderRadius: 3,
                    padding: [3, 5]
                }
            },
            indicator: [
            { name: '组织能力', max: 5},
            { name: '沟通能力', max: 5},
            { name: '学习能力', max: 5},
            { name: '创新能力', max: 5},
            { name: '适应能力', max: 5},
            { name: '技术能力', max: 5}
            ]
        },
        series: [{
            name: '能力评分',
            type: 'radar',
                    // areaStyle: {normal: {}},
                    data : [{
                        value : value,
                        name : '能力评分'
                    }]
                }]
            };
            myChart.setOption(option)
        }
//      判断能否评分
function canScore(){
    $.post('/comp/canscoreuser.do',{
        openid: params('openid'),
        joid: params('joid'),
    },function(res){
        if(res.status === 0){
            $('#toEvaluate').show();
        }
    })
}
canScore();
//      分值在1-5
$('.star-wrapper').on('click',function(e){
    if(e.target.tagName === 'IMG'){
        var tar = $(e.target);
        var tidx = tar.index();
        $(this).attr('score', tidx+1)
        $(this).find('img').each(function(idx,item){
            if(idx <= tidx){
                item.src = '/public/star.png'
            }else{
                item.src = '/public/star_none.png'
            }
        })
    }
})
//提交评价
$('#evaluateSubmit').on('click', function(e){
    var body = $(e.currentTarget).closest('modal-body');
    var cansubmit = true;
    var data = {};
    // 取到所有数据
    $('.star-wrapper').each(function(idx, item){
        item = $(item);
        data[ablityArr[idx].name] = item.attr('score');
    })
    var comment = $('$comment').val();
    if(!comment){
        alert('请输入文字评价')
    }
    data.comment = comment
    if(cansubmit){
        data.openid = params('openid');
        data.joid = params('joid');
        $.post('/comp/ratetouser.do',data,function(res){
            if(res.status === 0){
                window.alert('评价成功');
                $('#evaluateModal').remove();
                $('#toEvaluate').remove();
            }else{
                window.alert('评价失败请重试');
            }
        })
    }
})
        // 导出pdf
        var pdfel = document.getElementById('pdfWrapper');
        var avHeight = document.documentElement.clientHeight;
        var avWidth = avHeight / 1.4;
        $(pdfel).css({
            'height': avHeight + 'px',
            'width': avWidth + 'px',
            'maxHeight': avHeight + 'px',
            'maxWidth': avWidth + 'px',
            'margin': '-' + avHeight/2 + 'px 0 0 -' + avWidth/2 + 'px'
        })
        $('#downPDF').on('click',function(e){
         $('#wrapper').hide();
         $(pdfel).show();
         var avatar  = $(pdfel).find('img')[0];
         html2canvas(avatar,{
             onrendered: function(canvas){
                 var imgData = canvas.toDataURL('image/jpeg', 1.0);
                 avatar.src = imgData;
                 avatar.onload = function(){
                     createPDF();
                 }
             }
         })
     })
        function createPDF(){
            html2canvas(pdfel,{
                onrendered: function(canvas){
                    var pageData = canvas.toDataURL('image/jpeg', 1.0);
                    var pdf = new jsPDF('', 'pt', 'a4');
                    pdf.addImage(pageData, 'JPEG', 0, 0, 595, 842);
                    pdf.save('resume.pdf');
                    $('#wrapper').show();
                    $(pdfel).hide();
                }
            })
        }
    })
</script>
</body>

</html>

