#include<bits/stdc++.h>
using namespace std;

class X
{
    int i;
    public:
    X() {i = 0;
		cout << "x" << endl; 
	}
    ~X()
    {
        cout << "X����" << endl;
    }

    void set(int ii)
    {
        i = ii;
        cout << "X" << endl;
    }

    int permute()
    {
        return i;
    }

    int read()
    {
        return i;
    }
};

// Y �̳� X ��
// ���������������ܵ��ø���ĳ�Ա
class Y : public X 
{
    int i;
    public:
    // ���캯�������������޷��̳�
    Y() {i = 1;
		cout << "Y" <<endl;
	}
    ~Y()
    {
        cout << "Y����" << endl;
    }
    int change()
    {
        i = permute();
        return i;
    }

    // redefined �ض��� / ��д
    void set(int ii)
    {
        i = ii;
        cout << "Y" << endl;
    }



};

int main()
{
    Y D;
    // ���ø����Ա
    D.read();
    // ���ñ����Ա
    D.change();

    D.set(2);
    // ���ø��౻��д�ĳ�Ա����
    D.X::set(22);
    return 0;
}
