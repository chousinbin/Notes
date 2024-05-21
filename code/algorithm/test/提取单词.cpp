#include<bits/stdc++.h>

using namespace std;

int main()
{
    string str;
    getline(cin, str);
    
    int len = str.size();
    // TODO: size() 与 strlen() 区别
    for(int i = 0; i < len; i++)
    {
        int j = i;
        while(j < len && str[j] != ' ') j++;
        
        for(int k = i; k < j; k++)
            cout<<str[k];
        cout<<endl;
        
        i = j;
    }
    return 0;
}