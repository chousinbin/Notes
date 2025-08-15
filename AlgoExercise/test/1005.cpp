#include<bits/stdc++.h>
using namespace std;
int a[100000];//标记一下
int b[120];//存放输入的一串数 
bool cmp(int a,int b)
{
	return a>b;
}
int main()
{
	int n,k;
	cin>>k;
	for(int i=0;i<k;i++)
	{
		cin>>n;
		b[i]=n;
		while(n!=1)
		{
			if(n%2==0) n/=2;
			else n=3*n+1;
			a[n]=1;//不是原来的数 只要出现就标记一下 
		}
	}
	
	sort(b,b+k,cmp);
	int ret=1;
	for(int i=0;i<k;i++)
	{
		if(a[b[i]]==0) //如果输入的数 没出现过 是关键字 
		{
			if(ret==0) cout<<' '; 
			cout<<b[i];
			ret=0;
		}
	}
	return 0;
} 
