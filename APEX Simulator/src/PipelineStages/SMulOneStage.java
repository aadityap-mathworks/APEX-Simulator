package PipelineStages;

import Simulation.Simulator;

public class SMulOneStage extends Simulator 
{

	public static void executeMulOneStage()
	{	
		if (mulStageOne.size()!=0)
		{
			int add= mulStageOne.get(0).getAddress();
			String instNo= instNoWithAddress.get(add);
			System.out.println("MUL One Stage		:: ("+instNo+")"+ mulStageOne.get(0).toString());
			String instruction = mulStageOne.get(0).toString();
			String sinst[] = instruction.split("[ ,]+");
			
			String instName= mulStageOne.get(0).getInstName();
			if (instName.equals("MUL")) 
			{

				if(!mulStageOne.get(0).isWasDependent())
				{
				// logic for MUL instruction
				int source1 = mulStageOne.get(0).getValueSource1();
				int source2 = mulStageOne.get(0).getValueSource2();
				int dest = source1 * source2;
				
				mulStageOne.get(0).setValueDestn(dest);
				String mBusReg= mulStageOne.get(0).getNameDestn();
				int mregValue= mulStageOne.get(0).getValueDestn();
				String mbusRname[]= mBusReg.split("R");
				int RNo= Integer.parseInt(mbusRname[1]);
				mulBus[RNo]= mregValue;
				availableMulBus[RNo]=1;
				
				mulStageOne.get(0).setMUL1Executed(true);
				}
				
								
				else
				{
					
					String name= sinst[0];
                	String d= sinst[1];
                	String s1= sinst[2];
                	String s2= sinst[3];
                	
                	mulStageOne.get(0).setInstName(name); 
                	mulStageOne.get(0).setNameDestn(d);

    				String Dname[]= d.split("R");
    				int DNo= Integer.parseInt(Dname[1]);
    				available[DNo]=0;
    				
					String regi1[] = s1.split("#");
					int size1= regi1.length;
					if (size1==2) 
					{
						mulStageOne.get(0).setNameSource1("LITERAL");
						mulStageOne.get(0).setValueSource1(Integer.parseInt(regi1[1]));
						
					}
					else
					{	
						String Rname1[]= s1.split("R");
	    				int RNo1= Integer.parseInt(Rname1[1]);
							mulStageOne.get(0).setNameSource1(s1);
							String FU1=mulStageOne.get(0).getWhichS1Unit();
							if(FU1!=null)
							{
								if(mulStageOne.get(0).getWhichS1Unit().equals("divFU"))
								{
									mulStageOne.get(0).setValueSource1(divBus[RNo1]);
								}
								else if(mulStageOne.get(0).getWhichS1Unit().equals("intFU"))
								{
									mulStageOne.get(0).setValueSource1(intFUBus[RNo1]);
								}
								else if(mulStageOne.get(0).getWhichS1Unit().equals("mulFU"))
								{
									mulStageOne.get(0).setValueSource1(mulBus[RNo1]);
								}
							}	
							else
							{
								mulStageOne.get(0).setValueSource1(registers[RNo1]);
							}
					}

					String regi2[] = s2.split("#");
					int size2= regi2.length;
					if (size2==2) 
					{
						mulStageOne.get(0).setNameSource2("LITERAL");
						mulStageOne.get(0).setValueSource2(Integer.parseInt(regi2[1]));
					}
					else
					{

	    				String Rname2[]= s2.split("R");
	    				int RNo2= Integer.parseInt(Rname2[1]);
						
							mulStageOne.get(0).setNameSource2(s2);
							String FU2=mulStageOne.get(0).getWhichS2Unit();
							if(FU2!=null)
							{
								if(mulStageOne.get(0).getWhichS2Unit().equals("divFU"))
								{
									mulStageOne.get(0).setValueSource2(divBus[RNo2]);
								}
								else if(mulStageOne.get(0).getWhichS2Unit().equals("intFU"))
								{
									mulStageOne.get(0).setValueSource2(intFUBus[RNo2]);
								}
								else if(mulStageOne.get(0).getWhichS2Unit().equals("mulFU"))
								{
									mulStageOne.get(0).setValueSource2(mulBus[RNo2]);
								}
							}	
							else
							{
								mulStageOne.get(0).setValueSource2(registers[RNo2]);
							}
						
					}
					
					
					int source1 = mulStageOne.get(0).getValueSource1();
					int source2 = mulStageOne.get(0).getValueSource2();
					int dest = source1 * source2;
					mulStageOne.get(0).setValueDestn(dest);
					
					String mBusReg= mulStageOne.get(0).getNameDestn();
					int mregValue= mulStageOne.get(0).getValueDestn();
					String mbusRname[]= mBusReg.split("R");
					int RNo= Integer.parseInt(mbusRname[1]);
					mulBus[RNo]= mregValue;
					availableMulBus[RNo]=1;

					mulStageOne.get(0).setMUL1Executed(true);

				}
			} 
		}
		else
		{
			System.out.println("MUL One Stage		:: Empty");
		}
	}
	
}
