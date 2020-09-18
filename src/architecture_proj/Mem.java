package architecture_proj;

import java.util.*;

public class Mem {

    //fields
    public ArrayList<Integer> dataMemory = new ArrayList<Integer>();
    //constructor
    public Mem() {
        for (int i = 0; i < 100; i++) {
            dataMemory.add(0);
        }
    }   
    public static String intToString(int n){
        String s = "";
            if (n > 0) {
                while (n > 0) {
                    if (n % 2 == 1) {
                        s = "1" + s;
                    }

                    if (n % 2 == 0) {
                        s = "0" + s;

                    }
                    n = n / 2;
                }
                s = "0" + s;

            } else if (n < 0) {
                n = Math.abs(n);
                while (n > 0) {

                    if (n % 2 == 1) {
                        s = "1" + s;
                    }

                    if (n % 2 == 0) {
                        s = "0" + s;

                    }
                    n = n / 2;
                }
                s = "1" + s;

            }
            else if (n==0)
                s="0";
        
        return s;
       }
    public ArrayList<Integer> getDataMemory() {
        return dataMemory;
    }

    public void setDataMemory(ArrayList<Integer> dataMemory) {
        this.dataMemory = dataMemory;
    }
    public void storebyte(boolean write, int n, int address) {
        if (write) {
            dataMemory.set(address, n);

        }
    }
    public void loadbyte(boolean read, int address) {
        if (read == true) {
            int z = address;
            RegisterFile.writeinregister(dataMemory.get(address), RegisterFile.getnumofdestination());
        }
    }

    public void loadbyteunsigned(boolean read, int address) {
        if (read == true) {
            int z = address;
                  if(dataMemory.get(address)<0)
                  {
                      int y =dataMemory.get(address);
                      y  = y & 0x000000ff;
                      RegisterFile.writeinregister(y, RegisterFile.getnumofdestination());

                  }
                  else
                  {
                       RegisterFile.writeinregister(dataMemory.get(address), RegisterFile.getnumofdestination());
                  }
            /*
            int z = address;
            int y = dataMemory.get(getByte(z));
            if (y < 0) {
                y = y & 0x000000ff;
            }
            RegisterFile.writeinregister(y, RegisterFile.getnumofdestination());
            System.out.println("x");
*/
        }
    }

    public void storeword(boolean write, int n, int address) {
       

      if (write) {
          
        String str = "";  
        str=intToString(n);
        int z = str.length();
      
        for (int i = 0; i < 32 - z; i++) {
            str = "0" + str;
            

        }
        String s1 = str.substring(0, 8);
        int n1 = Integer.parseInt(s1,2);
        String s2 = str.substring(8, 16);
        int n2 = Integer.parseInt(s2,2);
        String s3 = str.substring(16, 24);
        int n3 = Integer.parseInt(s3,2);
        String s4 = str.substring(24, 32);
        int n4 = Integer.parseInt(s4,2);

        dataMemory.set(address, n1);
        dataMemory.set(address + 1, n2);
        dataMemory.set(address + 2, n3);
        dataMemory.set(address + 3, n4);

    }

    }

    public void loadword(boolean read, int address) {
        if (read == true) {
            int n1 = dataMemory.get(address);
            int n2 = dataMemory.get(address + 1);
            int n3 = dataMemory.get(address + 2);
            int n4 = dataMemory.get(address + 3);
            String res = "";
            res = "" + n1;
            res += "" + n2;
            res += "" + n3;
            res += "" + n4;
            int z = Integer.parseInt(res);
            RegisterFile.writeinregister(z, RegisterFile.getnumofdestination());
        }

    }
    public void print()
    {
        for(int i=0;i<dataMemory.size();i++)
        {
            System.out.println("Mem["+i+"]"+"="+ dataMemory.get(i));
        }
    }
}

