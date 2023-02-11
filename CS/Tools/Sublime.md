### sublime text 3

#### 安装及汉化

1. 官网下载 无限试用 [下载链接](http://www.sublimetext.com/3)
2. 打开查找栏 CTRL+SHIFT+P，输入关键字install，选择Install Package，点完无反应，成功后有弹框。
3. 接着在查找栏输入Chinese，选择ChineseLocalizations

#### 配置语言环境

1. 新建编译系统，填写相应环境的配置代码，保存到`C:\Users\ChouS\AppData\Roaming\Sublime Text 3\Packages\User`目录。

2. C++

   ```json
   {
   	"encoding": "gbk",//一定要是GBK！！不然原文报错（Error Inline）不会显示
   	// "encoding": "utf-8",
   	"working_dir": "$file_path",
   	"shell_cmd": "g++ -Wall -std=c++11 \"$file_name\" -o \"$file_base_name\"",
   	"file_regex": "^(..[^:]*):([0-9]+):?([0-9]+)?:? (.*)$",
   	"shell": true,
   	"selector": "source.c++",
   	"variants": 
   	[
   		{
   			//没有警告的
   			"name": "Run",
   			"shell_cmd": "g++ -std=c++11  \"$file\" -o \"${file_base_name}.exe\" && start cmd /c \"\"${file_path}/${file_base_name}\" &echo / = = = E N D = = = / & pause\""
   		},
   		{
   			//有警告的
   			"name": "Run - with alarm",
   			"shell_cmd": "g++ -Wall -std=c++11  \"$file\" -o \"${file_base_name}.exe\" && start cmd /c \"\"${file_path}/${file_base_name}\" &echo / = = = E N D = = = / & pause\""
   		}
   	]
   }
   
   
   ```

3. Javac

   ```json
   {
       "cmd": ["javac","-d",".","$file"],
       "file_regex": "^(...*?):([0-9]*):?([0-9]*)",
       "selector": "source.java",
       "encoding":"cp936",
       //执行完上面的命令就结束
       // 下面的命令需要按Ctrl+Shift+b来运行
       "variants":
       [
           {
               "name": "Run",
               "shell": true,
               "cmd" : ["start","cmd","/c", "java ${file_base_name} &echo. & pause"],
               //c是执行完命令后关闭cmd窗口,
               //k是执行完命令后不关闭cmd窗口。
               // echo. 相当于输入一个回车
               // pause命令使cmd窗口按任意键后才关闭
               "working_dir": "${file_path}",
               "encoding":"cp936"
           }
       ]
   }
   ```

