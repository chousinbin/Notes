1. 首先普通用户先登陆[路由器](https://link.zhihu.com/?target=http%3A//www.ibolg.net/tag/%E8%B7%AF%E7%94%B1%E5%99%A8)（普通权限）

   打开浏览器，输入地址192.168.1.1，先使用路由器后面的账号密码如useradmin+密码（猫的背面有密码）登陆到路由器中。

2. 打开Telnet功能：（1.找到控制面板并双击进去,2.进到控制面板,点击”程序与功能“3.进到”程序与功能“界面,点击“启动或关闭Windows功能”4.弹出“启动或关闭Windows功能”界面,勾选telnet客户端,点击确定）

   登陆路由器之后打开这个地址[http://192.168.1.1/cgi-bin/getGateWay.cgi](https://link.zhihu.com/?target=http%3A//192.168.1.1/cgi-bin/getGateWay.cgi)，，页面返回Yes字样一般即为成功，我这里返回的是：Family GateWay

   Yes

3. 连接并登陆Telnet

   打开成功后使用Telnet连接工具连接到路由器

```shell
telnet 192.168.1.1
```

然后输入账号密码admin s2@We3%Dc#

如果登陆后界面一般显示# 就是成功

4.接着查看密码

登陆成功后输入cat /tmp/ctromfile.cfg | grep 'Admin' 就可以查看超级管理员的密码

如我这里返回

```shell
# cat /tmp/ctromfile.cfg | grep 'Admin'

<Entry0 Active="Yes" username="CMCCAdmin"

web_passwd="CMCCAdmin"
```

其中的username=后面的就是管理员账号，一般为CMCCAdmin，web_passwd=后面的就是密码，这里对应的是CMCCAdmin，注意不要带引号。

&amp;amp等于&

5.完成

然后打开192.168.1.1重新登陆就可以看到管理员的界面啦！