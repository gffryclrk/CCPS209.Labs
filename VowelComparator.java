import java.util.*;

// public class VowelComparator implements Comparator<String>{
//   private Comparator comp;

//   public VowelComparator(Comparator comp){
//     this.comp = comp;
//   }
//   @Override public int compare(String s1, String s2){
//     //cs[0] = s1;
//     //cs[1] = s2;
//     int[] count = {0, 0};
//     String[] cs = new String[] {s1, s2};
//     // String[] cs;
//     // cs = new String[] {s1, s2};
//     for(int i=0; i<count.length; i++){
//       for(char ch : cs[i].toLowerCase().toCharArray()){
//         if(ch == 'a' || ch == 'e' || ch == 'i'|| ch == 'o' || ch == 'u'){
//            count[i] += 1;
//         }
//       }
//     }
//     if(count[0] < count[1]) { return -1; }
//     else if(count[0] > count[1]) { return +1; }
//     else{
//       String reverse1 = new StringBuilder(s1).reverse().toString();
//       String reverse2 = new StringBuilder(s2).reverse().toString();
//       return s1.compareTo(s2);  
//     }
//   }
// }


public class VowelComparator implements Comparator<String>{
  // private int s1count = 0;
  // private int s2count = 0;
  // public int[] count = {0, 0};
  // String[] cs;
  @Override public int compare(String s1, String s2){
    //cs[0] = s1;
    //cs[1] = s2;
    //System.out.println(s1);
    //System.out.println(s2);
    int[] count = {0, 0};
    String[] cs = new String[] {s1, s2};
    // String[] cs;
    // cs = new String[] {s1, s2};
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
      String reverse1 = new StringBuilder(s1).reverse().toString();
      String reverse2 = new StringBuilder(s2).reverse().toString();
      return reverse1.compareTo(reverse2);
      
    }
  }
}
