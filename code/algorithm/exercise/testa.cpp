#include<iostream>
using namespace std;
int main()
{
	int n,a,b,c,d,e,f;
	int sum1,sum2,sum3,ret;
	cin>>n>>a>>b>>c>>d>>e>>f;
	if(n%a) sum1=(n/a+1)*b; else sum1=n/a*b;
	if(n%c) sum2=(n/c+1)*d; else sum2=n/c*d;
	if(n%e) sum3=(n/e+1)*f; else sum3=n/e*f;
	if(sum1<sum2&&sum1<sum3) ret=sum1;
	if(sum2<sum1&&sum2<sum3) ret=sum2;
	if(sum3<sum1&&sum3<sum2) ret=sum3;
	cout<<ret;
	
	return 0;
}
