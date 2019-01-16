<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon" /> 
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/whir.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/addlay.css" />
<title>河北九洲普惠风机销售分公司</title>
</head>
<body>
	<c:set var="nav" value="${sessionScope.nav }" />
	<c:set var="title" value="${requestScope.title}" />
	<c:set var="page" value="${requestScope.page}" />
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
			<div class="le">P</div>
			<div class="ri">
				<span class="cn">${nav.navigation_name }</span><span class="en">roject</span>
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
					<div class="ProductList" id="${title.title_id }">
						<c:if test="${not empty sessionScope.user }">
							<ul>
								<li><a class="theme-login" href="javascript:;"> <img
										id="addhonor"
										src="${pageContext.request.contextPath}/images/add_normal_new.png">
										<font>添加${title.title_name }</font>
								</a></li>
							</ul>
						</c:if>
						<c:forEach var="pro" items="${requestScope.pros }">
							<ul>
								<li id="${pro.pro_id }" class="clickEvent"
									name="${sessionScope.user.user_id }"><a title='右击删除'
									class="intosingle"
									href="${pageContext.request.contextPath}/${nav.navigation_url }/single?id=${pro.pro_id }">
										<img src="${pageContext.request.contextPath}${pro.pro_image[0]}"> <font><b>产品名称：</b>${pro.pro_name}</font>
										<font><b>商品规格：</b>${pro.pro_specification}</font>
								</a></li>
							</ul>
						</c:forEach>

					</div>
					<div class="Pages">
						<span class="p_page"> <c:if test="${page.hasPrePage }">
								<a
									href="${pageContext.request.contextPath}/${nav.navigation_url }/${title.title_id }?page=${page.currentPage-1}&id=${title.title_id}"
									class="a_prev"></a>
							</c:if> <c:if test="${!page.hasPrePage }">
								<a href="javascript:void(0);" class="a_prev"></a>
							</c:if> <em class="num"> <c:forEach var="i"
									begin="${page.startPage }" end="${page.endPage}">
									<c:if test="${page.currentPage ==i}">
										<a
											href="${pageContext.request.contextPath}/${nav.navigation_url }/${title.title_id }?page=${i }&id=${title.title_id}"
											class="a_cur" id="pageNum${i }">${i }</a>
									</c:if>
									<c:if test="${page.currentPage !=i}">
										<a
											href="${pageContext.request.contextPath}/${nav.navigation_url }/${title.title_id }?page=${i }&id=${title.title_id}"
											class="a_num" id="pageNum${i }">${i }</a>
									</c:if>
								</c:forEach>
						</em> <c:if test="${!page.hasNextPage }">
								<a href="javascript:void(0);" class="a_next"></a>
							</c:if> <c:if test="${page.hasNextPage }">
								<a
									href="${pageContext.request.contextPath}/${nav.navigation_url }/${title.title_id }?page=${page.currentPage+1}&id=${title.title_id}"
									class="a_next"></a>
							</c:if>
						</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section></section>
	<div class="clear"></div>
	<!-- 添加商品页面 -->
	<div class="theme-popover-add-product">
		<div class="theme-poptit">
			<a href="javascript:;" title="关闭" class="close">×</a>
			<h3>添加${title.title_name }</h3>
		</div>
		<div class="theme-popbod dform">
			<form class="theme-signin-product" name="loginform"
				action="${pageContext.request.contextPath}/upload/product?id=${title.title_id }"
				method="post">
				<img class="show-img-product" id="showImg" src="">
				<table>
					<tr>
						<td><strong>产品图片：</strong><input class="ipt" type="file"
							name="p_image" size="20" /><br> <strong>产品图片：</strong><input
							class="ipt" type="file" name="p_image" size="20" /><br> <strong>产品图片：</strong><input
							class="ipt" type="file" name="p_image" size="20" /><br> <strong>产品图片：</strong><input
							class="ipt" type="file" name="p_image" size="20" /><br></td>
						<td><strong>商品名称：</strong><input class="ipt" type="text"
							name="p_name" size="20" /><br> <strong>产品规格：</strong><input
							class="ipt" type="text" name="p_specification" size="20" /><br>
							<strong>所属类别：</strong><input class="ipt" type="text"
							name="p_type" size="20" value="${title.title_name }" /><br>
							<input name="p_parameter" type="text" style="display: none;" /><br></td>
					</tr>
				</table>
				<br> <br> <br> <br>技术参数区：
				<div class="ContextEdite" contentEditable="true" name="ctext"></div>
				<input class="btn btn-primary" type="button" onclick="addProduct();"
					name="submit" value=" 上 传 " />
			</form>
		</div>
	</div>
	<div class="theme-popover-mask"></div>
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
	// 上传时显示图片
	$("input[name='file'],input[name='p_image']").change(function(even) {
		var reader = new FileReader();// 创建文件
		reader.onloadend = (function(e) {
			// 显示图片
			$("#showImg").attr("src", e.target.result);
		});
		var file = $("input[name='file']")[0];// 获取文件
		// Read the file
		reader.readAsDataURL(even.target.files[0]);
	});
	// 删除荣誉证书
	$(".clickEvent").mousedown(function(e) {
		if (e.button == 2) {// 如果值为2的时候说明是右击，开始删除
			var u = $(".clickEvent").attr("name");
			if (u != null && u != "") {
				var deleteUrl = ppath+"/product/delete?id=" + this.id+"&imgUrl="+encodeURIComponent($(".clickEvent a img").attr("src"));
				$.get(deleteUrl, function(data) {
					if (data == 1) {
						location.reload();
					} else {
						alert("系统正忙，请稍后再试!");
					}
				});
			}
		} else if (e.button == 0) {
			var aelemnt = $(".clickEvent a");
			if (aelemnt.attr("class") == "intosingle") {
				window.location.href = aelemnt.attr("href");
			}
		}

	});
	// 图片放大
	$('.CaseEngineer').bind('click', function(event) {
		event.preventDefault();
		// 判断如果是添加那个的话就不不进行缩放
		if (event.target.currentSrc.indexOf("add_normal_new.png") == -1) {
			zoom.to({
				element : event.target
			});
		}
	});
	// 弹出层添加点击事件
	$('.theme-login').click(function() {
		// 添加荣誉编辑框
		$('.theme-popover-mask').fadeIn(100);
		$('.theme-popover-add-honor').slideDown(200);
		// 添加新闻编辑框
		$('.theme-popover-add-news').slideDown(200);
		// 添加商品编辑框
		$('.theme-popover-add-product').slideDown(200);
		// 添加项目编辑框
		$('.theme-popover-add-project').slideDown(200);
	});
	$('.theme-poptit .close').click(function() {
		// 添加荣誉编辑框
		$('.theme-popover-mask').fadeOut(100);
		$('.theme-popover-add-honor').slideUp(200);
		// 添加新闻编辑框
		$('.theme-popover-add-news').slideUp(200);
		// 添加商品编辑框
		$('.theme-popover-add-product').slideUp(200);
		// 添加项目编辑框
		$('.theme-popover-add-project').slideUp(200);
	});
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/other.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/index_animate.js"></script>
</html>

