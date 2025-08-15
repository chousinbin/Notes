#include<bits/stdc++.h> // 引入所有标准库
using namespace std;

// 定义一个名为 'sample' 的模板类
template<class T>
class sample {
    T n; // 模板类型成员变量，用来存储一个值
public:
    sample() {} // 默认构造函数
    sample(T i) { n = i; } // 构造函数，用于初始化成员变量 'n'

    // 重载加法运算符，用于添加两个 'sample' 对象
    sample<T> operator+(sample<T> &);
    
    void dis() { cout << n << endl; }
};

// 重载加法运算符的实现
template<class T>
sample<T> sample<T>::operator+(sample<T> &s)
{
    sample<T> temp; // 创建一个临时的 'sample' 对象
    temp.n = n + s.n; // 将两个 sample 对象的 'n' 相加，并存储在 temp 的 'n' 中
    return temp; // 返回临时对象
}

int main()
{
    sample<int> s1(10), s2(20), s3; // 创建三个整型的 'sample' 对象
    sample<double> s4; // 创建一个未初始化的双精度浮点型 'sample' 对象
    s3 = s1 + s2; // 将 s1 和 s2 相加，结果存储在 s3 中
    s3.dis(); // 显示 s3 中存储的结果
    
    return 0; // 程序结束
}