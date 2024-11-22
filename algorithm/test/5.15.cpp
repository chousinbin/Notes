#include<stdio.h>
void sb(int n);
int main(void)
{
	int times=5;
	char ch='!';
	float f=6.0;
	
	sb(times);
	sb(ch);
	sb(f);
	
	return 0;
}

void sb(int n)
{
	while(n-->0)
		printf("#");
	printf("\n");
}
