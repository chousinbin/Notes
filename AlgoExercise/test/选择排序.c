#include<stdio.h>
#include<windows.h>
int max(int a[],int len)
{
    int maxid=0;
    for(int i=1;i<len;i++)
    {
        if(a[i]>a[maxid])
        {
            maxid=i;
        }
    }
    return maxid;
}
int main()
{
    int a[]={2,6,3,8,66,99};
    int len=sizeof(a)/sizeof(a[0]);
    for(int i=len-1;i>0;i--)
    {
        int maxid=max(a,i+1);
        //swap
        int t=a[maxid];
        a[maxid]=a[i];
        a[i]=t;
    }
    for(int i=0;i<len;i++)
    {
        printf("%d ",a[i]);
    }
    system("pause");
	return 0; 
}