import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.*;

public class Anagrams {
	private Map<Long,ArrayList<String>> hm = new HashMap<Long,ArrayList<String>>();
	
	public Anagrams(String[] wordlist) {			
		
		for(String word: wordlist) {
			// String hc = sortChars(word);
			Long hc = calcProd(word);
			ArrayList<String> lv = hm.get(hc);
			if(lv == null) { lv = new ArrayList<String>(1); }
			lv.add(word);
			hm.put(hc, lv);
		}
		
	}
/*	public AnagramStream(String[] wordlist) {
		List<String> al = Arrays.asList(wordlist);
		al.forEach(word -> {
			Integer hc = sortChars(word).hashCode();
			ArrayList<String> lv = hm.get(hc);
			if(lv == null) { lv = new ArrayList<String>(1); }
			lv.add(word);
			hm.put(hc, lv);
		});
		
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
		// String hc = sortChars(word);
		Long hc = calcProd(word);
		ArrayList<String> al = hm.get(hc);
		if(al == null) return new String[0];
		else {
			// return al.toArray(new String[0]);
			return al;
		}
	}
	private long calcProd(String w){
		// https://stackoverflow.com/questions/12477339/finding-anagrams-for-a-given-word
		private int[] PRIMES = new int[] {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,83,89,97,101,103,107,109,113};
		private long count = 1;
		// char[] ca = w.toCharArray();
		for(char c : w.toCharArray()){
			count *= PRIMES[(int)c - 97];
		}
		return count;
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
	private long charHash(String word) {
		long hash = 1;
		for (char c: word.toCharArray()) {
			hash = (int)c * hash;
		}
		return hash;
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
