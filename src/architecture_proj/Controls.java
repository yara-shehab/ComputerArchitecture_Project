
package architecture_proj;
public class Controls {
    //data
    boolean RegDest;
    boolean Jump;
    static boolean Branch;
    static boolean MemRead;
    static boolean MemToReg;
    static int ALUOp;
    static boolean MemWrite;
     boolean AluSrc;
    static boolean RegWrite;
    //methods
    public Controls(int opcode)
    {
        switch(opcode)
        {
            case 0: //RFormat
                if(RFormat.getF()==8)//jr
                {
                    RegDest=false;
                    Jump=false;
                    Branch = false;
                    MemRead= false;
                    MemToReg = false;
                    ALUOp = 10; // ALUControl haybos 3la el fn 3lshan da RFormat
                    MemWrite = false;
                    AluSrc = false;
                    RegWrite = false;//don't care
                    break;
                }
                    else
                {
                    RegDest=true;
                    Jump=false;
                    Branch = false;
                    MemRead= false;
                    MemToReg = false;
                    ALUOp = 10; // ALUControl haybos 3la el fn 3lshan da RFormat
                    MemWrite = false;
                    AluSrc = false;
                    RegWrite = true;
                    break;
                }
            case 8: //addi
                    RegDest=false;
                    Jump=false;
                    Branch = false;
                    MemRead= false;
                    MemToReg = false;
                    ALUOp = 00; 
                    MemWrite = false;
                    AluSrc = true;
                    RegWrite = true;
                    break;
            case 35: //lw
                    RegDest=false;
                    Jump=false;
                    Branch = false;
                    MemRead= true;
                    MemToReg = true;
                    ALUOp = 00; 
                    MemWrite = false;
                    AluSrc = true;
                    RegWrite = true;
                    break;
            case 43: //sw
                    RegDest=false;//don't care
                    Jump=false;
                    Branch = false;
                    MemRead= false;
                    MemToReg = true;//don't care
                    ALUOp = 00; 
                    MemWrite = true ;
                    AluSrc = true;
                    RegWrite = false;
                    break;
            case 40: //lb lesa hn3mlo
                    RegDest=false;
                    Jump=false;
                    Branch = false;
                    MemRead= true;
                    MemToReg = true;
                    ALUOp = 00; 
                    MemWrite = false;
                    AluSrc = true;
                    RegWrite = true;
                    break;
            case 41: //lbu lesa han3mlo
                    RegDest=false;
                    Jump=false;
                    Branch = false;
                    MemRead= true;
                    MemToReg = true;
                    ALUOp = 00; 
                    MemWrite = false;
                    AluSrc = true;
                    RegWrite = true;
                    break;
            case 39: //sb lessa han3mlo
                    RegDest=false;//don't care
                    Jump=false;
                    Branch = false;
                    MemRead= false;
                    MemToReg = true;//don't care
                    ALUOp = 00; 
                    MemWrite = true ;
                    AluSrc = true;
                    RegWrite = false;
                    break;
            case 4: //beq
                    RegDest=false;//don't care
                    Jump=false;
                    Branch = true;
                    MemRead= false;
                    MemToReg = true;//don't care
                    ALUOp = 01; 
                    MemWrite = false;
                    AluSrc = false;
                    RegWrite = false;
                    break;
            case 10: //slti
                    RegDest=false;
                    Jump=false;
                    Branch = false;
                    MemRead= false;
                    MemToReg = false;
                    ALUOp = 11;//assumption 
                    MemWrite = false;
                    AluSrc = true;
                    RegWrite = true;
                    break;
            
            case 2: //j
                    RegDest=false;//don't care
                    Jump=true;
                    Branch = false;
                    MemRead= false;
                    MemToReg = false;//don't care
                    ALUOp = 01;//not sure!!! don't care 
                    MemWrite = false;
                    AluSrc = true; //don't care not sure!!
                    RegWrite = false;
                    int i = (int)JFormat.gets1();
                    InstructionMemory.setPC(i);
                    break;
            case 3	:  //jal
                    RegDest=false;//don't care
                    Jump=true;
                    Branch = false;
                    MemRead= false;
                    MemToReg = false;//don't care
                    ALUOp = 01;//not sure!!! don't care
                    MemWrite = false;
                    AluSrc = true;//don't care
                    RegWrite = true;
                    int i1 = (int)JFormat.gets1();
                    RegisterFile.writeinregister(InstructionMemory.getPC(),31);
                    InstructionMemory.setPC(i1);
                    break;
        }
    
    }
    public void print()
    {
        System.out.println("RegDest :"+RegDest);
        System.out.println("Jump :"+Jump);
        System.out.println("Branch :"+Branch);
        System.out.println("MemRead :"+MemRead);
        System.out.println("ALUOp :"+ALUOp);
        System.out.println("MemWrite :"+MemWrite);
        System.out.println("ALUSrc :"+AluSrc);
        System.out.println("RegWrite :"+RegWrite);
    }
    public static int getALUOp()
    {
        return ALUOp;
    }
    public boolean getRegDest()
    {
        return this.RegDest;
    }
    public static boolean getRegWrite()
    {
        return RegWrite;
    }
    public static boolean getMemToReg()
    {
        return MemToReg;
    }
    public boolean getALUSrc()
    {
        return AluSrc;
    }
    public static boolean getMemRead()
    {
        return MemRead;
    }
    public static boolean getMemWrite()
    {
        return MemWrite;
    }
    public boolean getJump()
    {
        return this.Jump;
    }
    public static boolean getBranch()
    {
        return Branch;
    }
    
    
}
