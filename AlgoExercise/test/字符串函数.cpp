#include<iostream>
#include<cstring>
using namespace std;
int main()
{
	char obs[10],abs[10];
	cin>>obs;
	fgets(abs,5,stdin);
	cout<<"sizeof abs = "<<sizeof(obs)<<endl;
	cout<<"strlen(obs) = "<<strlen(obs)<<endl;
	cout<<"strcmp = "<<strcmp(obs,abs)<<endl;
	
	
	return 0;
 } 
