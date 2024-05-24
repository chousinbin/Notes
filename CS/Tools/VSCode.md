# Vscode C++

## 修改.exe生成位置

### 文件建立

现在关闭Vscode，在桌面新建一个文件夹，命名随意，然后直接拖拽到Vscode图标处打开，这个文件就是我们的工作区。

打开之后我们新建文件夹 **Demo** ，其下新建文件 **Hello.c** ，输入代码以便我们后续测试

```c++
#include <stdio.h>
int main()
{
    printf("Hello world");
    return 0;
}
```

点击左侧的调试按钮->创建`launch.json`文件 

![1620](https://cdn.jsdelivr.net/gh/chousinbin/Image/%E5%88%9B%E5%BB%BAlaunch.json%E6%96%87%E4%BB%B6.png)

选择`C++(GDB/LLDB)` 

![](https://cdn.jsdelivr.net/gh/chousinbin/Image/选择C++GDB.png)

 选择`gcc.exe-生成和调试活动文件` 

![](https://cdn.jsdelivr.net/gh/chousinbin/Image/选择gcc.exe-生成调试文件.png)

 返回工作区文件目录，发现生成了.vscode文件夹，`tasks`用于编译，`launch`用于执行编译后的文件。



### 重定向

为了方便大家修改，直接给出文件，修改位置有特殊标注。可以使用Ctrl+F组合键搜索，简单粗暴的可以直接删除生成的文件内容，复制下面对应文件操作。

#### tasks.json

```javascript
{
    "tasks": [
        {//构建配置项
            "type":"shell",//任务类型,Vscode将预定义变量转义解析后直接传给command;shell->先打开shell再输入命令,因此args会经过shell再次解析
            "label": "C/C++: gcc.exe 生成活动文件",//任务名称
            "command": "C:\\Program Files\\mingw64\\bin\\gcc.exe",//本地编译器路径
            "args": [ //包含传给gcc命令的参数,用于实现特定功能
                "-g", //生成和调试有关的信息
                "${file}", //指定编译文件为当前文件
                "-o",//指定输出文件的路径和名称
                "${workspaceFolder}\\build\\${fileBasenameNoExtension}.exe"//修改.exe文件生成位置
            ],
            "options": {
                "cwd": "C:\\Program Files\\mingw64\\bin"
            },
            "problemMatcher": [
                "$gcc"
            ],
            "group": {//包含很多task,归为group
                "kind": "build",//表名该组任务类型是构建
                "isDefault": true//表明此任务为此组任务中的默认任务
            },
            "detail": "调试器生成的任务。"
        }
    ],
    "version": "2.0.0"
}
```

（1）将命令

```c++
"${fileDirname}\\${fileBasenameNoExtension}.exe"
```

替换为

```c++
"${workspaceFolder}\\build\\${fileBasenameNoExtension}.exe"
```

（2）将命令

```c++
"cwd": "${fileDirname}"
```

替换为

```c++
"cwd": "C:\\Program Files\\mingw64\\bin"
```

#### launch.json

```javascript
{
    "version": "0.2.0",
    "configurations": [
        {//包含Debug配置
            "name": "gcc.exe - 生成和调试活动文件",//配置名称
            "type": "cppdbg", //配置类型,对应cpptools提供的调试功能
            "request": "launch", //请求配置类型,可以是启动/附加类型[launch/attach]
            "program": "${workspaceFolder}\\build\\${fileBasenameNoExtension}.exe",//待调试程序本地路径
            "args": [], //程序调试时传递给程序的命令行参数,设为空值
            "stopAtEntry": false,//改为true时程序暂停在程序入口位置,即main处打上断点
            "cwd": "${fileDirname}", //调试程序时的工作目录,这里表示源码目录
            "environment": [], //环境变量,设为空值
            "externalConsole": false, //true:cmd窗口; false:Vscode的内置终端输出
            "MIMode": "gdb", //指定连接的调试器,minGW64中调试程序->gdb
            "miDebuggerPath": "C:\\Program Files\\mingw64\\bin\\gdb.exe", //指定调试器所在路径,安装位置不同注意需要修改,间隔为\\
            "setupCommands": [
                {
                    "description": "为 gdb 启用整齐打印",
                    "text": "-enable-pretty-printing",
                    "ignoreFailures": true
                }
            ],
            "preLaunchTask": "C/C++: gcc.exe 生成活动文件" //调试开始前执行需要执行的任务,调试前要编译构建 名称要和tasks.json的label保持一致
        }
    ]
}
```

将命令

```javascript
"program": "${fileDirname}\\${fileBasenameNoExtension}.exe",
```

替换为

```javascript
"program": "${workspaceFolder}\\build\\${fileBasenameNoExtension}.exe",
```



#### Code Runner

点击`Edit in settings.json`打开配置项，由于Code Runner中配置文件较多，我们只修改相关部分即可 

![](https://cdn.jsdelivr.net/gh/chousinbin/Image/202207181607668.png)

 （1）将命令

```javascript
"c": "cd $dir && gcc $fileName -o $fileNameWithoutExt && $dir$fileNameWithoutExt", 
```

复制替换为

```javascript
"c": "cd $dir && gcc $fileName -o $workspaceRoot/build/$fileNameWithoutExt && $workspaceRoot/build/$fileNameWithoutExt",
```

（2）将命令

```javascript
"cpp": "cd $dir && g++ $fileName -o $fileNameWithoutExt && $dir$fileNameWithoutExt", 
```

复制替换为

```json
"cpp": "cd $dir && g++ $fileName -o $workspaceRoot/build/$fileNameWithoutExt && $workspaceRoot/build/$fileNameWithoutExt", 
```

最后在工作区新建文件夹**build**，作为**Test**文件子项，确定好文件从属关系。 

![](https://cdn.jsdelivr.net/gh/chousinbin/Image/202207181604118.png)

### 测试

![](https://cdn.jsdelivr.net/gh/chousinbin/Image/202207181605389.gif)

![](https://cdn.jsdelivr.net/gh/chousinbin/Image/202207181605600.png)

原帖：https://cloud.tencent.com/developer/article/2015634

## 指定位置保存编译生成的可执行文件

如图所示, 项目目录为algorithm, exe文件统一生成后存放在algorithm/build/中, 可在主目录任意创建子目录保存cpp源文件

<img src="https://cdn.jsdelivr.net/gh/chousinbin/Image/202311040001985.png" alt="image-20231104000133895" style="zoom: 50%;" />

#### 实现

通过在.vscode中的setting.json中添加字段

```json
"code-runner.executorMap":{
    "cpp": "cd $dir ; g++ $fileName -o d:\\Github\\Notes\\code\\algorithm\\build\\$fileNameWithoutExt ; d:\\Github\\Notes\\code\\algorithm\\build\\$fileNameWithoutExt",
}
```

其中:

`cd $dir`切换到当前源文件所在目录

`g++ $fileName -o`编译当前源文件

第一个`d:\\Github\\Notes\\code\\algorithm\\build\\$fileNameWithoutExt`表明exe文件输出的位置

第二个`d:\\Github\\Notes\\code\\algorithm\\build\\$fileNameWithoutExt`表明要打开的exe文件

#### 完整setting.json

```json
{
    "files.associations": {
        "iostream": "cpp",
        "ostream": "cpp",
        "random": "cpp",
        "array": "cpp",
        "bitset": "cpp",
        "string_view": "cpp",
        "initializer_list": "cpp",
        "regex": "cpp",
        "utility": "cpp",
        "valarray": "cpp",
        "*.tcc": "cpp",
        "type_traits": "cpp",
        "atomic": "cpp",
        "cctype": "cpp",
        "cfenv": "cpp",
        "charconv": "cpp",
        "chrono": "cpp",
        "cinttypes": "cpp",
        "clocale": "cpp",
        "cmath": "cpp",
        "codecvt": "cpp",
        "complex": "cpp",
        "condition_variable": "cpp",
        "csetjmp": "cpp",
        "csignal": "cpp",
        "cstdarg": "cpp",
        "cstddef": "cpp",
        "cstdint": "cpp",
        "cstdio": "cpp",
        "cstdlib": "cpp",
        "cstring": "cpp",
        "ctime": "cpp",
        "cuchar": "cpp",
        "cwchar": "cpp",
        "cwctype": "cpp",
        "deque": "cpp",
        "forward_list": "cpp",
        "list": "cpp",
        "unordered_map": "cpp",
        "unordered_set": "cpp",
        "vector": "cpp",
        "exception": "cpp",
        "algorithm": "cpp",
        "functional": "cpp",
        "iterator": "cpp",
        "map": "cpp",
        "memory": "cpp",
        "memory_resource": "cpp",
        "numeric": "cpp",
        "optional": "cpp",
        "ratio": "cpp",
        "set": "cpp",
        "string": "cpp",
        "system_error": "cpp",
        "tuple": "cpp",
        "fstream": "cpp",
        "future": "cpp",
        "iomanip": "cpp",
        "iosfwd": "cpp",
        "istream": "cpp",
        "limits": "cpp",
        "mutex": "cpp",
        "new": "cpp",
        "scoped_allocator": "cpp",
        "shared_mutex": "cpp",
        "sstream": "cpp",
        "stdexcept": "cpp",
        "streambuf": "cpp",
        "thread": "cpp",
        "typeindex": "cpp",
        "typeinfo": "cpp"
    },
    "C_Cpp.errorSquiggles": "disabled",
    "code-runner.executorMap":{
        "javascript": "node",
        "java": "cd $dir ; javac $fileName ; java $fileNameWithoutExt",
        "c": "cd $dir ; gcc $fileName -o $fileNameWithoutExt ; $dir$fileNameWithoutExt",
        "cpp": "cd $dir ; g++ $fileName -o d:\\Github\\Notes\\code\\algorithm\\build\\$fileNameWithoutExt ; d:\\Github\\Notes\\code\\algorithm\\build\\$fileNameWithoutExt",
        "objective-c": "cd $dir ; gcc -framework Cocoa $fileName -o $fileNameWithoutExt ; $dir$fileNameWithoutExt",
        "php": "php",
        "python": "python -u",
        "perl": "perl",
        "perl6": "perl6",
        "ruby": "ruby",
        "go": "go run",
        "lua": "lua",
        "groovy": "groovy",
        "powershell": "powershell -ExecutionPolicy ByPass -File",
        "bat": "cmd /c",
        "shellscript": "bash",
        "fsharp": "fsi",
        "csharp": "scriptcs",
        "vbscript": "cscript //Nologo",
        "typescript": "ts-node",
        "coffeescript": "coffee",
        "scala": "scala",
        "swift": "swift",
        "julia": "julia",
        "crystal": "crystal",
        "ocaml": "ocaml",
        "r": "Rscript",
        "applescript": "osascript",
        "clojure": "lein exec",
        "haxe": "haxe --cwd $dirWithoutTrailingSlash --run $fileNameWithoutExt",
        "rust": "cd $dir ; rustc $fileName ; $dir$fileNameWithoutExt",
        "racket": "racket",
        "ahk": "autohotkey",
        "autoit": "autoit3",
        "dart": "dart",
        "pascal": "cd $dir ; fpc $fileName ; $dir$fileNameWithoutExt",
        "d": "cd $dir ; dmd $fileName ; $dir$fileNameWithoutExt",
        "haskell": "runhaskell",
        "nim": "nim compile --verbosity:0 --hints:off --run",
        "lisp": "sbcl --script",
        "kit": "kitc --run"
    }
}
```

## Code Runner无法输入问题

1. `Ctrl` + `,` 打开设置
2. 搜索：“code runner'”
3. 找到：“code-runner: run in terminal”
4. 勾选
