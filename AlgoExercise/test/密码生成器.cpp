#include<iostream>
using namespace std;


int main()
{
    char d[]={
    '0','1','2','3','4','5','6','7','8','9',
    '!','@','$','%','&','*','=','-','#',
    'A','b','c','d','e','f','g','h','j','k','m','n',
    'p','q','r','s','t','u','v','w','x','y','z','A',
    'B','C','D','E','F','G','H','I','J','K','L','M',
    'N','P','Q','R','S','T','U','V','W','X','Y','Z',
    };

    int len;
    cout<<"Type the length of the password:";
    cin>>len;

    while(len--)
    {
        int id=rand()%67;
        cout<<d[id];
    }
    return 0;
}