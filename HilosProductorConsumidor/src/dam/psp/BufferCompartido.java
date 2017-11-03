package dam.psp;

public class BufferCompartido implements Buffer {

	private int buffer = -1;
	private int contadorOcupado = 0;
	
	@Override
	public synchronized int leer() {
		while(contadorOcupado==0)
		{
			try {
				this.wait();
			}catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		this.notifyAll();
		return buffer;
	}

	@Override
	public synchronized void escribir(int valor) 
	{
		contadorOcupado--;
		buffer= valor;
		contadorOcupado++;
		this.notifyAll();
		
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
