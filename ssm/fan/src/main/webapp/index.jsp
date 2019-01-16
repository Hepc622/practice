<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" /> 
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/whir.css" />
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>河北九洲普惠风机销售分公司</title>
</head>
<body>
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
				<a href='/index'><img
					src="${pageContext.request.contextPath}/images/201505271340514051.jpg" /></a>
			</div>
		</div>
	</header>
	<!--Top End-->
	<section class="IndexMain">
		<div class="Banner"></div>
		<div class="Indexbg"></div>
		<div class="IndexCon">
			<ul>
				<li class="color1">
					<h3>关于我们</h3>
					<ul>
						<li><a class="apic"
							href='${pageContext.request.contextPath}/about/qygk?id=1'
							title="1">企业概况</a></li>
						<li><a class="apic"
							href='${pageContext.request.contextPath}/about/jsyf?id=3'
							title="2">技术研发</a></li>
						<li><a class="apic"
							href='${pageContext.request.contextPath}/about/fzlc?id=5'
							title="3">发展历程</a></li>
					</ul> <em><img
						src="${pageContext.request.contextPath}/images/line_01.png"></em>
				</li>
				<li><img id="changepic" width="100%" height="100%"
					src="${pageContext.request.contextPath}/images/20150528135101511.jpg">
				</li>
				<li class="color6">
					<div class="li_div">
						<div class="a_link">
							<p>产品中心</p>
							<div class="icon">
								<img width="85px" height="85px"
									src="${pageContext.request.contextPath}/images/icon05.png">
							</div>
						</div>
						<div class="a_link_hide">
							<a href='${pageContext.request.contextPath}/product?id=5'>
								<p>产品中心</p>
								<div class="icon">
									<img width="85px" height="85px"
										src="${pageContext.request.contextPath}/images/icon05.png">
								</div>
							</a>
						</div>
					</div>
				</li>
				<li class="color2">
					<div class="li_div">
						<div class="a_link">
							<div class="icon">
								<img src="${pageContext.request.contextPath}/images/icon01.png">
							</div>
							<p>荣誉资质</p>
							<span>广东名牌产品</span> <span>中国十大风机质量品牌</span>
						</div>
						<div class="a_link_hide">
							<a href='${pageContext.request.contextPath}/about/ryzz?id=2'>
								<div class="icon">
									<img src="${pageContext.request.contextPath}/images/icon01.png">
								</div>
								<p>荣誉资质</p> <span>广东名牌产品</span> <span>中国十大风机质量品牌</span>
							</a>
						</div>
					</div>
				</li>
				<li class="color3">
					<div class="li_div">
						<div class="a_link">
							<div class="icon">
								<img src="${pageContext.request.contextPath}/images/icon02.png">
							</div>
							<p>联系我们</p>
							<span>何发海：13973521051<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp18975501192
								<br>石家庄市栾城区楼底镇北留营村
							</span>
						</div>
						<div class="a_link_hide">
							<a>
								<div class="icon">
									<img src="${pageContext.request.contextPath}/images/icon02.png">

								</div>
								<p>联系我们</p> <span>何发海：13973521051<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp18975501192
									<br>石家庄市栾城区楼底镇北留营村
							</span>
							</a>
						</div>
					</div>
				</li>
				<li>
					<div class="picScroll-left">
						<div class="hd">
						</div>
						<div class="bd">
							<div class="tempWrap">
								<div class="tempWrap"
									style="overflow: hidden; position: relative; width: 250px">
									<ul class="picList"
										style="width: 1250px; position: relative; overflow: hidden; padding: 0px; margin: 0px; left: -250px;">
										<c:forEach var="pro" items="${requestScope.pro }">
											<li style="float: left; width: 25%;">
												<div class="pic">
													<a
														href="${pageContext.request.contextPath}/product/single?id=${pro.pro_id}"
														target="_blank"><img
														src="${pageContext.request.contextPath}${pro.pro_image[0] }"></a>
												</div>
												<div class="title">
													<a
														href="${pageContext.request.contextPath}/product/single?id=${pro.pro_id}"
														target="_blank">${pro.pro_name }</a>
												</div>
											</li>
										</c:forEach>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</li>
				<li class="color4">
					<div class="li_div">
						<div class="a_link">
							<p>产品推荐</p>
							<div class="icon">
								<img src="${pageContext.request.contextPath}/images/icon03.png">
							</div>
						</div>
						<div class="a_link_hide">
							<a href="${pageContext.request.contextPath}/product?id=5" />
							<p>产品推荐</p>
							<div class="icon">
								<img src="${pageContext.request.contextPath}/images/icon03.png">
							</div>
							</a>
						</div>
					</div> <em><img
						src="${pageContext.request.contextPath}/images/line_02.png"></em>
				</li>
				<li class="color5">
					<div class="li_div">
						<div class="a_link">
							<p>企业文化</p>
							<div class="icon">
								<img width="85px" height="85px"
									src="${pageContext.request.contextPath}/images/icon04.png">
							</div>
						</div>
						<div class="a_link_hide">
							<a href="${pageContext.request.contextPath}/culture?id=4" />
							<p>企业文化</p>
							<div class="icon">
								<img width="85px" height="85px"
									src="${pageContext.request.contextPath}/images/icon04.png">
							</div>
							</a>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</section>
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
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js" /></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.SuperSlide.js" /></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/zooming.min.js"></script>
<script type="text/javascript">
	var li_id = "${title.title_url}${title.title_id}";
	var url = "${nav.navigation_url}";
	var id = "${nav.navigation_id}";
	var name = "${nav.navigation_name}";
	var ppath = "${pageContext.request.contextPath}";// 项目名路径
</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/other.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/index_animate.js"></script>
</html>

