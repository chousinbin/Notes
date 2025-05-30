# Git

$everything\ is\ local$

## 一、Git概述

**Git**是一个免费的、开源的**分布式版本控制系统**，可以快速高效的处理从小型到大型的各种项目。

**Git**易于学习， 占用空间小，性能快如闪电。它优于 **SCM** 工具，如 **Subversion**、**CVS**、**Perforce** 和 **ClearCase**，具有廉价的本地分支、方便的暂存区域和多个工作流等功能。

### 1.1Git历史

> Linus在1991年创建了开源的Linux，从此，Linux系统不断发展，已经成为最大的服务器系统软件了。
>
> Linus虽然创建了Linux，但Linux的壮大是靠全世界热心的志愿者参与的，这么多人在世界各地为Linux编写代码，那Linux的代码是如何管理的呢？
>
> 事实是，在2002年以前，世界各地的志愿者把源代码文件通过diff的方式发给Linus，然后由Linus本人通过手工方式合并代码！
>
> 你也许会想，为什么Linus不把Linux代码放到版本控制系统里呢？不是有CVS、SVN这些免费的版本控制系统吗？因为Linus坚定地反对CVS和SVN，这些集中式的版本控制系统不但速度慢，而且必须联网才能使用。有一些商用的版本控制系统，虽然比CVS、SVN好用，但那是付费的，和Linux的开源精神不符。
>
> 不过，到了2002年，Linux系统已经发展了十年了，代码库之大让Linus很难继续通过手工方式管理了，社区的弟兄们也对这种方式表达了强烈不满，于是Linus选择了一个商业的版本控制系统BitKeeper，BitKeeper的东家BitMover公司出于人道主义精神，授权Linux社区免费使用这个版本控制系统。
>
> 安定团结的大好局面在2005年就被打破了，原因是Linux社区牛人聚集，不免沾染了一些梁山好汉的江湖习气。开发Samba的Andrew试图破解BitKeeper的协议（这么干的其实也不只他一个），被BitMover公司发现了（监控工作做得不错！），于是BitMover公司怒了，要收回Linux社区的免费使用权。
>
> Linus可以向BitMover公司道个歉，保证以后严格管教弟兄们，嗯，这是不可能的。实际情况是这样的：
>
> Linus花了两周时间自己用C写了一个分布式版本控制系统，这就是Git！一个月之内，Linux系统的源码已经由Git管理了！牛是怎么定义的呢？大家可以体会一下。
>
> Git迅速成为最流行的分布式版本控制系统，尤其是2008年，GitHub网站上线了，它为开源项目免费提供Git存储，无数开源项目开始迁移至GitHub，包括jQuery，PHP，Ruby等等。
>
> 历史就是这么偶然，如果不是当年BitMover公司威胁Linux社区，可能现在我们就没有免费而超级好用的Git了。
>
> (摘录于廖雪峰官网Linux教程)

### 1.2版本控制

团队开发需要记录项目版本以及正确的版本控制，**Git**版本控制软件由此而来。

### 1.3版本控制工具

#### 集中式版本控制工具

**CVS**、**SVN（subversion）**、**VSS**......

集中化的版本控制系统诸如**CVS**、**SVN**等，都有一个单一的集中管理的服务器，保存所有文件的修订版本，而协同工作的人们都通过客户端连到这台服务器，取出最新的文件或者提交更新。多年以来，这已成为版本控制系统的标准做法。

优点是每个人都可以在一定程度上看到项目中的其他人正在做些什么。而管理员也可以轻松掌控每个开发者的权限，并且管理一个集中化的版本控制系统，要远比在各个客户端上维护本地数据库来得轻松容易。

缺点是中央服务器的单点故障。如果服务器宕机一小时，那么在这一小时内，准都无法提交更新，也就无法协同工作。

#### 分布式版本控制工具

**Git**、**Mercurial**、**Bazaar**、**Darcs**......

像**Git**这种分布式版本控制工具，客户端提取的不是最新版本的文件快照，而是把代码仓库完整地镜像下来（本地库）。这样任何一处协同工作用的文件发生故障，事后都可以用其他客户端的本地仓库进行恢复。因为每个客户端的每一次文件提取操作，实际上都是一次对整个文件仓库的完整备份。

分布式的版本控制系统出现之后，解决了集中式版本控制系统的缺陷：

1. 服务器断网的情况下也可以进行开发（因为**版本控制是在本地进行的**）
2. 每个客户端保存的也都是整个完整的项目（包含历史记录，更加安全）

### 1.4Git工作机制

![](https://cdn.jsdelivr.net/gh/chousinbin/Image/git工作机制.png)

只有把代码提交到本地库，才会产生历史版本。

本地库→**git push**→远程库

### 1.5代码托管平台

代码托管中心是基于网络服务器的远程代码仓库，一般称为**远程库**。

局域网：**Gitlab**

互联网：**Github**、**Gitee**码云

## 二、Git安装

Git官网：https://git-scm.com/

默认选项安装

查看Git版本

```shell
ChouS@DESKTOP-78VSLED MINGW64 ~
$ git --version
git version 2.37.0.windows.1
```

## 三、Git常用命令

大部分命令与Linux通用。

| 命令名称                             | 作用                 |
| ------------------------------------ | -------------------- |
| git config --global user.name 用户名 | 设置用户签名         |
| git config --global user.email 邮箱  | 设置用户签名         |
| git init                             | 初始化本地库         |
| git status                           | 查看本地库状态       |
| git add 文件名                       | 添加到暂存区         |
| git rm --cached 文件名               | 从暂存区删除         |
| git commit -m "版本信息" 文件名      | 提交到本地库         |
| git reflog                           | 查看历史纪录         |
| git reset --hard 版本号              | 版本穿梭             |
| git log                              | 查看当前版本详细日志 |



### 3.1用户签名

#### 设置用户签名

```
git config --global user.name 用户签名
git config --global user.email 用户邮箱
```

#### 查看用户签名

![](https://cdn.jsdelivr.net/gh/chousinbin/Image/查看用户签名.png)

注意：

1. 签名的作用是区分不同操作者的身份。用户签名信息在每一个版本的提交信息中能够看到，以此确定本次提交的谁做的。
2. Git首次安装必须设置一下用户签名，否则无法提交代码。
3. 这里设置的用户签名的用户名和邮箱与将来登录代码托管平台的账号没有任何关系。

### 3.2初始化本地库

```
git init
```

在项目根文件夹中`右键`选择`git bush` ，输入上命令，完成初始化本地库。

### 3.3查看本地库状态

```
git status
```

红名文件说明是改动的文件，未被添加到暂存区。

绿名文件，说明该文件状态已经从工作区`add`到暂存区，说明Git追踪到了该文件。

### 3.4添加到暂存区

#### 添加到暂存区

```
git add 文件名
```

#### 批量添加到暂存区

1. 添加多个文件，文件之间以空格隔开

   ```
   git add file1 file2 file3
   ```

2. 添加指定文件夹下的文件或者指定文件夹下指定格式文件

   ```
   git add 算法/*  //把算法文件夹下的全部文件添加到暂存区
   git add 算法/*.md  //把算法文件夹下.md格式的文件添加到暂存区
   ```

3. 添加所有文件

   ```
   git add .
   git add --all
   ```


#### 从暂存区删除

添加到暂存区还不会被版本控制记录，可以进行从暂存区删除命令。

```
git rm --cached 文件名
```

这个删除只是从暂存区删除，不会删除工作区的源文件。

### 3.5提交到本地库

```
git commit -m "版本信息" 文件名
```

执行该命令后，把暂存区的文件提交到本地库。此时，文件被版本控制记录。

### 3.6查看历史日志

```
git reflog
```

显示当前项目的所有历史版本，以及对应版本的版本号前七位（如本数据`c16588d`）。

### 3.7查看详细历史日志

```shell
ChouS@DESKTOP-78VSLED MINGW64 /e/Github/Notes (master)
$ git log
commit b2325b3a938da90867449087ef4abfaaf2b96637 (HEAD -> master, notes/master)
Author: SinbinChou <chousinbin@163.com>
Date:   Wed Jul 20 21:57:31 2022 +0800

    2022-07-20
```

显示当前项目当前版本的详细日志信息。比如：完整的版本号、提交者的签名、提交时间、版本名等。

### 3.8修改文件

#### 修改文件

![image-20220711220754217-165754847572118](https://cdn.jsdelivr.net/gh/chousinbin/Image/%E4%BF%AE%E6%94%B9%E6%96%87%E4%BB%B6.png)

修改`newfile`文件第一行尾添加了`222`。

#### 修改后的状态

![image-20220711220916755-165754855792719](https://cdn.jsdelivr.net/gh/chousinbin/Image/%E4%BF%AE%E6%94%B9%E5%90%8E%E7%9A%84%E7%8A%B6%E6%80%81.png)

再次查看状态，我们发现有提示`modified:文件名`，这种状态说明此文件被修改过了。

另外这个提示是红色字体，所以这个修改的文件还没有被添加到暂存区，需要对此文件进行添加到暂存区。

#### 添加到暂存区后的状态

![image-20220711221322293-165754880347220](https://cdn.jsdelivr.net/gh/chousinbin/Image/%E4%BF%AE%E6%94%B9%E6%96%87%E4%BB%B6%E6%B7%BB%E5%8A%A0%E5%88%B0%E6%9A%82%E5%AD%98%E5%8C%BA%E5%90%8E%E7%9A%84%E7%8A%B6%E6%80%81.png)

添加到暂存区后，再次查看状态，绿色状态表明：当前文件是被修改且添加到暂存区后未被提交到本地库的文件。

#### 提交到本地库

![image-20220711221637309-165754899852521](https://cdn.jsdelivr.net/gh/chousinbin/Image/%E4%BF%AE%E6%94%B9%E6%96%87%E4%BB%B6%E6%8F%90%E4%BA%A4%E5%88%B0%E6%9C%AC%E5%9C%B0%E5%90%8E%E7%9A%84%E7%8A%B6%E6%80%81.png)

提交到本地库后返回操作者提交的版本信息、文件修改的数量、行数的插入数与删除数。

我们明明是在一行的结尾添加了数字$2$，为什么返回的信息是一行插入和一行删除呢？

因为Git是按照行来编辑的，在修改文件信息时，先删除当前行，再把修改后的信息插入到原来的位置。

#### 提交到本地库后的状态

![image-20220711222302344-165754938352122](https://cdn.jsdelivr.net/gh/chousinbin/Image/%E4%BF%AE%E6%94%B9%E6%96%87%E4%BB%B6%E6%8F%90%E4%BA%A4%E5%88%B0%E6%9C%AC%E5%9C%B0%E5%BA%93%E5%90%8E%E7%9A%84%E7%8A%B6%E6%80%81.png)

世界恢复了原有的平静。

虽然我们对此项目的一个文件可能进行多个版本的修改，但是本地源文件只有一个，版本控制由Git掌管。

### 3.9版本穿梭

```
git reset --hard 版本号
```

先找到版本号（前7位就可以）

![image-20220711223246142-165754996722826](https://cdn.jsdelivr.net/gh/chousinbin/Image/%E6%9F%A5%E7%9C%8B%E6%97%A5%E5%BF%97%E4%BF%A1%E6%81%AF%E6%9F%A5%E6%89%BE%E7%89%88%E6%9C%AC%E5%8F%B7.png)

选中要穿梭到的版本号，右击复制，执行版本穿梭命令。

![image-20220711223518949-165755011993527](https://cdn.jsdelivr.net/gh/chousinbin/Image/%E6%89%A7%E8%A1%8C%E7%A9%BF%E6%A2%AD%E5%91%BD%E4%BB%A4.png)

查看穿梭后的日志信息

![image-20220711223609404-165755017064528](https://cdn.jsdelivr.net/gh/chousinbin/Image/%E7%A9%BF%E6%A2%AD%E5%90%8E%E7%9A%84%E6%97%A5%E5%BF%97%E4%BF%A1%E6%81%AF.png)

明显看到当前指向`first version`版本。最顶行多出一行日志记录我们进行了版本穿梭。说明**版本穿梭也会被Git的日志记录，但版本号不会新增。**



## 四、Git分支操作

### 4.1什么是分支

在版本控制过程中，同时推进多个任务，为每廷务，我们就可以创建每个任务的单独分支。使用分支意味着程序员可以把自己的工作从开发主线上分离开来，开发自己分支的时候，不会影响主线分支的运行。对于初学者而言，分支可以简单理解为副本，一个分支就是一个单独的副本。（分支底层其实也是指针的引用）

### 4.2分支的好处

同时并行推进多个功能开发，提高开发效率。

各个分支在开发过程中，如果某一个分支开发失败，不会对其他分支有任何影响。失败的分支删除重新开始即可。

### 4.3分支的操作

| 命令名称            | 作用                         |
| ------------------- | ---------------------------- |
| git branch 分支名   | 创建分支                     |
| git branch -v       | 查看分支                     |
| git checkout 分支名 | 切换分支                     |
| git merge 分支名    | 把指定的分支合并到当前分支上 |



#### 查看分支

```
git branch -v
```

![image-20220711231102512-165755226339829](https://cdn.jsdelivr.net/gh/chousinbin/Image/%E6%9F%A5%E7%9C%8B%E5%88%86%E6%94%AF.png)

#### 创建分支

```
git branch 分支名
```

创建一个名为`hot-fix`的紧急修复分支。

![image-20220711231323977-165755240493430](https://cdn.jsdelivr.net/gh/chousinbin/Image/%E5%88%9B%E5%BB%BA%E5%88%86%E6%94%AF.png)

创建的新分支，会克隆当前分支的的所有状态和信息，比如：历史版本信息等等。

#### 切换分支

```
git checkout 分支名
```

![image-20220711231543838-165755254481331](https://cdn.jsdelivr.net/gh/chousinbin/Image/%E5%88%87%E6%8D%A2%E5%88%86%E6%94%AF.png)

切换成功后会返回切换成功信息，下一个提示符的蓝色括号由原来的`master`变成了`hot-fix`。

同时日志会记录分支切换信息。

#### 分支修改文件

![image-20220711233153248-165755351431233](https://cdn.jsdelivr.net/gh/chousinbin/Image/%E5%88%86%E6%94%AF%E4%BF%AE%E6%94%B9%E6%96%87%E4%BB%B6.png)

直接调用`vim`对最新版本的`newfile.md`文件进行修改。修改之后的状态与在同一个分支下修改文件相似，这里省略图文介绍，详细参考上文`3.8修改文件`。之后的步骤是：添加到暂存区、提交到本地库。

在修改分支提交的版本我们命名为`hot-fix first version`。

![image-20220711232825334-165755330625032](https://cdn.jsdelivr.net/gh/chousinbin/Image/%E5%88%86%E6%94%AF%E4%BF%AE%E6%94%B9%E6%96%87%E4%BB%B6%E6%8F%90%E4%BA%A4.png)

#### 合并分支

```
git merge 分支名 
```

合并前先把项目的分支切换到需要合并到的分支上**（master)**

执行合并命令

![image-20220711233445810-165755368669935](https://cdn.jsdelivr.net/gh/chousinbin/Image/%E5%90%88%E5%B9%B6%E5%88%86%E6%94%AF.png)

#### 冲突合并

产生冲突的原因：合并分支时，两个分支在同一个文件的同一个位置有两套完全不同的修改。Git无法替我们决定使用哪一个。必须认为决定新代码的内容。

模拟冲突合并：

因为上一步我们刚刚把`hot-fix`中的` first version`合并到`mater`中来，所以此时`mater`分支`newfile`的内容与`hot-fix`中`newfile.md`的内容一样。

我们先把`master`中的`newfile`最后一行尾加入`master test`。再进行添加和提交。版本命名`master test`。

![image-20220711234546010-165755434724336](https://cdn.jsdelivr.net/gh/chousinbin/Image/%E5%86%B2%E7%AA%81%E5%90%88%E5%B9%B61.png)

再把分支切换到`hot-fix`，此时内容还未受到`master`分支的修改而修改。

![image-20220711235010268-165755461144537](https://cdn.jsdelivr.net/gh/chousinbin/Image/%E5%86%B2%E7%AA%81%E5%90%88%E5%B9%B62.png)

这时我们把`hot-fix`中的`newfile`的倒数第二行末加上`hot-fix test`。

![image-20220711235533164-165755493419538](https://cdn.jsdelivr.net/gh/chousinbin/Image/%E5%86%B2%E7%AA%81%E5%90%88%E5%B9%B63.png)

然后添加、提交。版本名为`hotfix-version`。切换回`master`分支，执行合并分支。

![image-20220712000055116-165755525709140](https://cdn.jsdelivr.net/gh/chousinbin/Image/%E5%86%B2%E7%AA%81%E5%90%88%E5%B9%B65.png)

此时报错并且当前状态为在`master`分支上，并且正在合并分支，需要我们人为进入**vim**选择合并。

![image-20220712000249139-165755537016641](https://cdn.jsdelivr.net/gh/chousinbin/Image/%E5%86%B2%E7%AA%81%E5%90%88%E5%B9%B66.png)

<<<<<< HEAD 与`======`之间的内容表示是当前**mater**分支的修改内容。
`=======`与>>>>>>> **hot-fix**之间的内容表示**hot-fix**分支的修改内容。

我们需要手动修改内容并且删除多余的提示符号。

![image-20220712000625610-165755558659742](https://cdn.jsdelivr.net/gh/chousinbin/Image/%E5%86%B2%E7%AA%81%E5%90%88%E5%B9%B67.png)

上图是人工手动修改合并后的信息，保留了两个处在不同分支的操作者对同一文件的修改。

保存完文件之后，还要把修改完的文件添加到暂存区以及提交到工作区的一系列操作，注意在**手动合并后的提交到本地库的命令中不需要带文件名**。

![image-20220712001330058-165755601223843](https://cdn.jsdelivr.net/gh/chousinbin/Image/%E5%86%B2%E7%AA%81%E5%90%88%E5%B9%B68.png)

提交完成后，状态变为`master`。至此我们通过手动合并分支解决了代码冲突。

![image-20220712001740176-165755626155745](https://cdn.jsdelivr.net/gh/chousinbin/Image/%E5%86%B2%E7%AA%81%E5%90%88%E5%B9%B69.png)

注意：合并分支只会修改合并到分支的文件的内容，从哪合并来的哪个分支通过合并操作不会被修改。

![image-20220712001648472-165755620941644](https://cdn.jsdelivr.net/gh/chousinbin/Image/%E5%86%B2%E7%AA%81%E5%90%88%E5%B9%B610.png)

 





## 五、Github远程库操作

### 5.1配置SSH

1. 设置用户签名

2. 检查是否存在**SSH Key**
   ```shell
   ChouS@DESKTOP-78VSLED MINGW64 /
   $ cd ~/.ssh
   
   ChouS@DESKTOP-78VSLED MINGW64 ~/.ssh
   $ ls
   id_rsa  id_rsa.pub  known_hosts  known_hosts.old
   ```

   存在`id_rsa.pub`和`id_rsa`说明存在**SSH**密钥。

3. 如果没有，则执行生成**SSH Key**

   ```shell
   ChouS@DESKTOP-78VSLED MINGW64 ~/.ssh
   $ ssh-keygen -t rsa -C "邮箱地址"
   ```

4. 查看**SSH Key**

   ```shell
   ChouS@DESKTOP-78VSLED MINGW64 ~/.ssh
   $ cat id_rsa.pub
   ssh-rsa 
   以下为密钥内容，此处不做展示。
   ```

5. 到**Github**配置添加密钥

   登陆Github-右上角头像-**settings**-**SSH and GPG keys**-**add**。

**配置好SSH后,在自己的电脑Github会自动与远程库保持通信。**

### 5.2创建远程仓库

**Repository**

公网访问仓库名称为 `username.github.io`，每个账号只有一个。

非公网访问仓库名称用户自定义，有很多个供我们使用。

### 5.3远程仓库操作

#### 创建远程仓库别名

| 操作命令                     | 操作名称                   |
| ---------------------------- | -------------------------- |
| git remote -v                | 查看当前所有远程地址的别名 |
| git remote add 别名 远程地址 | 设置远程地址的别名         |
| git remote rm 别名           | 删除远程主机               |
| git remotr rename 别名       | 修改远程主机别名           |

查看远程地址别名有两行，说明这个别名可以用于推送、拉取、克隆等。

#### 推送本地库代码到远程库

```
git push 别名/远程链接 分支
```

推送的最小单位是分支，需要指定推送哪一个分支。

#### 拉取远程库到本地库

```
git pull 别名 分支
```

当本地库与远程库的项目文件内容不一致时，需要先用`Pull`拉取到本地，更新本地库与远程库保持一致。

#### 克隆远程仓库到本地

```
git clone 远程地址
```

克隆会自动完成：1、拉取代码  2、初始化本地仓库  3、创建别名

当到一个新环境管理自己的或上级的项目需要克隆到本地以实现初始化和拉取最新代码。

### 5.4Github界面介绍

| 功能名称        | 作用                                                         |
| --------------- | ------------------------------------------------------------ |
| `Code`          | 展示项目源码，提供源码`Clone`和打包下载。                    |
| `Issues`        | 讨论区，可以对项目进行各种提问。我们每个人都可以在本区提出`issuse`。状态`Open`：讨论中状态`Closed`：关闭该帖，已经解决问题。 |
| `Pull requests` | 从Fork的项目发起向原项目合并请求                             |
| `fork`          | 原项目的拷贝数。                                             |
| `watch`         | 关注项目的变化，如果别人提交了`pull`、`request`、发起了`issue`，在通知中心会收到消息。 |
| `star`          | 类似于点赞，表示项目受欢迎度。                               |
| `branch`        | 分支                                                         |
| `tag`           | 标签                                                         |

### 5.5Branch与Fork的区别

`Fork`属于远程托管平台的功能，并不属于`Git`的`branch`。

`Fork`是一个新的仓库，可以随便开分支，只要最后不乱 `pull request` 乱合并到原项目就不会出事；
`branch` 其实只是一个分支，比一个仓库的范围要小得多，你实际上还是处于同一个项目仓库中。

`Pull Request`：从`Fork`过衍生出的新项目向原项目发起合并推送请求。

### 5.6顶级域名

申请顶级域名并且指向`username.github.io`，会使之变为类似`www.username.com`的地址。

#### 申请渠道

1. 阿里云
2. 腾讯云
3. GoDaddy
4. freenom

从顶级域名渠道配置指向我们的GitHub地址后，要从**GitHub**的仓库`setting`中的`Custom domain`输入我们购买好的顶级域名，这样顶级域名就配置完成了。

### 5.7版本比较

在原项目的网址后面加上`\compare`可以访问该项目的版本比较页面，另外也有插件可以使得源码比较起来直观。

## 六、配置代理

> Github 时常访问速度慢甚至无法访问，仅仅打开代理不能作用于 Git Bash，需要在Bash 中进行手动配置，代理在 Bash 中才能生效。
>
> 也可以使用 Clash 中的 TUN Mode，可以免去配置的麻烦。
>
> 对于 HTTPS 配置后大多可以正常生效，SSH配置后未见得会生效，因为 SSH 的 22 端口大多被代理服务商屏蔽，使得代理环境下 SSH 连接报错。

### 协议对比

| 协议名称 | 优点                                 | 缺点                                          |
| -------- | ------------------------------------ | --------------------------------------------- |
| HTTPS    | 广泛使用，端口大多数不会被禁         | 每次提交需要验证 Github 账号和密码            |
| SSH      | 每次提交不需要验证 Github 账号和密码 | 必须先配置 SSH key，22 端口大多被代理服务商禁 |

### 手动配置

#### HTTPS

```shell
// 设置全局代理
git config --global https.proxy http://127.0.0.1:7890
git config --global https.proxy https://127.0.0.1:7890

// 取消全局代理
git config --global --unset http.proxy
git config --global --unset https.proxy

// 设置 Github 代理
git config --global http.https://github.com.proxy socks5://127.0.0.1:7890
git config --global https.https://github.com.proxy socks5://127.0.0.1:7890

// 取消 Github 代理
git config --global --unset http.https://github.com.proxy
git config --global --unset https.https://github.com.proxy

// socks5
git config --global http.proxy socks5://127.0.0.1:7891
git config --global https.proxy socks5://127.0.0.1:7891
```

#### SSH

目录：C:\User\UserName\.ssh\config

```
# Windows 用户
ProxyCommand "D:\ProgramDev\Git\mingw64\bin\connect" -S 127.0.0.1:7890 -a none %h %p

# MacOS 用户
# ProxyCommand nc -v -x 127.0.0.1:51837 %h %p

Host github.com
  User git
  Port 22
  Hostname github.com
  # 注意修改路径为你的路径
  IdentityFile "C:\Users\ChouS\.ssh\id_rsa"
  TCPKeepAlive yes

Host ssh.github.com
  User git
  Port 443
  Hostname ssh.github.com
  # 注意修改路径为你的路径
  IdentityFile "C:\Users\ChouS\.ssh\id_rsa"
  TCPKeepAlive yes
```

```
# 测试是否设置成功
ssh -T git@github.com
```

### Clash TUN

- 打开 Service Mode，绿色地球标志亮起表示成功打开
- 打开 Clash 的TUN Mode
- 无需终端执行代理命令和编写配置文件

![image-20240126210735365](https://cdn.jsdelivr.net/gh/chousinbin/Image/202401262107425.png)

## 七、Windows Terminal 添加 Git Bash

1. 打开设置 - 添加新的配置文件 - 复制配置文件 Windows PowerShell - 复制

   ![image-20240126213757459](https://cdn.jsdelivr.net/gh/chousinbin/Image/202401262137511.png)

2. 名称：Git Bash

3. 命令行：`D:\ProgramDev\Git\bin\bash.exe --login -i`

4. 启动目录：`D:\Github`

5. 图标：`D:\ProgramDev\Git\mingw64\share\git\git-for-windows.ico`

   ![](https://cdn.jsdelivr.net/gh/chousinbin/Image/202401262138495.png)

6. 保存
