import java.util.*;

public class AccessCountArrayList<E>
    extends ArrayList<E>{

        private int getCount = 0;
        private int setCount = 0;
        
        public AccessCountArrayList(){
            super();
        }

        public AccessCountArrayList(int initialCapacity){
        	super(initialCapacity);
        }
        
        @Override public E get(int index){
        	getCount += 1;
            return super.get(index);
        }

        @Override public E set(int index, E element){
            setCount += 1;
            return super.set(index, element);
        }

        int getGetCount(){
            return getCount; 
        }

        int getSetCount(){
            return setCount;
        }

        void resetCounts(){
            getCount = 0;
            setCount = 0;
        }

    }