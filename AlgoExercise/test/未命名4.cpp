#include<stdio.h>
int main()
{
	unsigned long long n,a;
	scanf("%lld",&n);
	a=(n*(n-1)*(n-2)*(n-3))/24;
	printf("%lld\n",a);
	return 0;
}
