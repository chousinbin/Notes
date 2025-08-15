#include<bits/stdc++.h>
using namespace std;
bool space[30][30][30];
int main()
{
	int a,b,c,q,sum=0,x1,x2,y1,y2,z1,z2;
	cin>>a>>b>>c>>q;
	
	while(q--)
	{
		cin>>x1>>y1>>z1>>x2>>y2>>z2;
		for(int i=x1;i<=x2;++i)
		{
			for(int j=y1;j<=y2;++j)
			{
				for(int k=z1;k<=z2;++k)
				{
					space[i][j][k]=1;	
				}
			}
		}			
	}
	
	for(int i=0;i<a;++i)
	{
		for(int j=0;j<b;++j)
		{
			for(int k=0;k<c;++k)
			{
				if(space[i][j][k]==0)
				{
					sum++;
				}
			}
		}
	}
	
	cout<<sum;
	return 0;
}
