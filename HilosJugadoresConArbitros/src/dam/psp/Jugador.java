package dam.psp;

public class Jugador extends Thread {
	private int dorsal;
	private Arbitro arb;
	public Jugador(int dorsal, Arbitro arb) {
		this.dorsal = dorsal;
		this.arb = arb;
	}
	@Override
	public void run() {
		while(!arb.seAcabo())
		{
			arb.jugar(this.dorsal,1+(int)((arb.maximo)*Math.random()));
		}
		System.out.println("El jugador "+dorsal+" ha dejado de jugar");
		
	}
}
