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
    // ��Ա��ʼ���б� 
    C(int ii) : B(ii), a(1)
    {
        i = ii;
        cout << "C" << endl;
    }
};

int main()
{
    C c(10);
    // �ȹ��� B �ٹ��� A �ٹ��� C 
    return 0;
}