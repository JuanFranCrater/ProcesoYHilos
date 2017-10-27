package dam.psp;

class HolaMundoHilo implements Runnable{
	
	Thread hilo;
	HolaMundoHilo () {
		hilo= new Thread(this, "Nuevo Hilo creado");
		System.out.println("Creando hilo nuevo"+hilo);
		hilo.start();
	}
	public void Espera()
	{
		try {
			hilo.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		System.out.println("Hilo nuevo ha empezado a ejecutarse...");
		System.out.println("Me duermo...");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Me despierto");
		System.out.println("Hilo finalizando...");
	}

}

public class HolaMundo {

	public static void main(String[] args){
		HolaMundoHilo hijo;
		
		System.out.println("Hola desde el hilo principal(main)");
		
		hijo=new HolaMundoHilo();
		hijo.Espera();
		
		System.out.println("Hilo principal (main) finalizando...");

}}