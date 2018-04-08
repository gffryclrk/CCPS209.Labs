import java.util.concurrent.*;

public class LearningThreads {
    // With fair set to true there seems to be a more deterministic order
    // to the counting. The last time I ran it the thread ids who
    // acquired the semaphore seemed to go in order from lowest to highest.
    // If the initial semaphore value is larger than 1, say 2 or n, 
    // it appears that more threads run at once (concurrently). 
    // In such a situation the counting appears even less deterministic
    // than with one thread, even if fair is set to true. 
    Semaphore maySleep = new Semaphore(1, true); 
    boolean running = true; //never used?
    
    public class SleepyHead implements Runnable{
        private int id; 
        private int n;
        
        public SleepyHead(int id, int n) {
            this.id = id;
            this.n = n;
        }
        
        public void run() {
            for(int i = 0; i<n; i+=1) {
                try {
                    maySleep.acquire();
                    System.out.println("Thread " + id + " has acquired a permit to sleep");
                    Thread.sleep(2000);
                    System.out.println("Thread " + id + " has woken up");
                    maySleep.release();
                }catch(InterruptedException e) {}
                System.out.println("Thread " + id + " has completed its execution");
            }
        }
    }
    
    public LearningThreads() {
        for(int i=1; i<6; i+=1) {
            Thread t = new Thread(new SleepyHead(i, 5));
            t.start();
        }
        System.out.println("Constructor of LearningThreads is completed.");
    }
    public static void main(String[] args) {
        LearningThreads lt = new LearningThreads();
    }
    
}
