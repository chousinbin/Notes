# Linux



## 1.Linux介绍

#### Linux应用场景

Linux运维工程师：服务器规划、调试优化、系统进程监控、故障处理

Linux嵌入式工程师

Linux下开发项目：JavaEE、大数据、Python、PHP、Ｃ/C++

#### Linux应用领域

个人桌面：最弱的领域

**服务器领域**：最强大的应用领域

嵌入式领域：运行稳定、对网络良好支持、低成本、内核最小可以裁剪到几百KB

#### Linux吉祥物

Tux企鹅

<img src="https://cdn.jsdelivr.net/gh/chousinbin/Image/format,f_jpg.jpeg" alt="Tux" style="zoom: 33%;" />

#### Linux作者

Linux Torvalds，Git作者、Linux作者、世界著名黑客。

#### Linux主要发行版

1. Ubuntu乌班图
2. RedHat红帽
3. CentOS（Redhat分支）
4. Debain蝶变
5. Fedora
6. SuSE
7. OPenSUSE

#### Linux特点

1. 免费
2. 稳定
3. 高效

#### Linux与Unix的关系

在20世纪70年代从贝尔实验室联合麻省理工和通用公司计划设计一个多用户分时系统，项目名称为multics，但是因为种种原因导致此项目被搁置。1969，Kenneth tompson，用B语言在multics基础上设计出来了第一代的Unix。1974年，Kenneth Thompson和Dennis Ritchie合写Unix。

IBM、SUN、HP三家公司设计了Unix的发行版本，Richard Stallman发现在当时发行版本的Unix只能在高性能的服务器主机上运行，普通PC无法运行。他发起了GNU计划（开源精神），目的是让更多的人能够使用Unix系统。



## 2.Linux安装

### 2.1虚拟机安装

VMware[下载地址](https://download3.vmware.com/software/wkst/file/VMware-workstation-full-16.1.2-17966106.exe)

可能某些电脑运行VM虚拟机需要先在BIOS设置开启虚拟化设备支持。

激活码：ZF71R-DMX85-08DQY-8YMNC-PPHV8

#### 虚拟机克隆

在原虚拟机关机的状态下，在VM软件中右击虚拟机名，选择克隆，进行虚拟机克隆。特点是克隆的虚拟系统与原系统内容完全相同，不需要从头开始镜像安装。另外，虚拟机的根文件夹的克隆不仅可以同设备进行，也可以跨设备克隆。

#### 虚拟机快照

虚拟机快照就类似于版本存档，在虚拟机的某个时间节点设置一个快照，在后期阶段出现系统异常是我们就可以回退到之前的快照。快照之间可以任意穿梭。

![](https://cdn.jsdelivr.net/gh/chousinbin/Image/虚拟机快照.png)

#### 虚拟机删除与迁移

删除：先从VM软件右击移除，再从磁盘把虚拟系统根文件夹删除。

迁移：直接迁移虚拟系统根文件夹。

#### 共享文件夹

安装vmtools，实现主机与虚拟机的文件进行互通。需要内置`gcc`。

1. 从虚拟机菜单右击安装vm-tools

   ![image-20220719133315360](https://cdn.jsdelivr.net/gh/chousinbin/Image/%E5%AE%89%E8%A3%85vm-tools.png)

2. 把桌面VMware Tools里面的`.gz`压缩包复制到根目录的`opt`文件夹下

3. 打开终端进入到`opt`文件夹目录

   `cd`空格后紧挨着的`/`的意思为根目录

   ```bash
   [root@bogon opt]# cd /opt
   [root@bogon opt]# ls
   rh  VMwareTools-10.3.23-17030940.tar.gz
   ```

4. 解压命令

   ```
   tar -zxvf 文件名
   ```

   ```bash
   [root@bogon opt]# tar -zxvf VMwareTools-10.3.23-17030940.tar.gz 
   [root@bogon opt]# ls
   rh  VMwareTools-10.3.23-17030940.tar.gz  vmware-tools-distrib
   ```

   解压命令输入到VM时，按`Tab`可以根据前缀VM自动补全文件名。

5. 进入解压后的文件夹目录

   ```shell
   [root@bogon opt]# cd vmware-tools-distrib/
   [root@bogon vmware-tools-distrib]# 
   [root@bogon vmware-tools-distrib]# ls
   bin  doc  etc  FILES  INSTALL  installer  lib  vgauth  vmware-install.pl
   ```

6. 安装

   ```
   ./文件名
   ```

   ```
   ./vmware-install.pl
   一顿回车
   ```

7. 从虚拟系统设置里面打开并配置好共享文件夹路径

8. Linux内共享文件夹的路径

   ```shell
   # cd /mnt/hgft/
   ```

注意：此种主机与Linux系统共享文件仅适用于两个系统在同一台主机上。当Linux系统在远程时，我们需要远程登陆Linux，使用网络进行上传下载的传输文件。

### 2.2Linux系统安装

CentOS 7.6镜像

#### 软件选择

勾选GNOME桌面下的传统X Windows兼容性、兼容性程序库和开发工具

#### Linux分区

文件系统`ext4`格式

1. boot引导分区 1GB
2. swap交换分区 与分配的内存大小一致2GB 内存不足时的补充机制 速度小于实际内存
   一个程序的执行，先要加载到内存当中去，如果当前运行的三个程序占满了分配的内存空间。如果有第4个程序想要到内存里面是进不来的，这个时候swap分区临时充当虚拟内存，等待实际内存剩余空间能容下第4个程序时，第4个程序此时从swap分区加载到实际内存中。
3. 根分区 17GB

#### KDUMP

Kdump是一个内核崩溃转储机制。在系统崩溃时，会捕获系统信息，用于诊断崩溃原因。实际生产中需要用，因为占用内存，所以日常学习可以关闭此功能。

#### root密码

工作中的各种密码强烈建议用密码生成器生成高复杂程度的密码，防止被黑。

### 2.3网络连接方式

前三个字段相同的IP地址，属于同一网段。

![](https://cdn.jsdelivr.net/gh/chousinbin/Image/虚拟机网络连接的三种模式.png)

#### 桥接模式

可以和外部系统通信。虚拟系统占用与主机同网段的IP地址（与主机IP不同），一个网段内创建大量桥接模式的虚拟系统会造成IP冲突（不够用，一个网段最多256个IP）。双向通讯。

#### NAT模式（选用）

网络地址转换模式，是把内部私有网络地址（IP地址）翻译成合法网络IP地址的技术，虚拟系统可以和外部系统通讯，不造成IP冲突。

#### 主机模式

独立的系统，单机。

### 2.4Linux开机多个选项

![image-20220716184225846](https://cdn.jsdelivr.net/gh/chousinbin/Image/image-20220716184225846.png)

前面几个选项正常启动，最后一个选项急救模式启动（系统出项问题不能正常启动时使用并修复系统）。在CentOS更新后,并不会自动删除旧内核。所以在启动选项中会有多个内核选项,可以手动使用以下命令删除多余的内核:

#### root与普通用户切换

终端提示符开头显示为`$`，则是普通用户，显示`#`为root用户。

root切到普通用户

```
su 用户名
```

普通用户切到root

```
su回车
输入管理密码
```

#### 查看当前系统内核版本

```
uname -a
```

![image-20220716182109935](https://cdn.jsdelivr.net/gh/chousinbin/Image/image-20220716182109935.png)

#### 查看系统中全部的内核RPM包

```
rpm -qa | grep kernel
```

![image-20220716182158303](https://cdn.jsdelivr.net/gh/chousinbin/Image/image-20220716182158303.png)

#### 删除就内核的RPM包

```
yum remove kernel-
```

![image-20220716182250073](https://cdn.jsdelivr.net/gh/chousinbin/Image/image-20220716182250073.png)

#### 重启系统

```
reboot
```



## 3.Linux目录结构

实际工作Linux环境没有图形化桌面系统，只有命令行终端，程序员必须熟悉掌握文件树目录结构。

Linux的目录是规定好的，每个目录各有各的职能，硬件也映射成了文件来管理，不能随意增减文件。

——在Linux世界里，一切皆文件！

### 目录详解

#### /

根目录

#### /bin

是Binary的缩写，此目录存放着最常用的命令。

`/usr/bin`

`/usr/local/bin`

#### /sbin

s是Super User的意思，此目录存放系统管理员的系统管理程序。

`/usr/sbin` 

`/usr/local/sbin`

#### /home

是普通账户的主目录，在**Linux**中每个账户在`/homo`中都有一个自己的目录，以用户的账户名命名。

#### /root

是系统管理员/超级权限者的用户主目录。

#### /lib

是根文件系统上程序所需的动态连接共享库，类似于Windows里的`.dll`文件。几乎所有的应用程序都需要用到这些共享库。

#### /lost+found

隐藏的目录，一般情况下是空的，当系统非法关机后，存放一些文件。

#### /etc

存放所有的系统管理所需要的配置文件和子目录。

比如系统安装了**MySQL**，其配置文件**my.conf**存放那个在`/etc`中，也存储系统的相关配置文件。

#### /usr

存放用户的应用程序和文件，类似于Windows的`Program Files`目录。

#### /boot

存放**Linux**启动时需要的核心文件，包括连接文件以及镜像文件。

#### /proc

是一个虚拟的目录，时系统内存的映射，访问这个目录能获取系统信息。**（不能动）**

#### /srv

**service**缩写，存放一些服务启动之后需要提取的数据。**（不能动）**

#### /sys

是**Linux2.6**内核的一个很大的变化。该目录下安装了2.6内核中新出现的一个文件系统**sysfs**。**（不能动）**

#### /tmp

存放一些临时文件。

#### /dev

存放以文件的形式存储的硬件，类似于Windows的设备管理器。

#### /media

Linux系统会把自动识别的外设挂载到该目录下。

#### /mnt

用于临时挂载别的文件系统，可以将外部的存储挂载到`/mnt/`内。

#### /opt

给系统额外提供的存放软件安装包的目录，默认为空。

#### /usr/local

给系统额外提供的软件安装位置的目录，一般通过编译源码的方式安装的程序。

#### /var

存放不断扩充着的文件，习惯将经常被修改的目录放在这个目录下。包括各种日志文件。

#### /selinux

security-enhanced linux，是一种安全子系统，他能控制程序只能访问特定文件，三种工作模式，可自行设置。



## 4.远程操控服务器

Linux服务器是开发小组共享，Linux服务器是公网上远程的，并且正式上线的项目是运行在公网的，所以程序员需要远程登陆到Linux进行项目的管理和开发。

远程登陆的客户端有命令操作Xshell和文件传输Xftp。[下载地址](https://www.xshell.com/zh/free-for-home-school/)

### 远程登陆前的准备

#### 查询Linux系统IP地址

```shell
# ifconfig
```

![image-20220719235654490](https://cdn.jsdelivr.net/gh/chousinbin/Image/202207192356817.png)

#### 检查IP能否ping通

在个人系统环境的终端输入ping 远程IP

```
ping IP
```

#### 解决主机无法ping虚拟机

原因就是安装VMware时，由于防火墙等设置的影响，没有配置好Vmware的虚拟网卡，在控制面板网络中缺少VMware虚拟网卡，就没有办法保证NAT模式下虚拟网卡IP与虚拟机IP在同一网段，造成无法ping虚拟机。

1. 禁用防火墙
   1. win+r运行regedit打开注册表
   2. 按路径\HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Services\MpsSvc 找到start，参数修改为“4”，确定，重启电脑。

![img](https://cdn.jsdelivr.net/gh/chousinbin/Image/202207192351272.webp)

2. 开启Device Install Service 、Device Setup Service 服务

![img](https://cdn.jsdelivr.net/gh/chousinbin/Image/202207192351998.webp)

​		最保险的关闭时先把服务改为手动再开启防止自动关闭！

3. 开启Network Setup Service 服务

![img](https://cdn.jsdelivr.net/gh/chousinbin/Image/202207192351873.webp)

4. 卸载VMware，用CCleaner清理注册表，重新安装Vmware。



### Xshell远程命令

Xshell是一个强大的安全终端模拟软件，支持SSH1，SSH2，以及Windows的TELNEYT协议。可以在Windows界面下访问远端不同操作系统的服务器，从而比较好的达到远程控制终端的目的。

#### 远程登陆

名称-主机-端口22-确定-输入登陆的用户名-密码-连接-一次性保存密钥

<img src="https://cdn.jsdelivr.net/gh/chousinbin/Image/202207200029633.png" alt="image-20220720002936336"  />

### Xftp远程传输文件

基于Windows平台的SFTP、FTP文件传输软件，用于Windows与UNIX/Linux传输文件。

#### 远程登陆

用户名-主机-端口22-用户名-密码-连接-一次性保存密钥

#### 解决中文乱码

![](https://cdn.jsdelivr.net/gh/chousinbin/Image/xftp中文乱码.png)

从**xftp**菜单的小齿轮属性设置编码为UTF-8，即可解决。

![image-20220720195200749](https://cdn.jsdelivr.net/gh/chousinbin/Image/xftp%E5%B1%9E%E6%80%A7.png)

![image-20220720195255045](https://cdn.jsdelivr.net/gh/chousinbin/Image/xftp%20UTF-8.png)

## 5.vi与vim

**Linux**系统会内置**vi**文本编辑器，**Vim**具有程序编辑的能力，可以看做是**Vi**的增强版本，具有主动以字体颜色辨别语法的正确性、代码补完、编译及错误跳转等方便编程的功能特别丰富。

### 模式转换与常用快捷键

#### 正常模式

此模式下可以通过**移动光标**进行**删除字符**或删除整行。也可使用复制和粘贴。

以**vim**打开一个文档默认进入正常模式，按下`Esc`/`Ctrl+[`退出其他模式进入正常模式。

| 操作名称                           |  命令   |
| :--------------------------------- | :-----: |
| 拷贝光标所在行                     |   yy    |
| 单次拷贝从光标所在行向下$n$行      | **n**yy |
| 把拷贝的行粘贴到光标所在行的下一行 |    p    |
| 删除当前行                         |   dd    |
| 单次删除从光标所在行向下$n$行      |  $n$dd  |
| 定位到文档最末行                   |    G    |
| 定位到文档最首行                   |   gg    |
| 定位到第$n$行                      |  $n$G   |
| 撤销最近的一次编辑操作             |    u    |

#### 插入模式

正常模式下，按下`i`/`I`/`o`/`O`/`a`/`A`/`r`/`R`，进入编辑模式。

#### 命令行模式

正常模式下，输入`:`或`/`进入命令行模式。

| 操作名称                                                  |     命令      |
| --------------------------------------------------------- | :-----------: |
| 保存退出**vim**                                           |      :wq      |
| 如果有修改，不保存退出到正常模式。没有修改，退出**vim**。 |      :q       |
| 不保存强制退出**vim**                                     |      :q!      |
| 查找单次（区分大小写）                                    | /要查找的单次 |
| 遍历找的多个单词                                          |      按n      |
| 显示行号                                                  |    :set nu    |
| 隐藏行号                                                  |   :set nonu   |

### vim快捷键图

![](https://cdn.jsdelivr.net/gh/chousinbin/Image/vim%E5%BF%AB%E6%8D%B7%E9%94%AE.jpeg)



## 6.Linux终端命令

### 关机重启命令

虽然目前**shutdown/reboot/halt**命令均已经在关机和重启前自动执行**sync**命令，但工作还是要小心谨慎。

| 操作名称               | 命令                      |
| ---------------------- | ------------------------- |
| 把内存的数据同步到磁盘 | sync                      |
| 关机                   | shutdown -h now 或 halt   |
| $n$分钟后关机          | shutdown -h $n$           |
| 重启                   | shutdown -r now 或 reboot |

### 用户切换登录注销

| 操作名称                     | 命令         |
| ---------------------------- | ------------ |
| 用户切换（不仅身份而且环境） | su - 用户名  |
| 用户切换（仅仅身份）         | su -p 用户名 |
| 注销当前用户                 | logout       |

假设当前**xshell**连接的用户是**root** ,当把用户切换为另一个非**root**用户后，执行注销当前用户，会返回**root**用户，再次执行注销当前用户，会注销仅剩的**root**用户，回到用户选择界面。

### 用户管理













