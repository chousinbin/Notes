#include<stdio.h>
int main()//ָ������ 
{
	int a=1;
	int b=2,c=3,d=4,e=5;
	int *str[5]={&a,&b,&c,&d,&e};
	
	char *sor[5]={
	"a","abc","abcd","abcde","abcdef"
	};//��仰�ǵ�ַ 
	
	for(int i=0;i<5;i++)
	{
		printf("%d\n",*str[i]);
	}
	printf("******************\n");
	for(int i=0;i<5;i++)
	{
		printf("%s\n",sor[i]);
	}


	return 0;
}

