# Java前言

### 遗留

1. Java文档阅读
2. 

## Java特点

1. 面向对象（OOP）
2. Java语言是健壮的。强类型机制、异常处理、垃圾自动收集
3. **跨平台**，源代码被编译后生成的文件在不同的设备上可以不经二次编译直接运行。各个操作系统有JVM虚拟机，所以.class文件在不同操作系统能被运行。
4. 解释型

### 解释型与编译型语言

#### 解释型语言

代码编译后需要被解释器执行

1. JavaScript
2. PHP
3. Java

#### 编译性语言

代码编译后直接被机器执行

1. C
2. C++

### 运行机制

```mermaid
graph LR
Hello.java --javac编译--> Hello.clasS
Hello.clasS --java运行--> 输出
```

## Java配置

### JVM

JVM是一个虚拟计算机，具有指令集并使用不同的存储区域。负责执行指令，管理数据、内存、寄存器，被包含在JDK中。

对不同的平台有不同的虚拟机

JVM机制屏蔽了底层运行平台的查别实现了“一次编译，到处运行”。

### JDK

JDK = Java Development Kit = JRE + Java开发工具，JRE = Java Runtime Environment = JVM + Java SE标准类，运行开发完成的Java程序只需具备JRE环境。

环境变量-添加JAVA_HOME环境变量指向 $E:\JDK$ - 编辑path环境变量增加%JAVA_HOME%\bin



## Java开发注意事项及细节

1. 源文件.java，源文件的基本组成部分是class，比如Hello类。

2. Java应用程序的执行入口是main()方法，有固定的书写方法：

   ```java
   public static void main(String[] args) {
   
   }
   ```

3. Java严格区分大小写

4. 一个源文件最多只能有一个public类，其他类个数不限

5. 如果源文件只有一个public类，文件名必徐按该类名命名

6. 源代码中每一个类，编译后，每一个类都有一个对应的.class文件生成

7. 主方法不仅可以在public类中，也可以同时存在其他的普通类中，编译后只需运行不同的类来实现运行该主方法。

## Hello Java~

```java
public class Hello {  //表示Hello是一个public类
	public static void main(string[] args) {  //表示一个主方法，程序的入口
		System.out.println("Hello,Java~");  //程序主体
	}
}
```

```shell
#编译
javac 文件
#运行
java 文件名
```

