<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<!-- NAVBAR -->
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="brand">
		<%--<img src="/assets/img/life.png" alt="Life+ logo" class="img-responsive logo">--%>
		<a href="/comp/index.html"></a>
	</div>
	<div class="container-fluid">
		<div class="navbar-btn">
			<button type="button" class="btn-toggle-fullwidth"><i class="lnr lnr-arrow-left-circle"></i></button>
		</div>
		<div id="navbar-menu">
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle icon-menu" data-toggle="dropdown">
						<i class="lnr lnr-alarm"></i>
						<span class="badge bg-danger">6</span>
					</a>
					<ul class="dropdown-menu notifications">
						<li><a href="#" class="notification-item"><span class="dot bg-warning"></span>【王谋】投递了您的【JavaScript前端工程师】岗位</a></li>
						<li><a href="#" class="notification-item"><span class="dot bg-danger"></span>【李彦鹏】投递了您的【Java web后端工程师】</a></li>
						<li><a href="#" class="notification-item"><span class="dot bg-warning"></span>【王谋】投递了您的【JavaScript前端工程师】岗位</a></li>
						<li><a href="#" class="notification-item"><span class="dot bg-danger"></span>【李彦鹏】投递了您的【Java web后端工程师】</a></li>
						<li><a href="#" class="notification-item"><span class="dot bg-warning"></span>【王谋】投递了您的【JavaScript前端工程师】岗位</a></li>
						<li><a href="#" class="notification-item"><span class="dot bg-danger"></span>【李彦鹏】投递了您的【Java web后端工程师】</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown"><img src="/assets/img/user.png" class="img-circle" alt="Avatar"> <span>HR 您好！</span> <i class="icon-submenu lnr lnr-chevron-down"></i></a>
					<ul class="dropdown-menu">
						<!-- <li><a href="#"><i class="lnr lnr-user"></i> <span>My Profile</span></a></li>
						<li><a href="#"><i class="lnr lnr-envelope"></i> <span>Message</span></a></li> -->
						<li><a href="/logout.do"><i class="lnr lnr-exit"></i> <span>登出</span></a></li>
					</ul>
				</li>				
			</ul>
		</div>
	</div>
</nav>
<!-- END NAVBAR -->