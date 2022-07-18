# Linux



## Linux介绍

### Linux应用

#### Linux应用场景

Linux运维工程师：服务器规划、调试优化、系统进程监控、故障处理

Linux嵌入式工程师

Linux下开发项目：JavaEE、大数据、Python、PHP、Ｃ/C++

#### Linux应用领域

个人桌面：最弱的领域

**服务器领域**：最强大的应用领域

嵌入式领域：运行稳定、对网络良好支持、低成本、内核最小可以裁剪到几百KB

### Linux概述

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



## Linux安装

### [VM虚拟机](https://download3.vmware.com/software/wkst/file/VMware-workstation-full-16.1.2-17966106.exe)

（可能某些电脑需要先在BIOS设置开启虚拟化设备支持。）

激活码：ZF71R-DMX85-08DQY-8YMNC-PPHV8

### CentOS 7.6镜像

#### 网络选择

默认NAT

#### 软件选择

勾选GNOME桌面下的传统X Windows兼容性、兼容性程序库和开发工具

### Linux分区

1. boot引导分区 1GB
2. swap交换分区 与分配的内存大小一致2GB
3. 根分区 17GB

### CentOS开机界面出现多个选项

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





