#include<stdio.h>
int main()
{
	int num=5;
	int *p=&num;
	int **r=&p;
	
	printf("  p=%p\n",p);//指针p为num=5的地址 
	printf(" *p=%d\n",*p);// *p为指向num=5的指针 
	printf(" *r=%p\n",*r);//r 为指针p的地址 、*r为指向指针p的内容储存的num=5的地址 
	printf("**r=%d\n",**r);//**r指向指针p p指向num=5 
	return 0;
}
