#include<bits/stdc++.h>
using namespace std;
int main()
{
    int left=0,right=0,ret=0;
    string a,b,c,d;
    getline(cin,d);
    int q=0;
    while(d[q]!=',') a+=d[q++];
    q++;
    while(d[q]!=',') b+=d[q++];
    q++;
    while(d[q]!=','&&d[q]!=0) c+=d[q++];
    
    
    if(b.size()>a.size() || c.size()>a.size())
    {
        cout<<-1;
        return 0;
    }
    //����a ���Ҽ�¼b����С��ֵ
    for(int i=0;i<=a.size()-b.size();i++)
    {
        int j;
        for(j=0;j<b.size();j++)
        {
            if(a[i+j]!=b[j]) break;
        }
        if(j==b.size())
        {
            ret++;
            left=i+j-1;//����ߵ��Ҷ˵�
            break;     
        }
    }
    //����c ���Ҽ�¼c�������ֵ
    for(int i=a.size()-c.size();i>=0;i--)
    {
        int j;
        for(j=0;j<c.size();j++)
        {
            if(a[i+j]!=c[j]) break;
        }
        if(j==c.size())
        {
            ret++;
            right=i;  //���ұߵ���˵�
            break; 
        }
    }
    //cout<<left<<' '<<right<<' ';
    if(ret==2 && right>left) cout<<right-left-1;
    else cout<<-1;
    return 0;
}
