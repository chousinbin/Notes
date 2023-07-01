# 概念

### 数据库结构

![image-20230701215552974](https://cdn.jsdelivr.net/gh/chousinbin/Image/202307012155127.png)

#### 数据库管理系统

数据库管理系统管理若干个数据库

#### 数据库

数据库存放若干张表

```sql
mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| db01               |
| db02               |
| mysql              |
| performance_schema |
| sys                |
+--------------------+
6 rows in set (0.00 sec)
```

#### 表

表是文件, 表里面存放若干条记录, 表分为行(row)和列(column), 表的一行称为一条记录.

在Java中一条记录被映射为一个对象.

```sql
mysql> select * from users;
+----+-------+---------+
| id | name  | address |
+----+-------+---------+
|  1 | admin | 大连    |
|  2 | zxb   | 唐山    |
|  3 | dog   | 大连    |
+----+-------+---------+
3 rows in set (0.00 sec)
```



### SQL语句分类

#### DDL数据定义语句

create创建 数据库/表

#### DML数据操作语句

insert增, delete删, update改

#### DQL数据查询语句

select查询表

#### DCL数据控制语句

比如管理数据库用户权限 grant revoke



# MySQL

### 连接到MySQL服务

```shell
mysql -h 主机IP -P 端口 -u 用户名 -p密码

#可以省略-h 主机IP -P 端口这四个
#省略后默认主机为本机 端口为3306
#-p和密码之间无空格
#输完-p之后可以先回车后密码, 也可以先密码后回车
```



# 数据库

### 新建数据库

```sql
create database [if not exists] 数据库名 [character set xx] [collate xx];
```

#### character set

字符集, 默认utf8

#### collate

校对规则, 默认utf8_general_ci不区分大小写, 常用utf8_bin区分大小写

### 显示数据库

```mysql
show databases;
```

```sql
mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| db01               |
| db02               |
| mysql              |
| performance_schema |
| sys                |
+--------------------+
6 rows in set (0.00 sec)
```

### 显示数据库创建语句

```mysql
show create database 数据库名;
```

```sql
mysql> create database db02 character set utf8 collate utf8_bin;
Query OK, 1 row affected (0.00 sec)

mysql> show create database db02;
+----------+--------------------------------------------------------------------------------+
| Database | Create Database                                                                |
+----------+--------------------------------------------------------------------------------+
| db02     | CREATE DATABASE `db02` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */ |
+----------+--------------------------------------------------------------------------------+
1 row in set (0.00 sec)

#在创建数据库和表的时候, 为了规避关键字, 可以把数据库名和表名用反引号括起来
```

### 删除数据库

```sql
drop database if exists 数据库名;
```

### 备份数据库

在DOS下执行

```bash
mysqldump -u 用户名 -p -B 库1 库2 ... 库n > 文件名.sql
mysqldump -u 用户名 -p -B 库1 库2 ... 库n > D:\\文件名.sql
```

备份文件默认存放在`MySQL目录\bin\`中

自定义目录是注意要写两个反斜杠

备份文件后缀是`.sql`, 进一步说明备份文件里存放的是当前数据库之前写过的所有的SQL语句

### 备份数据库的表

```
mysqldump -u 用户名 -p 数据库 表1 ... 表n > D:\\文件名.sql
```

### 恢复数据库

```sql
mysql> Source 文件名.sql;
```



# 表

### 查看表

```sql
show stables;
```

### 新建表

```sql
create table 表名
(
    字段1 字段类型1,
    字段2 字段类型2(长度)
) [character set 字符集] [collate 校对规则] [engine 存储引擎];

#如果创建表时不指定字符集和校对规则, 则默认都为表所在数据库的字符集和校对规则
```

### 向表中插入数据

```mysql
insert into 表名 values (字段1元素, 字段2元素);
```

### 查询数据

```mysql
select * from 表 where 字段 = 字段元素;
```



# 数据类型
