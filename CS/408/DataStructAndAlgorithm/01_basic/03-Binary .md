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

## 冶炼金属

```cpp
#include <bits/stdc++.h>
using namespace std;

const int N = 1e4 + 10;
// 右端点，V_max
int check_r(int a, int b)
{
    int l = 1, r = 1e9;
    while(l < r)
    {
        int mid = l + r + 1 >> 1;
        // 左半边全合法，得到的是右端点
        if(a / mid >= b) l = mid;
        else r = mid - 1;
    }
    return r;
}
// 左端点，V_min
int check_l(int a, int b)
{
    int l = 1, r = 1e9;
    while(l < r)
    {
        int mid = l + r >> 1;
        // 右半边全合法，得到的是左端点
        if(a / mid <= b) r = mid;
        else l = mid + 1;
    }
    return r;
}
int main()
{
    int n;
    cin >> n;
    
    int V_min = 0, V_max = 1e9;
    for(int i = 0; i < n; i++)
    {
        int a, b;
        cin >> a >> b;
        V_min = max(V_min, check_l(a, b));
        V_max = min(V_max, check_r(a, b));
    }
    cout << V_min << ' ' <<V_max;
    return 0;
}
```

## 机器人跳跃问题

### 问题描述

机器人正在玩一个古老的基于 DOS 的游戏。

游戏中有 $N+1$ 座建筑——从 $0$ 到 $N$ 编号，从左到右排列。

编号为 $0$ 的建筑高度为 $0$ 个单位，编号为 $i$ 的建筑高度为 $H(i)$ 个单位。

起初，机器人在编号为 $0$ 的建筑处。

每一步，它跳到下一个（右边）建筑。

假设机器人在第 $k$个建筑，且它现在的能量值是 $E$，下一步它将跳到第 $k+1$ 个建筑。

如果 $H(k+1)>E$，那么机器人就失去 $H(k+1)−E$ 的能量值，否则它将得到 $E−H(k+1)$ 的能量值。

游戏目标是到达第 $N$ 个建筑，在这个过程中能量值不能为负数个单位。

现在的问题是机器人至少以多少能量值开始游戏，才可以保证成功完成游戏？

### 解题思路

对于初始的 $E$ 满足二段单调性，如果一个 $E$ 满足了在所有跳跃的点的能量都不为 $0$ ，那么大于等于 $E$ 的都能满足，所以我们只需要二分 $E$ ，检查是否能满足非 $0$ 就可以找到最小的 $E$。

根据题意和公式化简可以得出，无论当前能量比下一个建筑的高度多还是少，其能量变化都为 $2*E - h(k+1)$

### AC代码

```c++
#include<bits/stdc++.h>
using namespace std;
const int N=1e5+10;
int n,h[N];
bool cheak(int e)
{
    for(int i=1;i<=n;i++)
    {
        e=2*e-h[i];
        if(e<0) return false;
        if(e>=1e5) return true;//如果e的值大于等于高度的最大值根据上面公式可以得出必然e在今后不会为负数
    }
    return true;
}
int main()
{
    cin>>n;
    
    for(int i=1;i<=n;i++) cin>h[i];
    
    int l=0,r=1e5;
    while(l<r)
    {
        int mid=l+r>>1;
        if(cheak(mid)) r=mid;
        else l=mid+1;
    }
    
    cout<<l;
    return 0;}
```



## 四平方和

### 题目描述

四平方和定理，又称为拉格朗日定理：

每个正整数都可以表示为至多 $4$ 个正整数的平方和。

如果把 $0$ 包括进去，就正好可以表示为 $4$ 个数的平方和。

比如：

$5=0^2+0^2+1^2+2^2$
$7=1^2+1^2+1^2+2^2$

对于一个给定的正整数，可能存在多种平方和的表示法。

要求你对 $4$ 个数排序：

$0≤a≤b≤c≤d$

并对所有的可能表示法按 $a,b,c,d$ 为联合主键升序排列，最后输出第一个表示法。

数据范围

$0<N<5∗10^6$

### 如何替代三重循环暴力枚举？

把三重循环转化为两个双重循环，分别枚举$c,d$ 和$a,b$，即可降低时间复杂度。

### 如何得到字典序最小的解

因为a和b都是从最小开始枚举的，所以在有解的情况下a和b一定是最小的。所以我们只需确定c和d同时是最小的。为了找到c和d同时是最小的解，我们利用一个结构体来存储c^2^+d^2^,c,d。枚举完c和d后按照c^2^+d^2^,c,d优先级的递增的顺序进行结构体排序。再枚举a和b，利用二分找到四平方和的解，找到的就是最小的解。

### AC代码

```c++
#include<bits/stdc++.h>
using namespace std;
const int N=3e6+10;
int n,m;
struct Stu
{
    int e,c,d;
}s[N];

bool cmp(const Stu &x,const Stu &y)
{
    if(x.e != y.e) return x.e<y.e;
    if(x.c != y.c) return x.c<y.c;
    return x.d<y.d;
}


int main()
{
    cin>>n;
    
    for(int c=0;c*c<=n;c++)
    {
       for(int d=c;c*c+d*d<=n;d++)
        {
            s[m++]={c*c+d*d,c,d};
        }
    }
    
    sort(s,s+m,cmp);
    
   for(int a=0;a*a<=n;a++)
       for(int b=a;b*b+a*a<=n;b++)
       {
           int t=n-a*a-b*b;
           int l=0,r=m;
           while(l<r)
           {
               int mid=l+r>>1;
               if(s[mid].e>=t) r=mid;
               else l=mid+1;
           }
           if(s[l].e==t)
           {
               cout<<a<<' '<<b<<' '<<s[l].c<<' '<<s[l].d;
               return 0;
           }
       }
    return 0;
}
```

```c++
#include<bits/stdc++.h>
using namespace std;
typedef pair<int,int> PII;
const int N=2500010;
int n,m;
unordered_map<int,PII> S;

int main()
{
    for(int c=0;c*c<=n;c++)
    {
        for(int d=c;d*d+c*c<=n;d++)
        {
            int t=c*c+d*d;
            if(S.count(t)==0)
            {
                S[t]={c,d};//把c*c+d*d作为key值 利用哈希进行排序存储 
                //因为c和d是从小到大枚举的 所以第一个满足c*c+d*d的字典序就是最小的
            }
        }
    }

    for(int a=0;a*a<=n;a++)
    {
        for(int b=a;a*a+b*b<=n;b++)
        {
            int t=n-a*a-b*b;
            if(S.count(t))
            {
                cout<<a<<' '<<b<<' '<<S[t].first<<' '<<S[t].second;
                return 0;
            }
        }
    }
    return 0;
}
```

## 分巧克力

儿童节那天有 $K$ 位小朋友到小明家做客。

小明拿出了珍藏的巧克力招待小朋友们。

小明一共有 $N$ 块巧克力，其中第 $i$ 块是 $Hi×Wi$ 的方格组成的长方形。

为了公平起见，小明需要从这 $N$ 块巧克力中切出 $K$ 块巧克力分给小朋友们。

切出的巧克力需要满足：

1. 形状是正方形，边长是整数
2. 大小相同

例如一块 $6×5$ 的巧克力可以切出 $6$ 块 $2×2$ 的巧克力或者 $2$ 块 $3×3$ 的巧克力。

当然小朋友们都希望得到的巧克力尽可能大，你能帮小明计算出最大的边长是多少么？

### 解题思路

<img src="https://cdn.jsdelivr.net/gh/chousinbin/Image/202210221136022.png" style="zoom:50%;" />

由于边长和块数成反比例关系，块数越多边长最小，所以我们利用这个性质，用二分找到大于等于所求块数对应的边长，就是满足题意的最大边长。

```c++
#include<bits/stdc++.h>
using namespace std;

const int N=1e5+10;
int n,k;
int w[N],h[N];
bool check(int x)
{
    int res=0;
    for(int i=0;i<n;i++)
    {
        res=res+(w[i]/x)*(h[i]/x);
    }
    if(res<k) return false;
    else return true;
}
int main()
{
    cin>>n>>k;
    
    for(int i=0;i<n;i++)
    {
        cin>>h[i]>>w[i];
    }
    
    int l=1,r=1e5;
    while(l<r)
    {
        int mid=l+r+1>>1;
        if(check(mid)) l=mid;//个数多的时候边长是小的 求边长是最大的 所以l=mid
        else r=mid-1;
    }
    
    cout<<l;
    return 0;
}
```

## 盖楼

### 算法标签

- 二分
- 容斥原理
- 最小公倍数

### 实现思路

现在有 5 个集合，分别为

- $U$: 所有楼层的集合，大小为 $H$；
- $A$: 所有 $x$ 的倍数的集合，大小为 $a$；
- $B$: 所有 $y$ 的倍数的集合，大小为 $b$；
- $C$: 所有 $x$ 与 $y$ 公倍数的集合，大小为 $c$；
- $P$: 既不是 $x$ 的倍数，又不是 $y$ 的倍数，$P=U-A\ \cup \ B = H - a - b + c$ 

注：集合 $A$ 和 $B$ 都是包含 $C$ 的，$P$ 集合是万能的。

- 只能分给贝茜的个数 = $b-c$
- 只能分给贝蒂的个数 = $a - c$
- 万能的个数 = $H - a - b + c$

综上：能满足分配的个数分别为，$H - a - b + c >= N -(b - c) + M - (a - c)$ 

### 实现代码

```cpp
#include <iostream>
#include <algorithm>
using namespace std;

typedef long long LL;
int n, m, x, y;

bool check(LL h)
{
    LL a = h / x;
    LL b = h / y;
    LL c = h / (x * y);
    // 还需要的应该保证 >= 0
    LL xx = max(0ll, n - (b - c));
    LL yy = max(0ll, m - (a - c));
    LL p = h - a - b + c;

    return p >= xx + yy;
}

int main()
{
    cin >> n >> m >> x >> y;

    int l = 1, r = 6e9;
    while (l < r)
    {
        LL mid = (LL)l + r >> 1;
        if (check(mid)) r = mid;
        else l = mid + 1;
    }

    cout << r;
    return 0;
}
```

