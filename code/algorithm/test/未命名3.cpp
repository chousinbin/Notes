#include<stdio.h>
void sum(int a,int b)
{
	int i;
	int sum=0;
	for(i=a,a<=b,i++)
	{
		sum+=i;
		printf("%d to %d is %d\n",a,b,sum);
	}
}	
int main()
{
	sum(int a,int b)
	sum(1,9);
	sum(10,100);
	return 0;
}
