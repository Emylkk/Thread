package semaphoro;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Pi {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService es = Executors.newCachedThreadPool();
		Semaforo s = new Semaforo();
		for(int i=0;i<99000;i++) {
			es.submit(new Runnable() {
				public void run() {
					s.getInstancia().calcula();
				}
			});
			
		}
		System.out.println("\n pi = " + s.getInstancia().getPi()*4);
	es.shutdown();
	es.awaitTermination(2, TimeUnit.SECONDS);
	}

}
