#include <bits/stdc++.h>
using namespace std;
// n + 2m = 3e5
const int N = 3e5 + 10;

typedef pair<int, int> PII;
int n, m;
int a[N]; // 原坐标离散后序列权值
int s[N]; // 原坐标离散后序列权值前缀和
vector<int> alls; // 存原坐标和查询区间端点的原坐标
vector<PII> add; // 存原坐标和要加的权值
vector<PII> query; // 存查询区间端点的原坐标
// 二分查找原坐标 x 的离散值
// 离散值是所有需要用到的原坐标递增排序后的连续的下标值
int find(int x)
{
    int l = 0, r = alls.size() - 1;
    while(l < r)
    {
        int mid = l + r >> 1;
        if(alls[mid] >= x) r = mid;
        else l = mid + 1;
    }
    return r + 1; // 前缀和的坐标需要从 1 开始
}

int main()
{
    cin >> n >> m;

    for(int i = 0; i < n; i++)
    {
        int x, c;
        cin >> x >> c;
        add.push_back({x, c});
        alls.push_back(x);
    }

    for(int i = 0; i < m; i++)
    {
        int l, r;
        cin >> l >> r;
        query.push_back({l, r});
        alls.push_back(l);
        alls.push_back(r);
    }
    // 排序
    sort(alls.begin(), alls.end());
    // 去重
    alls.erase(unique(alls.begin(), alls.end()), alls.end());
    // 完成加值
    for(int i = 0; i < add.size(); i++)
    {
        a[find(add[i].first)] += add[i].second;
    }
    // 处理前缀和
    for(int i = 1; i <= alls.size(); i++)
    {
        s[i] = s[i - 1] + a[i];
    }
    // 处理查询
    for(int i = 0; i < query.size(); i++)
    {
        int l, r;
        l = find(query[i].first);
        r = find(query[i].second);
        cout << s[r] - s[l - 1] << endl;
    }
    return 0;
}
