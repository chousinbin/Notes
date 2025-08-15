#include<stdio.h>
#include <iostream>
#include<math.h>
using namespace std;
int main()
{
	int n;
	scanf("%d",&n);
	switch(n)
	{
		case 1:
		printf("I love Luogu!\n");
		break;
		case 2:
		printf("%d %d\n",2+4,10-2-4);
		break;
		case 3:
		{
			int num=14,p=4;
			int x;
			x=num/p;
			printf("%d\n%d\n%d\n",x,x*p,num-x*p);
			break;	
		}
		case 4:
		{
			double x=500.0/3;
			printf("%lf\n",x);
			break;
		}
		case 5:
			printf("%d",480/32);
			break;
		case 6:
		{
			int a=6,b=9;
			float c;
			c=sqrt(a*a+b*b);
			cout<<c<<endl;	
			break;
		}
		case 7:
			printf("110\n90\n0");
			break;
		case 8:
			cout<<2*5*3.141593 << std::endl << 3.141593*5*5 << std::endl << 4.0/3*3.141593*125 << std::endl;
			break;
		case 9:
			{
				int day=1,n=1;
				for(day=3;day>0;day--)
				{
					n=(n+1)*2;
				}
				printf("%d\n",n);
				break;
			 } 
		case 10:
			{
				
				
			printf("9\n");
			break;
				
				
			}
		case 11:
			{
				float x=100.0/13;
				std::cout<<x<<std::endl;
				break;
			}
		case 12:
			{
				char ch;
				printf("%d\n%c",'M'-64,18+64);
				break;
			}
		case 13:
		{
			double v,a;
			v=4.0/3*3.141593*(4*4*4+1000);
			a=1.0/3;
			printf("%d",(int)pow(v,a));
			break;
		}
		case 14:
		{
			int money=110,people=10;
			int x=0;
			for(x=1100;x<3500;--money,++people)
			{
				x=money*people;
				continue;
			}
			printf("50\n");
			break;
		}
			
	}
	
	return 0;
}
