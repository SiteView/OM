package com.siteview.xmpp.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;

public class FileTool {
	public static Properties prop = null;
	public static String getRoot(){
		 String path=null;
		  try {
		    path = FileLocator.toFileURL(Platform.getBundle("com.siteview.xmpp.om").getEntry("")).getPath();
		    path = path.substring(path.indexOf("/") + 1, path.length());
		  } catch (Exception e) {
		    e.printStackTrace();
		  }
		  return "/"+path;
	}
	public static String getReturnStr(String filePath, String parm) {
		try {
			FileInputStream fis = new FileInputStream(new File(filePath));
			prop = new Properties();
			prop.load(fis);
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty(parm);
	}
	
	public static void setlogfile(String filename,String s){
		String filepath=FileTool.getRoot();
		File file=new File(filepath+filename);
		if(!file.exists()||!file.isFile()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		FileWriter writer=null;
		 BufferedWriter bwriter=null;
		try {
			writer=new FileWriter(file,true);
			bwriter = new BufferedWriter(writer);
			 bwriter.write(s);
			 bwriter.newLine();
			 bwriter.flush();
			 bwriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
