#include<stdio.h>
int main()
{
    int i;//��ʾ�·�-1
    int cost[12];
    for(i=0;i<12;i++)//����Ԥ��
    {
        scanf("%d",&cost[i]);
    }
    i=0;
    int sum=0;//�Լ��Ľ�Ǯ
    int money=0;//�Ͻ���Ǯ
    int ret=12;
    for(i=0;i<12;i++)
    {
        sum+=300;//ÿ���¼�300
        sum-=cost[i];//��ȥԤ��
        if(sum<0)//�ж��Ƿ�Ԥ�㳬֧
        {
             ret=i;//���·ݴ洢
             break;
        }else if(sum/100>0){//�ж��Ƿ������Ǯ
            money+=(sum/100*100);//��Ǯ
            sum-=(sum/100*100);//����֮��
        }
    }
    if(ret!=12)
    {
        printf("money was not enough in month:");
        printf("%d\n",ret+1);//����·�
    }else{ 
        money=money*120/100;
        printf("the end of money:");
        printf("%d\n",money);//����������Ϣ֮��
    }
	return 0; 
}
