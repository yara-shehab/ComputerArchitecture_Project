
package architecture_proj;
public class ALUOperation {
    //data
     int read1;
     int read2;
     int ALUControlFinal;
     boolean ALUSrc;
     boolean ZeroFlag;
     int ALUResult;
    //methods
    public ALUOperation(int ALUControlFinal,int read1,int read2,boolean ALUSrc,int offset, int x)
    {
        if(!ALUSrc)
        {
            switch(ALUControlFinal)
            {
                case 2://add
                    
                    ALUResult= read1+read2;
                    if(Controls.getRegWrite())
                    {
                    RegisterFile.writeinregister(ALUResult,RegisterFile.getnumofdestination());
                    }
                    break;
                case 3://sll
                    String s = Integer.toBinaryString(read1 << x);
                    ALUResult = Integer.parseInt(s,2);
                    if(Controls.getRegWrite())
                    {
                    RegisterFile.writeinregister(ALUResult,RegisterFile.getnumofdestination());
                    }

                    break;
                case 5: //beq 
                    ALUResult = read1-read2;
                    if(ALUResult==0)
                    {
                        ZeroFlag=true;
                        if(Controls.getBranch())
                        {                 
                            int k = offset;
                            InstructionMemory.setPC(k+InstructionMemory.getPC());
                        }
                    }
                    else 
                    {
                        ZeroFlag=false;
                    }
                    break;
                case 1://nor
                    ALUResult= ~(read1|read2);
                    if(Controls.getRegWrite())
                    {
                    RegisterFile.writeinregister(ALUResult,RegisterFile.getnumofdestination());
                    }
                    break;
                case 4://jr 
                    InstructionMemory.setPC(read1); 
                    break;
                case 7: //slt
                    if(read1<read2)
                    {
                        ALUResult = 1;
                        if(Controls.getRegWrite())
                    {
                    RegisterFile.writeinregister(ALUResult,RegisterFile.getnumofdestination());
                    }

                    }
                    else
                    {
                        ALUResult =0;
                        if(Controls.getRegWrite())
                    {
                    RegisterFile.writeinregister(ALUResult,RegisterFile.getnumofdestination());
                    }

                    }
                    break;
            }
        }
        else
        {
            switch(ALUControlFinal)
            {
               case 2://addi lw sw
                   ALUResult= read1+offset;
                   if(Controls.getRegWrite()== true && Controls.getMemToReg()==false)//addi
                    {
                    RegisterFile.writeinregister(ALUResult,RegisterFile.getnumofdestination());
                    }
                    break;
               
               case 0: //slti
                   if(read1<offset)
                    {
                        ALUResult = 1;
                        if(Controls.getRegWrite())
                    {
                    RegisterFile.writeinregister(ALUResult,RegisterFile.getnumofdestination());
                    }

                    }
                    else
                    {
                        ALUResult =0;
                        if(Controls.getRegWrite())
                    {
                    RegisterFile.writeinregister(ALUResult,RegisterFile.getnumofdestination());
                    }

                    }
                    break; 
            }
        }         
        }
    public  int getALUResult()
    {
        return ALUResult;
    }
    
    }
    
    
   
                 
        
    
    
