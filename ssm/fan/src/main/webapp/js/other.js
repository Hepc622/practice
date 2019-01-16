// 网站文字不能复制代码
document.oncontextmenu = new Function("event.returnValue=false");
// document.onselectstart = new Function("event.returnValue=false");
// 杀死错误
function killerrors() {
	return true;
}
window.onerror = killerrors;
// 其他
function clickIE4() {
	if (event.button == 2) {
		return false;
	}
}
function clickNS4(e) {
	if (document.layers || document.getElementById && !document.all) {
		if (e.which == 2 || e.which == 3) {
			return false;
		}
	}
}
function OnDeny() {
	if (event.ctrlKey || event.keyCode == 78 && event.ctrlKey || event.altKey
			|| event.altKey && event.keyCode == 115) {
		return false;
	}
}
if (document.layers) {
	document.captureEvents(Event.MOUSEDOWN);
	document.onmousedown = clickNS4;
	document.onkeydown = OnDeny();
} else if (document.all && !document.getElementById) {
	document.onmousedown = clickIE4;
	document.onkeydown = OnDeny();
}
document.oncontextmenu = new Function("return false");
// 子标题栏被选中的效果
$("#" + li_id).addClass("onmenu"); // 选定
$(".MenuList li").hover( // 鼠标移上去效果
function() {
	$(this).siblings("li").removeClass("onmenu");
	$(this).addClass("onmenu");
}, function() { // 鼠标移走效果
	$(this).removeClass("onmenu");
	$("#" + li_id).addClass("onmenu");
});
// 给div 绑定paste事件，当粘贴时候出发事件。
$(".Singlepage").bind("paste", function(event) {
	editPaste(event);
});
$(".ContextEdite").bind("paste", function(event) {
	editPaste(event);
});
// 粘贴事件处理
function editPaste(event) {
	// 获取错误信息
	var em = $("#error_message");
	// event.clipboardData获取控制板数据
	// event.originalEvent.clipboardData获取事件源的控制板数据
	// 从控制板中拿出所有的数据
	var items = (event.clipboardData || event.originalEvent.clipboardData).items
	// 遍历整个数据集合
	for (index in items) {
		var item = items[index];// 获取每一个下表为index的对象数据
		var type = item.type;// 获取出该数据类型
		var data = type.split('/');// 已/斜杠切割字符
		if (type && data[0] == 'image') {// 如果类型为image就进行上传
			var suffix = data[1];
			var blob = item.getAsFile();// 获取它的文件
			var size = blob.size;// 获取文件的大小
			var reader = new FileReader();// 创建文件
			reader.onload = function(e) {// 读取完后出发
				var form = new FormData();
				form.append("file", blob, "img." + suffix);
				var xhr = new XMLHttpRequest();
				xhr.open("POST", ppath + "/upload/fileUpload", true);
				xhr.setRequestHeader('X-Requested-With', 'XMLHttpRequest',
						'Content-Type', 'multipart/form-data');
				xhr.send(form);
				xhr.onreadystatechange = function() {
					if (xhr.readyState == 4 && xhr.status == 200) { // 上传成功时，触发
						$(".ContextEdite").append(
								'<img src="' + xhr.responseText + '"/>');
						$(".Singlepage").append(
								'<img src="' + xhr.responseText + '"/>');
					}
				}
			}
			reader.onerror = function(e) {
				alert("上传错误");
			}
			reader.onabort = function(e) {
				alert("上传中断");
			}
			reader.readAsDataURL(blob);
			// 将文件转化成dataurl（可以插入懂啊文档的一种方案）
		}
	}
}
// 发布信息
var oldContexts = $(".Singlepage").html().trim();
function release() {
	var newContexts = $(".Singlepage").html().trim();
	if (newContexts != null && newContexts != oldContexts) {
		var f = $("#releaseform");
		// 将编辑框的设置到input中去
		$("input[name='contexts']").val(newContexts);
		var options = {
			url : f.attr("action"),
			type : 'post',
			success : function(data) {
				if (data == 1) {
					alert("发布成功！");
					// 将数据进行更换成老数据
					oldContexts = newContexts;
				} else {
					alert("添加失败!");
				}
			}
		};
		f.ajaxSubmit(options);// submit
	} else {
		alert("您的内容为空或没有做任何改动！");
	}
}

// 提交form表单
function addContext() {
	var filePath = $("input[name='file']").val();// 获取文件
	var type = filePath.substring(filePath.lastIndexOf(".") + 1);// 截取出文件格式
	// 判断格式是否合法
	if (type.toLowerCase() != "png" && type.toLowerCase() != 'jpg'
			&& type.toLowerCase() != 'jpeg' && type.toLowerCase() != 'gif'
			&& type.toLowerCase() != 'bmp') {
		alert("格式错误，请上传'png、jpg、jpeg、bmp、gif'格式文件");
		return;
	}
	// 验证标题不能为空
	var title = $("input[name='title']").val();
	if (title == "" || title == null) {
		alert("标题不能为空！");
		return;
	}
	// 将编辑框的设置到input中去
	$("input[name='ctext']").val($(".ContextEdite").html());
	// 使用form.js上传文件
	var f = $(".theme-signin");
	var options = {
		url : f.attr("action"),
		type : 'post',
		success : function(data) {
			if (data == 1) {
				var result = confirm("添加成功!是否继续？");
				if (result) {
				} else {
					location.reload();
				}
			} else {
				alert("添加失败!");
			}
		}
	};
	f.ajaxSubmit(options);// submit
}
// 添加商品
function addProduct() {
	var filePath = $("input[name='p_image']");// 获取文件
	for (var index = 0; index < filePath.length; index++) {
		var fimg = filePath[index].value;
		var type = fimg.substring(fimg.lastIndexOf(".") + 1);// 截取出文件格式
		// 判断格式是否合法
		if (type != null && type != "") {
			if (type.toLowerCase() != "png" && type.toLowerCase() != 'jpg'
					&& type.toLowerCase() != 'jpeg'
					&& type.toLowerCase() != 'gif'
					&& type.toLowerCase() != 'bmp') {
				alert("格式错误，请上传'png、jpg、jpeg、bmp、gif'格式文件");
				return;
			}
		}
	}
	// 验证标题不能为空
	var title = $("input[name='p_name']").val();
	if (title == "" || title == null) {
		alert("名称不能为空！");
		return;
	}
	// 将编辑框的设置到input中去

	$("input[name='p_parameter']").val($(".ContextEdite").html());
	// 使用form.js上传文件
	var f = $(".theme-signin-product");
	var options = {
		url : f.attr("action"),
		type : 'post',
		success : function(data) {
			if (data == 1) {
				var result = confirm("添加成功!是否继续？");
				if (result) {
				} else {
					location.reload();
				}
			} else {
				alert("添加失败!");
			}
		}
	};
	f.ajaxSubmit(options);// submit
}
