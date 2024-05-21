#include <bits/stdc++.h>
using namespace std;

const int N = 50;
//bool st[N];
/*
	因为题目要求所有数递增
	所以不需要用 st 标记数的占用情况
	后边的数肯定是没被用过的
*/
int num[N];

int n, m;
// start 表示从 start 这个数开始枚举
void dfs(int u, int start)
{
	//  剪枝优化：当位数不够 m 时提前返回
	if(u - 1 + n - start + 1 < m) return;
	
	if(u > m)
	{
		for(int i = 1; i <= m; i++)
			cout << num[i] << ' ';
		cout << endl;
		return;
	}
	
	for(int i = start; i <= n; i++)
	{
		num[u] = i;
		// 下一位：u + 1
		// 下一开始数：i + 1 当前数加 1 保证递增
		dfs(u + 1, i + 1);
		num[u] = 0;
	}
}

int main()
{
	cin >> n >> m;
	
	dfs(1, 1);
	
	return 0;
}
