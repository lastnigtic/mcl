<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!-- LEFT SIDEBAR -->
<div id="sidebar-nav" class="sidebar">
	<div class="sidebar-scroll">
		<nav>
			<ul class="nav">
				<li><a href="/comp/index.html" class=""><i class="lnr lnr-home"></i> <span>首页</span></a></li>

				<li>
					<a href="#subPages" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i><span>兼职实习管理</span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
					<div id="subPages" class="collapse ">
						<ul class="nav">
							<li><a href="/comp/addjob.html" class="">新增岗位</a></li>
							<li><a href="/comp/myjob.html" class="">岗位列表</a></li>
						</ul>
					</div>
				</li>
				<li>
					<a href="#subPages2" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i> <span>企业信息管理</span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
					<div id="subPages2" class="collapse">
						<ul class="nav">
							<li><a href="/comp/editinfo.html" class="">编辑公司信息</a></li>
							<li><a href="/comp/verified.html" class="">实名认证</a></li>
						</ul>
					</div>
				</li>
				<li><a href="/comp/msglist.html" ><i class="lnr lnr-home"></i> <span>消息列表</span></a></li>
				<li><a href="/comp/ratelist.html" ><i class="lnr lnr-home"></i> <span>评分列表</span></a></li>

			</ul>
		</nav>
	</div>
	<script>
        var href = window.location.href;
        var as = document.getElementsByTagName('a');
        var isHigh = false;
        for(var s = 0, len = as.length;s<len;s++){
            if(href.indexOf(as[s].getAttribute('href'))>0){
                as[s].className = 'active';
                isHigh = true;
            }
        }
        if(!isHigh){as[0].className = 'active'}
	</script>
</div>
<!-- END LEFT SIDEBAR -->