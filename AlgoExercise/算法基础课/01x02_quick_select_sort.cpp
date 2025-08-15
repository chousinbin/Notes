#include<bits/stdc++.h>
using namespace std;
const int N = 1e6 + 10;
int q[N];

int quick_select_sort(int l, int r, int k)
{
    if(l >= r) return q[l];
    int x = q[l + r >> 1];
    int i = l - 1, j = r + 1;
    while(i < j)
    {
        do i ++; while(q[i] < x);
        do j --; while(q[j] > x);
        if(i < j) swap(q[i], q[j]);
    }
    int sl = j - l + 1;
    if(k <= sl) return quick_select_sort(l, j, k);
    else return quick_select_sort(j + 1, r, k - sl);
}

int main()
{
    int n, k;
    scanf("%d%d", &n, &k);
    for(int i = 0; i < n; i ++) scanf("%d", &q[i]);
    cout << quick_select_sort(0, n - 1, k);
    return 0;
}
