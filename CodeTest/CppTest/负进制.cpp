#include<stdio.h>
#include<windows.h>

void change(int begin_num,int base_num)
{
    int rem=0,i=0;
    int bit[37336];
    for(i=0;begin_num!=0;i++)
    {
        rem=begin_num%base_num;  //����
        if(rem<0)  //���ĸ�����
        {
            begin_num+=base_num;
            rem-=base_num;
        }
        bit[i]=rem;  //�洢����
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
	
    scanf("%d %d",&begin_num,&base_num);  //����ʮ�������ͻ���
    printf("%d=",begin_num);
    change(begin_num,base_num);
    printf("(base%d)\n",base_num);
	
	return 0; 
}
