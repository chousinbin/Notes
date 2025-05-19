# JavaWeb

# HTML

## 标签和元素

- 标签：用尖括号括起来 <>，一般为双标签\<html> \</html>，也有单标签 \<br/>
- 元素：尖括号括起来的叫元素

## 标签细节

- 标签不能交叉嵌套
- 注释不能嵌套
- 标签必须正确关闭
- HTML 语法严谨性：标签闭合、属性加双引号

## 字体标签

font 标签有三个基本属性：

1. size 字体大小
2. color 字体颜色
3. face 字体类型

## 字符实体

字符实体把符号转化为**文本**

| 显示结果 | 实体名称 | 实体编号 |
| -------- | -------- | -------- |
| 空格     | \&nbsp;  |          |
| <        | \&lt;    |          |
| >        | \&gt;    |          |
| &        | \&amp;   |          |
| "        | \&quot;  |          |
| '        | \&apos;  |          |

## 标题标签

\<h1> ~ \<h6> 从大到小

| 属性  | 作用     | 值                |
| ----- | -------- | ----------------- |
| align | 对齐方式 | left right center |

## 超链接标签

本标签页打开

```html
<a href="https://bing.com" target="_self">必应</a>
```

新标签页打开

```html
<a href="https://bing.com" target="_blank">必应 </a>
```

邮箱地址

```html
<a href="mailto:tom@163.com">联系邮箱</a>
```

## 列表标签

### 无序列表 ul

```html
<ul type="无序类型">
  <li>列表内容</li>
  <li>...</li>
</ul>
```

- disc 实心圆
- circle 空心圆
- square 空心正方形

### 有序列表 ol

```html
<ol type="有序类型" start="1">
  <li>...</li>
</ol>
```

1. A
2. a
3. 1
4. i
5. I

默认从第一个开始

## 图像标签

```html
<img src="资源路径" width="" height="" board = "px" alt="">
```

- src 绝对路径和相对路径，绝对路径使用 URL 访问而不是盘符定位
- 仅指定高度或宽度，另一边会根据宽高比缩放
- board 边框厚度
- alt 图片找不到时提示的文字 

## 表格标签

常用标签：

- \<tr> 代表行，列数由 \<th>/\<td> 决定
- \<th> 代表表头单元格
- \<td> 代表普通单元格

常用属性：

- cellspacing 单元格间距
- cellpadding 单元格内容与边框的距离
- align 水平对齐方式
- border 边框宽度
- bordercolor 边框颜色

### 普通表格

```html
<table width="500" board="5" align="center">
  <tr>
    <th>Name</th>
    <th>Phone</th>
  </tr>
  <tr>
    <td>zxb</td>
    <td>19990079994</td>
  </tr>
</table>
```

### 跨行跨列

```html
<table border="5" bordercolor="red" align="center" width="500">
    <tr>
        <td colspan="3" align="center">合并3列</td>
    </tr>
    <tr>
        <td rowspan="2">合并两行，占位下n-1行</td>
        <td>2,2</td>
        <td>2,3</td>
    </tr>
    <tr>
        <td>3,2</td>
        <td>3,3</td>
    </tr>
    <tr>
        <td rowspan="2">4,1</td>
        <td>4,2</td>
        <td>4,3</td>
    </tr>
    <tr>
        <td>5,2<img src="img.png" width="100"></td>
        <td>5,3</td>
    </tr>
</table>
```

## 表单标签

### form

- action 表单提交的目标 URL 位置
- method 提交主要方法：GET 和 POST

### input

- text
- password
- submit
- reset checked 默认选项
- checkbox 复选框
- radio 单选框
- **hidden 隐藏元素：用于隐式向服务器提交必要信息**
- file 文件

```html
<form action="ok.html" method="get">
    用户: <input type="text" name="username"><br>
    密码: <input type="password" name="password"><br>
    <input type="checkbox" name="1" value="xj">香蕉
    <input type="checkbox" name="1" value="pg" checked>苹果<br>
    <input type="radio" name="2" value="sj">phone
    <input type="radio" name="2" value="dn" checked>computer<br>
    <input type="hidden" name="id" value="001">
    <input type="submit" name="submit" value="登陆">
    <input type="reset" name="reset" value="清空"><br>
    <input type="image" name="submit" src="img.png">   
</form>
```

### 下拉列表

```html
<select name="like">
    <option value="游戏" selected>游戏</option>
    <option value="篮球">篮球</option>
    <option value="网球">网球</option>
</select>
```

### 文本域

```html
<textarea name="comment" rows="4" cols="25"></textarea>
```

### 表单美化

元素嵌套在 table 内

### GET 与 POST 的区别

1. GET 地址栏显示参数名和值，POST 只显示Action 值
2. GET 数据有长度限制
3. POST 安全

## div 标签

- \<div> 标签可以把文档分割为独立不同的部分
- \<div> 是一个块级元素，他会自动从下一行开始

```html
<div style:color=red>
  
</div>
```

## p 标签

段落元素，会自动在段前段后创建空白

## span 标签

内联元素，没有换行效果

```html
您的购物车有<span style="color: red;font-size: 40px">10</span>个商品
```











