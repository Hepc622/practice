package com.practice.chat.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.practice.chat.bean.Message;
import com.practice.chat.bean.OnlineUser;
import org.springframework.stereotype.Component;

/**
 * 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端,
 * 注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端
 */
@ServerEndpoint("/websocket/{userId}/{groupId}")
public class ChatController {
	private static final Logger LOG = LoggerFactory.getLogger(ChatController.class);  
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    //concurrent包的线程安全Map，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    private static Map<String,OnlineUser> onLineUser = new ConcurrentHashMap<String,OnlineUser>();

	/**
     * 连接建立成功调用的方法
     * @param session  可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(@PathParam("userId") String userId,
    				   @PathParam("group")String group,
    				   Session session){
    	//创建onlineuser
    	OnlineUser online = createOnlineUser(userId, group, session);
        //将对象保存在set中
    	onLineUser.put(userId,online);
        //在线数加1
        addOnlineCount();
        System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());
    }
	/**创建onlineUser
	 * @param userId 用户id
	 * @param group 用户所拥有的群组id
	 * @param session 当前的wsSession
	 * @return 
	 */
	private OnlineUser createOnlineUser(String userId, String group, Session session) {
		OnlineUser online = new OnlineUser();
    	//设置链接用户的userid
    	online.setUserId(userId);
        //保存session
    	online.setSession(session);
    	if(group!=null&&!"".equals(group)) {
	    	JSONObject json = JSONObject.parseObject(group);
	    	//将该用户的所有的群id设置进去
	    	online.setGroup(json);
    	}
		return online;
	}
    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(@PathParam("userId")String userId){
    	onLineUser.remove(userId);  //从Map中删除
        subOnlineCount();           //在线数减1
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     * @param message 客户端发送过来的消息
     * @param session 可选的参数
     * @throws IOException 
     */
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
    	Message msg = JSONObject.parseObject(message,Message.class);
    	//msg不能等于空
    	if(msg!=null) {
    		//判断是发给个人还是群组
        	String sendType = msg.getSendType();
        	if("1".equals(sendType)) {//单聊
        		String receiverId = msg.getReceiverId();
        		//拿出接收者对应的userid的OnlineUser对象
        		OnlineUser user = onLineUser.get(receiverId);
        		//判断是否在线，如果没有在线就讲把信息作为离线消息给保存起来
        		if(user!=null) {//将消息发送给接受者
        			//设置接收时间
        			msg.setReceiverTm(new Date());
        			sendMessage(user, msg.toString());
        			LOG.info("信息发送成功：from"+msg.getSenderName()+" to "+msg.getReceiverName());
        		}else {//不在线，将离线消息保存起来
        			//TODO 保存消息 
        			LOG.info("接收者暂时没有上线,保存为未读消息！");
        		}
        		
        	}else if("2".equals(sendType)) {//群聊
        		//获取发送者的onlineuser对象
        		String renserId = msg.getSenderId();
        		OnlineUser user = onLineUser.get(renserId);
        		if(user!=null) {
        			//获取group中的人员
            		String receiverId = msg.getReceiverId();
            		//获取发送者所有的群
            		JSONObject group = user.getGroup();
            		//获取发送的要发送的目标群
            		JSONArray array = group.getJSONArray(receiverId);
            		//发送给群里的每一成员
            		for (Object object : array) {
            			//获取接收者的id
						String recevier = object.toString();
						//判断该接收者是否在线
						OnlineUser user2 = onLineUser.get(recevier);
						if(user2!=null) {
							sendMessage(user2, message.toString());
						}else {
							//TODO 保存消息 
		        			LOG.info("接收者暂时没有上线,保存为未读消息！");
						}
						
					}
            		LOG.info("信息发送成功：from"+msg.getSenderName()+" to "+msg.getReceiverName());
        		}else {
        			LOG.error("客户端断开了链接，获取不到发送者的群中的群员！");
        		}
        	}
    	}
    }

    /**
     * 发生错误时调用
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error){
    	LOG.error("error.................");
        error.printStackTrace();
    }

    /**
     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
     * @param message
     * @throws IOException
     */
    public void sendMessage(OnlineUser user,String message) throws IOException{
    	user.getSession().getBasicRemote().sendText(message);
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
    	ChatController.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
    	ChatController.onlineCount--;
    }
}