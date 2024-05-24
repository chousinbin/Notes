#include<bits/stdc++.h>
using namespace std;

class Circle
{
    private:

    double radius;
    
    public:

    Circle()
    {
        radius = 1;
    }

    Circle(int newRadius)
    {
        radius = newRadius;
    }

    // 析构无参数 无返回值
    ~Circle()
    {
        cout << "对象销毁";
    }
    
    double getRadius()
    {
        return radius;
    }

};  // 类以分号结尾

int main()
{
    Circle circle1(10);
    cout << circle1.getRadius() << endl;
}
