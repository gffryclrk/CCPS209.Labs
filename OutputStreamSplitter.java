
import java.io.*;
import java.util.*;

public class OutputStreamSplitter extends OutputStream {
	private List<OutputStream> streams;

	public OutputStreamSplitter(List<OutputStream> los){
		// super(los);
		this.streams = los;	
	}
	public OutputStreamSplitter() {
		this(new ArrayList<OutputStream>());
	}

	public OutputStreamSplitter addStream(OutputStream os){
		streams.add(os);
		return this;
	}
	public void close() throws IOException{
//		Iterator<OutputStream> lit = streams.iterator();
//		while(lit.hasNext()){
//			lit.next().close();
//		}
//		for(OutputStream e : streams) {
//			e.close();
//		}
		streams.forEach(x -> {
			try {
				x.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

//		}catch(IOException e) {}
		
		
	}
	public void write(int b) throws IOException{
//		Iterator<OutputStream> lit = streams.iterator();
//		while(lit.hasNext()) {
//			lit.next().write(b);
//		}
		for(OutputStream e : streams) {
			e.write(b);
		}
	}
	public void write(byte[] b) throws IOException{
//		Iterator<OutputStream> lit = streams.iterator();
//		while(lit.hasNext()) {
//			lit.next().write(b);
//		}
		for(OutputStream e : streams) {
			e.write(b);
		}
	}
	public void write(byte[] b, int off, int len) throws IOException{
//		Iterator<OutputStream> lit = streams.iterator();
//		while(lit.hasNext()) {
//			lit.next().write(b, off, len);
//		}
		for(OutputStream e : streams) {
			e.write(b);
		}
	}
}
