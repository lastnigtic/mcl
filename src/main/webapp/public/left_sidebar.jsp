<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!-- LEFT SIDEBAR -->
<div id="sidebar-nav" class="sidebar">
	<div class="sidebar-scroll">
		<nav>
			<ul class="nav">
				<li><a href="index.jsp" class="active"><i class="lnr lnr-home"></i> <span>主页</span></a></li>

				<li>
					<a href="#subPages" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i> <span>实习模块</span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
					<div id="subPages" class="collapse ">
						<ul class="nav">
							<li><a href="addjob.jsp" class="">新的岗位+</a></li>
							<li><a href="myjob.jsp" class="">我的发布</a></li>
							<li><a href="myresumebox.jsp" class="">我的简历箱</a></li>
						</ul>
					</div>
				</li>
				<li>
					<a href="#subPages2" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i> <span>公司信息</span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
					<div id="subPages2" class="collapse">
						<ul class="nav">
							<li><a href="editinfo.jsp" class="">查看/修改</a></li>
							<li><a href="verified.jsp" class="">实名认证</a></li>
						</ul>
					</div>
				</li>
			</ul>
		</nav>
	</div>
</div>
<!-- END LEFT SIDEBAR -->