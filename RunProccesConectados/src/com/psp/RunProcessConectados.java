package com.psp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class RunProcessConectados {

	public static void main(String[] args)
	{
		if(args.length <=0) {
			System.err.println("Se necesita como argumento un proceso a ejecutar");
			System.exit(-1);
		}
		ProcessBuilder pb = new ProcessBuilder(args);
		pb.redirectErrorStream(true);
		try {
			Process proceso = pb.start();
			
			MostrarSalidaProceso(proceso);
			System.exit(0);
		}catch(IOException e){
			System.err.println("Error de E/S");
			System.exit(-1);
		}
		
	}
	private static void MostrarSalidaProceso(Process proceso)
	{
		int lineas = 5;
		try {
			
			 InputStreamReader lector = new InputStreamReader(proceso.getInputStream(), "utf-8");
			 BufferedReader	 br = new BufferedReader(lector);
			 String linea;
			 while ((linea = br.readLine()) != null&&lineas!=0) {
				System.out.println(linea);
				lineas--;
			}
			 if(proceso != null)
				 proceso.destroy();
			 try {
				 proceso.waitFor();
			 }catch(InterruptedException e)
			 {
				 System.out.println("No se puede esperar al final del proceso hijo");
			 }
			 System.out.println("Salida del proceso hijo:" + proceso.exitValue());
			 System.exit(0);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
