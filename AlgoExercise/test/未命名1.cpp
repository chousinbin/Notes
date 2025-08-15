#include<stdio.h>
int main()
{
	int x,i;
	const int number=10;//����Ĵ�С 
	int count[number];  //�������� 
	for(i=0;i<number;i++)//�����ʼ�� 
	{
		count[i]=0;

	}
	scanf("%d",&x);
	while(x!=-1)
	{
		if(x>=0|x<=9)//����������� 
		{
			count[x]++;
		}
		scanf("%d",&x);
		
	}
	for(i=0;i<number;i++)//���������� 
	printf("%d:%d\n",i,count[i]);
	return 0;
}
