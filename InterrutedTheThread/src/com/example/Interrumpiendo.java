package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class HiloInterrumpible implements Runnable{
	
	private Thread miHilo = new Thread(this,"Nuevo Hilo");
	private volatile boolean vivo;
	
	HiloInterrumpible()
	{
		this.vivo = true;
		this.miHilo.start();
	}
	public boolean vive()
	{
		return this.vivo;
	}
	public void interrumpir()
	{
		if(this.miHilo != null)
			this.miHilo.interrupt();
	}
	public void detener() {
		this.vivo = false;
	}
	public void esperar() throws InterruptedException
	{
		this.miHilo.join();
	}
	@Override
	public void run() {
		
		System.out.println("Corriendo el cuerpo el hilo...");
		while(this.vivo) {
			System.out.println("Toca irse a la siesta");
			try {
				Thread.sleep(2000);
			}
			catch (InterruptedException e) {
				System.out.println("El hilo ha sido despertado por el interrupted");
			}
	
		}
		System.out.println("Hilo finalizado...");
	}
	
}

public class Interrumpiendo {

	public static void main(String[] args) {
		HiloInterrumpible hilo = new HiloInterrumpible();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String tecla;
		
		System.out.println("Iniciando el hilo principal...");
		while(hilo.vive())
		{
			System.out.println("Hilo vivo, [i] interrumpir, [k] matar");
			try {
				tecla = br.readLine();
				if(tecla.equals("i")) {
					hilo.interrumpir();
				}
				if(tecla.equals("k")) {
					hilo.detener();
				}
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		try {
		hilo.esperar();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Hilo principal finalizado...");
	}

}
