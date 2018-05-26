package Simulation;
import Initialization.Initializations;
import PipelineStages.SDecodeStage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Simulator {
	protected static HashMap<Integer, SDecodeStage> instWithAddress = new HashMap<>();
	protected static HashMap<Integer, String> instNoWithAddress = new HashMap<>();
	protected static ArrayList<SDecodeStage> fetchStage = new ArrayList<>();
	protected static ArrayList<SDecodeStage> decodeStage = new ArrayList<>();
	protected static ArrayList<SDecodeStage> mulStageOne = new ArrayList<>();
	protected static ArrayList<SDecodeStage> divStageOne = new ArrayList<>();
	protected static ArrayList<SDecodeStage> divStageTwo = new ArrayList<>();
	protected static ArrayList<SDecodeStage> divStageThree = new ArrayList<>();
	protected static ArrayList<SDecodeStage> divStageFour = new ArrayList<>();
	protected static ArrayList<SDecodeStage> mulStageTwo = new ArrayList<>();
	protected static ArrayList<SDecodeStage> integerFUStage = new ArrayList<>();
	protected static ArrayList<SDecodeStage> memoryStage = new ArrayList<>();
	protected static ArrayList<SDecodeStage> writeBackStage = new ArrayList<>();
	protected static int Memory[] = new int[3999];
	protected static int PC = 4000;
	protected static int instNum = 0;
	protected static int BZPC;
	protected static int PSWPC;
	protected static int zeroflag;
	protected static int regValue;
	protected static int registers[]= new int[16];
	protected static int available[]= new int[16];
	protected static int dependent[]= new int[16];
	protected static int OPDep[]= new int[16];
	protected static int intFUBus[]= new int[16];
	protected static int divBus[]= new int[16];
	protected static int mulBus[]= new int[16];
	protected static int availableIntFUBus[]= new int[16];
	protected static int availablDdivBus[]= new int[16];
	protected static int availableMulBus[]= new int[16];
	protected static boolean isDDecoded = false;
	protected static boolean StallChahiye = false; 
	protected static boolean mulStall = false; 
	protected static boolean nextMulLinedUp = false;
	protected static boolean divStall = false; 
	protected static boolean nextDivLinedUp = false;
	protected static boolean haltFlag = false;
	protected static boolean StallforPSW= false;
	protected static boolean bzstall=false;
	protected static boolean opdstall=false;
	protected static boolean stopflag=false;
	public static String instructioninWBStage;
	protected static int temploadValue;
	
	public static void main(String[] args) 
	{
		
		String file = args[0];
		
		int n;
		while (true) 
		{
			System.out.print("\n*****************************************************************");
			System.out.print("\nCommands:");
			System.out.print("\n1. Initialize ");
			System.out.print("\n2. Simulate ");
			System.out.print("\n3. Display ");
			System.out.print("\n5. Exit");
			System.out.println("\nPlease choose the Option : ");
			

			Scanner sc = new Scanner(System.in);
				int choice = sc.nextInt();
				if (choice==1||choice==2||choice==3||choice==4||choice==5) 
					{
						switch(choice)
						{
							case 1:
								Initializations.ResetMemory();
								Initializations.ReadInputFile(file);						
								break;
							case 2:
								System.out.print("Enter Number of cycles to simulate:: ");
								n = sc.nextInt();
								PipelineSemulation.pipelineSemulations(n);
								break;
								
							case 3:
								Display.displayResults();
								break;
									
							case 5:
								System.exit(0);
								System.out.println("You have successfully Exited");
			                    break;
						}
					}
				else
					{
						System.out.println("\n ***Kindly Choose the valid option***"); 
					}
		
		}
	}
	

}
