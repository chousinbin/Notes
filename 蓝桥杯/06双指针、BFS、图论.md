# 双指针



## 日志统计

小明维护着一个程序员论坛。现在他收集了一份”点赞”日志，日志共有 $N$ 行。

其中每一行的格式是：

```
ts id  
```

表示在 $ts$ 时刻编号 $id$ 的帖子收到一个”赞”。

现在小明想统计有哪些帖子曾经是”热帖”。

如果一个帖子曾在任意一个长度为 $D$ 的时间段内收到不少于 $K$ 个赞，小明就认为这个帖子曾是”热帖”。

具体来说，如果存在某个时刻 TT 满足该帖在 $[T,T+D)$ 这段时间内(注意是左闭右开区间)收到不少于 $K$ 个赞，该帖就曾是”热帖”。

给定日志，请你帮助小明统计出所有曾是”热帖”的帖子编号。

#### 输入格式

第一行包含三个整数 $N,D,K$。

以下 $N$ 行每行一条日志，包含两个整数 $ts$ 和 $id$。

#### 输出格式

按从小到大的顺序输出热帖 $id$。

每个 $id$ 占一行。

#### 数据范围

$1≤K≤N≤10^5$
$0≤ts,id≤10^5$
$1≤D≤10000$

### AC代码

```c++
#include<bits/stdc++.h>
using namespace std;
typedef pair<int,int> PII;
const int N=100010;
int n,d,k;
PII logs[N];  //存储日志信息 时间和id
int cnt[N];  //记录当前时间段id的出现次数
bool st[N];  //记录某个i是否曾是热帖
int main()
{
    cin>>n>>d>>k;
    for(int i=0;i<n;i++) scanf("%d%d",&logs[i].first,&logs[i].second);
    
    sort(logs,logs+n);  //按照时间顺序排序二元组
    
    for(int i=0,j=0;i<n;i++)
    {
        int id=logs[i].second;
        cnt[id]++;
        
        while(logs[i].first - logs[j].first >= d)  //当长度为d的窗口左边越界
        {
            cnt[logs[j].second]--;  //越界的j对应的id的热度减一
            j++;  //向右走一步
        }
        
        if(cnt[id] >= k) st[id]=true;  //因为i是从始到终的 所以i对应的id都能被遍历 所以每次只需判断i(右端点)次数
    }
    
    for(int i=0;i<100000;i++)
        if(st[i])
            printf("%d\n",i);
    
    return 0;
}
```





# BFS

对于走迷宫问题，虽然可能有不同的走法，但是每走一步都进行一次判断是否到达终点，一旦有一个到达了终点，那么最先到达的就一定是路径最小的，这时我们直接返回距离（是最短的）。



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



## 全球变暖

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

第一行包含一个整数N。

以下 $N$ 行 $N$ 列，包含一个由字符”#”和”.”构成的 $N×N$ 字符矩阵，代表一张海域照片，”#”表示陆地，”.”表示海洋。

照片保证第 $1$ 行、第 $1$ 列、第 $N$ 行、第 $N$ 列的像素都是海洋。

#### 输出格式

一个整数表示答案。

#### 数据范围

$1≤N≤1000$

#### 输入样例1：

```
7
.......
.##....
.##....
....##.
..####.
...###.
.......
```

#### 输出样例1：

```
1
```

#### 解题思路

1. 双重循环遍历地图，找到一个陆地元素#后开始用 $FloodFill$ 算法标记当前陆地元素所在的岛屿的其他陆地元素，并统计出陆地元素数和边界陆地元素数。
2. 执行完一次 $FloodFill$ 就找完了一个岛屿，如果一个岛屿的陆地元素数和边界陆地元素数相等，那么就会被淹没。

```c++
#include<bits/stdc++.h>
using namespace std;
const int N=1010;
typedef pair<int,int> PII;
char g[N][N];
bool st[N][N];
int n;
void bfs(int x,int y,int &total,int &bound)
{
    queue <PII> q;
    q.push({x,y});
    st[x][y]=true;
    bound++,total++;  //第一个元素绝对是边界元素 
    
    int dx[]={1,0,-1,0},dy[]={0,1,0,-1};
    
    while(q.size())
    {
        PII t=q.front();
        q.pop();
        
        for(int i=0;i<4;i++)
        {
            int xx=t.first+dx[i],yy=t.second+dy[i];
            if(xx<0 || xx>=n || yy<0 || yy>=n) continue;
            if(st[xx][yy]) continue;
            if(g[xx][yy]=='.') continue;
            
            st[xx][yy]=true;
            total++;
            
            for(int i=0;i<4;i++)  //判断当前是否为边界元素
            {
                int xxx=xx+dx[i],yyy=yy+dy[i];
                if(g[xxx][yyy]=='.')
                {
                    bound++;
                    break;
                }
            }
            q.push({xx,yy});
        }
    }
}
int main()
{
    cin>>n;
    for(int i=0;i<n;i++) cin>>g[i];
    
    int res=0;  //被淹没的岛屿的数量
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            if(g[i][j]=='#' && st[i][j]==false)
            {
                int total=0,bound=0;
                bfs(i,j,total,bound);
                if(total==bound) res++;
            }
        }
    }
    
    cout<<res;
    return 0;
}
```



# 图论



## 大臣的旅费（树的直径）

很久以前，T王国空前繁荣。

为了更好地管理国家，王国修建了大量的快速路，用于连接首都和王国内的各大城市。

为节省经费，T国的大臣们经过思考，制定了一套优秀的修建方案，使得任何一个大城市都能从首都直接或者通过其他大城市间接到达。

同时，如果不重复经过大城市，从首都到达每个大城市的方案都是唯一的。

J是T国重要大臣，他巡查于各大城市之间，体察民情。

所以，从一个城市马不停蹄地到另一个城市成了J最常做的事情。

他有一个钱袋，用于存放往来城市间的路费。

聪明的J发现，如果不在某个城市停下来修整，在连续行进过程中，他所花的路费与他已走过的距离有关，在走第 $x$ 千米到第 $x+1$ 千米这 $1$ 千米中（ $x$ 是整数），他花费的路费是 $x+10$ 这么多。也就是说走 $1$ 千米花费 $11$ ，走 $2$ 千米要花费 $23$ 。

J大臣想知道：他从某一个城市出发，中间不休息，到达另一个城市，所有可能花费的路费中**最多**是多少呢？

#### 输入格式

输入的第一行包含一个整数 $n$，表示包括首都在内的T王国的城市数。

城市从 $1$ 开始依次编号，$1$ 号城市为首都。

接下来 $n−1$ 行，描述T国的高速路（T国的高速路一定是 $n−1$ 条）。

每行三个整数 $Pi,Qi,Di$，表示城市 $Pi$ 和城市 $Qi$ 之间有一条**双向**高速路，长度为 $Di$ 千米。

#### 输出格式

输出一个整数，表示大臣 $J$ 最多花费的路费是多少。

#### 数据范围

$1≤n≤10^5$,
$1≤Pi,Qi≤n$,
$1≤Di≤1000$

#### 解题思路

树的直径：一个树中两个相距最远的结点的距离。

1. 先任取一点 $x$ ，找到距离 $x$ 最远的点 $y$ ，此时 $y$ 就是两个相距最远的点的其中一个。
2. 再找到距离 $y$ 最远的 $z$ ，此时 $y$ 到 $z$ 的距离就是最远距离。

```c++
#include<bits/stdc++.h>
using namespace std;
const int N=1e5+10,M=2e5+10;
int h[N],e[M],ne[M],w[M],idx;
int dist[N],n;

void add(int a,int b,int c)
{
    e[idx]=b,w[idx]=c,ne[idx]=h[a],h[a]=idx++;
}

void dfs(int u,int fa,int dis)  //u为当前结点 fa为u的父结点的值 dis表示当前结点的距离
{
    dist[u]=dis;
    for(int i=h[u];i!=-1;i=ne[i])
    {
        if(e[i]!=fa)  //e[i]为下一个结点 e[i]不是之前走过的 
        {
            dfs(e[i],u,dis+w[i]);
        }
    }
}  //完成之后 得到 dist[N] 各个结点到u结点的距离

int main()
{
    cin>>n;
    memset(h,-1,sizeof h);

    for(int i=0;i<n-1;i++)
    {
        int a,b,c;
        scanf("%d%d%d",&a,&b,&c);
        add(a,b,c),add(b,a,c);  //双向
    }

    dfs(1,-1,0);  //1为任意取的一个结点 初始化到自己距离为0
    int u=1;
    for(int i=2;i<=n;i++)
        if(dist[i]>dist[u]) u=i;  //更新最远结点的城市id

    dfs(u,-1,0);
    for(int i=1;i<=n;i++)
        if(dist[i]>dist[u]) u=i;  //此时dist[u]等于树的直径

    cout<<(long long)dist[u]*10+(long long)dist[u]*(dist[u]+1)/2;  //公式不理解!!
    return 0;
}
```

