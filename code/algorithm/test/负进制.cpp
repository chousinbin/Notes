#include<stdio.h>
#include<windows.h>

void change(int begin_num,int base_num)
{
    int rem=0,i=0;
    int bit[37336];
    for(i=0;begin_num!=0;i++)
    {
        rem=begin_num%base_num;  //余数
        if(rem<0)  //抄的负进制
        {
            begin_num+=base_num;
            rem-=base_num;
        }
        bit[i]=rem;  //存储余数
        begin_num/=base_num;
    }
    while(i>0)
    {
        printf("%d",bit[i]);
        i--;
    }
}

int main()
{
    int begin_num,base_num;
	
    scanf("%d %d",&begin_num,&base_num);  //读入十进制数和基数
    printf("%d=",begin_num);
    change(begin_num,base_num);
    printf("(base%d)\n",base_num);
	
	return 0; 
}
