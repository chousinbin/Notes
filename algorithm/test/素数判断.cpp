#include<stdio.h>
int main()
{
	int x,i;
	scanf("%d",&x);
	int isprime=1;
	
	for(i=2;i<x;i++)
	{
		if(x%i==0)
		{
			isprime=0;
			break; //跳转 一旦能满足不是素数的条件 就直接结束 不再一直重复for循环 
		}
	}
	
	if(isprime==0)
	{
		printf("不是素数\n");
	}
	else
	{
		printf("ta是素数\n");
	}
	
	return 0; 
}

