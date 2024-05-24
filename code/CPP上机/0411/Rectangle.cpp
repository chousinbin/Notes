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
        cout << "�������캯��������: " << this -> width << ' ' << this -> height << endl;
    }

    ~Rectangle()
    {
        cout << this -> width << ' ' << this -> height << " �ݻ�" << endl;
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

// ��������ÿ������캯�������µĶ���
Rectangle f(Rectangle r)
{
    cout << "�µ� r ����: " << r.getWidth() << ' ' << r.getHeight() << endl;

    static Rectangle static_object(99, 99);
    cout << "static_object: " << static_object.getWidth() << ' ' << static_object.getHeight() << endl;

    // ���ػ���ÿ������������µĶ���
    return static_object;
}

int main()
{

    Rectangle r; // 0 0
    // ��һ�ֵ��ÿ������캯��
    Rectangle r2(r); // 1 1
    // �ڶ��ֵ��ÿ������캯��
    Rectangle r3 = r2; // 2 2
    // �����ֵ��ÿ������캯��
    // ���ε��� f ��֤ȫ�ֶ���
    Rectangle R1 = f(r3); // 3 3
    
    Rectangle R2 = f(r3);

    return 0;
}