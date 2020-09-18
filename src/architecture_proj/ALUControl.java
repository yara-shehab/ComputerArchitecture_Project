
package architecture_proj;


public class ALUControl  {
    int ALUOp;
    int function;
    int ALUControlFinal;
    ALUControl(int ALUOp,int function)
    {
      this.ALUOp=ALUOp;
       if(ALUOp==10)
     {
        //RFormat
        switch(function)
        {
            case 32: //add
                ALUControlFinal = 2;
                break;
            case 0: //sll 
                ALUControlFinal = 3;
                break;
            case 39: //nor
                ALUControlFinal = 1; //
                break;
            case 8: //jr
                ALUControlFinal = 4; //jr
                break;
            case 42: //slt
                ALUControlFinal = 7; 
                break;
        }
        
    }
    else if(ALUOp==00) //add for lw sw ...
    {
        ALUControlFinal = 2;
    }
    else if(ALUOp==01) //sub for beq
    {
        ALUControlFinal = 5;
    }
    else  //slti  ...
    {
        ALUControlFinal = 0;
    }
    
    
    }
    public int getALUControlFinal()
    {
        return this.ALUControlFinal;
    }
}
