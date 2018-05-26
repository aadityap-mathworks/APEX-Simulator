package PipelineStages;

import Simulation.Simulator;

public class SDivFourStage extends Simulator
{
	public static void executeDivFourStage()
	{
		if (divStageFour.size() > 0) {
			int add= divStageFour.get(0).getAddress();
			String instNo= instNoWithAddress.get(add);
			System.out.println("div Four Stage 		:: ("+instNo+") "+ divStageFour.get(0).toString());
			if(divStageFour.get(0).getInstName().equals("HALT"))
			{
				divStageFour.get(0).setDIV4Executed(true);
				
			}
			if(integerFUStage.size()>0)
			{
				divStall=true;
				if(decodeStage.size()>0)
				{	
					if(decodeStage.get(0).getInstName().equals("DIV"))
					{
						nextDivLinedUp= true;
					}
				}	
			}
			
			else if(mulStageTwo.size()>0)
			{
				divStall=true;
				if(decodeStage.size()>0)
				{	
					if(decodeStage.get(0).getInstName().equals("DIV"))
					{
						nextDivLinedUp= true;
					}
				}	
			}

			if(!divStageFour.get(0).getInstName().equals("HALT"))
			{
				
				String dBusReg= divStageFour.get(0).getNameDestn();
				String dbusRname[]= dBusReg.split("R");
				int RNo= Integer.parseInt(dbusRname[1]);
				availablDdivBus[RNo]=0;
				if(decodeStage.size()>0)
				{
					if(decodeStage.get(0).isWasDependent())
							{
								String s1 = decodeStage.get(0).getNameSource1();
								String s2 = decodeStage.get(0).getNameSource2();
								if(dBusReg.equals(s2)||dBusReg.equals(s1))
								{
									registers[RNo]=divBus[RNo];
									StallChahiye=false;
								}
							}
				}
			}
			divStageFour.get(0).setDIV4Executed(true);

		}
		else
		{
			System.out.println("div Four Stage 		:: Empty");
		}
	}
}
