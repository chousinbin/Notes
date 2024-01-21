# DFS

深度优先搜索

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

