#include<bits/stdc++.h>
using namespace std;

class A
{
    int i;
    public:
    A(int ii)
    {
        i = ii;
        cout << "A" << endl;
    }
};

class B
{
    int i;
    public:
    B(int ii)
    {
        i = ii;
        cout << "B" << endl;
    }
};

class C : public B
{
    int i;
    A a;
    public:
    // 成员初始化列表 
    C(int ii) : B(ii), a(1)
    {
        i = ii;
        cout << "C" << endl;
    }
};

int main()
{
    C c(10);
    // 先构造 B 再构造 A 再构造 C 
    return 0;
}