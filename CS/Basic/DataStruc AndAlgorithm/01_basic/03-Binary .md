# 二分

> 无单调性也可以二分~

## 整数二分

关键：确定数据的左右边界点

### 整数二分模板

#### 左边界

```cpp
// 找左边界
bool check() {}
int main()
{
	while(l < r)
    {
        int mid = l + r >> 1;
        // mid 符合条件，收缩右边界，最后得到满足条件的左边界
        if(check(mid)) r = mid;
        else l = mid + 1;
    }
}
```

#### 右边界

```cpp
// 找右边界
bool check() {}
int main()
{
    /*
    	如果使用 mid = l + r >> 1;
    	当 l = r - 1时，
    	如果check() = true，会陷入死循环
    	所以需要补上 + 1
    */
	int mid = l + r + 1>> 1;
    // mid 符合条件，收缩左边界，最后得到满足条件的右边界
    if(check(mid)) l = mid;
    else r = mid - 1;
}
```

### 数的范围

#### 题目描述

给定一个按照升序排列的长度为 $n$ 的整数数组，以及 $q$ 个查询。

对于每个查询，返回一个元素 $k$ 的起始位置和终止位置（位置从 $0$ 开始计数）。

如果数组中不存在该元素，则返回 `-1 -1`。

#### 输入格式

第一行包含整数 $n$ 和 $q$，表示数组长度和询问个数。

第二行包含 $n$ 个整数（均在 $1∼10000$ 范围内），表示完整数组。

接下来 $q$ 行，每行包含一个整数 $k$，表示一个询问元素。

#### 输出格式

共 $q$ 行，每行包含两个整数，表示所求元素的起始位置和终止位置。

如果数组中不存在该元素，则返回 `-1 -1`。

#### 数据范围

$1≤n≤100000$
$1≤q≤10000$
$1≤k≤10000$

#### 输入样例

```
6 3
1 2 2 3 3 4
3
4
5
```

#### 输出样例

```
3 4
5 5
-1 -1
```

#### AC代码

```c++
#include <bits/stdc++.h>

using namespace std;

const int N = 1e5 + 10;

int a[N];

int main()
{
	int n, q;
	cin >> n >> q;
	
	for(int i = 0; i < n; i++)
		cin >> a[i];
	
	int k;
	while(q--)
	{
		cin >> k;
		int l = 0, r = n - 1;
		while(l < r)
		{
			int mid = l + r >> 1;
			if(a[mid] >= k) r = mid;
			else l = mid + 1;
		}
		
		if(a[l] != k)
		{
			cout << -1 << ' ' << -1 << endl;
		}
		else
		{
			cout << l << ' ';
			l = 0, r = n - 1;
			while(l < r)
			{
				int mid = l + r + 1 >> 1;
				if(a[mid] <= k) l = mid;
				else r = mid - 1;
			}
			cout << l << endl;
		}
	}
	return 0;
}
```

## 浮点数二分

精度到 $x$ 位，那么判断就要到 $x + 2$ 位。

### [数的三次方根](https://www.acwing.com/problem/content/792/)

#### 题目描述

给定一个浮点数 $n$，求它的三次方根。

#### 输入格式

共一行，包含一个浮点数 $n$。

#### 输出格式

共一行，包含一个浮点数，表示问题的解。

注意，结果保留 $6$ 位小数。

#### 数据范围

$−10000≤n≤10000$

#### 输入样例

```
1000.00
```

#### 输出样例

```
10.000000
```

#### AC代码

```c++
#include <bits/stdc++.h>

using namespace std;

int main()
{
    double n;
    // double 用 lf
    scanf("%lf", &n);
    
    double l = -100, r = 100;
    // double 不是准确的值，需要扩大进度判断
    while(r - l > 1e-8)
    {
        double mid = (l + r) / 2;
        if(mid * mid * mid >= n) r = mid;
        // mid + 1 可能跳过答案, 需要的是立方根，不是一个精确的整数
        else l = mid;
    }
    
    printf("%.6lf", l);
    return 0;
}
```
