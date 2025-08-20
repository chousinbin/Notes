#include<iostream>
#include<algorithm>
using namespace std;
int main()
{
	int a;
	cin>>a;
	int sx=a/2,sy=a/2;
	for(int i=0;i<a;i++)
	{
		for(int j=0;j<a;j++)
		{
			if((abs(sx-i)+abs(sy-j))<=a/2) cout<<'*';
			else cout <<' ';
		}
		cout<<endl;
	}
	return 0;;
}
