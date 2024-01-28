#include <bits/stdc++.h>
using namespace std;

int main()
{
	int q;
	cin >> q;
	
	while(q--)
	{
		int n = 0;
		
		for(int i = 31; i >= 0; i--)
		{
			int x;
			cin >> x;
			n = (n << 1) + x;
		}
		
		int a = n + 1, b = n + 3;
		
		for(int i = 31; i >= 0; i--)
		{
			cout << (a >> i & 1);
		}
		cout << endl;
		for(int i = 31; i >= 0; i--)
		{
			cout << (b >> i & 1);
		}
		cout << endl;
	}
	return 0;
}
