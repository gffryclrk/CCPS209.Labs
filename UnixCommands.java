//import java.io.Reader;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
import java.io.*;
import java.util.*;

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

		Reader r = new InputStreamReader(new FileInputStream("lorem.txt"), "UTF-8");
		UnixCommands unix = new UnixCommands();
		unix.tail(r, new OutputStreamWriter(System.out), 5);
	}
	
	public void tail(Reader in, Writer out, int lines) throws IOException{
		LinkedList lb = new LinkedList<String>(); // Line buffer lb
		BufferedReader br = new BufferedReader(in);
		PrintWriter pw = new PrintWriter(out);
		String line;
		while((line = br.readLine()) != null){
			// if(line.length() == 0) { continue ;} // This is from Illka's SomeUnixCommands.java ln:38. Not sure purpose...
			lb.add(line);
			if(lb.size() > lines) lb.remove(); // Only need to store as many lines as required by lines paramater...
		}
		
		ListIterator<String> listIterator = lb.listIterator();
		while(listIterator.hasNext()){
			line = listIterator.next();
			pw.println(line);
			// System.out.println(line);
			// pw.println(listIterator.next());
		}
		pw.flush();

	}
}
