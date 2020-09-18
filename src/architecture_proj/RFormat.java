
package architecture_proj;

public class RFormat extends Instruction {
    //data
    int opCode;
    int rs;
    int rt;
    int rd;
    int shamt;
    int funCode;
    static int f;
    
    
    public RFormat(String s)
    {
        super(s);
        
        opCode = super.getopcode();
        
        String str2 = getinst().substring(6,11);
        rs = Integer.parseInt(str2, 2);        
        
        String str3 = getinst().substring(11,16);
        rt = Integer.parseInt(str3, 2);        
        
        String str4 = getinst().substring(16,21);
        rd = Integer.parseInt(str4, 2);     
        
        String str5 = getinst().substring(21,26);
        shamt = Integer.parseInt(str5, 2);
        
        String str6 = getinst().substring(26,32);
        funCode = Integer.parseInt(str6, 2);
        f=funCode;
    }
            @Override

    public int getShamt()
    {
        return this.shamt;
                
    }
            @Override

    
    public int getSource1() {
        return rs;
    }
            @Override

    public int getSource2() {
        return rt;
    }
            @Override

    public int getDestination()
    {
        return this.rd;
    }
            @Override

    public int getFunction()
    {
        return this.funCode;
    }
          /*  @Override
            
    public  int getJump(){
        return 0;
    }*/

    public int getOffset()
    {
        return 0;
    }
            @Override

    public int SignExtend()
        {
        return 0;
        }
    public static int getF()
    {
        return f ;
    }
              
}
   /* public void StringToBinary()
    {
        char[] ch = new char[4];    
        this.inst.getChars(0, 3, ch, 0);  
        String y = String.copyValueOf(ch);
        
        if(y.contains("add"))
        {
            opCode=0;
            funCode=32;
        }
        if(y.contains("addi"))
        {
            opCode=8;
            
        }
        if(y.contains("lw"))
        {
            opCode = 35;
        }
        if(y.contains("sw"))
        {
            opCode = 51;
        }
        if(y.contains("lb"))
        {
            opCode = 32;
        }
        if(y.contains("lbu"))
        {
            opCode = 40;
        }if(y.contains("j"))
        {
            opCode = 2;
        }
        if(y.contains("j"))
        {
            opCode = 2;
        }
        if(y.contains("j"))
        {
            opCode = 2;
        }
        if(y.contains("j"))
        {
            opCode = 2;
        }
        }
*/
