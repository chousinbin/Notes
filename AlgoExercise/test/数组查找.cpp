#include<stdio.h>
int search(int key,int a[],int length);
int main(void)
{
	int a[]={1,3,2,4,6,7,5,8,9,98}; 
	int x,loc;
	scanf("%d",&x);
	loc=search(x,a,sizeof(a)/sizeof(a[0]));
	if(loc!=-1)
	{
		printf("%d on size %d\n",x,loc);
	}else{
		printf("%d is not exist\n",x);
	}
	return 0;
 } 
 int search(int key,int a[],int length)
 {
 	int ret=-1;
 	int i;
 	for(i=0;i<length;i++)
 	{
 		if(a[i]==key)
 		{
 			ret=i;
 			break;
		}
	}
	return ret;
 }
