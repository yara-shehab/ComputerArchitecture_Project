
package architecture_proj;
public class  RegisterFile {
    //data
     Register res1;
     Register res2;
     static Register destination;
     Register value1;
     Register value2;
     Register value3;
     static final int v=0;
     static int indexofdest;

    
    static Register[] RegisterFile = new Register[32];
    //constructor 
    public RegisterFile()
    {  
        RegisterFile[0]= new Register("$0",v);
        RegisterFile[1]= new Register("$at",0);
        RegisterFile[2]= new Register("$v0",0);
        RegisterFile[3]= new Register("$v1",0);
        for(int j=0, i=4;i<8;i++,j++)
        {
            RegisterFile[i]= new Register("$a"+j , 0);
        }
        for(int i = 8, j = 0; i < 16; i++, j++) 
        {
            RegisterFile[i] = new Register("$t" + j, 0);
        }
        for(int i = 16, j = 0; i < 24; i++, j++) 
        {
            RegisterFile[i] = new Register("$s" + j, 0);
        }
        for(int i = 24, j = 8; i < 26; i++, j++) 
        {
            RegisterFile[i] = new Register("$t" + j, 0);
        }
            RegisterFile[26] = new Register("$k0", 0);
            RegisterFile[27] = new Register("$k1", 0);
            RegisterFile[28] = new Register("$gp", 0);
            RegisterFile[29] = new Register("$sp", 100);
            RegisterFile[30] = new Register("$fp", 0);
            RegisterFile[31] = new Register("$ra", 0);
    }
    public void Reg(int rs,int rt,int rd,boolean RegDest,boolean MemToReg,boolean RegWrite)
    {
            value1 = RegisterFile[rs];
            value2 = RegisterFile[rt];
            value3 = RegisterFile[rd];
            if(RegDest==true)
            {
                indexofdest=rd;
                destination=value3;
            }
            else
            {
               indexofdest=rt;
               destination=value2;
            }
    }
    public static int getnumofdestination()
    {
        return indexofdest;
    }
    public static void writeinregister(int result,int numofreg)
    {        RegisterFile[numofreg].setValue(result);
    }
    public int getdata1()
    {
        return value1.getValue();
    }
    public int getdata2()
    {
        return value2.getValue();
    }
   /* public int getdata3()
    {
        return value3.getValue();
    }*/
    public static void print()
    {
        for(int i=0;i<32;i++)
        {
            System.out.println(RegisterFile[i].getName() + ":" + RegisterFile[i].getValue());
        }
    }

    public static int getIndexofdest() {
        return indexofdest;
    }
    public void printRegistersUsed()
    {
        System.out.println("rs :"+value1.getName() );
        System.out.println("rt :"+value2.getName() );
        System.out.println("rd :"+value3.getName() );

    }
            


}