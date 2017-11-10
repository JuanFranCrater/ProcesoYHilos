package dam.psp;

public class Cena {
	Palillo[] palillos;
	int comensales;
	public Cena(int comensales) {
		this.comensales = comensales;
		palillos = new Palillo[comensales];
		for(int i=0; i<comensales;i++)
		{
			palillos[i]=new Palillo(i);
		}
	}
	public synchronized Palillo getPalillo(int numComensal ){
		return palillos[numComensal];
	}
	public synchronized int getPalilloD(int numComensal) {
	if(numComensal==comensales-1)
	{
		return 0;
	}else {
		return numComensal+1;
	}
	}
	public synchronized int getPalilloI(int numComensal) {
	
		if(numComensal==0)
		{
			return comensales-1;
		}else {
			return numComensal;
		}
	}
}
