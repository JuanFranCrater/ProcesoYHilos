package dam.psp;

import java.util.concurrent.atomic.AtomicInteger;


class Contador{
	public final static  AtomicInteger cuenta = new AtomicInteger(0);
	
}

class Sumador extends Thread {
		@Override
		public void run() {
			for(int i = 0; i<1000000000;i++)
			{
			Contador.cuenta.incrementAndGet();
			}	
			}
}

class Restador extends Thread {
	@Override
	public void run() {
		for(int i = 0; i<50;i++)
		{
		Contador.cuenta.decrementAndGet();
		
		}
	}
}

public class TestCondiciondeCarrera {

	public static void main(String[] args) {
		Sumador s = new Sumador();
		Restador r = new Restador();
		
		s.start();
		r.start();
		try {
			s.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			r.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Valor final del contador: "+Contador.cuenta);
		
		
	}

}
