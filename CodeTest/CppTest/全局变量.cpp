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
		
	printf("С���㱻����%d��\n",count);
    return 0;
}
