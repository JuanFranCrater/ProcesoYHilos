package dam.psp;

public class Productor extends Thread {
	private Buffer compartido;
	private int veces; //veces que tiene que iterar las producciones de enteros
	
	public Productor(Buffer elbufer,int nveces)
	{
		compartido = elbufer;
		veces = nveces;
	}
	
	@Override
	public void run() {
		int contador=0;
		for(int i = 0; i< veces; i++)
		{
			//try {
			//Thread.sleep((int) (Math.random()*3001));
			compartido.escribir(i);
			//}catch(InterruptedException e)
			//{
				//e.printStackTrace();
				
		//	}
			contador++;
		}
		//System.out.println(getName() + " termino de producir datos("+contador+")");
	}
}
