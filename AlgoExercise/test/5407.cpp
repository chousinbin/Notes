#include<bits/stdc++.h>
#define x first
#define y second

using namespace std;

const int N = 1e5 + 10;

typedef pair<int, int> PII;
typedef long long LL;

PII w[N];
int n, len;

// 检查这一时刻能否灌满
bool check(int t)
{
    vector<PII> a;
    // 收集区间
    for(int i = 0; i < n; i++)
    {
        if(t >= w[i].y)
        {
            int l = max(1, w[i].x - (t - w[i].y));
            int r = min((LL)len, (LL)w[i].x + (t - w[i].y));
            a.push_back({l, r});
        }
    }
    // 排序
    sort(a.begin(), a.end());
    // 合并区间
    int l = -1, r = -1;
    for(int i = 0; i < a.size(); i++)
    {
        // 注意边界，离散的点要 + 1
        if(r + 1 < a[i].x) l = a[i].x, r = a[i].y;
        else r = max(r, a[i].y);
    }
    
    return r == len && l == 1;
}

int main()
{
    cin >> n >> len;
    
    for(int i = 0; i < n; i++)
        cin >> w[i].x >> w[i].y;
        
    int l = 0, r = 2e9;
    while(l < r)
    {
        // 注意左右都要用 LL
        // T 死我了 ... 2024-4-4 20:52:08
        LL mid = (LL)l + r >> 1;
        if(check(mid)) r = mid;
        else l = mid + 1;
    }
    
    cout << r;
    return 0;
}