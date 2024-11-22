#include<stdio.h>
int sp(long,int);
int main()
{
    long A,B,DA,DB;
    scanf("%ld %d %ld %d",&A,&DA,&B,&DB);
    int sum=sp(A,DA)+sp(B,DB);
    printf("%d",sum);
    return 0;
}
int sp(long n,int p)
{
	int i=0;
    while(n!=0)
    {
        if((n%10)==p)
        {
            i++;
        }
        n/=10;
    }
    int ret=0,rem=1;
    if(i==0)
    {
    	ret=0;
	}
    while(i>=1)
    {
        ret+=p*rem;
        rem*=10;
        i--;
    }
    
    return ret;
}
