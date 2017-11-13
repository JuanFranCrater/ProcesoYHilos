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
		}
		System.out.println("Yo, el Filosofo "+posicion+", he acabado de cenar");
		System.out.println();
	}
	void pensar()
	{
		System.out.println("Yo, el Filosofo "+posicion+", estoy pensando");
		System.out.println();
		try {
			Thread.sleep((long)Math.random());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Yo, el Filosofo "+posicion+", empiezo a tener hambre");
		System.out.println();
	}
	void comer()
	{
		System.out.println("Yo, el Filosofo "+posicion+", comienzo a comer");
		System.out.println();
		try {
			Thread.sleep((long)Math.random());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Yo, el Filosofo"+posicion+", he terminado de comer");
		System.out.println();
	}
	void cogerPalillo()
	{if(posicion%2==0)
	{
	System.out.println("Yo, el Filosofo"+posicion+", voy a coger los palillos");
	System.out.println();
	laCena.getPalillo(laCena.getPalilloD(posicion)).coger();
	laCena.getPalillo(laCena.getPalilloI(posicion)).coger();
	
	System.out.println("Yo, el Filosofo"+posicion+", los he cogido");
	System.out.println();
	}else
	{
		System.out.println("Yo, el Filosofo"+posicion+", voy a coger los palillos");
		System.out.println();
		laCena.getPalillo(laCena.getPalilloI(posicion)).coger();
		laCena.getPalillo(laCena.getPalilloD(posicion)).coger();
		System.out.println("Yo, el Filosofo"+posicion+", los he cogido");
		System.out.println();
	}
		
	}
	void soltarPalillo()
	{
		if(posicion%2==0)
		{
		System.out.println("Yo, el Filosofo"+posicion+", voy a coger los palillos");
		System.out.println();
		laCena.getPalillo(laCena.getPalilloD(posicion)).soltar();
		laCena.getPalillo(laCena.getPalilloI(posicion)).soltar();
		
		System.out.println("Yo, el Filosofo"+posicion+", los he cogido");
		System.out.println();
		}else
		{
			System.out.println("Yo, el Filosofo"+posicion+", voy a coger los palillos");
			System.out.println();
			laCena.getPalillo(laCena.getPalilloI(posicion)).soltar();
			laCena.getPalillo(laCena.getPalilloD(posicion)).soltar();
			System.out.println("Yo, el Filosofo"+posicion+", los he cogido");
			System.out.println();
		}
		;
	}

	

}
