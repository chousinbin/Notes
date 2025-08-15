#include<bits/stdc++.h>
using namespace std;

const int N = 510, M = 10010;
int n, m, k;
int dist[N], last[N];

struct Str{
    int a, b, w;
}edge[M];

void bellman_ford()
{
    memset(dist, 0x3f, sizeof dist);
    dist[1] = 0;
    // k 次限制
    for(int i = 0; i < k; i++)
    {
        // 使用上一次的距离更新这一次，防止过度更新
        memcpy(last, dist, sizeof dist);

        for(int j = 0; j < m; j++)
        {
            auto e = edge[j];
            dist[e.b] = min(dist[e.b], last[e.a] + e.w);
        }
    }
}

int main()
{
    cin >> n >> m >> k;
    
    for(int i = 0; i < m; i++)
    {
        int a, b, w;
        cin >> a >> b >> w;
        edge[i] = {a, b, w};
    }

    bellman_ford();
    
    // 存在负权边：无法到达的点的距离会变小
    if(dist[n] > 0x3f3f3f3f / 2) puts("impossible");
    else cout << dist[n];

    return 0;
}