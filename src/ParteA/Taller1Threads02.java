package ParteA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Taller1Threads02 implements Runnable{
	
	private int limite;
	
	private boolean par;
	
	public Taller1Threads02(int n, boolean par) 
	{
		this.limite = n;
		this.par = par;
	}
	
	public void run() 
	{	
		if(par) {			
			System.out.println("Pares: ");
			
			for (int i=1; i<=limite; i++) {
				if(esImpar(limite)) {
					if (!esImpar(i) && i!=limite-1) {
					    System.out.print(i + "-");
					}
					if (!esImpar(i) && i==limite-1) {
					    System.out.print(i);
					}
				} 
				else {
					if (!esImpar(i) && i!=limite) {
					    System.out.print(i + "-");
					}
					if (!esImpar(i) && i==limite) {
					    System.out.print(i);
					}
				}				
			}
		}
		else {
			System.out.println("Impares: ");
			if(limite == 1) {
				System.out.print(1);
			}
			else {
				for (int i=1; i<=limite; i++) {
					if(esImpar(limite)) {
						if (esImpar(i) && i!=limite) {
						    System.out.print(i + "-");
						}
						if (esImpar(i) && i==limite) {
						    System.out.print(i);
						}
					}
					else {
						if (esImpar(i) && i!=limite-1) {
						    System.out.print(i + "-");
						}
						if (esImpar(i) && i==limite-1) {
						    System.out.print(i);
						}
					}				
				}
			}
		}
		System.out.println("");
	}
	
	public boolean esImpar(int iNumero) 
	{
		if (iNumero%2!=0)
			return true;
		else
		    return false;
	}
	
	public static void main (String [] args) throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader (isr);

        try
        {
            System.out.print("Número límite superior: ");
            int limite = Integer.parseInt(br.readLine());
            
            Thread par = new Thread(new Taller1Threads02(limite, true));
            Thread impar = new Thread(new Taller1Threads02(limite, false));
            
    		par.start();
    		par.sleep(100);
    		impar.start();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
