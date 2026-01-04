package com.shaffan.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public final class FileUtil {

	private FileUtil() {
		// TODO Auto-generated constructor stub
	}
	
	private static void copy(File source, File destination) throws IOException {
		if(!source.exists()) {
			throw new IOException("Source file does not exists: " + source.getAbsolutePath());
		}
		
		File parentDir = destination.getParentFile();
		if(parentDir != null && !parentDir.exists()) {
			parentDir.mkdirs();
		}
		
		Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
	}
	
	public static void copyFile(File source, File destination) throws IOException {
		copy(source, destination);
	}
	
	public static File copyFileWithTimeStamp(File source, File destination) throws IOException {
		File timeStampedFile = getTimeStampedFile(destination);
		copy(source, timeStampedFile);
		return timeStampedFile;
	}
	
	public static File copyScreenshot(File src, String name) throws IOException {
		File destination = new File(System.getProperty("user.dir") + "/reports/screenshots/" + name + ".png");
		return copyFileWithTimeStamp(src, destination);
	}
	
	public static File getTimeStampedFile(File originalFile) {
		
		String name = originalFile.getName();
		String parent = originalFile.getParent();
		
		System.out.println("File name: " + name + "\n Parent Dir: " + parent);
		
		int dotIndex = name.lastIndexOf(".");
		System.out.println("Dot Index: " + dotIndex);
		
		String baseName = (dotIndex == -1) ? name : name.substring(0, dotIndex);
		String extension = (dotIndex == -1) ? "" : name.substring(dotIndex);
		
		System.out.println("Base name: " + baseName + "\n Extension: " + extension);
		
		String timeStampedName = baseName + "_" + TimeUtil.now() + extension;
		
		System.out.println("Timestamped Name: " + timeStampedName);
		
		File timeStampedFile = new File(parent, timeStampedName);
		System.out.println("Timestamped File Name: " + timeStampedFile.getName());
		
		return timeStampedFile;
		
	}
	
	
}
