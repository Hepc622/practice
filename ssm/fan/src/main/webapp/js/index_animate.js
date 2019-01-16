// 导航栏选中效果
$(function() {
	var paths = location.href;
	if (paths.indexOf("index") != -1)
		$("#index").addClass("onnav");
	else if (paths.indexOf("about") != -1)
		$("#about").addClass("onnav");
	else if (paths.indexOf("news") != -1)
		$("#news").addClass("onnav");
	else if (paths.indexOf("culture") != -1)
		$("#culture").addClass("onnav");
	else if (paths.indexOf("product") != -1)
		$("#product").addClass("onnav");
	else if (paths.indexOf("service") != -1)
		$("#service").addClass("onnav");
	else if (paths.indexOf("project") != -1)
		$("#project").addClass("onnav");
	else
		$("#index").addClass("onnav");
});
// 模块滑动效果
jQuery(".IndexCon li").bind("mouseover", function() {
	$(this).find(".a_link").stop().animate({
		"margin-left" : "-1000px"
	}, 500);
	$(this).find(".a_link_hide").stop().animate({
		"margin-top" : "-250px"
	}, 500);
});
jQuery(".IndexCon li").bind("mouseleave", function() {
	$(this).find(".a_link").stop().animate({
		"margin-left" : "+20px"
	}, 500);
	$(this).find(".a_link_hide").stop().animate({
		"margin-top" : "+250px"
	}, 500);
});
// 产品滑动
jQuery(".picScroll-left").slide({
	titCell : ".hd ul",
	mainCell : ".bd ul",
	autoPage : true,
	effect : "left",
	autoPlay : true
});
// 关于我们效果
$(function() {
	$(".apic").bind("mouseover", function() {
		if (this.title == 1) {
			$("#changepic")[0].src = ppath+"/images/20150528135101511.jpg";
		} else if (this.title == 2) {
			$("#changepic")[0].src = ppath+"/images/201505281418251825.jpg";
		} else {
			$("#changepic")[0].src = ppath+"/images/20150528141800180.jpg";
		}
	});
});
