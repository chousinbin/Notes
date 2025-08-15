#include<bits/stdc++.h>
using namespace std;

const int N = 2e5 + 10;

int n, m;
int e[N], w[N], ne[N], h[N], idx;
int d[N];
bool st[N];

typedef pair<int, int> PII;

void add(int a, int b, int c)
{
    e[idx] = b;
    w[idx] = c;
    ne[idx] = h[a];
    h[a] = idx++;
}

int dijkstra()
{
    memset(d, 0x3f, sizeof d);
    d[1] = 0;
    /*
        小根堆：自动递增排序，队头元素总是最小的
        对于多元素数据类型，按照多元素的第一个元素递增
        所以要把距离存到 first 结点编号存到 second
    */
    priority_queue<PII, vector<PII>, greater<PII>> heap;
    heap.push({0, 1});

    while(heap.size())
    {
        auto t = heap.top();
        heap.pop();

        int p = t.second, distence = t.first;

        if(st[p]) continue;
        st[p] = true;

        for(int i = h[p]; i != -1; i = ne[i])
        {
            // t 的子结点的编号
            int j = e[i];
            if(d[j] > d[p] + w[i])
            {
                d[j] = d[p] + w[i];
                // 优先队列不能修改值，只能把更新的值插入到优先队列中
                heap.push({d[j], j});
            }
        }
    }

    return d[n];
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

    int res = dijkstra();
    if(res == 0x3f3f3f3f) cout << -1;
    else cout << res;
    
    return 0;
}