#include<bits/stdc++.h>
using namespace std;
const int N = 1e5 + 10, M = 2 * N;
int h[N], e[M], ne[M], idx; // 邻接表存树
// idx 结点的坐标
// h[i] 存储父结点 i 的子结点的头指针
// e[i] 存储结点 i 的值
// ne[i] 存储结点 i 的子结点的坐标
int n;
int ans = N; // 最小的最大连通块
bool st[N];  // 标记结点是否被访问过

// 头插法 邻接表
void add(int a, int b)
{
	// 创建子结点 b 保存值
	e[idx] = b;
	// 将子结点头插法到父结点后边
	ne[idx] = h[a];
	// 更新父结点头指针
	h[a] = idx++;
}
// 返回以 u 为根节点的树的大小
int dfs(int u)
{
	st[u] = true;
	int res = 0; // 记录以 u 为中心的连通块的最大值
	int sum = 1; // 包含当前 u
	// i 是结点的指针
	for(int i = h[u]; i != -1; i = ne[i])
	{
		int j = e[i]; // 取出当前子结点的值
		if(!st[j])
		{
			int s = dfs(j); // 求当前子结点为根的树的大小
			res = max(res, s);  // 更新最大值
			sum += s; // 更新结点数
		}
	}
	// 当前结点 u 的连通块除了子结点，还有 u 的父结点的其他子结点
	res = max(res, n - sum);
	// 更新最大联通块的最小值
	ans = min(ans, res);
	// 返回结点数
	return sum;
}

int main()
{
	// 初始化邻接表
	memset(h, -1, sizeof h);
	cin >> n;
	
	// 构造临接表存储树
	for(int i = 0; i < n - 1; i++)
	{
		int a, b;
		cin >> a >> b;
		// 无向边, 双向连接
		add(a, b), add(b, a);
	}
	
	// 任选一个结点 1 - n 开始遍历
	dfs(1);
	
	cout << ans;
	return 0;
}
