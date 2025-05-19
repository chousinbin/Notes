# CPP

> 上机 + 表现：12
>
> 测验：12
>
> 大作业：6
>
> 期末：
>
> - 选择题(15 * 2)：
> - 读程序写结果(20 * 2)：类、拷贝构造函数、继承、多态、虚函数
> - 编程题(10 + 20)：课本编程题、运算符重载

## 01 基础

#### identifiers

can be letters, digits and underscores, can start with letters or underscores

#### sizeof

sizeof 计算 字符串时会计算字符串尾的‘/0’

```cpp
int main()
{
	cout << sizeof("123"); // 4
	return 0; 
}
```

#### :: 作用域解析符

#### static 变量初始化

```cpp
// 静态变量初始化的位置在类的结尾
int Circle :: numberofObject = 0;
```

#### const 函数

const 函数不能修改对象的属性，只能读取；

```cpp
int name() const
```

#### const 属性

const 修饰属性后，属性变为常量，只能在声明时或构造函数内赋值，其他地方不可被修改；

```cpp
const int N = 1e5 + 10;
```

### 指针

#### 指向常量的指针

```
const int *p = &a;
```

*p 不能修改

#### 常量指针

```
int * const p = &a;
```

p 的地址不能修改

### 引用

```cpp
int a = 3;
int &c = a;
c++;
cout << a; // 4
```

### 输出格式

1 个 \t 等于 8 个空格

## 04 函数

#### 默认参数

默认参数，但必须从右向左提供默认参数

```
void fun(int x = 0, int) // 错误
void fun(int x = 0, int t = 0) 
void fun(int x, int t = 0)
void fun(int x, int, int, int t = 0)
void fun(int x, int, int, int)
```

- 定义和调用
- 重载
- 传值
- 传引用
- 传指针

```cpp
#include<iostream>
using namespace std;

void swap_p(int *a, int *b)
{
	int t = *b;
	*b = *a;
	*a = t;
}

void swap_r(int &a, int &b)
{
	int t = b;
	b = a;
	a = t;
}

void swap_v(int a, int b)
{
	int t = b;
	b = a;
	a = t;
}

int main()
{
	int a = 3, b = 4;
	swap_r(a, b);
	cout << a << ' ' << b << endl;

	swap_p(&a, &b);
	cout << a << ' ' << b << endl;

	swap_v(a, b);
	cout << a << ' ' << b << endl;
}

```

## 05 类

成员属性可以有默认值

- 构造顺序：基类、成员函数、自己的构造函数
- 析构
- 常量函数：不能修改、输入成员变量
- 静态函数
- 静态数据：不占用类的存储空间
- 类的友元函数：允许类外访问类内私有数据

## 06 拷贝构造函数

- 拷贝构造函数的定义和调用
- 堆空间的申请和释放：用指针操作2

## 07 运算符重载

> 编程 20 分，7 个重载函数(4 个成员函数、3 个友元函数)

1. 复数相加
2. 点相加
3. 有理数相加

类内函数顺序无区别。

运算符重载：能使得自定义的数据类型实现和普通运算符一样的基本运算。

```cpp
返回类型 operator运算符 (参数列表) {}
```

### 不能被重载的运算符

```cpp
?:
.
.*
::
sizeof
```

### 必须为成员函数

```
=
```

### 哪些必须为友元

```
<<
>>
```

### MyPoint例子

```cpp
#include<bits/stdc++.h>
using namespace std;

class MyPoint
{
		int x, y;
	
	public:
		MyPoint(int x = 0, int y = 0)
		{
			this->x = x;
			this->y = y;
		}
		
		MyPoint operator+ (MyPoint &b)
		{
			MyPoint tmp;
			tmp.x = x + b.x;
			tmp.y = y + b.y;
			return tmp;	
		}
		// 全局函数，不属于类，可以访问私有属性 
		friend MyPoint operator- (MyPoint &a, MyPoint &b);
		friend bool operator>= (MyPoint &a, MyPoint &b);
		friend void operator*= (MyPoint &a, MyPoint &b);
		
		int getX()
		{
			return x;
		}
		
		int getY()
		{
			return y;
		}
		// 参数列表带 int 默认后增，反之前增
		const MyPoint operator++(int)
		{
			cout << "后增 post - increment" << endl;
			MyPoint old(x, y);
			x++;
			y++;
			return old;
		}
		// 返回引用避免再次调用拷贝构造函数
		const MyPoint& operator++()
		{
			cout << "前增 pre - increment" << endl;
			++x;
			++y;
			return *this;
		}

		friend const MyPoint & operator--(MyPoint &a);
		friend const MyPoint operator--(MyPoint &a, int);

		// 输出符号必须作为友元函数
		friend ostream& operator<<(ostream &, MyPoint &);
		friend istream& operator>>(istream &, MyPoint &);
	
};
// 两点的分量直接相减 
MyPoint operator- (MyPoint &a, MyPoint &b)
{
	MyPoint tmp;
	tmp.x = a.x - b.x;
	tmp.y = a.y - b.y;
	return tmp;	
}
// 两点的 x 相比较 
bool operator>= (MyPoint &a, MyPoint &b)
{
	return a.x >= b.x;
}
// 两点分量直接相乘 
void operator*= (MyPoint &a, MyPoint &b)
{
	a.x *= b.x;
	b.y *= b.y;
//	return a;
}

const MyPoint& operator--(MyPoint &a)
{
	cout << "pre - decrement" << endl;
	--a.x;
	--a.y;
	return a;
}

const MyPoint operator--(MyPoint &a, int)
{
	cout << "post - decrement" << endl;
	MyPoint old(a.x, a.y);
	a.x--;
	a.y--;
	return old;
}

ostream& operator<<(ostream &out, MyPoint &obj)
{
	out << obj.x << ' ' << obj.y;
	return out;
}

istream& operator>>(istream &in, MyPoint &obj)
{
	in >> obj.x >> obj.y;
	return in;
}

int main()
{
	MyPoint a(1, 2);
	MyPoint b(3, 4);
	
	MyPoint c = a + b;
	cout << c.getX() << ' ' << c.getY() << endl;
	
	MyPoint d = a - b;
	cout << d.getX() << ' ' << d.getY() << endl;
	
	cout << (a >= b) << endl;
	
	a *= b;
	cout << a.getX() << endl;
	// 前增与后增
	cout << a.getX() << ' ' << a.getY() << endl;
	++a;
	a++;
	cout << a.getX() << ' ' << a.getY() << endl;
	// 前减与后减
	cout << a.getX() << ' ' << a.getY() << endl;
	--a;
	a--;
	cout << a;

	// 验证输入输出
	MyPoint p4;
	cin >> p4;
	cout << p4 << endl;

	return 0;
}

```

## 08 封装和继承

## 09 多态和虚函数

- 静态联编：发生在编译时期
- 动态联编：发生在运行时期

### 虚函数

- **不能是静态函数**
- 虚函数的重写在子类中可以省略 virtual
- 虚函数不一定从基类开始虚函数，可以从某个子类开始虚函数
- 虚函数只能在 public 与 protected 的类中使用

```cpp
virtual void fun();
```

## 10 模板

模板是代码复用的工具

### 函数模板

```cpp
#include<bits/stdc++.h>
using namespace std;

template<typename T>
T fun(T x, T y)
{
	return x > y ? x : y;    
}

int main()
{
    cout << fun(1, 2);
    cout << fun(1.1, 2.22);
    
    return 0;
}
```

### 类模板

```cpp
#include<bits/stdc++.h>
using namespace std;

template<class T>
class sample{
	T n;
	public:
		sample(){}
		sample(T i) { n = i;}
		sample<T> operator+(sample<T> &);
		void dis() { cout << n << endl; }
};

template<class T>
sample<T> sample<T>::operator+(sample<T> &s)
{
	sample<T> temp;
	temp.n = n + s.n;
	return temp;
}

int main()
{
	sample<int> s1(10), s2(20), s3;
	sample<double> s4;
	s3 = s1 + s2;
	s3.dis();
	
	return 0;
}
```



