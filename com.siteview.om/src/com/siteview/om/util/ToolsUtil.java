package com.siteview.om.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;

import com.siteview.om.Activator;

public class ToolsUtil {
	public static String getRealPath(String fileName) {
		String str = getRoot()+fileName;
		  return str;
	}
	
	public static String getRoot() {
		String path = null;
		try {
			path = FileLocator.toFileURL(
					Platform.getBundle(Activator.PLUGIN_ID).getEntry("")).getPath();
			path = path.substring(path.indexOf("/") + 1, path.length());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}
	
	public static String getReturnStr(String fileName, String parm) {
		String filePath=getRealPath(fileName);
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(new File(filePath));
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
}
