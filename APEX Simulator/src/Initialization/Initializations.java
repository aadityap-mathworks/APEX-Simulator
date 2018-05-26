package Initialization;

import PipelineStages.SDecodeStage;
import Simulation.Simulator;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class Initializations extends Simulator {
	
	//function to read the input file
	public static void ReadInputFile(String fileName) 
	{
		
		//ArrayList<String> instWithAddress = new ArrayList<String>();
		System.out.println("Reading the input file\n");
		//String fileName = "src/inputfile.txt";
		try
		{
		File file = new File(fileName);	
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		String currentline;
		
		while ((currentline = bufferedReader.readLine()) != null) 
			{
				SDecodeStage instruction = new SDecodeStage();
				instruction.setAddress(PC);
				instruction.setinstuction(currentline);
				instWithAddress.put(PC, instruction); 
				instNoWithAddress.put(PC, "I"+instNum);
				System.out.println(PC+" : ("+instNoWithAddress.get(PC)+")"+instWithAddress.get(PC));
				PC = PC+4;
				instNum=instNum+1;
				
			}
		bufferedReader.close();
		}
		
		catch (FileNotFoundException ex)
	        {
	            System.out.println("Cannot find the file '" + fileName + "'");
	        } 
		catch (IOException ex)
	        {
	            System.out.println("Error occureed while reading the file '" + fileName + "'");
	
	        }
	}

	public static void ResetMemory() 
	{		
    	fetchStage.clear();
    	decodeStage.clear();
    	mulStageOne.clear();
    	mulStageTwo.clear();
    	integerFUStage.clear();
    	memoryStage.clear();
    	writeBackStage.clear();
        
    	
        for (int y = 0; y < 16; y++)
        {
        	registers[y] = 0;
        	available[y] = 1;
        }
    	
        for (int i = 0; i < 3999; i++)
        {
            Memory[i] = 0;
        }
		
		System.out.println("\nInitialized the program counter to "+PC+"\n");
	}

}
