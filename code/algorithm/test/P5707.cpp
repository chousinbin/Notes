#include<stdio.h>
int main()
{
	int s,v,hour,min;
	scanf("%d %d",&s,&v);
	int t;
	t=s/v+s%v+10;
	if(t<=480)
	{
		hour=t/60;
		min=t%60;
		if(min>0)
		{
			if(min>50)
			{
				printf("%d:0%d\n",8-hour-1,60-min);	
			}else{
				printf("%d:%d\n",8-hour-1,60-min);
			}
				
		}else{
			printf("%d:00\n",8-hour);
		}
	}else{
		t-=480;
		hour=t/60;
		min=t%60;
		if(min>0)
		{
			if(min>50)
			{
				printf("%d:0%d\n",24-hour-1,60-min);
			}else{
				printf("%d:%d\n",24-hour-1,60-min);
			}
		}else{
			printf("%d:00",24-hour);
		}
		
	}
	return 0;
}
