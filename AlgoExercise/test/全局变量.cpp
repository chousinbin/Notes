#include<stdio.h>
int count=0;

void a()
{
	count++;
}
void b()
{
	count++;
}
void c()
{
	count++;
}
void d()
{
	count++;
}
int main()
{
	a();
	b();
	c();
	d();
		
	printf("小甲鱼被爆了%d次\n",count);
    return 0;
}
