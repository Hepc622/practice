package com.practice.chat.bean;

import java.util.Date;

//聊天信息内容对象
public class Message {
	private String msgId;
	private String senderId;//发送者id
	private String senderName;//发送者名字
	private String sendHeader;//发送者头像
	private Date sendTm;//发送时间
	private String receiverId;//接收者id
	private String receiverName;//接收者名字
	private String receiverHeader;//接收者头像
	private Date receiverTm; //接收时间
	private String msgType;//发送类型 1文本 2图片 3文件 4语音 5视频
	private String content;//发送数据
	private String sendType;//发送类别给单个好友还是群友 1 单个 2群聊
	//是否已读
	private String read;//是否已读
	
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	public String getSendType() {
		return sendType;
	}
	public void setSendType(String sendType) {
		this.sendType = sendType;
	}
	public String getRead() {
		return read;
	}
	public void setRead(String read) {
		this.read = read;
	}
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getSendHeader() {
		return sendHeader;
	}
	public void setSendHeader(String sendHeader) {
		this.sendHeader = sendHeader;
	}
	public Date getSendTm() {
		return sendTm;
	}
	public void setSendTm(Date sendTm) {
		this.sendTm = sendTm;
	}
	public String getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getReceiverHeader() {
		return receiverHeader;
	}
	public void setReceiverHeader(String receiverHeader) {
		this.receiverHeader = receiverHeader;
	}
	public Date getReceiverTm() {
		return receiverTm;
	}
	public void setReceiverTm(Date receiverTm) {
		this.receiverTm = receiverTm;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "{'msgId':" + msgId + ",'senderId':" + senderId + ",'senderName':" + senderName + ",'sendHeader':"
				+ sendHeader + ",'sendTm':" + sendTm + ",'receiverId':" + receiverId + ",'receiverName':" + receiverName
				+ ",'receiverHeader':" + receiverHeader + ",'receiverTm':" + receiverTm + ",'msgType':" + msgType
				+ ",'content':" + content + ",'sendType':" + sendType + ",'read':" + read + "}";
	}
}
