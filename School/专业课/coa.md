| 节数 | 加分  |
| ---- | ----- |
| 1    | 2+1+2 |
| 2    | 2     |
| 3    | 2     |
|      |       |
|      |       |

### 考试

1. 40个选择40分 来源于作业
2. 10分简答题
3. 30分计算题
4. 10分分析题

# 0x0 绪论

#### 计算机的组成

1. I/O
2. 总线
3. CPU
4. 主存

#### 计算机是怎么工作的

计算机做任何事情都是通过执行指令(instruction)来实现的，指令的执行者是CPU，指令在内存(memory)中。内存中又细分很多空间每个空间有一个内存地址(address)，每个空间占1Byte。

#### 高速缓存

cache memory高速缓存存储器解决CPU与主存运行速度的差异。

#### 进制

binary二进制

decimal十进制

hex十六进制

# 0x1 introduction

### organization and architecture

#### computer architecture

体系结构定义了那些对程序员显而易见的系统属性或那些直接强制程序逻辑执行的属性。它以用户对计算机系统视图的功能行为进行管理。

计算机体系结构与系统的编程部分一起管理，包括多位可以定义几种数据类型、输入输出方法、寻址内存的方法以及计算机的指令集。任何程序的实施都会受到这些架构品质的影响。位或大小的变化可能会给程序员带来不同的结果。

解释：两个程序员开发实现同一个功能，所采用不同的架构不同的算法，产品会给用户不同的体验。

#### computer organization

计算机组织可以研究数字计算机的基本计算机硬件结构和行为。它包括系统的操作单元，包括 CPU、内存、输入-输出单元及其互连。它还包括计算机进化和算术、并行组织、控制单元、计算机外围设备之间的接口、使用的存储技术、寄存器、总线工作和连接等。

解释：计算机组织是计算机的基本硬件结构和行为。

### instruction and function

function make instruction

#### computer function

1. date processing
2. date storage
3. date movement
4. Control

#### computer instruction

1. Central processing unit ：date processing
2. Main memory : Stores date
3. I/O ： date movement
4. System interconnetion : system bus

#### CPU

1. ALU（算数逻辑单元）
2. registers（寄存器）
3. CPU interconnection（CPU总线）
4. Control unit（控制器）

# 0x2 Computer Evolution And Performance

### Computer Evolution

#### The first generation: Vacuum Tubes(真空管)

**ENIAC**，University of Pennsylvania ,during World War，the fisrt computer of word.

**VON NEUMANN,stored-program concept** （冯诺依曼,提出程序存储概念）

### IAS Computer

#### Words & Instruction

IAS,1000 memory locations,calls **Words**. 1Words 40 binary digits,hava left and right **instruction**.

each instruction consisting of an 8-bit operation code **(opcode)** specifying the operation to be
performed and a 12-bit **address** designating one of the words in memory.

![](https://cdn.jsdelivr.net/gh/chousinbin/Image/instruction word.png)

Opcode操作码，操作码让CPU执行对应的操作。Address，指令携带的数据的地址。

操作码1：load ac from memory

操作码2：store AC to memory

操作码5：add to AC from memory

#### Memory

MAR：存储指令或数据在内存中的地址，通过地址总线与主存连接 Memory address register  

MBR：临时存储读来或者要写入的数据 或 指令 Memory buffer register  

PC：存储指令的地址Program counter  

IR：翻译解释指令Instruction register  

CU：控制器 control unit  

#### Cycle

fetch cycle：取指周期。

1. 把PC中的指令地址给MAR
2. 通过控制总线传输read指令，通过地址指令传输指令的地址从MAR到内存，读取内存中该指令地址的指令。
3. 通过数据总线把指令传输到MBR做临时存储
4. MBR把指令传输给IR翻译解释指令，为了下一步的执行周期。d

execute cycle：执行周期。

1. 把翻译解释后指令中的address给MAR
2. 把address通过地址总线传输到内存上，从内存找到这个地址的数据
3. 通过控制总线把read的权限给到那个地址的数据，读取address上的数据
4. 把数据通过数据总线传输到MBR上
5. 把数据从MBR拷贝到AC







## 中断IRS

#### 中断四步骤

1. spending挂起
2. branching转向
3. processing处理
4. rescuming恢复

BreakPoint断点

打印完I/O给CPU发送中断请求信号，暂停执行第N+M条指令，去执行打印收尾工作的程序，结束后执行第N+M+1条指令。

![202210061529084](https://cdn.jsdelivr.net/gh/chousinbin/Image/202210061529084.png)



![2](https://cdn.jsdelivr.net/gh/chousinbin/Image/202210111638598.png)







# 0x4cache

#### 物理性质

1. 是否可擦写Erasable/nonerasable  
2. 是否易矢Volatile/nonvolatile  

#### 访问方式

1. 随机Random
2. 顺序Sequential
3. 直接Direct
4. 关联Associative

#### 写策略write policy

1. write through 同时向缓存和主存中写
2. write back 先只向缓存中写,当缓存内容要被替换之前再写到主存中

## 第一道计算内存映射

#### 内存容量（word的个数）和内存地址（word的地址）宽度关系

一座楼有80个房间，则需要80个门牌号，十进制下门牌号宽度为2位（能表示00-99）

那么比如内存的容量是16M个word，则每个word二进制内存地址宽度为，$16M\ =\ 2^x\ \ x=24$，二进制地址宽度为24。



$1block=4words\\cache=64Kwords\\1line=4words=1block\\cache=16Klines$



### 直接映射direct mapping

$0x16339C\\00010110\ 00110011100111\ 00\\8bits-tag\ 14bits-line\ 2bits-word\\$

word内存地址内拆分出来14bits的line给cache中的line一一映射，因为cache中的line地址宽度也是14bits。

1个cache中的四个word的身份码就是14bits中最后2bits的word位。

从内存地址分析出来的line地址，我们再看line地址上的line对应个tag和我们要找的内存地址的line，如果不一样就要到内存中找到要找的block然后映射到cache的指定line中，再根据我们查找地址的word部分，确定我们要找的line中的word。

#### 缺点

命中率低，冲突。fixed

### 关联映射

$0x16339C\\0001011000110011100111\ 00\\22bits-tag\ 2bits-word\\$

#### 优点

命中率提高100，

#### 缺点

比较次数较多

### 组关联映射

$0x16339C\\000101100\ 0110011100111\ 00\\9bits-tag\ 13bits-set\ 2bits-word\\$

根据系统的不同，1set=2lines\1set=4lines\1set=8lines

#### 优缺点

提高命中率，减少查询次数。几路组关联，就最多比较几次。





# 0x5内存

#### DRAM

Dynamic动态:做内存

随机存取

易矢

write-read memory

可擦除

#### SRAM

Static静态：做缓存

随机存取

易矢

write-read memory

可擦除

有6个晶体管transistors

### Read-only

#### ROM

Read only Memory

不可擦除

不易失

#### PROM

可编程只读

### Read-mostly Memory 读操作比写操作多

#### EPROM

可编程可擦除只读

#### EEPROM

可编程电可擦除只读

#### FLASH

可擦除可编程EEPROM、不易失、

## 第二道计算、hamming code 海明码

1. 根据数据码位数M计算出检查码的位数K

   假设数据码8位为1001 1100

   $2^k-1\ >=\ M+K$

   K=4

2. 列出M+K位的海明码的表格

   | 位置 | 二进制数 | 校验码 | 数据码 |
   | ---- | -------- | ------ | ------ |
   | 1    | 0001     | C1     |        |
   | 2    | 0010     | C2     |        |
   | 3    | 0011     |        | D1     |
   | 4    | 0100     | C3     |        |
   | 5    | 0101     |        | D2     |
   | 6    | 0110     |        | D3     |
   | 7    | 0111     |        | D4     |
   | 8    | 1000     | C4     |        |
   | 9    | 1001     |        | D5     |
   | 10   | 1010     |        | D6     |
   | 11   | 1011     |        | D7     |
   | 12   | 1100     |        | D8     |

   $C_k的位置：2^k-1 \\ D_M的位置：除了校验位剩下的按位置从小到大依次排序$

3. 求校验码分别为多少

   根据$C_K$的二进制数中唯一的$1$所在的二进制位置，与其他位置的二进制数的相同的二进制位作比较，如果一个位置的二进制数的相同位也为1，那么记下此位置的$D_M$，找出所有的$D_M$后相异或就为$C_K$。

4. 根据海明码的数据码按照步骤3，形成新的效验码

5. 新的效验码与海明码中的效验码按位异或形成的二进制数的十进制数就是海明码中错误的数位



# 0x6外存

## disk

#### ID

cylinder

head/side

sector

#### access time

seek time:找轨道

rotational time:找扇区

#### transfer time

传输数据

## RAID

Redundant Array of Independent Disks  

#### 优点

1. 速度快
2. 容量大
3. 冗余盘能恢复

| Level | 盘数      | High I/O request rate高多用户请求 | High data transfer rate高单用户速度 | category                            |      |
| ----- | --------- | --------------------------------- | ----------------------------------- | ----------------------------------- | ---- |
| 0     | N         | N                                 | Y                                   | striping条带存储                    |      |
| 1     | 2N        | N                                 | Y                                   | Mirroring                           |      |
| 2     | N+m海明码 | N                                 | Y                                   | Parallel access同时满足一个读写请求 |      |
| 3     | N+1       | N                                 | Y                                   | Parallel access                     | 小条 |
| 4     | N+1       | Y                                 | N                                   | Independent access                  | 大块 |
| 5     | N+1       | Y                                 | N                                   | Independent access                  |      |
| 6     | N+2       | Y                                 | N                                   | Independent access                  |      |







































# 7输入输出



## DMA

![](https://cdn.jsdelivr.net/gh/chousinbin/Image/202211151610493.png)

## 中断











## 可编程传输



# 10补码

## 源码

符号1为负数

## 补码

#### 补码求非

原码取反，末位加1

#### 补码扩位

负数在符号位与原码位之间补1

正数在符号位与原码位之间补0

#### 补码求十进制数

$A=-2^{n-1}a_{n-1}+2^{n-2}a_{n-2}+...+2^0a_0$

### ALU

logic and arithmetic



# 12指令集instruction sets

高级语言 一对多 机器语言

机器语言的符号表示是汇编语言，汇编语言与机器语言一对一。

指令集：能被CPU理解的指令的集合

## elements

![](https://cdn.jsdelivr.net/gh/chousinbin/Image/202211171420780.png)

operand操作数：opcode操作码要操作的数据

opcode操作码

source 

#### where operand

1. memory
2. CPU register
3. I/O device
4. Immediate：立即，把指令的操作数的地址直接换成操作数，即操作数来源于指令

#### instruct

1. data processing
2. data storage
3. data movement
4. program flow control

指令里面必须有操作码opcode



SP:堆栈指针寄存器，存储栈顶的地址

# 寻址方式

## 直接寻址:

指令里面存放操作数的地址

## 立即数寻址:

指令里面存储操作数

#### 公式

A=operand

#### 优点



## 间接寻址:

指令里面存储操作数的地址的地址

## 寄存器寻址:

指令里面存储操作数所在的寄存器的地址

## 寄存器间接寻址:

指令里面存储寄存器的地址,操作数的地址在寄存器中



# 14CPU







# 19micro-operation



## fetch cycle

$$
t_1:(PC)\rightarrow MAR\\
t_2:(MAR) \xrightarrow{AB} Memory\\
CU \xrightarrow[read]{CB} Memory\\
t_3:Memory \xrightarrow{DB} MBR\\
t_4:(MBR) \rightarrow IR\\
(PC)+1 \rightarrow PC\\
$$

## indirect cycle

$$
t_1:Address(IR) \rightarrow MAR\\
t_2:(MAR) \xrightarrow{AB} Memory \\
CU \xrightarrow[read]{CB} Memory\\
t_3:Memory \xrightarrow{DB} MBR\\
$$

## execute cycle

$$
t_1:(MBR) \rightarrow MAR\\
t_2:(MAR) \xrightarrow{AB} Memory\\
CU \xrightarrow[read]{CB} Memory\\
t_3:Memory \xrightarrow{DB} MBR\\
t_4:(AC)+(MBR) \rightarrow AC\\
$$







#### 写操作的执行子周期

$STORED (AC),940H;$
$$
t_1:(AC) \rightarrow MBR\\
Address(IR) \rightarrow MAR\\
t_2:(MAR) \xrightarrow{AB} Memory\\
CU \xrightarrow[read]{CB} Memory\\
(MBR) \xrightarrow{DB} Memory\\
$$





### ISZ X

把X内的数据加一,如果结果为零跳过下一个指令.

#### execute cycle

$$
t_1:Address(IR) \rightarrow MAR \\
t_2:(MAR) \xrightarrow{AD} Memory\\
CU \xrightarrow[read]{CB} Memory\\
t_3:Memory \xrightarrow{DB} MBR\\
t_4:(MBR)+1 \rightarrow MBR\\
t_5:MAR \xrightarrow{AB} Memory\\
CU \xrightarrow[write]{CB} Memory\\
(MBR) \xrightarrow{DB} Memory\\
t_6:if((MBR)==0)\ (PC)+1 \rightarrow PC\\
$$











































































