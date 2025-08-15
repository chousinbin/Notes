#include<stdio.h>
int main()
{
	int m,n;
	scanf("%d %d",&m,&n);
	while(m<=n)
	{
		printf("%d %d %d\n",m,m*m,m*m*m);
		m++;
	}
	return 0;
}
