#include<bits/stdc++.h>
using namespace std;
const int N=200;//字符串最多200个
int main()
{
    int n;
    string a[N];//字符串数组
    while(cin>>n,n)//一组数据有n个字符串
    {
        int len=1000;
        for(int i=0;i<n;i++)//遍历n个字符串求最短长度
        {
            cin>>a[i];
            if(a[i].size()<len) len=a[i].size();
        }
        for( ;len>0;len--)//遍历最长后缀 从大到小
        {
            
            bool success=true;//表示n个字符串的最长后缀 相等
            for(int i=1;i<n;i++)//遍历n-1个字符串和a[0]比较
            {
                bool is_same=true;//表示1个字符串 最长后缀和a[0] 相等
                for(int j=1;j<=len;j++)
                {//从这两个字符串的最后一个字符开始比较
                    if(a[0][a[0].size()-j] != a[i][a[i].size()-j])
                    {
                       is_same=false;
                       break;
                    }
                }
                if(!is_same)//如果有一个字符串和a[0]不相等
                {
                    success=false;//n个就不全部相同
                    break;
                }
             }
             if(success) break;//这n个字符串不全相同 让步让最长后缀-1  
        }
        cout<<a[0].substr(a[0].size()-len)<<endl;    
    }
    return 0;
}