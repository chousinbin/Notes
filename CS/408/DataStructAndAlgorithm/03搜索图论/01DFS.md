# DFS

> 深度优先搜索

**所有的递归都可以转换成递归搜索树**

<img src="https://cdn.jsdelivr.net/gh/chousinbin/Image/202210221136934.png" style="zoom:50%;" />

## 简单斐波那契

输出前 $n$ 个斐波那契数。斐波那契初始 `0,1,1,2,3`

### 递推法 $O(n)$

```cpp
int n;
cin >> n;

int a = 0, b = 1;
for(int i = 0; i < n; i++)
{
    cout << a << ' ';
    int c = a + b;
    a = b, b = c;
}
```

### 递归法 $2^n$

```c++
int Fibonacci(int n)
{
	if(n <= 1) return n;
	else return Fibonacci(n - 1) + Fibonacci(n - 2);
}
```

> We are all racing against ourselves
> There is no end ahead
> The struggle never stops
>
> ---2024-4-5 21:30:21

## 递归实现指数型枚举

### 问题描述

从 $1∼n$ 这 $n$ 个整数中随机选取任意多个，输出所有可能的选择方案。

### 输入格式

输入一个整数 $n$。

### 输出格式

每行输出一种方案。

同一行内的数必须升序排列，相邻两个数用恰好 $1$ 个空格隔开。

对于没有选任何数的方案，输出空行。

本题有自定义校验器$（SPJ）$，各行（不同方案）之间的顺序任意。

### 解题思路

- 转化为递归搜索树，利用一个数组表示两种状态选或不选，所有情况遍历一遍；
- 根据选或不选进行输出；
- 核心为$DFS$ 回溯（恢复现场）。

### 实现代码

```c++
#include<bits/stdc++.h>
using namespace std;

const int N = 20;

int n;
bool is_selected[N];

// u 表示当前枚举第几个数
void dfs(int u)
{
	if(u > n)
	{
		for(int i = 1; i <= n; i++)
			if(is_selected[i] == true) 
				cout << i << ' ';
		
		cout << endl;
		return;
	}
	
	// 不选
	is_selected[u] = false;
	dfs(u + 1);
	// 选
	is_selected[u] = true;
	dfs(u + 1);
}
int main()
{
	cin >> n;
	
	dfs(1);
	
	return 0;
}
```

## 递归实现排列型枚举

把 $1∼n$ 这 $n$ 个整数排成一行后随机打乱顺序，输出所有可能的次序。

### 输入格式

一个整数 $n$。

### 输出格式

按照从小到大的顺序输出所有方案，每行 $1$ 个。

首先，同一行相邻两个数用一个空格隔开。

其次，对于两个不同的行，对应下标的数一一比较，字典序较小的排在前面。

### AC代码

```c++
#include <bits/stdc++.h>
using namespace std;

const int N = 20;

bool st[N];
int num[N];
int n;

void dfs(int u)
{
	if(u > n)
	{
		for(int i = 1; i <= n; i++)
			cout << num[i] << ' ';
		cout << endl;
		return;
	}
	// 从小到大枚举 1 - n
	// 保证答案顺序按字典序递增
	for(int i = 1; i <= n; i++)
	{
		if(st[i] == false)
		{
			st[i] = true;
			num[u] = i;
			dfs(u + 1);
			st[i] = false;
		}
	}
}

int main()
{
	cin >> n;
	dfs(1);
	return 0;
}
```

## 递归实现组合型枚举

从 $1∼n$ 这 $n$ 个整数中随机选出 $m$ 个，输出所有可能的选择方案。

### 输入格式

两个整数 $n,m$ ,在同一行用空格隔开。

### 输出格式

按照从小到大的顺序输出所有方案，每行 $1$ 个。

首先，同一行内的数升序排列，相邻两个数用一个空格隔开。

其次，对于两个不同的行，对应下标的数一一比较，字典序较小的排在前面（例如 `1 3 5 7` 排在 `1 3 6 8` 前面）。

### 数据范围

$n>0$
$0≤m≤n$ ,
$n+(n−m)≤25$

### AC代码

```c++
#include <bits/stdc++.h>
using namespace std;

const int N = 50;
//bool st[N];
/*
	因为题目要求所有数递增
	所以不需要用 st 标记数的占用情况
	后边的数肯定是没被用过的
*/
int num[N];

int n, m;
// start 表示从 start 这个数开始枚举
void dfs(int u, int start)
{
	//  剪枝优化：当位数不够 m 时提前返回
	if(u - 1 + n - start + 1 < m) return;
	
	if(u > m)
	{
		for(int i = 1; i <= m; i++)
			cout << num[i] << ' ';
		cout << endl;
		return;
	}
	
	for(int i = start; i <= n; i++)
	{
		num[u] = i;
		// 下一位：u + 1
		// 下一开始数：i + 1 当前数加 1 保证递增
		dfs(u + 1, i + 1);
		num[u] = 0;
	}
}

int main()
{
	cin >> n >> m;
	
	dfs(1, 1);
	
	return 0;
}
```

#### 剪枝优化

在DFS中如果能有判断让DFS提前退出就能优化时间，他叫剪枝。此题中可以算出来，当start到n的个数+已经选择的个数<m个的时候就已经必然无解了就退出。`u-1+n-start+1<m` 。这样的一个优化算法，经过实验得出，能优化一半的时间。

## 带分数

#### 问题描述

$100$ 可以表示为带分数的形式：$100=3$+$\frac{69258}{714}$

还可以表示为：$100=82$+$3546$ / $197$

注意特征：带分数中，数字 $1∼9$ 分别出现且只出现一次（不包含 $0$）。

类似这样的带分数，$100$ 有 $11$ 种表示法。

#### 解题思路

1. 枚举  1~9 全排列
2. 用两个隔板把全排列成三部分a,b,c。
3. 把a,b,c区间数组分别转化成数。
4. 最后试算是否满足公式，满足加一。
5. 输出结果。

#### AC代码

```c++
#include<bits/stdc++.h>
using namespace std;

const int N = 20;

int n, cnt, num[N];
bool st[N];

int get(int l, int r)
{
	int res = 0;
	for(int i = l; i <= r; i++)
		res = res * 10 + num[i];
	return res;
}

void dfs(int u)
{
	if(u > 9)
	{
		for(int i = 1; i <= 7; i++)
		{
			for(int j = i + 1; j <= 8; j++)
			{
				int a, b, c;
				a = get(1, i);
				b= get(i + 1, j);
				c = get(j + 1, 9);
				
				if(n * c == a * c + b)
					cnt ++;
			}
		}
		return;
	}
	
	for(int i = 1; i <= 9; i++)
	{
		if(!st[i])
		{
			num[u] = i;
			st[i] = true;
			dfs(u + 1);
			st[i] = false;
		}
	}
 }
 
int main()
{
	cin >> n;
	
	dfs(1);
	
	cout << cnt;
	return 0;
```

## 求连通块数

### 算法标签

- DFS
- Flood Fill

### 算法模板

```cpp
#include<bits/stdc++.h>
using namespace std;

const int N = 1010;
char g[N][N];
const int dx[] = {-1, 0, 1, 0}, dy[] = {0, -1, 0, 1};
int n, m;

void dfs(int a, int b)
{
    g[a][b] = '.';
    
    for(int i = 0; i < 4; i++)
    {
        int x = a + dx[i], y = b + dy[i];
        if(x >= 0 && x < n && y >= 0 && y < m && g[x][y] == 'B')
            dfs(x, y);
	}
}

int main()
{
    cin >> n >> m;
    for(int i = 0; i < n; i++) scanf("%s", g[i]);
    
    for(int i = 0; i < n; i++)
        for(int j = 0; j < m; j++)
            if(g[i][j] == 'B')
            {
                cnt++;
                dfs(i, j);
			}
    
    cout << cnt;
    return 0;
}
```

## 正则问题

### 算法标签

- 递归
- DFS
- 二叉树

### 解题思路

- 把正则表达式转化为递归搜索树（二叉）

### 实现代码

```cpp
#include<bits/stdc++.h>
using namespace std;

int p;
string str;

int dfs()
{
    int res = 0;
    while(p < str.size())
    {
        // 遇到一个左括号 开始递归计算括号里
        if(str[p] == '(')
        {
            p++; // 跳过左括号
            res += dfs();
            p++; // 跳过右括号
        }
        else if(str[p] == ')')
        {
            break; // 遇到右括号 这层递归结束 
        }
        else if(str[p] == '|')
        {
            p++; // 跳过 '|'
            // '|' 左边是当前的 res
            // '|' 右边是下一层递归的值
            res = max(res, dfs());
        }
        else
        {
            // 遇到 'x' 个数自增
            p++;
            res++;
        }
    }
    // 遇到右括号或走到尽头返回此层递归
    return res;
}
int main()
{
    cin >> str;
    
    cout << dfs();

    return 0;
}
```

## 数字排列

```c++
#include<bits/stdc++.h>
using namespace std;
const int N=10;
int num[N],n;//存放数列
bool st[N];//表示数字是否被用过

void dfs(int u)
{
    if(u>n)
    {
        for(int i=1;i<=n;i++) cout<<num[i]<<' ';
        cout<<endl;
        return;
    }
	//空位上的数可以是1~n
    for(int i=1;i<=n;i++)
    {
        if(st[i]==false)//i没用过
        {
            num[u]=i;
            st[i]=true;
            dfs(u+1);
            st[i]=false;
        }
    }
}
int main()
{
    cin>>n;

    dfs(1);

    return 0;
}
```

## 有重数组的不重复的排序个数

**DFS＋剪枝优化**

这道题的难点其实在于如何得到有重复数字的数组的所有不重复全排列，如一个数组

```
[1, 1, 2]
设下标从1开始, 直接dfs+回溯枚举排列的话, 会有六种组合
```

`[]` 为一种排列,` ()`为它们的下标排列

```
[1, 1, 2] (1, 2, 3)
[1, 2, 1] (1, 3, 2)
[1, 1, 2] (2, 1, 3)
[1, 2, 1] (2, 3, 1)
[2, 1, 1] (3, 1, 2)
[2, 1, 1] (3, 2, 1)
```

但其实有三种都是重复的，那如何消除这种重复呢?
我们可以限制重复元素下标的顺序, 如对于重复元素, 下标小的一定要先出现
上例按照此规则, 下标1一定要在下标2的前面出现, 合法的有

```
[1, 1, 2] (1, 2, 3)
[1, 2, 1] (1, 3, 2)
[2, 1, 1] (3, 1, 2)
```

如何实现呢
我们可以将数组排个序, 这样重复元素就都聚集到了一起
这样我们就可以得到一个剪枝条件: 对于位置p, 如果nums[p-1] = nums[p], 并且p-1没有被使用, 则p也不能被使用

也就是说p能被使用的前提是, 与p的值重复并且位置比它前的元素已经被使用, 即下标小的重复元素一定要先使用

至于题目的要求, 同样可以看作是剪枝条件, 即当前元素一定要能与已形成序列的最后一个元素满足和为平方数。

```c++
#include<bits/stdc++.h>
using namespace std;
const int N=13;

int n,res;
int a[N];
bool st[N];

bool check(int r)
{
    int x=sqrt(r);
    if(x*x==r) return true;
    else return false;
}

int dfs(int u,int last)  //u当前第几个数 last上一个位数的大小
{
    if(u==n)
    {
        ans++;
    } 
    else
    {
        for(int i=0;i<n;i++)
        {
            if(st[i]) continue;  //这个位置的数被用过了
            if(i && !st[i-1] && a[i]==a[i-1])  continue//不是所在区间d'h
            if(!check(last+a[i])) continue;  //相邻元素不是完全平方数

            st[i]=true;
            dfs(u+1,a[i]);
            st[i]=false;
        }
    }
}
int main()
{
    cin>>n;
    for(int i=0;i<n;i++) cin>>a[i];
    sort(a,a+n);

    for(int i=0;i<n;i++)
    {
        if(i==0 || a[i]!=a[i-1])  //该位置数为所在区间第一个数
        {
            st[i]=true;
            dfs(1,w[i]);
            st[i]=false;
        }
    }

    cout<<ans;
    return 0;
}
```

## $n$ - 皇后问题

### 问题描述

n−皇后问题是指将 $n$ 个皇后放在 $n×n$ 的国际象棋棋盘上，使得皇后不能相互攻击到，即任意两个皇后都不能处于同一行、同一列或同一斜线上。

![1_597ec77c49-8-queens.png](https://cdn.acwing.com/media/article/image/2019/06/08/19_860e00c489-1_597ec77c49-8-queens.png)

现在给定整数 $n$，请你输出所有的满足条件的棋子摆法。

### 输入格式

共一行，包含整数 $n$。

### 输出格式

每个解决方案占 $n$ 行，每行输出一个长度为 $n$ 的字符串，用来表示完整的棋盘状态。

其中 `.` 表示某一个位置的方格状态为空，`Q` 表示某一个位置的方格上摆着皇后。

每个方案输出完成后，输出一个空行。

**注意：行末不能有多余空格。**

输出方案的顺序任意，只要不重复且没有遗漏即可。

### 数据范围

$1≤n≤9$

```c++
#include<bits/stdc++.h>
using namespace std;
const int N=20;
int n;
char g[N][N];//棋盘
bool col[N],dg[N],udg[N];//竖、正斜、反斜状态

void dfs(int u)
{
    if(u==n)
    {
        for(int i=0;i<n;i++) cout<<g[i]<<endl;
        cout<<endl;
        
        return;
    }
    //枚举列
    for(int i=0;i<n;i++)
    {
        if(!col[i] && !dg[u+i] && !udg[n-u+i])//竖、正斜、反斜都不能有皇后
        {
            g[u][i]='Q';//确定皇后
            col[i]=dg[u+i]=udg[n-u+i]=true;//标记
            dfs(u+1);//递归进入下一行
            col[i]=dg[u+i]=udg[n-u+i]=false;//恢复
            g[u][i]='.';
        }
    }
}

int main()
{
    cin>>n;
    
    for(int i=0;i<n;i++)
        for(int j=0;j<n;j++)
            g[i][j]='.';
    
    dfs(0);
    
    return 0;
}
```

## 大臣的旅费

### 题目描述



### 算法标签

- 树的直径
- DFS
- 

### 解题思路

> 同时，如果不重复经过大城市，从首都到达每个大城市的方案都是唯一的。

以上说明是一棵树，要求树的最大路径，称为**树的直径**。

第 $x$ 到 $x+ 1$这段路花费 $x + 10$ 路费，那么 $1$ 到 $x$ 总路费等于：

$f(x)=1 + 10 + 2 + 10+...+x + 10 = 10(1+2+3+...+x) = 10 \frac{(1+x)x}{2}$

1. 任取一点 $x$, 找到距离 $x$ 最远的点 $y$ ;
2. 重复步骤 1，找到距离 $y$ 最远的点 $z$ , $y$ 与 $z$ 之间的距离就是树的直径。

### 实现代码

```cpp
```

## 扫雷

### 算法标签

- 图的遍历
- DFS / BFS
- 哈希表

### 实现思路



### 实现代码

```cpp
```

