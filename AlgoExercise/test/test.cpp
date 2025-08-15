#include <iostream>
#include <math.h>
int str[110][110];
using namespace std;
int main()
{
	int n,m,i=1,j=1,sum=1;
	str[1][1]=1;
	cin>>n>>m;

	while(sum<n*m)
	{
		while(++j<=m&& !str[i][j])
		{
			str[i][j]=++sum;
		}
		j--;
		while(++i<=n&& !str[i][j])
		{
			str[i][j]=++sum;
		}
		i--;
		while(--j>=1&& !str[i][j])
		{
			str[i][j]=++sum;
		}
		j++;
		while(--i>=1&& !str[i][j])
		{
			str[i][j]=++sum;
		}
		i++;
	}
	
	for(int i=1;i<=n;i++)
	{
		for(int j=1;j<=m;j++)
		{
			cout<<str[i][j]<<' ';
		}
		cout<<endl;
	}
	
	return 0;
}
