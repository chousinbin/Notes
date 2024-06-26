# 基础语法

## 代码规范

1. 类和方法的注释要使用文档注释
2. 非文档注释是给代码维护者看的，着重告诉读者为什么这样写、如何修改、注意什么问题
3. 选中的多行代码`TAB`整体右移，`TAB+SHIFT`整体左移
4. 运算符和=习惯两边各加一个空格
5. 源文件使用UTF-8编码
6. 行宽度小于等于80字符
7. 代码编写次行规则和**行尾规则**

### 标识符的命名规则和规范

#### 标识符概念

Java对各种变量、方法和类等命名时使用的字符序列称为标识符

#### 命名规则

> 规则必须遵守

1. 由26个英文字母大小写、0-9、下划线或$组成
2. 数字不可以开头
3. 不可以使用关键字和保留字，但能包含关键字和保留字
4. 严格区分大小写，长度无限制
5. 不能包含空格

#### 命名规范

> 更加专业

1. 包名：多单词组成时，所有字母都小写
2. 类名、接口名：多单词组成时，所有单词的首字母大写
3. 变量名、方法名：多单词组成时，第2个单词开始每个单词首字母大写
4. 常量名：所有字母都大写，多单词连接用下划线

#### 关键字

被Java语言赋予了特殊含义，用作专门用途的字符串，关键字中所有字母都为小写

| 数据类型  | 数据类型值 | 流程控制 | 访问权限修饰符 | 类函数变量修饰符 | 类类之间关系 | 实例建立、引用、判断 | 异常处理 | 包      | 其他      |
| --------- | ---------- | -------- | -------------- | ---------------- | ------------ | -------------------- | -------- | ------- | --------- |
| class     | true       | if       | private        | abstract         | extends      | new                  | try      | package | native    |
| interface | false      | else     | protected      | final            | implements   | this                 | catch    | import  | strictfp  |
| enum      | null       | switch   | public         | static           |              | super                | finally  |         | transient |
| byte      |            | case     |                | synchronized     |              | instanceof           | throw    |         | volatile  |
| short     |            | default  |                |                  |              |                      | throws   |         | assert    |
| int       |            | while    |                |                  |              |                      |          |         |           |
| long      |            | do       |                |                  |              |                      |          |         |           |
| float     |            | for      |                |                  |              |                      |          |         |           |
| double    |            | break    |                |                  |              |                      |          |         |           |
| char      |            | continue |                |                  |              |                      |          |         |           |
| boolean   |            | return   |                |                  |              |                      |          |         |           |
| void      |            |          |                |                  |              |                      |          |         |           |

#### 保留字

现有版本尚未使用，以后版本可能会作为关键字使用

| 保留字   |
| -------- |
| byValue  |
| cast     |
| future   |
| generic  |
| inner    |
| operator |
| outer    |
| rest     |
| var      |
| goto     |
| const    |

## 注释

```java
/**
	*
	*
*/
public class Comment {
    // 	单行注释 
    //  批量单行注释快捷键 CTRL+/
    
    /* 	多行注释
    	1
    	2
    	3
    	禁止嵌套
    */
}
```

#### 生成文档注释

文档注释内容可以被JDK带的工具javadoc解析，生成以网页文件体现该程序的说明

```shell
javadoc -d 生成网页文件的目标文件夹名 -标签 -标签 被解析的源代码文件
```

#### 文档注释标签

| 标签 | 含义 |
| ---- | ---- |
|      |      |
|      |      |
|      |      |

## 变量

变量 = 数据类型 + 数据大小

```java
public class BL {
	public static void main(String[] args) {
        int a,b=2;
        double c=3.0;
        float d=4.0;
        System.out.println("a b c d");
    }
}
```

### 数据类型

#### 分类

按照数据类型:

1. 基本数据类型
2. 引用数据类型

按照类中声明的位置:

1. 成员变量:

   按照是否使用static关键字

   1. 使用:静态变量, 类变量
   2. 不使用:非静态变量, 实例变量

2. 局部变量:方法内, 方法形参, 构造器内, 构造器形参, 代码块



| 基本数据类型 | 占用内存大小 |
| ------------ | ------------ |
| byte         | 1Byte        |
| short        | 2Byte        |
| int          | 4Byte        |
| long         | 8Byte        |
| float        | 4Byte        |
| double       | 8Byte        |
| char         | 2Byte        |
| boolean      | 1Byte        |

```mermaid
graph LR
Java数据类型 --> 基本数据类型
Java数据类型 --> 引用数据类型
基本数据类型 --> 数值型
基本数据类型 --> 字符型
基本数据类型 --> 布尔型
引用数据类型 --> 类Class
引用数据类型 --> 接口interface
引用数据类型 --> 数组
数值型 --> 整型:byte,short,int,long
数值型 --> 浮点型:float,double
```

1. Java的整型、浮点型都有固定的范围和字段长度，不受操作系统影响，具有可移植性。
2. 整型默认为int，声明long型常量需后加"l"或"L"，以保证在我们声明的数据大小超过int范围时自动转换为long型数据，然后再赋值给long型变量，数据不溢出。
3. 浮点型默认为double，声明float型常量需后加"f"或'F'
4. 浮点数 = 符号位 + 指数位 + 尾数位，尾数部分可能丢失造成精度损失（小数都是近似值）
5. 浮点数.125等价于0.125，512.0f，5.12e2等价于512.0，512E-2等价于5.12
6. float仅保留6位小数
7. 由于浮点数可能是近似值，所以在进行浮点数判断相等时，要两浮点数相减取绝对值，然后判断之差的绝对值是否在精度之内。
8. 有浮点数参与的运算，运算结果是近似于这个小数结果的数

#### 字符

```mermaid
graph LR
'a' --> 码值97 --> 二进制01100001 --> 存储
```

```java
public class Char {
	public static void main(String[] args) {
        //字符和码值对应关系遵循编码规则
		char c1 = 97;
        char c2 = 'a';
        System.out.println(c1);
		System.out.println((int)c2);  //强制转换
        
        //char运算
        System.out.println('a' + 10);  //107
        char c3 = 'b' + 1;
        System.out.println(c3);  //'c'
        
	}
}
```

| 字符编码表 | 大小                                            |
| ---------- | ----------------------------------------------- |
| ASCII      | 1Byte 可存储256个字符，有128个字符              |
| Unicode    | 统一使用2Byte存储字符 浪费空间                  |
| UTF-8      | 字母1字节，汉字3字节，可以使用1-6个字节表示字符 |
| GBK        | 可表示汉字，范围广，字母1字节，汉字2字节        |
| GB2312     | 可表示汉字，GB2312 < GBK                        |
| BIG5       | 繁体中文 台湾香港                               |

#### 布尔

```java
public class Bool {
    public static void main(String[] args) {
        boolean state = true;  //不能用0或1赋值表示真假
        if(state){
            System.out,println("True");
        }else{
            System.out.println("false");
        }
    }
}
```

### 数据类型的转换

#### 自动类型转换

Java程序在进行赋值或运算时，精度小的类型自动转换为精度大的类型。

```mermaid
graph LR
char --> int --> long --> float --> double
byte --> short --> int
```

1. 当多种类型数据混合运算时，自动将所有数据类型转为容量最大的类型，再进行计算。
2. 当我们把精度大的数据类型赋值给精度小的数据类型时，非法。反之，合法。
3. （byte、short）和char之间不会互相自动转换，但三者任意其一参与运算，就自动转换为int。

```java
public class var_change {
	public static void main(String[] args) {
   		int a = 'A';
		double b =80;
        System.out.println(a);  //65
        System.out.println(b);  //80.0
        
        double c = 1 + 2.3;  //合法
        float d = 1 +2.3;  //非法 右边是double无法降级赋值给float
    }
}
```

#### 强制类型转换

使用强制转换符`()`，将容量大的数据类型转换为容量小的数据类型。可能造成精度降低或溢出。

1. 强制转换符只对最近的一个数有效，多个需要使用小括号括起来
2. char类型可以被赋值为int常量，不能直接被赋值int变量需强制转换为char再赋值。

```java
public class var_change {
	public static void main(String[] args) {
   		double a = 1.9;
        int b = (int)a;  //1精度降低
        int c = 1000;
        byte d = (byte)c;  //溢出
        
        char ch1 = 97;
        int num1 = 97;
        char ch2 = (char)(num1 + 1);  //b
    }
}
```

#### String与Basic互转

```java
public class String_to_Basic {
	public static void main(String[] args) {
        //Basic_to_String
   		int n1 = 1111;
        double d1 = 11.11;
        boolean b1 = true;
        String str1 = n1 + "";
        String str2 = d1 + "";
        String str3 = b1 + "";
        System.out.println(str1 + " " + str2 + " " + str3);
        //String_to_Basic
        int n2 = Integer.parseInt("1919");
        double d2 = Double.parseDouble("19.19");
        boolean b2 = Boolean.parseBoolean("true");
        System.out.println(n2 + " " + d2 + " " + b2);
        //String_to_char 按下标取字符串的字符
        char ch1 = "123".charAt(1);  //'2'
        System.out.println(ch1);
    }
}
```

## 输出

```java
println();
```

#### 转义字符

| 转义字符 | 含义                 |
| -------- | -------------------- |
| \t       | 一个制表位，实现对齐 |
| \n       | 换行符               |
| \\\      | 一个\                |
| \\\\\\   | 两个\                |
| \\"      | 一个"                |
| \\'      | 一个'                |
| \\r      | 一个回车             |

```java
public class ChangeChar {
    public static void main(String[] args) {
    	System.out.println("Beijing\tTianjin\tShanghai");
        System.out.println("\\\t\"\t\'");
        System.out.println("中国首都\r北京");
        System.out.println("中国首都\r\n北京");
	}
}

java ChangeChar
Beijing Tianjin Shanghai
\       "       '
北京首都
中国首都
北京
```

#### 字符串相加

当加号左右两边都是数值型时，做加法运算。当有一方是字符串型，做拼接。

```java
System.out.println(11 + 89); //100
System.out.println("777" + "七七七");  //"777七七七"
System.out.println("zxb" + 20);  //"zxb20"
System.out.println('男' + '女');  //输出一个数，值为男与女的字符码之和 
```

## 输入

```java
//1.把java.util下的Scanner类导入
import java.util.Scanner;
public class Inputt {
	public static void main (String[] args) {
		//2.创建Scanner对象
		Scanner myScanner = new Scanner(System.in);
		//3.使用相关的方法接收用户的输入
		String name = myScanner.next();
		int age = myScanner.nextInt();
		double sal = myScanner.nextDouble();
		
		System.out.println(name + " " + age + " " + sal);
	}
}
```



## 运算符

运算符是一种特殊的符号，用以表示数据的运算、赋值和比较。

### 算数运算符

| 运算符 | 运算       | 备注                                                  |
| ------ | ---------- | ----------------------------------------------------- |
| +      | 正         |                                                       |
| -      | 负         |                                                       |
| +      | 加         |                                                       |
| -      | 减         |                                                       |
| *      | 乘         |                                                       |
| /      | 除         |                                                       |
| %      | 取模       | -10 % 3 = -1，10 % -3 = 1，a % b = a - (int)a / b * b |
| ++     | 自增       |                                                       |
| --     | 自减       |                                                       |
| +      | 字符串相加 |                                                       |

### 关系运算符

1. 关系运算符的结果都是Boolean型
2. 关系运算符组成的表达式叫关系表达式

| 运算符     | 运算               |                         |
| ---------- | ------------------ | ----------------------- |
| ==         |                    |                         |
| !=         |                    |                         |
| <          |                    |                         |
| >          |                    |                         |
| <=         |                    |                         |
| >=         |                    |                         |
| instanceof | 检查是否是类的对象 | "zxb" instanceof String |

### 逻辑运算符

用于连接多个关系表达式

1. a&b：逻辑与，两边同时为T即为T
2. a&&b：短路与，两边同时为T即为T
3. a|b：逻辑或，一个为T即为T
4. a||b：短路或，一个为T，即为T
5. !a：非，取反
6. a^b：，逻辑异或，两边不同即为T

#### &&与&区别

1. 短路与，如果第一个条件结果为F，则停止判断之后的条件表达式，结果直接为F
2. 逻辑与，所有条件表达式都要判断一遍
3. 开发常用短路与，效率高

#### ||与|区别

1. 短路或，如果第一个条件结果为T，则停止判断之后的条件表达式，结果直接为T
2. 逻辑或。所有表达式都要判断一遍
3. 开发常用短路或



| a    | b    | a&b  | a&&b | a\|b | a\|\|b | !a   | a^b  |
| ---- | ---- | ---- | ---- | ---- | ------ | ---- | ---- |
| T    | T    | T    | T    | T    | T      | F    | F    |
| T    | F    | F    | F    | T    | T      | F    | T    |
| F    | T    | F    | F    | T    | T      | T    | T    |
| F    | F    | F    | F    | F    | F      | T    | F    |

### 赋值运算符

1. 赋值运算符的右边可以是:变量、常量、表达式

2. 复合赋值运算符会进行强制类型转换

   ```java
   byte b = 2;
   b += 2;  //等价于b = (byte)(b+2);
   b++;  //b = (byte)(b+1);
   ```

| 运算符 |
| ------ |
| =      |
| +=     |
| -=     |
| *=     |
| \=     |
| %=     |

### 三元运算符

```
条件表达式?表达式1:表达式2
```

如果条件表达式为真，则结果返回表达式1，否则返回表达式2

```java
public class TernaryPoerator {
    public static void main(String[] args) {
        int a = 10, b = 99;
        int result = a < b ? a++ : b--;
        System.out.println("result = " + result);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        
        //  用一条三元运算符语句求三个数的最大值
        int n1, n2, n3;
        int max = (n1 > n2 ? n1 : n2) > n3 ? (n1 > n2 ? n1 : n2) : n3;
    }
}
```

### 运算符优先级

1. (),{}
2. 单目运算符
3. 算符运算符
4. 位移运算符
5. 比较运算符
6. 逻辑运算符
7. 三元运算符

| 优先级 | 运算符                                           | 结合性   |
| ------ | ------------------------------------------------ | -------- |
| 1      | ()、[]、{}                                       | 从左向右 |
| 2      | !、+、-、~、++、--                               | 从右向左 |
| 3      | *、/、%                                          | 从左向右 |
| 4      | +、-                                             | 从左向右 |
| 5      | <<、>>、>>>                                      | 从左向右 |
| 6      | <、<=、>、>=、instanceof                         | 从左向右 |
| 7      | ==、!=                                           | 从左向右 |
| 8      | &                                                | 从左向右 |
| 9      | ^                                                | 从左向右 |
| 10     | \|                                               | 从左向右 |
| 11     | &&                                               | 从左向右 |
| 12     | \|\|                                             | 从左向右 |
| 13     | ?:                                               | 从右向左 |
| 14     | =、+=、-=、*=、/=、&=、\|=、^=、~=、«=、»=、>>>= | 从右向左 |



## 进制

| 进制     | Java表示                        |
| -------- | ------------------------------- |
| 二进制   | 0b或0B开头                      |
| 十进制   | 0~9                             |
| 八进制   | 以0开头                         |
| 十六进制 | 以0x或0X开头，不区分A-F的大小写 |

#### 二进制转十进制

从$0$位（右边）开始，依次将每一位乘以$2^{位数}$ 的和。

```java

```



## 位运算

| 符号 | 作用                                         |
| ---- | -------------------------------------------- |
| <<   | 算数左移：符号位不变，抹除高位，低位补0      |
| >>   | 算数右移：低位抹掉，符号位不变，高位补符号值 |
| >>>  | 逻辑右移/无符号右移：低位溢出，高位补0       |
| ~    | 按位取反                                     |
| &    | 按位与                                       |
| \|   | 按位或                                       |
| ^    | 按位异或                                     |

### 原码反码补码

1. 二进制的最高位是符号位，最高位为0表示正数，1表示负数
2. 正数的三码一样
3. 负数的反码 = 符号位不变，剩余的取反
4. 负数的补码 = 反码 + 1
5. 0的反码、补码 = 0
6. Java中所有的数都是有符号的
7. 计算机运算时数据是以补码的方式运算的
8. 看运算结果要看原码

#### 补码转原码

1. 先利用 补码 - 1 得到反码
2. 反码再取反，得到原码



## 控制结构

### 顺序

程序从上到下逐行执行，中间没有任何判断和跳转。

### 分支

#### 单分支

```java
if(条件表达式) {
    执行代码块;
}
```

#### 双分支

```java
if(条件表达式) {
    执行代码块1;
}
else {
    执行代码块2;
}
```

#### 多分支

```java
if(条件表达式1) {
    执行代码块1;
}
else if(条件表达式2) {
    执行代码块2;
}
...
else {
    执行代码块n;
}
```

#### switch

```java
switch(条件表达式) {
    case 常量1:
        语句块1;
        break;
    case 常量2:
        语句块2;
        break;
        ···
    case 常量n:
        语句块n;
        break;
    default:
        default语句块;
        break;     
}
```

### 循环

#### for

```java
for(循环变量初始化;循环条件;循环变量迭代) {
    循环语句;
}
//增强for循环
for(声明循环变量 : 循环数组名) {
    循环语句;
}
```

1. 每次循环执行完循环语句之后才进行循环变量迭代
2. 循环语句只有一句时，可省略{}

#### while

```java
while(循环条件) {
    循环语句;
    循环变量迭代;
}
```

#### do while

```java
do {
    循环语句;
    循环变量迭代;
}while(循环条件)
```

至少能执行一次，先执行后判断。

### 跳转

#### break

跳出此循环

#### continue

结束本轮循环，执行下一轮循环

#### return

跳出方法



## 数组 

| 语句             | 作用                       |
| ---------------- | -------------------------- |
| 数组名.length    | 数组的长度，二维数组的行数 |
| 数组名[i].length | 二维数组的列数             |
|                  |                            |

### 一维数组

#### 初始化

```java
//动态初始化1
//声明加分配空间
数据类型[] 数组名 = new 数据类型[大小];

//动态初始化2
/*
先声明后分配空间
光声明不能分配内存空间
*/
数据类型[] 数组名;
数组名 = new 数据类型[大小];

//静态初始化
数据类型[] 数组名 = {数据};

```

#### 引用

```
数组名[下标/索引];
```

###  二维数组

二维数组实际上是有多个一维数组组成的，各个一维数组长度可以相同也可以不同。

#### 声明

```java
//动态初始化1
//声明加分配空间
数据类型[][] 数组名 = new 数据类型[行数][列数];

//动态初始化2
数据类型[][] 数组名;
数据类型 数组名[][];
数据类型[] 数组名[];
//静态初始化
数据类型[][] 数组名 = {{}, {}, {}};
```

####  内存结构

![image-20230131172144556](https://cdn.jsdelivr.net/gh/chousinbin/Image/202301311721656.png)

### 注意事项

1. 数组元素默认值为$0/NULL$
2. 数组属于引用类型，数组型数据是对象(object)

### 数组赋值机制

基本数据类型赋值，采用值传递，赋值的是数值，跟数据地址没关系。而数组在默认情况下是引用传递，赋值的是地址。

```java
int arr1[] = {1,2,3};
int arr2[] = arr1;

arr2[0] = 0;

for(int i = 0;i < 3;i ++)
	System.out.println(arr1[i]);
------
0
2
3
```

### 数组扩容

```java
import java.util.Scanner;
public class ArrayAdd {
	public static void main(String[] args) {
		/*
		数组扩容
		*/
		int[] arr = {1, 2, 3};
		
		int[] newarr = new int[arr.length + 1];
		for(int i = 0; i < arr.length; i ++)
			newarr[i] = arr[i];

		Scanner scanf = new Scanner(System.in);
		int res = scanf.nextInt();
		newarr[newarr.length - 1] = res;

		arr = newarr;
		
		for(int i = 0; i < arr.length; i ++)
			System.out.println(arr[i]);
	}
}
```



# 面向对象

## 类与对象

类是一个引用数据类型，对象是类中一个具体的实例。

从类到对象的说法有：创建一个对象、实例化一个对象、把类实例化...。

### 类的加载时机

1. 创建对象实例时
2. 创建子类对象实例时, 父类也会被加载, 而且父类优先加载
3. 使用类的静态成员时
4. 使用子类的静态成员时, 父类也会被加载, 而且父类优先加载

### 创建对象

```java
//直接创建
类名 对象名 = new 类名();
//先声明后创建
类名 对象名;  //声明是在内存的栈中给一个名字，没有分配
对象名 = new 类名();  //创建的过程就是在内存的堆中给对象分配一个地址
```

### 引用对象

```
对象名.成员变量;
```

### 对象创建流程

1. 先加载类信息（属性和方法信息，只会加载一次）
2. 在堆中分配对象空间, 得到对象地址
3. 成员变量进行默认初始化
4. 成员变量进行显示初始化，比如类代码中的`p.name = "Jing";`
5. 如果定义了构造方法, 成员变量根据构造方法赋值.
6. 把对象再堆中的地址返回给栈中的对象名

### 内存存在形式

![image-20230131201526665](https://cdn.jsdelivr.net/gh/chousinbin/Image/202301312015741.png)

![image-20230201133158259](https://cdn.jsdelivr.net/gh/chousinbin/Image/202302011331333.png)

![image-20230201140237179](https://cdn.jsdelivr.net/gh/chousinbin/Image/202302011402259.png)

### 样例代码

```java
public class object01 {
	public static void main (String[] args) {
		//1. new Peo(); 创建一个Peo类的对象
		//2. Peo cat1 = new Peo(); 把创建的对象赋给cat1
		Peo peo1 = new Peo();  //实例化一个Peo类的对象cat1
		
        peo1.name = "Jing";
		peo1.age = 18;
		peo1.weight = "55";

		System.out.println(peo1.name + " " + peo1.age + " " + peo1.weight);
        
        Peo peo2 = peo1;  //引用传递
        System.out.println("peo2.age=" + peo2.age);
	}
}

class Peo {
    //属性，成员变量，filed
	String name;
	int age;
	String weight;
    //构造方法
    
    //成员方法
}
```

### 匿名对象

```java
public class anonymousObject {
    public static void main(String[] args) {
        /*
         * new A08() 是匿名对象 匿名对象使用后自动释放
         * 匿名对象创建好后就可以调用其成员方法 .count1()
         */
        new A08().count1();  //10

        A08 a08 = new A08();
        a08.count2();  //9
        a08.count2();  //10
    }
}

class A08 {
    int count = 9;

    public void count1() {
        count = 10;
        System.out.println(count);
    }

    public void count2() {
        System.out.println(count++);
    }
}
```

## 成员变量

属性也叫成员变量、字段(field)。

属性不赋值的话有默认值，规则跟数组一样; 属性赋值的话, 必须且只能在声明的时候赋值, 不能先声明后赋值.

属性的定义类型为任意类型，包含基本类型和引用类型。

访问修饰符：public、protected、默认、private

```java
class 类名 {
	访问修饰符 属性类型 属性名;
	访问修饰符 属性类型 属性名 = 数据;
}
```

## 成员方法

与C/C++的函数概念类似，可以传参。方法不能嵌套定义！

### 定义

```java
访问修饰符 返回数据类型 方法名(参数列表) {
    语句;
    return 返回值;
}
```

#### 访问修饰符

控制方法的适用范围

#### 方法名

驼峰形式，能见名知义

#### 返回数据类型

任意类型。如果方法有返回数据类型，则方法末尾必须有`return 返回值;`。

#### 返回值

返回值类型必须和返回数据类型一致或兼容(int -> double)。

#### 形参列表

1. 一个方法即可以无参数也可以有多个参数，多个参数用逗号隔开。
2. 参数类型可以为任意类型，包含基本类型和引用类型
3. 调用带参数的方法时，一定对应着参数列表传入相同类型或兼容(数据类型由低向高兼容)类型的参数
4. 形式参数：方法定义时的参数；
5. 实际参数：方法调用时的参数。

### 优点

1. 提高代码的复用性
2. 可以将实现的细节封装起来，然后供其他用户调用

### 样例代码

```java
/*
创建对象调用方法,类似C++中的函数
但在Java中调用函数需先创建对象
*/
public class Method02 {
	public static void main(String[] args) {
		int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		Tools myTools = new Tools();
		
		myTools.bianli(arr);
	}
}

class Tools {

	public void bianli(int[][] ans) {
		for(int i = 0; i < ans.length; i++)
		{
			for(int j = 0; j<ans[i].length; j++)
				System.out.print(ans[i][j] + " ");
			System.out.println();
		}
	}
}
```



## 方法调用

### 调用机制

![image-20230201155636166](https://cdn.jsdelivr.net/gh/chousinbin/Image/202302011556274.png)

从方法返回数据之后，方法在栈中就被释放了。

### 调用流程

1. 当程序执行到方法时，就会开辟一个独立的栈空间
2. 当方法执行完毕，或者执行到return语句，就会返回
3. 返回到调用方法的地方
4. 返回后继续执行方法调用后面的代码
5. 当main方法执行完毕后，整个程序退出

### 样例代码

```java
import java.util.Scanner;

public class Method01 {
	public static void main (String[] args) {
		Person Jing = new Person();
		Jing.speak();  //调用方法
		
		Jing.cal01();
		
		Jing.cal02(99);
		
		int res03 = Jing.cal03(1, 100);
		System.out.println(res03);
	}
}

class Person {
	String name;
	int age;

	//声明方法
	public void speak() {
		System.out.println("我是好人");
	}

    public void cal01() {
        int res = 0;
        for(int i = 1; i <= 100; i++)
            res += i;
        System.out.println(res);
    }

    public void cal02(int n) {
    	int res = 0;
    	for(int i = 0; i <= n; i++)
    		res += i;
    	System.out.println(res);
    }

    public int cal03(int num1, int num2) {
    	int res = 0;
    	for(int i = num1; i <= num2; i++)
    		res += i;
    	return res;
    }
}
```

### 调用规则

在同一个类中调用方法直接调用即可，不需创建一个对象。

跨类中的方法调用,需要通过对象名调用。

跨类的方法能否成功调用和方法的访问修饰符有关。

```java
public class MethodDetail {
    public static void main (String[] args) {
        B ans = new B();
        ans.print2();
    }
}

class A {  //同类调用方法
    
    public void print(int n) {
        System.out.println("n=" + n);
    }
    public void sayOk() {
        print(10);
    }
}

class B {  //跨类调用方法
    public void print2() {
        A a = new A();
        a.print(20);
    }
}
```



## 传参机制

### 基本数据类型

传递的是值(值拷贝),形参的任何改变不影响实参.

### 引用类型

传递的是地址, 可以通过形参影响实参.

### 样例代码

```java
//基本数组和数组
public class MethodParameter01 {
    public static void main(String[] args) {
        //基本数据类型
        int a = 10;
        int b = 20;
        A myA = new A();
        myA.swap(a, b);
        System.out.println("after after sawp a=" + a +  "b=" + b);  //10 20
		
        //引用数据类型
        int[] arr2 = new int[2];
        arr2[0] = 1;
        arr2[1] = 2;

        A myb = new A();
        myb.swapArr(arr2);

        for(int i = 0; i < arr2.length; i++)
            System.out.print(arr2[i] + " ");  //2 1

    }
}

class A {
    public void swap(int a, int b) {  
        int temp;
        temp = a;
        a = b;
        b = temp;
        System.out.println("after swap a=" + a +"b=" + b);  //20 10
    }

    public void swapArr(int[] arr) {  
        int temp;
        temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;
        
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");  //2 1
        }
        System.out.println();
    }
}

```

```java
//对象传参机制
public class MethodParameter02 {
    public static void main(String[] args) {
        Person1 pp = new Person1();
        pp.age = 10;
        pp.name = "Jing";
        
        A1 mya = new A1();
        mya.test01(pp);
        System.out.println(pp.age);  //20
        mya.test02(pp);
        System.out.println(pp.age);  //20
    }
}

class Person1 {
    int age;
    String name;
}

class A1 {
    public void test01(Person1 p) {
        p.age = 20;
        /*
        对象是引用类型 实参受形参影响 
        因为两个方法里虽然对象名不同
        但是对象名都指向堆中同一个对象的地址
        */
        p = null;
        /*
        这里p只是在test01方法里的对象名 
        p指向了null 
        在main方法中的对象名指向的对象没变
        */
    }
    public void test02(Person1 p) {
        p = new Person1();
        p.age = 99;
        p.name = "Bin";
        /*
        这里p只是在test02方法里的对象名 
        p指向新的对象的地址
        那两句操作也是针对新对象的
        在main方法中的对象属性没变, 其中的对象名指向的地址也没变
        */
    }
}
```

## 方法递归

递归就是自己调用自己, 每次调用时传入不同的变量. 递归有利于编程者解决复杂问题.

### 内存结构

![image-20230207162823426](https://cdn.jsdelivr.net/gh/chousinbin/Image/202302071628517.png)

```java
public class Recursion01 {
    public static void main(String[] args) {
        Tools t1 = new Tools();

        int res = t1.factorial(5);
        System.out.println(res);
        
        int ans = t1.shulie(5);
        System.out.println(ans);
    }
    
}

class Tools {
    //递归阶乘
    public int factorial(int n) {
        if(n == 1) return 1;
        else return factorial(n - 1) * n;
    }
    //递归斐波那契数列
    public int shulie(int n) {
        if(n == 1 || n == 2) return 1;
        else return (shulie(n - 1) + shulie(n - 2));
    }
}
```

### 细节规则

1. 执行一个方法时, 就创建一个新的受保护的独立空间(栈空间)
2. 方法的局部变量时独立的, 不会相互影响
3. 如果方法使用的是引用类型的变量, 就会共享该引用类型的数据
4. 递归必须有结束条件, 否则死循环
5. 当一个方法执行完毕或遇到return,就会返回. 遵守谁调用谁就将结果返回给谁, 同时当方法执行完毕或者返回时,该方法也执行完毕.

## 方法重载

java允许同一个类中存在多个同名方法, 但要求**形参列表**不一致. 

### 细节规则

1. 方法名:必须相同
2. 参数列表:参数类型或参数个数,至少有一样不同, 参数名无要求
3. 返回类型:无要求

```java
public class Overload01 {
    public static void main(String[] args) {
        MyCalculator Calculator = new MyCalculator();
        
        System.out.println(Calculator.calculate(1, 2));
        System.out.println(Calculator.calculate(1, 2.5));
        System.out.println(Calculator.calculate(1.8, 2));
        System.out.println(Calculator.calculate(1, 2, 3));
    }
}

class MyCalculator {
    //两整数之和
    public int calculate(int n1, int n2) {
        return (n1 + n2);
    }
    //整数和浮点数之和
    public double calculate(int n1, double n2) {
        return (n1 + n2);
    }
    //浮点数和整数之和
    public double calculate(double n1, int n2) {
        return (n1 + n2);
    }
    //三整数之和
    public int calculate(int n1, int n2, int n3) {
        return (n1 + n2 + n3);
    }
}
```



## 可变参数

Java中允许将同一个类中多个**同名同功能**但**参数个数不同**的方法, 封装成一个方法. 

### 细节规则

1. 可变参数的实参可以为0~$n$个
2. 参编参数的实参可以为数组
3. 可变参数的本质是数组
4. 可变参数可以和普通参数一起放在形参列表, 但可变参数必须在最后
5. 一个形参列表最多只能有一个可变参数

### 语法

 ```java
public 返回参数类型 方法名(参数类型... 参数名) {
	
}
 ```

```java
public class VarParameter {
    public static void main(String[] args) {
        VP myVP = new VP();
        System.out.println(myVP.sum());
        System.out.println(myVP.sum(1, 2, 3,4));

        int[] arr1 = {4, 5, 6};
        System.out.println(myVP.sum(arr1));

        System.out.println(myVP.showScore("Sun", 90 , 80));
    }
}

class VP {
    /*
     * 返回可变参数之和
     */
    public int sum(int... n) {
        int res = 0;
        for(int i = 0; i < n.length; i++) {
            res += n[i];
        }
        return res;
    }
    /*
     * 返回学生姓名和任意门数总成绩的可变参数方法
     */
    public String showScore(String name, int... scores) {
        double res = 0;
        for(int i = 0; i < scores.length; i++) {
            res += scores[i];
        }
        return name + " " + res;
    }
    
}
```



## 作用域

全局变量:也就是属性, 作用域为整个类, 有默认值可以不赋值

局部变量:也就是方法中定义的变量, 作用域为整个方法, 无默认值必须赋值才能使用

```java
public class Scope {
    public static void main(String[] args) {
        S s1 = new S();
        s1.say();
    }
}

class S {
    String name = "Jing";  //全局变量:作用域为整个类S中
    public void say() {
        int score = 10;  //局部变量:作用域为整个方法say中
        String name = "Bin";
        System.out.println("sayName = " + name);
    }
}
```

### 命名细节

1. 成员变量与局部变量可以重名, 访问时遵循就近原则
2. 同一个方法里, 局部变量不能重名

### 作用范围

全局变量/属性:可以在本类中使用, 也可以通过对象调用的方式从其他类中使用

局部变量:只能在本类中对应的方法中使用

### 修饰符相关

全局变量/属性:可以加修饰符

局部变量:不可以加修饰符



## 构造方法

构造方法/构造器可以在创建对象的时候完成对新对象属性的初始化

### 细节规则

1. 构造器的修饰符可以默认
2. 构造器没有返回值
3. **方法名**与**类**名必须一致
4. 参数和成员方法规则一样
5. 创建对象的同时, 系统自动调用该类的构造方法
6. 构造器是完成对象的初始化, 不是创建对象
7. 构造方法可以重载, 利用不同的构造方法
8. 如果程序员没有定义构造器, 系统会自动给类生成一个默认无参构造器(默认构造器)
9. 一旦定义了自己的构造器, 默认的构造器失效, 就不能在使用无参构造器, 除非再显示定义一下

```java
public class constructor {
    /*
     * 要求
     * 利用构造方法
     * 实现
     * 创建人类对象的同时
     * 指定对象年龄和姓名
     */
    public static void main(String[] args) {
        Person p1 = new Person("Jing", 18);
        System.out.println(p1.name + " " + p1.age);

        Person p2 = new Person("Bin");
        System.out.println(p2.name + " " + p2.age);

        /*
         * 定义构造方法之后创建对象必须传参
         * 因为定义构造方法之后默认无参构造方法失效
         * 想要不传参就必须在类中显示声明默认无参构造方法
         */
        Person p3 = new Person(); 
        System.out.println(p3.name + " " + p3.age);
    }
}

class Person {
    //属性
    String name;
    int age;

    //构造方法1
    public Person(String pName, int pAge) {
        name = pName;
        age = pAge;
    }
    
    //构造方法2
    public Person(String pName) {
        name = pName;
    }

    //默认无参构造方法0
    Person(){}
}
```



## this

> 如果构造方法参数列表里面的参数名和对象的成员变量名相同, 会看起来美观方便. 但是根据作用域原则, 会导致成员变量无法被成功赋值. 关键字`this`能解决这个问题. 

Java虚拟机会为每个对象分配`this`, 用于代表当前对象, this关键字可以用来访问本类的属性(用于区分当前类的属性和局部变量)、方法、构造器.this不能在类定义的外部使用, 只能在类定义的方法中使用

### 访问成员方法

`this.方法名(参数列表);`

### 访问构造方法

`this(参数列表);`

只能在构造方法内使用, 并且必须是构造方法中的第一个语句, 一个构造方法里最多使用一次this访问构造方法

### 样例代码

```java
public class This {
    public static void main(String[] args) {
        People p1 = new People("Jing", 18);
        System.out.println(p1.name + " " + p1.age);

        People p2 = new People();
        System.out.println(p2.name + " " + p2.age);
    }
}

class People {
    String name;
    int age;

    public People() {
        this("THIS", 99);//只能在构造方法内使用
    }
    
    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

### 内存结构

![image-20230212135009596](https://cdn.jsdelivr.net/gh/chousinbin/Image/202302121350749.png)



## 包

### 包的作用

1. 区分相同名字的类

   ![image-20230218190727421](https://cdn.jsdelivr.net/gh/chousinbin/Image/202302181907481.png)

2. 当类很多时, 可以很好地管理类

3. 控制访问范围

在文档和JDK源码中都可以看到Java内置的类很多, 为了方便管理, 用包来分类区分管理. 

### 包的声明

#### 语法

```java
package 主包名.子包名;
```

#### 作用

package的作用是声明当前类所在的包, 需要放在类的最上面, 一个类中最多只有一句package

#### 结构

![image-20230218191132409](https://cdn.jsdelivr.net/gh/chousinbin/Image/202302181911454.png)

### 包的本质

创建不同的文件夹来保存类文件

### 包的命名

#### 命名规则

只能包含数字,字母,下划线,小圆点, 但不能用数字开头, 不能是关键字或保留字

#### 命名规范

小写字母加小圆点

`com.公司名.项目名.业务模块名`

### 常用的包

```java
java.lang.*  //基本包, 默认引用, 不需要再引用
java.util.*  //工具包, 工具类, 使用Scanner需引用此包
java.net.*   //网络开发
java.awt.*   //GUI
```

### 包的引入

#### 作用

引入包的主要目的是使用该包下的类,

#### 语法

```java
import 包;
import java.util.Scanner;  //仅仅引入Scanner类
import java.util.*;  //引入java.util包下的所有类
```

#### 注意

1. 实际开发中仅引入需要用到的类
2. import位置放在package的下面, 在类定义前面, 可以有多句且顺序无要求
3. 同名的类最多引入一次

### 样例代码

```java
package com.usr;  //包的声明

import com.bin.Person;  //类的引入

public class test {
    public static void main(String[] args) {
        //由于com.bin.Person类被引入 所以可以省略所在包前缀
        Person person1 = new Person();
        System.out.println(person1);

        //没被引入的类 使用时必须要有所在包前缀
        com.jing.Person person2 = new com.jing.Person();
        System.out.println(person2);
    }
}
```



## 访问修饰符

java提供四种访问控制修饰符号, 控制**类**,**方法**和**属性**(成员变量)的访问权限(范围)

| 访问级别 | 访问控制修饰符 | 本类 | 同包 | 子类 | 不同包子类 | 不同包 |
| -------- | -------------- | ---- | ---- | ---- | ---------- | ------ |
| 公开     | public         | √    | √    | √    | √          | √      |
| 受保护   | protected      | √    | √    | √    | √          | ✗      |
| 默认     | 无             | √    | √    | √    | ✗          | ✗      |
| 私有     | private        | √    | ✗    | ✗    | ✗          | ✗      |

#### 注意

能修饰类的只有默认和public



## 封装

封装就是把抽象出的数据[**属性**]和对数据的操作[**方法**]封装在一起, 数据被保护在内部, 程序的其他部分只有通过被**授权的操作[方法]**, 才能对数据进行操作.

### 封装好处

1. 隐藏实现细节
2. 可以对数据进行验证, 保证安全合理

### 封装步骤

1. 将属性私有化

2. 提供一个公共的set方法, 用于对属性判断并赋值

   ```java
   public void setXxx(参数列表) {
       //加入数据验证的业务逻辑
       属性 = 参数名;
   }
   ```

3. 提供一个公共的get方法, 用于获取属性的值

   ```java
   public XX getXxx() {
   	return xx;
   }
   ```

### 封装与构造方法结合

封装与构造方法相结合后, 本质是在构造方法里用封装的set方法代替this赋值, 保证可以对封装的属性进行数据验证, 多了一种设置/修改封装的私有属性的方式, 使得代码更加灵活.

### 样例代码

```java
package com.encapsulation;

/*
    不能随便查看人的年龄和工资等隐私
    并对设置的年龄进行合理的验证
    年龄合理就设置, 否则默认
    年龄在1~120
    name长度在2~6之间
*/
public class encapsulation {
    public static void main(String[] args) {
        Person p1 = new Person();

        //靠方法修改值
        p1.setAge(20);
        p1.setName("周新斌");
        p1.setSalary(2000);

        //靠方法查看值
        System.out.println(p1.getName());
        System.out.println(p1.getAge());
        System.out.println(p1.getSalary());
        
        //构造方法与set结合
        Person p2 = new Person("新斌", 0, 1000);
        System.out.println(p2.getName());
        System.out.println(p2.getAge());
        System.out.println(p2.getSalary());
    }
}

class Person {
    public String name;
    private int age;
    private double salary;

    
    public Person() {
    }

    public Person(String name, int age, double salary) {
        //this.name = name;
        //this.age = age;
        //this.salary = salary;
        //构造器与set相结合 可以利用set验证数据
        setName(name);
        setAge(age);
        setSalary(salary);
    }
    
    
    public void setName(String name) {
        if(name.length() >=2 && name.length() <=6) {
            this.name = name;
        } else {
            System.out.println("字符串长度需要在2~6");
            this.name = "null";
        }
    }
    
    public void setAge(int age) {
        if(age < 1 || age > 120) {
            System.out.println("年龄需要在1~120");
            this.age = 0;
        } else {
            this.age = age;
        }
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }

    
    public int getAge() {
        return age;
    }
    
    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}
```



## 继承

> 继承解决多个类的大部分属性和方法是相同导致代码复用的问题,

### 基本介绍

继承可以解决代码复用. 当多个类存在相同的属性和方法时, 可以从这些类中抽象出父类, 在父类中定义这些相同的属性和方法, 所有的子类不需要重新定义这些属性和方法, 只需要通过extends来声明继承父类即可.

![image-20230219183620534](https://cdn.jsdelivr.net/gh/chousinbin/Image/202302191836624.png)

上图中D类也可以是B类的子类

### 基本语法

```java
class 子类名 extends 父类名 {
	子类特有属性;
    子类特有方法;
}
```

1. 子类会自动拥有父类定义的属性和方法
2. 父类又叫超类,基类
3. 子类又叫派生类

### 继承好处

1. 提高代码的复用性
2. 提高代码的扩展性和维护性

### 细节特点

1. 子类继承了主类所有的属性和方法, 但是私有属性不能在子类中直接访问, 要通过公共的方法间接访问

2. 创建子类对象时, 必须先调用父类的构造器, 完成父类的初始化

3. 父类构造器的调用不限于直接父类, 将一直往上追溯到Object类(祖宗)

4. 子类最多只能继承一个父亲, 即java是**单继承机制**

   ![image-20230219215919170](https://cdn.jsdelivr.net/gh/chousinbin/Image/202302192159237.png)

   如何让A继承B和C ? 让B继承C, A继承B

5. 不能滥用继承, 子类和父类之间必须满足 is-a 的逻辑关系



### 继承本质

访问是从子类向上依次查找访问数据, 创建对象时是从祖宗类依次向下加载类信息.

#### 样例代码

```java
package com.Extends;

/**
 * 讲解继承的本质
 */
public class ExtendsTheory {
    public static void main(String[] args) {
        Son son = new Son();  //分析执行完这条语句的内存结构布局
        //根据查找关系返回数据
        System.out.println(son.name);  //大头儿子
        System.out.println(son.getAge());  //39
        System.out.println(son.hobby);  //旅游
    }
}
class GrandPa {
    String name = "大头爷爷";
    String hobby = "旅游";
    public int age = 66;
    //虽然这里个是公有的看似可以访问得到
    //但是子类Father中的age是私有的
    //访问到Father中的age查完权限发现无权限就停止了
    //所以不能访问的到Grandpa中的age
}
class Father extends GrandPa {
    String name = "大头爸爸";
    private int age = 39;


    public int getAge() {
        return age;
    }
}
class Son extends Father {
    String name = "大头儿子";
}
```

#### 内存结构

![image-20230220101217755](https://cdn.jsdelivr.net/gh/chousinbin/Image/202302201012833.png)

如果某一个属性是私有的, 那么在内存中也是存在的, 虽然主类访问不到, 但是可以在子类中创建公有方法, 通过继承间接访问

#### 查找关系

1. 先看子类有没有该属性
2. 如果子类有该属性并且能访问, 就返回信息
3. 如果子类有该属性并且不能访问, 就停止查找, 并且报错
4. 如果子类没有这个属性, 就看父类有无这个属性
5. 如果父类没有这个属性, 就按(3)的规则继续向上查找, 直到Object类
6. 如果都没有, 那么就会报错



## super

super用于父类的引用, 用于访问父类的属性, 方法, 构造器, 当本类调用super时会依次向父亲类查找成员, 如果查不到报错, 如果查到并且有权限就返回数值并停止查找 ,如果无权限那么报错, 并且不继续向上查找. 

#### 访问父类属性

```java
super.属性名;
```

#### 访问父类方法

```java
super.方法名(参数列表);
```

#### 访问父类构造器

```java
super(参数列表);
```

1. 当创建子类对象时, 不管使用子类的哪个构造器, 默认情况下总会去调用父类的无参构造器, 如果父类没有提供无参构造器, 则必须在子类的构造器中用super去指定父类中的构造器完成对父类的初始化, 否则编译报错.

2. 如果希望指定去调用父类的某个构造器, 则用super()显示的调用一下

3. super()必须放在构造器的第一行(为了先初始化父类), 只能在构造器中使用, 只能有一句

4. super()和this() 都只能放在构造器的第一行, 因此这两个方法不能同时存在于一个构造器中

#### 优点

1. 分工明确, 父类属性由父类初始化, 子类属性由子类初始化

   ```java
   class PC extends Computer {
       private String brand;
       public PC(){}
       /**
        *这里IDEA根据继承的规则, 自动把构造器的调用写好
        * 这里也体现继承设计的基本思想:父类的构造器完成父类属性初始化
        * 子类构造器完成子类属性的初始化
        */
       public PC(String CPU, String memory, String disk, String brand) {
           super(CPU, memory, disk);
           this.brand = brand;
       }
   
       public String getBrand() {
           return brand;
       }
   
       public void setBrand(String brand) {
           this.brand = brand;
       }
   
       public void printInfo() {
           System.out.println("PC信息");
           System.out.println(getDetails()+ " " + getBrand() + " ");
       }
   }
   ```

2. 当子类和父类中的属性或方法重名时, 为了访问父类的成员, 必须通过super. 如果没有重名使用super,this,直接访问的效果是一样的

3. super访问不限于直接父类, 如果爷爷类和本类中有同名的成员, 也可以使用super去访问爷爷类的成员; 如果多个父类中都有同名的成员, 使用super访问遵循就近原则, 同时遵循权限规则

#### 与this区别

| 区别点     | this                                                   | super                                  |
| ---------- | ------------------------------------------------------ | -------------------------------------- |
| 访问属性   | 访问本类中的属性, 如果本类没有, 则向从父类依次查找属性 | 直接从父类开始依次查找属性             |
| 访问方法   | 访问本类中的方法, 如果本类没有, 则向从父类依次查找方法 | 直接从父类开始依次查找方法             |
| 调用构造器 | 调用本类构造器, 必须放在构造器首行                     | 调用父类构造器, 必须放在子类构造器首行 |
| 特殊       | 表示当前对象                                           | 子类中访问父类对象                     |



## 方法重写

方法重写也叫方法覆盖(Override), 就是子类一个方法和父类一个方法的名称, 返回类型, 参数一样, 那么我们就说子类的方法覆盖了父类的方法.(子类父类是相对而言, 不一定是直接关系)

#### 条件

1. 子类方法的参数, 方法名称, 要和父类方法的参数, 方法名称完全一样
2. 子类方法的返回类型和父类方法返回类型一样, 或者是父类返回类型的子类
3. 子类方法不能小于父类方法的访问权限

#### 与重载区别

| 名称 | 发生范围 | 方法名   | 形参列表                   | 返回类型                                         | 修饰符                             |
| ---- | -------- | -------- | -------------------------- | ------------------------------------------------ | ---------------------------------- |
| 重载 | 本类     | 必须一样 | 类型,个数,顺序至少一个不同 | 无要求                                           | 无要求                             |
| 重写 | 父子类   | 必须一样 | 类型,个数,顺序必须完全相同 | 相同或者子类方法返回类型是父类方法返回类型的子类 | 子类方法不能缩小父类方法的访问范围 |



## 多态

### 优缺点

#### 优点

极大的减少了代码冗余, 不需要定义多个重载的方法, 利于在后期项目添加功能时不需要修改原有代码

#### 缺点

在多态的场景下, 我们创建了子类的对象, 也加载了子类特有的属性和方法. 但由于声明为父类的引用, 导致我们不能调用子类中特有的属性和方法

### 多态的前提

1. 存在类的继承关系
2. 存在方法重写

### 多态适用性

适用于方法, 不适用于属性. 属性没有重写之说, 属性的值要看编译类型

```java
public class Detail {
    public static void main(String[] args) {
        Base base = new Sub();  //向上转型
        System.out.println(base.count);  //10
        Sub sub = new Sub();
        System.out.println(sub.count);  //20
    }
}

class Base {
    int count = 10;
}

class Sub extends Base {
    int count = 20;
}
```

### 方法的多态

重载和重写体现多态

```java
package com.polymorphic.poly2;
/**
 * 方法的多态
 * 重写和重载
 */
public class PolyMethod {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        //方法重写体现多态
        a.say();
        b.say();
        //方法重载体现多态
        System.out.println(b.sum(1, 2));
        System.out.println(b.sum(1, 2, 3));
    }
}

class A {
    public void say() {
        System.out.println("A say()被调用");
    }
}

class B extends A {
    public int sum(int n1, int n2) {
        return n1 + n2;
    }
    public int sum(int n1, int n2, int n3) {
        return n1 + n2 + n3;
    }

    public void say() {
        System.out.println("B say()被调用");
    }
}
```

### 对象的多态

父类的引用指向子类的对象

1. 一个对象的编译类型和运行类型可以不一致
2. 编译类型在定义对象时就确定了, 不能改变
3. 运行类型是可以变化的
4. 编译类型看定义时=号的左边, 运行类型看=号的右边

```java
Animal animal = new Dog();  //animal编译类型是Animal, 运行类型Dog
animal = new Cat();  //animal运行类型变成了Cat, 编译类型吧依然是Animal
```



```java
package com.polymorphic.poly2;

public class PolyObject {
    public static void main(String[] args) {
        //对象animal
        //编译类型是Animal
        //运行类型是Dog
        Animal animal = new Dog();
        //执行要看运行类型
        //运行时, 执行到改行, animal的运行类型是Dog
        //所以结果是Dog cry()
        animal.cry();  //"Dog cry()"

        //animal这个类对象名此时
        //指向堆中的猫对象
        //运行的时候就看Cat对象
        animal = new Cat();
        animal.cry();  //"Cat cry()"
    }
}

class Animal {
    public void cry() {
        System.out.println("Animal cry()");
    }
}
class Cat extends Animal {
    public void cry() {
        System.out.println("Cat cry()");
    }
}
class Dog extends Animal {
    public void cry() {
        System.out.println("Dog cry()");
    }
}
```

### 向上转型

#### 本质

向上转型就是多态, 父类的引用指向了子类的对象

#### 语法

```java
父类类型 引用名 = new 子类类型();
```

#### 调用规则

1. 编译类型看左边, 运行类型看右边, 
2. 可以调用父类中的所有成员方法(在访问权限允许情况下)
3. 不能调用子类中特有成员方法, 因为在编译阶段, 能调用哪些成员方法是由编译类型决定的
4. 最终的运行效果要看子类的具体实现, 即调用方法是按照从子类(运行类型)开始查找成员调用

### 向下转型

强转的是父类的引用, 不是父类的对象

#### 语法

```java
子类类型 引用名 = (子类类型) 父类引用;
```

#### 要求

父类的引用必须指向的是当前目标类型的对象

#### 作用

向下转型后可以调用子类对象中所有的成员

```java
public class test {
    public static void main(String[] args) {
        //多态的向上转型
        Animal animal = new Cat();
        animal.eat();
        animal.run();
        animal.show();
        animal.sleep();

        //多态的向下转型
        //cat的编译类型Cat, 运行类型Cat
        Cat cat = (Cat) animal;
        cat.catchMouse();  //能访问特有成员了
        cat.eat();
        cat.run();
        cat.show();
        cat.sleep();
    }
}
```

### instanceof

判断一个对象的运行类型是否属于**某类**或者**某类的子类**, 返回布尔类型; 

可以在类向下转型之前用instanceof进行判断

```java
public class Detail02 {
    public static void main(String[] args) {
        B b = new B();
        System.out.println(b instanceof B);  //true
        System.out.println(b instanceof A);  //true

        A a = new B();
        System.out.println(a instanceof B);  //true
        System.out.println(a instanceof A);  //true

        Object obj = new Object();
        System.out.println(obj instanceof A);  //false
        System.out.println(obj instanceof B);  //false
    }
}
class A {}
class B extends A{}
```



### 动态绑定机制

1. 当调用对象方法时, 该方法会和该对象的内存地址/运行类型绑定
2. 当调用对象属性时, 没有动态绑定机制, 哪里声明, 就哪里使用



### 应用1多态数组

#### 定义

数组的定义类型为父类类型, 数组里面保存的元素是父类类型或子类类型的对象; 

#### 样例代码

```java
/**
 * @ClassName: PolyArr
 * @Description: 创建一个P对象两个S对象两个T对象, 统一放在数组中, 并调用每个say方法
 * @date: 2023-02-23 11:26
 */
public class PolyArr {
    public static void main(String[] args) {
        Person[] persons = new Person[5];
        persons[0] = new Person("a1", 11);
        persons[1] = new Student("a2", 22, 100);
        persons[2] = new Student("a3" , 23, 200);
        persons[3] = new Teacher("a4", 30, 3000);
        persons[4] = new Teacher("a5", 34, 4000);

        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i].say());
            //persons[1].study();
            //persons[3].teach();
            //这里无法访问到子类的特有属性
            //我们采用instanceof类型判断+向下转型
            if(persons[i] instanceof Student) {
                ((Student) persons[i]).study();
            } else if(persons[i] instanceof Teacher) {
                ((Teacher)persons[i]).teach();
            } else if(persons[i] instanceof Person) {
                //不做处理
            } else {
                System.out.println("对象类型有误 无法能调用独有方法");
            }
        }
        
    }
}
```



### 应用2多态参数

#### 定义

方法定义的参数类型为父类类型, 实参类型允许为子类类型; 

#### 好处

能减少方法的冗余, 实现一个方法多用; 

#### 样例代码

```java
package com.polymorphic.polyparameter;

/**
 * @ClassName: PolyParameter
 * @Description:
 * @date: 2023-02-24 17:01
 */
public class PolyParameter {
    public static void main(String[] args) {
        Test test = new Test();
        Employee employee = new Employee("null", 0);
        Handle handle = new Handle("经理李", 10000, 1000);
        Staff staff = new Staff("小工晓", 4000);

        test.showEmpAnnual(employee);
        test.showEmpAnnual(handle);
        test.showEmpAnnual(staff);

        test.testWork(employee);
        test.testWork(handle);
        test.testWork(staff);


    }
}

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getAnnual() {
        return salary;
    }
}

class Handle extends Employee{
    private double bonus;

    public Handle(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void manage() {
        System.out.println("经理" + getName() + "正在喝茶");
    }

    public double getAnnual() {
        return super.getAnnual() + bonus;
    }
}

class Staff extends Employee {
    public Staff(String name, double salary) {
        super(name, salary);
    }

    public void work() {
        System.out.println("员工" + getName() + "正在工作");
    }

    public double getAnnual() {
        return super.getAnnual();
    }
}

class Test {
    public void showEmpAnnual(Employee e) {
        //动态绑定机制a.getAnnual()
        System.out.println(e.getName() + "月总薪资:" + e.getAnnual());
    }

    public void testWork(Employee e) {
        if(e instanceof Staff) {
            ((Staff) e).work();
        } else if (e instanceof Handle) {
            ((Handle) e).manage();
        }
    }
}
```



## Object类

任何一个类(除Object)都直接或间接的继承与Object类

类`java.lang.Object`是类层次结构的根类, 每个类都使用 Object 作为超类, 所有对象(包括数组)都实现这个类的方法;

Object类中声明的结构(属性,方法)就具有通用性,

Object类中没有声明属性, 提供了一个空参的构造器

![image-20230219213901435](https://cdn.jsdelivr.net/gh/chousinbin/Image/202302192139501.png)



### ==

==既可以判断基本类型(判断的是**值**是否相等), 又可以判断引用类型(判断的是**地址**是否相等)

### equals()

equals()是Object类中的方法, 只能判断**引用类型**数据; 默认判断地址是否相等, 子类往往重写该方法, 用于判断内容是否相等.

```java
public boolean equals(Object obj) {
        return (this == obj);
    }
```

```java
package com.object_;

/**
 * @ClassName: EqualTest
 * @Description:
 * @date: 2023-03-06 16:40
 */
public class EqualTest {
    public static void main(String[] args) {
        Person p1 = new Person("bin", 20, 'a');
        Person p2 = new Person("jin", 18, 'a');
        Person p3 = new Person("bin", 20, 'a');

        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p3));
    }
}

class Person {
    private String name;
    private int age;
    private char gender;

    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public boolean equals(Object obj) {
        //同一个对象成员属性肯定相等
        if(obj == this) {
            return true;
        }
        if(obj instanceof Person) {
            Person p = (Person)obj;
            return this.name.equals(p.name) && this.age == p.age && this.gender == p.gender;
        }
        return false;
    }
}

```

### hashcode()

返回该对象的哈希码值(整数), 此方法是为了提高哈希表的性能; 哈希值主要是根据地址来的, 但**哈希值不是地址**;



### toString()

返回该对象的字符串表示; 默认返回:`全类名`@`哈希值的十六进制`; 程序员可以自己重写自定义此方法

```java
public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
```

如果输出对象名, 会默认调用toString()方法

### finalize()

当对象不再被引用, JVM会认为这是一个垃圾对象, 根据垃圾回收机制来进行销毁对象; 

垃圾回收机制的调用由JVM决定(拥有自己的GC算法), 也可以通过System.gc()主动触发垃圾回收机制; 

在系统销毁对象之前, 系统自动调用finalize()方法, 子类可以重写该方法, 写一些其他的操作;



## static

静态的, 用static修饰的成员变量和成员方法



### 类变量

类变量(静态变量)顾名思义, 一个类中所以对象公有的成员变量, 只占用一份内存空间;

#### 调用方式

1. 类.类变量
2. 对象.类变量 

#### 与实例变量区别

|          | 静态变量                                                     | 实例变量                         |
| -------- | ------------------------------------------------------------ | -------------------------------- |
| 个数     | 在内存中只有一份                                             | 每个对象都占有独立内存空间的一个 |
| 存放位置 | JDK6及之前在方法区, JDK7开始在堆                             | 堆空间对象实体中                 |
| 加载时机 | 随着类的加载而加载, 由于类只会加载一次, 类变量也只占有一份内存 | 随着对象的创建而加载             |
| 调用者   | 可以被类直接调用, 也可以使用对象调用                         | 只能使用对象调用                 |
| 消亡时机 | 随着类的卸载而消亡                                           | 随着对象的消亡而消亡             |

#### 内存结构

<img src="https://cdn.jsdelivr.net/gh/chousinbin/Image/202303062106497.png" alt="image-20230306210648275" style="zoom:50%;" />

#### 用处

1. 用于一个类中多个对象共享此成员变量, 且此成员变量的值是相同的
2. 开发中, 常将常量声明为静态的



### 类方法

#### 调用方式

1. 类.类方法
2. 对象.类方法

#### 调用范围

类的静态方法内:可以调用静态变量或静态方法, 不可以调用非静态的成员

类的非静态方法内:可以调用静态变量或静态方法

#### 注意

因为static修饰的静态方法是随着类的加载而加载的, 而super和this操作基于对象, 所以在静态方法内不能使用super或this

#### 用处

1. 方法内操作的变量如果都是静态变量, 通常将此方法声明为静态方法
2. 工具类中的方法通常为静态方法



## main()

#### 详解main()

```java
public static void main(String[] args)
```

1. main()方法由JVM调用

2. JVM调用main(), 所以main()访问修饰符必须为public

3. JVM执行调用main()不必创建对象, 所以要为static方法

4. main()方法接收String类型的数组参数, 其中保存**执行Java命令时传递给所运行的类**的参数

   <img src="https://cdn.jsdelivr.net/gh/chousinbin/Image/202303071949201.png" alt="image-20230307194914055" style="zoom: 33%;" />

#### main()动态传值

> 上面讲到用命令行动态给main()传值, 接下来介绍IDEA用给main()动态传值

<img src="https://cdn.jsdelivr.net/gh/chousinbin/Image/202303072014996.png" alt="image-20230307201454887" style="zoom:50%;" />

#### 调用

1. 在main()方法内, 可以直接调用, main()所在类中的静态方法或静态属性
2. 不能直接访问该类中的非静态成员, 必须创建类的对象后, 才能通过对象去访问非静态成员

#### 代码

```java
package com.main_;

/**
 * @ClassName: MainTest
 * @Description:
 * @date: 2023-03-07 19:59
 */
public class MainTest {
    String name;
    static String nation = "CN";

    static void f1() {
        System.out.println("f1");
    }

    public static void main(String[] args) {
        /**
         * main()内可以直接访问所在类的静态属性
         */
        System.out.println(nation);
        f1();
        /**
         * main()方法内要访问非静态属性, 要先创建对象, 在通过对象引用
         */
        //System.out.println(name);
        MainTest mainTest = new MainTest();
        System.out.println(mainTest.name);
    }
}
```



## 代码块

代码块又称初始化块, 属于类中的成员(类的一部分),相当于另一种形式的构造器(构造器的补充机制), 可以做初始化操作

### 语法

```java
[修饰符] {
	逻辑语句...;
};
```

1. 修饰符:static或无
2. 逻辑语句:可以为任意语句
3. 末尾的分号;可以不写

### 调用

不通过对象或类的显式调用, 而是随着加载类或创建对象时隐式调用

### 好处

如果多个构造器有重复内容, 即可把重复内容提取到初始化块中, 提高代码的重用性

### 分类

使用static修饰的为静态代码块, 反之叫普通代码块

#### 静态代码块

随着[类的加载](##类的加载时机)而执行, 并**只会执行一次**,

静态代码块内只能调用静态成员

如果只使用类的静态成员时, 只会执行静态代码块, 不执行普通代码块

#### 普通代码块

**每创建一个对象就执行一次**

普通代码块内可以调用任意成员





### 创建一个对象时在一个类中成员调用顺序

1. 调用静态代码块和静态属性初始化, 上述两者优先级一样, 如有多个则按照代码编写顺序

   (因为静态的代码块和静态属性的初始化在类加载时被调用, 所以比普通代码块和普通属性初始化优先级高)

2. 调用普通代码块和普通属性初始化, 上述两者优先级一样, 如有多个则按照代码编写顺序
   (因为构造方法开头里隐藏了调用普通代码块和普通属性初始化, 所以比调用构造方法内容优先级别高)

3. 调用构造方法里的显式代码.

```java
package com.codeblock_;

/**
 * @ClassName: Block1
 * @Description:演示创建一个对象时,类成员的调用顺序
 * @date: 2023-03-07 20:34
 */
public class Block1 {
    public static void main(String[] args) {
        A a = new A("a");
        System.out.println(a.name);
        /**
         * out:
         * 静态代码块被调用
         * 静态方法被调用
         * 普通代码块被调用
         * 普通方法被调用
         * 构造方法被调用
         * a
         */
        //上面输出a.name为a也证明了普通方法优先于构造器调用
    }
}

class A {
    static {
        System.out.println("静态代码块被调用");
    }

    private static int age = getAge();

    public static int getAge() {
        System.out.println("静态方法被调用");
        return 100;
    }

    {
        System.out.println("普通代码块被调用");
    }

    String name = getName();

    public String getName() {
        System.out.println("普通方法被调用");
        return "bin";
    }

    public A(String name) {
        this.name = name;
        System.out.println("构造方法被调用");
    }
}
```

### 创建一个子类对象其成员调用顺序

1. 父类的静态代码块和静态属性初始化(优先级一样, 按定义顺序执行)
2. 子类的静态代码块和静态属性初始化(优先级一样, 按定义顺序执行)
3. 父类的普通代码块和普通属性初始化(优先级一样, 按定义顺序执行)
4. 父类的构造方法
5. 子类的普通代码块和普通属性初始化(优先级一样, 按定义顺序执行)
6. 子类的构造方法

#### 为什么父类比子类优先?

因为构造方法第一行隐藏了super(), 所以父类要比子类优先加载完成初始化

#### 为什么静态比普通优先?

因为静态初始化随着类的加载而完成初始化, 普通的代码块和属性随着对象的创建而完成初始化. 并且类只加载一次, 静态代码块和成员属性也只会初始化一次;

#### 为什么同一类的普通代码块和成员属性比构造方法内的显式代码优先?

因为构造方法第二行隐藏了`调用此类普通代码块和成员属性初始化`代码;

#### 样例代码

```java
package com.codeblock_;

/**
 * @ClassName: Block2
 * @Description:
 * 演示构造器中隐藏的super和调用普通代码块
 * 演示创建子类对象时类成员调用顺序
 * @date: 2023-03-08 10:48
 */
public class Block2 {
    public static void main(String[] args) {
        new BB();//创建含有继承关系的子类对象
        new BB();
    }
}

class AA {
    private static int val = getVal();

    public static int getVal() {
        System.out.println("父类的静态变量初始化被调用");//(1)
        return 1;
    }

    static {
        System.out.println("父类的静态代码块被调用");//(2)
    }

    private int val2 = getVal2();

    public int getVal2() {
        System.out.println("父类的普通变量初始化被调用");//(5)
        return 2;
    }

    {
        System.out.println("父类的普通代码块被调用");//(6)
    }

    public AA() {
        //隐藏super()(5)
        //隐藏了调用此类普通代码块和普通属性初始化(5和6)
        System.out.println("父类构造器内容被调用");//(7)
    }
}

class BB extends AA{
    static {
        System.out.println("子类的静态代码块被调用");//(3)
    }

    private static int val3 = getVal3();

    public static int getVal3() {
        System.out.println("子类的静态变量初始化被调用");//(4)
        return 3;
    }

    private int val4 = getVal4();

    {
        System.out.println("子类的普通代码块被调用");//(8)
    }

    public int getVal4() {
        System.out.println("子类的普通变量初始化被调用");//(9)
        return 4;
    }

    public BB() {
        //隐藏super() (5)
        //隐藏了调用此类普通代码块和普通属性初始化(8和9)
        System.out.println("子类构造器内容被调用");//(10)
    }
}
```



## 单例设计模式

单例设计, 就是采取一定的方法使一个类最多只能存在一个对象实例, 并该类提供一个取得其对象的方法

### 饿汉式

#### 步骤

1. 构造器私有化
2. 类的内部创建对象
3. 向外暴露一个静态的公共方法, 返回对象

#### 样例代码

```java
package com.singledesign;

/**
 * @ClassName: Single
 * @Description:
 * @date: 2023-03-08 21:16
 */
public class Single {
    public static void main(String[] args) {
        GirlFriend myGirlFriend = GirlFriend.getGirlFriend();
        System.out.println(myGirlFriend);
    }
}

class GirlFriend {
    private String name;

    private GirlFriend(String name) {
        this.name = name;
    }

    private static GirlFriend gf = new GirlFriend("yuanJin");

    public static GirlFriend getGirlFriend() {
        return gf;
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                '}';
    }
}
```

由于类内对象的声明和创建都是静态的, 所以可能在没有用到创建对象时, 就随着加载类而完成了对象的初始化;

### 懒汉式

#### 步骤

1. 构造器私有化
2. 定义一个静态属性对象
3. 提供一个public的static方法, 可以返回一个对象

#### 代码

```java
package com.singledesign;

/**
 * @ClassName: Single2
 * @Description:
 * @date: 2023-03-08 21:42
 */
public class Single2 {
    public static void main(String[] args) {
        GirlFriend2 myGf = GirlFriend2.getGirlFriend();
        System.out.println(myGf);
    }
}

class GirlFriend2 {
    private String name;

    private GirlFriend2(String name) {
        this.name = name;
    }

    private static GirlFriend2 gf;

    public static GirlFriend2 getGirlFriend() {
        if(gf == null)
            gf = new GirlFriend2("yuanJin");
        return gf;
    }

    @Override
    public String toString() {
        return "GirlFriend2{" +
                "name='" + name + '\'' +
                '}';
    }
}
```

### 区别

| 区别         | 饿汉式                                               | 懒汉式                         |
| ------------ | ---------------------------------------------------- | ------------------------------ |
| 创建对象时机 | 在类加载就创建对象实例                               | 在使用对象时才创建对象实例     |
| 线程安全问题 | 不存在                                               | 存在线程安全问题               |
| 资源浪费     | 类对象没有使用, 但创建了对象, 占用内存空间, 浪费对象 | 需要使用对象时时才创建, 不浪费 |



## final

final关键词, 可以修饰:类, 属性, 方法和局部变量, 不能修饰构造方法;

### 常见final类

1. 包装类(Integer, Double, Float, Boolean)
2. String类

### 修饰类

final类不能被继承, 但可以有实例化对象

```java
[final] class 类名 {}
```

### 修饰方法

父类的final方法可以不被子类方法覆盖/重写

如果不是final父类, 但其中有final方法, 则该方法不能重写, 但可以被继承

```java
[访问修饰符] [final] 返回数据类型 方法名() {}
```

一般来说, final父类的方法不需再用final修饰了, 因为整个类都无法被继承了, 所以此类的方法也就不存在被重写的问题了

### 修饰属性

final修饰的属性叫常量,  一般以XX_XX格式命名, 可以使类的某个属性的值不被修改

```java
[访问修饰符] [final] 数据类型 属性名;
```

#### 赋值时机

1. 定义时
2. 在构造器中
3. 在代码块中

如果final修饰的属性是静态的, 那么只能在定义时或静态代码块中赋值

### 修饰局部变量

可以使某个局部变量不被修改

```java
[访问修饰符] [final] 数据类型 变量名;
```

### final与static搭配

final往往与static搭配使用, 效率更高, 底层编译器做了优化, 不会导致类加载



## abstract

abstract只能修饰类或方法

### 抽象类

用abstract修饰的类, 叫抽象类;

```java
[访问修饰符] [abstract] 类名 {}
```

1. 抽象类不能被实例化
2. 抽象类内不一定要有抽象方法
3. 抽象类也是类, 抽象类内可以有任意成员
4. 如果普通类继承了抽象类, 则普通类内必须实现抽象类的所有抽象方法

### 抽象方法

当父类方法不能确定时, 可以用abstract关键字来修饰此方法, 并且没有方法体, 这个方法就叫抽象方法; 

```java
[访问修饰符] [abstract] 返回数据类型 方法名();
```

1. 抽象方法必须在抽象类内
2. 抽象方法不能有方法体
3. 抽象方法不能使用private, static, final来修饰, 因为这些关键词与方法重写有矛盾

### 模板设计模式

#### 基本介绍

抽象类体现的是一种模板模式的设计, 抽象类作为多个子类的通用模板, 子类在抽象类的基础上进行扩展, 改造, 但子类总体上会保留抽象类的行为方式

#### 用处

1. 当功能内部一部分实现是确定的, 另一部分的实现是不确定的; 这时可以把不确定的部分暴露出去, 让子类去实现
2. 编写一个抽象父类, 父类提供了多个子类的通用方法, 并把一个或多个方法留给子类去实现, 就是一种模板设计模式

#### 样例代码

```java
public class TemplateTest {
    public static void main(String[] args) {
        new Sub1().calculateTime();
        new Sub2().calculateTime();
    }
}

abstract class Template {
    public abstract void job();

    public void calculateTime() {
        long startTime = System.currentTimeMillis();
        job();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时" + (endTime - startTime));
    }
}

class Sub1 extends Template{
    public void job() {
        for (int i = 0; i < 800000; i++) {
            int sum = 0;
            sum++;
        }
        System.out.print("类Sub1.job()");
    }
}

class Sub2 extends Template{
    public void job() {
        long sum = 0;
        for (int i = 1; i < 100000; i++) {
            sum *= i;
        }
        System.out.print("Sub2.job()");
    }
}
```



## 接口

借口就是把没有实现的方法, 封装到一起, 到某个类要使用的时候, 再根据具体情况把这些方法写出来;

### 语法

#### 创建接口语法

```java
[public/默认] interface 接口名 {
	属性;  //接口的属性实际是 public static final 修饰的, 比如 int a = 1; 实际是 public static final int a = 1
    抽象方法;  //可以不需要abstract修饰
    默认方法;  //开头要用default修饰
    静态方法;  
}
```

在JDK7.0之前, 接口里的所有方法都没有方法体; JDK8.0后接口类可以有静态方法, 默认方法, 也就是说接口中可以有具体的实现

1. 接口的属性实际是 public static final 修饰的, 通过`接口名.属性名`访问

2. 接口不能被实例化

3. 接口中所有方法均为public方法, 接口中的抽象方法可以不用abstract修饰

4. 接口不能继承其他的类, 但是可以继承多个其他的接口

   ```java
   interface A extends B, C {}
   ```

5. 接口的修饰符只能是public或默认

6. 接口的属性可以直接通过接口名访问, 也可以通过实现该接口的类的实例化对象访问, 还可以通过实现该接口的类名直接访问

   ```java
   public class InterfaceExercise1 {
       public static void main(String[] args) {
           B b = new B();
           System.out.println(A.a);  //23
           System.out.println(b.a);  //23
           System.out.println(B.a);  //23
       }
   }
   
   interface A {
       int a = 23;
   }
   
   class B implements A {}
   ```

   

#### 类实现接口语法

```java
class 类名 implements 接口 {
	自己属性;
    自己方法;
    必须实现的接口的方法;
}
```

1. 普通类实现接口, 就要把接口中的抽象方法全部实现

2. 抽象类实现接口, 可以不用实现接口找那个的抽象方法

3. 一个类可以同时实现多个接口

   ```java
   class A implements B, C {}
   ```

   

### 用处

1. 在实际开发中, 往往项目经理根据项目需求写出接口规范出方法名, 然后小组内的各个开发人员严格按照接口规范实现自己的业务逻辑代码
1. 接口在一定程度上实现代码解耦(接口的规范性+动态绑定机制)



### 继承vs实现接口

当子类继承了父类, 就自动仅仅拥有了父类的功能;
如果子类需要扩张功能, 可以通过实现接口的方式扩展功能; 实现接口是对Java单继承机制的补充;

|      | 继承                           | 接口                                                       |
| ---- | ------------------------------ | ---------------------------------------------------------- |
| 价值 | 提高代码的复用性和可维护性     | 设计好各种规范(方法), 让其他类去实现这些规范, 接口更加灵活 |
| 灵活 | 继承前提是两个类属性是一种东西 | 接口不拘泥于两个类是否是一种东西, 只要特征相似就OK         |



### 接口多态性

#### 多态参数

1. 接口类型的形参可以接收实现了该接口的类的对象实例
2. 接口类型的变量可以指向实现了该接口的类的对象实例

```java
public void 方法名(接口名 形参名) {}

接口名 引用名 = new 实现该接口的类名();
```

```java
public class poly {
    public static void main(String[] args) {
        //接口类型的变量可以指向实现了该接口的类的对象实例
        Usb myUsb = new Phone();
        myUsb = new Camera();
    }
}

interface Usb {
    void connect();
    void stop();
}

class Computer {
    //接口类型的形参可以接收实现了该接口的类的对象实例
    public void work(Usb myUsb) {
        myUsb.connect();
        myUsb.stop();
    }
}

class Phone implements Usb {
    public void connect() {

    }
    public void stop() {

    }
}

class Camera implements Usb {
    public void connect() {

    }
    public void stop() {

    }
}
```

#### 多态数组

多态数组即数组类型为一个接口, 数组元素可以为任意实现该接口的对象实例

```java
public class InterfacePolyArray {
    public static void main(String[] args) {
        UsbInterface[] myUsbDevice = new UsbInterface[2];

        myUsbDevice[0] = new Phone_();
        myUsbDevice[1] = new Camera_();

        for (int i = 0; i < myUsbDevice.length; i++) {
            myUsbDevice[i].work();
            if(myUsbDevice[i] instanceof Phone_) {  //如果接口数组的元素的运行类型是手机
                ((Phone_)myUsbDevice[i]).call();  //向下转型为手机类型 并调用该类的特有打电话方法
            }
        }
    }
}

interface UsbInterface {
    void work();
}
class Phone_ implements UsbInterface {
    public void work() {
        System.out.println("手机插入USB接口");
    }

    public void call() {
        System.out.println("手机拨打电话");
    }
}
class Camera_ implements UsbInterface {
    public void work() {
        System.out.println("相机插入USB接口");
    }
}
```

#### 多态传递

如果一个类实现的接口继承了另一个接口, 那么这个类也同时实现了本身实现的接口的父接口

```java
public class InterfacePolyPass {
    public static void main(String[] args) {
        I1 i1 = new C1();
        //如果类C1实现了接口I2
        //并且接口I2继承了接口I1
        //那么相当于类C1也实现了接口I1
    }
}

interface I1 {}
interface I2 extends I1 {}
class C1 implements I2 {}
```

### 练习

```java
public class Exercise {
    public static void main(String[] args) {
        C.use();
    }
}

interface A {
    int x = 0;
}

class B {
    int x = 1;
}

class C extends B implements A {
    int x = 2;
    public void pX() {
        //System.out.println(x); x使用错误, x不明确
        //用super.x使用B类的x
        //用A.x使用A类的x
        //用C类的使用x

        System.out.println(x + " " + super.x + " " + A.x);
    }
    public static void use() {
        new C().pX();
    }
}
```



## 内部类

### 概括

#### 定义

类的内部嵌套的类叫做内部类(Inner Class), 拥有内部类的类叫做外部类(Outer Class), 没有内部类的类叫做外部其他类;
内部类是我们类的五大成员[属性、方法、构造器、代码块、**内部类**]

#### 语法

```java
class Outer {
    class Inner {
        
    }
}

class Other {
    
}
```

#### 特点

内部类的最大特点是可以直接访问私有属性， 并且可以体现类与类之间的包含关系；

#### 分类

```mermaid
graph LR

内部类分类 --> 定义在外部类的局部位置上
定义在外部类的局部位置上 --> 局部内部类,有类名
定义在外部类的局部位置上 --> 匿名内部类,无类名

内部类分类 --> 定义在外部类的成员位置上
定义在外部类的成员位置上 --> 成员内部类,无static修饰
定义在外部类的成员位置上 --> 静态内部类,有static修饰



```

### 局部内部类

#### 定义

局部内部类是定义在外部类的局部位置, 比如方法中, 并且有类名;

#### 基本语法

```java
class Outer {
    public void function() {
        class Inner {
        
    	}
    }
}

class Other {
    
}
```

#### 访问权限

局部内部类可以直接访问外部类的所有成员, 包含私有成员;

内部类属性和外部类属性同名时, 遵循就近原则, 如果需要访问外部类的同名属性, 则通过`外部类名.this.属性名` 的方式访问

外部类方法中访问局部内部类中的成员, 只能通过实例化局部内部类对象的方式来访问;

外部其他类不能访问局部内部类, 因为局部内部类相当于一个局部变量

#### 修饰符

局部内部类相当于一个局部变量, 访问修饰符不能修饰它, 但是可以被`final`修饰

#### 作用域

局部内部类的作用域仅仅是在定义它的方法或代码块中



### 匿名内部类

#### 定义

匿名内部类是定义在外部类的局部位置, 比如方法中, 并且无类名(表面上无类名), 同时还是一个对象

#### 基本语法

```java
class Outer {
    public void method() {
    	new 接口(参数列表) {
          
        };
        /*
        基于接口的匿名内部类相当于
        class 匿名内部类的隐藏名 implements 接口 {
        
        }
        */
        
        new 类(参数列表) {
            
        };
        /*
        基于类的匿名内部类相当于
        class 匿名内部类的隐藏名 extends 类名 {
        
        }
        */
   	}
}
```

#### 本质

匿名内部类的实质就是在一个类中声明了一个继承了父类的子类或实现了某个接口的类, 其中体现继承性;

所以可以从匿名内部类的参数列表传递参数给父类的构造器;	

```java
class Outer {
    public void method() {
    	new 接口(参数列表) {
          
        };
        /*
        基于接口的匿名内部类相当于
        class 匿名内部类的隐藏名(Outer$1) implements 接口 {
        
        }
        */
        
        
        new 类(参数列表) {
            
        };
        /*
        基于类的匿名内部类相当于
        class 匿名内部类的隐藏名(Outer$2) exte 类名 {
        
        }
        */
   	}
}
```

#### 方法调用

匿名内部类在创建的时候顺便自动实例化了对象, 所以匿名内部类既是类也是对象; 所以能直接调用其方法

```java
public void method() {
        //引用调用
        Person p = new Person() {
            @Override
            public void say() {
                System.out.println("引用调用");
            }
        };
        p.say();
        
   		//直接调用内部类的方法
        new Person() {
            @Override
            public void say() {
                System.out.println("直接调用");
            }
        }.say();
}
```

#### 访问权限

匿名内部类内可以直接访问外部类的所有成员, 包含私有成员;

内部类属性和外部类属性同名时, 遵循就近原则, 如果需要访问外部类的同名属性, 则通过`外部类名.this.属性名` 的方式访问;

外部类的方法中访问匿名内部类中的成员, 通过实例化内部类对象或直接调用的方式来访问;

外部其他类不能访问匿名内部类, 因为匿名内部类相当于一个局部变量;

#### 修饰符

匿名内部类相当于一个局部变量, 访问修饰符不能修饰它, 但是可以被`final`修饰

#### 作用域

匿名内部类的作用域仅仅是在定义它的方法或代码块中



### 成员内部类

#### 定义

成员内部类定义在外部类的成员位置, 并且没有 `static` 修饰,;

#### 修饰符

成员内部类可以地位是一个成员, 所以可以被访问修饰符修饰

#### 作用域

成员内部类的作用域为所嵌套在外部类的整个类内

#### 访问方式

成员内部类内 访问 外部类的成员(包含私有成员) : 直接访问

外部类内访问 访问 内部类的成员 (包含私有成员): 先实例化对象, 在通过对象访问

内部类属性和外部类属性同名时, 遵循就近原则, 如果需要访问外部类的同名属性, 则通过`外部类名.this.属性名` 的方式访问;

外部其他类访问成员内部类:

1. 直接在外部其他类中创建两次对象调用

   ```java
   外部类名.内部类名 对象名 = 外部类对象名.new 内部类名();
   ```

2. 在外部其他类调用外部类中定义的一个返回内部类的实例化对象的方法

```java
public class Test {
    public static void main(String[] args) {
        Outer outer = new Outer();
        //外部其他类调用内部类法一
        Outer.Inner inner1 = outer.new Inner();
        inner1.method();

        //外部其他类调用内部类法二
        Outer.Inner inner2 = outer.returnObject();
        inner2.method();
    }
}
```



### 静态内部类

#### 定义

成员内部类定义在外部类的成员位置, 并且有 `static` 修饰,;

#### 修饰符

成员内部类可以地位是一个成员, 所以可以被访问修饰符修饰

#### 作用域

成员内部类的作用域为所嵌套在外部类的整个类内

#### 访问方式

静态内部类内 访问 外部类的静态成员(包含私有静态成员) : 直接访问

外部类内 访问 静态内部类的静态成员(包含私有静态成员): 先实例化对象, 再通过对象访问

内部类静态属性和外部类静态属性同名时, 遵循就近原则, 如果需要访问外部类的同名静态属性, 则通过`外部类名.属性名` 的方式访问;

外部其他类 访问 静态内部类:

```java
public class Other {
    public static void main(String[] args) {
        Outer outer = new Outer();

        //外部其他类调用静态内部类法一
        //因为静态内部类可以直接通过类名访问
        Outer.Inner inner01 = new Outer.Inner();
        inner01.method();
        //外部其他类调用静态内部类法二
        Outer.Inner inner02 = outer.getStaticInnerClassObject();
        inner02.method();
    }
}
```



# 枚举和注解

## 枚举类

### 概括

#### 定义

枚举类(enumeration, 简称enum), 枚举是一组常量的集合; 枚举类可以理解为是一种特殊的类, 里面只包含一组有限的特定的对象;



### 自定义类实现枚举

#### 步骤

1. 将构造器私有化(防止实例化对象)
2. 删除`setXxx()`方法(防止对象的属性被修改)
3. 在Season内部直接创建固定的对象, 对象名采用全部大写(符合常量命名规范)
4. 通过final修饰优化对象, 调用对象时类不会加载



```java
package com.enum_.diy_enum;

/**
 * @ClassName: Test
 * @Description:
 * @date: 2023-03-16 20:44
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);
        System.out.println(Season.SUMMER);
        System.out.println(Season.AUTUMN);
        System.out.println(Season.WINTER);
    }
}

class Season {
    private String name;
    private String desc;

    //1. 构造器私有化
    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    //2. 删除setXxx()方法

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    //3. 在Season内部直接创建固定的对象
    //4. 通过final修饰优化对象, 使调用对象时类不会加载
    public static final Season SPRING = new Season("春天", "温暖");
    public static final Season SUMMER = new Season("夏天", "炎热");
    public static final Season AUTUMN = new Season("秋天", "凉爽");
    public static final Season WINTER = new Season("冬天", "寒冷");

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
```



### enum关键字实现枚举

#### 步骤

1. 使用关键字 `enum` 替代 `Class`
2. **首行**使用 `对象常量名(参数列表)` 替代自定义类实现枚举中的创建对象方式
   (如果使用无参构造器, 创建枚举对象, 则实参列表和小括号都可以省略)
3. 如有多个常量对象, 使用逗号间隔, 重复步骤2;
4. 私有化构造器

#### 细节

1. 当我们使用enum关键字开发一个枚举类时, 会隐式继承Enum类, 而且是一个`final`类, 通过`javap`反编译可以证明以上; 所以, **enum类不能继承其他的类**;
2. 在用enum枚举类时传统的`public static final 对象名 = new 类名(参数列表)` 会被简化成`对象名(参数列表)`

#### 反编译

```bash
E:\Github\Notes\CodeTest\javaProject\javaTest\out\production\javaTest\com\enum_\enum_enum>javap Season.class
Compiled from "Test.java"
final class com.enum_.enum_enum.Season extends java.lang.Enum<com.enum_.enum_enum.Season> {
  public static final com.enum_.enum_enum.Season SPRING;
  public static final com.enum_.enum_enum.Season SUMMER;
  public static final com.enum_.enum_enum.Season AUTUMN;
  public static final com.enum_.enum_enum.Season WINTER;
  public static com.enum_.enum_enum.Season[] values();
  public static com.enum_.enum_enum.Season valueOf(java.lang.String);
  public java.lang.String getName();
  public java.lang.String getDesc();
  public java.lang.String toString();
  static {};
}
```

#### 演示代码

```java
package com.enum_.enum_enum;

/**
 * @ClassName: Test
 * @Description:
 * @date: 2023-03-16 21:12
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);
        System.out.println(Season.SUMMER);
        System.out.println(Season.AUTUMN);
        System.out.println(Season.WINTER);
        System.out.println(Season.a);
        System.out.println(Season.b);
    }
}

enum Season {
    SPRING("春天", "温暖"), SUMMER("夏天", "炎热"), AUTUMN("秋天", "凉爽"), WINTER("冬天", "寒冷"), a(), b;

    private String name;
    private String desc;

    private Season() {}  //无参构造器
    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}

```



### Enum成员方法

#### name()

返回当前枚举类的常量的名称(对象名)

#### toString()

已经被Enum类重写, 返回当前对象名, 子类可以重写该方法, 用于返回对象属性信息

#### ordinal()

返回当前枚举的对象的编号, 编号从0开始;

#### values()

返回包含当前枚举类的所有对象名的数组

#### valueOf()

将字符串与枚举类中的对象名进行匹配, 匹配成功返回对象, 否则报错

#### compareTo()

比较两个枚举常量的位置号, 返回前者位置号与后者位置号相减的结果

#### 演示代码

```java
package com.enum_;

/**
 * @ClassName: EnumMethod
 * @Description:演示Enum类的成员方法
 * @date: 2023-03-18 15:57
 */
public class EnumMethod {
    public static void main(String[] args) {
        Season autumn = Season.AUTUMN;
        //name()返回当前枚举常量的名称
        System.out.println(autumn.name());
        //toString(), 已经被Enum类重写, 返回当前对象名, 子类可以重写该方法, 用于返回对象属性信息
        System.out.println(Season.SPRING);
        //ordinal()返回当前枚举常量的编号(从0开始)
        System.out.println(autumn.ordinal());
        //values()返回包含当前枚举类的所有对象名的数组
        Season[] values = Season.values();
        for(Season value : values) {
            System.out.println(value);
        }
        //valueOf()将字符串与枚举类中的对象名进行匹配, 匹配成功返回对象, 否则报错
        Season spring = Season.valueOf("SPRING");
        System.out.println(spring);
        System.out.println(spring == Season.SPRING);
        //compareTo()比较两个枚举常量的位置号, 返回前者位置号与后者位置号相减的结果
        System.out.println(Season.SPRING.compareTo(Season.SUMMER));
    }
}

enum Season {
    SPRING("春天", "温暖"), SUMMER("夏天", "炎热"),
    AUTUMN("秋天", "凉爽"), WINTER("冬天", "寒冷");

    private String name;
    private String desc;

    private Season() {}  //无参构造器
    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
```

### enum实现接口

enum实现的枚举类可以实现接口

#### 演示代码

```java
public class enumInterface {
    public static void main(String[] args) {
        Music.CLASSIC.playing();
    }
}

interface IP {
    public void playing();
}

enum Music implements IP{
    CLASSIC;

    @Override
    public void playing() {
        System.out.println("播放音乐");
    }
}
```



## 注解

### 概括

#### 定义

注解(Annotation)也被称为元数据(Metadata), 用于修饰包, 类, 方法, 属性, 构造器, 局部变量等数据信息;和注释一样, 注解不影响程序逻辑, 但注解可以被编译运行, 相当于嵌入在代码中的补充信息; 

#### 作用

在JavaSe中, 注解的使用目的比较简单, 例如标记过时的功能, 忽略警告等. 在JavaEE中注解占据了重要角色, 例如用来配置应用程序的任何切面, 代替JavaEE旧版中所遗留的繁冗代码和XML配置等;



### @Override

@Override表示指定重写父类方法, 如果注解了@Override的方法在父类中没有, 则会报错. 如果不写@Override注解, 而父类有子类同名方法, 则依然构成方法重写.

@Override只能修饰方法, 查看@Override注解源码为@Target(ElementType.METHOD), 说明只能修饰方法

@Target是修饰注解的注解, 称为源注解

#### 源码

```java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface Override {
}
```



### @Deprecated

@Deprecated注解修饰某个元素, 表明该元素已过时, 即不推荐使用, 但不是不能用;

可以修饰:方法, 类, 字段, 包, 参数等

@Deprecated可以做JDK版本升级过度使用

#### 源码

```java
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE})
public @interface Deprecated {
}
```

### @SuppressWarnings

我们写的有些代码, IEDA会在界面上有警告信息, 可以用@SuppressWarnings注解那些代码, 来抑制IDEA的警告;

#### 语法

```java
@SuppressWarings({"警告类型", "警告类型"})
```

#### 作用范围

作用范围和编写的位置相关, 比如@SuprressWarnings放在一个方法的前一行, 那么作用范围为整个方法;

#### 警告类型表

|警告类型|作用|
| ---- | ---- |
|all| 抑制所有警告|
|boxing|抑制与封装/拆装作业相关的警告|
|cast| 抑制与强制转型作业相关的警告|
|dep-ann| 抑制与淘汰注释相关的警告|
|deprecation| 抑制与淘汰的相关警告|
|fallthrough| 抑制与 switch 陈述式中遗漏 break 相关的警告|
|finally| 抑制与未传回 finally 区块相关的警告|
|hiding| 抑制与隐藏变数的区域变数相关的警告|
|incomplete-switch| 抑制与 switch 陈述式(enum case)中遗漏项目相关的警告|
|javadoc| 抑制与 javadoc 相关的警告|
|nls| 抑制与非 nls 字串文字相关的警告|
|null| 抑制与空值分析相关的警告|
|rawtypes| 抑制与使用 raw 类型相关的警告|
|resource| 抑制与使用 Closeable 类型的资源相关的警告|
|restriction| 抑制与使用不建议或禁止参照相关的警告|
|serial| 抑制与可序列化的类别遗漏 serialVersionUID 栏位相关的警告|
|static-access| 抑制与静态存取不正确相关的警告|
|static-method| 抑制与可能宣告为 static 的方法相关的警告|
|super| 抑制与置换方法相关但不含 super 呼叫的警告|
|synthetic-access| 抑制与内部类别的存取未最佳化相关的警告|
|sync-override| 抑制因为置换同步方法而遗漏同步化的警告|
|unchecked| 抑制与未检查的作业相关的警告|
|unqualified-field-access| 抑制与栏位存取不合格相关的警告|
|unused| 抑制与未用的程式码及停用的程式码相关的警告|

#### 源码

```java
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RetentionPolicy.SOURCE)
public @interface SuppressWarnings {
    String[] value();
}
```



### 元注解

JDK的元注解用于修饰其他的注解

#### Retention

只能用于修饰一个 Annotation 定义, 用于指定该 Annotation 可以保留多长时间, @Rentention 包含一个 RetentionPolicy
类型的成员变量, 使用 @Rentention 时必须为该 value 成员变量指定值:

1) RetentionPolicy.SOURCE: 编译器使用后， 直接丢弃这种策略的注释
2) RetentionPolicy.CLASS: 编译器将把注解记录在 class 文件中. 当运行 Java 程序时, JVM 不会保留注解. 这是默认
   值
3) RetentionPolicy.RUNTIME:编译器将把注解记录在 class 文件中. 当运行 Java 程序时, JVM 会保留注解. 程序可以
   通过反射获取该注解 

```java
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Retention {
    /**
     * Returns the retention policy.
     * @return the retention policy
     */
    RetentionPolicy value();
}
```



#### Target

用于修饰一个 Annotation 定义, 指定被修饰的注解可以修饰哪些程序元素. @Target也包含一个名为value的成员变量

```java
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Target {
    /**
     * Returns an array of the kinds of elements an annotation type
     * can be applied to.
     * @return an array of the kinds of elements an annotation type
     * can be applied to
     */
    ElementType[] value();
}
```



#### Documented

用于指定被该元注解修饰的注解类将被JavaDoc工具提取成文档, 即在生成文档时, 可以看到该注解;

```java
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Documented {
}
```



#### Inherited

被@Inherited修饰的注解将具有继承性, 即如果某个类使用了被@Inherited修饰的注解, 则子类将自动被那个注解修饰;



# 异常

> 当程序逐行执行到有错误的代码行的时候, 程序会抛出相应类型的异常, 当抛出异常后, 程序结束, 不再执行后面的代码; 所以只要出现一个非致命错误, 就导致整个系统结束运行, 异常处理机制应运而生; 如果程序员觉得某些代码行的代码有可能出现异常, 可以使用异常处理机制来解决, 从而保证程序的健壮性容错性;



## 基本概念

### 异常定义

Java语言中,  将程序执行中发生的不正常情况称为异常. 语法错误和逻辑错误不称为异常. 

### 异常事件分类

1. Error(错误)：Java虚拟机无法解决的严重问题。如：JVM系统内部错误、资源耗尽等严重情况。比如：StackOverflowError[栈溢出]和OOM(out of memory),Error是严重错误，程序会崩溃。
2. Exception:其它因编程错误或偶然的外在因素导致的一般性问题，可以使用针对性的代码进行处理. 例如空指针访问，试图读取不存在的文件，网络连接中断等等，Exception分为两大类：运行时异常和编译时异常.

### 异常体系图

![](https://cdn.jsdelivr.net/gh/chousinbin/Image/202303241111492.png)



## 运行时异常

### 定义

运行时异常是编译器检查不出来的异常, 一般是指编译时发生的逻辑错误, 是程序员应该避免其出现的异常; 

对于运行时异常, 可以不做处理, 默认的处理方法就是隐式的throws处理异常, 最终会抛给JVM.  因为这类异常很普遍, 若全处理可能对程序的可读性和运行效率产生影响;

### NullPointerException

当应用程序试图在需要对象的地方使用null时抛出空指针异常

```java
public class NullPointer {
    public static void main(String[] args) {
        String name = null;
        System.out.println(name.length());
    }
}

Exception in thread "main" java.lang.NullPointerException
	at com.exception_.NullPointer.main(NullPointer.java:4)
```



### ArithmeticException

当出现异常的运算条件时, 抛出算数异常

```java
public class ArithmeticException {
    public static void main(String[] args) {
        int n1 = 10;
        int n2 = 0;

        int res = n1 / n2;  //抛出异常
        System.out.println("程序正在运行");  //从此不再执行
    }
}

Exception in thread "main" java.lang.ArithmeticException: / by zero
	at com.exception_.ArithmeticException.main(ArithmeticException.java:6)
```



### ArrayIndexOutOfBounds

用非法索引访问数组时抛出的数组下标越界异常

```java
public class ArrayIndexOutOfBounds {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3};
        for (int i = 0; i <= arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}

Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 4
	at com.exception_.ArrayIndexOutOfBounds.main(ArrayIndexOutOfBounds.java:5)
```



### ClassCastException

当试图将对象强制转换为不是实例的子类时, 抛出类型转换异常

```java
public class ClassCast {
    public static void main(String[] args) {
        A a = new B();
        B b = (B) a;
        C c = (C) a;
    }
}

class A {}
class B extends A {}
class C extends A {}

Exception in thread "main" java.lang.ClassCastException: com.exception_.B cannot be cast to com.exception_.C
	at com.exception_.ClassCast.main(ClassCast.java:5)
```



### NumberFormatException

当应用程序试图将字符串转换成一种数值类型, 但该字符串不能转换为适当格式时, 抛出该数字格式不正确异常, 使用异常可以确保输入是满足条件数字

```java
public class NumberFormatException {
    public static void main(String[] args) {
        String name = "1234";
        int num = Integer.parseInt(name);
        
        name = "zhou";
        num = Integer.parseInt(name);
    }
}

Exception in thread "main" java.lang.NumberFormatException: For input string: "zhou"
	at java.lang.NumberFormatException.forInputString(Unknown Source)
	at java.lang.Integer.parseInt(Unknown Source)
	at java.lang.Integer.parseInt(Unknown Source)
	at com.exception_.NumberFormatException.main(NumberFormatException.java:7)
```



## 编译时异常

### 定义

编译异常是指在编译期间, 就必须处理的异常, 比如用try-catch 或者 throws,否则代码不能通过编译.

### 常见编译异常

| 异常                      | 含义                               |
| ------------------------- | ---------------------------------- |
| SQLException              | 操作数据库时, 查询表可能发生异常   |
| IOException               | 操作文件时, 发生的异常             |
| FileNotFoundException     | 当操作一个不存在的文件时, 发生异常 |
| ClassNotFoundException    | 加载类, 而该类不存在时, 发生异常   |
| EOFException              | 操作文件, 到文件末尾, 发生异常     |
| IllegalArguementException | 参数异常                           |



## 异常处理

异常处理就是当异常发生时, 对异常的处理方式.

### try

#### try-catch-finall

```java
try {
	可能有异常的代码块;
    //如果try块内某行代码发生异常, 则try中那行之后的代码不会被执行
    //当异常发生时, 系统将异常封装成Exception类型的异常对象e, 传递给catch
} catch (Exception e) {
    //捕获到异常
    //输出异常信息
    //如果没有异常发生, 不会执行catch代码块
} finally {  //finally不是必须的
    //不管try里的代码块是否有异常发生, finally块始终被执行
    //所以通常将释放资源的代码放在finally中
}
```

可以有多个catch语句, 用于捕获不同类型的异常, 要求父类异常在后, 子类异常在前, 比如Exception在后, NullPointerException在前; 如果发生异常, 只会匹配一个catch

#### try-finally

这种用法相当于没有捕获异常, try中发生异常后, 执行finally, finally执行完毕中断程序.

应用场景:执行一段代码时, 不管是否发生异常, 都必须执行某个业务逻辑, 此业务逻辑的代码就放在finally中.

```java
public class TryFinally {
    public static void main(String[] args) {
        try {
            int a = 10;
            int b = 0;
            System.out.println(a / b);
        } finally {
            System.out.println("总是执行");
        }
    }
}
```



### throws

如果一个方法中的语句执行时可能生成某种异常, 但是不能确定如何处理这些异常, 则此方法应显示地声明抛出异常, 表明该方法将不对这些异常进行处理, 而由该方法的调用者负责处理.

在方法声明中用throws语句可以声明抛出异常的列表, throws后面异常类型可以是方法中产生的异常类型, 也可以是它的父类类型.

将发生的异常抛给上一级调用者, 顶级调用者为JVM, 对于一个异常处理, 不是try-catch-finally就是throws. 如果在代码中没有显示的处理方法, 那么就会默认使用隐式的异常处理, 即为throws, 最终throws到JVM, 而JVM作为最高级调用者, 他就会简单的输出异常信息, 中断程序.

<img src="https://cdn.jsdelivr.net/gh/chousinbin/Image/202304021340954.png" alt="image-20230402134033727" style="zoom: 33%;" />

#### 细节

1. 子类重写父类的方法时, 对抛出异常的规定:子类重写的方法, 所抛出的异常类型要么和父类抛出的类型一致, 要么为父类抛出异常的类型的子类型.
2. 在throws过程中, 如果有方法try-catch处理异常, 就可以不必throws 



## 自定义异常

### 概念

当程序中出现了某些"错误", 但该错误信息并没有在Throwable子类中描述处理, 这个时候可以自己设计异常类, 用于描述该错误信息.

### 步骤

1. 自定义类:自定义异常类名, 继承Exception或RuntimeException类
2. 如果继承Exception类属于编译异常
3. 如果继承RuntimeException类属于运行异常

### 举例代码

```java
//要求范围在18-120之间,否则抛出自定义异常,并给出提示信息
public class CustomException {
    public static void main(String[] args) {
        int age = 800;

        if(age < 18 || age > 120) {
            throw new AgeException("输入应在18-120之间");
        }

        System.out.println("输入范围正确");
    }
}
class AgeException extends RuntimeException {
    public AgeException(String message) {
        super(message);
    }
}


Exception in thread "main" com.exception_.AgeException: 输入应在18-120之间
	at com.exception_.CustomException.main(CustomException.java:6)
```



## throw与throws区别

| 类型   | 意义                   | 位置       | 后面跟的东西 |
| ------ | ---------------------- | ---------- | ------------ |
| throws | 异常处理的一种方式     | 方法声明处 | 异常类型     |
| throw  | 手动生成异常类型关键字 | 方法体中   | 异常对象     |

