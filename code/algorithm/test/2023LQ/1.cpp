#include<bits/stdc++.h>
using namespace std;

int get(int a, int b)
{
	int l = 1, r = 1e9 + 1;  //?????????¦¶??b=0???v>1e9 
	while(l < r)
	{
		int mid = l + r >> 1;
		if(a / mid <= b) r = mid;
		else l = mid + 1; 
	}
	return l;
}
int main()
{
	int n;
	cin>>n;
	int v_min = 1, v_max = 1e9;
	while(n --)
	{
		int a, b;
		cin >> a >> b;
		v_min = max(v_min, get(a, b));
		v_max = min(v_max, get(a, b - 1) - 1);
	}
	cout << v_min << ' ' << v_max;
	return 0;
}
