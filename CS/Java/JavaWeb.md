# JavaWeb

# HTML

> Hyper Text Marked Language 超文本标记语言

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

# CSS

> Cascading Style Sheets 层叠样式表
>
> CSS 让 HTML 页面的内容和样式分离，降低耦合程度，提高 Web 开发效率。

## CSS 语法

- CSS 由**选择器**（元素、标签）和**声明**组成；
- 声明由属性和值组成，多个属性之间使用分号隔开；
- CSS 注释语法 /* 注释内容 */

## CSS 常用样式

### 字体颜色

颜色属性的值有三种写法：

1. 颜色的英文：red, orange, green
2. 颜色的十六进制：#FF0000
3. 颜色的RGB：rgb(255, 255, 255)

```html
<style type="text/css">
  div {
    /*color: red;*/
    /*color: #ff7d44;*/
    color: rgb(255, 255, 255);
  }
</style>
```

### 边框

boarder 属性有三个参数，分别为：边框宽度、边框样式、边框颜色。三个参数使用空格隔开。

```
<line-width> || <line-style> || <color>
<line-width> = <length [0,∞]> | thin | medium | thick
<line-style> = none | hidden | dotted | dashed | solid | double | groove | ridge | inset | outset
```

```html
<head>
    <meta charset="UTF-8">
    <title>边框</title>
  <style type="text/css">
    div {
      width: 300px;
      height: 100px;
      border: 10px dashed blue;
    }
  </style>
</head>
```

### 背景颜色

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>CSS 快速入门</title>
  	<!-- div 表示对 <div> 元素进行样式指定 -->
    <style type="text/css">
      div {
        width: 300px;
        height: 100px;
        background-color: orange;
      }
    </style>
</head>
<body>
  <div> hello Beijing </div>
  <br>
  <div> hello Nanjing </div>
</body>
</html>
```

### 字体样式

字体样式常用属性有：

1. font-size: 字体大小
2. font-weight: 字体是否加粗
3. font-family: 字体类型

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>字体样式</title>
    <style type="text/css">
        div {
            font-size: 36px;
            font-family: "fangsong";
            font-weight: bold;
        }
    </style>
</head>
<body>
<div> 周新斌</div>
</body>
</html>
```

### div 水平居中

 ```html
 <!DOCTYPE html>
 <html lang="en">
 <head>
     <meta charset="UTF-8">
     <title>div居中</title>
     <style type="text/css">
         div {
             margin-left: auto;
             margin-right: auto;
             height: 100px;
             width: 300px;
             border: 5px dashed red;
         }
     </style>
 </head>
 <body>
 <div> 周新斌</div>
 </body>
 </html>
 ```

### 文本水平居中

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>文本居中</title>
  <style type="text/css">
    div {
      text-align: center;
    }
  </style>
</head>
<body>
<div> 周新斌 </div>
</body>
</html>
```

### 超链接去下划线

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>超链接</title>
    <style type="text/css">
        a {
            text-decoration: none;
        }
    </style>
</head>
<body>
<a href="https://jd.com">跳转到京东</a>
</body>
</html>
```

### 表格

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>表格细线</title>
    <style type="text/css">
        /* 共用样式 */
        table, tr, td {
            width: 300px;
            border: 1px solid black;
            border-collapse: collapse;
            text-align: center;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <td> 1</td>
        <td> 2</td>
        <td> 3</td>
        <td> 4</td>
    </tr>
    <tr>
        <td> 苹果</td>
        <td> 杨桃</td>
        <td> 香蕉</td>
        <td> 李子</td>
    </tr>
</table>

</body>
</html>
```

### 无序列表去符号

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>无序列表去符号</title>
    <style type="text/css">
        ul {
            list-style: none;
        }
    </style>
</head>
<body>
<ul>
    <li> a</li>
    <li> b</li>
</ul>
</body>
</html>
```

## CSS 使用方式

1. 在标签的 style 属性上设置 CSS 样式
2. 在 head 标签中，使用 style 标签定义样式
3. 把 CSS 样式写成单独的 CSS 文件，在通过 link 标签引入

**CSS3.html**

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>link 引入 css</title>
    <link href="./CSS/use/my.css" rel="stylesheet"/>
</head>
<body>
<div> link 标签引入 CSS</div>
<br>
<span> hello, world</span>
</body>
</html>
```

**my.css**

```css
div {
    width: 400px;
    height: 200px;
    background-color: #ff7d44;
}

span {
    border: 2px dashed blue;
}
```

## CSS 选择器

### 元素选择器

元素选择器是最常见的选择器，CSS 元素选择器的元素/标签通常是 HTML 的某个元素或标签。

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>元素选择器</title>
    <style type="text/css">
        p {
            font-family: fangsong;
            font-size: 24px;
            color: red;
        }
      
        div {
            width: 300px;
            height: 100px;
        }
    </style>
</head>
<body>
<p>元素选择器会修饰所有的对应元素</p>
</body>
</html>
```

### ID 选择器

- ID 选择器为**特定元素**指定样式；
- ID 选择器用 #id 标记特定元素；
- ID 选择器不能重复，每个 ID 只能被使用一次；

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ID 选择器</title>
    <style type="text/css">
        #css1 {
            color: orange;
        }

        #css2 { 
            color: red;
        }
    </style>
</head>
<body>
<p id="css1"> hello</p>
<p id="css2"> world</p>
</body>
</html>
```

### 类选择器

 class 属性的值可以重复，每个 class 可以被多次使用。

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>类选择器</title>
    <style type="text/css">
        .css1 {
            color: red;
        }

        .css2 {
            color: orange;
        }
    </style>
</head>
<body>
<div class="css1"> zxb</div>
<div class="css1"> zxb zxb</div>
</body>
</html>
```

### 组合选择器

**组合选择器**让多个选择器共用一个 CSS 样式代码。

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>组合选择器</title>
    <style type="text/css">
        .css1, #css1 {
            width: 300px;
            height: 100px;
            color: red;
            background-color: cornflowerblue;
        }
    </style>
</head>
<body>
<div id=css1> zxb</div>
<br>
<div class=css1> zxb</div>
</body>
</html>
```

### 选择器优先级

1. 行内样式
2. ID 选择器
3. class 选择器
4. 元素选择器

# JavaScript

## 特点

1. 解释型脚本语言
2. 弱类型变量
3. 基于对象的脚本语言，可以创建对象，也可以使用现有的对象

## 使用方式

同一个 \<script> 标签中，两种方式只能生效一个，生效的是引入的 JS 代码

### \<script> 标签直接使用

```html
<head>
    <meta charset="UTF-8">
    <title>使用方式</title>
    <script type="text/javascript">
        console.log("在 script 中使用")
    </script>
</head>
<body>
<script type="text/javascript">
    console.log("在 body 中使用")
</script>
</body>
</html>
```

### \<script> 标签引入 JS 文件

```html
<head>
    <meta charset="UTF-8">
    <title>引入 js 文件</title>
    <script type="text/javascript" src="/JavaScript/script_use2.js"></script>
</head>
<body>

</body>
</html>
```

## 查看错误信息

浏览器打开 检查，console 栏报错信息；

![image-20250812140834155](https://cdn.jsdelivr.net/gh/chousinbin/Image/202508121408214.png)

可以在浏览器中定位错误代码。

![image-20250812140910255](https://cdn.jsdelivr.net/gh/chousinbin/Image/202508121409280.png)

## 数据类型

### 数据类型

| 数据类型 | 变量含义   |
| -------- | ---------- |
| number   | 数值类型   |
| string   | 字符串类型 |
| object   | 对象类型   |
| boolean  | 布尔类型   |
| function | 函数类型   |

### 特殊值

| 特殊值    | 含义                |
| --------- | ------------------- |
| undefined | 未赋值的初始值      |
| null      | 空值                |
| NaN       | Not a Number 非数值 |

### var let const

| 特性         | `var`                      | `let`                | `const`              |
| ------------ | -------------------------- | -------------------- | -------------------- |
| **作用域**   | 函数作用域                 | 块级作用域           | 块级作用域           |
| **变量提升** | 是（赋值前为 `undefined`） | 否（存在暂时性死区） | 否（存在暂时性死区） |
| **重复声明** | 允许                       | 不允许               | 不允许               |
| **可变性**   | 可变                       | 可变                 | 不可变（常量）       |

### 注意事项

- stirng 字符串可以使用单双引号；
- var 变量可以被多次声明，值不变；

## 运算符

### 算术运算符

同 Java

### 赋值运算符

同 Java

### 关系运算符

基本同 Java，多了一个 ===，意为全等（类型和值）

### 逻辑运算符

同 Java

- 所有变量都可以作为 boolean 类型使用，0 null undefined “” 都认为是 false。
- 对于 && 运算。
  - 表达式两边全真时，返回最后一个表达式的值。
  - 有一个为假，返回第一个为假的表达式的值。
- 对于 || 运算。
  - 表达式两边全假时，返回最后一个表达式的值。
  - 有一个为真，返回第一个为真的表达式的值。
- && 与 || 运算有 **短路** 现象：运算结果确定后，后面表达式不再进行。

### 条件运算符

同 Java

## 数组

### 定义数组

```js
// f1
let cars1 = ["BMW", "Benz", "Audi"];
console.log(cars1);
console.log(cars1[0]);

// f2
let cars2 = [];  // 空数组
cars2[0] = "BMW";
cars2[1] = "Benz";
cars2[2] = "Audi";
console.log(cars2);
console.log(cars2[1]);

// f3
let cars3 = new Array("BMW", "Benz", "Audi");
console.log(cars3);
console.log(cars3[2]);

// f4
let cars4 = new Array();
console.log("type of cars4 " + typeof cars4);
cars4[0] = "宝马";
cars4[1] = "奔驰";
cars4[2] = "奥迪";
cars4[3] = "沃尔沃";
console.log(cars4);
console.log(cars4[3]);
```

### 遍历数组

```javascript
console.log("type of cars4 " + typeof cars4);
cars4[0] = "宝马";
cars4[1] = "奔驰";
cars4[2] = "奥迪";
cars4[3] = "沃尔沃";
console.log(cars4);
for (let i = 0; i < cars4.length; i ++) {
  console.log(cars4[i]);
}
```

## 函数

函数是由事件驱动的，当他被调用时，执行可重复使用的代码块。

### 函数定义

```js
// 无参
function f1() {
    console.log("函数 f1 被调用");
}
f1();
// 有参数，无需定义参数类型
function f2(n1) {
    console.log(n1);
}
f2("123");
// 有参数和返回值，同样不需要定义返回类型
function f3(n1, n2) {
    return n1 + n2;
}
console.log(f3(1, 2));
```

### 函数赋值给变量

```js
let f4 = function () {
    console.log("hello");
}
console.log(typeof f4);
f4();

let f5 = f4;
f5();
```

### 函数调用

执行函数有两种方式，**主动调用** 或 **事件触发**。

```html
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>函数</title>
    <script type="text/javascript">
        function hi() {
          alert("hello world");
        }
        // 主动调用
        hi();
    </script>
</head>
<body>
<!-- 绑定点击事件触发 hi() 函数 -->
<button onclick="hi()">点我一下</button>
</body>
</html>
```

### 注意事项

- js 函数没有重载，重复定义会覆盖上一个函数定义。
- 函数带有隐藏参数 arguments，本质是一个对象数组。函数有形参的时候，在传入实参时按照顺序匹配：
  - 实参个数 >= 形参个数：匹配上的赋值，最后把所有实参赋值给 arguments。
  - 实参个数 < 形参个数：匹配上的赋值，多余形参为 undefined，所有赋给 arguments。

## 对象

### 使用 Object 定义

```js
let person = new Object();
person.name = "zxb";
person.age = 22;
person.say = function() {
  	console.log("hello" + this.name + " " + this.age);
};

person.say();
```

### 使用 {} 定义

```js
let objectName = {
		fielddName: fieldValue,
  	functionName: function() {
      	
    }
};

objectName.functionName();
objectName.fieldName;
```

## 事件

### 事件分类

| 事件类型 | 含义                                            |
| -------- | ----------------------------------------------- |
| onload   | 页面加载之后                                    |
| onclick  | 鼠标单击某个对象                                |
| onblur   | 失去焦点                                        |
| onchange | 内容发生改变                                    |
| onsubmit | 表单提交（**重要，form 表单提交前先 JS 校验**） |

### 动态注册

1. 获取标签对象/dom 对象
2. 标签对象.事件名 = function() {}

```js
// onload 页面加载完毕之后执行代码
window.onload = function () {
    console.log("动态绑定");
};
```

示例代码：

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>失去焦点-小写转大写</title>
    <script type="text/javascript">
        // 动态绑定
      	// 先等页面加载完毕，不然获取不到 id
        window.onload = function () {
            document.getElementById("ip2").onblur = function () {
                document.getElementById("ip2").value =
                    document.getElementById("ip2").value.toUpperCase();
            }
        }
    </script>
</head>
<body>
<input type="text" id="ip2"/>
</body>
</html>
```

### 静态注册

在 HTML 标签上绑定

```html
<body onload="init()">
```

示例代码：

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>失去焦点-小写转大写</title>
    <script type="text/javascript">
        // 静态绑定
        function upperCase() {
            document.getElementById("ip1").value =
                document.getElementById("ip1").value.toUpperCase();
        }
    </script>
</head>
<body>
<input type="text" id="ip1" onblur="upperCase()"/>
</body>
</html>
```

### 动态 VS 静态

| **对比项**   | 静态注册                            | 动态注册                              |
| ------------ | ----------------------------------- | ------------------------------------- |
| **绑定方式** | HTML 标签属性（如 `<body onload>`） | JavaScript 代码（如 `window.onload`） |
| **灵活性**   | 固定，不可修改                      | 可动态绑定/解绑                       |
| **事件覆盖** | 多次声明会覆盖                      | 可通过 `addEventListener` 避免覆盖    |
| **维护性**   | 较差（HTML 与 JS 混合）             | 较好（行为与结构分离）                |

# DOM

> Document Object Model 文档对象模型

DOM 是把文档中的标签、属性、文本等元素转换成对象来管理

```mermaid
graph LR
DOM --- HTML.DOM
DOM --- CSS.DOM
DOM --- XML.DOM
```

## HTML DOM 树

当页面被加载时，浏览器会创建页面的文档对象模型

```mermaid
graph TB
document --- HTML
HTML --- head
HTML --- body
head --- title
body --- a
body --- h1
body --- form
body --- ...
```

## Document 对象

当 HTML 文档加载到 Web 浏览器中时，它就变成了一个**文档对象**。

**文档对象**是 HTML 文档的根节点。

**文档对象**是*窗口对象*的属性。

### 常用方法

| 方法名                                                       | 作用                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| [getElementById()](https://www.w3school.com.cn/jsref/met_document_getelementbyid.asp) | 返回拥有指定值的 ID 属性的元素。                             |
| [getElementsByClassName()](https://www.w3school.com.cn/jsref/met_document_getelementsbyclassname.asp) | 返回包含拥有指定类名的所有元素的 [HTMLCollection](https://www.w3school.com.cn/jsref/dom_obj_htmlcollection.asp)。 |
| [getElementsByName()](https://www.w3school.com.cn/jsref/met_doc_getelementsbyname.asp) | 返回包含拥有指定名称的所有元素的活动 [NodeList](https://www.w3school.com.cn/jsref/dom_obj_html_nodelist.asp)。 |
| [getElementsByTagName()](https://www.w3school.com.cn/jsref/met_document_getelementsbytagname.asp) | 返回包含拥有指定标签名称的所有元素的 [HTMLCollection](https://www.w3school.com.cn/jsref/dom_obj_htmlcollection.asp)。 |
| [createElement()](https://www.w3school.com.cn/jsref/met_document_createelement.asp) | 创建元素节点。                                               |

## Elemment 对象

Element 对象代表 HTML 元素，如 P、DIV、A、TABLE 或任何其他 HTML 元素。

### 常用方法

| 方法名                                                       | 作用                                 |
| ------------------------------------------------------------ | ------------------------------------ |
| [childElementCount](https://www.w3school.com.cn/jsref/prop_element_childelementcount.asp) | 返回元素的子元素个数。               |
| [childNodes](https://www.w3school.com.cn/jsref/prop_node_childnodes.asp) | 返回元素子节点的 NodeList。          |
| [children](https://www.w3school.com.cn/jsref/prop_element_children.asp) | 返回元素的子元素的 HTMLCollection。  |
| [getElementsByClassName()](https://www.w3school.com.cn/jsref/met_element_getelementsbyclassname.asp) | 返回拥有给定类名的子元素的集合。     |
| [getElementsByTagName()](https://www.w3school.com.cn/jsref/met_element_getelementsbytagname.asp) | 返回拥有给定标签名称的子元素的集合。 |
| [innerHTML](https://www.w3school.com.cn/jsref/prop_html_innerhtml.asp) | 设置或返回元素的内容。               |
| [innerText](https://www.w3school.com.cn/jsref/prop_node_innertext.asp) | 设置或返回节点及其后代的文本内容。   |
| [parentNode](https://www.w3school.com.cn/jsref/prop_node_parentnode.asp) | 返回元素的父节点。                   |
| [parentElement](https://www.w3school.com.cn/jsref/prop_node_parentelement.asp) | 返回元素的父元素节点。               |

### 子元素与子节点区别

- **子节点**：元素节点、文本节点或注释节点（元素之间的**空白**、**换行符**也是文本节点）
- **子元素**：不返回文本节点和注释节点

# XML

> eXtensible Markup Language 可扩展标记语言

- XML 也可以看做树结构
- XML 旨在存储和传输数据
- XML 常用作配置文件

## XML 组成

- 序言
- 元素
- 属性
- 注释
- CDATA、特殊字符

## XML 命名规则

- 元素名称区分大小写
- 元素名称必须以字母或下划线开头
- 元素名称不能以字母 xml（或 XML、Xml 等）开头
- 元素名称可以包含字母、数字、连字符、下划线和句点
- 元素名称不能包含空格

注：使用数据库的名称规则来命名 XML 文档中的元素

## XML 语法

### 序言

- 序言包含XML规范和字符编码
- 是可选的；如果有，则必须在第一行

### 元素

- 每个 XML 文档 **有且只有** 一个根元素
- 元素要有始末标签，标签不能嵌套
- 多个空格会被视为一个空格
- 标签对大小写敏感

### 属性

- XML 元素可以在开始标签中包含属性，提供关于元素的额外信息。
- 属性值必须加引号，可单可双。

**属性与元素：**

- 属性不能包含多个值（元素可以）
- 属性无法描述树结构（元素可以）
- 属性不易扩展（为未来的变化）

### 注释

同 HTML 注释格式，不能嵌套。

### CDATA

XML 文档中的所有文本均会被解析器解析。只有 CDATA 区段中的文本会被解析器忽略。

```xml
<?xml version="1.0" encoding="utf-8" ?>

<![CDATA[
    <script>
        console.log("hello");
    </script>
]]>
```

### 转义字符

| 转义字符 | 符号 | 含义           |
| -------- | ---- | -------------- |
| \&lt;    | <    | less than      |
| \&gt;    | >    | greater than   |
| \&amp;   | &    | ampersand      |
| \&apos;  | '    | apostrophe     |
| \&quot;  | "    | quotation mark |

## XML 解析器

- [XML DOM（文档对象模型）](https://www.w3school.com.cn/xml/dom_intro.asp)定义了用于访问和编辑 XML 的属性和方法。
- 然而，在访问 XML 文档之前，必须将其加载到 XML DOM 对象中。
- 所有现代浏览器都提供内置的 XML 解析器，可以将文本转换为 XML DOM 对象。

### DOM4J

JDOM 在 DOM 基础上进行了封装，DOM4J 在 JDOM 基础上进行了封装。

### 获取 Document 对象

```java
@Test
public void loadXML() throws DocumentException {
    // 创建解析器
    SAXReader reader = new SAXReader();
    // XML Document
    Document document = reader.read(
            new File("/Users/sinpin/Desktop/GitHub/MyCode/JavaWeb/04XML/students.xml"));
    // 在此设置断点，执行调试，可以发现 Document 对象是一个树形结构，对应 XML 文件内容
    System.out.println(document);
}
```

### 遍历

```java
// 遍历 Students
@Test
public void listStudents() throws DocumentException {
    SAXReader reader = new SAXReader();
    Document document = reader.read(
            new File("/Users/sinpin/Desktop/GitHub/MyCode/JavaWeb/04XML/students.xml"));
    // 获取根节点
    Element rootElement = document.getRootElement();
    // 获取根节点的子节点
    List<Element> student = rootElement.elements("student");
    // 输出信息
    System.out.println(student.size());
    for (Element o : student) {
        Element name = o.element("name");
        Element gender = o.element("gender");
        Element age = o.element("age");
        System.out.println(name.getText() + " " + age.getText() + " " + gender.getText());
    }
}
```

XPath 可以更方便的读取元素值，避免层层遍历。

### 添加

```java
@Test
public void addStudent() throws DocumentException, IOException {
    SAXReader reader = new SAXReader();
    Document document = reader.read(
            new File("/Users/sinpin/Desktop/GitHub/MyCode/JavaWeb/04XML/students.xml"));
    // 在内存中添加节点
    Element student = DocumentHelper.createElement("student");
    student.addAttribute("id","03");

    Element name = DocumentHelper.createElement("name");
    name.setText("宋江");
    student.add(name);

    Element gender = DocumentHelper.createElement("gender");
    gender.setText("男");
    student.add(gender);

    Element age = DocumentHelper.createElement("age");
    age.setText("55");
    student.add(age);

    document.getRootElement().add(student);

    // 解决乱码
    OutputFormat outputFormat = OutputFormat.createPrettyPrint();
    outputFormat.setEncoding("UTF-8");
    // XML 文件更新
    XMLWriter xmlWriter = new XMLWriter(
            new FileOutputStream(
                    new File("/Users/sinpin/Desktop/GitHub/MyCode/JavaWeb/04XML/students.xml")), outputFormat);
    xmlWriter.write(document);
    xmlWriter.close();
    // 遍历
    listStudents();
}
```

### 删除

1. 先找到被删除的元素
2. 再找到该元素的父元素
3. 通过父元素删除子元素

```java
@Test
public void removeStudent() throws DocumentException, IOException {
    SAXReader reader = new SAXReader();
    Document document = reader.read(
            new File("/Users/sinpin/Desktop/GitHub/MyCode/JavaWeb/04XML/students.xml"));

    Element rootElement = document.getRootElement();
    List<Element> student = (List<Element>) rootElement.elements("student");
    Element element = student.get(0);
    element.getParent().remove(element);
    // 解决乱码
    OutputFormat outputFormat = OutputFormat.createPrettyPrint();
    outputFormat.setEncoding("UTF-8");
    // XML 文件更新
    XMLWriter xmlWriter = new XMLWriter(
            new FileOutputStream(
                    new File("/Users/sinpin/Desktop/GitHub/MyCode/JavaWeb/04XML/students.xml")), outputFormat);
    xmlWriter.write(document);
    xmlWriter.close();
    // 遍历
    listStudents();
}
```

### 更新

1. 先找到被修改的元素
2. 修改元素属性

```java
@Test
public void updateStudent() throws DocumentException, IOException {
    SAXReader reader = new SAXReader();
    Document document = reader.read(
            new File("/Users/sinpin/Desktop/GitHub/MyCode/JavaWeb/04XML/students.xml"));

    Element rootElement = document.getRootElement();
    List<Element> students = (List<Element>) rootElement.elements("student");
    Element student = students.get(0);
    int age = Integer.parseInt(student.element("age").getText());
    age += 3;
    student.element("age").setText(String.valueOf(age));
    // 解决乱码
    OutputFormat outputFormat = OutputFormat.createPrettyPrint();
    outputFormat.setEncoding("UTF-8");
    // XML 文件更新
    XMLWriter xmlWriter = new XMLWriter(
            new FileOutputStream(
                    new File("/Users/sinpin/Desktop/GitHub/MyCode/JavaWeb/04XML/students.xml")), outputFormat);
    xmlWriter.write(document);
    xmlWriter.close();
    // 遍历
    listStudents();
}
```

# Tomcat

## URL 请求过程

```mermaid
sequenceDiagram
    participant User as 用户/浏览器
    participant DNS as DNS服务器
    participant Server as 目标服务器
    participant CDN as CDN节点（可选）

    User->>DNS: 1. DNS查询（www.example.com）
    DNS-->>User: 2. 返回IP地址（如 93.184.216.34）
    
    alt 使用CDN
        User->>CDN: 3. 请求资源（HTTP GET /）
        CDN-->>User: 4. 返回缓存内容
    else 直连服务器
        User->>Server: 3. TCP三次握手
        User->>Server: 4. HTTPS TLS握手（如https）
        User->>Server: 5. HTTP请求（GET /）
        Server-->>User: 6. HTTP响应（HTML/CSS/JS等）
    end
```

## DNS 解析过程

```mermaid
sequenceDiagram
    participant User as 用户/应用
    participant Browser as 浏览器/App缓存
    participant System as 系统缓存/Hosts
    participant ManualDNS as 手动DNS (8.8.8.8)
    participant RouterDNS as 路由器DNS
    participant Recursive as 递归查询 (根→TLD→权威)

    User->>Browser: 1. 发起DNS查询 (example.com)
    alt 浏览器/App缓存命中
        Browser-->>User: 2. 直接返回缓存IP
    else 未命中
        Browser->>System: 3. 检查系统缓存/Hosts
        alt 系统缓存/Hosts命中
            System-->>User: 4. 返回IP
        else 未命中
            alt 手动配置了DNS?
                System->>ManualDNS: 5. 向手动DNS (8.8.8.8) 查询
                ManualDNS->>Recursive: 6. 递归查询 (根→TLD→权威)
                Recursive-->>ManualDNS: 7. 返回IP
                ManualDNS-->>User: 8. 返回IP并缓存
            else 使用路由器DNS
                System->>RouterDNS: 5. 向路由器DNS查询
                RouterDNS->>Recursive: 6. 递归查询 (根→TLD→权威)
                Recursive-->>RouterDNS: 7. 返回IP
                RouterDNS-->>User: 8. 返回IP并缓存
            end
        end
    end

```

## IDEA 创建 Web 项目

1. 新建一个普通 Java 项目
2. 打开项目设置，添加 Web 模块，设置对应工件
3. 配置 Tomcat，配置 Tomcat 的 Deployment









