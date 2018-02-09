<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
	<title>标签管理</title>
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
		.icon{
			width: 30px;
			height: 30px;
			margin-left: 20px;
		}
		.form-inline{
			padding: 10px 0;
		}
		.form-inline label{
			margin-right: 20px;
			cursor: pointer;
		}
        th:first-child,
        td:first-child{
            width: 10%;
        }
        .panel .btn.foot{
            float: right;
            padding: 4px 20px;
            margin-top: 20px;
            color: white;
            background: lightseagreen;
        }
        .name.form-control{
            height: auto;
            padding: 2px 8px;
        }
        .status-select {
            width: auto;
            display: inline-block;
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
					<div class="row">
							<!-- RECENT PURCHASES -->
							<div class="panel">
								<div class="panel-heading">
                                    <h3 class="panel-title">标签管理</h3>
									<div class="right">
                                        <select class="form-control status-select" id="typeSelect">
                                            <option value="">标签增删</option>
                                            <option value="">小程序首页标签管理</option>
                                        </select>
									</div>
								</div>
								<div class="panel-body">
                                <div id="ctrlTag">
									<table class="table table-striped">
										<thead>
											<tr>
												<th>名字</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody id="tagBox">
                                        <c:forEach items="${pageInfo.list}" var="tag" varStatus="xh">
                                            <tr>
                                                <td>${tag.name}</td>
                                                <td><a href="#" class="J-delete" data-id="${tag.id}">删除</a></td>
                                            </tr>
                                        </c:forEach>
										</tbody>
									</table>
                                    <button class="btn foot" id="addTag">新增</button>
									<jsp:include page="/public/page.jsp">
										<jsp:param name="url" value="/admin/managetag.html"></jsp:param>
									</jsp:include>
                                </div>
                                    <form enctype="multipart/form-data" method="post"  action="/admin/customize.html" id="wechatTag" style="display:none">
                                        <div class="form-inline">
                                            <div class="form-group">
                                                <label>第一位显示</label>
                                                <select class="form-control J-tags" data-id="tagid1">
                                                </select>
                                            </div>
                                            <div class="form-group">
                                                <input class="form-control J-file" type="file" name="uploadfile" style="display: none">
                                                <img src="/public/upload.png" class="J-up icon"></img>
                                                <input id="tagid1" name="tagid1" style="display:none">
                                                <img src="" class="icon view" style="display: none"></img>
                                            </div>
                                        </div>
                                        <div class="form-inline">
                                        <div class="form-group">
                                            <label>第二位显示</label>
                                            <select class="form-control J-tags" data-id="tagid2">
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <input class="form-control J-file" type="file" name="uploadfile" style="display: none">
                                            <img src="/public/upload.png" class="J-up icon"></img>
                                            <input id="tagid2" name="tagid2" style="display:none">
                                            <img src="" class="icon view" style="display: none"></img>
                                        </div>
                                    </div>
                                        <div class="form-inline">
                                            <div class="form-group">
                                                <label>第三位显示</label>
                                                <select class="form-control J-tags" data-id="tagid3">
                                                </select>
                                            </div>
                                            <div class="form-group">
                                                <input class="form-control J-file" type="file" name="uploadfile" style="display: none">
                                                <img src="/public/upload.png" class="J-up icon"></img>
                                                <input id="tagid3" name="tagid3" style="display:none">
                                                <img src="" class="icon view" style="display: none"></img>
                                            </div>
                                        </div>
                                        <div class="form-inline">
                                            <div class="form-group">
                                                <label>第四位显示</label>
                                                <select class="form-control J-tags" data-id="tagid4">
                                                </select>
                                            </div>
                                            <div class="form-group">
                                                <input class="form-control J-file" type="file" name="uploadfile" style="display: none">
                                                <img src="/public/upload.png" class="J-up icon"></img>
                                                <input id="tagid4" name="tagid4" style="display:none">
                                                <img src="" class="icon view" style="display: none"></img>
                                            </div>
                                        </div>
                                        <button type="submit" class="btn btn-primary">提交</button>
                                    </form>
								</div>
							</div>
							<!-- END RECENT PURCHASES -->
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
	<script type="text/javascript">
		$(function(){
			$('.J-up').on('click',function(e){
				var tar = $(e.target);
				tar.prev().click();
			})
			$('.J-file').on('change',function(e){
				var file = this.files[0];
				var img = $($(e.target).siblings('.view')[0]);
				if(file.size > 128000){
					img.siblings('input[type=file]')[0].src = '';
					img.hide();
					return window.alert('请上传小于128k的图片')
				}
				var read  = new FileReader();
				read.readAsDataURL(file);
				read.onload=function(){
					var url = read.result;
					img.attr('src', url) ;
					img.css('display','inline-block');
				}
			})
            var tagBox = $('#tagBox');
			var typePage = [$('#ctrlTag'),$('#wechatTag')];
            // 分页显示
            $('#typeSelect').on('change',function(e){
                $(typePage).each(function(idx, item){
                    if(idx === e.target.selectedIndex){
                        $(item).show();
                    }else{
                        $(item).hide();
                    }
                })
                if(e.target.selectedIndex === 1){
                    getAllTag()
                }
            })
            // 新增填写显示
            $('#addTag').on('click', function(e){
                var el = "<tr>"
                        + "<td><input class='name form-control'></td>"
                        + "<td><a href='javascript: ;' class='J-confirmTag' data-type='confirm'>确认</a>&nbsp;<a class='J-cancel'>取消</a></td>"
                        + "</tr>"
               tagBox.append(el);
            })
            // 标签请求
            $('#tagBox').on('click',function(e){
                var tar = $(e.target);
                var parent = tar.parent();
                // 新增标签
                if(tar.hasClass('J-confirmTag')){
                    var inp = $(parent.prev().find('input')[0]);
                    var name = inp.val();
                    if(name){
                        $.post('/admin/addtag.do',{
                            type: 'jobtag',
                            name: name
                        }, function(res){
                            if(res.status == 0){
                                setTimeout(function(){
                                    location.reload()
                                }, 1500)
                                window.alert('新增标签成功！');
                            }else{
                                window.alert('失败请重试！');
                            }
                        })
                    }
                }
                else if(tar.hasClass('J-delete')){
                    if(window.confirm('确认删除标签？')){
                        $.post('/admin/deltag.do',{
                            id: tar.data('id')
                        },function(res){
                            if(res.status == 0){
                                parent.parent().remove();
                                window.alert('删除标签成功！');
                            }else{
                                window.alert('失败请重试！');
                            }
                        })
                    }
                }
                else if(tar.hasClass('J-cancel')){
                    parent.parent().remove()
                }
                e.preventDefault();
            })
           //  获取所有标签
            function getAllTag(){
                $.get('/admin/getJobTag.do',function(res){
                    var jobtag;
                    if(res.status === 0){
                        for(var i = 0, len = res.data.length;i < len; i++){
                            if(res.data[i].type === 'jobtag'){
                                jobtag = res.data[i].list;
                                break;
                            }
                        }
                        initSelect(jobtag)
                    }
                })
            }
           // 初始化选择
            function initSelect(tags){
                var tagsEl = [];
                var firstVal = tags[0];
                $(tags).each(function(idx, item){
                    tagsEl.push('<option value='+item+'>'+item+'</option>')
                })
                tagsEl = tagsEl.join('');
                $('.J-tags').each(function(idx, item){
                    item = $(item);
                    item.append(tagsEl);
                    var parent = $(this).parent();
                    $('#tagid'+(idx+1)).val(firstVal);
                })
//               初始化数据
            }
           // 选择标签事件
            $('.J-tags').on('change',function(e){
                var tar = $(this);
                var idx  = tar.prop('selectedIndex');
                var val = tar.find('option')[idx].value;
                var id = tar.data('id');
                $('#'+id).val(val);
            })
		})
	</script>
</body>

</html>
