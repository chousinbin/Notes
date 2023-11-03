#include<stdio.h>
void fun(); 
int a,b=520;
void fun()
{
	int b;
	a=880;
	b=120;
	printf("in funs a=%d b=%d",a,b);
}
int mian()
{
	printf("%d %d",a,b);
	fun();
	printf("%d %d",a,b);
	return 0;
}
