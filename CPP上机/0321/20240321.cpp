#include<bits/stdc++.h>
using namespace std;

void array_reference(int a[], int n)
{
    cout << "形参数组第一个元素的地址：" << &a[0];
    a[0] = 0;
}

void swap_value(int x, int y)
{
    int temp = x;
    x = y;
    y = temp;
}

void swap_reference(int &x, int &y)
{
    int temp = x;
    x = y;
    y = temp;
}

void swap_pointer(int *p1, int *p2)
{
    int temp = *p1;
    *p1 = *p2;
    *p2 = temp;
}

int main()
{
    // 验证数组是传递引用
    cout << "验证数组是传递引用" << endl << endl;
    int n = 3;
    int a[n] = {1, 2, 3};
    cout << "原数组：";
    for(int i = 0; i < n; i++)
    {
        cout << a[i] << ' ';
    }
    cout << endl;
    array_reference(a, n);
    cout << endl << "修改之后的数组：";
    for(int i = 0; i < n; i++)
    {
        cout << a[i] << ' ';
    }
    cout << endl;
    cout << "实参数组第一个元素的地址：" << &a[0] << endl;
    cout << "形参与实参数组第一个元素的地址相同所以数组做参数传递地址";
    puts("");
    puts("");
    
    // 验证 swap 传值
    int x = 9, y = 22;
    cout << "验证 swap 传值" << endl;
    cout << "原值：" << x << ' ' << y << endl;
    swap_value(x, y);
    cout << "传值交换之后：" << x << ' ' << y << endl << endl;
    
    // 验证 swap 传引用
    cout << "验证 swap 传引用" << endl;
    cout << "原值：" << x << ' ' << y << endl;
    swap_reference(x, y);
    cout << "传引用交换之后：" << x << ' ' << y << endl << endl;
    
    // 验证 swap 传指针
    cout << "验证 swap 传指针" << endl;
    cout << "原值：" << x << ' ' << y << endl;
    swap_pointer(&x, &y);
    cout << "传指针交换之后：" << x << ' ' << y << endl << endl;

    // 6.4
    int num = 65535;
    while(num)
    {
        cout << num % 10;
        num /= 10;
    }

    return 0;
}