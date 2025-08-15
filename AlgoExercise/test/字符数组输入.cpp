#include<iostream>
#include<cstdio>
using namespace std;
int main()
{
	string std;
	char str[101];

	cin.getline(str,100);//字符串输入 
	puts(str);//输出后默认回车 

	getline(cin,std);//string 输入 
	cout<<std<< endl;
	
	return 0;
 } 
