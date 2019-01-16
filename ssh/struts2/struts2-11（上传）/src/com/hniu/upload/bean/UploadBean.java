package com.hniu.upload.bean;

import java.io.File;

public class UploadBean {
	private File up;
	private String upFileName;
	private String upContentType;

	public File getUp() {
		return up;
	}

	public void setUp(File up) {
		this.up = up;
	}

	public String getUpFileName() {
		return upFileName;
	}

	public void setUpFileName(String upFileName) {
		this.upFileName = upFileName;
	}

	public String getUpContentType() {
		return upContentType;
	}

	public void setUpContentType(String upContentType) {
		this.upContentType = upContentType;
	}

}
