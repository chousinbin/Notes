#include<bits/stdc++.h>
using namespace std;
int main ()
{
	int n;
	cin>>n;
	int a[n][4],sum3=0;
	for(int i=0;i<n;i++)
	{
		cin>>a[i][0]>>a[i][1]>>a[i][2];
		a[i][3]=a[i][0]+a[i][1]+a[i][2];
	}
	for(int j=0;j<n;j++)
	{
		for(int k=j+1;k<n;k++)
		{
			int ret=0;
			for(int i=0;i<3;i++)
			{
				if(a[j][i]-a[k][i]<=5 || a[j][i]-a[k][i]>=-5) ret++;
			}
			if(ret=3 && (a[j][3]-a[k][3]<=10 || a[j][3]-a[k][3]>=-10)) sum3++;
		}
	}
	cout<<sum3;
	return 0;
}
