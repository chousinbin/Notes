# CPP

> 上机 + 表现：12
>
> 测验：12
>
> 大作业：6

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
		MyPoint(int x=0, int y = 0)
		{
			this->x=x;
			this->y=y;
		}
		
		MyPoint operator+ (MyPoint &b)
		{
			MyPoint tmp;
			tmp.x=x+b.x;
			tmp.y=y+b.y;
			return tmp;	
		}
    
		friend MyPoint operator- (MyPoint &a, MyPoint &b);
};

MyPoint operator- (MyPoint &a, MyPoint &b)
{
	MyPoint tmp;
	tmp.x= a.x-b.x;
	tmp.y= a.y-b.y;
	return tmp;	
}

int main()
{
	MyPoint a(5, 5);
	MyPoint b(3, 8);
	
	MyPoint c = a + b;
	
	MyPoint d = a - b;

	return 0;
}
```

