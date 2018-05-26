package PipelineStages;

import Simulation.Simulator;

public class SDivOneStage extends Simulator 
{
	public static void executeDivOneStage()
	{
		if (divStageOne.size()!=0)
		{
			int add= divStageOne.get(0).getAddress();
			String instNo= instNoWithAddress.get(add);
			System.out.println("DIV One Stage		:: ("+instNo+") "+ divStageOne.get(0).toString());
			String instruction = divStageOne.get(0).toString();
			String sinst[] = instruction.split("[ ,]+");
			
			String instName= divStageOne.get(0).getInstName();
			if(instName.equals("HALT"))
			{
				divStageOne.get(0).setDIV1Executed(true);
			}
			if (instName.equals("DIV")) 
			{
				if(!divStageOne.get(0).isWasDependent())
				{
				// logic for div instruction
				int source1 = divStageOne.get(0).getValueSource1();
				int source2 = divStageOne.get(0).getValueSource2();
				int dest = source1 / source2;
				divStageOne.get(0).setValueDestn(dest);

				String dBusReg= divStageOne.get(0).getNameDestn();
				int dregValue= divStageOne.get(0).getValueDestn();
				String dbusRname[]= dBusReg.split("R");
				int RNo= Integer.parseInt(dbusRname[1]);
				divBus[RNo]= dregValue;
				availablDdivBus[RNo]=1;
				
				divStageOne.get(0).setDIV1Executed(true);
				}
				else
				{
					
					String name= sinst[0];
                	String d= sinst[1];
                	String s1= sinst[2];
                	String s2= sinst[3];
                	
                	divStageOne.get(0).setInstName(name); 
                	divStageOne.get(0).setNameDestn(d);

    				String Dname[]= d.split("R");
    				int DNo= Integer.parseInt(Dname[1]);
    				available[DNo]=0;
    				
					String regi1[] = s1.split("#");
					int size1= regi1.length;
					if (size1==2) 
					{
						divStageOne.get(0).setNameSource1("LITERAL");
						divStageOne.get(0).setValueSource1(Integer.parseInt(regi1[1]));
						
					}
					else
					{	
						String Rname1[]= s1.split("R");
	    				int RNo1= Integer.parseInt(Rname1[1]);
							divStageOne.get(0).setNameSource1(s1);
							String FU1=divStageOne.get(0).getWhichS1Unit();
							if(FU1!=null)
							{
								if(divStageOne.get(0).getWhichS1Unit().equals("divFU"))
								{
									divStageOne.get(0).setValueSource1(divBus[RNo1]);
								}
								else if(divStageOne.get(0).getWhichS1Unit().equals("intFU"))
								{
									divStageOne.get(0).setValueSource1(intFUBus[RNo1]);
								}
								else if(divStageOne.get(0).getWhichS1Unit().equals("mulFU"))
								{
									divStageOne.get(0).setValueSource1(mulBus[RNo1]);
								}
							}	
							else
							{
								divStageOne.get(0).setValueSource1(registers[RNo1]);
							}
						
					}

					String regi2[] = s2.split("#");
					int size2= regi2.length;
					if (size2==2) 
					{
						divStageOne.get(0).setNameSource2("LITERAL");
						divStageOne.get(0).setValueSource2(Integer.parseInt(regi2[1]));
					}
					else
					{

	    				String Rname2[]= s2.split("R");
	    				int RNo2= Integer.parseInt(Rname2[1]);
						
							divStageOne.get(0).setNameSource2(s2);
							String FU2=divStageOne.get(0).getWhichS2Unit();
							if(FU2!=null)
							{
								if(divStageOne.get(0).getWhichS2Unit().equals("divFU"))
								{
									divStageOne.get(0).setValueSource2(divBus[RNo2]);
								}
								else if(divStageOne.get(0).getWhichS2Unit().equals("intFU"))
								{
									divStageOne.get(0).setValueSource2(intFUBus[RNo2]);
								}
								else if(divStageOne.get(0).getWhichS2Unit().equals("mulFU"))
								{
									divStageOne.get(0).setValueSource2(mulBus[RNo2]);
								}
							}	
							else
							{
								divStageOne.get(0).setValueSource2(registers[RNo2]);
							}
						
					}
					
					
					int source1 = divStageOne.get(0).getValueSource1();
					int source2 = divStageOne.get(0).getValueSource2();
					int dest = source1 * source2;
					divStageOne.get(0).setValueDestn(dest);
					
					if(!divStageOne.get(0).getInstName().equals("HALT"))
					{
						String dBusReg= divStageOne.get(0).getNameDestn();
						int dregValue= divStageOne.get(0).getValueDestn();
						String dbusRname[]= dBusReg.split("R");
						int RNo= Integer.parseInt(dbusRname[1]);
						divBus[RNo]= dregValue;
						availablDdivBus[RNo]=1;
					}
					divStageOne.get(0).setDIV1Executed(true);

				}
			} 
		}
		
		else
		{
			System.out.println("div One Stage 		:: Empty");
		}
		
	}
	
	
}
