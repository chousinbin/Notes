#include<stdio.h>
int main()
{
	int *ar;//����ָ��int���͵�ָ�� 
	int x=3;
	ar=&x;//��x�����ĵ�ַ����ָ��ar 
	printf("%d\n",*ar);//��ӡָ��arָ��ĵ�ַ��ֵ 
	
	char *str="hello";
    printf("%s\n",str); 
	
	return 0; 
 } 
