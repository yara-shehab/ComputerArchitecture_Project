# ComputerArchitecture_Project

1. Brief Description:
➢ The programming language used is Java. The project is divided to classes: “Instruction”, “InstructionMemory”, “RFormat”, “IFormat”, “JFormat”, “Register”, “RegisterFile”, “Controls”, “ALUControl”, “ALUOperation”, “Memory”, and the main class named “Architecture_proj”.
➢ We have created an abstract class “Instruction” that have 3 children:
• RFormat: Comprise the majority of commands of MIPS Assembly, for example addition, subtraction, division and multiplication, and all logical operations.
This format divides the 32 bits into: “opcode” (6 bits),”rs” (5 bits),” rt” (5 bits),” rd” (5 bits),” shamt” (5 bits),” FunctionCode” (6 bits).
• IFormat: Comprise the instructions where one of the values are directly passed in the code, the immediate instruction I-Type are characterized by operations with one value in the register and another in a part of the code, with the data of the maximum length of 16 bits. This format divides the 32 bits into: “opcode” (6 bits),”rs” (5 bits),” rt” (5 bits),” Offset” (16 bits).
• JFormat: Represents the instructions of unconditional jump) that extends from it. All instructions that should be supported are subclasses of one of the three super classes. This format divides the 32 bits into: “opcode” (6 bits),” jump” (26 bits).
➢ Each of them contains its fields and methods and attributes. When we create an object from one of them, it would have its own controls based on the opcode or function code if it is RFormat because that the opcode of this type of instruction is (000000) so the indentation of the instruction is by observing the function code.
➢ We have created also a class named “InstructionMemory” which have an array of String as fields and are initialize as empty array and have also methods for example “Instruction_Decode” that divide the 32 bits instruction based on its format. At the beginning of the program, this class set the PC using a method named “SetPC ()” with the value 0. And After every instruction the PC is incremented by 1. So, if we want to jump or branch we have to get the PC using the method “getPC ()”.
➢ We have created a class named “Register” that holds String name and an integer value. And contains its setters and getters that we use at the program then.
3
➢ The program holds also a class named “RegisterFile” that is composed of an array of 32
“Register” that we have mentioned before. Noting that at the initialization of the
program, we create an object of this class that contains 32 Registers named: $0, $at,
$v0…. and holds a value “0” at the beginning.
➢ The program have also a class named “Controls” that take the opcode from the
instruction (either it is RFormat, IFormat or JFormat) and generates the controls signals
to the different units of the path. Control signals are set according to the class of the
instruction when it is created with those controls we can determine if we would write in a
register or if we would read from the memory and other controls.
➢ We have also a class named “ALUControl” that take control signal (ALUOp) as an input
and based on this input it sends another signal to the class named “ALUOperation” so it
can execute the required operation (add, sub…).
➢ The “ALUOperation” takes input from the register file or from the “SignExtend” method
based on another control signal(ALUSrc) and (ALUOp) as we mentioned before, so the
answer of the operation is ready and also the “ZeroFlag” that we use if the current
Instruction is branch instructions “beq”.
➢ In addition of a class “Mem” that is composed of integer ArrayList of size 100 that are
initialized “0”. The memory could support many instructions as (lw,sw,lb,lbu,sb) because
of the methods supported in this class as(loadByte(),storeByte()..)that take input from
ALUOperation and controls signals (MemRead,MemWrite…) and based on those
controls it can either load from the memory(Byte or a word) in a specific address that we
take from the “ALUOperation” or store in it the result of the “ALUOperation”.
Each line in this ArrayList contains 1 Byte = 8 bits.So when we load a word we load 4
lines of the memory and then we concatenate them to form the word. As the store word,
we store the 4 bytes that form the word, each byte in his line. So the word takes 4 lines
then.
➢ For the Jump instruction (j, jal) when the “Controls” detect the instruction and sends the
“jump” control. The last 26 bits of the instruction pass by the “SignExtend” as it is an
JFormat and is shifted by 2 and the concatenated with the first 4 bits of the updated PC
and the result would be the next address we would jump for. finally, the PC would be
updated with the new address.
➢ For the branch instruction (beq), when the instruction arrive at the ALUOperation if the
“ZeroFlag” =1 and the control signal “Branch” is 1 also, the PC have to be updated. We
can update it when the 16 bits of the offset are SignExtend the shifted by 2 then added
to the PC+4.
4
➢ The “main” class is the one that uses all these components to simulate the MIPS data
path, first the we create a “RegisterFile” and the “Memory”. We ask the user to enter the
number of instructions “noi” he would enter so that he could fill the array of strings of the
“InstructionMemory” by entering “noi” String that represents the instruction in binary. It
has to be 32 bits else the program would terminate. Once we have the
“InstructionMemory” is ready with all instructions filled by the user, we start the decoding
and dividing the current instruction based on its format then sending the controls to the
units of the path and prints on the console the controls of the current instruction. Then
the execution takes place at the “ALUOperation” after receiving all the signals it needs
and the data stored in the chosen registers as source.
