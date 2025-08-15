#include<stdio.h>
int main()
{
	int i,n;
	char ch='A';
	for(i=1;i<=6;i++)
	{
		for(n=i;n>0;n--,ch++)
		{
			printf("%c",ch);
		}
		printf("\n");
	}
	return 0;
}
