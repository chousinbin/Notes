#include<bits/stdc++.h>
using namespace std;

const int N = 510, INF = 0x3f3f3f3f;

int n, m;
int g[N][N]; // 存储结点路径信息
int dist[N]; // 表示第 i 个结点到连通部分最短距离
bool st[N]; // 表示第 i 个结点是否已经是最小生成树的一部分

int prim()
{
    memset(dist, 0x3f, sizeof dist);
    
    int res = 0; // 最小路径权值
    // n 次迭代
    for(int i = 0; i < n; i++)
    {
        // 找出未通车的结点中到已通车部分最近的结点
        int t = -1;
        for(int j = 1; j <= n; j++)
            if(!st[j] && (t == -1 || dist[t] > dist[j]))
                t = j;
        // 非首结点 并且 找完一圈没找到能与已通车部分相连的结点 => 不能连通     
        if(i && dist[t] == INF) return INF;
        // 非首结点 把结点到连通部分的最短距离累加
        if(i) res += dist[t];
        // 标记已经连通
        st[t] = true;
        // 用已联通的新结点更新其他结点到连通块的距离
        for(int j = 1; j <= n; j++)
            dist[j] = min(dist[j], g[t][j]);
    }
    return res;
}

int main()
{
    cin >> n >> m;
    
    memset(g, 0x3f, sizeof g);
    
    while(m--)
    {
        int a, b, c;
        cin >> a >> b >> c;
        // 无向图
        g[a][b] = g[b][a] = min(g[a][b], c);
    }
    
    int res = prim();
    if(res == INF) puts("impossible");
    else cout << res;
    
    return 0;
}