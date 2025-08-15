#include <bits/stdc++.h>
using namespace std;

#define x first
#define y second

const int N = 60;
int n, m;
char g[N][N];

const int dx[] = {-1, 0, 1, 0}, dy[] = {0, 1, 0, -1};
typedef pair<int, int> PII;
vector<PII> points[2];

void dfs(int a, int b, vector<PII> &q)
{
	q.push_back({a, b});
	g[a][b] = '.';
	
	for(int i = 0; i < 4; i++)
	{
		int x = a + dx[i], y = b + dy[i];
		if(x >= 0 && x < n && y >= 0 && y < m && g[x][y] == 'X')
			dfs(x, y, q);
	}
}

int main()
{
	cin >> n >> m;
	for(int i = 0; i < n; i++) scanf("%s", g[i]);
		
	int k = 0;
	for(int i = 0; i < n; i++)
		for(int j = 0; j < m; j++)
			if(g[i][j] == 'X') 
				dfs(i, j, points[k++]);
	/*
		遇到第一个 'X' 就去 DFS 直到第一块全变为 '.'
		保证两个 points 中分别存储 2 个斑块的点
	*/
	
	int res = 110;
	for(auto& a : points[0])
		for(auto& b : points[1])
			res = min(res, abs(a.x - b.x) + abs(a.y - b.y));
	
	cout << res - 1;
	return 0;
}
