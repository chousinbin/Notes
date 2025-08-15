#include<bits/stdc++.h>
using namespace std;
int fun(long,long);
int main()
{
	long a,b,c,ret;
	cin>>a>>b>>c;
	if(a>b) swap(a,b);
	if(a>c) swap(a,c);
	if(b>c) swap(b,c);
	ret=fun(a,c);
	cout<<a/ret<<'/'<<c/ret;
	return 0;
} 
int fun(long a,long c)
{
	long ret;
	for(int i=a;i>=1;i--)
	{
		if(a%i==0 && c%i==0)
		{
			ret=i;
			break;	
		}
		ret=1;
	}
	return ret;
}
