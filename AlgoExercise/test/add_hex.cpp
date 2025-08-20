#include<bits/stdc++.h>
using namespace std;

string add_hex(vector<char> A,vector<char> B)
{
    char a[16]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    string C;
    int t=0;
    for(int i=0;i<A.size()|i<B.size();i++)
    {
        if(i<A.size())
        {
             if(A[i]>='A' && A[i]<='F') t+=A[i]-'A'+10;
            else if(A[i]>='a' && A[i]<='f') t+=A[i]-'a'+10;
            else t+=A[i]-'0';
        }
        if(i<B.size())
        {
            if(B[i]>='A' && B[i]<='F') t+=B[i]-'A'+10;
            else if(B[i]>='a' && B[i]<='f') t+=B[i]-'a'+10;
            else t+=B[i]-'0';
        }
        
        C+=a[t%16];
        t/=16;
    }
    if(t) C+=1;
    C+="x0";
    reverse(C.begin(),C.end());
    return C;
}
int main()
{
    string a,b;
    vector<char> A,B;
    cin>>a>>b;
    for(int i=a.size()-1;i>=2;i--) A.push_back(a[i]);
    for(int i=b.size()-1;i>=2;i--) B.push_back(b[i]);
    
    string C=add_hex(A,B);
    cout<<C<<endl;
    return 0;
}