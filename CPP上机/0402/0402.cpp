/*
    验证局部对象、全局对象、静态对象的析构顺序
    得到三种类型的对象存储位置
*/

#include<bits/stdc++.h>
using namespace std;

class Stu
{
    public:
    int a;
    int b;
    Stu(int a, int b)
    {
        this->a = a;
        this->b = b;
    }
    Stu(const Stu &s)
    {
        this->a = s.a + 1;
        this->b = s.b + 1;
    }

    // 形参也调用拷贝构造函数，也创建一个临时对象
    Stu f(Stu s)
    {
        return s; // 调用拷贝构造函数创建一个临时对象
    }
}; 

int main()
{
    int a = 10, b = 20;
    
    /*
        指向常量的指针
        不能通过指针更改 a 的值
        可以通过 a 更改值
    */

    const int *p = &a;

    /*
        指向整数的常量指针
        不能更改指针的地址
    */
    
    int * const p2 = &a;

    /*
        指向常量整数的常量指针
        不能通过指针更改变量的值
        也不能更改指针的地址
    */

    const int * const p3 = &b;


    /*
        堆
        手动申请和释放
        得到的是一个连续的内存单元
        需要使用指针
    */

    int *res  = new int[10]; // Allocate

    delete [] res; // Deallocate

    res[1] = a;
    res[0] = b;

    // 两个同类对象可以进行复制
    /*
        拷贝构造函数
        参数只有一个是某个对象的引用
        每个类都必须有拷贝构造函数

        1. 一个对象初始化另一个对象
        2. 对象作为函数的返回值
        3. 对象作为函数的参数
    */

    Stu s(1, 2);

    Stu s2(s);

    cout << s2.a << ' ' << s2.b;

    s2.f(s2);

    // 直接赋值对象不能复制资源
    Stu s3 = s;

}

