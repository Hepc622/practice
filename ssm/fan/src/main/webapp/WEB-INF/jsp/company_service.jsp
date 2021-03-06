<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>河北九洲普惠风机销售分公司</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon" /> 
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/whir.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/addlay.css" />
</head>
<body>
	<c:set var="nav" value="${sessionScope.nav }" />
	<c:set var="con" value="${requestScope.con }" />
	<c:set var="title" value="${requestScope.title}" />
	<!--Top-->
	<header class="Top">
	<div class="TopMain">
		<nav class="MainNav">
		<ul>
			<c:forEach items="${sessionScope.navs }" var="navs">
				<li id="${navs.navigation_url }"><a class="navA"
					href="${pageContext.request.contextPath}/${navs.navigation_url}?id=${navs.navigation_id }"><span>${navs.navigation_name }</span></a></li>
			</c:forEach>
		</ul>
		</nav>
		<div class="logo">
			<a href='/index'><img src="${pageContext.request.contextPath}/images/201505271340514051.jpg" /></a>
		</div>
	</div>
	</header>
	<!--Top End-->
	<aside class="nyBanner"> <img id="topimg"
		src="${pageContext.request.contextPath}${nav.navigation_img }"> </aside>
	<section class="Mianbg"> <section class="MianContent">
	<div class="nyContain">
		<aside class="SildeBar"> <nav class="Menu">
		<div class="SildeBarhead">
			<div class="le">M</div>
			<div class="ri">
				<span class="cn">${nav.navigation_name }</span><span class="en">erchants
					Recruitment</span>
			</div>
		</div>
		<div class="clear"></div>
		<ul class="MenuList">
			<c:forEach items="${sessionScope.titles }" var="titles">
				<li id="${titles.title_url }${titles.title_id }"><a
					href="${pageContext.request.contextPath}/${nav.navigation_url }/${titles.title_url }?id=${titles.title_id }"
					class="MenuA">${titles.title_name }</a></li>
			</c:forEach>
		</ul>
		</nav> </aside>
		<div class="nyRight">
			<div class="nyCont">
				<div class="nyCont_con">
					<div class="Current">
						<h1>
							当前位置:<a href="${pageContext.request.contextPath}/">首页</a>><a
								href="${pageContext.request.contextPath}/${nav.navigation_url }?id=${nav.navigation_id }">${nav.navigation_name }</a>><span>${title.title_name }</span>
						</h1>
						<b>${title.title_name }</b>
					</div>
					<!-- 内容显示模式1 -->
					<c:if test="${not empty sessionScope.user }">
						<form id="releaseform"
							action="${pageContext.request.contextPath}/context/save">
							<input name="id" type="hidden" value="${title.title_id }">
							<input name="contexts" type="hidden">
							<div class="Singlepage" contentEditable="true">${con.context_text}</div>
							<input type="submit" value="发布" class="btn btn-primary"
								onclick="release();return false;">
						</form>
					</c:if>
					<c:if test="${empty sessionScope.user }">
						<div class="Singlepage" id="${t.title_id }">${con.context_text}</div>
					</c:if>
				</div>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	</section> </section>
	<div class="clear"></div>
	<!--Bottom-->
	<footer class="Footbg">
	<div class="foot">
		<div class="footCopy">© 2017 河北九洲普惠风机销售分公司</div>
		<div class="footHome">
			<a
				href='http://mail.populafan.com/alimail/auth/login?custom_login_flag=1&reurl=%2Falimail%2F'
				target=_blank>企业邮箱</a> <a title="友情链接">友情链接</a> <a title="下载中心">下载中心</a>
			<a title="网站声明">网站声明</a> <a title="联系我们">联系我们</a>
		</div>
	</div>
	</footer>
	<!--Bottom end-->
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js" /></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.SuperSlide.js" /></script>
<script type="text/javascript">
	var li_id = "${title.title_url}${title.title_id}";
	var url = "${nav.navigation_url}";
	var id = "${nav.navigation_id}";
	var name = "${nav.navigation_name}";
	var ppath = "${pageContext.request.contextPath}";// 项目名路径
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/other.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/index_animate.js"></script>
</html>

