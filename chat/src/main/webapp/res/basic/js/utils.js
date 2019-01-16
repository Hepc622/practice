document.write("<script type='text/javascript' src='../res/basic/js/jquery-1.9.1.min.js'></script>");
var utils = {
		//获取请求参数
		getUrlQueryParams:function(key){
	        var reg = new RegExp("(^|&)" + key + "=([^&]*)(&|$)");
	        var r = window.location.search.substr(1).match(reg);
	        if (r != null)
	            return unescape(r[2]);
	        return "";
		},
		//获取服务器时间
		getTmFromServer:function(){
			return new Date(this.get({async: false}).getResponseHeader("Date"));
		},
		post:function(options){
			options['type']='post';
			return this.ajax(options);
		},
		get:function(options){
			options['type']='get';
			return this.ajax(options);
		},
		ajax:function(options){
			//type,url,headers,data,async,success,fail		
			//判断是否有指定属性
			//判断url是否为空
			if(!options.hasOwnProperty('url')||!options.url){
				options['url']="/";
			}
			if(!('type' in options)){
				options['type']='get';
			}
			if(!('data' in options)){
				options['data']={};
			}
			if(!('async' in options)){
				options['async']=true;
			}
			if(!('success' in options)){
				options['success']=function(){};
			}
			if(!('error' in options)){
				options['error']=function(){};
			}
			if(!('headers' in options)){
				options['headers']={};
			}
			if(!('beforeSend' in options)){
				options['beforeSend']=function(){};
			}
			if(!('jsonpCallback' in options)){
				options['jsonpCallback']=function(){};
			}
			if(!('timeout' in options)){
				options['timeout']=2000;
			}
			return $.ajax({  
					          'type' : options.type,  			//请求方式
					          'url' : options.url,				//请求url
					          'data' : options.data,			//请求数据
					          'dataType':options.dataType,		//预期服务器返回的数据类型
					          'async' : options.async,  		//是否为异步，默认是异步
					          'success' : options.success,		//成功回调
					          'error':options.fail,				//失败回调
					          'headers':options.headers	,		//请求头设置
					          'beforeSend':options.beforeSend,	//请求之前调用函数
					          'timeout':options.timeout,		//请求超时设置
					          'jsonpCallback':options.jsonpCallback,//jsonp回调函数
					   		});  
		}
		
};
//扩展String的方法是否以什么结束
String.prototype.endWith=function(endStr){
    var d=this.length-endStr.length;
    return (d>=0&&this.lastIndexOf(endStr)==d)
}