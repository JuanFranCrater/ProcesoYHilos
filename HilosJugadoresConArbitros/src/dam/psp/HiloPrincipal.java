package dam.psp;


public class HiloPrincipal {

	public static void main(String[] args) {
		int numJug = 7;
		Arbitro arb = new Arbitro(numJug);
		Jugador jug1 = new Jugador(0,arb);
		Jugador jug2 = new Jugador(1,arb);
		Jugador jug3 = new Jugador(2,arb);
		Jugador jug4 = new Jugador(3,arb);
		Jugador jug5 = new Jugador(4,arb);
		Jugador jug6 = new Jugador(5,arb);
		Jugador jug7 = new Jugador(6,arb);
		
		jug1.start();
		jug2.start();
		jug3.start();
		jug4.start();
		jug5.start();
		jug6.start();
		jug7.start();
		
	try {
		jug1.join();
		jug2.join();
		jug3.join();
		jug4.join();
		jug5.join();
		jug6.join();
		jug7.join();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	System.out.println("Hilo Principal Acabado");

	}

}
