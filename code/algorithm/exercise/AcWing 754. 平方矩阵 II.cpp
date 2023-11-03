#include <iostream>
#include <algorithm>
using namespace std;
int main()
{
	int n;
	while(cin>>n&&n>0)
	{ 
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				cout<<abs(i-j)+1<<' ';//重要规律 
			}
			cout<<endl;
		}
		cout<<endl;
	}
	return 0;
}
