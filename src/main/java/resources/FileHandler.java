package resources;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
	public static BufferedWriter BW;
	
	
	public static void writefile() throws IOException
	{
	  String TestFile = "./outputfile/temp.txt";
	  FileWriter FW = new FileWriter(TestFile);
	  BW = new BufferedWriter(FW);
	
	}
	
	public static BufferedWriter getBW() {
		return BW;
	}

	public static void setBW(BufferedWriter bW) {
		BW = bW;
	}


	
	
}
