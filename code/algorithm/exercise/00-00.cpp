#include <bits/stdc++.h>
using namespace std;

const int N = 1e5 + 10;
int a[N];
int b[N];

int main()
{
    int n, m;
    cin >> n >> m;
    for(int i = 0; i < n; i++) cin >> a[i];
    for(int i = 0; i < m; i++) cin >> b[i];

    /*
        遍历主串，
        当子指针与主指针数值相同时，子指针右移
        遍历完主串，看子指针是否遍历完子串
    */
    int j = 0;
    for(int i = 0; i < m; i++)
    {
        if(b[i] == a[j] && j < n) j++;
    }

    if(j == n) cout << "Yes";
    else cout << "No";
    return 0;
}