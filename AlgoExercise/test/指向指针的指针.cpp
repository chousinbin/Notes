#include<stdio.h>
int main()
{
	int num=5;
	int *p=&num;
	int **r=&p;
	printf(" *p=%d\n",*p);
	printf("  p=%p\n",p);
	printf(" *r=%p\n",*r);
	printf("**r=%d\n",**r);
	return 0;
}
