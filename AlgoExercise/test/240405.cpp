#include<bits/stdc++.h>
using namespace std;

const int N = 20;

int n, cnt, num[N];
bool st[N];

int get(int l, int r)
{
	int res = 0;
	for(int i = l; i <= r; i++)
		res = res * 10 + num[i];
	return res;
}

void dfs(int u)
{
	if(u > 9)
	{
		for(int i = 1; i <= 7; i++)
		{
			for(int j = i + 1; j <= 8; j++)
			{
				int a, b, c;
				a = get(1, i);
				b= get(i + 1, j);
				c = get(j + 1, 9);
				
				if(n * c == a * c + b)
					cnt ++;
			}
		}
		return;
	}
	
	for(int i = 1; i <= 9; i++)
	{
		if(!st[i])
		{
			num[u] = i;
			st[i] = true;
			dfs(u + 1);
			st[i] = false;
		}
	}
 }
 
int main()
{
	cin >> n;
	
	dfs(1);
	
	cout << cnt;
	return 0;
}
