# 01x00 introduction

## 01x01 What is an OS?

### User view

1. providing the interface between users and the computer

   GUI / CL / API

2. As an extended machine / virtual machine 现有机器的增强, 虚拟机器

### System view

1. A resources manager

   in time: different program take turns to use resources

   in space: each get parts of the resources

2. a program's scheduler: deciding the order of many process

## 01x02 OS historical

### First generation (1946 - 1955)

**manual operation and No OS 人工操作 无操作系统**

### Second generation(1955 - 1965)

**transistors and Simple Batch Systems 晶体管和简单单道批处理系统**

1. offline-I/O: 输入输出不在主机运行, 输入输出在前置机器读取
2. Batch System: 单次顺序运行多个程序

### Third generation(1965 -  1980)

**ICs and Multi - programming  集成电路和多道程序**

#### multi programming Batch System

multi jobs in Memory

#### time - sharing System

each user have a terminal, CPU take turns 

#### Real - time System

the key is time, have deadline

### Fourth generation(1980 - now)

**LSI(large scale integration) and Personal Computers**

1. Network OS
2. Distributed OS 分布式

## 01x03 Hardware reviews

### CPU

1. CPU is  brain of computer
2. CPU fetches instructions from memory and executes them
3. Each CPU has a special set if instructions that it can execute

#### register

PC : the memory address of the next instruction

SP : pointing the top of the current stack in memory

PSW程序状态字按位表示 :the condition code bits, the CPU priority, the mode, the control bits, 

#### modes

##### Kernel:内核态,核心态,管态, 完全存取所有硬件, 执行所有指令

1.  control I/O Devices
2. set System register
3. Handle system table
4. modify clock
5. manage interrupt
6. memory protection

##### User:用户态,目态, 执行部分CPU指令

#### Technical

pipeline : 流水线, 提升CPU处理指令的效率

super scalar : 超标量, 操作系统分配CPU的各个核心分工合理地完成一个程序的执行, 解决多核并发

#### -by architecture

##### RISC精简指令集

1. MIPS

   龙芯:server/PC

2. Alpha

   申威(超算)

3. Power

   非开源,起源IBM

4. ARM

   海思, 飞腾, 紫光展讯,MacOS

5. RISC-V

   开源, 华为, 阿里, 寒武纪

##### CISC复杂指令集

1. Intel
2. AMD:海光
3. Cyrix:兆芯

### Memory

(按速度递减)

1. Register

2. L1 cache

3. L2/L3 cache

4. RAM

   SRAM : 功耗高速度快

   DRAM : 功耗低速度慢

5. Hard Disk/SSD

6. CDROM/Type

也可以把全部内存放在CPU里, 但是价格昂贵, 有散热问题, 目前内存体系分配临界点就是为了追求PC性价比, 让更多的人能使用PC.

### IO

#### Two part

1. a device controller
2. the device itself

#### Device driver

a software that talks to controller , giving it commends and accepting reponses

the device can run in kernel mode

#### Three I/O can be done

1. Polling (busy waiting)
2. interrupt
3. DMA: 输入输出任务缓存到硬盘上, 进一步解脱CPU执行低效率工作

#### Spooling

系统执行打印程序, 把打印信息给虚拟打印机的spooling, 这样不会影响计算机执行后面的程序, 然后spooling根据打印机的状态再给打印机分配打印任务.

### BUS

#### from function

1. System bus
2. Data Bus
3. Address Bus
4. Control Bus

#### 南北桥

北桥: 链接CPU和内存

南桥: 链接CPU与外设

#### 总线举例

ISA

IDE

SCSI

PCIE

USB:Universal Serival Bus

SATA

NVME: sata, M.2

RS-232

RS-485

## 01x04 System Call

### concept

interface between the operating system and the user programs

execute TRAP instruction to transfer control to the OS

System Call enters the kernel mode

### 系统调用和程序本身调用区别

1. CPU所处模式不同:内核态和用户态
2. 返回时间不同:系统调用可能不是调用完立即返回, 本身调用立即返回

### 中断

#### interrupt

hard, from outer

硬中断/外中断, 中断源来自CPU外部, HW -> PRG

#### Trap

soft, from inner

软中断/内中断, 中断源来自CPU内部, PRG -> HW

## OS Structure

#### macro-kernel : 宏内核

核内包含操作系统的功能, 代表OS(Linux/Unix)

1. 安全稳定

2. 核太大

3. 核出现问题会引发操作系统问题

#### micro-kernel : 微内核

核内只保留接收中断和调用相关的程序, 代表OSMinix(Minix)

1. 核小
2. 不安全

#### hybrid : 混核

Win/Mac

## OS Function

1. process management
2. memory management
3. device management
4. File management

# 02x00 Processes & threads

## 02x01 Process Conception

#### what is process

A process is an executing program

#### Process VS Program

| Process                                                | Program                                                      |
| ------------------------------------------------------ | ------------------------------------------------------------ |
| dynamic                                                | static                                                       |
| temporary                                              | permanently                                                  |
| consist of program, data and process state information | a set of instructions                                        |
| one process can call multi-programs                    | one program can execute much times, which one is a new process |
| process have parallel and asynchrony 并行和异步        | not have                                                     |

## 02x02 Process Describe

### Process state: Dynamic

<img src="https://cdn.jsdelivr.net/gh/chousinbin/Image/202304241132201.png" alt="image-20230424113249470" style="zoom: 25%;" />

#### Ready

at Memory, waiting CPU (进程已经加载到内存, 等待 CPU执行它)

stopped to let another processs run (Running态时, 超时timeout, 遇见优先级高priority的线程, 会回退到Ready)

#### Running

using the CPU

#### Blocked

unable to run until some external event happens

正在Running的程序缺少要计算的资源时, 有Running转为Blocked态, wait I/O, I/O准备好数据, 由Blocked态转为Ready态

#### Suspending

当内存不足以加载一个优先级高的进程时, 把一些Blocked的进程打包到虚拟内存(硬盘里)的过程叫做Suspending

### PCB: Static

#### PCB

PCB进程的唯一表示, 用结构表示进程

1. PID:进程ID
2. PName:进程名称
3. Start Address
4. length
5. priority
6. state
7. CPU%
8. message pointer
9. family

#### PCB Management

Sequence table

Link List

Index table

组织起来顺序表, 链表, 双向表

## 02x03 Process Control

### Four principal events cause processes to be created

1. System initialization.

2. Execution of a process-creation system call by a running process.

3. A user request to create a new process.

4. Initiation of a batch job.

### Four principal events cause processes to be terminated

1. Normal exit (voluntary).

2. Error exit (voluntary).

3. Fatal error (involuntary).

4. Killed by another process (involuntary).

## 02x04 Thread Conception

### reason

1. network development
2. CPU speed high quickly, 多线程运行程序缓解CPU过快I/O过慢的的情况
3. Problem mode changed
4. Application request changed
5. multi - CPU & multi - core

进程切换switch之前要有一定时间用来加载下一个进程的PCB信息和更新保存上一个进程的PCB信息, 效率不高, 浪费时间,

### Process Vs Threads

Processes are used to group resources together
Threads are the entries scheduled for execution on the CPU.
The threads share an address space,open files,and other resources.

## 02x05 Thread Describe

线程保证进程的并发, 让进程的并发更加并发从而保持进程被执行

Dynamic : state - Diagram

Static : TCB (Thread control Block) 线程控制块(Register / pointer) cpu寄存器的值, 栈的指针

TCB 数量级比PCB小 , 占用资源少, 切换代价小

### Image

![IMG_0315](https://cdn.jsdelivr.net/gh/chousinbin/Image/202304271136361.JPG)

## 02x06 Thread Level

线程最忌讳的是跨进程的调度线程, 适得其反

### User - level (Unix)

OS, 不能看到PCB, 不能调用PCB

### Kernel - level (Windows)

OS, 能看到TCB和PCB, 能调用TCB和PCB

## 02x07 IPC

### critical resource 临界资源

 share resource accessed only by one process at the same time同一时刻只能被一个进程访问 [慢速共享设备]

### critical region / section 临界区域

the part of program that access critical resource (sharing resource)

### mutually exclusive 互斥

the way make sure critical resource only by one process access

### race condition 竞争条件

a situation if access critical resource , find result depend on who run next (execute order)

### solution

1. No two process maybe simulate inside the critical region
2. no assumotion maybe made about speed & number of CPU
3. No process running outside it's critical region may block other process
4. No process should have to wait forever to enter its critical region

## 02x08 Semaphores

![image-20230708170700747](https://cdn.jsdelivr.net/gh/chousinbin/Image/202307081707019.png)

等待队列指针的值为负数, 代表有几个进程正在等待该资源

## 02x09 P-V 原语

### P(s)

Request Resource

![image-20230708175449134](https://cdn.jsdelivr.net/gh/chousinbin/Image/202307081754344.png)

### V(s)

Release Resource

![image-20230708175500863](https://cdn.jsdelivr.net/gh/chousinbin/Image/202307081755073.png)

### Mutual exclusive

互斥

![image-20230708175431389](https://cdn.jsdelivr.net/gh/chousinbin/Image/202307081754628.png)

![image-20230708175919345](https://cdn.jsdelivr.net/gh/chousinbin/Image/202307081759590.png)

### Synchronization Semaphores 

同步信号量

![image-20230708180227814](https://cdn.jsdelivr.net/gh/chousinbin/Image/202307081802035.png)

![image-20230708181208979](https://cdn.jsdelivr.net/gh/chousinbin/Image/202307081812218.png)

![image-20230708181406431](https://cdn.jsdelivr.net/gh/chousinbin/Image/202307081814639.png)

![image-20230708181419369](https://cdn.jsdelivr.net/gh/chousinbin/Image/202307081814563.png)

### Summary

![image-20230708181446746](https://cdn.jsdelivr.net/gh/chousinbin/Image/202307081814011.png)

![image-20230708181705430](https://cdn.jsdelivr.net/gh/chousinbin/Image/202307081817796.png)

![image-20230511105002771](https://cdn.jsdelivr.net/gh/chousinbin/Image/202305111050048.png)

## 02x10 Classical IPC

### Producer - Consumer

![image-20230708184959150](https://cdn.jsdelivr.net/gh/chousinbin/Image/202307081849380.png)

![image-20230708185700796](https://cdn.jsdelivr.net/gh/chousinbin/Image/202307081857029.png)

### Writer - Reader

![image-20230708190125007](https://cdn.jsdelivr.net/gh/chousinbin/Image/202307081901301.png)

![image-20230708190638786](https://cdn.jsdelivr.net/gh/chousinbin/Image/202307081906994.png)

![image-20230708190622672](https://cdn.jsdelivr.net/gh/chousinbin/Image/202307081906894.png)

## 02x11 Scheduling

### Conception

#### scheduling

make a choice who run next

#### scheduler

a part of OS, such as a part of code / program

#### algorithm

the algorithm it uses

### Scheduling Ways

1. preemptive 抢占
2. non- preemptive 非抢占

### Process Behavior

1. CPU - bound process(CPU密集型), short I/O burst
2. I/O -bound process(I/O密集型), short CPU burst

### 3-level Scheduling

1. Admission scheduler
2. CPU scheduler
3. Memory scheduler

### When to scheduling

1. process created
2. process exited
3. process blocked
4. get I/O / interrupte

### Function

1. save status of last process
2. select one to run next
3. swap context

### Categories of scheduling

1. batch system 批处理
2. interactive 交互式
3. real time 实时

### Scheduling Goal

#### all - system

1. fairness
2. balance
3. policy enforcement

#### Batch system

1. throughput吞吐量: 单位时间内完成任务的个数
2. turn round周转时间 = $T_{end} - T_{submit}$
3. $weight round = \frac{T_{turnround}}{T_{run}}$ 
4. CPU utility

#### Interactive System

1. response time [响应时间]: $T_{start} - T_{submit}$
2. proportionality [与期望相吻合]: 

#### Read - time System

1. Deadline[生死线]: 硬实施
2. predictable: 软实施, 可预测

### Schedling in batch System

1. FCFS (first co first service) 先进先服务
2. SJF (shortest job first)
3. SRN(shortest remain next)最短剩余优先
4. HRN(High Response Next) 高响应比的优先 $R = \frac{T_{turnround}}{T_{exec}} = 1 + \frac{T_{wait}}{T_{exec}}$

### Scheduling in interactive System 

1. RR (Round - Robin) 轮转时间片

   | P    | Arrive | Run(q=2) |
   | ---- | ------ | -------- |
   | A    | 0      | 3        |
   | B    | 0      | 2        |
   | C    | 0      | 1        |

   顺序:A2B2C1A1

   时间片为2, 当执行到C进程是只消耗1个单位时间其小于时间片2, 执行完C进程, 定时器归零重新计时, 只保证每个进程不超过时间片2

2. Priority优先级

   | P    | Arrive | Run  | Priority |
   | ---- | ------ | ---- | -------- |
   | A    | 0      | 6    | 0        |
   | B    | 2      | 4    | 1        |
   | C    | 4      | 2    | 2(High)  |

   顺序:A2B2C2B2A4

3. Multi - Queue轮转队列

4. Shortest Process Next最短进程优先 : $T_2 = \alpha T_0 + (1 - \alpha)T_1$ (Aging 老化算法) 根据之前的数据预测未来的数据

5. Guarantee保证算法 : 如果有n个User, 保证给每个User, 1/n资源

6. Fairness 公平算法 : one user 1 process & another one User 9 process, one 1/10, another one 9 / 10

7. lottery彩票算法 : 

在操作系统中要减少进程的切换,所以wdg老师个人认为4567算法难以实施不好用.

### Scheduling in Runtime System 

$\sum_{1}^{m} \frac{C_i}{P_i} <= 1$称为schedulable

m事件的个数, C为cost, P为peried

|               | P1   | P2   | P3   |
| ------------- | ---- | ---- | ---- |
| cost          | 50   | 30   | 100  |
| Period        | 100  | 200  | 500  |
| 0.85 <= 1安全 | 0.5  | 0.15 | 0.2  |

## 02x12 Thread Scheduling

![image-20230708201555085](https://cdn.jsdelivr.net/gh/chousinbin/Image/202307082015339.png)

![image-20230708201706903](https://cdn.jsdelivr.net/gh/chousinbin/Image/202307082017162.png)

## 02x13 Deadlock

### Conception

Deadlock is a set of process if each process in the set is wait for an event that only by another process in the set can cause

#### resource

1. Preemptible : CPU / RAM, High speed
2. non - Preemptible : Printer / CD Rom / Plotter Low speed(死锁通常发生在这类不可抢占资源)

#### acquisition a resource

request (use semaphore in wrong order) -> use -> release

### Condition

以下四个条件缺一不可

1. mutually exclusive(互斥resource)
2. non - Preemptible(不可抢占resource)
3. hold & wait(process持有一部分资源 等待一部分资源)
4. Circular wait(process)

### Solution 

![image-20230710152850720](https://cdn.jsdelivr.net/gh/chousinbin/Image/202307101528995.png)

### Deadlock Prevention

1. Attacking mutual exclusive : Spooling everything

2. Attacking hold & wait : request all resources inittially

3. Attacking non - preemptive : take resources away

4. Attacking circular waiting : order resources numerically

### Deadlock Avoidance

#### state

1. safe, can not get deadlock through a algorithm
2. unsafe big may be deadlock

#### Banker's algorithm with single- resource

![image-20230710151032993](https://cdn.jsdelivr.net/gh/chousinbin/Image/202307101510352.png)

#### Banker's algorithm with multi - resource

![image-20230710151056106](https://cdn.jsdelivr.net/gh/chousinbin/Image/202307101510332.png)

<img src="https://cdn.jsdelivr.net/gh/chousinbin/Image/202305221136731.png" alt="image-20230522113604444" style="zoom:33%;" />

$E_j = \sum_{1}^{n} C_{ij} + A_j$

### Deadlock Detected & Recover 

#### Deadlock Detection with One Resource of Each Type

| 进程 | 占有 | 申请  |
| ---- | ---- | ----- |
| A    | R    | S     |
| B    |      | T     |
| C    |      | S     |
| D    | U    | S & T |
| E    | T    | V     |
| F    | W    | S     |
| G    | V    | U     |

<img src="https://cdn.jsdelivr.net/gh/chousinbin/Image/202305221138201.png" alt="image-20230522113855109" style="zoom: 33%;" />

#### Deadlock Detection with Multiple Resources of Each Type

#### recover

(1) preemptive 抢只能是释放部分资源

(2) killing process

(3) Rollback [check point]

# 03x00 Memory Management

## 03x01 Conception

### space

Program Name space : in editor

Address space : the address in disk

Memory space : in memory

### relocation space 

#### static

![image-20230710163918767](https://cdn.jsdelivr.net/gh/chousinbin/Image/202307101639974.png)

#### dynamic

动态调度,地址是浮动的,提高内存效率

![image-20230710165000283](https://cdn.jsdelivr.net/gh/chousinbin/Image/202307101650517.png)

### address protected : 

1. Protection code in PSW

   验证保护码, 符合才能访问

2. Base / limit register

   规定程序地址范围

## 03x02 Partition Management

缺点产生大量碎片, 造成资源浪费, 还有程序无法离散存储

### static partition

1. same size : 多用户操作系统中,给每个用户分配的内存空间是平均的, 内存利用率低
2. not same : 给每个用户分配的内存空间是不等的

### dynamic

动态分区, 根据程序大小为其分配空间, 缺点是会产生大量内存碎片, 造成资源浪费

### Management for partition

#### Link List & Sequence

![image-20230710170534844](https://cdn.jsdelivr.net/gh/chousinbin/Image/202307101705095.png)

#### Bitmap

![image-20230710170549492](https://cdn.jsdelivr.net/gh/chousinbin/Image/202307101705795.png)

### Search Algorithm for Partition

#### Best Fit

查找时间成本高, 会产生内存碎片, 可能找到最佳匹配

#### First Fit

只要找到满足内存大小的分区, 就把进程装进去; 速度快查找时间短, 每次从头开始找, 前部分内存区域占用高, 后半部分占用低

#### Next Fit

把上一个找到的分区,作为此次寻找的起点, 

#### Worst Fit

优先选取最大的

## 03x03 Paging Management

解决离散存储和碎片产生的问题, 缺点需要访问页表, 造成效率不高

### idea

给内存分块, 进程按块存储

![image-20230710172846911](https://cdn.jsdelivr.net/gh/chousinbin/Image/202307101728136.png)

碎片产生少, 程序在内存能离散的存放, 耗时

### Block size

块的大小按照$2^n$进行确定, 这样在电脑的二进制世界中, 定位比较快, 计算得快

### Relocation

创建Page Table, 并把table的起始地址和长度加载到进程的PCB中, 这样运行程序时, 就能找到对应的地址关系, 硬盘中的页和内存的块在页表中是

![image-20230710173528710](https://cdn.jsdelivr.net/gh/chousinbin/Image/202307101735919.png)

### Address  translation

![image-20230711103905914](https://cdn.jsdelivr.net/gh/chousinbin/Image/202307111039160.png)

## 03x04 Memory Enlarge

解决当应用程序所占存储空间大于物理内存容量的时候, 保证计算机还能运行该大空间程序

### Overlays

![image-20230711104557045](https://cdn.jsdelivr.net/gh/chousinbin/Image/202307111045277.png)

### Swapping

![image-20230711104813622](https://cdn.jsdelivr.net/gh/chousinbin/Image/202307111048844.png)

### Virtual Memory

![image-20230711105242081](https://cdn.jsdelivr.net/gh/chousinbin/Image/202307111052295.png)

## Demand Paging Management 请求页式

## Replacement Algorithm

### OPT(optimal)

内存留了3个, 最佳的意思为置换之后可能用不到的

|      | 0    | 1    | 2    | 3    | 0    | 1    | 4    | 0    | 1    | 2    | 3    | 4    |
| ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- |
| 1    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 0    | 2    | 2    | 2    |
| 2    |      | 1    | 1    | 1    | 1    | 1    | 1    | 1    | 1    | 1    | 3    | 3    |
| 3    |      |      | 2    | 3    | 3    | 3    | 4    | 4    | 4    | 4    | 4    | 4    |
|      | X    | X    | X    | X    | √    | √    | X    | √    | √    | X    | X    | √    |

A=12, 缺页F = 7 , 置换R = 4

### NRU(Not Recently Used)

置换最近未被使用的

### FIFO(First In First Out)

|      | 0    | 1    | 2    | 3    | 0    | 1    | 4    | 0    | 1    | 2    | 3    | 4    |
| ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- |
| 1    | 0    | 1    | 2    | 3    | 0    | 1    | 4    | 4    | 4    | 2    | 3    | 3    |
| 2    |      | 0    | 1    | 2    | 3    | 0    | 1    | 1    | 1    | 4    | 2    | 2    |
| 3    |      |      | 0    | 1    | 2    | 3    | 0    | 0    | 0    | 1    | 4    | 4    |
|      | X    | X    | X    | X    | X    | X    | X    | √    | √    | X    | X    | √    |

### SC(Second Chance)

|      | 0    | 1    | 2    | 3    | 0    | 1    | 4    | 0    | 1    | 2    | 3    | 4    |
| ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- |
| 1    | 0    | 1    | 2    | 3    | 0    | 1    | 4    | 0    | 1    | 2    | 3    | 4    |
| 2    |      | 0    | 1    | 2    | 3    | 0    | 1    | 4    | 0    | 1    | 2    | 3    |
| 3    |      |      | 0    | 1    | 2    | 3    | 0    | 1    | 4    | 0    | 1    | 2    |
| 4    |      |      |      | 0    | 1    | 2    | 3    | 3    | 3    | 4    | 0    | 1    |
|      | X    | X    | X    | X    | √    | √    | X    | √    | √    | X    | X    | X    |

### Clock

### LRU(Least Recently Used)

最近最少使用

### NFU(Simulate LRU, Not Frequency Used)



# 04x00 Device Management

## 04x01 I/O hardware

### I/O device 

#### by the unit

Block : 4KB, disk, tape, CD - rom

Char : 1B, keyboard, mouse, printer

Clock : Special

### Device controller

#### consist

1. device itself
2. device controller
   1. control register
   2. data register
   3. status register
   4. data buffer数据缓冲区

#### function

1. accept the commands from the CPU
2. data exchange
3. record and report the status
4. error detection

### Addressing mapped

CPU communicate with control register and buffer need addressing technology

#### address mode

1. separate I/O and memory space : 独立编地址, 连接总线的两个设备在总线互不干扰, 最多只有一个设备抢占总线
2. Memory - Mapped I/O : I/O映射在内存里, 对总线的抢占只有内存抢占
3. Hybrid 

![image-20230711144921434](https://cdn.jsdelivr.net/gh/chousinbin/Image/202307111449634.png)

## 04x02 I/O control

### Programed I/O

CPU do all works, busy waiting, tying CPU full time until all the I/O done

### Interrupt I/O

### DMA I/O

DMA controller 

### channel

直接通过通道进行设备与内存之间的数据交换

character - channel

Selected - channel

Array - channel

## 04x03 I/O software

### Goals of I/O software

#### device independent

设备独立性, 软件通用性

#### uniform naming

统一命名, 

#### error handling

错误处理, 

#### synchronous Vs asynchronous 

同步异步问题, 

#### Buffering

缓冲区, 解决速度不匹配的问题

#### share & dedicate_device

deadlock program

### I/O software layer

| I/O software layer                |      |
| --------------------------------- | ---- |
| User - level I/O software         |      |
| Device - independent I/O software |      |
| Device drivers                    |      |
| Interrupt handles                 |      |

#### Interrupt handles

wake up driver when I/O completed

#### Device drivers

driver control device, running in kernel

1. accept abstract request from device - independent software and translate it to concrete terms
2. check status
3. set up device registers
4. initialize device
5. Start I/O

#### Device - independent I/O software

1. uniform interface for device drivers
2. Buffering
3. error reporting
4. allocating and release dedicated devices
5. protection

#### User - Level I/O

1. making system calls
2. put their parameters in appropriate place
3. formatting I/O
4. spooling

## 04x04 Disk

### Disk formatting

#### Low level formatting

低级分区针对的是硬盘本身结构

![image-20230711155205499](https://cdn.jsdelivr.net/gh/chousinbin/Image/202307111552714.png)

![image-20230711155242682](https://cdn.jsdelivr.net/gh/chousinbin/Image/202307111552922.png)

#### High level formatting

高级分区是针对整个硬盘逻辑分区之后硬盘按部分进行的格式化

### Disk Arm Scheduling Algorithm

#### FCFS : 先来先服务

#### SSF : 最短寻道优先

#### Elevator : 向上或向下循环

# 05x00 Files Management

## 05x01 Files

### naming

字母数字特殊字符组成, 最长不超过255个字符, 是否区分大小写, 名称.扩展名, 表示文件的基本特性

### Structure

1. Byte sequence : OS do not know what is in the file

2. record sequence

3. Tree

### type

1. regular files
   1. character special files
   2. block special files
   3. ASCII files
   4. binary files
2. directories

### access

1. sequential access
2. random access

### attributes

files consist of date and attributes

### operating

1. create

2. delete

3. open

4. close

5. read

6. write

7. append

8. seek

9. get attributes

10. set attributes

11. rename


## 05x02 Directory

### single level directory system

所有文件都放在根目录, 无法重名

### hierarchical directory system

有目录

### path

#### absolute path name

绝对路径, 从根目录开始, Win反斜杠Linux斜杠

#### relative path name

相对当前目录

## 05x03 File System implement

### file system layout

independent file system in each partition

sector 0 of the disk is called MBR, it used to boot the computer

the end of the MBR is the partition table, which give the start and end address of each partition	

### implement files

![image-20230711181132138](https://cdn.jsdelivr.net/gh/chousinbin/Image/202307111811403.png)

![image-20230711181116554](https://cdn.jsdelivr.net/gh/chousinbin/Image/202307111811811.png)

![image-20230711181100813](https://cdn.jsdelivr.net/gh/chousinbin/Image/202307111811131.png)

![image-20230711181052068](https://cdn.jsdelivr.net/gh/chousinbin/Image/202307111810411.png)

## 05x04 Disk Space Management

### keeping track of free blocks

1. a linked list of disk blocks 

2. bitmap

![image-20230711182206692](https://cdn.jsdelivr.net/gh/chousinbin/Image/202307111822964.png)

物理转储和逻辑转储是两种数据备份和存储的方法，通常用于计算机系统或数据库管理中。

物理转储（Physical Dump）是将整个计算机系统或数据库的物理状态以二进制形式复制到外部存储介质中的过程。它包括操作系统、应用程序、配置设置、数据文件等所有相关信息的完全复制。物理转储通常是通过创建一个映像或镜像文件来实现的，这个文件可以被还原到原始系统中以恢复数据。

逻辑转储（Logical Dump）则是将特定应用程序或数据库的逻辑结构和内容以一种可读性更高的格式进行备份的过程。逻辑转储仅备份数据库的逻辑视图，包括表、字段、索引、触发器等对象的定义和数据。与物理转储不同，逻辑转储不包含底层操作系统或其他应用程序的信息。

物理转储和逻辑转储各有其优点和用途。物理转储适用于需要完全还原整个系统状态的情况，例如在灾难恢复（如硬件故障）或系统迁移时。逻辑转储则更适合于仅需要备份和恢复特定的应用程序或数据库的情况，例如进行数据迁移、测试和开发环境的创建等。

需要注意的是，物理转储和逻辑转储都属于数据备份的手段，而不是数据迁移或同步的解决方案。在实际应用中，根据具体需求和情境，选择合适的备份策略和工具非常重要。

# 科普

### 华为产品线

#### 芯片

1. 麒麟(手机CPU)
2. 巴龙(手机5G)
3. 天罡(基站5G)
4. 鲲鹏(PC/sever)
5. 昇腾AI(NPU/APU)
6. 凌霄(WiFi)
7. 鸿鹄(IOT物联网)

#### OS

1. 鸿蒙
2. Euler:基于CentOS
3. Gauss DB:数据库

### 国产OS

1. 深度 Deepin
2. 统信uOS
3. 优麒麟Ubuntukylin
4. 红旗Linux
5. 中标麒麟Neoklin
6. 鸿蒙
7. Euler
8. 龙蜥anolisOS
9. 中科方
10. 普华Linux
11. AliOS
