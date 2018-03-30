import java.util.concurrent.*;

public class LearningThreads {
	Semaphore maySleep = new Semaphore(1, true);
	boolean running = true;
	
	public class SleepyHead implements Runnable{
		private int id; 
		private int n;
		
		public SleepyHead(int id, int n) {
			this.id = id;
			this.n = n;
		}
		
		public void run() {
			for(int i = 0; i<=n; i+=1) {
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
		System.out.println("All SleepyHeads created, returning from method.");
	}
	public static void main(String[] args) {
		LearningThreads lt = new LearningThreads();
	}
	
}
