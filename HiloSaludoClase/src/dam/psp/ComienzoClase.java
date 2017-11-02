package dam.psp;

public class ComienzoClase {

	public static void main(String[] args) {
		Bienvenida b = new Bienvenida();
		
		int nAlumnos = Integer.parseInt(args[0]);
		
		for(int i = 0; i<nAlumnos; i++)
		{
			new Alumno("Alumno "+i,b).start();
		}
		Profesor profe = new Profesor("E.Moreno",b);
		profe.start();
		
		try {
			profe.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
