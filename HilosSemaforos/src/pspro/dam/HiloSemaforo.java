package pspro.dam;

import java.util.concurrent.Semaphore;



public class HiloSemaforo {
	private static Sumador sumadores[];
	private static Semaphore semaphore = new Semaphore(1);
	
	public static void main(String[] args) {
		int n_sum = Integer.parseInt(args[0]);
		
	}

}

class Acumula{
	public static int acumulador=0;
}

class Sumador extends Thread{
	private int cuenta;
	private Semaphore sem;
	
	Sumador(int hasta, int id, Semaphore sem)
	
	{
		this.cuenta= hasta;
		this.sem=sem;
	}
	public void sumar()
	{
		Acumula.acumulador++;
	}
	public void run() {
		for (int i = 0;i<cuenta;i++) {
			try {
				sem.acquire();
				sumar();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			//sumar();
			sem.release();
		}
	}
}
