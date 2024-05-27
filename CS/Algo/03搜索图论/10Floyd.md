# Floyd

> 多源最短路

## Floyd 求最短路

### 实现代码

```cpp
#include<bits/stdc++.h>
using namespace std;

const int N = 210, INF = 1e9;
int n, m, Q;
int d[N][N];

void floyd()
{
    for(int k = 1; k <= n; k++)
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++)
                d[i][j] = min(d[i][j], d[i][k] + d[k][j]);
}

int main()
{
    cin >> n >> m >> Q;

    // 存在自环
    for(int i = 1; i <= n; i++)
        for(int j = 1; j <= n; j++)
            if(i == j) d[i][j] = 0;
            else d[i][j] = INF;

    while(m--)
    {
        int a, b, w;
        cin >> a >> b >> w;
        // 存在重边
        d[a][b] = min(d[a][b], w);
    }

    floyd();

    while(Q--)
    {
        int a, b;
        cin >> a >> b;
        // 边权可能为负数
        if(d[a][b] > INF / 2) puts("impossible");
        else cout << d[a][b] << endl;
    }

    return 0;
}
```

