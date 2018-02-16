//import java.io.Reader;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
import java.io.*;

public class UnixCommands {
	public int[] wc(Reader in) throws IOException{
		
		BufferedReader br = new BufferedReader(in);
		int[] counts = new int[3];
		
			
			int c;
			char p = ' '; //previous. 
			while((c = br.read()) != -1) {
				counts[2] += 1;
				if(!Character.isWhitespace(c) && Character.isWhitespace(p)) counts[1] += 1;
				p = (char) c;
				if (p == '\n') counts[0] += 1;
				
			}
			
			// System.out.println("0 " + counts[0] + " 1 " + counts[1] + " 2 " + counts[2]);
			return counts;
		
	}
	
	public static void main(String[] args) throws IOException{
		
		// Reader r = new InputStreamReader(new FileInputStream("README.TXT"), "UTF-8");
		// wc(r);
		// r.clos8Ge();
	}
	
	public void tail(Reader in, Writer out, int lines) throws IOException{
		
	}
}
