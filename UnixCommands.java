//import java.io.Reader;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
import java.io.*;

public class UnixCommands {
	public static int[] wc(Reader in) throws IOException{
		
		//FileReader inputStream = null;
		//FileWriter outputStream  = null;
		BufferedReader br = new BufferedReader(in);
		
		int[] counts = new int[3];
		
		//try {
			
			int c;
			char p = ' '; //previous. 
			//char c;
			while((c = br.read()) != -1) {
				counts[2] += 1;
				if(!Character.isWhitespace(c) && Character.isWhitespace(p)) counts[1] += 1;
				//if(int =)
				//if('\n') counts[2] +=1;
				p = (char) c;
				//System.out.println(c);
				if (p == '\n') counts[0] += 1;
				
			}
			
			
		//} finally {
			//if (br != null) {
				//br.flush();
			//}
			System.out.println("0 " + counts[0] + " 1 " + counts[1] + " 2 " + counts[2]);
			return counts;
		//}
		
	}
	
	public static void main(String[] args) throws IOException{
		
		Reader r = new InputStreamReader(new FileInputStream("README.TXT"), "UTF-8");
		wc(r);
		r.close();
	}
	
}
