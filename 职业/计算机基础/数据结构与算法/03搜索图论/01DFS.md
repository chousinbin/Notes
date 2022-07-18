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

