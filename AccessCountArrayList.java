import java.util.*;

public class AccessCountArrayList<E>
    extends ArrayList<E>{
        // private static int getCount;
        // private static int setCount;
        private int getCount = 0;
        private int setCount = 0;
        // private E value = null;
        
        // private static int getCount = 0;
        // private static int setCount = 0;
        
        public AccessCountArrayList(){
            super();
        }
        // public AccessCountArrayList(Collection<? extends E> c){
        // 	super(c);
        // }
        public AccessCountArrayList(int initialCapacity){
        	super(initialCapacity);
        }
        // static {
        // 	getCount = 0;
        // 	setCount = 0;
        // }
        
        @Override public E get(int index){
            // value = super.get(index);
            // return value;
        	
            getCount += 1;

        	// if(this.size() > index) getCount += 1;
            return super.get(index);
        }
        @Override public E set(int index, E element){
            // value = super.set(index, element);
            // return value;
            
            setCount += 1;
            
            // if(this.size() > index) setCount += 1;
            return super.set(index, element);
        }
        int getGetCount(){
            return getCount; // + setCount;
        }
        int getSetCount(){
            return setCount; // + getCount;
        }
        void resetCounts(){
            getCount = 0;
            setCount = 0;
        }

    }