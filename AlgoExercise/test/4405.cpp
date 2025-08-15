#include<bits/stdc++.h>
using namespace std;

const int N = 510;
int a[N][N], s[N][N];

int main()
{
    int n, m, k;
    cin >> n >> m >> k;

    for(int i = 1; i <= n; i++)
        for(int j = 1; j <= m; j++)
            cin >> a[i][j];
    
    for(int i = 1; i <= n; i++)
        for(int j = 1; j <= m; j++)
            s[i][j] = s[i - 1][j] + s[i][j -1] - s[i - 1][j - 1] + a[i][j];

    long long cnt = 0;

    // i 和 j 枚举左右边界
    for(int i = 1; i <= m; i++)
    {
        for(int j = i; j <= m; j++)
        {
            // t 是上边界, d 是下边界
            // 遍历下边界
            for(int t = 1, d = 1; d <= n; d++)
            {
                int sum = s[d][j] - s[t - 1][j] - s[d][i - 1] + s[t - 1][i - 1];
                // 推进上指针
                // 只要区间和大于 k，向下推进上边界
                while(t <= d && sum > k)
                {
                    t++;
                    // 更新区间和
                    sum = s[d][j] - s[t - 1][j] - s[d][i - 1] + s[t - 1][i - 1];
                }
                // 如果推进完区间合法就加上以下边界为底的区间数
                if(t <= d) cnt += d - t + 1;
            }
        }
    }

    cout << cnt;
    return 0;
}