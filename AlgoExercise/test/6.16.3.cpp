#include<stdio.h>
int main()
{
	int i,n;
	char ch;
	for(i=1;i<=6;i++)
	{
		ch='F';
		for(n=i;n>0;n--,ch--)
		{
			printf("%c",ch);
		}
		printf("\n");
	}
	return 0;
}
