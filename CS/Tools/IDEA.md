##  编辑快捷键

| 功能                     | 快捷键         |
| ------------------------ | -------------- |
| 删除当前行               | ctrl + Y       |
| 复制当前行               | ctrl + alt + d |
| 补全代码                 | alt + /        |
| 添加注释/取消注释        | ctrl + /       |
| 导入该行所需要的类       | alt + enter    |
| 运行程序                 | alt + R        |
| 格式化代码               | ctrl + alt + L |
| 光标在方法名上定位到方法 | ctrl + B       |
| 自动生成构造方法         | alt + insert   |
| 自动分配变量名           | .var           |
| 显示模板关键词           | Ctrl + J       |

## 模板关键词

| 模板                      | 关键词 |
| ------------------------- | ------ |
| main{}                    | main   |
| System.out.println();     | sout   |
| for(int i = 0; i < ; i++) | fori   |
|                           |        |
|                           |        |

#### 自定义模板快捷键

file -> setting -> editor -> live templates





## 断点调试

### 快捷键

| 快捷键      | 作用                     |
| ----------- | ------------------------ |
| F7          | 跳入方法                 |
| F8          | 逐行执行代码             |
| Shift  + F8 | 跳出方法                 |
| F9          | resume, 执行到下一个断点 |

### 技巧

1. 可以在Debug过程中动态的添加断点
1. 断点调试可以进入源码，帮助我们理解源码运作流程

### 显示完整数据

在展示 ArrayList 扩容时，调试发现扩容之后显示的数组没有显示后面的 null 数据，只显示非空数据，需要关闭下面选项，以显示完整的真实的数据。

1. 修改设置 setting -> Build, Execution, Deployment -> Debugger -> Data Viewer -> Java
2. 取消勾选 `Enable alternative view for Collections classes`
