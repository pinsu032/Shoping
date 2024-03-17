package com.uj.io;

import java.io.File;

public class FileDemo2 {

	public static void main(String[] args) {
		File f = new File("C:\\uj\\UI-Courses");
		String[] list = f.list();
		for(String f1 : list) {
			File file = new File(f,f1);
			if(file.isFile())
				System.out.println("This on is File == "+f1);
			if(file.isDirectory())
				System.out.println("This one is directory == "+f1);
		}
	}
	
}
