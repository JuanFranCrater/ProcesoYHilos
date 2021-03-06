package dam.ps;


class Inutil {
	
	private int a = 0;
	private int b = 0;

	public synchronized void marcar_5()
	{
		a = 5;
		System.out.println("Marcando, no me metas bulla que te reviento pavo");
		b = 5;
	}
	public synchronized boolean esVerdad() {
		System.out.println("Preguntando, no me metas bulla que te reviento pavo");
		return a == 0 || b == 5;
	}
}

class HiloA extends Thread{
	private Inutil i;
	
	public HiloA(Inutil i)
	{
		this.i= i;
	}
	@Override
	public void run()
	{
		i.marcar_5();
	}
	
}
class HiloB extends Thread{
	private Inutil i;
	
	public HiloB(Inutil i)
	{
		this.i=i;
	}
	@Override 
	public void run()
	{
		if(i.esVerdad())
		{
			System.out.println("Verdadero");
		}else {
			System.out.println("Falso");
		}
	}
	
}

public class MonitoresMain {

	public static void main(String[] args) {
		Inutil in = new Inutil();
		
		HiloA ha = new HiloA(in);
		HiloB hb = new HiloB(in);
		hb.start();
		ha.start();
		
		
		try {
			ha.join();
			hb.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

	}

}
