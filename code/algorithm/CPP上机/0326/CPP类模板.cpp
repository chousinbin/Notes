#include<bits/stdc++.h>
using namespace std;

class Circle
{
    // 访问修饰符
    private:
    // 属性, 可以有默认值
    double radius;
    // 从此处到类结尾全为 public
    public:
    // 构造函数
    Circle()
    {
        radius = 1;
    }
    Circle(int newRadius)
    {
        radius = newRadius;
    }
    // 方法
    double gatArea()
    {
        return 3.14 * pow(radius, 2);
    }
    
    double getRadius()
    {
        return radius;
    }

};  // 类以分号结尾

int main()
{
    Circle circle1(10), circle2;
    circle2 = circle1;
    cout << circle2.getRadius();
}

//TODO 析构