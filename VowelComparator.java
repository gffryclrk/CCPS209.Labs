import java.util.*;

public class VowelComparator implements Comparator<String>{
  @Override public int compare(String s1, String s2){
    int[] count = {0, 0};
    String[] cs = new String[] {s1, s2};
    for(int i=0; i<count.length; i++){
      for(char ch : cs[i].toLowerCase().toCharArray()){
        if(ch == 'a' || ch == 'e' || ch == 'i'|| ch == 'o' || ch == 'u' || ch == 'y'){
           count[i] += 1;
        }
      }
    }
    if(count[0] < count[1]) { return -1; }
    else if(count[0] > count[1]) { return +1; }
    else{
      
      // I don't know if below, instantiating two StringBuilders, is the best way to do the reversal comparison
      // However, I couldn't think of anything more succinct. 

      String reverse1 = new StringBuilder(s1).reverse().toString();
      String reverse2 = new StringBuilder(s2).reverse().toString();
      return reverse1.compareTo(reverse2);
      
    }
  }
}
