# 双指针算法

## 从字符串中提取单词

```c++
#include<bits/stdc++.h>

using namespace std;

int main()
{
    string str;
    getline(cin, str);
    
    int len = str.size();
    for(int i = 0; i < len; i++)
    {
        int j = i;
        while(j < n && str[j] != ' ') j++;
        
        for(int k = i; k < j; k++)
            cout<<str[i];
        cout<<endl;
        
        i = j;
    }
    return 0;
}
```

## 最长连续不重复子序列

如果暴力算法时间复杂度为 $O(n^2)$，我们采用双指针时间复杂度为 $O(n)$。

- $i$  和 $j$ 指针从 $0$ 开始往右走，$i$ 是右端点，$j$ 是左端点。
-  $i$ 每向右扩展一位，用 $cnt[a[i]]$ 标记子串中数字出现的次数。
- 每向右扩展一位，根据 $cnt[a[i]]$ 判断当前子串中是否与新的右边界的值 $a[i]$ 重复。
- 如果重复，从子串的左端点 $j$ 开始向右收缩, 直到子串中没有重复数字。
- 此时区间 $[j, i]$ 是一个不重复子序列, 每找到一个子序列就用 $res$ 更新一下最长连续不重复子序列。
- 最后输出$res$。

向右扩展一位只能使最大长度加一或者出现重复子序列的情况; 出现重复子序列的情况时, 因为每向右扩展一位之前从$j$到$i-1$指向的区间已经是以$i$为结尾的连续不重复的子序列, 所以是刚扩展的位重复了, 所以只能从当前子序列的左端点逐步往右缩短才能够使以$i$为结尾的子序列不重复;

```c++
#include <bits/stdc++.h>
using namespace std;

const int N = 1e6 + 10;
int a[N];
int cnt[N]; // 记录 i 在区间出现的次数

int main()
{
    int n;
    cin >> n;

    for(int i = 0; i < n; i++)
        cin >> a[i];

    int res = 0;
    for(int i = 0, j = 0; i < n; i++)
    {
        cnt[a[i]]++;

        /*
            当 i 向右扩展导致区间 a[i] 重复
            收缩左边界使区间中 a[i] 不重复
        */
        while(j <= i && cnt[a[i]] > 1)
        {
            cnt[a[j]]--;
            j++;
        }
        
        res = max(res, i - j + 1);
    }
    cout << res;
    return 0;
}
```

## 最长连续子序列

可以重复 但是子序列元素种数不能超过 $k$ 输出首尾下标

```c++
#include<bits/stdc++.h>
using namespace std;
const int N=5e5+10,;
int n,k;
int a[N],cnt[M];

int main()
{
    cin>>n>>k;
    
    for(int i=1;i<=n;i++) cin>>a[i];
    
    int res=0,l,r;
    for(int i=1,j=1,t=0;i<=n;i++)
    {
        if(cnt[a[i]]==0) t++;
        cnt[a[i]]++;
        
        while(t>k)
        {
            if(cnt[a[j]]==1) t--;
            cnt[a[j]]--;
            j++;
        }
        
        if(i-j+1>res)
        {
            res=i-j+1;
            l=j,r=i;
        }
    }
    cout<<l<<' '<<r;
    return 0;
}
```

## 数组元素的目标和

```cpp
#include <bits/stdc++.h>
using namespace std;

const int N = 1e5 + 10;
int a[N];
int b[N];
int main()
{
    int n, m, x;
    cin >> n >>m >> x;

    for(int i = 0; i < n; i++) cin >> a[i];
    for(int i = 0; i < m; i++) cin >> b[i];
    /*
        a 和 b 两个数组是升序的
        i 和 j 分别为两个数组的左、右指针
        单调性，i 向右走，必然使 j 向左走
    */
    for(int i = 0, j = m - 1, i < n; i++)
    {
        while(j > 0 && a[i] + b[j] > x) j--;
        if(a[i] + b[j] == x)
        {
            cout << i << ' ' << j;
            return 0;
        }
    }
    return 0;
}
```
