<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>河北九洲普惠风机销售分公司</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon" /> 
<link rel="stylesheet" type="text/css" 
href="${pageContext.request.contextPath}/css/whir.css" />
</head>
<body>
	<c:set var="nav" value="${sessionScope.nav }" />
	<c:set var="cons" value="${requestScope.cons }" />
	<c:set var="title" value="${requestScope.title}" />
	<c:set var="page" value="${requestScope.page}" />
	<c:set var="cafter" value="${requestScope.cafter}" />
	<c:set var="ccurrent" value="${requestScope.ccurrent}" />
	<c:set var="cbefore" value="${requestScope.cbefore}" />
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
			<div class="le">N</div>
			<div class="ri">
				<span class="cn">${nav.navigation_name }</span><span class="en">ews</span>
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
					<!-- 类型3为新闻内容显示 -->
					<!-- 类型5为项目内容显示 -->
					<c:if test="${title.title_type == 3 ||title.title_type == 5  }">
						<article class="News_info">
						<h3 class="info_title h3">${ccurrent.context_title }</h3>
						<time class="info_time"> <fmt:formatDate
							value="${ccurrent.context_date }" dateStyle="long" /></time>
						<div class="info_txt">${ccurrent.context_text }</div>
						<div class="PrevNextBox">
							<h1 class="h1">
								<a
									href="${pageContext.request.contextPath}/${nav.navigation_url }/${title.title_url }?id=${title.title_id }">[
									返回列表 ]</a>
							</h1>
							<dl>
								<c:choose>
									<c:when test="${empty cafter}">
										<a class="none" href="javascript:void(0);">上一篇：已经没有上一篇了</a>
									</c:when>
									<c:otherwise>
										<a class="none"
											href="${pageContext.request.contextPath}/${nav.navigation_url }/single?id=${cafter.context_id }">上一篇：${cafter.context_title }</a>
									</c:otherwise>

								</c:choose>
							</dl>
							<dl>
								<c:choose>
									<c:when test="${empty cbefore}">
										<a class="none" href="javascript:void(0);">下一篇：已经没有下一篇了</a>
									</c:when>
									<c:otherwise>
										<a class="none"
											href="${pageContext.request.contextPath}/${nav.navigation_url }/single?id=${cbefore.context_id }">下一篇：${cbefore.context_title }</a>
									</c:otherwise>
								</c:choose>
							</dl>
						</div>
						</article>
					</c:if>
					<!-- 类型4为商品内容显示 -->
					<c:if test="${title.title_type == 4}">
						<div class="picFocus">
							<div class="bd">
								<div class="tempWrap">
									<div class="tempWrap"
										style="overflow: hidden; position: relative; width: 373px">
										<ul>
											<c:forEach var="imgUrl" items="${ccurrent.pro_image }">
												<li style="float: left; width: 373px;"><img
													src="${pageContext.request.contextPath}${imgUrl }"></li>
											</c:forEach>
										</ul>
									</div>
								</div>
							</div>
							<div class="txt">
								<h3>${ccurrent.pro_name }</h3>
								<p>产品规格：${ccurrent.pro_specification }</p>
								<p>所属类别：${ccurrent.pro_type }</p>
							</div>
							<div class="hd">
								<a class="sPrev" href="javascript:void(0)"></a>
								<ul>
									<c:forEach var="imgUrl" items="${ccurrent.pro_image }">
										<li><img src="${pageContext.request.contextPath}${imgUrl}"></li>
									</c:forEach>
								</ul>
								<a class="sNext" href="javascript:void(0)"></a>
							</div>
						</div>
						<div class="technical">
							<h2>技术参数</h2>
							<div>${ccurrent.pro_parameter }</div>
						</div>
						<div class="PrevNextBox">
							<h1 class="h1">
								<a
									href="${pageContext.request.contextPath}/${nav.navigation_url }/${title.title_url }?id=${title.title_id }">[
									返回列表 ]</a>
							</h1>
							<dl>
								<c:choose>
									<c:when test="${empty cafter}">
										<a class="none" href="javascript:void(0);">上一篇：已经没有上一篇了</a>
									</c:when>
									<c:otherwise>
										<a class="none"
											href="${pageContext.request.contextPath}/${nav.navigation_url }/single?id=${cafter.pro_id  }">上一篇：${cafter.pro_name }</a>
									</c:otherwise>

								</c:choose>
							</dl>
							<dl>
								<c:choose>
									<c:when test="${empty cbefore}">
										<a class="none" href="javascript:void(0);">下一篇：已经没有下一篇了</a>
									</c:when>
									<c:otherwise>
										<a class="none"
											href="${pageContext.request.contextPath}/${nav.navigation_url }/single?id=${cbefore.pro_id }">下一篇：${cbefore.pro_name }</a>
									</c:otherwise>
								</c:choose>
							</dl>
						</div>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/zooming.min.js"></script>
<script type="text/javascript">
	var li_id = "${title.title_url}${title.title_id}";
	var url = "${nav.navigation_url}";
	var id = "${nav.navigation_id}";
	var name = "${nav.navigation_name}";
	var ppath = "${pageContext.request.contextPath}";// 项目名路径
	jQuery(".picFocus").slide({
		mainCell : ".bd ul",
		effect : "left",
		autoPlay : true,
		prevCell : ".sPrev",
		nextCell : ".sNext"
	});
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/other.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/index_animate.js"></script>
</html>

