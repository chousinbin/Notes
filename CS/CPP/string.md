# string

## stringstream

如果一行有 $n$ 个空格隔开的字符串,在 $C$ 语言中无法直接单独读入。我们可以用 $string$ 的`getline`函数进行整行的读入，再用`stringstream`进行提取处理。

### 错误票据

某涉密单位下发了某种票据，并要在年终全部收回。

每张票据有唯一的ID号。

全年所有票据的ID号是连续的，但ID的开始数码是随机选定的。

因为工作人员疏忽，在录入ID号的时候发生了一处错误，造成了某个ID断号，另外一个ID重号。

你的任务是通过编程，找出断号的ID和重号的ID。

假设断号不可能发生在最大和最小号。

#### 输入格式

第一行包含整数 $N$，表示后面共有 $N$ 行数据。

接下来 $N$ 行，**每行包含空格分开的若干个（不大于$100$个）正整数（不大于100000）**，每个整数代表一个ID号。

#### 输出格式

要求程序输出$1$行，含两个整数 $m,n$，用空格分隔。

其中，$m$表示断号ID，$n$表示重号ID。

#### 数据范围

$1≤N≤100$

#### 输入样例：

```
2
5 6 8 11 9 
10 12 9
```

#### 输出样例：

```
7 9
```

#### AC代码

```c++
#include<bits/stdc++.h>
using namespace std;
const int N=1e5+10;
int n,a[N],cnt;

int main()
{
    cin>>n;
    string line;
    getline(cin,line);//读取忽略第一行的回车
    while(n--)
    {
        getline(cin>>line);//把每行的字符串及中间空格读入进来
        stringstream ssin(line);//从 line 中提取字符串
        while(ssin>>a[cnt]) cnt++;//把提取出来的流入到a数组当中
    }
    
    sort(a,a+cnt);
    int n,m;
    for(int i=0;i<cnt;i++)
    {
        if(a[i]==a[i+1]) n=a[i];
        if(a[i]==a[i-1]+2) m=a[i]-1;
    }
    
    cout<<m<<' '<<n;
    
}
```



## 数字转string

```cpp
string str=to_string(123);
```



## string转int

```cpp
int x=stoi(str);
```

