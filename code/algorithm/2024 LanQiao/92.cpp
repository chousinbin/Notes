#include<bits/stdc++.h>
using namespace std;

const int N = 20;

int n;
bool is_selected[N];

// u 表示当前枚举第几个数
void dfs(int u)
{
	if(u > n)
	{
		for(int i = 1; i <= n; i++)
			if(is_selected[i] == true) 
				cout << i << ' ';
		
		cout << endl;
		return;
	}
	
	// 不选
	is_selected[u] = false;
	dfs(u + 1);
	// 选
	is_selected[u] = true;
	dfs(u + 1);
}
int main()
{
	cin >> n;
	
	dfs(1);
	
	return 0;
}
