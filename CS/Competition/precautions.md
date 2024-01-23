# OI 注意事项

#### 返回 0

main 函数 `return 0;`。

#### 数据溢出

```cpp
// 注意：此方法会替换掉 main() 函数的返回值 int 类型
#define int long long
// 需要换成 signed
signed main() {}
```

```cpp
// 此方法则不需要
typedef long long ll;
```

#### 输入输出速度

1. 【最快】：用 C 的输入输出。

2. 【稍快】：用 CPP 的输出输出，加上关流代码，此时 `cout `不能使用 `endl`。

   ```cpp
   #define endl '\n'
   int main()
   {
   	ios::sync_with_stdio(0);
       cin.tie(0);
       cout.tie(0);
   }
   ```

3. 【稍慢】：纯 CPP 的输入输出。

