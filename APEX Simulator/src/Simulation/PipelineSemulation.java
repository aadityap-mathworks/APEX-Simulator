package Simulation;
import PipelineStages.SDecodeStage;
import PipelineStages.SDivFourStage;
import PipelineStages.SDivOneStage;
import PipelineStages.SDivThreeStage;
import PipelineStages.SDivTwoStage;
import PipelineStages.SFetchStage;
import PipelineStages.SIntegerFUStage;
import PipelineStages.SMemoryStage;
import PipelineStages.SMulOneStage;
import PipelineStages.SMulTwoStage;
import PipelineStages.SWriteBackStage;

public class PipelineSemulation extends Simulator
{
	public static void pipelineSemulations(int cycles)
	{	
		PC=4000;
		for (int i = 0; i < cycles; i++) 
		{
			System.out.println("\nCYCLE -->" + (i + 1));
			
			// Fetch Stage
			if(!opdstall)
			{
				if(!haltFlag)
				{	
					if(!(divStall^nextDivLinedUp))
					{
						if(!(mulStall^nextMulLinedUp))
						{	
							if (!StallChahiye) 
							{
								if (fetchStage.size() == 0) 
								{
									if (instWithAddress.get(PC) != null) 
									{
										
										fetchStage.add(instWithAddress.get(PC));
										SFetchStage.ExecuteFetch();
										PC = PC + 4;
								
										//continue;
									}
								} 
								else 
								{
									if (instWithAddress.get(PC) != null) 
									{
										fetchStage.add(instWithAddress.get(PC));
										
										PC = PC + 4;
									}
									if (fetchStage.size() > 0) 
									{
										decodeStage.add(fetchStage.get(0));						
										fetchStage.remove(0);
										SFetchStage.ExecuteFetch();
									}
								}
							}
								else
								{
									if(fetchStage.size()==0)
									{
										System.out.println("Fetch Stage 		:: Empty");
									}
									else
									{
										int add= fetchStage.get(0).getAddress();
										String instNo= instNoWithAddress.get(add);
										System.out.println("Fetch Stage 		:: ("+instNo+") "+ fetchStage.get(0));
									}
								}
						}
							else
							{
								if(fetchStage.size()==0)
								{
									System.out.println("Fetch Stage 		:: Empty");
								}
								else
								{
									int add= fetchStage.get(0).getAddress();
									String instNo= instNoWithAddress.get(add);
									System.out.println("Fetch Stage 		:: ("+instNo+") "+ fetchStage.get(0));
								}
							}
					}
						else
						{
							if(fetchStage.size()==0)
							{
								System.out.println("Fetch Stage 		:: Empty");
							}
							else
							{
								int add= fetchStage.get(0).getAddress();
								String instNo= instNoWithAddress.get(add);
								System.out.println("Fetch Stage 		:: ("+instNo+") "+ fetchStage.get(0));
							}
						}
				}
					else
					{
						if(fetchStage.size()==0)
						{
							System.out.println("Fetch Stage 		:: Empty");
						}
						else
						{
							int add= fetchStage.get(0).getAddress();
							String instNo= instNoWithAddress.get(add);
							System.out.println("Fetch Stage 		:: ("+instNo+") "+ fetchStage.get(0));
						}
					}
			}
			else
			{
				if(fetchStage.size()==0)
				{
					System.out.println("Fetch Stage 		:: Empty");
				}
				else
				{
					int add= fetchStage.get(0).getAddress();
					String instNo= instNoWithAddress.get(add);
					System.out.println("Fetch Stage 		:: ("+instNo+") "+ fetchStage.get(0));
				}
			}
			
			//decode stage
			if(!opdstall)
			{
				if(!(divStall^nextDivLinedUp))
				{
					if(!(mulStall^nextMulLinedUp))
					{	
						if (!StallChahiye)
						{	
							if (decodeStage.size() == 1 && !decodeStage.get(0).isDecoded()) 
							{
								SDecodeStage.executeDecodeStage();
								//continue;
							} 
							
							else if (decodeStage.size() > 0) 
							{		
			
									if (decodeStage.get(0).getInstName().equals("MUL"))
									{
										mulStageOne.add(decodeStage.get(0));
									}
									else if(decodeStage.get(0).getInstName().equals("DIV")||decodeStage.get(0).getInstName().equals("HALT"))
									{
										divStageOne.add(decodeStage.get(0));
									}
									
									else
									{
										integerFUStage.add(decodeStage.get(0));
									}
									decodeStage.remove(0);
									SDecodeStage.executeDecodeStage();
										
							}
							else
							{
								if (decodeStage.size()>0) 
								{
									int add= decodeStage.get(0).getAddress();
									String instNo= instNoWithAddress.get(add);
									System.out.println("Decode Stage 		:: ("+instNo+") "+ decodeStage.get(0).toString());
								}
								else
								{
									System.out.println("Decode Stage 		:: Empty");
								}
							}
		
						}
						else
						{
							if (decodeStage.size()>0) 
							{
								int add= decodeStage.get(0).getAddress();
								String instNo= instNoWithAddress.get(add);
								System.out.println("Decode Stage 		:: ("+instNo+") "+ decodeStage.get(0).toString());
							}
							else
							{
								System.out.println("Decode Stage 		:: Empty");
							}
						}
					}
					else
					{
						if (decodeStage.size()>0) 
						{
							int add= decodeStage.get(0).getAddress();
							String instNo= instNoWithAddress.get(add);
							System.out.println("Decode Stage 		:: ("+instNo+") "+ decodeStage.get(0).toString());
						}
						else
						{
							System.out.println("Decode Stage 		:: Empty");
						}
					}
				}
				else
				{
					if (decodeStage.size()>0) 
					{
						int add= decodeStage.get(0).getAddress();
						String instNo= instNoWithAddress.get(add);
						System.out.println("Decode Stage 		:: ("+instNo+") "+ decodeStage.get(0).toString());
					}
					else
					{
						System.out.println("Decode Stage 		:: Empty");
					}
				}
			}
			else
			{
				if (decodeStage.size()>0) 
				{
					int add= decodeStage.get(0).getAddress();
					String instNo= instNoWithAddress.get(add);
					System.out.println("Decode Stage 		:: ("+instNo+") "+ decodeStage.get(0).toString());
				}
				else
				{
					System.out.println("Decode Stage 		:: Empty");
				}
			}
	
			// IntFU stage
			if(!divStall)
			{
				if(!mulStall)
				{	
					if (integerFUStage.size() == 1 && !integerFUStage.get(0).isIntFUExecuted()) 
					{
							SIntegerFUStage.executeIntegerFUStage();
		
					} 
					else if (integerFUStage.size() > 0) 
					{	
						memoryStage.add(integerFUStage.get(0));
						integerFUStage.remove(0);
						SIntegerFUStage.executeIntegerFUStage();
						
					}
					else
					{
						if(integerFUStage.size()==0)
						{
							System.out.println("Integer FU Stage 	:: Empty");
						}
						else
						{
							int add= integerFUStage.get(0).getAddress();
							String instNo= instNoWithAddress.get(add);
							System.out.println("Integer FU Stage 	:: ("+instNo+") "+ integerFUStage.get(0).toString());
						}
					}
				}
				else
				{
					if(integerFUStage.size()==0)
						{
							System.out.println("Integer FU Stage 	:: Empty");
						}
						else
						{
							int add= integerFUStage.get(0).getAddress();
							String instNo= instNoWithAddress.get(add);
							System.out.println("Integer FU Stage 	:: ("+instNo+") "+ integerFUStage.get(0).toString());
						}
					
				}
			}
			else
			{
				if(integerFUStage.size()==0)
				{
					System.out.println("Integer FU Stage 	:: Empty");
				}
				else
				{
					int add= integerFUStage.get(0).getAddress();
					String instNo= instNoWithAddress.get(add);
					System.out.println("Integer FU Stage 	:: ("+instNo+") "+ integerFUStage.get(0).toString());
				}
			}
			
	
			
			//MUL One Stage
			if(!divStall)
			{	
				if (mulStageOne.size()==1 && !mulStageOne.get(0).isMUL1Executed())
				{
					SMulOneStage.executeMulOneStage();
	//				if ((mulStageTwo.size() == 0)&& (memoryStage.size() == 0)&& (writeBackStage.size() == 0))
	//					continue;
				}
				else if (mulStageOne.size()>0)
				{
					mulStageTwo.add(mulStageOne.get(0));
					mulStageOne.remove(0);
					SMulOneStage.executeMulOneStage();
				}
				else
				{
					if(mulStageOne.size()==0)
					{
						System.out.println("MUL One Stage		:: Empty");
					}
					else
					{
						int add= mulStageOne.get(0).getAddress();
						String instNo= instNoWithAddress.get(add);
						System.out.println("MUL One Stage		:: ("+instNo+")"+ mulStageOne.get(0).toString());
					}
				}
			}
			else
			{
				if(mulStageOne.size()==0)
				{
					System.out.println("MUL One Stage		:: Empty");
				}
				else
				{
					int add= mulStageOne.get(0).getAddress();
					String instNo= instNoWithAddress.get(add);
					System.out.println("MUL One Stage		:: ("+instNo+")"+ mulStageOne.get(0).toString());
				}
			}
			
			//mulTwo Stage
			if(!divStall)
			{
				if (mulStageTwo.size()==1 && !mulStageTwo.get(0).isMUL2Executed())
				{
					SMulTwoStage.executeMulTwoStage();
	//				if ((memoryStage.size() == 0)&& (writeBackStage.size() == 0))
	//					continue;
				}
				else if (mulStageTwo.size()>0)
				{
					
					memoryStage.add(mulStageTwo.get(0));
					mulStageTwo.remove(0);
					SMulTwoStage.executeMulTwoStage();
//					mulStall=false;
//					nextMulLinedUp=false;
				}
				else
				{
					if(mulStageTwo.size()==0)
					{
						System.out.println("MUL Two Stage 		:: Empty");
					}
					else
					{
						int add= mulStageTwo.get(0).getAddress();
						String instNo= instNoWithAddress.get(add);
						System.out.println("MUL Two Stage 		:: ("+instNo+") "+ mulStageTwo.get(0).toString());
					}
				}
				
				if(mulStageTwo.size()==0)
				{
					mulStall=false;
					nextMulLinedUp=false;
				}
			}
			else
			{
				if(mulStageTwo.size()==0)
				{
					System.out.println("MUL Two Stage 		:: Empty");
				}
				else
				{
					int add= mulStageTwo.get(0).getAddress();
					String instNo= instNoWithAddress.get(add);
					System.out.println("MUL Two Stage 		:: ("+instNo+") "+ mulStageTwo.get(0).toString());
				}
			}
			
			//DIV One Stage
			if (divStageOne.size()==1 && !divStageOne.get(0).isDIV1Executed())
			{
				SDivOneStage.executeDivOneStage();
				//if ((divStageTwo.size() == 0)&& (memoryStage.size() == 0)&& (writeBackStage.size() == 0))
					//continue;
			}
			else if (divStageOne.size()>0)
			{
				divStageTwo.add(divStageOne.get(0));
				divStageOne.remove(0);
				SDivOneStage.executeDivOneStage();
			}
			else
			{
				System.out.println("DIV One Stage		:: Empty");
			}
			
			//DIV Two Stage
			if (divStageTwo.size()==1 && !divStageTwo.get(0).isDIV2Executed())
			{
				SDivTwoStage.executeDivTwoStage();
				//if ((divStageTwo.size() == 0)&& (memoryStage.size() == 0)&& (writeBackStage.size() == 0))
					//continue;
			}
			else if (divStageTwo.size()>0)
			{
				divStageThree.add(divStageTwo.get(0));
				divStageTwo.remove(0);
				SDivTwoStage.executeDivTwoStage();			
				
			}
			else
			{
				System.out.println("DIV Two Stage		:: Empty");
			}
			
			//DIV Three Stage
			if (divStageThree.size()==1 && !divStageThree.get(0).isDIV3Executed())
			{
				SDivThreeStage.executeDivThreeStage();
				//if ((divStageTwo.size() == 0)&& (memoryStage.size() == 0)&& (writeBackStage.size() == 0))
					//continue;
			}
			else if (divStageThree.size()>0)
			{
				divStageFour.add(divStageThree.get(0));
				divStageThree.remove(0);
				SDivThreeStage.executeDivThreeStage();			
				
			}
			else
			{
				System.out.println("DIV Three Stage		:: Empty");
			}
			
			
			//DIV Four Stage
			if (divStageFour.size()==1 && !divStageFour.get(0).isDIV4Executed())
			{
				SDivFourStage.executeDivFourStage();
				//if ((divStageTwo.size() == 0)&& (memoryStage.size() == 0)&& (writeBackStage.size() == 0))
					//continue;
			}
			else if (divStageFour.size()>0)
			{
				memoryStage.add(divStageFour.get(0));
				divStageFour.remove(0);
				SDivFourStage.executeDivFourStage();
				if (divStageFour.size()==0) 
				{
					
					divStall=false;
					nextDivLinedUp=false;
				}
			}
			else
			{
				System.out.println("DIV Four Stage		:: Empty");
			}
			
			
			// MemoryStage
			if (memoryStage.size() == 1 && !memoryStage.get(0).isMemoryExecuted())
			{
			
				SMemoryStage.executeMemoryStage();

			} else if (memoryStage.size() > 0) {
				writeBackStage.add(memoryStage.get(0));
				memoryStage.remove(0);
				SMemoryStage.executeMemoryStage();
			}
			else
			{
				System.out.println("Memory Stage 		:: Empty");
			}

			
			// WriteBack
			if (writeBackStage.size() == 1) {
				SWriteBackStage.executeWriteBackStage();
				writeBackStage.remove(0);
				if(stopflag)
				{
					i=cycles;
				}
			}
			else
			{
				System.out.println("Writeback Stage 	:: Empty");
							
			}

			
			
		}
		
	}
}	

