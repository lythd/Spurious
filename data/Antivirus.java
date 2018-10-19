package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import virus.Virus;
import virus.VirusStatus;

public class Antivirus {
	
	static String temp = "";
	
	public static void listFilesFromDir(String dir) {
		File folder = new File(dir);
	    listFilesForFolder(folder);
	}
	
	public static void listFilesForFolder(File folder) {
		File [] files = folder.listFiles();
		File file = null;
		int count;
		for (int i = 0; i < files.length; i++) {
		    count = 0;
		    for (File f : files) {
		    	if (count == i) file = f;
		    	count++;
		    }
		    if (file.isDirectory()) {
		    	listFilesForFolder(file);
		    } else {
		    	if (file.isFile()) {
			    	temp = file.getName();
			    	if (temp.contains(".bat") && !temp.contains(".lnk")) {
			    		if (TFBoot.getGo()) batFileSummary(file);
				    	else i--;
			    	}
		    	}
		    }
		}
	}
	
	public static void batFileSummary(File file) {
		String fileData = readFile(file).toLowerCase();
		VirusStatus stat = new VirusStatus();
		if (fileData.contains("shutdown.exe")) {
			stat.shutdownI();
		} else if (fileData.contains("shutdown")) {
			stat.shutdownII();
		} if (fileData.contains("%appdata%\\microsoft\\windows\\start menu\\programs\\startup") || 
				fileData.contains("%appdata%\\microsoft\\windows\\start menu\\programs\\start-up")) {
			stat.startupI();
		} else if (fileData.contains("startup") || fileData.contains("start-up")) {
			stat.startupII();
		} else if (fileData.contains("xcopy")) {
			stat.wormI();
		} else if (fileData.contains("copy")) {
			stat.wormII();
		}
		TFBoot.bat(new Virus(file, stat));
	}
	
	public static String readFile (File file) {
		String string = "";
		String line = null;
		try {
			BufferedReader br;
			br = new BufferedReader(new FileReader(file));
			while((line = br.readLine())!= null) string += line + "\n";
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return string;
	}
}
