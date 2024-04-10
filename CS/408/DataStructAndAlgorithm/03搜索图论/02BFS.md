# BFS

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

