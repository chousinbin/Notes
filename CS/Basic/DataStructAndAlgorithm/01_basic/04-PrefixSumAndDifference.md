# 前缀和与差分

## 前缀和

### 一维前缀和

#### 前缀和图示

![image-20240124163625957](https://cdn.jsdelivr.net/gh/chousinbin/Image/202401241636982.png)

#### 区间和图示

![image-20240124163614568](https://cdn.jsdelivr.net/gh/chousinbin/Image/202401241636597.png)

#### [题目描述](https://www.acwing.com/problem/content/797/)

输入一个长度为 n 的整数序列。

接下来再输入 m 个询问，每个询问输入一对 l,r。

对于每个询问，输出原序列中从第 l 个数到第 r 个数的和。

#### 输入格式

第一行包含两个整数 n 和 m。

第二行包含 n 个整数，表示整数数列。

接下来 m 行，每行包含两个整数 l 和 r，表示一个询问的区间范围。

#### 输出格式

共 m 行，每行输出一个询问的结果。

#### 数据范围

1≤l≤r≤n
1≤n,m≤100000
−1000≤数列中元素的值≤1000

#### 输入样例

```
5 3
2 1 3 6 4
1 2
1 3
2 4
```

#### 输出样例

```
3
6
10
```

#### AC代码

```c++
#include <bits/stdc++.h>

using namespace std;

const int N = 1e6 + 10;

int a[N], s[N];

int main()
{
    int n, m;
    cin >>n >> m;
    
    for(int i = 1; i <= n; i++)
        cin >> a[i];
    // 前缀和初始化
    for(int i = 1; i <= n; i++)
        s[i] = s[i - 1] + a[i];
        
    while(m--)
    {
        int l, r;
        cin >> l >> r;
        // 区间和
        cout << s[r] - s[l - 1] << endl;
    }
    return 0;
}
```

### 二维前缀和

$s[i][j]$ = 第 $i$ 行 $j$ 列格子左上部分所有元素的和

#### 前缀和图示

![image-20240126213945800](https://cdn.jsdelivr.net/gh/chousinbin/Image/202401262139826.png)

#### 区间和图示

![image-20240126213935881](https://cdn.jsdelivr.net/gh/chousinbin/Image/202401262139909.png)

#### [题目描述](https://www.acwing.com/problem/content/798/)

输入一个 n 行 m 列的整数矩阵，再输入 q 个询问，每个询问包含四个整数 x1,y1,x2,y2，表示一个子矩阵的左上角坐标和右下角坐标。

对于每个询问输出子矩阵中所有数的和。

#### 输入格式

第一行包含三个整数 n，m，q。

接下来 n 行，每行包含 m 个整数，表示整数矩阵。

接下来 q 行，每行包含四个整数 x1,y1,x2,y2，表示一组询问。

#### 输出格式

共 q 行，每行输出一个询问的结果。

#### 数据范围

1≤n,m≤1000,
1≤q≤200000,
1≤x1≤x2≤n,
1≤y1≤y2≤m,
−1000≤矩阵内元素的值≤1000

#### 输入样例

```
3 4 3
1 7 2 4
3 6 2 8
2 1 2 3
1 1 2 2
2 1 3 4
1 3 3 4
```

#### 输出样例

```
17
27
21
```

#### AC代码

```c++
#include <bits/stdc++.h>

using namespace std;

const int N = 1001;

int a[N][N], s[N][N];

int main()
{
    int n, m, q;
    cin >> n >> m >> q;
    
    for(int i = 1; i <= n; i++)
        for(int j = 1; j <= m; j++)
            cin >> a[i][j];
    // 二维前缀和       
    for(int i = 1; i <= n; i++)
        for(int j = 1; j <= m; j++)
            s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + a[i][j];
    
    while(q--)
    {
        int x1, y1, x2, y2;
        cin >> x1 >> y1 >> x2 >> y2;
        // 二维区间和
        cout << s[x2][y2] - s[x1 - 1][y2] - 
            s[x2][y1 - 1] + s[x1 - 1][y1 - 1] << endl;
    }
    return 0;
}
```

## 差分

> 差分是前缀和的逆运算
>

### 一维差分

![image-20240126233840816](https://cdn.jsdelivr.net/gh/chousinbin/Image/202401262338845.png)

$a[i]=b[1]+b[2]+...+b[i]$

$b[i] = a[i]-a[i-1]$

**由于 a[i] 是 b[i] 的前缀和，所以当 b[i]  加上数值 c，使得原数组 a[i] - a[n] 在原来基础上每个数值都加上了 c。**

#### [题目描述](https://www.acwing.com/problem/content/description/799/)

输入一个长度为 n 的整数序列。

接下来输入 m 个操作，每个操作包含三个整数 l,r,c，表示将序列中 [l,r]之间的每个数加上 c。

请你输出进行完所有操作后的序列。

#### 输入格式

第一行包含两个整数 n 和 m。

第二行包含 n 个整数，表示整数序列。

接下来 m 行，每行包含三个整数 l，r，c 表示一个操作。

#### 输出格式

共一行，包含 n 个整数，表示最终序列。

#### 数据范围

1≤n,m≤100000
1≤l≤r≤n
−1000≤c≤1000
−1000≤整数序列中元素的值≤1000

#### 输入样例

```
6 3
1 2 2 1 2 1
1 3 1
3 5 1
1 6 1
```

#### 输出样例

```
3 4 5 3 4 2
```

#### AC代码

```c++
#include <bits/stdc++.h>
using namespace std;

const int N = 1e5 + 10;

int a[N]; // b[i]的前缀和
int b[N]; // b[i] = a[i] - a[i - 1]

/*
    由于 a[i] 是 b[i] 的前缀和
    所以 b[i - 1] + c，会使 a[i] - a[n] + c
    为了实现区间加值，则需要再区间的 end (r + 1) 减去 c
*/
void insert(int l, int r, int c)
{
    b[l] += c;
    b[r + 1] -= c;
}

int main()
{
    int n, m;
    cin >> n >> m;

    for(int i = 1; i <= n; i++)
        cin >> a[i];
    // 初始化原数组
    for(int i = 1; i <= n; i++)
        insert(i, i, a[i]);
    // 实现区间加值
    while(m--)
    {
        int l, r, c;
        cin >> l >> r >> c;
        insert(l, r, c);
    }
    // 更新前缀和
    for(int i = 1; i <= n; i++)
        a[i] = a[i - 1] + b[i];

    for(int i = 1; i <= n; i++)
        cout << a[i] << ' ';

    return 0;
}
```

### 二维差分

![image-20240126234113640](https://cdn.jsdelivr.net/gh/chousinbin/Image/202401262341682.png)

#### [题目描述](https://www.acwing.com/problem/content/800/)

输入一个 n 行 m 列的整数矩阵，再输入 q 个操作，每个操作包含五个整数 x1,y1,x2,y2,c，其中 (x1,y1) 和 (x2,y2)表示一个子矩阵的左上角坐标和右下角坐标。

每个操作都要将选中的子矩阵中的每个元素的值加上 c。

请你将进行完所有操作后的矩阵输出。

#### 输入格式

第一行包含整数 n,m,q。

接下来 n 行，每行包含 m 个整数，表示整数矩阵。

接下来 q 行，每行包含 5 个整数 x1,y1,x2,y2,c，表示一个操作。

#### 输出格式

共 n 行，每行 m 个整数，表示所有操作进行完毕后的最终矩阵。

#### 数据范围

$1≤n,m≤1000,$
$1≤q≤100000,$
$1≤x1≤x2≤n,$
$1≤y1≤y2≤m,$
$−1000≤c≤1000,$
$−1000≤矩阵内元素的值≤1000$

#### 输入样例

```
3 4 3
1 2 2 1
3 2 2 1
1 1 1 1
1 1 2 2 1
1 3 2 3 2
3 1 3 4 1
```

#### 输出样例

```
2 3 4 1
4 3 4 1
2 2 2 2
```

#### AC代码

```c++
#include <bits/stdc++.h>
using namespace std;

const int N = 1010;
int a[N][N], b[N][N];
// 差分数组构造
void insert(int x1, int y1, int x2, int y2, int c)
{
    b[x1][y1] += c;
    b[x2 + 1][y1] -= c;
    b[x1][y2 + 1] -= c;
    b[x2 + 1][y2 + 1] += c;
}

int main()
{
    int n, m, q;
    cin >> n >> m >> q;
    // 输入原数组，初始化差分数组
    for(int i = 1; i <= n; i++)
    {
        for(int j = 1; j <= m; j++)
        {
            cin >> a[i][j];
            insert(i, j, i, j, a[i][j]);
        }
    }
    // 差分数组区间加值
    while(q--)
    {
        int x1, x2, y1, y2, c;
        cin >> x1 >> y1 >> x2 >> y2 >>c;
        insert(x1, y1, x2, y2, c);
    }
    // 最终结果是差分数组的前缀和
    for(int i = 1; i <= n; i++)
    {
        for(int j = 1; j <= m; j++)
        {
            a[i][j] = a[i - 1][j] + a[i][j - 1] - 
                a[i - 1][j - 1] + b[i][j];
            cout << a[i][j] << ' ';
        }
        cout << endl;
    }
    return 0;
}
```

