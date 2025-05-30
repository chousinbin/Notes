# KMP算法

> 一个人能走的多远不在于他在顺境时能走的多快，而在于他在逆境时多久能找到曾经的自己（公共前后缀）。
>

### 问题描述

给定一个模式串 $S$，以及一个模板串 $P$，所有字符串中只包含大小写英文字母以及阿拉伯数字。

模板串 $P$ 在模式串 $S$ 中多次作为子串出现。

求出模板串 $P$ 在模式串 $S$ 中所有出现的位置的起始下标。

#### 输入格式

第一行输入整数 $N$，表示字符串 $P$ 的长度。

第二行输入字符串 $P$。

第三行输入整数 $M$，表示字符串 $S$ 的长度。

第四行输入字符串 $S$。

#### 输出格式

共一行，输出所有出现位置的起始下标（下标从 $0$ 开始计数），整数之间用空格隔开。

#### 数据范围

$1≤N≤10$^5^
$1≤M≤10$^6^

### 算法思想

- 为子串构造一个**部分匹配表**，表的值表示从子串开头到子串之后任一元素这部分字符串中最长公共前后缀的长度，用于部分匹配时伸缩，当子串在代码中从 1 开始存储时，表的值也是最长公共前后缀的前缀的尾下标。
- 当匹配中断时，可以向部分匹配表中查询部分匹配的子串的最长公共前后缀的前缀的尾下标。
- 重新从前缀下一元素与主串待匹配的元素与进行比较。

![image-20240224005839066](https://cdn.jsdelivr.net/gh/chousinbin/Image/202402240058135.png)

### 解题代码

```c++
#include <bits/stdc++.h>
using namespace std;

const int N = 1e5 + 10, M = 1e6 + 10;

int n, m;
char part[N], s[M];
// ne 数组存储以 i 结尾的子串，最长公共前后缀的前缀尾下标
int ne[N];

int main()
{
	cin >> n >> part + 1 >> m >> s + 1;
	// 构造 ne 数组(ne[1] == 默认 0，从 2 开始)
	// j 是前缀指针也是公共前后缀的长度， i 是后缀指针
	for(int i = 2, j = 0; i <= n; i++)
	{
		// 前缀和后缀进行比较，如果不是公共的，一直缩短匹配长度
		// 直到前缀退回原点
		while(j > 0 && part[i] != part[j + 1]) j = ne[j];
		// 如果直接或退回之后匹配成功，公共长度加 1
		if(part[i] == part[j + 1]) j++;
		// 以 i 结尾的子串的最长公共前后缀的前缀的尾下标 j
		ne[i] = j;
	}
	// KMP 匹配过程
	for(int i = 1, j = 0; i <= m; i++)
	{
		// 子串部分匹配成功，j 循环向前移动再与 i 比较（伸缩）
		// 直到退回原点 0
		while(j > 0 && part[j + 1] != s[i]) j = ne[j];
		// 元素匹配成功
		if(part[j + 1] == s[i]) j++;
		// 子串匹配成功
		if(j == n)
		{
			cout << i - n << ' ';
			// 为匹配下一个后移 j 指针
			j = ne[j];
		}
	}
	return 0;
}
```

### 参考文章

[阮一峰：字符串匹配的KMP算法](https://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html)
