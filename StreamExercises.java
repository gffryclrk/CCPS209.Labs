import java.util.*;
//import java.util.function.Predicate;
import java.nio.file.*;
import java.io.*;
import java.util.stream.*;

/**
 * Write a description of class StreamExercises here.
 *
 * @author Geoffrey
 * @version 0.1 AWESOME
 */
public class StreamExercises
{
    int sumOfSquares(Collection<Integer> c, int thres){
        return c.stream()
        .filter( x -> x > Math.abs(thres) )
        .map(x -> x * x)
        .reduce (0, (x,y) -> x + y);
    }
    
    private class Increasing implements java.util.function.DoublePredicate{
		private Double prev;
        @Override
        public boolean test(double x){
    		boolean result = (prev == null || x > prev);
            this.prev = x;
            return result;
        }
    }
    int countAscensions(Random rng, int len){
        Increasing dp = new Increasing();
        return (int) DoubleStream.generate( () -> rng.nextDouble())
        .limit(len)
        .filter( dp )
        .count();
    }
    int countLines(Path path, int thres) throws IOException{
        return (int) Files.lines(path)
        .filter(x-> x.length() >= thres)
        .count();
    }
    
    private class MyDistinct<T> implements java.util.function.Predicate<T>{
    		private Collection<T> hs = new HashSet<T>();
    		public boolean test(T s) {
    			return hs.add(s);
    		}
    }
    
    public List<String> collectWords(Path path) throws IOException{
    		return Files.lines(path)
    		.flatMap(str -> Arrays.stream(str.toLowerCase().split("[^a-z]+")))
    		.filter(x -> x.length() > 0)
    		.sorted(String::compareTo)
//    		.distinct()
    		.filter(new MyDistinct<String>())
    		.collect(Collectors.toList());
    }
}
