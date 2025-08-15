#include <bits/stdc++.h>
using namespace std;

const int N = 20;

bool st[N];
int num[N];
int n;

void dfs(int u)
{
	if(u > n)
	{
		for(int i = 1; i <= n; i++)
			cout << num[i] << ' ';
		cout << endl;
		return;
	}
	// 从小到大枚举 1 - n
	// 保证答案顺序按字典序递增
	for(int i = 1; i <= n; i++)
	{
		if(st[i] == false)
		{
			st[i] = true;
			num[u] = i;
			dfs(u + 1);
			st[i] = false;
		}
	}
}

int main()
{
	cin >> n;
	dfs(1);
	return 0;
}
