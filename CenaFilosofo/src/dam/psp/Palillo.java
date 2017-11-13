package dam.psp;

public class Palillo {
	int numero;
	boolean enUso;
	
	public Palillo(int numero) {
	
		this.numero = numero;
		enUso = false;
	}
	public synchronized void coger(){
		
		while(enUso)
		{
			try {
				this.wait();
				System.out.println("Palillo "+numero+" en uso, espera...");
				System.out.println();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		enUso=true;
		System.out.println("Palillo "+numero+" tomado por "+Thread.currentThread().getName());	
		System.out.println();
	}
	public synchronized void soltar(){
		enUso=false;
		System.out.println("Palillo "+numero+" soltado por "+Thread.currentThread().getName());
		System.out.println();
		notify();
	}

}
