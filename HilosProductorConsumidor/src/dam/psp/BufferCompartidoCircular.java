package dam.psp;

public class BufferCompartidoCircular implements Buffer {
	
	private int buffer[] = {-1,-1,-1};
	private int contadorOcupado = 0;
	private int posLectura = 0;
	private int posEscritura = 0;
	
	@Override
	public synchronized int leer() {
		String hiloLlamador = Thread.currentThread().getName();
		while(contadorOcupado==0)
		{
			System.out.println(hiloLlamador+"trata de leer");
			System.out.println("buffer vacío. "+hiloLlamador+" debe esperar");
			System.out.println();
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int valorLeido= buffer[posLectura];
		contadorOcupado--;
		posLectura =(posLectura+1)%buffer.length;
		System.out.println(hiloLlamador+" consigue leer "+valorLeido);
		System.out.println();
		notify();
		return valorLeido;
	}

	@Override
	public synchronized void escribir(int valor) {
		
		String hiloLlamador = Thread.currentThread().getName();
		while(contadorOcupado==buffer.length)
		{
			System.out.println(hiloLlamador+" trata de escribir");
			System.out.println();
			System.out.println("buffer lleno. "+hiloLlamador+" debe esperar");
			System.out.println();
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		buffer[posEscritura]=valor;
		contadorOcupado++;
		posEscritura =(posEscritura+1)%buffer.length;
		System.out.println(hiloLlamador+" consigue escribir "+valor);
		System.out.println();
		notify();
	}

	@Override
	public void mostrarEstado(String cadena) {
		StringBuffer linea = new StringBuffer();
		linea.setLength(80);
		linea.append(buffer + " " + contadorOcupado);
		System.out.println(linea);
		System.out.println();

	}
	
	public String mostrarSalida() {
		String salida = "(huecos ocupado: )"+contadorOcupado+")\nhuecos:    ";
		for(int i = 0; i<buffer.length;i++)
		{
			salida +=buffer[i] +"";
		}
		salida +="\n      ";
		for(int i = 0; i<buffer.length;i++) {
			if(i==posEscritura && posEscritura == posLectura) {
				salida+=" EL ";
			}
			else if(i==posLectura) {
				salida+=" L ";
			}
			else {
				salida+="  ";
			}
		}
		return salida;
	}

}
