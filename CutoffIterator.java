import java.util.*;

public class CutoffIterator<E> implements Iterator<E>{
	private Iterator<E> it;
	private E value = null;
	private int limit;
	private int count = 0;

	public CutoffIterator(Iterator<E> it, int limit){
		this.it = it;
		this.limit = limit;
	}

	@Override
	public boolean hasNext(){
		if(count < limit){
			return it.hasNext(); 
		}else{
		    return false;
		}
	}

	@Override
	public E next(){
		if(it.hasNext()){
			count += 1;
			value = it.next();
			return value;
		}else{
		    return (E) new Boolean("false");
		}
	}
}