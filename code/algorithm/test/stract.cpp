#include<stdio.h>
#include<string.h>
int main()
{
	char A[10]="abcd";
	char B[10]="efgh";
	strncat(A,B,3);//������Ԫ�����ƿ������ַ��� 
	printf("%s",A);
	return 0;
}
