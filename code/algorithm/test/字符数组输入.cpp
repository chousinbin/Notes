#include<iostream>
#include<cstdio>
using namespace std;
int main()
{
	string std;
	char str[101];

	cin.getline(str,100);//�ַ������� 
	puts(str);//�����Ĭ�ϻس� 

	getline(cin,std);//string ���� 
	cout<<std<< endl;
	
	return 0;
 } 
