package PipelineStages;


import Simulation.Simulator;

public class SIntegerFUStage extends Simulator
{
	public static void executeIntegerFUStage() 
	{
		if (integerFUStage.size() > 0) 
		{
		
			//String instruction = integerFUStage.get(0).toString();
			String instName= integerFUStage.get(0).getInstName();
			String instruction = integerFUStage.get(0).toString();
			String sinst[] = instruction.split("[ ,]+");
			int source1, source2;
			// check for instruction type
			if (instName.equals("ADD")) 
			{
				if(!integerFUStage.get(0).isWasDependent())
				{
				// logic for ADD instruction
				source1 = integerFUStage.get(0).getValueSource1();
				source2 = integerFUStage.get(0).getValueSource2();
				int dest = source1 + source2;
				integerFUStage.get(0).setValueDestn(dest);
				}
				else
				{
					String name= sinst[0];
                	String d= sinst[1];
                	String s1= sinst[2];
                	String s2= sinst[3];
                	
                	integerFUStage.get(0).setInstName(name); 
                	integerFUStage.get(0).setNameDestn(d);

    				String Dname[]= d.split("R");
    				int DNo= Integer.parseInt(Dname[1]);
    				available[DNo]=0;
    				
					String regi1[] = s1.split("#");
					int size1= regi1.length;
					if (size1==2) 
					{
						integerFUStage.get(0).setNameSource1("LITERAL");
						integerFUStage.get(0).setValueSource1(Integer.parseInt(regi1[1]));
						
					}
					else
					{	
						String Rname1[]= s1.split("R");
	    				int RNo1= Integer.parseInt(Rname1[1]);
							integerFUStage.get(0).setNameSource1(s1);
							String FU1=integerFUStage.get(0).getWhichS1Unit();
							if(FU1!=null)
							{
								if(integerFUStage.get(0).getWhichS1Unit().equals("divFU"))
								{
									integerFUStage.get(0).setValueSource1(divBus[RNo1]);
								}
								else if(integerFUStage.get(0).getWhichS1Unit().equals("intFU"))
								{
									integerFUStage.get(0).setValueSource1(intFUBus[RNo1]);
								}
								else if(integerFUStage.get(0).getWhichS1Unit().equals("mulFU"))
								{
									integerFUStage.get(0).setValueSource1(mulBus[RNo1]);
								}
							}
							else
							{
								integerFUStage.get(0).setValueSource1(registers[RNo1]);
							}
						
					}

					String regi2[] = s2.split("#");
					int size2= regi2.length;
					if (size2==2) 
					{
						integerFUStage.get(0).setNameSource2("LITERAL");
						integerFUStage.get(0).setValueSource2(Integer.parseInt(regi2[1]));
					}
					else
					{

	    				String Rname2[]= s2.split("R");
	    				int RNo2= Integer.parseInt(Rname2[1]);
						
							integerFUStage.get(0).setNameSource2(s2);
							String FU2=integerFUStage.get(0).getWhichS2Unit();
							if(FU2!=null)
							{
								if(integerFUStage.get(0).getWhichS2Unit().equals("divFU"))
								{
									integerFUStage.get(0).setValueSource2(divBus[RNo2]);
								}
								else if(integerFUStage.get(0).getWhichS2Unit().equals("intFU"))
								{
									integerFUStage.get(0).setValueSource2(intFUBus[RNo2]);
								}
								else if(integerFUStage.get(0).getWhichS2Unit().equals("mulFU"))
								{
									integerFUStage.get(0).setValueSource2(mulBus[RNo2]);
								}
							}
							else
							{
								integerFUStage.get(0).setValueSource2(registers[RNo2]);
							}
						
					}
					
					source1 = integerFUStage.get(0).getValueSource1();
					source2 = integerFUStage.get(0).getValueSource2();
					int dest = source1 + source2;
					integerFUStage.get(0).setValueDestn(dest);
					
					
				}
			} 
			else if (instName.equals("SUB")) {
				// logic for SUB instruction
				if(!integerFUStage.get(0).isWasDependent())
				{	
				source1 = integerFUStage.get(0).getValueSource1();
				source2 = integerFUStage.get(0).getValueSource2();
				int dest = source1 - source2;
				integerFUStage.get(0).setValueDestn(dest);
				}
				else
				{
					String name= sinst[0];
                	String d= sinst[1];
                	String s1= sinst[2];
                	String s2= sinst[3];
                	
                	integerFUStage.get(0).setInstName(name); 
                	integerFUStage.get(0).setNameDestn(d);

    				String Dname[]= d.split("R");
    				int DNo= Integer.parseInt(Dname[1]);
    				available[DNo]=0;
    				
					String regi1[] = s1.split("#");
					int size1= regi1.length;
					if (size1==2) 
					{
						integerFUStage.get(0).setNameSource1("LITERAL");
						integerFUStage.get(0).setValueSource1(Integer.parseInt(regi1[1]));
						
					}
					else
					{	
						String Rname1[]= s1.split("R");
	    				int RNo1= Integer.parseInt(Rname1[1]);
							integerFUStage.get(0).setNameSource1(s1);
							String FU1=integerFUStage.get(0).getWhichS1Unit();
							if(FU1!=null)
							{
								if(integerFUStage.get(0).getWhichS1Unit().equals("divFU"))
								{
									integerFUStage.get(0).setValueSource1(divBus[RNo1]);
								}
								else if(integerFUStage.get(0).getWhichS1Unit().equals("intFU"))
								{
									integerFUStage.get(0).setValueSource1(intFUBus[RNo1]);
								}
								else if(integerFUStage.get(0).getWhichS1Unit().equals("mulFU"))
								{
									integerFUStage.get(0).setValueSource1(mulBus[RNo1]);
								}
							}
							else
							{
								integerFUStage.get(0).setValueSource1(registers[RNo1]);
							}
						
					}

					String regi2[] = s2.split("#");
					int size2= regi2.length;
					if (size2==2) 
					{
						integerFUStage.get(0).setNameSource2("LITERAL");
						integerFUStage.get(0).setValueSource2(Integer.parseInt(regi2[1]));
					}
					else
					{

	    				String Rname2[]= s2.split("R");
	    				int RNo2= Integer.parseInt(Rname2[1]);
						
							integerFUStage.get(0).setNameSource2(s2);
							String FU2=integerFUStage.get(0).getWhichS2Unit();
							if(FU2!=null)
							{
								if(integerFUStage.get(0).getWhichS2Unit().equals("divFU"))
								{
									integerFUStage.get(0).setValueSource2(divBus[RNo2]);
								}
								else if(integerFUStage.get(0).getWhichS2Unit().equals("intFU"))
								{
									integerFUStage.get(0).setValueSource2(intFUBus[RNo2]);
								}
								else if(integerFUStage.get(0).getWhichS2Unit().equals("mulFU"))
								{
									integerFUStage.get(0).setValueSource2(mulBus[RNo2]);
								}
							}
							else
							{
								integerFUStage.get(0).setValueSource2(registers[RNo2]);
							}
						
					}
					source1 = integerFUStage.get(0).getValueSource1();
					source2 = integerFUStage.get(0).getValueSource2();
					int dest = source1 - source2;
					integerFUStage.get(0).setValueDestn(dest);

				}
			} 
			
			else if (instName.equals("OR")) {
				// logic for SUB instruction
				if(!integerFUStage.get(0).isWasDependent())
				{	
				source1 = integerFUStage.get(0).getValueSource1();
				source2 = integerFUStage.get(0).getValueSource2();
				int dest = source1 | source2;
				integerFUStage.get(0).setValueDestn(dest);
				}
				else
				{
					String name= sinst[0];
                	String d= sinst[1];
                	String s1= sinst[2];
                	String s2= sinst[3];
                	
                	integerFUStage.get(0).setInstName(name); 
                	integerFUStage.get(0).setNameDestn(d);

    				String Dname[]= d.split("R");
    				int DNo= Integer.parseInt(Dname[1]);
    				available[DNo]=0;
    				
					String regi1[] = s1.split("#");
					int size1= regi1.length;
					if (size1==2) 
					{
						integerFUStage.get(0).setNameSource1("LITERAL");
						integerFUStage.get(0).setValueSource1(Integer.parseInt(regi1[1]));
						
					}
					else
					{	
						String Rname1[]= s1.split("R");
	    				int RNo1= Integer.parseInt(Rname1[1]);
							integerFUStage.get(0).setNameSource1(s1);
							String FU1=integerFUStage.get(0).getWhichS1Unit();
							if(FU1!=null)
							{
								if(integerFUStage.get(0).getWhichS1Unit().equals("divFU"))
								{
									integerFUStage.get(0).setValueSource1(divBus[RNo1]);
								}
								else if(integerFUStage.get(0).getWhichS1Unit().equals("intFU"))
								{
									integerFUStage.get(0).setValueSource1(intFUBus[RNo1]);
								}
								else if(integerFUStage.get(0).getWhichS1Unit().equals("mulFU"))
								{
									integerFUStage.get(0).setValueSource1(mulBus[RNo1]);
								}
							}
							else
							{
								integerFUStage.get(0).setValueSource1(registers[RNo1]);
							}
						
					}

					String regi2[] = s2.split("#");
					int size2= regi2.length;
					if (size2==2) 
					{
						integerFUStage.get(0).setNameSource2("LITERAL");
						integerFUStage.get(0).setValueSource2(Integer.parseInt(regi2[1]));
					}
					else
					{

	    				String Rname2[]= s2.split("R");
	    				int RNo2= Integer.parseInt(Rname2[1]);
						
							integerFUStage.get(0).setNameSource2(s2);
							String FU2=integerFUStage.get(0).getWhichS2Unit();
							if(FU2!=null)
							{
								if(integerFUStage.get(0).getWhichS2Unit().equals("divFU"))
								{
									integerFUStage.get(0).setValueSource2(divBus[RNo2]);
								}
								else if(integerFUStage.get(0).getWhichS2Unit().equals("intFU"))
								{
									integerFUStage.get(0).setValueSource2(intFUBus[RNo2]);
								}
								else if(integerFUStage.get(0).getWhichS2Unit().equals("mulFU"))
								{
									integerFUStage.get(0).setValueSource2(mulBus[RNo2]);
								}
							}
							else
							{
								integerFUStage.get(0).setValueSource2(registers[RNo2]);
							}
						
					}				
					source1 = integerFUStage.get(0).getValueSource1();
					source2 = integerFUStage.get(0).getValueSource2();
					int dest = source1 | source2;
					integerFUStage.get(0).setValueDestn(dest);
				}
			}
			
			else if (instName.equals("AND")) {
				// logic for SUB instruction
				if(!integerFUStage.get(0).isWasDependent())
				{
				source1 = integerFUStage.get(0).getValueSource1();
				source2 = integerFUStage.get(0).getValueSource2();
				int dest = source1 & source2;
				integerFUStage.get(0).setValueDestn(dest);
				}
				else
				{
					String name= sinst[0];
                	String d= sinst[1];
                	String s1= sinst[2];
                	String s2= sinst[3];
                	
                	integerFUStage.get(0).setInstName(name); 
                	integerFUStage.get(0).setNameDestn(d);

    				String Dname[]= d.split("R");
    				int DNo= Integer.parseInt(Dname[1]);
    				available[DNo]=0;
    				
					String regi1[] = s1.split("#");
					int size1= regi1.length;
					if (size1==2) 
					{
						integerFUStage.get(0).setNameSource1("LITERAL");
						integerFUStage.get(0).setValueSource1(Integer.parseInt(regi1[1]));
						
					}
					else
					{	
						String Rname1[]= s1.split("R");
	    				int RNo1= Integer.parseInt(Rname1[1]);
							integerFUStage.get(0).setNameSource1(s1);
							String FU1=integerFUStage.get(0).getWhichS1Unit();
							if(FU1!=null)
							{
								if(integerFUStage.get(0).getWhichS1Unit().equals("divFU"))
								{
									integerFUStage.get(0).setValueSource1(divBus[RNo1]);
								}
								else if(integerFUStage.get(0).getWhichS1Unit().equals("intFU"))
								{
									integerFUStage.get(0).setValueSource1(intFUBus[RNo1]);
								}
								else if(integerFUStage.get(0).getWhichS1Unit().equals("mulFU"))
								{
									integerFUStage.get(0).setValueSource1(mulBus[RNo1]);
								}
							}
							else
							{
								integerFUStage.get(0).setValueSource1(registers[RNo1]);
							}
						
					}

					String regi2[] = s2.split("#");
					int size2= regi2.length;
					if (size2==2) 
					{
						integerFUStage.get(0).setNameSource2("LITERAL");
						integerFUStage.get(0).setValueSource2(Integer.parseInt(regi2[1]));
					}
					else
					{

	    				String Rname2[]= s2.split("R");
	    				int RNo2= Integer.parseInt(Rname2[1]);
						
							integerFUStage.get(0).setNameSource2(s2);
							String FU2=integerFUStage.get(0).getWhichS2Unit();
							if(FU2!=null)
							{
								if(integerFUStage.get(0).getWhichS2Unit().equals("divFU"))
								{
									integerFUStage.get(0).setValueSource2(divBus[RNo2]);
								}
								else if(integerFUStage.get(0).getWhichS2Unit().equals("intFU"))
								{
									integerFUStage.get(0).setValueSource2(intFUBus[RNo2]);
								}
								else if(integerFUStage.get(0).getWhichS2Unit().equals("mulFU"))
								{
									integerFUStage.get(0).setValueSource2(mulBus[RNo2]);
								}
							}
							else
							{
								integerFUStage.get(0).setValueSource2(registers[RNo2]);
							}
						
					}				
					
					source1 = integerFUStage.get(0).getValueSource1();
					source2 = integerFUStage.get(0).getValueSource2();
					int dest = source1 & source2;
					integerFUStage.get(0).setValueDestn(dest);
				}
			}
			
			else if (instName.equals("EXOR")) {
				// logic for SUB instruction
				if(!integerFUStage.get(0).isWasDependent())
				{
				source1 = integerFUStage.get(0).getValueSource1();
				source2 = integerFUStage.get(0).getValueSource2();
				int dest = source1 ^ source2;
				integerFUStage.get(0).setValueDestn(dest);
				}
				else
				{
					String name= sinst[0];
                	String d= sinst[1];
                	String s1= sinst[2];
                	String s2= sinst[3];
                	
                	integerFUStage.get(0).setInstName(name); 
                	integerFUStage.get(0).setNameDestn(d);

    				String Dname[]= d.split("R");
    				int DNo= Integer.parseInt(Dname[1]);
    				available[DNo]=0;
    				
					String regi1[] = s1.split("#");
					int size1= regi1.length;
					if (size1==2) 
					{
						integerFUStage.get(0).setNameSource1("LITERAL");
						integerFUStage.get(0).setValueSource1(Integer.parseInt(regi1[1]));
						
					}
					else
					{	
						String Rname1[]= s1.split("R");
	    				int RNo1= Integer.parseInt(Rname1[1]);
							integerFUStage.get(0).setNameSource1(s1);
							String FU1=integerFUStage.get(0).getWhichS1Unit();
							if(FU1!=null)
							{
								if(integerFUStage.get(0).getWhichS1Unit().equals("divFU"))
								{
									integerFUStage.get(0).setValueSource1(divBus[RNo1]);
								}
								else if(integerFUStage.get(0).getWhichS1Unit().equals("intFU"))
								{
									integerFUStage.get(0).setValueSource1(intFUBus[RNo1]);
								}
								else if(integerFUStage.get(0).getWhichS1Unit().equals("mulFU"))
								{
									integerFUStage.get(0).setValueSource1(mulBus[RNo1]);
								}
							}
							else
							{
								integerFUStage.get(0).setValueSource1(registers[RNo1]);
							}
						
					}

					String regi2[] = s2.split("#");
					int size2= regi2.length;
					if (size2==2) 
					{
						integerFUStage.get(0).setNameSource2("LITERAL");
						integerFUStage.get(0).setValueSource2(Integer.parseInt(regi2[1]));
					}
					else
					{

	    				String Rname2[]= s2.split("R");
	    				int RNo2= Integer.parseInt(Rname2[1]);
						
							integerFUStage.get(0).setNameSource2(s2);
							String FU2=integerFUStage.get(0).getWhichS2Unit();
							if(FU2!=null)
							{
								if(integerFUStage.get(0).getWhichS2Unit().equals("divFU"))
								{
									integerFUStage.get(0).setValueSource2(divBus[RNo2]);
								}
								else if(integerFUStage.get(0).getWhichS2Unit().equals("intFU"))
								{
									integerFUStage.get(0).setValueSource2(intFUBus[RNo2]);
								}
								else if(integerFUStage.get(0).getWhichS2Unit().equals("mulFU"))
								{
									integerFUStage.get(0).setValueSource2(mulBus[RNo2]);
								}
							}
							else
							{
								integerFUStage.get(0).setValueSource2(registers[RNo2]);
							}
						
					}				

					
					source1 = integerFUStage.get(0).getValueSource1();
					source2 = integerFUStage.get(0).getValueSource2();
					int dest = source1 ^ source2;
					integerFUStage.get(0).setValueDestn(dest);
				}
			}
			
			else if (instName.equals("LOAD")) {
				// LOAD dest src1 literal
				if(!integerFUStage.get(0).isWasDependent())
				{
				int src1;
				src1 = integerFUStage.get(0).getValueSource1();
				int literal = integerFUStage.get(0).getValueSource2();
				int memoryAddr = src1 + literal;
				int value= Memory[memoryAddr];
				temploadValue=value;
				integerFUStage.get(0).setValueDestn(value);
				System.out.println(integerFUStage.get(0).getValueDestn());
				}
				else
				{
					String name= sinst[0];
                	String d= sinst[1];
                	String s1= sinst[2];
                	String s2= sinst[3];
                	
                	integerFUStage.get(0).setInstName(name); 
                	integerFUStage.get(0).setNameDestn(d);

    				String Dname[]= d.split("R");
    				int DNo= Integer.parseInt(Dname[1]);
    				available[DNo]=0;
    				
					String regi1[] = s1.split("#");
					int size1= regi1.length;
					if (size1==2) 
					{
						integerFUStage.get(0).setNameSource1("LITERAL");
						integerFUStage.get(0).setValueSource1(Integer.parseInt(regi1[1]));
						
					}
					else
					{	
						String Rname1[]= s1.split("R");
	    				int RNo1= Integer.parseInt(Rname1[1]);
							integerFUStage.get(0).setNameSource1(s1);
							String FU1=integerFUStage.get(0).getWhichS1Unit();
							if(FU1!=null)
							{
								if(integerFUStage.get(0).getWhichS1Unit().equals("divFU"))
								{
									integerFUStage.get(0).setValueSource1(divBus[RNo1]);
								}
								else if(integerFUStage.get(0).getWhichS1Unit().equals("intFU"))
								{
									integerFUStage.get(0).setValueSource1(intFUBus[RNo1]);
								}
								else if(integerFUStage.get(0).getWhichS1Unit().equals("mulFU"))
								{
									integerFUStage.get(0).setValueSource1(mulBus[RNo1]);
								}
							}
							else
							{
								integerFUStage.get(0).setValueSource1(registers[RNo1]);
							}
						
					}

					String regi2[] = s2.split("#");
					int size2= regi2.length;
					if (size2==2) 
					{
						integerFUStage.get(0).setNameSource2("LITERAL");
						integerFUStage.get(0).setValueSource2(Integer.parseInt(regi2[1]));
					}
					else
					{

	    				String Rname2[]= s2.split("R");
	    				int RNo2= Integer.parseInt(Rname2[1]);
						
							integerFUStage.get(0).setNameSource2(s2);
							String FU2=integerFUStage.get(0).getWhichS2Unit();
							if(FU2!=null)
							{
								if(integerFUStage.get(0).getWhichS2Unit().equals("divFU"))
								{
									integerFUStage.get(0).setValueSource2(divBus[RNo2]);
								}
								else if(integerFUStage.get(0).getWhichS2Unit().equals("intFU"))
								{
									integerFUStage.get(0).setValueSource2(intFUBus[RNo2]);
								}
								else if(integerFUStage.get(0).getWhichS2Unit().equals("mulFU"))
								{
									integerFUStage.get(0).setValueSource2(mulBus[RNo2]);
								}
							}
							else
							{
								integerFUStage.get(0).setValueSource2(registers[RNo2]);
							}
						
					}				

					int src1;
					src1 = integerFUStage.get(0).getValueSource1();
					int literal = integerFUStage.get(0).getValueSource2();
					int memoryAddr = src1 + literal;
					int value= Memory[memoryAddr];
					integerFUStage.get(0).setValueDestn(value);
				}
			} 
			
			
			else if (instName.equals("JUMP")) 
			{
				// logic for JUMP instruction
				if(!integerFUStage.get(0).isWasDependent())
				{
				source1 = integerFUStage.get(0).getValueSource1();
				source2 = integerFUStage.get(0).getValueSource2();
				int dest = source1 + source2;
				PC=dest;
				fetchStage.clear();
				decodeStage.get(0).setDecoded(false);
				decodeStage.get(0).setWasDependent(false);
				decodeStage.clear();
				if(bzstall==true)
				{
					StallChahiye=false;
				}
				}
				else
				{
					String name= sinst[0];
                	String s1= sinst[1];
                	String s2= sinst[2];
    				
                	integerFUStage.get(0).setInstName(name); 
                	String regi1[] = s1.split("#");
					int size1= regi1.length;
					if (size1==2) 
					{
						integerFUStage.get(0).setNameSource1("LITERAL");
						integerFUStage.get(0).setValueSource1(Integer.parseInt(regi1[1]));
					}
					else
					{
					  	String Rname1[]= s1.split("R");
	    				int RNo1= Integer.parseInt(Rname1[1]);
							integerFUStage.get(0).setNameSource1(s1);
							String FU1=integerFUStage.get(0).getWhichS1Unit();
							if(FU1!=null)
							{
								if(integerFUStage.get(0).getWhichS1Unit().equals("divFU"))
								{
									integerFUStage.get(0).setValueSource1(divBus[RNo1]);
								}
								else if(integerFUStage.get(0).getWhichS1Unit().equals("intFU"))
								{
									integerFUStage.get(0).setValueSource1(intFUBus[RNo1]);
								}
								else if(integerFUStage.get(0).getWhichS1Unit().equals("mulFU"))
								{
									integerFUStage.get(0).setValueSource1(mulBus[RNo1]);
								}
							}
							else
							{
								integerFUStage.get(0).setValueSource1(registers[RNo1]);
							}
						
					}
                	
					String regi2[] = s2.split("#");
					int size2= regi2.length;
					if (size2==2) 
					{
						integerFUStage.get(0).setNameSource2("LITERAL");
						integerFUStage.get(0).setValueSource2(Integer.parseInt(regi2[1]));
					}
					else
					{	
							integerFUStage.get(0).setNameSource2(s2);
							integerFUStage.get(0).setValueSource2(0);
						
					}
					source1 = integerFUStage.get(0).getValueSource1();
					source2 = integerFUStage.get(0).getValueSource2();
					int dest = source1 + source2;
					PC=dest;
					fetchStage.clear();
					decodeStage.get(0).setDecoded(false);
					decodeStage.get(0).setWasDependent(false);
					decodeStage.clear(); 					
					integerFUStage.get(0).setDepcount(0);
					if(bzstall==true)
					{
						StallChahiye=false;
					}
				}
			}
			
			
			else if(instName.equals("JAL"))
			{
				// logic for JUMP instruction
				if(!integerFUStage.get(0).isWasDependent())
				{
					source1 = integerFUStage.get(0).getValueSource1();
					source2 = integerFUStage.get(0).getValueSource2();
					int dest = source1 + source2;
					PC=dest;
					fetchStage.clear();
					decodeStage.get(0).setDecoded(false);
					decodeStage.get(0).setWasDependent(false);
					decodeStage.clear(); 
					if(bzstall==true)
					{
						StallChahiye=false;
					}
				}
				else
				{
					String name= sinst[0];
                	String s1= sinst[2];
                	String s2= sinst[3];
    				
                	integerFUStage.get(0).setInstName(name); 
                	String regi1[] = s1.split("#");
					int size1= regi1.length;
					if (size1==2) 
					{
						integerFUStage.get(0).setNameSource1("LITERAL");
						integerFUStage.get(0).setValueSource1(Integer.parseInt(regi1[1]));
					}
					else
					{
					  	String Rname1[]= s1.split("R");
	    				int RNo1= Integer.parseInt(Rname1[1]);
							integerFUStage.get(0).setNameSource1(s1);
							String FU1=integerFUStage.get(0).getWhichS1Unit();
							if(FU1!=null)
							{
								if(integerFUStage.get(0).getWhichS1Unit().equals("divFU"))
								{
									integerFUStage.get(0).setValueSource1(divBus[RNo1]);
								}
								else if(integerFUStage.get(0).getWhichS1Unit().equals("intFU"))
								{
									integerFUStage.get(0).setValueSource1(intFUBus[RNo1]);
								}
								else if(integerFUStage.get(0).getWhichS1Unit().equals("mulFU"))
								{
									integerFUStage.get(0).setValueSource1(mulBus[RNo1]);
								}
							}
							else
							{
								integerFUStage.get(0).setValueSource1(registers[RNo1]);
							}
						
					}
                	
					String regi2[] = s2.split("#");
					int size2= regi2.length;
					if (size2==2) 
					{
						integerFUStage.get(0).setNameSource2("LITERAL");
						integerFUStage.get(0).setValueSource2(Integer.parseInt(regi2[1]));
					}
					else
					{	
							integerFUStage.get(0).setNameSource2(s2);
							integerFUStage.get(0).setValueSource2(0);
						
					}
					source1 = integerFUStage.get(0).getValueSource1();
					source2 = integerFUStage.get(0).getValueSource2();
					int dest = source1 + source2;
					PC=dest;
					fetchStage.clear();
					decodeStage.get(0).setDecoded(false);
					decodeStage.get(0).setWasDependent(false);
					decodeStage.clear(); 					
					integerFUStage.get(0).setDepcount(0);
					if(bzstall==true)
					{
						StallChahiye=false;
					}
				}
				
				
				
				
			}
			else if (instName.equals("BZ"))
			{
				if(zeroflag==0)
				{
					PC = BZPC+integerFUStage.get(0).getValueSource1();
					fetchStage.clear();
					if(!decodeStage.get(0).getInstName().equals("JUMP")&&!decodeStage.get(0).getInstName().equals("BZ")&&!decodeStage.get(0).getInstName().equals("BNZ"))
					{
						String Dname= decodeStage.get(0).getNameDestn();
						String Rname[]= Dname.split("R");
						if(Rname.length==2)
						{
							int Dno= Integer.parseInt(Rname[1]);
							available[Dno]=1;
						}
						
					}	
					decodeStage.get(0).setDecoded(false);
					decodeStage.clear(); 
					decodeStage.removeAll(decodeStage);
					for(int i=0; i<16; i++)
					{
						OPDep[i]=0;
					}
				}
				
			}
			
			else if (instName.equals("BNZ"))
			{
				if(zeroflag!=0)
				{
					PC = BZPC+integerFUStage.get(0).getValueSource1();
					fetchStage.clear();
					if(!decodeStage.get(0).getInstName().equals("JUMP")&&!decodeStage.get(0).getInstName().equals("BZ")&&!decodeStage.get(0).getInstName().equals("BNZ"))
					{
						String Dname= decodeStage.get(0).getNameDestn();
						String Rname[]= Dname.split("R");
						if(Rname.length==2)
						{
							int Dno= Integer.parseInt(Rname[1]);
							available[Dno]=1;
						}
						
					}	
					decodeStage.get(0).setDecoded(false);
					decodeStage.clear(); 
					decodeStage.removeAll(decodeStage);
					for(int i=0; i<16; i++)
					{
						OPDep[i]=0;
					}
					
				}
				
			}
			
			
			else if (instName.equals("STORE")) 
			{
				// STORE src1 src2 literal
				if(!integerFUStage.get(0).isWasDependent())
				{
				source1= integerFUStage.get(0).getValueSource1();
				source2= integerFUStage.get(0).getValueSource2();
				int literal = integerFUStage.get(0).getValueSource3();
				int memoryAddr = source2 + literal;
				Memory[memoryAddr]= source1;
				}
				else
				{
					String name= sinst[0];
					String s1= sinst[1];
					String s2= sinst[2];
					String s3= sinst[3];
    				
                	integerFUStage.get(0).setInstName(name); 
                	String regi1[] = s1.split("#");
					int size1= regi1.length;
					if (size1==2) 
					{
						integerFUStage.get(0).setNameSource1("LITERAL");
						integerFUStage.get(0).setValueSource1(Integer.parseInt(regi1[1]));
					}
					else
					{
					  	String Rname1[]= s1.split("R");
	    				int RNo1= Integer.parseInt(Rname1[1]);
						
							integerFUStage.get(0).setNameSource1(s1);
							String FU1=integerFUStage.get(0).getWhichS1Unit();
							if(FU1!=null)
							{
								if(integerFUStage.get(0).getWhichS1Unit().equals("divFU"))
								{
									integerFUStage.get(0).setValueSource1(divBus[RNo1]);
								}
								else if(integerFUStage.get(0).getWhichS1Unit().equals("intFU"))
								{
									integerFUStage.get(0).setValueSource1(intFUBus[RNo1]);
								}
								else if(integerFUStage.get(0).getWhichS1Unit().equals("mulFU"))
								{
									integerFUStage.get(0).setValueSource1(mulBus[RNo1]);
								}
							}
							else
							{
								integerFUStage.get(0).setValueSource1(registers[RNo1]);
							}
						
					}
					String regi2[] = s2.split("#");
					int size2= regi2.length;
					if (size2==2) 
					{
						integerFUStage.get(0).setNameSource2("LITERAL");
						integerFUStage.get(0).setValueSource2(Integer.parseInt(regi2[1]));
					}
					else
					{
						String Rname2[]= s2.split("R");
	    				int RNo2= Integer.parseInt(Rname2[1]);							
						integerFUStage.get(0).setNameSource2(s2);
						String FU2=integerFUStage.get(0).getWhichS2Unit();
						if(FU2!=null)
						{
							if(integerFUStage.get(0).getWhichS2Unit().equals("divFU"))
							{
								integerFUStage.get(0).setValueSource2(divBus[RNo2]);
							}
							else if(integerFUStage.get(0).getWhichS2Unit().equals("intFU"))
							{
								integerFUStage.get(0).setValueSource2(intFUBus[RNo2]);
							}
							else if(integerFUStage.get(0).getWhichS2Unit().equals("mulFU"))
							{
								integerFUStage.get(0).setValueSource2(mulBus[RNo2]);
							}
						}
						else
						{
							integerFUStage.get(0).setValueSource2(registers[RNo2]);
						}
						
						
					}
                	
					String regi3[] = s3.split("#");
					int size3= regi3.length;
					if (size3==2) 
					{
						integerFUStage.get(0).setNameSource3("LITERAL");
						integerFUStage.get(0).setValueSource3(Integer.parseInt(regi3[1]));
					}
					else
					{	
							integerFUStage.get(0).setNameSource3(s3);
							integerFUStage.get(0).setValueSource3(0);
						
					}
					
					source1= integerFUStage.get(0).getValueSource1();
					source2= integerFUStage.get(0).getValueSource2();
					int literal = integerFUStage.get(0).getValueSource3();
					int memoryAddr = source2 + literal;
					Memory[memoryAddr]= source1;
				}
				
			} 
			else if (instName.equals("MOVC")) 
			{
				int literal = integerFUStage.get(0).getValueSource1();
				integerFUStage.get(0).setValueDestn(literal);
			}
			
			if(!instName.equals("LOAD")&&!instName.equals("JUMP")&&!instName.equals("BZ")&&!instName.equals("BNZ")&&!instName.equals("JAL")&&!instName.equals("STORE"))
			{
				
				String intBusReg= integerFUStage.get(0).getNameDestn();
				int intregValue= integerFUStage.get(0).getValueDestn();
				String intBusRname[]= intBusReg.split("R");
				int RNo= Integer.parseInt(intBusRname[1]);
				intFUBus[RNo]= intregValue;	
				availableIntFUBus[RNo]=1;
			}
			
			int add= integerFUStage.get(0).getAddress();
			String instNo= instNoWithAddress.get(add);
		System.out.println("Integer FU Stage 	:: ("+instNo+") "+ integerFUStage.get(0).toString());
		integerFUStage.get(0).setIntFUExecuted(true);
				
	}
		else
		{
			System.out.println("Integer FU Stage 	:: Empty");
		}
		
}
	
}
