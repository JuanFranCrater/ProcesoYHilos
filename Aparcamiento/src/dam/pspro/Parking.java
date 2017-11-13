package dam.pspro;

public class Parking 
{
	private int numCoches;
	private boolean[] parking;
	private int ocupados;
	
	public Parking(int numCoches, int numparking) {
		super();
		this.numCoches = numCoches;
		this.parking = new boolean[numparking];
		this.ocupados=0;
	}
	public synchronized void entrar() {
		String cocheEntrante = Thread.currentThread().getName();
		while(ocupados==parking.length)
		{
			System.out.println(cocheEntrante+"trata de aparcar");
			System.out.println("Aparcamiento Lleno. "+cocheEntrante+" debe esperar");
			System.out.println();
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public synchronized void salir()
	{
		
	}
	
}
