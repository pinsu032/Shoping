package com.uj.io;

import java.io.File;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) throws IOException {
		File file = new File("uj/f1.docs");
		boolean createNewFile = file.createNewFile();
		if(createNewFile)
			System.out.println("File created...");
		else
			System.out.println("file not created");
		
		File dir = new File("uj");
		boolean mkdir = dir.mkdir();
		System.out.println(mkdir);
		
		File f = new File(dir,"test.txt");
		boolean createNewFile2 = f.createNewFile();
		System.out.println(createNewFile2);
	}
}
