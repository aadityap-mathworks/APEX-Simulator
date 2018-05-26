package PipelineStages;

import Simulation.Simulator;

public class SWriteBackStage extends Simulator
{

	public static void executeWriteBackStage() 
	{
		
		if (writeBackStage.size() > 0)
		{
			int add= writeBackStage.get(0).getAddress();
			String instNo= instNoWithAddress.get(add);
			System.out.println("Writeback Stage 	:: ("+instNo+") "+ writeBackStage.get(0).toString());
			
			writeBackStage.get(0).setDecoded(false);
			writeBackStage.get(0).setIntFUExecuted(false);
			writeBackStage.get(0).setMemoryExecuted(false);
			writeBackStage.get(0).setDIV1Executed(false);
			writeBackStage.get(0).setDIV2Executed(false);
			writeBackStage.get(0).setDIV3Executed(false);
			writeBackStage.get(0).setDIV4Executed(false);
			writeBackStage.get(0).setMUL1Executed(false);
			writeBackStage.get(0).setMUL2Executed(false);
			instructioninWBStage =  writeBackStage.get(0).toString();
			String instName[]= instructioninWBStage.split("[ ,]+");
			
			if (writeBackStage.get(0).getPSW()==true) 
			{
				writeBackStage.get(0).setPSW(false);
				StallChahiye = false;
			}
				
			if (instName[0].equals("ADD")|| instName[0].equals("SUB")||instName[0].equals("MUL")||instName[0].equals("DIV")||instName[0].equals("LOAD")
					||instName[0].equals("OR")||instName[0].equals("AND")||instName[0].equals("XOR")||instName[0].equals("EXOR")||instName[0].equals("JAL")) 
			{
				if(instName[0].equals("LOAD"))
				{
					
					String regName= writeBackStage.get(0).getNameDestn();
					regValue= temploadValue;
					String Rname[]= regName.split("R");
					int RNo= Integer.parseInt(Rname[1]);
					registers[RNo]= regValue;
							
						if(writeBackStage.get(0).isOPDependent())
						{
							available[RNo]=1;
							writeBackStage.get(0).setOPDependent(false);
						}
					else
					{
						available[RNo]=1;
					}
						
						if(OPDep[RNo]==1)
						{
							OPDep[RNo]=0;
							if(decodeStage.size()>0 
									&&((decodeStage.get(0).getNameDestn().equals(decodeStage.get(0).getNameSource1()))
											||decodeStage.get(0).getNameDestn().equals(decodeStage.get(0).getNameSource2())))
							{
								available[RNo]=1;
							}
							else
							{
								available[RNo]=0;
							}
							
							opdstall=false;
						}
					
					if(dependent[RNo]==1 && available[RNo]==1)
					{
						int depc= decodeStage.get(0).getDepcount();
						depc=depc-1;
						decodeStage.get(0).setDepcount(depc);
						if(depc==0)
						{	
							StallChahiye=false;	
						}
						dependent[RNo]=0;
					}
						
				}
				else
				{
					String regName= writeBackStage.get(0).getNameDestn();
					 regValue= writeBackStage.get(0).getValueDestn();
					String Rname[]= regName.split("R");
					int RNo= Integer.parseInt(Rname[1]);
					registers[RNo]= regValue;
					
					if(writeBackStage.get(0).isOPDependent())
					{
						available[RNo]=1;
						writeBackStage.get(0).setOPDependent(false);
					}
					else
					{
						available[RNo]=1;
					}
					
					if(OPDep[RNo]==1)
					{
						OPDep[RNo]=0;
						if(decodeStage.size()>0 
								&&((decodeStage.get(0).getNameDestn().equals(decodeStage.get(0).getNameSource1()))
										||decodeStage.get(0).getNameDestn().equals(decodeStage.get(0).getNameSource2())))
						{
							available[RNo]=1;
						}
						else
						{
							available[RNo]=0;
						}
						opdstall=false;
					}
					if(dependent[RNo]==1 && available[RNo]==1)
					{
						int depc;
						if(decodeStage.size()>0)
						{
							depc= decodeStage.get(0).getDepcount();
							depc=depc-1;
							decodeStage.get(0).setDepcount(depc);	
						}
						else
						{
							depc=0;
								
						}
						
						if((depc==0))
						{	
							StallChahiye=false;	
						}
						dependent[RNo]=0;
						if(decodeStage.size()>0 
								&&((decodeStage.get(0).getNameDestn().equals(decodeStage.get(0).getNameSource1()))
										||decodeStage.get(0).getNameDestn().equals(decodeStage.get(0).getNameSource2())))
						{
							available[RNo]=0;
						}
						
					}
				}
				
				
				
				if(instName[0].equals("ADD")|| instName[0].equals("SUB")||instName[0].equals("MUL"))
				{
					if(regValue==0)
					{
						zeroflag=0;
					}
					else
					{
						zeroflag=1;
					}
				}
				
				
			}
			
			if(instName[0].equals("BNZ")||instName[0].equals("BZ"))
			{

			}
			
			
			if (instName[0].equals("MOVC")) {
				String regName= writeBackStage.get(0).getNameDestn();
				regValue= writeBackStage.get(0).getValueDestn();
				String Rname[]= regName.split("R");
				int RNo= Integer.parseInt(Rname[1]);
				registers[RNo]= regValue;
				if(writeBackStage.get(0).isOPDependent())
				{
					available[RNo]=1;
					writeBackStage.get(0).setOPDependent(false);
				}
				else
				{
					available[RNo]=1;
				}
				
				if(OPDep[RNo]==1)
				{
					OPDep[RNo]=0;
					available[RNo]=0;
					opdstall=false;
				}
				if(dependent[RNo]==1)
				{
					int depc= decodeStage.get(0).getDepcount();
					depc=depc-1;
					decodeStage.get(0).setDepcount(depc);
					if(depc==0)
					{	
						StallChahiye=false;
					
					}
					
					dependent[RNo]=0;
				}
			}
			
			if (instName[0].equals("HALT")) 
			{
				
				stopflag= true;
			}
			if(decodeStage.size()==0 && fetchStage.size()==0 && integerFUStage.size()==0 && mulStageOne.size()==0
					&& mulStageTwo.size()==0 && divStageOne.size()==0 && divStageTwo.size()==0 && divStageThree.size()==0
					&& divStageFour.size()==0 && memoryStage.size()==0)
			{
				stopflag= true;
			}
			
		}
		else
		{
			System.out.println("Writeback Stage 	:: Empty");
		}
		
	}
	
}
