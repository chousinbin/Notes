# BFS

对于走迷宫问题，虽然可能有不同的走法，但是每走一步都进行一次判断是否到达终点，一旦有一个到达了终点，那么最先到达的就一定是路径最小的，这时我们直接返回距离（是最短的）。

## 走迷宫

### 实现代码

```cpp
#include<bits/stdc++.h>
using namespace std;

#define x first
#define y second

const int N = 110;

int g[N][N];
int d[N][N];
int n, m;

typedef pair<int, int> PII;
const int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};

int bfs()
{
    memset(d, -1, sizeof d);
    
    queue<PII> q;
    q.push({0, 0});
    d[0][0] = 0;
    
    while(q.size())
    {
        auto t = q.front();
        q.pop();
        
        for(int i = 0; i < 4; i++)
        {
            int a = t.x + dx[i], b = t.y + dy[i];
            if(a >= 0 && a < n && b >= 0 && b < m && g[a][b] == 0 && d[a][b] == -1)
            {
                d[a][b] = d[t.x][t.y] + 1;
                q.push({a, b});
            }
        }
    }
    return d[n - 1][m - 1];
}

int main()
{
    cin >> n >> m;
    for(int i = 0; i < n; i++)
        for(int j = 0; j < m; j++)
            cin >> g[i][j];
            
    cout << bfs();
    
    return 0;
}
```

### 打印路径

开一个prev[N]数组，存放当前点的前一个点的坐标

```cpp
//输出路径

    int x = n - 1, y = m - 1;

    while(x || y)
    {
        cout << x << ' ' << y << endl;

        pair t = prev[x][y];

        x = t.first, y = t.second;
    }
```

## 八数码

### 实现思路

- 二维图形转化为一维字符串
- `x` 的一维坐标转换为二维坐标
- 枚举当前状态 `x` 与四个方向交换

### 实现代码

```cpp
#include<bits/stdc++.h>
using namespace std;

int dx[] = {0, 1, 0, -1}, dy[] = {1, 0, -1, 0};

int bfs(string start)
{
    // 终点状态
    string end = "12345678x";
    
    queue<string> q; // 状态队列
    unordered_map<string, int> d; // 状态步数
    
    q.push(start);
    d[start] = 0;
    
    while(q.size())
    {
        auto t = q.front();
        q.pop();
        
        // 当前达到目标状态
        if(t == end) return d[t];
        
        // 当前移动次数
        int distance = d[t];
        
        // 一维坐标
        int k = t.find('x');
        // 二维坐标
        int x = k / 3, y = k % 3;
        
        for(int i = 0; i < 4; i++)
        {
            // 新的二维坐标
            int a = x + dx[i], b = y + dy[i];
            if(a >= 0 && a < 3 && b >= 0 && b < 3)
            {
                // 移动 x
                swap(t[a * 3 + b], t[k]);
                // 如果移动完是新的状态
                if(d.count(t) == 0)
                {
                    d[t] = distance + 1;
                    q.push(t); // 新的状态加入队列
                }
                // 恢复
                swap(t[a * 3 + b], t[k]);
            }
        }
    }
    return -1;
}

int main()
{
    string start;
    for(int i = 0; i < 9; i++)
    {
        char c;
        cin >> c;
        start += c;
    }
    
    cout << bfs(start);
    
    return 0;
}
```

## 全球变暖

### 算法标签

- BFS
- Flood Fill
- 连通块的个数

### 题目描述

你有一张某海域 $N×N$ 像素的照片，”.”表示海洋、”#”表示陆地，如下所示：

```
.......
.##....
.##....
....##.
..####.
...###.
.......
```

其中”上下左右”四个方向上连在一起的一片陆地组成一座岛屿，例如上图就有 $2$ 座岛屿。

由于全球变暖导致了海面上升，科学家预测未来几十年，岛屿边缘一个像素的范围会被海水淹没。

具体来说如果一块陆地像素与海洋相邻(上下左右四个相邻像素中有海洋)，它就会被淹没。

例如上图中的海域未来会变成如下样子：

```
.......
.......
.......
.......
....#..
.......
.......
```

请你计算：依照科学家的预测，照片中有多少岛屿会被完全淹没。

#### 输入格式

第一行包含一个整数 $N$。

以下 $N$ 行 $N$ 列，包含一个由字符”#”和”.”构成的 $N×N$ 字符矩阵，代表一张海域照片，”#”表示陆地，”.”表示海洋。

照片保证第 $1$ 行、第 $1$ 列、第 $N$ 行、第 $N$ 列的像素都是海洋。

#### 输出格式

一个整数表示答案。

#### 数据范围

$1≤N≤1000$

### 解题思路

- Flood Fill 就是在求连通块的个数（BFS / DFS）的基础上，统计联通块中，陆地的个数和边界元素的个数；
- 每统计完一个连通块，比较点的个数和边界点的个数，若不同，则此岛屿不会被淹没。

### 实现代码

```c++
#include<bits/stdc++.h>
using namespace std;

const int N = 1010;
typedef pair<int, int> PII;
const int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
#define x first
#define y second

char g[N][N];
bool st[N][N];
int n;

void bfs(int a, int b, int &total, int &bound)
{
    // 第一个点必然是陆地边界元素
    st[a][b] = true;
    total++, bound++;
    
    queue<PII> q;
    q.push({a, b});
    
    while(q.size())
    {
        auto t = q.front();
        q.pop();
        
        // 枚举当前元素的四周陆地元素
        for(int i = 0; i < 4; i++)
        {
            int x = t.x + dx[i], y = t.y + dy[i];
            if(x < 0 || x >= n || y < 0 || y >= n) continue;
            if(st[x][y]) continue;
            if(g[x][y] == '.') continue;
            // 标记和统计未被标记的元素
            st[x][y] = true;
            total++;
            // 判断当前元素是否为边界元素
            for(int j = 0; j < 4; j++)
            {
                int xx = x + dx[j], yy = y + dy[j];
                if(g[xx][yy] == '.')
                {
                    bound++;
                    break;
                }
            }
            // 加入到队列中
            q.push({x, y});
        }
    }
}

int main()
{
    cin >> n;
    for(int i = 0; i < n; i++) cin >> g[i];
    
    
    int res = 0;
    for(int i = 0; i < n; i++)
    {
        for(int j = 0; j < n; j++)
        {
            if(g[i][j] == '#' && !st[i][j])
            {
                int total = 0, bound = 0;
                bfs(i, j, total, bound);
                if(total == bound) res++;
            }
        }
    }
    
    cout << res;
    return 0;
}
```

## 母亲的牛奶

### 解题思路



### 实现代码

```cpp
#include<bits/stdc++.h>
using namespace std;

const int N = 21, M = N * N * N;

int A, B, C;

struct Stu
{
    int a, b, c;
}q[M];

bool st[N][N][N];

void bfs()
{
    // 记录三个杯子容量
    int W[3] = {A, B, C};
    
    int hh = 0, tt = 0;
    q[0] = {0, 0, C};
    st[0][0][C] = true;
    
    while(hh <= tt)
    {
        auto t = q[hh++];
        
        // 枚举所有倒法
        // 从 i 往 j 倒
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                if(i != j)
                {
                    // 提取原来的状态
                    int w[3] = {t.a, t.b, t.c};
                    // 倒满对方或全部倒出
                    int r = min(w[i], W[j] - w[j]);
                    w[i] -= r, w[j] += r;
                    // 判断并标记新状态
                    int a = w[0], b = w[1], c = w[2];
                    if(!st[a][b][c])
                    {
                        st[a][b][c] = true;
                        q[++tt] = {a, b, c};
                    }
                }
            }
        }
    }
}

int main()
{
    cin >> A >> B >> C;
    
    bfs();
    
    for(int c = 0; c <= C; c++)
    {
        for(int b = 0; b <= B; b++)
        {
            if(st[0][b][c]) cout << c << ' ';
        }
    }
    
    return 0;
}
```

## 扫雷

### 算法标签

- Blood Fill

### 实现思路

点击值为 0 的单元格，会递归打开所有相邻单元格，所以先求出 0 的连通块的个数。

再算未被打开的值为 1 - 8 的单元格个数。

### 实现代码

```cpp
#include<bits/stdc++.h>
using namespace std;

const int N = 310;

char g[N][N];
int w[N][N];
int n;

void dfs(int x, int y)
{
    int t = w[x][y];
    w[x][y] = -1;
    // 如果空位置周围是一个 1 - 8 停止递归
    if(t) return;
    
    for(int i = x - 1; i <= x + 1; i++)
        for(int j = y - 1; j <= y + 1; j++)
            // 递归 0 或 1 - 8 的单元格
            if(i >= 0 && i < n && j >= 0 && j < n && w[i][j] != -1)
                dfs(i, j);
}

int main()
{
    int T;
    cin >> T;
    
    for(int cases = 1; cases <= T; cases++)
    {
        cin >> n;
        for(int i = 0; i < n; i++) cin >> g[i];
        
        // 统计每个单元格的值
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(g[i][j] == '*') w[i][j] = -1;
                else
                {
                    w[i][j] = 0;
                    for(int x = i - 1; x <= i + 1; x++)
                        for(int y = j - 1; y <= j + 1; y++)
                            if(x >= 0 && x < n && y >= 0 && y < n && g[x][y] == '*')
                                w[i][j]++;
                }
            }
        }
        
        // 统计 0 连通块的数量
        int cnt = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(w[i][j] == 0)
                {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        
        // 统计其余点 1 - 8 的个数
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                if(w[i][j] != -1)
                    cnt++;
                    
        cout << "Case #" << cases << ": " << cnt << endl;
    }
    return 0;
}
```

## 献给阿尔及农的花束

现在研究员们想知道，如果阿尔吉侬足够聪明，它最少需要多少时间就能吃到奶酪。

迷宫用一个 $R×C$ 的字符矩阵来表示。

字符 $S$ 表示阿尔吉侬所在的位置，字符 $E$ 表示奶酪所在的位置，字符 # 表示墙壁，字符 . 表示可以通行。

阿尔吉侬在 $1$ 个单位时间内可以从当前的位置走到它上下左右四个方向上的任意一个位置，但不能走出地图边界。

#### 输入格式

第一行是一个正整数 $T$，表示一共有 $T$ 组数据。

每一组数据的第一行包含了两个用空格分开的正整数 $R$ 和 $C$，表示地图是一个 $R×C$ 的矩阵。

接下来的 $R$ 行描述了地图的具体内容，每一行包含了 $C$ 个字符。字符含义如题目描述中所述。保证有且仅有一个 $S$ 和 $E$。

#### 输出格式

对于每一组数据，输出阿尔吉侬吃到奶酪的最少单位时间。

若阿尔吉侬无法吃到奶酪，则输出“oop!”（只输出引号里面的内容，不输出引号）。

每组数据的输出结果占一行。

#### 数据范围

$1<T≤10$,
$2≤R,C≤200$

```c++
#include<bits/stdc++.h>
using namespace std;
const int N=210;
typedef pair<int,int> PII;
char g[N][N];  //地图
int n,m;
int dist[N][N];

int dfs(PII start,PII end)
{
    queue<PII> q;
    memset(dist,-1,sizeof dist);
    
    dist[start.first][start.second]=0;
    q.push(start);
    
    int dx[]={1,0,-1,0},dy[]={0,1,0,-1};
    
    while(q.size())
    {
        PII t=q.front();
        q.pop();
        
        for(int i=0;i<4;i++)
        {
            int x=t.first+dx[i],y=t.second+dy[i];
            if(x<0 || x>=n || y<0 || y>=m) continue;  //出界
            if(g[x][y]=='#') continue;  //障碍物
            if(dist[x][y]!=-1) continue;  //已经遍历过
            
            dist[x][y]=dist[t.first][t.second]+1;
            
            if(end==make_pair(x,y)) return dist[x][y];  //make_pair(x,y) 无需写出类别就能生成一个pair对象
            //相当于(end.first==x && end.second==y)
            
            q.push({x,y});
        }
    }
    return -1;
}

int main()
{
    int T;
    cin>>T;
    while(T--)
    {
        cin>>n>>m;
        for(int i=0;i<n;i++) scanf("%s",g[i]);  //整行读入字符串
        
        PII start,end;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
            	if(g[i][j]=='S') start={i,j};
        		else if(g[i][j]=='E') end={i,j};
        
        int t=dfs(start,end);
        if(t==-1) cout<<"oop!"<<endl;
        else cout<<t<<endl;
    }
    return 0;
}
```



## 交换瓶子

有 $N$ 个瓶子，编号 $1∼N$，放在架子上。

比如有 $5$ 个瓶子：

```
2 1 3 5 4
```

要求每次拿起 $2$ 个瓶子，交换它们的位置。

经过若干次后，使得瓶子的序号为：

```
1 2 3 4 5
```

对于这么简单的情况，显然，至少需要交换 $2$ 次就可以复位。

如果瓶子更多呢？你可以通过编程来解决。

#### 输入格式

第一行包含一个整数 $N$，表示瓶子数量。

第二行包含 $N$ 个整数，表示瓶子目前的排列状况。

#### 输出格式

输出一个正整数，表示至少交换多少次，才能完成排序。

#### 数据范围

$1≤N≤10000$,

#### 输入样例1：

```
5
3 1 2 5 4
```

#### 输出样例1：

```
3
```

#### 输入样例2：

```
5
5 4 3 2 1
```

#### 输出样例2：

```
2
```

### 暴力算法

```c++
#include<bits/stdc++.h>
using namespace std;
const int N=10010;
int b[N];
int main()
{
    int n,res=0;
    cin>>n;
    for(int i=1;i<=n;i++) cin>>b[i];
    
    for(int i=1;i<=n;i++)
    {
        if(i!=b[i])
        {
            for(int j=i+1;j<=n;j++)
            {
                if(b[j]==i)
                {
                    swap(b[i],b[j]);
                    res++;
                    break;
                }
            }
        }
    }
    cout<<res;
    return 0;
}
```

### 置换群算法

#### 环的建立

建立初始的环，环是由当前位置的 $a[i]$ 指向本该在的位置上的 $a[j]$ 。

#### 性质

1. 交换同一个环内的两个点，必然会由一个环变成两个环。
2. 交换不同环的两个点，两个环合成一个环。

#### 过程

为了重排序，排好后满足， $n$ 个指向自己的环，而乱序数列是 $k$ 个杂环，根据环的变换性质得出最小的步数就是 $n-k$。

#### 代码

```c++
#include<bits/stdc++.h>
using namespace std;
const int N=10010;
int a[N];
bool st[N];  //标记数组
int main()
{
    int n;
    cin>>n;
    for(int i=1;i<=n;i++) cin>>a[i];
    
    int res=0;  //记录环的个数
    for(int i=1;i<=n;i++)
    {
        if(!st[i])
        {
            res++;
            
            for(int j=i;!st[j];j=a[j]) //形成环！！！！！！！！！！！！！！！！！！！！！！！！！！
                st[j]=true;
        }
    }
    
    cout<<n-res;
    return 0;
}
```



## 红与黑 （FloodFill算法）

有一间长方形的房子，地上铺了红色、黑色两种颜色的正方形瓷砖。

你站在其中一块黑色的瓷砖上，只能向相邻（上下左右四个方向）的黑色瓷砖移动。

请写一个程序，计算你总共能够到达多少块黑色的瓷砖。

#### 输入格式

输入包括多个数据集合。

每个数据集合的第一行是两个整数 $W$ 和 $H$，分别表示 $x$ 方向和 $y$ 方向瓷砖的数量。

在接下来的 $H$ 行中，每行包括 $W$ 个字符。每个字符表示一块瓷砖的颜色，规则如下

1）‘.’：黑色的瓷砖；
2）‘#’：红色的瓷砖；
3）‘@’：黑色的瓷砖，并且你站在这块瓷砖上。该字符在每个数据集合中唯一出现一次。

当在一行中读入的是两个零时，表示输入结束。

#### 输出格式

对每个数据集合，分别输出一行，显示你从初始位置出发能到达的瓷砖数(记数时包括初始位置的瓷砖)。

#### 数据范围

$1≤W,H≤20$

#### BFS做法

```c++
#include<bits/stdc++.h>
using namespace std;
typedef pair<int,int> PII;
const int N=30;
char g[N][N];
int n,m;

int bfs(int a,int b)
{
    int res=1;
    queue<PII> q;
    q.push({a,b});
    g[a][b]='#';  //走过就改变
    
    int dx[]={1,0,-1,0},dy[]={0,1,0,-1};
    
    while(q.size())
    {
        PII t=q.front();
        q.pop();
        
        for(int i=0;i<4;i++)
        {
            int x=t.first+dx[i],y=t.second+dy[i];
            if(g[x][y]!='.' || x<0 || x>=n || y<0 || y>=m) continue;
            
            g[x][y]='#';  //走过就改变
            res++;
            
            q.push({x,y});
        }
    }
    return res;
}
int main()
{
    while(cin>>m>>n,n||m)
    {
        for(int i=0;i<n;i++)
            scanf("%s",g[i]);
        
        int a,b;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(g[i][j]=='@') a=i，b=j;
        
        cout<<bfs(a,b)<<endl;
    }
    return 0;
} 
```

#### DFS做法

````c++
#include<bits/stdc++.h>
using namespace std;
const int N=30;
char g[N][N];
int n,m;
bool st[N][N];
int dx[]={1,0,-1,0},dy[]={0,1,0,-1};
int dfs(int a,int b)
{
    int res=1;
    st[a][b]=true;
    
    for(int i=0;i<4;i++)
    {
        int x=a+dx[i],y=b+dy[i];
        
        if(x<0 || x>=n || y<0 || y>=m) continue;
        if(g[x][y]!='.') continue;
        if(st[x][y]) continue;
        
        res+=dfs(x,y);
    }
    return res;
}
int main()
{
    while(cin>>m>>n,n||m)
    {
        for(int i=0;i<n;i++) cin>>g[i];
        
        int a,b;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(g[i][j]=='@') a=i,b=j;
        
        memset(st,0,sizeof st);
        cout<<dfs(a,b);
    }
    return 0;
}
````



## 完全二叉树的权值

#### 知识点

完全二叉树与满二叉树。

```c++
#include<bits/stdc++.h>
using namespace std;
const int N=1e5+10;
int a[N];

int main()
{
    int n,cnt;
    long long res=-0x3f3f3f3f;
    cin>>n;
    for(int i=1;i<=n;i++) cin>>a[i];
    
    for(int d=1,i=1;i<=n;d++,i*=2)  //d为层数，i为每层第一个数的下标
    {
        long long s=0;
        for(int j=i;j-i<pow(2,d-1) && j<=n;j++)
        {
            s+=a[j];
        }
        if(s>res)
        {
            res=s;
            cnt=d;
        }
    }
    
    cout<<cnt;
    return 0;
}
```



## 地牢大师

三维版本的 $BFS$ 走迷宫问题。

#### 输入格式

输入包含多组测试数据。

每组数据第一行包含三个整数 $L,R,C$ 分别表示地牢层数，以及每一层地牢的行数和列数。

接下来是 $L$ 个 $R$ 行 $C$ 列的字符矩阵，用来表示每一层地牢的具体状况。

每个字符用来描述一个地牢单元的具体状况。

其中, 充满岩石障碍的单元格用”#”表示，不含障碍的空单元格用”.”表示，你的起始位置用”S”表示，终点用”E”表示。

每一个字符矩阵后面都会包含一个空行。

当输入一行为”0 0 0”时，表示输入终止。

#### 输出格式

每组数据输出一个结果，每个结果占一行。

如果能够逃脱地牢，则输出”Escaped in x minute(s).”，其中X为逃脱所需最短时间。

如果不能逃脱地牢，则输出”Trapped!”。

#### 数据范围

$1≤L,R,C≤100$

#### AC代码

```c++
#include<bits/stdc++.h>
using namespace std;
const int N=110;
char g[N][N][N];
int dist[N][N][N];
int n,m,b;
typedef pair<int,pair<int,int>> PII;

int dz[]={1,-1,0,0,0,0},dx[]={0,0,1,-1,0,0},dy[]={0,0,0,0,1,-1};
int bfs(PII start,PII end)
{
    queue<PII> q;
    q.push({start.first,{start.second.first,start.second.second}});
    memset(dist,-1,sizeof dist);
    dist[start.first][start.second.first][start.second.second]=0;
    
    while(q.size())
    {
        PII t=q.front();
        q.pop();

        for(int i=0;i<6;i++)
        {
            int z=t.first+dz[i],x=t.second.first+dx[i],y=t.second.second+dy[i];
            if(z<0 || z>=b || x<0 || x>=n || y<0 || y>=m) continue;
            if(g[z][x][y]=='#') continue;
            if(dist[z][x][y]!=-1) continue;

            dist[z][x][y]=dist[t.first][t.second.first][t.second.second]+1;

            if(z==end.first && x==end.second.first && y==end.second.second) return dist[z][x][y];
            q.push({z,{x,y}});
        }
    }
    return -1;
}
int main()
{
    PII start,end;
    while(cin>>b>>n>>m,b||m||n)
    {
        for(int i=0;i<b;i++)
        {
            for(int j=0;j<n;j++)
            {
                cin>>g[i][j];
            }
        }
        
        for(int i=0;i<b;i++)
        {
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<m;k++)
                {
                    if(g[i][j][k]=='S') start={i,{j,k}};
                    else if(g[i][j][k]=='E') end={i,{j,k}};
                }
            }
        }
        
        int t=bfs(start,end);
        if(t!=-1) cout<<"Escaped in "<<t<<" minute(s)."<<endl;
        else cout<<"Trapped!"<<endl;
    }
    return 0;
}
```



