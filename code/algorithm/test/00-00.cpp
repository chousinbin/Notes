#include<bits/stdc++.h>
using namespace std;

const int N = 1e5 + 10;
void array_reference(int a[], int n)
{
    cout << "原数组：";
    for(int i = 0; i < n; i++)
    {
        cout << a[i] << ' ';
    }
    cout << endl << "修改之后的数组：";
    a[0] = 0;
    for(int i = 0; i < n; i++)
    {
        cout << a[i] << ' ';
    }
    puts("");
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
    cout << "验证数组是传递引用" << endl;
    int n = 3;
    int a[n] = {1, 2, 3};
    array_reference(a, n);
    
    // 验证 swap 传值
    int x = 9, y = 22;
    cout << "验证 swap 传值" << endl;
    cout << "原值：" << x << ' ' << y << endl;
    swap_value(x, y);
    cout << "传值交换之后：" << x << ' ' << y << endl;
    
    // 验证 swap 传引用
    cout << "验证 swap 传引用" << endl;
    cout << "原值：" << x << ' ' << y << endl;
    swap_reference(x, y);
    cout << "传引用交换之后：" << x << ' ' << y << endl;
    
    // 验证 swap 传指针
    int *p1, *p2;
    *p1 = 1;
    *p2 = 2;
    cout << "验证 swap 传指针" << endl;
    cout << "原值：" << *p1 << ' ' << *p2 << endl;
    swap_pointer(p1, p2);
    cout << "传指针交换之后：" << *p1 << ' ' << *p2 << endl;

    return 0;
}