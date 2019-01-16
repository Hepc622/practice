package com.hniu.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.log4j.chainsaw.Main;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport {
	private List<File> up;
	private List<String> upFileName;
	private List<String> upContentType;

	public List<File> getUp() {
		return up;
	}

	public void setUp(List<File> up) {
		this.up = up;
	}

	public List<String> getUpFileName() {
		return upFileName;
	}

	public void setUpFileName(List<String> upFileName) {
		this.upFileName = upFileName;
	}

	public List<String> getUpContentType() {
		return upContentType;
	}

	public void setUpContentType(List<String> upContentType) {
		this.upContentType = upContentType;
	}

	public String execute() throws Exception {
		if(up!=null)
		for (int x = 0; x < up.size(); x++) {
			FileOutputStream outputStream = new FileOutputStream("E:/"
					+ upFileName.get(x));
			FileInputStream inputStream = new FileInputStream(up.get(x));
			byte[] buffer = new byte[1024 * 4];
			int len = 0;
			while ((len = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, len);
			}
			outputStream.close();
			inputStream.close();
		}
		return super.execute();
	}
	public static void main(String[] args) {
		System.out.println('0');
	}
}
