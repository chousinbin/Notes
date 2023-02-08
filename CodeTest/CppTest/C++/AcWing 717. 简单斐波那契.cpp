#include<iostream>
using namespace std;
int main()
{
	int n;
	cin>>n;
	int a=0,b=1,c=0;
	for(int i=0;i<n;i++){
		 printf("%d ",a);
		 c=a+b;
		 a=b;
		 b=c;
	}
	return 0;
}
