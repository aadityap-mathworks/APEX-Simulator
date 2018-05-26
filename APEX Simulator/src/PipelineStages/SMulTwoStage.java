package PipelineStages;

import Simulation.Simulator;

public class SMulTwoStage extends Simulator{

	public static void executeMulTwoStage()
	{
		if (mulStageTwo.size() > 0) {
			int add= mulStageTwo.get(0).getAddress();
			String instNo= instNoWithAddress.get(add);
			System.out.println("MUL Two Stage 		:: ("+instNo+") "+ mulStageTwo.get(0).toString());
			if(integerFUStage.size()>0)
			{
				
					mulStall=true;
				
				if(decodeStage.size()>0)
				{	
					if(decodeStage.get(0).getInstName().equals("MUL"))
					{
						nextMulLinedUp= true;
					}
				}	
			}
			String dBusReg= mulStageTwo.get(0).getNameDestn();
			String dbusRname[]= dBusReg.split("R");
			int RNo= Integer.parseInt(dbusRname[1]);
			availableMulBus[RNo]=0;
			if(decodeStage.size()>0)
			{
				if(decodeStage.get(0).isWasDependent())
						{
							String s1 = decodeStage.get(0).getNameSource1();
							String s2 = decodeStage.get(0).getNameSource2();
							if(dBusReg.equals(s2)||dBusReg.equals(s1))
							{
								registers[RNo]=mulBus[RNo];
								StallChahiye=false;
							}
						}
			}
						
			mulStageTwo.get(0).setMUL2Executed(true);
		}
		else
		{
			System.out.println("MUL Two Stage		:: Empty");
		}
	}
}
