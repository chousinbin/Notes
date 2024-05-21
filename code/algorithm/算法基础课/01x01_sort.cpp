#include<bits/stdc++.h>
using namespace std;

const int N = 1e6 + 10;
int q[N];

//快速排序
void quick_sort(int q[], int l, int r)
{
    if(l >= r) return;  //退出条件
    int i = l - 1, j = r + 1;  //指针作用
    int x = q[l + r >> 1];  //x为本组数中随机确定的一个分界点, 为其他数对比作参数
    while(i < j) {  //指针未走到一起
        do i ++; while(q[i] < x);
        do j --; while(q[j] > x);
        /*
        上面i和j指针指向两个分别不符合大小的数
        再判断一遍是否指针未越界, 进行交换
        */
        if(i < j) swap(q[i], q[j]);
    }
    quick_sort(q, l, j), quick_sort(q, j + 1, r);
}
int main()
{
    int n;
    scanf("%d", &n);
    for(int i = 0; i < n; i ++) scanf("%d", &q[i]);
    quick_sort(q, 0, n - 1);
    for(int i = 0; i < n; i ++) printf("%d ", q[i]);
    
    return 0;
}