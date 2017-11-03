package dam.psp;

public class PruebaBufferCompartido {

	public static void main(String[] args) {
		
		Buffer bcompartido = new BufferCompartido();
		
		Productor prod = new Productor(bcompartido, 10);
		Consumidor con1 = new Consumidor(bcompartido, 6);
		Consumidor con2 = new Consumidor(bcompartido, 4);
		StringBuffer encabezado = new StringBuffer("Operación");
		encabezado.setLength(40);
		encabezado.append("Buffer		Contador ocupado");
		System.out.println(encabezado);
		System.out.println();
		bcompartido.mostrarEstado("Estado inicial");
		
		prod.start();
		con1.start();
		con2.start();
		try {
		prod.join(); 
		con1.join();
		con2.join();
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println("Hilo principal ha finalizado");
	}

}
