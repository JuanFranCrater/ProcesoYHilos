package dam.psp;

public class Filosofo implements Runnable {
	int posicion;
	int veces;
	Cena laCena;
	public Filosofo(int posicion, int veces,Cena laCena) {
		this.posicion = posicion;
		this.veces = veces;
		this.laCena = laCena;
	}
	@Override
	public void run() {
		for(int i =0; i<veces;i++)
		{
			pensar();
			cogerPalillo();
			comer();
			soltarPalillo();
			notifyAll();
		}
		System.out.println("Yo, el Filosofo "+posicion+", he acabado de cenar");
	}
	void pensar()
	{
		System.out.println("Yo, el Filosofo "+posicion+", estoy pensando");
		try {
			Thread.sleep((long)Math.random());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Yo, el Filosofo "+posicion+", empiezo a tener hambre");
	}
	void comer()
	{
		System.out.println("Yo, el Filosofo "+posicion+", comienzo a comer");
		try {
			Thread.sleep((long)Math.random());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Yo, el Filosofo"+posicion+", he terminado de comer");
	}
	void cogerPalillo()
	{
		System.out.println("Yo, el Filosofo"+posicion+", voy a coger los palillos");
		laCena.getPalillo(laCena.getPalilloD(posicion)).coger();
		laCena.getPalillo(laCena.getPalilloI(posicion)).coger();
		
		System.out.println("Yo, el Filosofo"+posicion+", los he cogido");
	}
	void soltarPalillo()
	{
		System.out.println("Yo, el Filosofo"+posicion+", voy a soltar los palillos");
		laCena.getPalillo(laCena.getPalilloD(posicion)).soltar();
		laCena.getPalillo(laCena.getPalilloI(posicion)).soltar();
	}

	

}
