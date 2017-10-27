package dam.ps;


//Clase con métodos sincronizados
public class Monitores {
private int c = 0;
public void Monitores(int num)
{
this.c = num;	
}
public synchronized void increment()
{
	c++;

}

public synchronized void decrement()
{
	c--;
}
public synchronized int value()
{
	return c;
}
}
