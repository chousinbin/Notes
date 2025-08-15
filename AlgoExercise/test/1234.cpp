#include<bits/stdc++.h>
using namespace std;
int main()
{
    int n,c;
    string sss,ss,s;
    string ch;
    cin>>n;
    while(n--)
    {
        int a=0,b=0,ret=0,len=0;
        cin>>sss;
        
        if(sss=="a"||sss=="b"||sss=="c")
        {
            ch=sss;
            cin>>ss>>s;
            for(int i=0;i<ss.size();i++) a=a*10+(ss[i]-'0');
            for(int i=0;i<s.size();i++) b=b*10+(s[i]-'0');
            
            if(sss=="a")
                c=a+b,cout<<a<<'+'<<b<<'='<<a+b<<endl;
            if(sss=="b")
                c=a-b,cout<<a<<'-'<<b<<'='<<a-b<<endl;
            if(sss=="c")
                c=a*b,cout<<a<<'*'<<b<<'='<<a*b<<endl;
            if(c<0) len++,c=0-c;
            while(c)
            {
                c/=10;
                ret++;
            }
            len+=ss.size()+s.size()+2+ret;
            cout<<len<<endl;
        }else{
            for(int i=0;i<sss.size();i++) a=a*10+(sss[i]-'0');
            cin>>s;
            for(int i=0;i<s.size();i++) b=b*10+(s[i]-'0');
        
            if(ch=="a")
                c=a+b,cout<<a<<'+'<<b<<'='<<a+b<<endl;
            if(ch=="b")
                c=a-b,cout<<a<<'-'<<b<<'='<<a-b<<endl;
            if(ch=="c")
                c=a*b,cout<<a<<'*'<<b<<'='<<a*b<<endl;
            if(c<0) c=0-c,len++;
            while(c)
            {
                c/=10;
                ret++;
            }
            len+=sss.size()+s.size()+2+ret;
            cout<<len<<endl;
        }
    }
    return 0;
}
