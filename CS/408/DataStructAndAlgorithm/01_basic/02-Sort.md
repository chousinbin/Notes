# 	排序

## 对比

| 名称     | 时间复杂度           | 稳定性 |
| -------- | -------------------- | ------ |
| 选择排序 | $O(n^2)$             | 不稳定 |
| 冒泡排序 | $O(n^2)$             | 稳定   |
| 插入排序 | $O(n^2)$             | 稳定   |
| 计数排序 | $O(n + k)$           | 稳定   |
| 基数排序 | $O(n * k)$           | 稳定   |
| 快速排序 | $O(n log n)$         | 不稳定 |
| 归并排序 | $O(n log n)$         | 稳定   |
| 堆排序   | $O(n log n)$         | 不稳定 |
| 桶排序   | $O(n + k)$           | 稳定   |
| 希尔排序 | 取决于间隔序列的选择 | 不稳定 |

## 快速排序

### 快排模板

#### 思路

1. 确定分界点，左边界 / 右边界 / 中间
2. 调整区间，左半边为小于等于 x 的，右半边为大于等于 x 的
3. 递归处理左右两端

#### 用途

面试手写

算法竞赛多直接用 $sort$

#### AC代码

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

#### 为什么不能q[i] <= x 或 q[j] >= x

当选取的`x`为一个序列里面最大或最小的时候, 指针`i`或`j`一直符合其条件, 导致指针越界才停下.

#### 为什么临界值不能是下标

因为临界值的选取是原数组中间下标对应的值，并不能保证值的大小是理想情况为整个数组的中位数，所以有些情况下中间索引对应的值会被swap到别的位置，这样就不能保证一次递归中，`l + r >> 1` 的值是固定的了，所以不能使用 `x = l + r >>1` ，需要使用 `x = a[l + r >> 1]` 

### sort函数

```cpp
sort(begin, end);
// 注意：end 指向尾元素下一位置的指针
```

### comp() + sort() 

当需要对多重元素排序时，可以使用结构体 + 自定义compare()函数 + sort()进行排序

```cpp
struct Stu
{
    int a, b, c;
}s[1000];

bool cmp(Stu x, Stu y)
{
    if(x.a != y.a) return x.a < y.a;
    if (x.b != y.b) return x.b < y.b;
    return x.c < y.c;
}

int main()
{
    sort(s, s + 1000, cmp);
}
```

### 快速选择排序

#### 题目描述

给定一串数字，求第 $k$ 小的数。

#### AC代码

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

## 归并排序

### 归并模板

#### 思路

1. 确定分界点 mid=q[(l+r)/2]
2. 递归排序 left right
3. 归并：合二为一

#### AC代码

```c++
#include <bits/stdc++.h>
using namespace std;

const int N = 1e5 + 10;
int q[N], tmp[N];

void merge_sort(int q[], int l, int r)
{
    if(l >= r) return;
    
    int mid  = l + r >> 1;
    // 递归处理
    merge_sort(q, l, mid), merge_sort(q, mid + 1, r);
    
    int k = 0, i = l, j = mid + 1;
    while(i <= mid && j <= r)
        if(q[i] <= q[j]) tmp[k++] = q[i++];
        else tmp[k++] = q[j++];
    // 收尾
    while(i <= mid) tmp[k++] = q[i++];
    while(j <= r) tmp[k++] = q[j++];
    // 每次递归区间为 [l, r]; tmp从 0 开始，需要两个指针
    for(int i = l, j = 0; i <= r; i++, j++) q[i] = tmp[j];
}

int main()
{
    int n;
    cin >> n;
    for(int i = 0; i < n; i++) cin >> q[i];
    
    merge_sort(q, 0, n - 1);
    
    for(int i = 0; i < n; i++) cout << q[i] << ' ';
    
    return 0;
}
```

### 归并求逆序对

#### 题目描述

给定一个长度为 $n$ 的整数数列，请你计算数列中的逆序对的数量。

逆序对的定义如下：对于数列的第 $i$ 个和第 $j$ 个元素，如果满足 $i<j$ 且 $a[i]>a[j]$ ，则其为一个逆序对；否则不是。

#### 输入格式

第一行包含整数 $n$，表示数列的长度。

第二行包含 $n$ 个整数，表示整个数列。

#### 输出格式

输出一个整数，表示逆序对的个数。

#### 数据范围

$1≤n≤100000$
数列中的元素的取值范围 $[1, 10^9]$

#### 解题思路

1. 逆序对所在位置分为：左区间、右区间、左右各一；
2. 其中左区间和右区间两种情况可以通过递归分解为左右各一的形式；
3. 所以只需考虑左右各一的情况；
4. 因为归并是先递归的，所以当前所在区间的左右区间都是单调递增的；
5. 那么，当左指针指向的值大于右指针指向的值时，从左指针开始的所有左区间的值都大于右指针指向的值；
6. 所以，此时左区间中大于右指针指向的值的个数为：`mid - i + 1`
7. 需要考虑逆序对的数量超出 `int` 范围。

#### AC代码

```c++
#include <bits/stdc++.h>
using namespace std;

const int N = 1e5 + 10;
int q[N], tmp[N];

long long merge_sort(int q[], int l, int r)
{
    if(l >= r) return 0;
    
    int mid = l + r >> 1;
    // max_num = 5 * 10 ^ 9, int will overflow
    long long res = merge_sort(q, l, mid) + merge_sort(q, mid + 1, r);
    
    int k = 0, i = l, j = mid + 1;
    while(i <= mid && j <= r)
        if(q[i] <= q[j]) tmp[k++] = q[i++];
        else
        {
            tmp[k++] = q[j++];
            /*
            	左右两边的序列都是单调递增的
            	如果 q[i] > q[j]
            	说明 q[i, mid] > q[j]
            	所以 左边大于 q[j] 的有 mid - 1 + 1 个
            */
            res += mid - i + 1;
        }
    while(i <= mid) tmp[k++] = q[i++];
    while(j <= r) tmp[k++] = q[j++];
    
    for(int i = l, j = 0; i <= r; i++, j++) q[i] = tmp[j];
    
    return res;
}

int main()
{
    int n;
    cin >> n;
    
    for(int i = 0; i < n; i++) cin >> q[i];
    
    cout << merge_sort(q, 0, n - 1);
    
    return 0;
}
```

### 超快速排序

限制条件：每次交换相邻两个元素的位置，使得原数组升序。

解题思路：每次交换完恰好使得逆序对数量减少一个 ==> 逆序对的数量 = 最小交换次数。

