#include<iostream>
#include<cstring>
using namespace std;
int main()
{
    string a;
    getline(cin,a);
    char b;
    cin>>b;
    for (int i = 0; i < a.size(); i ++ )
    {
    	if(a[i]==b){
			cout<<'#';
		}else{
			cout<<a[i];
		}
	}
	return 0;
}
