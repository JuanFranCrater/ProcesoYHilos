package dam.psp;

public class BufferCompartido implements Buffer {

	private int buffer = -1;
	private int contadorOcupado = 0;
	
	@Override
	public synchronized int leer() {
		
		while(contadorOcupado==0)
		{
			try {
				wait();
			}catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		contadorOcupado=0;
		notify();
		return buffer;
	}

	@Override
	public synchronized void escribir(int valor) 
	{		
		while(contadorOcupado==1)
		{
			try {
				wait();
			}catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		buffer= valor;
		System.out.println("Se ha creado el "+valor);
		contadorOcupado=1;
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

}
