package com.wang.config;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class FilePaths {

	private String[] filePath;
	private String fileDirectory;
	private String currentFile="E:\\java-workspace\\SpringBatch\\src\\main\\resources\\out\\out.csv";

	public String getCurrentFile() {
		return currentFile;
	}

	public void setCurrentFile(String currentFile) {
		this.currentFile = currentFile;
	}

	public String getFileDirectory() {
		return fileDirectory;
	}

	public void setFileDirectory(String fileDirectory) {
		this.fileDirectory = fileDirectory;
	}

	public String[] getFilePath() {
		return filePath;
	}

	public void setFilePath(String[] filePath) {
		this.filePath = filePath;
	}

}
