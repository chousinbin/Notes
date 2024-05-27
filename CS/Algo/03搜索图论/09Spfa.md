# Spfa

## Spfa 求最短路

### 时间复杂度

$O(n) - O(nm)$

### 实现思路

- Bellman - Ford 算法每次迭代，试图更新所有边，显然每次迭代并不能使所有结点到起点的距离变短；
- Spfa 只拿到起点距离变短的结点。更新后面的结点，这样能保证后边的结点到起点的距离变短。

动态逼近法：设立一个先进先出的队列用来保存待优化的结点，优化时每次取出队首结点 t，并且用 t 点当前的最短路径估计值对离开 t 点所指向的结点 j 进行松弛操作，如果 j 点的最短路径估计值有所调整，且 j 点不在当前的队列中，就将 j 点放入队尾。这样不断从队列中取出结点来进行松弛操作，直至队列空为止。

### 实现代码

```cpp
#include<bits/stdc++.h>
using namespace std;

const int N = 1e5 + 10;

int n, m;
int h[N], e[N], w[N], ne[N], idx;
int dist[N];
bool st[N];

void add(int a, int b, int c)
{
    e[idx] = b, w[idx] = c, ne[idx] = h[a], h[a] = idx++;
}

int spfa()
{
    memset(dist, 0x3f, sizeof dist);
    dist[1] = 0;

    queue<int> q;
    q.push(1);
    st[1] = true; // 标记结点在队列中

    while(q.size())
    {
        int t = q.front();
        q.pop();
        st[t] = false;

        for(int i = h[t]; i != -1; i = ne[i])
        {
            int j = e[i];
            if(dist[j] > dist[t] + w[i])
            {
                dist[j] = dist[t] + w[i];
                if(st[j] == false)
                {
                    q.push(j);
                    st[j] = true;
                }
            }
        }
    }

    return dist[n];
}

int main()
{
    cin >> n >> m;
    memset(h, -1, sizeof h);

    while(m--)
    {
        int a, b, c;
        cin >> a >> b >> c;
        add(a, b ,c);
    }

    int res = spfa();

    if(res == 0x3f3f3f3f) puts("impossible");
    else cout << res;

    return 0;
}
```

## Spfa 判断负环

### 实现思路

用一个数组计算每个点到起点经过的边数，如果边数 >= 图中点的个数 n ，说明点数 >= n + 1，则一定存在负环。

### 实现代码

```cpp
#include<bits/stdc++.h>
using namespace std;

const int N = 1e5 + 10;
int n, m;
int h[N], e[N], w[N], ne[N], idx;
int dist[N], cnt[N];
bool st[N];

void add(int a, int b, int c)
{
    e[idx] = b, w[idx] = c, ne[idx] = h[a], h[a] = idx++;
}

bool spfa()
{
    memset(dist, 0x3f, sizeof dist);
    dist[1] = 0;

    queue<int> q;
    // 把所有点都加到队列中
    // 从 1 开始的可能没有负环
    for(int i = 1; i <= n; i++)
    {
        q.push(i);
        st[i] = true;
    }

    while(q.size())
    {
        int t = q.front();
        q.pop();
        st[t] = false;

        for(int i = h[t]; i != -1; i = ne[i])
        {
            int j = e[i];
            if(dist[j] > dist[t] + w[i])
            {
                dist[j] = dist[t] + w[i];
                cnt[j] = cnt[t] + 1; // 更新边数
                if(cnt[j] >= n) return true;
                if(st[j] == false)
                {
                    q.push(j);
                    st[j] = true;
                }
            }
        }
    }
    return false;
}

int main()
{
    cin >> n >> m;
    memset(h, -1, sizeof h);

    while(m--)
    {
        int a, b, c;
        cin >> a >> b >> c;
        add(a, b, c);
    }

    bool res = spfa();
    if(res) puts("Yes");
    else puts("No");

    return 0;
}
```
