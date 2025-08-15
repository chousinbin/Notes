#include <bits/stdc++.h>
using namespace std;

const int N = 110;

int a[N], b[N], c[N];
int spend[N]; // 标记第 i 个鱼塘已经钓了几次

// 求当前 x 号鱼塘，下一杆能钓获多少鱼
int get(int x)
{
    return max(0, a[x] - b[x] * spend[x]);
}

// 求在 1 - n 个鱼塘，钓 t 次的总鱼获
// 函数内是不考虑切换鱼塘的时间成本
// 找到固定时间内，每个鱼塘钓几次总鱼获最多，得到最优方案
// 而实际过程，可以根据最优方案，充分垂钓完每个鱼塘，一次性走到 n 号鱼塘
int fish(int n, int t)
{
    int res = 0;
    memset(spend, 0, sizeof spend);
    
    // debug
    // t 有可能是负值，单纯 t-- 不加上整数限定，导致 TLE
    // 所以 for 更安全，保证参数
    while(t-- && t)
    {
        // 表示当前几个鱼塘中，下一杆钓的最多的鱼塘的下标
        int p = 1;
        for(int i = 2; i <= n; i++)
            if(get(p) < get(i))
                p = i;
        // 加上这一鱼塘这一杆的鱼获        
        res += get(p);
        // 这个鱼塘所钓的次数加一
        spend[p]++;
    }
    return res;
}

int main()
{
    int n;
    cin >> n;

    for(int i = 1; i <= n; i++) cin >> a[i];
    for(int i = 1; i <= n; i++) cin >> b[i];
    for(int i = 2; i <= n; i++)
    {
        cin >> c[i];
        // 顺便前缀和，c[i] 表示第 1 到 i 鱼塘所需路程时间之和
        c[i] += c[i - 1];
    }
    int t;
    cin >> t;
    
    // 枚举在 1 到 i 鱼塘之间垂钓
    int res = 0;
    for(int i = 1; i <= n; i++)
        res = max(res, fish(i, t - c[i]));
        
    cout << res;
    return 0;
}