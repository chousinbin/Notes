# 前缀和

## 一维前缀和

#### 一维前缀和图片

![image-20240124163625957](https://cdn.jsdelivr.net/gh/chousinbin/Image/202401241636982.png)

#### 一维区间和图片

![image-20240124163614568](https://cdn.jsdelivr.net/gh/chousinbin/Image/202401241636597.png)

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

## 二维前缀和

$s[i][j]$ = 第 $i$ 行 $j$ 列格子左上部分所有元素的和

#### 二维前缀和图片

![image-20240124162839566](https://cdn.jsdelivr.net/gh/chousinbin/Image/202401241628593.png)

#### 二维区间和图片

![image-20240124162917138](https://cdn.jsdelivr.net/gh/chousinbin/Image/202401241629168.png)

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

# 差分

差分是前缀和的逆运算

$a[i]=b[1]+b[2]+...+b[i]$

$b[i] = a[i]-a[i-1]$

## 一维差分

```c++
#include<bits/stdc++.h>
using namespace std;
const int N=1e6+10;
int n,m,a[N],b[N];
//实现区间加值
void insert(int l,int r,int c)
{
    b[l]+=c;
    b[r+1]-=c;
}
int main()
{
    cin>>n>>m;
    for(int i=1;i<=n;i++) cin>>a[i];
    //构造a的差分数组b
    for(int i=1;i<=n;i++) insert(i,i,a[i]);
    while(m--)
    {
        int l,r,c;
        cin>>l>>r>>c;
        insert(l,r,c);//实现区间加值
    }
   	//更新a
    for(int i=1;i<=n;i++) a[i]=a[i-1]+b[i];
    //输出
    for(int i=1;i<=n;i++) cout<<a[i]<<' ';
    return 0;
}
```

## 二维差分

![image-20240124220523003](https://cdn.jsdelivr.net/gh/chousinbin/Image/202401242205222.png)

```c++
#inclued<bits/stdc++.h>
using namespace std;
const int N=1010;
int n,m,q,a[N][N],b[N][N];
void insert(int x1,int y1,int x2,int y2,int c)
{
    b[x1][y1]+=c;
    b[x2+1][y1]-=c;
    b[x1][y2+1]-=c;
    b[x2+1][y2+1]+=c;
}
int main()
{
    cin>>n>>m>>q;
    //读入a 并且构造a
    for(int i=1;i<=n;i++)
    {
        for(int j=1;j<=m;j++)
        {
            cin>>a[i][j];
            insert(i,j,i,j,a[i][j]);
        }
    }
    //实现区间加值
    while(q--)
    {
        int x1,y1,x2,y2,c;
        cin>>x1>>y1>>x2>>y2>>c;
        insert(x1,y1,x2,y2,c);
    }
    //更新b的前缀和a并输出
    for(int i=1;i<=n;i++)
    {
        for(int j=1;j<=m;j++)
        {
            a[i][j]=a[i-1][j]+a[i][j-1]-a[i-1][j-1]+b[i][j];
            cout<<a[i][j]<<' ';
        }
        cout<<endl;
    }
    return 0;
}
```

