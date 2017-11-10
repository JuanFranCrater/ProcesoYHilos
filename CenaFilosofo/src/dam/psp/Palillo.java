package dam.psp;

public class Palillo {
	int numero;
	boolean enUso;
	
	public Palillo(int numero) {
	
		this.numero = numero;
		enUso = false;
	}
	void coger(){
		enUso=true;
		
	}
	void soltar(){
		enUso=false;
	}

}
