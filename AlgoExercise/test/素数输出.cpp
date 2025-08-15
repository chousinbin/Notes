#include<stdio.h>
int main()
{
	int x ;
	int cnt = 1;
	x = 2;
	while (cnt <=50)
	{
		int i;
		int isprime = 1;//ÊÇËØÊı
		for (i = 2; i < x; i++)
		{
			if (x % i == 0)
			{
				isprime = 0;
				break;
			}
		}


		if (isprime == 1)
		{
			printf("No.%d %d\n",cnt,x);
			cnt++;
		}
		x++;
	}
	return 0;
}

