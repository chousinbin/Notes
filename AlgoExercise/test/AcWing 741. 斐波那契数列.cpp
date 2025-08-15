#include<iostream>
using namespace std;
int main()
{
	int t,n;
	cin>>t;
	for(int i=0;i<t;i++)
	{
		int a=0,b=1,c=0;
		cin>>n;
		for(int j=0;j<=n;j++)
		{	
			if(j==n) printf("Fib(%d) = %d\n",n,a);
		 	c=a+b;
		 	a=b;
		 	b=c;
		}
	}
	
	return 0;
}
