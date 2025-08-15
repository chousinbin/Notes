#include<stdio.h>
#include<string.h>
int main()
{
	char A[10]="abcd";
	char B[10]="efgh";
	strncat(A,B,3);//第三个元素限制拷贝的字符数 
	printf("%s",A);
	return 0;
}
