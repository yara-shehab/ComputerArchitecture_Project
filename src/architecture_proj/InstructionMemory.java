
package architecture_proj;

public class InstructionMemory {
    //data
    static int pc=0;
    int opCode;
    String [] instructions = new String[100];
    
    //methods
    public Instruction instruction_decode()
    {
        Instruction ins;
        String i = instructions[pc];
        opCode = Integer.parseInt(i.substring(0, 6),2);
        if(opCode == 0) {
            //R type
            ins = new RFormat(i);
            
        }
        else if (opCode == 2 || opCode == 3) {
            //J type
            ins = new JFormat(i);
        }
        else {
            // I type
            ins = new IFormat(i);
        }
       pc++;
       // pc=pc+4;
        return ins;
    }
    public static void setPC(int x)
    {
       pc = x;
    }
    public static int getPC()
    {
        return pc; 
    }
    public static int getfirst4()
    {   
        int res=0;
        for(int i=1; i<=4; i++){
        res=(pc)%10;
        }
        return res;
    }
    public void setValue(int index ,String i )
    {
        instructions[index]=i;
        
    }
    
    public String  getins(int index)
    {
        return instructions[index];
    }
    
    //Automatic instruction loading
    public String getins()
    {
        return instructions[pc];
    }
    
   
}
