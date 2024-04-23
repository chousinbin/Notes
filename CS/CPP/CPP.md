# CPP

> 上机 + 表现：12
>
> 测验：12
>
> 大作业：6
>
> 期末：
>
> - 读程序写结果：类、拷贝构造函数、继承
> - 编程题：函数、重载、杨辉三角

## 2

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

# 运算符重载

> 16 - 18 分
>
> 不考读程序写结果

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

#### MyPoint例子

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

