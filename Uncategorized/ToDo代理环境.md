Windows在使用CFW代理时，会导致微软的ToDo等软件无法联网，通过一下操作，可以在代理环境正常使用ToDo

1. 获取uwp的DisplayName 或 SID

   Win + R: `C:\Users\%username%\AppData\Local\Packages`

2. 使用CheckNetIsolation将此UWP添入排除列表

   管理员身份打开PowerShell 执行 `checknetIsolation loopbackexempt -a -n="SID"`