#include<iostream>
using namespace std;
int main()
{
	int m,t,s;
	cin>>m>>t>>s;
	if(t==0){
		cout<<0<<endl;
		return 0;//严谨啊 就差这一个就不100；
	}
	if(s==0) cout<<m;
	if(s/t-m>0){
		cout<<0;
	}else{
		if(s%t==0) cout<<m-s/t;
		if(s%t) cout<<m-s/t-1;
	}
	
	return 0;
 } 
