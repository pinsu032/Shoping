package com.uj.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IO_Stream_Demo {

	public static void main(String[] args) throws IOException  {
		// program to write data to the file....
		
			FileWriter fw = new FileWriter("uj/test.txt");
			fw.write("Hi ! Good Morning");
			fw.write("\n"); // to move onto next line
			fw.write("Please wake up at 8 AM in the morning....");
			fw.flush();
			fw.close();
		
			//read the content from file..
			FileReader fr = new FileReader("uj/test.txt");
			int read = fr.read();
			
			while(read != -1) {
				System.out.print((char)read);
				read = fr.read();
			}
			
			fr.close();
	}

}
