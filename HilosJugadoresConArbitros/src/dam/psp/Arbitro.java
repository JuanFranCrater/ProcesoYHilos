package dam.psp;


public class Arbitro implements Juego{
	private int numJug;
	private int turno;
	private int objetivo;
	private boolean acertado;
	public int maximo = 1000;
	
	public Arbitro(int numJug) {
		turno=(int)(numJug*Math.random());
		acertado=false;
		this.numJug = numJug;
		objetivo=1+(int)(maximo*Math.random());
		System.out.println("Número a acertar: "+objetivo);
	}
	@Override
	public int esTurnoDe() {

		return turno;
	}
	@Override
	public boolean seAcabo() {
	
		return acertado;
	}
	@Override
	public synchronized void jugar(int dorsal, int intento) {
		System.out.println();
		System.out.println("Jugador "+dorsal);
		while(dorsal!=turno && !acertado)
		{
			try {
				System.out.println("[PRE]Jugador "+dorsal+" y es turno de "+turno);
				wait();
				System.out.println("[POST]Jugador "+dorsal+" y es turno de "+turno);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if(!acertado)
		{
			System.out.println("El jugador "+turno+ " prueba con "+intento);
			if(intento==objetivo)
			{
				acertado = true;
				System.out.println("Jugador "+turno+ " WINS!");
				System.out.println();
				
			}else {
				System.out.println("Jugador "+turno+ " FAILED!");
				turno = (turno+1)%numJug;
				System.out.println("Ahora es turno del Jugador  " +turno);
				System.out.println();
			}
		
		}
		notifyAll();
		
		
	}
	
	
	
}
