#include<iostream>
using namespace std;
int main()
{
	int sum=0,n=1;
	char abs[14];
	char mod[12]="0123456789X";// 
	cin.getline(abs,14);
	
	for(int i=0;i<12;i++)
	{
		if(i==1||i==5||i==11) continue;
		sum+=(abs[i]-48)*n++;
	}
	
	if(mod[sum%11]==abs[12]) cout<<"Right";
	else abs[12]=mod[sum%11],cout<<abs;
	
	return 0;
}
