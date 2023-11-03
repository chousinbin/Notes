#include<stdio.h>
int main()
{
	int ac[]={0,1,2,3,4,5,-1};
	int *p=ac;
	while(*p!=-1)
	{
		printf("%d ",*p++);
	} 
	printf("\n");
	for(int i=0;i<sizeof(ac)/sizeof(ac[0]);i++)
	{
		printf("%d ",ac[i]);
	}
	return 0;
}
