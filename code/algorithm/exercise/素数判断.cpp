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
			break; //��ת һ�������㲻������������ ��ֱ�ӽ��� ����һֱ�ظ�forѭ�� 
		}
	}
	
	if(isprime==0)
	{
		printf("��������\n");
	}
	else
	{
		printf("ta������\n");
	}
	
	return 0; 
}

