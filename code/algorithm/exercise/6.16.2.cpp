#include<stdio.h>
#include<windows.h>
int main()
{
	int i,n;
	for(i=1;i<=5;i++)
	{
		n=i;
		while(n>0)
		{
			n--;
			printf("$");
		} 
		printf("\n");
	}
	system("pause");
	return 0;
} 
