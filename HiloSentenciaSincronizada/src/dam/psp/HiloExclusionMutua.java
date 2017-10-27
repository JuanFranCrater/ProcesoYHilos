package dam.psp;

class DatosCompartido{
	public static int c1 = 0;
	public static int c2 = 0;
	
	public static void incremetarC1()
	{
		c1++;
	}
	public static void incremetarC2()
	{
		c2++;
	}
}

class HilosMutex extends Thread{
	@Override
	public void run()
	{
		DatosCompartido.incremetarC1();
		DatosCompartido.incremetarC2();
	}
	
}


public class HiloExclusionMutua {

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		
		HilosMutex hilos[];
		hilos= new HilosMutex[N];
		System.out.println("Creando "+N+" hilos");
		for(int i = 0; i< N;i++)
		{
			hilos[i] = new HilosMutex();
			hilos[i].start();
		}
		for(int i = 0; i< N;i++)
		{
			
			try {
				hilos[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("C1="+DatosCompartido.c1);
		System.out.println("C2="+DatosCompartido.c2);
	}

}
