#include<stdio.h>
int main()
{
	int sum=0;
	int x,y;
	int i=1;
	
	for(i=1;i<=10;i++)
	{
		x*=i;
		sum+=x;
		printf("%d\n",x);
	}
	printf("%d",sum);
	return 0;
}
