import java.util.*;

public class VowelComparator implements Comparator<String>{
  // private int s1count = 0;
  // private int s2count = 0;
  private int[] count = new int[2];
  @Override public int compare(String s1, String s2){
    for(int i=0; i<count.length; i++){
      for(char ch : s1.toCharArray()){
        if(ch == 'a' || ch == 'e' || ch == 'i'|| ch == 'o' || ch == 'u'){
           count[i] += 1;
        }
      }
    }
    if(count[0] < count[1]) { return -1; }
    else if(count[0] > count[1]) { return +1; }
    else{
      String reverse1 = new StringBuilder(s1);
      String reverse2 = new StringBuilder(s2);
      
    }
  }
}
