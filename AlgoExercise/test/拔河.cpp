#include<bits/stdc++.h>
using namespace std;

const int N = 1010;
typedef long long LL;
int n;
LL a[N];

 
int main()
{
	cin >> n;
	for(int i = 1; i <= n; i++)
	{
		cin >> a[i];
		a[i] += a[i - 1];
	}
	
	LL res = 0x3f3f3f;
	for(int i = 1; i <= n - 1; i++)
	{
		for(int j = i; j <= n - 1; j++)
		{
			for(int k = j + 1; k <= n; k++)
			{
				for(int l = k; l <= n; l++)
				{
					LL s1 = a[j] - a[i - 1];
					LL s2 = a[l] - a[k - 1];
					res = min(res, abs(s1 - s2));
				}
			}
		}
	}
	
	cout << res;
	return 0;
}
