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

    // �����޲��� �޷���ֵ
    ~Circle()
    {
        cout << "��������";
    }
    
    double getRadius()
    {
        return radius;
    }

};  // ���ԷֺŽ�β

int main()
{
    Circle circle1(10);
    cout << circle1.getRadius() << endl;
}
