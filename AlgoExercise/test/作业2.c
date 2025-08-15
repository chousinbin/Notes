#include<stdio.h>
int main()
{
    int n1,n2,n3;
	int i,i2;
	
    scanf("%d",&n1);
    n3=n2=n1;
    
	//位数 
	for(i=0;n1>0;i++)
    { 
        n1/=10;   
    }
    printf("the bits are:%d\n",i);
    
    //按位输出 
    i2=i;
    while(i>0)
    {
		printf("the %d bit is %d\n",i,n2%10); 
		i--;
		n2/=10;
	}
	
	//倒序输出 
	printf("the inverted order of the number is:");
	while(i2>0)
	{
		printf("%d",n3%10);
		n3/=10;
		i2--;
	}
    printf("\n");
	
	return 0; 
}
