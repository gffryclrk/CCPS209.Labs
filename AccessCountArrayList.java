import java.util.*;

public class AccessCountArrayList<E>
    extends ArrayList<E>{
        private static int getCount = 0;
        private static int setCount = 0;
        private E value = null;
        
        /*
        public AccessCountArrayList(){
            super();
        }
        */

        
        @Override
        public E get(int index){
            value = super.get(index);
            getCount += 1;
            return value;
            // return super.get(index);
        }
        @Override
        public E set(int index, E element){
            value = super.set(index, element);
            setCount += 1;
            return value;
            //return super.set(index, element);
        }
        //public boolean
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