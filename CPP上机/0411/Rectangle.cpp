#include<bits/stdc++.h>
using namespace std;

class Rectangle
{
    private:
    double width;
    double height;

    public:
    Rectangle(double width = 0, double height = 0)
    {
        this -> width = width;
        this -> height = height;
    }

    Rectangle(const Rectangle &r)
    {
        this -> height = r.height + 1;
        this -> width = r.width + 1;
        cout << "拷贝构造函数被调用: " << this -> width << ' ' << this -> height << endl;
    }

    ~Rectangle()
    {
        cout << this -> width << ' ' << this -> height << " 摧毁" << endl;
    }

    void setWidth(int width)
    {
        this -> width = width;
    }

    double getWidth()
    {
        return width;
    }

    double getHeight()
    {
        return height;
    }
};

// 参数会调用拷贝构造函数创建新的对象
Rectangle f(Rectangle r)
{
    cout << "新的 r 对象: " << r.getWidth() << ' ' << r.getHeight() << endl;

    static Rectangle static_object(99, 99);
    cout << "static_object: " << static_object.getWidth() << ' ' << static_object.getHeight() << endl;

    // 返回会调用拷贝函数创建新的对象
    return static_object;
}

int main()
{

    Rectangle r; // 0 0
    // 第一种调用拷贝构造函数
    Rectangle r2(r); // 1 1
    // 第二种调用拷贝构造函数
    Rectangle r3 = r2; // 2 2
    // 第三种调用拷贝构造函数
    // 两次调用 f 验证全局对象
    Rectangle R1 = f(r3); // 3 3
    
    Rectangle R2 = f(r3);

    return 0;
}