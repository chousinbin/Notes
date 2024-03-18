#include<bits/stdc++.h>
using namespace std;

const int N = 1e5 + 10;
int len, n;
int p[N], s[N], b[N];

typedef long long LL;

typedef pair<int, int> PII;


bool check(int mid)
{
    vector<PII> a, b;
    for(int i = 0; i < n; i++)
    {
        // 此时阀门打开，存储覆盖区间
        if(mid >= s[i])
        {
            int l = max(1, p[i] - (mid - s[i]));
            int r = min((LL)len, (LL)p[i] + (mid - s[i]));
            a.push_back({l, r});
        }
    }
    
    //区间合并
    sort(a.begin(), a.end());
    int begin = -1, end = -1;
    for(int i = 0; i < a.size(); i++)
    {
        // 当前区间与下一区间无交集
        if(end + 1 < a[i].first)
        {
            begin = a[i].first;
            end = a[i].second;
        }
        else
        {
            end = max(end, a[i].second);
        }
    }
    return begin == 1 && end == len;
}

int main()
{
    cin >> n >> len;
    for(int i = 0; i < n; i++) cin >> p[i] >> s[i];
    
    int l = 0, r = 2e9;
    while(l < r)
    {
        LL mid = (LL)l + r >> 1;
        if(check(mid)) r = mid;
        else l = mid + 1;
    }
    
    cout << r;
    return 0;
}