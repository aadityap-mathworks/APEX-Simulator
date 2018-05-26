package PipelineStages;

import Simulation.Simulator;

public class SDivTwoStage extends Simulator
{
	public static void executeDivTwoStage()
	{
		if (divStageTwo.size() > 0) 
		{
			int add= divStageTwo.get(0).getAddress();
			String instNo= instNoWithAddress.get(add);
			System.out.println("div Two Stage 		:: ("+instNo+") "+ divStageTwo.get(0).toString());
			if(divStageTwo.get(0).getInstName().equals("HALT"))
			{
				divStageTwo.get(0).setDIV2Executed(true);
			}
//			if(integerFUStage.size()>0)
//			{
//				if(mulStageTwo.get(0).getAddress()< integerFUStage.get(0).getAddress())
//				{
//					mulStall=true;
//				}
//				
//				if(decodeStage.get(0).getInstName().equals("MUL"))
//				{
//					nextMulLinedUp= true;
//				}
//			}
			divStageTwo.get(0).setDIV2Executed(true);

		}
		else
		{
			System.out.println("div Two Stage 		:: Empty");
		}
	}
}
