var chat = {
	//发送的信息体
	message:{
		senderId:null,//发送者id
		senderName:null,//发送者名字
		senderHeader:null,//发送者头像
		sendTm:null,//发送时间
		receiverId:null,//接收者id
		receiverName:null,//接收者名字
		receiverHeader:null,//接收者头像
		receiverTm:null,//接收时间
		type:null,//发送类型 1文本 2图片 3文件 4语音 5视频
		content:null//发送数据
	},
	
	//webSocket对象
	ws:null,
	
	//初始化聊天js
	init:function(uid){
		this.ws = new WebSocket('ws://localhost:8080/websocket/'+uid);
		return this.getState();
	},
	
	//获取当前的链接状态
	getState:function(){
		var state = "";
		switch (this.ws.readyState) {
		  case WebSocket.CONNECTING:
		    state="正在连接...";
		    break;
		  case WebSocket.OPEN:
			state="连接成功";
		    break;
		  case WebSocket.CLOSING:
			state="正在关闭连接...";
		    break;
		  case WebSocket.CLOSED:
			state="关闭成功";
		    break;
		  default:
		    // this never happens
		    break;
		}
		return state;
	},
	/**********************************************发送信息***************************************************/
	//发送普通文本
	sendText:function(){
		this.sendMsg(1);
	},
	
	//发送图片
	sendImg:function(){
		
	},
	
	//发送文件
	sendFile:function(){
		
	},
	
	//发送语音
	sendAudio:function(){
		
	},
	
	//发送视频
	sendVideo:function(){
		
	},
	
	//发送消息
	sendMsg:function(type,content){
		var message = null;
		if(type == 1){
			message = content;
		}else if(type == 2){
			
		}else if(type == 3){
			
		}else if(type == 4){
			
		}else if(type == 5){
			
		}
		//发送到服务器
		this.ws.send(message);
		
		if (this.ws.bufferedAmount === 0) {
			// 发送完毕
		} else {
			// 发送还没结束
		}	
	},
	/**********************************************监听事件***************************************************/
	//添加链接成功的回调函数
	addOpenListener:function(fn){
		this.addListener("open",fn);
	},
	
	//添加关闭回调函数
	addCloseListener:function(fn){
		this.addListener("close",fn);
	},
	
	//添加当接收到信息时的回调函数
	addMsgListener:function(fn){
		this.addListener("message",fn);
	},
	
	//添加发送错误回调函数
	addErroListener:function(fn){
		this.addListener("error",fn);
	},
	
	//添加监听方法
	addListener:function(type,fn){
		if(fn instanceof Function){//是否为方法
			this.ws.addEventListener(type,fn);
		}else if(fn instanceof Array){//是否为数组
			for(f in fn){
				if(f instanceof Function){//是否为方法
					this.ws.addEventListener(type,f);
				}
			}
		}else{
			throw Exception("must be a function or a array of function!");
		}
	}
};


