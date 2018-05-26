package PipelineStages;

import Simulation.Simulator;

public class SDivThreeStage extends Simulator
{
	public static void executeDivThreeStage()
	{
		if (divStageThree.size() > 0) {
			int add= divStageThree.get(0).getAddress();
			String instNo= instNoWithAddress.get(add);
			System.out.println("div Three Stage 	:: ("+instNo+") "+ divStageThree.get(0).toString());
			if(divStageThree.get(0).getInstName().equals("HALT"))
			{
				divStageThree.get(0).setDIV3Executed(true);
			}
			divStageThree.get(0).setDIV3Executed(true);

		}
		else
		{
			System.out.println("div Three Stage 	:: Empty");
		}
	}
}
