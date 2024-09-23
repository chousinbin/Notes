# Tire 字典树

**Tire 树**，又称单词查找树，是一种树形结构，是一种哈希树的变种。典型应用是用于统计，排序和保存大量的字符串（但不仅限于字符串），所以经常被搜索引擎系统用于文本词频统计。它的优点是：利用字符串的公共前缀来减少查询时间，最大限度地减少无谓的字符串比较，查询效率比哈希树高。

- 每条路径存储一个字符串；
- 引入布尔变量，标记每个字符串的结尾的节点，表示存在以当前结点为结尾的字符串；

![31041_aed49a42ad-Trie2](https://cdn.jsdelivr.net/gh/chousinbin/Image/202401290032400.PNG)

![未命名图片](https://cdn.jsdelivr.net/gh/chousinbin/Image/202401290032500.png)

## Tire 字符串统计

### 问题描述

维护一个字符串集合，支持两种操作：

1. `I x` 向集合中插入一个字符串 $x$；
2. `Q x` 询问一个字符串在集合中出现了多少次。

共有 $N$ 个操作，输入的字符串总长度不超过 $10$^5^，字符串仅包含小写英文字母。

#### 输入格式

第一行包含整数 $N$，表示操作数。

接下来 $N$ 行，每行包含一个操作指令，指令为 `I x` 或 `Q x` 中的一种。

#### 输出格式

对于每个询问指令 `Q x`，都要输出一个整数作为结果，表示 $x$ 在集合中出现的次数。

每个结果占一行。

#### 数据范围

$1≤N≤2∗10$^4^

### 问题解释

关于`son[N][26]`：`son`存储子结点的`id`、`i`是当前结点的`id`、`j`表示`26`个小写字母`0~25`。对于每个结点的`son`值可以得出，如果有值则有子结点并且提供位置，否则无子结点。

关于`cnt`：`cnt`存储以尾结点是`id`的字符串的个数。

关于`idx`：为每一个结点提供独一无二的`id`

效率问题：通过公用前缀来降低查询时间的开销以提高效率。

### 解题代码

```c++
#include<bits/stdc++.h>
using namespace std;

const int N = 1e5 + 10;

int son[N][26]; // 前缀树
int idx; // 前缀树结点的唯一标识
int cnt[N]; // 统计字符串的个数

void insert(string str)
{
    int p = 0; // 作为结点指针
    for(int i = 0; i < str.size(); i++)
    {
        // 取出字母
        int u = str[i] - 'a';
        // 如果树中不存在这个字母，创建这个字母
        if(!son[p][u]) son[p][u] = ++idx;
        // 更新当前尾结点的指针
        p = son[p][u];
    }
    // 尾指针作为前缀树中字符串的唯一标识
    cnt[p]++;
}

int query(string str)
{
    int p = 0;
    for(int i = 0; i < str.size(); i++)
    {
        int u = str[i] - 'a';
        // 树中没有字母串的任一字母，所以没有字符串
        if(!son[p][u]) return 0;
        p = son[p][u];
    }
    // 该字符串的个数
    return cnt[p];
}

int main()
{
    int n;
    cin >> n;
    
    while(n--)
    {
        string op, str;
        cin >> op >> str;
        
        if(op == "I") insert(str);
        else cout << query(str) << endl;
    }
    
    return 0;
}
```

## [208. 实现 Trie (前缀树)](https://leetcode.cn/problems/implement-trie-prefix-tree/)

**[Trie](https://baike.baidu.com/item/字典树/9825209?fr=aladdin)**（发音类似 "try"）或者说 **前缀树** 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。

请你实现 Trie 类：

- `Trie()` 初始化前缀树对象。
- `void insert(String word)` 向前缀树中插入字符串 `word` 。
- `boolean search(String word)` 如果字符串 `word` 在前缀树中，返回 `true`（即，在检索之前已经插入）；否则，返回 `false` 。
- `boolean startsWith(String prefix)` 如果之前已经插入的字符串 `word` 的前缀之一为 `prefix` ，返回 `true` ；否则，返回 `false` 。

#### **示例：**

```
输入
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
输出
[null, null, true, false, true, null, true]

解释
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // 返回 True
trie.search("app");     // 返回 False
trie.startsWith("app"); // 返回 True
trie.insert("app");
trie.search("app");     // 返回 True
```

#### **提示：**

- `1 <= word.length, prefix.length <= 2000`
- `word` 和 `prefix` 仅由小写英文字母组成
- `insert`、`search` 和 `startsWith` 调用次数 **总计** 不超过 `3 * 104` 次

### 代码

```cpp
class Trie {
public:
    struct Node {
        Node* sons[26];
        bool is_end;

        Node() {
            for (auto& c : sons) c = NULL;
            is_end = false;
        }
    }*root;

    Trie() {
        root = new Node();
    }
    
    void insert(string word) {
        auto p = root;
        for (int i = 0; i < word.size(); i++) {
            int u = word[i] - 'a';
            // 不存在就插入这个单词
            if (!p->sons[u]) p->sons[u] = new Node();
            // 结点下移
            p = p->sons[u];
        }
        // 标记结尾
        p->is_end = true;
    }
    
    bool search(string word) {
        auto p = root;
        for (int i = 0; i < word.size(); i++) {
            int u = word[i] - 'a';
            if (!p->sons[u]) return false;
            p = p->sons[u];
        }
        return p->is_end;
    }
    // 以 prefix 结尾为节点的子树存在
    bool startsWith(string prefix) {
        auto p = root;
        for (int i = 0; i < prefix.size(); i++) {
            int u = prefix[i] - 'a';
            if (!p->sons[u]) return false;
            p = p->sons[u];
        }
        // 能到达最后一个字符，说明至少当前是一个字符串
        // 或者还有更深的字符串
        // 两种情况都算是公共前缀
        return true;
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */
```

## 最大异或对？

#### 问题描述

在给定的 $N$ 个整数 $A1，A2……AN$ 中选出两个进行 $xor$（异或）运算，得到的结果最大是多少？

#### 输入格式

第一行输入一个整数 $N$。

第二行输入 NN 个整数 $A1$～$AN$。

#### 输出格式

输出一个整数表示答案。

#### 数据范围

$1≤N≤10$^5^
$0≤Ai<2$^31^



