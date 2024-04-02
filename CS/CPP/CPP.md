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

