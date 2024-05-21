#include<iostream>

using namespace std;
int cnt[26];
char abs[100010];
int main()
{
	int ret=0;
	cin>>abs;
	for(int i=0;abs[i];i++)
	{
		cnt[abs[i]-'a']++;
	}
	for(int i=0;abs[i];i++)
	{
		if(cnt[abs[i]-'a']==1) 
		{
			cout<<abs[i]<<endl;
			ret=1;
			break; 	
		}
	}
	if(!ret) cout<<"no"<<endl;
	return 0;
}
