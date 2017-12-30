package com.igate.demos;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharacters {

	public static void main(String[] args) {
       
        try(FileReader inputStream = new FileReader("sampleinput.txt");
        	FileWriter outputStream = new FileWriter("sampleoutput.txt");) {
              int c;
              while ((c = inputStream.read()) != -1) {
                    outputStream.write(c);
              }
         }catch(IOException ex) {
        	 System.out.println(ex.getMessage());
         }
	}
}
