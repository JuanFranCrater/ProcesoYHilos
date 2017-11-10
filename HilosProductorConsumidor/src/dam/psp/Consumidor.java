package dam.psp;

public class Consumidor extends Thread {
	private Buffer compartido;
	private int veces; //veces que tiene que iterar el consumo de enteros
	
	public Consumidor(Buffer elbufer,int nveces)
	{
		compartido = elbufer;
		veces = nveces;
	}
	
	@Override
	public void run() {
		int suma =0;
		int valor =0;
		for(int i = 0; i< veces; i++)
		{
			//try {
			//Thread.sleep((int) (Math.random()*3001));
			valor=compartido.leer();
			suma += valor;
			//System.out.println("Yo, "+getName()+" he leido el "+valor);
			//}catch(InterruptedException e)
			//{
			//	e.printStackTrace();
			//}
		}
		System.out.println(getName() + " termino de consumir un total de " + suma+" datos");
	}
}