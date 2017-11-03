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
			
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		System.out.println("El alumno "+alumno+" dice: Buenos dias");
		
	
	}
	public synchronized void profesorSaluda() 
	{
		System.out.println("El profesor dice: Buenos dias");
		this.comienzaLaClase=true;
		this.notifyAll();
	}
}
