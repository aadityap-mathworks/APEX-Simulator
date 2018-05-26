package PipelineStages;

import Simulation.Simulator;

public class SMemoryStage extends Simulator {
	
	public static void executeMemoryStage()
	{
		
		if (memoryStage.size() > 0) {
			int add= memoryStage.get(0).getAddress();
			String instNo= instNoWithAddress.get(add);
			System.out.println("Memory Stage 		:: ("+instNo+") "+ memoryStage.get(0).toString());
			String instName= memoryStage.get(0).getInstName();
			
//			String dBusReg= memoryStage.get(0).getNameDestn();
//
//			String dbusRname[]= dBusReg.split("R");
//			int RNo= Integer.parseInt(dbusRname[1]);
//			availablDdivBus[RNo]=0;
//			availableIntFUBus[RNo]=0;
//			availableMulBus[RNo]=0;
			
			
			if (instName.equals("LOAD")) 
			{
				memoryStage.get(0).setValueDestn(Memory[memoryStage.get(0).getValueDestn()]);
				
				//forwardGeneratedResult(memoryStageList.get(0));
			}
			if (instName.equals("STORE")) 
			{
				int source1;
				//if (forwardingLatch.get(memoryStageList.get(0).getSource1().getOperandName()).getValidFlag() == 1) {
				//	source1 = forwardingLatch.get(memoryStageList.get(0).getSource1().getOperandName()).getValue();
				//	forwardingLatch.get(memoryStageList.get(0).getSource1().getOperandName()).setValidFlag(0);
				//} else
					source1 = memoryStage.get(0).getValueSource1();

				Memory[memoryStage.get(0).getValueDestn()] = source1;
			}
			memoryStage.get(0).setMemoryExecuted(true);
		}
		else
		{
			System.out.println("Memory Stage 		:: Empty");
		}
	}

}
