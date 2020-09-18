
package architecture_proj;
import java.util.*;
public class Architecture_proj {
    public static void main(String[] args) {
        int j = 0;
        Scanner sc = new Scanner(System.in);
        InstructionMemory il = new InstructionMemory();  
        RegisterFile f = new RegisterFile();
        Mem h = new Mem();
        System.out.println("Please enter the number of instructions you would enter!");
        int noi;
        noi = sc.nextInt();
        InstructionMemory.setPC(j);
        for(int z=0;z<noi;z++)
        {
            System.out.println("Please enter the instruction (IN BINARY!)");
            String s = sc.next();
            if(s.length()!=32)
            {
                System.out.println("INVALID INSTRUCTION");
                return ;
            }
            il.setValue(z, s);
        } 
        int k=0;
        while(k<=(noi-1))
        {
            Instruction i = il.instruction_decode();
            k = InstructionMemory.getPC();
            Controls c = new Controls(i.getopcode());
            System.out.println("The crontrols is ");
            c.print();
            f.Reg(i.getSource1(),i.getSource2(),i.getDestination(),c.getRegDest(),Controls.getMemToReg(),Controls.getRegWrite());
            f.printRegistersUsed();
            ALUControl x = new ALUControl(Controls.getALUOp(),i.getFunction());
            ALUOperation o = new ALUOperation(x.getALUControlFinal(),f.getdata1(),f.getdata2(),c.getALUSrc(),i.getOffset(),i.getShamt());   
            switch(i.getopcode())
            {
                 case 41:      
                 h.loadbyteunsigned(Controls.getMemRead(),o.getALUResult()); 
                 break;
                 case 40:
                 h.loadbyte(Controls.getMemRead(),o.getALUResult());
                  break;
                case 35:
                 h.loadword(Controls.getMemRead(),o.getALUResult());
                  break;
                case 39:
                  h.storebyte(Controls.getMemWrite(),f.getdata2(),o.getALUResult());
                  break;
                case 43:
                 h.storeword(Controls.getMemWrite(),f.getdata2(),o.getALUResult());
                  break;
            }
    }
        RegisterFile.print();
        h.print();
}
}
       //Memory.print(); elmafroud atba3 eli esta5damto bas 
     

