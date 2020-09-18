
package architecture_proj;

public class IFormat extends Instruction{

    int opcode;
    int rs;
    int rt;
    int offset;
    static int s1 ;
    

    public IFormat(String s)
    {
        super(s);
        opcode = super.getopcode();
        
        String str2 = getinst().substring(6,11);
        rs = Integer.parseInt(str2, 2); 
        
        String str3 = getinst().substring(11,16);
        rt = Integer.parseInt(str3, 2);
        
        String str4 = getinst().substring(16,32);
        offset = Integer.parseInt(str4, 2);
        s1=offset;
       
    }
    /*@Override
    public  int getJump(){
        return 0;
    }*/
            @Override

    public int getSource1()
    {
        return rs;
    }
            @Override

    public int getSource2()
    {
        return this.rt;
    }
            @Override

    public int getDestination()
    {
    return 0;
    }
            @Override

    public int getFunction()
    {
    return 0;
    }
    public static int gets1()
    {
        return s1;
    }
            @Override

    public int getOffset()
    {
        return this.SignExtend();
        
    }
            @Override

        public  int getShamt()
        {
            return 0;
        
        }
        @Override
     public int SignExtend()
     {
         String str = getinst().substring(16,32);
         
         int signedValue = 0xffff0000;
         
        if(str.charAt(0) == '1') 
        {
            //handle negative values
            signedValue |= Integer.parseInt(str,2);
        }
        else {
            signedValue=  Integer.parseInt(str, 2);
        }
        return signedValue;
     }              
}
