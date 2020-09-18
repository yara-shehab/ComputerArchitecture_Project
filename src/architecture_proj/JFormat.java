
package architecture_proj;
public class JFormat extends Instruction {
    //data
    int opcode;
    static String jump;
    static int g =0;
    public JFormat(String s)
    {
        super(s);
        opcode = super.getopcode();
        jump = getinst().substring(6,32);
        String str2 = "00"+jump; //28 bits
        String f = "0000"+str2;        
        long l = Long.parseLong(f,2);
        g = (int)l;
    }
            @Override

    public int getopcode()
    {
        return opcode;
    }
            @Override

    public int getSource1()
    {
        return 0;
    }
            @Override

    public int getSource2()
    {
        return 0;
    }
            @Override

    public int getFunction()
    {
    return 0;
    }
            @Override

    public int getDestination()
    {
        return 0;
    }
            @Override

    public int getOffset()
    {
        return 0;
    }
            @Override

    public  int getShamt()
        {
            return 0;
        }
            @Override

    public int SignExtend()
        {
        return 0;
        }
    public static int gets1()
    {
        return g;
    }
           
}
