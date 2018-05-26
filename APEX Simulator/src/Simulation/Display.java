package Simulation;

public class Display extends Simulator {

	
	public static void displayResults()
	{
		
		System.out.println("\nRegisters");
		
		for(int i=0; i<16; i++)
		{
			System.out.println("R"+i+" : "+registers[i]);
		}

		for(int j=0; j<100; j++)
		{
			System.out.println("memory["+j+"]= " + Memory[j]);
		}
		
	}
	
}
