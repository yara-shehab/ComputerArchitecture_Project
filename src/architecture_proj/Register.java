
package architecture_proj;
public class Register {
     String name;
     int value;
    public Register(String n,int v)
    {
        name=n;
        value=v;
    }
    public String getName()
    {
     return name;
    }
    public int getValue()
    {
        return value;
    }
    public  void setValue(int x)
    {
        value=x;
    }
    public  void setName(String n)
    {
        name=n;
    }
    
}
