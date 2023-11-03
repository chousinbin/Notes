#include<bits/stdc++.h>
//双指针  AcWing771 字符串中最长连续的数 
using namespace std;
int main()
{
	int n;
	cin>>n;
	char b;
	while(n--)
	{
		string a;
		cin>>a;
		int cnt=0;
		for(int i=0;i<a.size();i++)
		{
			int j=i;
			while(a[i]==a[j] && j<a.size()) j++;
			if(j-i>cnt) cnt=j-i,b=a[i];
			i=j-1;
		}
		cout<<b<<' '<<cnt<<endl;
	}
	return 0;
} 
