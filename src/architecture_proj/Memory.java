
package architecture_proj;

public class Memory {
    int [] [] mem = new int [40][4];
    
    // int [][] mem = new int [40][4];
    // int a = ALUOperation.getALUResult();
    public Memory () {
        mem[0][0] = 0; 
        mem[0][1] = 0;
        mem[0][2] = 0;
        mem[0][3] = 0;
    }
    public static int setByte (int x)
	{
		String s = Integer.toBinaryString(x);
		String s2 = "0";
		for (int i = s.length(); i < 8;i++)
		{
			s2 = "0";
			s2 += s;
			s = s2;
		}
		for (int i = s.length(); i < 32;i++)
		{
			s2 += "0";
		}
		int foo = Integer.parseInt(s2, 2);
		return foo;
	}
    public static int getByte (int x)
	{
		String s = Integer.toBinaryString(x);
		String s2 = "0";
		for (int i = s.length(); i < 32;i++)
		{
			s2 = "0";
			s2 += s;
			s = s2;
		}
		s2 = s.substring(0, 8);
		int foo = Integer.parseInt(s2, 2);
		return foo;
	}
     public void loadByteUnsigned(boolean read,int a){
        if(read){
            int z = mem[a-a%4][a%4];
            if(z<0){
                z = z & 0x000000ff;
            }
            RegisterFile.writeinregister( mem[a-a%4][a%4],RegisterFile.getnumofdestination());
        }
        
    }
     public void loadByte(boolean read,int a){
        if(read){
            /*
            int z = mem[a-a%4][a%4];
            
         */
            int z = getByte(a);
            RegisterFile.writeinregister(z,RegisterFile.getnumofdestination());

        }
    }
       public void loadWord(boolean read,int a) {
        if(read) {
            int x = mem[a-a%4][0];
            int y = mem[a-a%4][1];
            y = y << 8;
            x = y | x;
            
            y = mem[a-a%4][2];
            y = y << 16;
            x = y | x;
            
            y = mem[a][3];
            y = y << 24;
            x = y | x;
            
           
            RegisterFile.writeinregister(x,RegisterFile.getnumofdestination());
        }
    }
    public void print(){
        for(int i=0;i<4000;i++)
        {
            for(int j=0;j<4;j++)
            {
                System.out.println(mem[i][j]);
            }
        }
    }
       public void storeWord(boolean write,int n,int a) {
        if(write) {
            int y = n & 0x000000ff;
            mem[a-a%4][0]=y;
             
            y = n & 0x0000ff00;
            y= y >> 8;
            mem[a-a%4][1]=y;
            
            y = n & 0x00ff0000;
            y= y >>> 16;
            mem[a-a%4][2]=y;
            
            y = n & 0xff000000;
            y = y >>> 24;
            mem[a-a%4][3]=y;
        }
    }
    public  void storeByte(boolean write,int n,int a){
        if(write)
        {
            /*
            n &= 0x000000ff;
            mem[a-a%4][a%4]=n;*/
            int x =setByte(n);
            mem[a-a%4][a%4]=x;
        }
    }
    
}