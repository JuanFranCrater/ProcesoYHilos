package dam.psp;


public class HiloPrincipalCena {
	
	

	public static void main(String[] args) {
		Thread hilo;
		
		int comensales = Integer.parseInt(args[0]);
		int almuerzos =  Integer.parseInt(args[1]);
		Cena laCena= new Cena(comensales);
	
		for(int i = 0; i<comensales;i++)
		{
			hilo=new Thread(new Filosofo(i,almuerzos, laCena));
			hilo.start();
		}
		
		System.out.println("Hilo Principal acabado");
	
	}

}
