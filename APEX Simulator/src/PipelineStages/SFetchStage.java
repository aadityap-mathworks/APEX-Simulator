package PipelineStages;

import Simulation.Simulator;

public class SFetchStage extends Simulator
{
	public static void ExecuteFetch()
	{
		if (fetchStage.size() > 0)
		{
			int add= fetchStage.get(0).getAddress();
			String instNo= instNoWithAddress.get(add);
			System.out.println("Fetch Stage 		:: ("+instNo+") "+ fetchStage.get(0));
			
		}
		else {
			System.out.println("Fetch Stage 		:: Empty");
		}
	}

}
