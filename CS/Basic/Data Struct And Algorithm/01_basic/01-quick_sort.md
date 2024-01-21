# 	快速排序

## 快速排序

### 分治思想

1. 确定分界点，左边界 / 右边界 / 中间
2. 调整区间，左半边为小于等于 x 的，右半边为大于等于 x 的
3. 递归处理左右两端

### 用途

面试手写

算法竞赛多直接用 $sort$

### 模板

```c++
#include <bits/stdc++.h>
using namespace std;

const int N = 1e5 + 10;
int q[N];

void quick_sort(int q[], int l, int r)
{
    if(l >= r) return;
    
    int i = l - 1, j = r + 1;
    int x = q[l + r >> 1];
    
    while(i < j)
    {  
        do i++; while(q[i] < x);
        do j--; while(q[j] > x);
        // 上面停止之后，如果两个指针未越界，说明当前指针所指的两个值是相反的
        if(i < j) swap(q[i], q[j]);
    }
    
    quick_sort(q, l, j), quick_sort(q, j + 1, r);
}

int main()
{
    int n;
    scanf("%d", &n);
    for(int i = 0; i < n; i++) scanf("%d", &q[i]);
    
    quick_sort(q, 0, n - 1);
    for(int i = 0; i < n; i++) printf("%d ", q[i]);
    
    return 0;
}
```

### 问题

#### 为什么不能q[i] <= x 或 q[j] >= x

当选取的`x`为一个序列里面最大或最小的时候, 指针`i`或`j`一直符合其条件, 导致指针越界才停下.

#### 为什么临界值不能是下标

因为临界值的选取是原数组中间下标对应的值，并不能保证值的大小是理想情况为整个数组的中位数，所以有些情况下中间索引对应的值会被swap到别的位置，这样就不能保证一次递归中，`l + r >> 1` 的值是固定的了，所以不能使用 `x = l + r >>1` ，需要使用 `x = a[l + r >> 1]` 

## 快速选择排序

### 题目描述

给定一串数字，求第 $k$ 小的数。

### AC代码

```c++
#include <bits/stdc++.h>
using namespace std;

const int N = 1e5 + 10;
int q[N];

void quick_sort(int q[], int l, int r, int k)
{
    if(l >= r) return;
    
    int x = q[l + r >> 1];
    int i = l - 1, j = r + 1;
    
    while(i < j)
    {
        do i++; while(q[i] < x);
        do j--; while(q[j] > x);
        if(i < j) swap(q[i], q[j]);
    }
    
    int cnt_left = j - l + 1;
    if(k <= cnt_left) quick_sort(q, l, j, k);
    else quick_sort(q, j + 1, r, k - cnt_left);
}
int main()
{
    int n, k;
    cin >> n >> k;
    for(int i = 0; i < n; i++) cin >> q[i];
    quick_sort(q, 0, n - 1, k);
    cout << q[k - 1];
    return 0;
}
```

