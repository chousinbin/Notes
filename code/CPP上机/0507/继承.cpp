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
        cout << "X析构" << endl;
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

// Y 继承 X 类
// 公有派生：子类能调用父类的成员
class Y : public X 
{
    int i;
    public:
    // 构造函数和析构函数无法继承
    Y() {i = 1;
		cout << "Y" <<endl;
	}
    ~Y()
    {
        cout << "Y析构" << endl;
    }
    int change()
    {
        i = permute();
        return i;
    }

    // redefined 重定义 / 重写
    void set(int ii)
    {
        i = ii;
        cout << "Y" << endl;
    }



};

int main()
{
    Y D;
    // 调用父类成员
    D.read();
    // 调用本类成员
    D.change();

    D.set(2);
    // 调用父类被重写的成员函数
    D.X::set(22);
    return 0;
}
