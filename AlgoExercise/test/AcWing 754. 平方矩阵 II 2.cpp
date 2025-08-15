#include <iostream>
#include <algorithm>
using namespace std;
int main()
{
	int n,a[110][110];
	while(cin>>n&&n>0)
	{
		for(int i=1;i<=n;i++)
		{
			for(int j=i,k=1;j<=n;j++,k++)
			{
				a[i][j]=k;
				a[j][i]=k;
			}
		}
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
				cout<<a[i][j]<<' ';
			cout<<endl;
		}
		cout<<endl;
	}
	
	return 0;
}
