#include<bits/stdc++.h>
using namespace std;
const int N=110;
int q[N];

int main()
{
    q[1]=1,q[2]=3;
    int a=1,b=3;
    for(int i=3;i<=100;i++)
    {
        int c=a+b;
        q[i]=c;
        a=b,b=c;
    }

    double z=0.0000005;
    for(int i=1;i<=99;i++)
    {
        double num=q[i]*1.0/q[i+1]+z;

        if(abs(num-0.618034)<=0.000001)
        {
            cout<<q[i]<<' '<<q[i+1]<<endl;
            return 0;
        }
    }
}
