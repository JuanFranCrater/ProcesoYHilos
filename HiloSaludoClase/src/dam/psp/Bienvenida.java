package dam.psp;

public class Bienvenida {
	Boolean comienzaLaClase;
	public Bienvenida()
	{
		this.comienzaLaClase =false;
	}
	
	public synchronized void saludarAlProfesor(String alumno)
	{
		System.out.println("El alumno "+alumno+" quiere saludar");
		while(!comienzaLaClase)
			try {
				this.wait();
				System.out.println("El alumno "+alumno+" dice: Buenos dias");
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
	
	}
	public synchronized void profesorSaluda() 
	{
		System.out.println("El profesor dice: Buenos dias");
		this.comienzaLaClase=true;
		this.notifyAll();
	}
}
