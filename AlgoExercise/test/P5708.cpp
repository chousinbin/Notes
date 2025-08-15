#include<stdio.h>
int main()
{
	int a,b,n=-1;
	scanf("%d %d",&a,&b);
	double money,x;
	money=(float)a+0.1*b;
	for(x=1.9;money>=0;n++)
	{
		money-=1.9;
	}
	printf("%d\n",n);
	return 0;
}
