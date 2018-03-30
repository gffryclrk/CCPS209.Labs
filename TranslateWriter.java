import java.io.*;
import java.util.*;

public class TranslateWriter extends Writer {
	private Writer w;
	private Map<Character, String> tm = new TreeMap<>();
	
	public TranslateWriter(Writer w) {
		this.w = w;
	}
	public void addRule(char c, String s) {
		tm.put(c, s);
	}
	@Override
	public void close() throws IOException{
		w.close();
	}
	@Override
	public void flush() throws IOException{
		w.flush();
	}
	@Override
	public void write(char[] a, int off, int len) throws IOException{
		for(int i = off; i<(off+len);i+=1) {
			if(tm.containsKey(a[i])) {
				w.write(tm.get(a[i]));
			}else {
				w.write(a[i]);
			}
		}
	}
}
