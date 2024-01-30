# 区间合并

- 按区间左端点排序
- 扫描整个区间，把所有可能有交集的区间进行合并

## 区间合并

### 题目描述

给定 $n$ 个区间$ [li,ri]$，要求合并所有有交集的区间。

注意如果在端点处相交，也算有交集。

输出合并完成后的区间个数。

例如：$[1,3]$和 $[2,6]$可以合并为一个区间 $[1,6]$。

### 输入格式

第一行包含整数 $n$。

接下来 $n$ 行，每行包含两个整数 $l$ 和 $r$。

### 输出格式

共一行，包含一个整数，表示合并区间完成后的区间个数。

### 数据范围

$1≤n≤100000$
$−10^9≤ li≤ri ≤10^9$

### 输入样例

```
5
1 2
2 4
5 6
7 8
7 9
```

### 输出样例

```
3
```

### AC代码

```c++
#include <bits/stdc++.h>
using namespace std;

const int N = 1e5 + 10;
typedef pair<int, int> PII;
vector<PII> a;
vector<PII> b; // 合并后的区间

int main()
{
	int n;
	cin >> n;
	
	for(int i = 0; i < n; i++)
	{
		int l, r;
		cin >> l >> r;
		a.push_back({l, r});
	}
    // 按左端点排序
	sort(a.begin(), a.end());

	// 表示当前区间
	int begin = -2e9, end = -2e9;
	for(int i = 0; i < a.size(); i++)
	{
		// 当前区间和下一个区间没有交集
		if(end < a[i].first)
		{
			// 如果不是起始边界，把当前区间存起来
			if(begin != -2e9)
			{
				b.push_back({begin, end});
			}
			// 更新当前区间为下一个区间
			begin = a[i].first;
			end = a[i].second;
		}
		else // 当前区间与下一区间合并
		{
			end = max(end, a[i].second);
		}
	}
	// 处理最后一个区间
	b.push_back({begin, end});
	cout << b.size();
	return 0;
}
```

