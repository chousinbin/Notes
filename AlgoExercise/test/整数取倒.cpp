#include<stdio.h>
int main()
{
	int x;
	int y;
	int z=0;
	scanf("%d",&x);
	while(x>0)
	{
		y=x%10;
		z=z*10+y;
		printf("%d",y);
		x/=10;
	}
	return 0;
 } 
 	
