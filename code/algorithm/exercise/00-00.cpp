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