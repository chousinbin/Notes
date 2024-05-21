#include<stdio.h>
int main()
{
	int *ar;//声明指向int类型的指针 
	int x=3;
	ar=&x;//把x变量的地址传给指针ar 
	printf("%d\n",*ar);//打印指针ar指向的地址的值 
	
	char *str="hello";
    printf("%s\n",str); 
	
	return 0; 
 } 
