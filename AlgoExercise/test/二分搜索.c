#include<stdio.h>
#include<windows.h>
int search(int key);
int main() //two search
{
    int key,k;
    printf("enter your number!");
    scanf("%d",&key);
    k=search(key);
    printf("%d",k);
    system("pause");
    return 0;
}
int search(int key)
{
    int a[10]={2,5,8,14,16,19,22,67,86,99};
    int ret=-1;
    int left=0,right=9,mid=0;
    while(right>left)
    {
        mid=(left+right)/2;
        if(a[mid]==key)
        {
            ret=mid;
            break;
        }else if(a[mid]<key){
            left=mid+1;
        }else{
            right=mid-1;
        }
    }
    return ret;
}
