import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.*;

public class Anagrams {
	private Map<String,ArrayList<String>> hm = new HashMap<String,ArrayList<String>>();
	
	public Anagrams(String[] wordlist) {			
		
		for(String word: wordlist) {
			String hc = sortChars(word);
			ArrayList<String> lv = hm.get(hc);
			if(lv == null) { lv = new ArrayList<String>(1); }
			lv.add(word);
			hm.put(hc, lv);
		}
		
	}
/*	public AnagramStream(String[] wordlist) {
		List<String> al = Arrays.asList(wordlist);
//		al.forEach(word -> {
//			Integer hc = sortChars(word).hashCode();
//			ArrayList<String> lv = hm.get(hc);
//			if(lv == null) { lv = new ArrayList<String>(1); }
//			lv.add(word);
//			hm.put(hc, lv);
//		});
		
		Map<Integer, ArrayList<String>> hm = al.stream()
		.map(x -> new HashMap<Integer, ArrayList<String>>(sortChars(x).hashCode(), new ArrayList<String>(x))
		.reduce((a,b) -> {
			if(a.get(b.
		}
		
		
		Map<Integer, ArrayList<String>> hm = al.stream()
		.map(x -> sortChars(x).hashCode() + "," + x)
		.
		
		Map<Integer, ArrayList<String>> hm = al.stream()
		.collect(() -> new HashMap<>(),
		(c, e) -> c.put(sortChars(e).hashCode(), new ArrayList<String>(e)),
		(c1, c2) -> 
	}
*/
	public String[] allAnagrams(String word) {
//		https://stackoverflow.com/questions/5374311/convert-arrayliststring-to-string-array
		String hc = sortChars(word);
		ArrayList<String> al = hm.get(hc);
		if(al == null) return new String[0];
		else {
			return al.toArray(new String[0]);
		}
	}
	private String sortChars(String word) {
//		https://stackoverflow.com/questions/30199304/sorting-characters-alphabetically-in-a-string
		char[] ca = word.toCharArray();
		Arrays.sort(ca);
		return new String(ca);
	}
	private int charSum(String word) {
		int sum = 0;
		for(char c : word.toCharArray()) {
			sum += (int) c;
		}
		return sum;
	}
	public static void main(String[] args) {
		/*
		String[] wl = {"pram", "ramp", "poot", "hoot", "top","pot"};
		Anagrams aa = new Anagrams(wl);
		System.out.println(Arrays.toString(aa.allAnagrams("pram")));
		System.out.println(aa.sortChars("pram"));
		System.out.println(aa.sortChars("pram").hashCode());
		System.out.println(aa.sortChars("ramp"));
		System.out.println(aa.sortChars("ramp").hashCode());
		 */
		
		List<String> wordList = new ArrayList<String>(74896);
        try {
            Scanner s = new Scanner(new File("words45678.txt"));
            while(s.hasNextLine()) {
                wordList.add(s.nextLine());
            }
            s.close();
        }
        catch(Exception e) {
            System.out.println("Unable to read words6.txt: " + e);
            assertTrue(false);
        }
        System.out.println("Successfully read in " + wordList.size() + " words.");
        String[] wordArray = wordList.toArray(new String[0]);
        Anagrams aa = new Anagrams(wordArray);
		System.out.println(Arrays.toString(aa.allAnagrams("ramble")));
    		
	}
}
