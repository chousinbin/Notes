#include<stdio.h>
int main()
{
	int a,b,c,d;
	scanf("%d %d %d %d",&a,&b,&c,&d);
	int hour,min;
	hour=c-a;
	min=d-b;
	if(min<0)
	{
		hour--;
		min+=60;
	}
	printf("%d %d\n",hour,min);
	return 0;
 } 
