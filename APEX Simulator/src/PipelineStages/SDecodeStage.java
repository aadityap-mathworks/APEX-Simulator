package PipelineStages;

import Simulation.Simulator;

public class SDecodeStage extends Simulator
{
	//getters and setters
	private int address;
	private String instName;
	private String NameSource1;
	private String NameSource2;
	private String NameSource3;
	private String NameDestn;
	private String whichS1Unit;
	private String whichS2Unit;
	public String getWhichS1Unit() {
		return whichS1Unit;
	}

	public void setWhichS1Unit(String whichS1Unit) {
		this.whichS1Unit = whichS1Unit;
	}

	public String getWhichS2Unit() {
		return whichS2Unit;
	}

	public void setWhichS2Unit(String whichS2Unit) {
		this.whichS2Unit = whichS2Unit;
	}

	private int ValueSource1;
	private int ValueSource2;
	private int ValueSource3;
	private int ValueDestn;
	private int depcount=0;
	private String completeInstuction;
	private boolean PSW = false;
	private boolean isDecoded = false;
	private boolean isMUL1Executed = false;
	private boolean isMUL2Executed = false;
	private boolean isDIV1Executed = false;
	private boolean isDIV2Executed = false;
	private boolean isDIV3Executed = false;
	private boolean isOPDependent = false;
	private boolean isForwardNeeded = false;
	public boolean isForwardNeeded() {
		return isForwardNeeded;
	}

	public void setForwardNeeded(boolean isForwardNeeded) {
		this.isForwardNeeded = isForwardNeeded;
	}

	public boolean isOPDependent() {
		return isOPDependent;
	}

	public void setOPDependent(boolean isOPDependent) {
		this.isOPDependent = isOPDependent;
	}

	public boolean isDIV1Executed() {
		return isDIV1Executed;
	}

	public void setDIV1Executed(boolean isDIV1Executed) {
		this.isDIV1Executed = isDIV1Executed;
	}

	public boolean isDIV2Executed() {
		return isDIV2Executed;
	}

	public void setDIV2Executed(boolean isDIV2Executed) {
		this.isDIV2Executed = isDIV2Executed;
	}

	public boolean isDIV3Executed() {
		return isDIV3Executed;
	}

	public void setDIV3Executed(boolean isDIV3Executed) {
		this.isDIV3Executed = isDIV3Executed;
	}

	public boolean isDIV4Executed() {
		return isDIV4Executed;
	}

	public void setDIV4Executed(boolean isDIV4Executed) {
		this.isDIV4Executed = isDIV4Executed;
	}

	private boolean isDIV4Executed = false;
	private boolean isMemoryExecuted = false;
	private boolean isIntFUExecuted = false;
	private boolean wasDependent = false;
	
	public boolean getPSW() {
		return PSW;
	}

	public void setPSW(boolean pSW) {
		PSW = pSW;
	}
	public boolean isWasDependent() {
		return wasDependent;
	}

	public void setWasDependent(boolean wasDependent) {
		this.wasDependent = wasDependent;
	}

	public boolean isIntFUExecuted() {
		return isIntFUExecuted;
	}

	public int getDepcount() {
		return depcount;
	}

	public void setDepcount(int depcount) {
		this.depcount = depcount;
	}

	public void setIntFUExecuted(boolean isIntFUExecuted) {
		this.isIntFUExecuted = isIntFUExecuted;
	}

	private boolean isDependent = false;
	
	@Override
	public String toString() {
		return completeInstuction;
	}
	
	public boolean isDecoded() {
		return isDecoded;
	}

	public void setDecoded(boolean isDecoded) {
		this.isDecoded = isDecoded;
	}

	public boolean isMUL1Executed() {
		return isMUL1Executed;
	}

	public void setMUL1Executed(boolean isMUL1Executed) {
		this.isMUL1Executed = isMUL1Executed;
	}

	public boolean isMUL2Executed() {
		return isMUL2Executed;
	}

	public void setMUL2Executed(boolean isMUL2Executed) {
		this.isMUL2Executed = isMUL2Executed;
	}

	public boolean isMemoryExecuted() {
		return isMemoryExecuted;
	}

	public void setMemoryExecuted(boolean isMemoryExecuted) {
		this.isMemoryExecuted = isMemoryExecuted;
	}

	public int getAddress() 
	{
		return address;
	}

	public void setAddress(int address) 
	{
		this.address = address;
	}
	
	
	public String getInstName() {
		return instName;
	}

	public void setInstName(String instName) {
		this.instName = instName;
	}
	
	
	public String getNameSource1() 
	{
		return NameSource1;
	}
	
	public void setNameSource1(String NameSource1) {
		this.NameSource1 =NameSource1;
	}
	
	public String getNameSource2() {
		return NameSource2;
	}

	public void setNameSource2(String nameSource2) {
		NameSource2 = nameSource2;
	}

	public String getNameSource3() {
		return NameSource3;
	}

	public void setNameSource3(String nameSource3) {
		NameSource3 = nameSource3;
	}

	public String getNameDestn() {
		return NameDestn;
	}

	public void setNameDestn(String nameDestn) {
		NameDestn = nameDestn;
	}

	public int getValueSource1() 
	{
		return ValueSource1;
	}

	public void setValueSource1(int ValueSource1) 
	{
		this.ValueSource1 = ValueSource1;
	}
	
	public int getValueSource2() 
	{
		return ValueSource2;
	}

	public void setValueSource2(int ValueSource2) 
	{
		this.ValueSource2 = ValueSource2;
	}
	
	public int getValueSource3() 
	{
		return ValueSource3;
	}

	public void setValueSource3(int ValueSource3) 
	{
		this.ValueSource3 = ValueSource3;
	}
	
	public int getValueDestn() 
	{
		return ValueDestn;
	}

	public void setValueDestn(int ValueDestn) 
	{
		this.ValueDestn = ValueDestn;
	}
	
	
	public static void executeDecodeStage() 
	{	
		
		String s1, s2, s3, d, name;
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
		if (decodeStage.size()>0) 
		{				
			
		String instruction = decodeStage.get(0).toString();
			String sinst[] = instruction.split("[ ,]+");
			if (sinst.length > 3)
            {	
				//ADD dest src1 src2	
				//SUB dest src1 src2
				//MUL dest src1 src2
				//DIv dest src1 src2
                if (sinst[0].equals("ADD") || sinst[0].equals("SUB") ||sinst[0].equals("MUL")||sinst[0].equals("DIV")
                		||sinst[0].equals("OR")||sinst[0].equals("AND")||sinst[0].equals("EXOR")||sinst[0].equals("LOAD")||sinst[0].equals("XOR") )
                {	
                	
                	int RNo1 = 6798;
                	name= sinst[0];
                	d= sinst[1];
                	s1= sinst[2];
                	s2= sinst[3];
                	
                	decodeStage.get(0).setInstName(name); 
                	decodeStage.get(0).setNameDestn(d);

    				String Dname[]= d.split("R");
    				int DNo= Integer.parseInt(Dname[1]);
    				
    				
					String regi1[] = s1.split("#");
					int size1= regi1.length;
					if (size1==2) 
					{
						decodeStage.get(0).setNameSource1("LITERAL");
						decodeStage.get(0).setValueSource1(Integer.parseInt(regi1[1]));
						
					}
					else
					{	
						String Rname1[]= s1.split("R");
	    				 RNo1= Integer.parseInt(Rname1[1]);
						if (available[RNo1]==1) 
						{
						
							decodeStage.get(0).setNameSource1(s1);
							decodeStage.get(0).setValueSource1(registers[RNo1]);
						}
						else
						{	
							
							
							 if (divStageThree.size()>0 && availablDdivBus[RNo1]==1)
							{
									decodeStage.get(0).setNameSource1(s1);
									decodeStage.get(0).setValueSource1(divBus[RNo1]);
									decodeStage.get(0).setWhichS1Unit("divFU");
								
							}
							else if (mulStageOne.size()>0 && availableMulBus[RNo1]==1)
							{
									decodeStage.get(0).setNameSource1(s1);
									decodeStage.get(0).setValueSource1(mulBus[RNo1]);
									decodeStage.get(0).setWhichS1Unit("mulFU");
								
							}
							else if(integerFUStage.size()>1 && integerFUStage.get(1).getNameDestn().equals(s1)&& !integerFUStage.get(1).equals("STORE"))
							{
								decodeStage.get(0).setNameSource1(s1);
								decodeStage.get(0).setWasDependent(true);
								decodeStage.get(0).setWhichS1Unit("intFU");
								
							}
							else if(integerFUStage.size()==1 && integerFUStage.get(0).getNameDestn().equals(s1) && !integerFUStage.get(0).equals("STORE"))
							{
								decodeStage.get(0).setNameSource1(s1);
								decodeStage.get(0).setWasDependent(true);
								decodeStage.get(0).setWhichS1Unit("intFU");
							}
							else
							{
								decodeStage.get(0).setNameSource1(s1);
								dependent[RNo1]=1;
								StallChahiye=true;
								decodeStage.get(0).setDepcount(1);
								decodeStage.get(0).setWasDependent(true);
							}
							
						}
					}
					
					String regi2[] = s2.split("#");
					int size2= regi2.length;
					if (size2==2) 
					{
						decodeStage.get(0).setNameSource2("LITERAL");
						decodeStage.get(0).setValueSource2(Integer.parseInt(regi2[1]));
					}
					else
					{

	    				String Rname2[]= s2.split("R");
	    				int RNo2= Integer.parseInt(Rname2[1]);
						if (available[RNo2]==1) 
						{
							decodeStage.get(0).setNameSource2(s2);
							decodeStage.get(0).setValueSource2(registers[RNo2]);
						}
						else
						{
							
							if (divStageThree.size()>0 && availablDdivBus[RNo2]==1)
							{
									decodeStage.get(0).setNameSource2(s2);
									decodeStage.get(0).setValueSource2(divBus[RNo2]);
									decodeStage.get(0).setWhichS2Unit("divFU");
								
							}
							else if (mulStageOne.size()>0 && availableMulBus[RNo2]==1)
							{
									decodeStage.get(0).setNameSource2(s2);
									decodeStage.get(0).setValueSource2(mulBus[RNo2]);
									decodeStage.get(0).setWhichS2Unit("mulFU");
								
							}
							else if(integerFUStage.size()>1 && integerFUStage.get(1).getNameDestn().equals(s2))
							{
								decodeStage.get(0).setNameSource2(s2);
								decodeStage.get(0).setWasDependent(true);
								decodeStage.get(0).setWhichS2Unit("intFU");
								
							}
							else if(integerFUStage.size()==1 && integerFUStage.get(0).getNameDestn().equals(s2))
							{
								decodeStage.get(0).setNameSource2(s2);
								decodeStage.get(0).setWasDependent(true);
								decodeStage.get(0).setWhichS2Unit("intFU");
							}
							else
							{
								dependent[RNo2]=1;
								StallChahiye=true;
								decodeStage.get(0).setNameSource2(s2);
								decodeStage.get(0).setWasDependent(true);
								int dpc= decodeStage.get(0).getDepcount();
								if(dpc==1)
								{
									decodeStage.get(0).setDepcount(2);
								}
								else
								{
									decodeStage.get(0).setDepcount(1);
								}
								if(RNo1==RNo2)
								{
									decodeStage.get(0).setDepcount(1);
								}
							}
						}
						
					}
					if(integerFUStage.size()>0)
					{
						if(integerFUStage.get(0).instName.equals("JUMP")||integerFUStage.get(0).instName.equals("JAL"))
						{
							
						}
						else
						{	
							if(available[DNo]==0)
							{
								available[DNo]=0;
								OPDep[DNo]=1;
								decodeStage.get(0).setOPDependent(true);
								opdstall=true;
							}
							else
							{
								available[DNo]=0;
							}
						
						}
					}
					else
					{
						if(available[DNo]==0)
						{
							available[DNo]=0;
							OPDep[DNo]=1;
							decodeStage.get(0).setOPDependent(true);
							opdstall=true;
						}
						else
						{
							available[DNo]=0;
						}
					}
                }
                
                //JAL dest src1 #literal
                else if(sinst[0].equals("JAL"))
                {
                	int JRNo = 6798;
                	name= sinst[0];
                	d= sinst[1];
                	s1= sinst[2];
                	s2= sinst[3];
                	
                	decodeStage.get(0).setInstName(name); 
                	decodeStage.get(0).setNameDestn(d);
                	int add = decodeStage.get(0).getAddress()+4;
                	
                	decodeStage.get(0).setValueDestn(add);

    				String Dname[]= d.split("R");
    				int DNo= Integer.parseInt(Dname[1]);
    				
    				
					String regi1[] = s1.split("#");
					int size1= regi1.length;
					if (size1==2) 
					{
						decodeStage.get(0).setNameSource1("LITERAL");
						decodeStage.get(0).setValueSource1(Integer.parseInt(regi1[1]));
						
					}
					else
					{	
						String Rname1[]= s1.split("R");
						JRNo= Integer.parseInt(Rname1[1]);
						if (available[JRNo]==1) 
						{
						
							decodeStage.get(0).setNameSource1(s1);
							decodeStage.get(0).setValueSource1(registers[JRNo]);
						}
						else
						{
							dependent[JRNo]=1;
							StallChahiye=true;
							decodeStage.get(0).setDepcount(1);
							decodeStage.get(0).setWasDependent(true);
							
							
						}
					}
					
					String regi2[] = s2.split("#");
					int size2= regi2.length;
					if (size2==2) 
					{
						decodeStage.get(0).setNameSource2("LITERAL");
						decodeStage.get(0).setValueSource2(Integer.parseInt(regi2[1]));
					}
					else
					{

	    				String Rname2[]= s2.split("R");
	    				int RNo2= Integer.parseInt(Rname2[1]);
						if (available[RNo2]==1) 
						{
							decodeStage.get(0).setNameSource2(s2);
							decodeStage.get(0).setValueSource2(registers[RNo2]);
						}
						else
						{
							dependent[RNo2]=1;
							StallChahiye=true;
							decodeStage.get(0).setWasDependent(true);
							int dpc= decodeStage.get(0).getDepcount();
							if(dpc==1)
							{
								decodeStage.get(0).setDepcount(2);
							}
							else
							{
								decodeStage.get(0).setDepcount(1);
							}
						}
						
					}
					if(integerFUStage.size()>0)
					{
						if(integerFUStage.get(0).instName.equals("JUMP")||integerFUStage.get(0).instName.equals("JAL"))
						{
							
						}
						else
						{
							if(available[DNo]==0)
							{
								available[DNo]=0;
								OPDep[DNo]=1;
								decodeStage.get(0).setOPDependent(true);
								opdstall=true;
							}
							else
							{
								available[DNo]=0;
							}
						}
					}
					else
					{
						if(available[DNo]==0)
						{
							available[DNo]=0;
							OPDep[DNo]=1;
							decodeStage.get(0).setOPDependent(true);
							opdstall=true;
						}
						else
						{
							available[DNo]=0;
						}
					}
                	
                }
                
                else if(sinst[0].equals("STORE"))
                {
                	name= sinst[0];
                	d= "asdasd";
                	s1= sinst[1];
                	s2= sinst[2];
                	s3= sinst[3];
    				
                	decodeStage.get(0).setNameDestn(d);
                	decodeStage.get(0).setInstName(name); 
                	String regi1[] = s1.split("#");
					int size1= regi1.length;
					if (size1==2) 
					{
						decodeStage.get(0).setNameSource1("LITERAL");
						decodeStage.get(0).setValueSource1(Integer.parseInt(regi1[1]));
					}
					else
					{
					  	String Rname1[]= s1.split("R");
	    				int RNo1= Integer.parseInt(Rname1[1]);
	    				if(available[RNo1]==1)
	    				{
							
							decodeStage.get(0).setNameSource1(s1);
							decodeStage.get(0).setValueSource1(registers[RNo1]);
						}
	    				else
	    				{
		    				
							 if (divStageThree.size()>0 && availablDdivBus[RNo1]==1)
							{
									decodeStage.get(0).setNameSource1(s1);
									decodeStage.get(0).setValueSource1(divBus[RNo1]);
									decodeStage.get(0).setWhichS1Unit("divFU");
								
							}
							else if (mulStageOne.size()>0 && availableMulBus[RNo1]==1)
							{
									decodeStage.get(0).setNameSource1(s1);
									decodeStage.get(0).setValueSource1(mulBus[RNo1]);
									decodeStage.get(0).setWhichS1Unit("mulFU");
								
							}
							else if(integerFUStage.size()>1 && integerFUStage.get(1).getNameDestn().equals(s1))
							{
								decodeStage.get(0).setNameSource1(s1);
								decodeStage.get(0).setWasDependent(true);
								decodeStage.get(0).setWhichS1Unit("intFU");
								
							}
							else if(integerFUStage.size()==1 && integerFUStage.get(0).getNameDestn().equals(s1))
							{
								decodeStage.get(0).setNameSource1(s1);
								decodeStage.get(0).setWasDependent(true);
								decodeStage.get(0).setWhichS1Unit("intFU");
							}
							
							else
							{	
								decodeStage.get(0).setNameSource1(s1);
								dependent[RNo1]=1;
								StallChahiye=true;
								decodeStage.get(0).setDepcount(1);
								decodeStage.get(0).setWasDependent(true);
							}
	    				}	
					}
					String regi2[] = s2.split("#");
					int size2= regi2.length;
					if (size2==2) 
					{
						decodeStage.get(0).setNameSource2("LITERAL");
						decodeStage.get(0).setValueSource2(Integer.parseInt(regi2[1]));
					}
					else
					{
						String Rname2[]= s2.split("R");
	    				int RNo2= Integer.parseInt(Rname2[1]);
						if (available[RNo2]==1) 
						{
							decodeStage.get(0).setNameSource2(s2);
							decodeStage.get(0).setValueSource1(registers[RNo2]);
						}
						else
						{
							decodeStage.get(0).setNameSource2(s2);
							
							
							if (divStageThree.size()>0 && availablDdivBus[RNo2]==1)
							{
									decodeStage.get(0).setNameSource2(s2);
									decodeStage.get(0).setValueSource2(divBus[RNo2]);
									decodeStage.get(0).setWhichS2Unit("divFU");
								
							}
							else if (mulStageOne.size()>0 && availableMulBus[RNo2]==1)
							{
									decodeStage.get(0).setNameSource2(s2);
									decodeStage.get(0).setValueSource2(mulBus[RNo2]);
									decodeStage.get(0).setWhichS2Unit("mulFU");
								
							}
							else if(integerFUStage.size()>1 && integerFUStage.get(1).getNameDestn().equals(s2))
							{
								decodeStage.get(0).setNameSource2(s2);
								decodeStage.get(0).setWasDependent(true);
								decodeStage.get(0).setWhichS2Unit("intFU");
								
							}
							else if(integerFUStage.size()==1 && integerFUStage.get(0).getNameDestn().equals(s2))
							{
								decodeStage.get(0).setNameSource2(s2);
								decodeStage.get(0).setWasDependent(true);
								decodeStage.get(0).setWhichS2Unit("intFU");
							}
							
							else
							{
								decodeStage.get(0).setNameSource2(s2);
								dependent[RNo2]=1;
								StallChahiye=true;
								decodeStage.get(0).setWasDependent(true);
								int dpc2= decodeStage.get(0).getDepcount();
								if(dpc2==1)
								{
									decodeStage.get(0).setDepcount(2);
								}
								else
								{
									decodeStage.get(0).setDepcount(1);
								}
							}
							
						}
					
					String regi3[] = s3.split("#");
					int size3= regi3.length;
					if (size3==2) 
					{
						decodeStage.get(0).setNameSource3("LITERAL");
						decodeStage.get(0).setValueSource3(Integer.parseInt(regi3[1]));
					}
					else
					{	
							decodeStage.get(0).setNameSource3(s3);
							decodeStage.get(0).setValueSource3(0);
						
					}
                }
                
                }  
            }
			
			
			else if (sinst.length > 2 && sinst.length <= 3)
            {	
				//MOVC reg literal
                if (sinst[0].equals("MOVC")||sinst[0].equals("MOV"))
                {
                	name= sinst[0];
                	d= sinst[1];
                	s1= sinst[2];
                	String Dname[]= d.split("R");
    				int DNo= Integer.parseInt(Dname[1]);
    				
                	decodeStage.get(0).setInstName(name); 	
                	decodeStage.get(0).setNameDestn(d);
                	String regi1[] = s1.split("#");
					int size1= regi1.length;
					if (size1==2) 
					{
						decodeStage.get(0).setNameSource1("LITERAL");
						decodeStage.get(0).setValueSource1(Integer.parseInt(regi1[1]));
					}
					else
					{
						decodeStage.get(0).setNameSource1(s1);
						decodeStage.get(0).setValueSource1(0);
					}
					available[DNo]=0;
                	
                }
                
              //JUMP reg literal
                if(sinst[0].equals("JUMP"))
                {
                	
                	name= sinst[0];
                	s1= sinst[1];
                	s2= sinst[2];
    				
                	decodeStage.get(0).setInstName(name); 
                	String regi1[] = s1.split("#");
					int size1= regi1.length;
					if (size1==2) 
					{
						decodeStage.get(0).setNameSource1("LITERAL");
						decodeStage.get(0).setValueSource1(Integer.parseInt(regi1[1]));
					}
					else
					{
					  	String Rname1[]= s1.split("R");
	    				int RNo1= Integer.parseInt(Rname1[1]);
						if (available[RNo1]==1) 
						{
							decodeStage.get(0).setNameSource1(s1);
							decodeStage.get(0).setValueSource1(registers[RNo1]);
						}
						else
						{
							dependent[RNo1]=1;
							StallChahiye=true;
							decodeStage.get(0).setDepcount(1);
							decodeStage.get(0).setWasDependent(true);
						}
						
					}
                	
					String regi2[] = s2.split("#");
					int size2= regi2.length;
					if (size2==2) 
					{
						decodeStage.get(0).setNameSource2("LITERAL");
						decodeStage.get(0).setValueSource2(Integer.parseInt(regi2[1]));
					}
					else
					{	
							decodeStage.get(0).setNameSource2(s2);
							decodeStage.get(0).setValueSource2(0);
						
					}
                	
                }
            }
            else if (sinst.length > 1 && sinst.length <= 2)
            {
            	//BZ literal
                if (sinst[0].equals("BZ") || sinst[0].equals("BNZ") )
                {
                	name= sinst[0];
                	d= sinst[1];
                	
                	String regi1[] = d.split("#");
					int size1= regi1.length;
					if (size1==2) 
					{
						decodeStage.get(0).setNameSource1("LITERAL");
						decodeStage.get(0).setValueSource1(Integer.parseInt(regi1[1]));
					}
                	
                	decodeStage.get(0).setInstName(name);      	
                	//decodeStage.get(0).setNameDestn(d);
                	BZPC= decodeStage.get(0).getAddress();
                	 if(divStageOne.size()>0)
                	{
                		divStageOne.get(0).setPSW(true);
                		StallChahiye=true;
                		bzstall=true;
                	}
                	 else if(mulStageOne.size()>0)
                 	{
                 		//PSWPC= mulStageOne.get(0).getAddress();
                 		mulStageOne.get(0).setPSW(true);
                 		StallChahiye=true;
                 		bzstall=true;
                 	}
                	 else if(integerFUStage.size()>1&&(integerFUStage.get(1).instName.equals("ADD")||integerFUStage.get(1).instName.equals("SUB")))
                	{
	                		if (integerFUStage.size()==1)
	                		{
	                		//PSWPC= integerFUStage.get(0).getAddress();
	                		integerFUStage.get(0).setPSW(true);
	                		StallChahiye=true;
	                		bzstall=true;
	                		}
	                		else
	                		{
	                			//PSWPC= integerFUStage.get(1).getAddress();
	                    		integerFUStage.get(1).setPSW(true);
	                    		StallChahiye=true;
	                    		bzstall=true;
	                		}
	                	}
                	}
                	else if(integerFUStage.size()>0&&(integerFUStage.get(0).instName.equals("ADD")||integerFUStage.get(0).instName.equals("SUB")))
                	{
                		//PSWPC= integerFUStage.get(1).getAddress();
                		integerFUStage.get(0).setPSW(true);
                		StallChahiye=true;
                		bzstall=true;
                	}
                	
                	
                	else if (memoryStage.get(0).instName.equals("ADD")||memoryStage.get(0).instName.equals("SUB"))
                	{
                		PSWPC= memoryStage.get(0).getAddress();
                		memoryStage.get(0).setPSW(true);
                		StallChahiye=true;
                		bzstall=true;
                	}
                	
                	                	
                
            }
            else if (sinst.length > 0 && sinst.length <= 1)
            {
                if (sinst[0].equals("HALT") )
                {
                	name=sinst[0];
                	decodeStage.get(0).setInstName(name); 
                	haltFlag=true;
                	fetchStage.clear();
                }
            }
            else
            {
                System.out.println("Unknown Command......!!!");
            }
				
				decodeStage.get(0).setDecoded(true);
				isDDecoded=true;
			
		}
		
	}
	

	public void setinstuction(String completeInstuction) {
		this.completeInstuction =completeInstuction;
		
	}
	

}
