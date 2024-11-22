#include<stdio.h>
#include<windows.h>
void change(int,int);
int main()
{
    int begin_num,base_num;
    scanf("%d %d",&begin_num,&base_num);//读入十进制数和基数
    printf("%d=",begin_num);
    int rem=0,i=0;
    int bit[20];
    for(i=0;begin_num!=0;i++)
    {
        rem=begin_num%base_num;//余数
        begin_num/=base_num;
        if(rem<0)//抄的负进制
        {
            begin_num+=1;
            rem-=base_num;
        }
        bit[i]=rem;//存储余数
    }

    for(i-=1;i>=0;i--)//输出
    {
        if(bit[i]>=10)
        {
            printf("%c",bit[i]+55);
        }else{
            printf("%d",bit[i]);
        }
    }
    printf("(base%d)\n",base_num);

    system("pause");
	return 0; 
}