#include<stdio.h>
#include<windows.h>
int main()
{
    int i;//表示月份-1
    int cost[12];
    for(i=0;i<12;i++)//输入预算
    {
        scanf("%d",&cost[i]);
    }
    i=0;
    int sum=0;//自己的金钱
    int money=0;//上交的钱
    int ret=12;
    for(i=0;i<12;i++)
    {
        sum+=300;//每个月加300
        sum-=cost[i];//减去预算
        if(sum<0)//判断是否预算超支
        {
             ret=i;//把月份存储
             break;
        }else if(sum/100>0){//判断是否满足存钱
            money+=(sum/100*100);//存钱
            sum-=(sum/100*100);//存完之后
        }
    }
    if(ret!=12)
    {
        printf("money was not enough\n");
        printf("%d\n",-(ret+1));//输出月份
    }else{ 
        money=money*120/100;
        printf("the end money:\n");
        printf("%d\n",money+sum);//输出本金加利息之和
    }

    system("pause");
	return 0; 
}