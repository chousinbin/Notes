#include<bits/stdc++.h>
using namespace std;

const int N = 510;

int n, m;
int g[N][N]; // 邻接矩阵存图
int d[N]; // 记录 1 - i 点的最短距离
int st[N]; // 标记 1 - i 点是否已经最短

int dijkstra()
{
    memset(d, 0x3f, sizeof d);
    d[1] = 0;
    // 迭代 n 次，每次确定出一个到起点最短的点
    for(int i = 0; i < n; i++)
    {
        int t = -1;
        // 从未确认的点中挑选一个到起点最近的点
        for(int j = 1; j <= n; j++)
            if(st[j] == false && (t == -1 || d[j] < d[t]))
                t = j;
        // 得到一个新的到起点最短结点
        st[t] = true;
        // 引入新的最短点后 更新其他点到起点的距离
        for(int j = 1; j <= n; j++)
            d[j] = min(d[j], d[t] + g[t][j]);
    }
    return dist[n];
}
int main()
{
    cin >> n >> m;
	// memset 为每个字节初始化数值
    // 所以 int 类型的变量初始化最大值只需 0x3f
    // 0x3f 在算法竞赛中几乎可以称为最大的数，并且能保证加法不溢出
    memset(g, 0x3f, sizeof g);

    while(m--)
    {
        int a, b, c;
        cin >> a >> b >> c;
        // 存在重边
        g[a][b] = min(g[a][b], c);
    }

    int res = dijkstra();
    if(res == 0x3f3f3f3f) cout << -1;
    else cout << res;

    return 0;
}