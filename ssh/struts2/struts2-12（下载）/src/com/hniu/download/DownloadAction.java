package com.hniu.download;

import java.io.FileInputStream;
import java.io.InputStream;

import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport {
	// 准备下载的四个参数
	private InputStream inputStream;// 下载要用的流对象
	private String contentType;// 指定下载类型
	private String contentDisposition;//
	private long contentLength;

	public InputStream getInputStream() {
		return inputStream;
	}

	public String getContentType() {
		return contentType;
	}

	public String getContentDisposition() {
		return contentDisposition;
	}

	public long getContentLength() {
		return contentLength;
	}

	public String execute() throws Exception {
		contentType = "text/html";
		contentDisposition = "attachment;filename=a.html";
		inputStream = new FileInputStream("e:/a.html");
		contentLength = inputStream.available();
		return super.execute();
	}
}
