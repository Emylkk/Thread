package semaphoro;

import java.util.concurrent.Semaphore;

public class Semaforo {
	private static Semaforo instancia = new  Semaforo();
	Semaphore sem= new Semaphore(10, true);
	Semaforo() {
		
	}
	static private double pi=  0,operador= 1;
	static private double i=-1;
	public static Semaforo getInstancia() {
		return instancia;
	}
	public   void calcula(){
		try {
			sem.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized(this) {
			i+=2;
			pi += (1/i);
			i+=2;
			pi -= (1/i);
		}
		
		sem.release();
	}
	public static double getPi() {
		return pi;
	}
}
