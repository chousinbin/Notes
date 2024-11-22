#include<bits/stdc++.h>
using namespace std;

const int N = 2e6 + 10;
int a[N], s[N];
int n, m;

// 只要区间覆盖到了线段的中点，那么区间就包含了这个线段
int main()
{
    cin >> n >> m;
    for(int i = 1; i <= n; i++)
    {
        int l, r;
        cin >> l >> r;
        // 标记线段中点
        // 防止中点小数统一乘 2
        a[l + r]++;
    }

    for(int i = 1; i <= N; i++)
        s[i] = s[i - 1] + a[i];

    // 求某个区间的覆盖的线段数，就是区间内的中点数
    while(m--)
    {
        int l, r;
        cin >> l >> r;
        // 线段也同步乘 2
        cout << s[r * 2] - s[l * 2 - 1] << endl;
    }

    return 0;
}