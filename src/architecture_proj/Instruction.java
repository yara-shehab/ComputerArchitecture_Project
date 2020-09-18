package architecture_proj;
import java.util.*;

public abstract  class Instruction {
    //data
    static String inst;
    
    //methods
    public Instruction(String s)
    {
        inst=s;
    }
    
    public static String getinst()
    {
        return inst;
    }
    public static void setins(String i)
    {
        inst = i;
    }
    public abstract int getSource1 () ;
    public abstract int getSource2 () ;
    public abstract int getDestination () ;
    public abstract int getFunction();
    public int getopcode() {
        return Integer.parseInt(inst.substring(0, 6), 2);
    }
    public abstract int getOffset();
    public abstract int getShamt();
    public abstract int SignExtend();
    
}  
    
    
    
