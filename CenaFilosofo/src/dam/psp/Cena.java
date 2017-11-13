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
	public Palillo getPalillo(int numComensal ){
		return palillos[numComensal];
	}
	public int getPalilloD(int numComensal) {
	return (numComensal+1)%comensales;
	}
	public int getPalilloI(int numComensal) {
		return numComensal;
	}
}
