# MySQL 概念

## 数据库三层结构

![image-20230701215552974](https://cdn.jsdelivr.net/gh/chousinbin/Image/202307012155127.png)

### DBMS

数据库管理系统管理若干个数据库

### Database

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

### Table

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

## SQL 语句分类

- DDL 数据定义语句：create 创建数据库/表
- DML 数据操作语句：insert 增, delete 删, update 改
- DQL 数据查询语句：select 查询表
- DCL 数据控制语句：比如管理数据库用户权限 grant revoke

## MySQL 连接方式

### 命令行连接

```shell
mysql -h 主机IP -P 端口 -u 用户名 -p密码

# 可以省略-h 主机IP -P 端口这四个
# 省略后默认主机为本机 端口为3306
# -p和密码之间无空格
# 输完-p之后可以先回车后密码, 也可以先密码后回车
```

### Java 连接

使用 Java 连接数据库需要导入 JDBC 库文件

```java
public class HelloJDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 配置信息
        String url = "jdbc:mysql://localhost:3306/mysql_test";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "zxb19990079994...");
        // 获取连接对象
        Connection connection = DriverManager.getConnection(url, properties);
        Statement statement = connection.createStatement();
        // 执行 SQL
        String sql = "insert into users values(null, 'zxb', '23', 'zxb@neu.com')";
        int res = statement.executeUpdate(sql);
        System.out.println(res > 0 ? "成功" : "失败");
        // 关闭连接
        statement.close();
        connection.close();
    }
}
```

### Navicat 连接

略

## 数据类型

### 数值类型

| 数据类型       | 类型         | 存储大小                            | 数据范围（有符号）                                           | 数据范围（无符号）  |
| -------------- | ------------ | ----------------------------------- | ------------------------------------------------------------ | ------------------- |
| `TINYINT`      | 整型         | 1 Byte                              | $$[-2^7, 2^7-1]$$                                            | $$[0, 2^8-1]$$      |
| `SMALLINT`     | 整型         | 2 Bytes                             | $$[-2^{15}, 2^{15}-1]$$                                      | $$[0, 2^{16}-1]$$   |
| `MEDIUMINT`    | 整型         | 3 Bytes                             | $$[-2^{23}, 2^{23}-1]$$                                      | $$[0, 2^{24}-1]$$   |
| `INT`          | 整型         | 4 Bytes                             | $$[-2^{31}, 2^{31}-1]$$                                      | $$[0, 2^{32}-1]$$   |
| `BIGINT`       | 整型         | 8 Bytes                             | $$[-2^{63}, 2^{63}-1]$$                                      | $$[0, 2^{64}-1]$$   |
| `FLOAT`        | 单精度浮点数 | 4 Bytes                             | $$\pm 1.18 \times 10^{-38} \text{ 到 } \pm 3.40 \times 10^{38}$$ | 同有符号            |
| `DOUBLE`       | 双精度浮点数 | 8 Bytes                             | $$\pm 2.23 \times 10^{-308} \text{ 到 } \pm 1.79 \times 10^{308}$$ | 同有符号            |
| `DECIMAL(m,d)` | 定点数       | 变长                                | $$[-10^{m-d}+1, 10^{m-d}-1]$$                                | $$[0, 10^{m-d}-1]$$ |
| `BIT(n)`       | 位类型       | $$\lceil n/8 \rceil \text{ Bytes}$$ | $$[0, 2^n-1]$$（`n ∈ [1,64]`）                               | 同有符号            |

- 创建表时，列未指定 `unsigned` 默认为有符号数据类型。

### 字符串类型

| 数据类型   | 类型   | 大小            |
| ---------- | ------ | --------------- |
| char()     | 字符串 | $0\sim255$      |
| varchar()  | 字符串 | $0\sim65535$    |
| text()     | 字符串 | $0\sim65535$    |
| longtext() | 字符串 | $0\sim2^{32}-1$ |

### 二进制类型

| 数据类型 | 类型   | 大小            |
| -------- | ------ | --------------- |
| bit()    | 二进制 | $1\sim64$       |
| blob     | 二进制 | $0\sim65535$    |
| longblob | 二进制 | $0\sim2^{32}-1$ |

### 日期类型

| 数据类型  | 说明                                  |
| --------- | ------------------------------------- |
| date      | 年月日                                |
| time      | 时分秒                                |
| datetime  | 年月日时分秒                          |
| timestamp | 时间戳（随`insert` `update`自动记录） |

# MySQL 入门

## 数据库操作

### 使用数据库

```sql
USE database_name;
```

### 新建数据库

```sql
mysql> create database [if not exists] 数据库名 [character set xx] [collate xx];
```

- **character set**：字符集，默认 `utf8`
- **collate**：校对规则，是在**特定字符集内**对字符进行**比较和排序**的一套规则。 `utf8_general_ci` 不区分大小写，常用 `utf8_bin` 区分大小写

### 显示数据库

```mysql
mysql> show databases;
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
mysql> show create database 数据库名;
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

# 在创建数据库和表的时候, 为了规避关键字, 可以把数据库名和表名用反引号括起来
```

### 删除数据库

```sql
mysql> drop database [if exists] 数据库名;
```

### 备份数据库

```shell
mysqldump -u 用户名 -p -B 库1 [库2 ... 库n] > 文件名.sql
mysqldump -u 用户名 -p -B 库1 [库2 ... 库n] > D:\\文件名.sql
```

- 备份文件默认存放在 `MySQL目录\bin\` 中
- 自定义目录是注意要写两个反斜杠
- 备份文件后缀是 `.sql`，进一步说明备份文件里存放的是当前数据库之前写过的所有的 SQL 语句

### 备份数据库的表

```shell
mysqldump -u 用户名 -p 数据库 表1 [表2 ... 表n] > D:\\文件名.sql
```

### 恢复数据库

```sql
mysql> Source 文件名.sql;
```

## 表操作

表的本质是文件

### 查看表

```sql
-- 显示当前数据库所有表的名字
SHOW tables;

-- 显示指定表的详细结构，包括约束
DESC table_name;
```

### 新建表

```sql
create table 表名
(
    字段1 字段类型1,
    字段2 字段类型2(长度)
) [character set 字符集] [collate 校对规则] [engine 存储引擎];

# 如果创建表时不指定字符集和校对规则, 则默认都为表所在数据库的字符集和校对规则
```

### 复制表

复制表的结构

```sql
CREATE TABLE table_new
LIKE table_old;
```

### 修改表

```sql
-- 添加字段
ALTER TABLE table_name
ADD
(column datatype[, column datatype]);

-- 修改字段
ALTER TABLE table_name
MODIFY
(column datatype[, column datatype]);

-- 删除字段
ALTER TABLE table_name
DROP
(column [, column]);

-- 修改表名
RENAME TABLE table_name TO table_name_new

-- 修改表字符集
ALTER TABLE table_name CHARACTER SET charset;
```

### 删除表

```sql
DROP TABLE [IF EXISTS] 表名1 [, 表名2, ...];
```

### 表复制

为了测试 SQL 语句的效率，可以复制表以获取海量数据。

```sql
-- 他表复制
INSERT INTO table_new
(...)
SELECT *
FROM
table_old;

-- 自我复制
INSERT INTO table_new
SELECT * 
FROM table_new;
```

### 表数据去重

```sql
-- 创建一个临时表，复制表结构
CREATE TABLE temp
LIKE old;

-- 向临时表加入不重复的数据
INSERT INTO temp
SELECT DISTINCT * FROM old;

-- 清空旧表
DELETE FROM old;

-- 导入数据
INSERT INTO old
SELECT * FROM temp;

-- 删除临时表
DROP TABLE temp;
```

## 数据操作

### INSERT

```mysql
-- 插入全部字段
INSERT INTO 表名 
VALUES
(字段1元素, 字段2元素...);

-- 插入指定字段
INSERT INTO 表名
(字段1, 字段2...)
VALUES
(字段1元素, 字段2元素...);
```

**注意事项：**字符串和日期数据应使用单引号包含

### UPDATE

```sql
UPDATE table_name
SET column = value[, column = value...]
[WHERE column = ?;]
-- 如果不带 WHERE 子句会 修改 所有记录
```

### DELETE

```sql
DELETE FROM table_name
[where column = ?;]
-- 如果不带 WHERE 子句会 删除 所有记录
```

### SELECT

```sql
SELECT [DISTINCT] * | {column1, column2...}
FROM table_name 
[WHERE column = ?];
```

- DISTINCT 去重：每个字段都相同才会去重
- SELECT 可以显示指定字段
- 可以对字段进行运算
- AS：可以给字段起别名（也可使用**单个空格**代替 AS）

```sql
SELECT name, (chinese, english, math) AS sum
FROM student
```

# MySQL 函数

## 统计函数

### WHERE 子句运算符

| 运算符               | 描述                                  |
| :------------------- | :------------------------------------ |
| `>`                  | 大于                                  |
| `<`                  | 小于                                  |
| `>=`                 | 大于等于                              |
| `<=`                 | 小于等于                              |
| `=`                  | 等于                                  |
| `<>`                 | 不等于 (SQL 标准)                     |
| `!=`                 | 不等于 (部分数据库支持，与 `<>` 相同) |
| `BETWEEN ... AND`    | 值在两个指定值之间（包含边界）        |
| `IN(value1, value2)` | 值等于列表中的任意一个值              |
| `LIKE`               | 匹配指定模式的字符串                  |
| `NOT LIKE`           | 不匹配指定模式的字符串                |
| `IS NULL`            | 检查值是否为 NULL                     |
| `IS NOT NULL`        | 检查值是否不为 NULL                   |
| `AND`                | 两个条件都为真时返回真                |
| `OR`                 | 任意一个条件为真时返回真              |
| `NOT`                | 反转条件的逻辑结果                    |

### COUNT

- `COUNT(*)` 统计满足条件的记录的个数
- `COUNT(column)  `统计满足条件的列的个数，排除 column 为 NULL 的记录
- 括号里可以叠加 `DISTINCT`

```sql
SELECT COUNT(*)
FROM student
```

### SUM

返回满足条件的所有记录的指定数值字段的之和。

```sql
SELECT SUM(math)
FROM student
```

### AVG

返回满足条件的所有记录的指定数值字段的平均数。

```sql
SELECT AVG(math)
FROM student
```

### MAX / MIN

```sql
SELECT MAX(math), MIN(math)
FROM student
```

## 字符串函数

| 函数名称                                | 功能描述                                           |
| --------------------------------------- | -------------------------------------------------- |
| `CHARSET(str)`                          | 返回字符串的字符集                                 |
| `CONCAT(string2 [,...])`                | 连接字符串                                         |
| `INSTR(string, substring)`              | 返回substring在string中出现的位置，没有返回0       |
| `UCASE(string2)`                        | 转换成大写                                         |
| `LCASE(string2)`                        | 转换成小写                                         |
| `LEFT(string2, length)`                 | 从string2中的左边起取length个字符                  |
| `LENGTH(string)`                        | string长度[按照字节]                               |
| `REPLACE(str, search_str, replace_str)` | 在str中用replace_str替换search_str                 |
| `STRCMP(string1, string2)`              | 逐字符比较两字符串大小                             |
| `SUBSTRING(str, position [,length])`    | 从str的position开始【从1开始计算】，取length个字符 |
| `LTRIM(string2)`                        | 去除前端空格                                       |
| `RTRIM(string2)`                        | 去除后端空格                                       |
| `TRIM(string2)`                         | 去除前后端空格                                     |

## 数学函数

| 函数                             | 作用                         |
| -------------------------------- | ---------------------------- |
| `ABS(number)`                    | 绝对值                       |
| `BIN(number)`                    | 十进制转二进制               |
| `CONV(number, 原进制, 目标进制)` | 进制转换                     |
| `CEILING(number)`                | 向上取整                     |
| `FLOOR(number)`                  | 向下取整                     |
| `FORMAT(number, bit)`            | 保留小数（四舍五入）         |
| `LEAST(set)`                     | 返回集合最小值               |
| `MOD()`                          | 求余数                       |
| `RAND()`                         | 返回随机数 $\in[0, 1]$       |
| `RAND(seed)`                     | 返回固定随机数，与 seed 绑定 |

## 时间日期

| 函数名称                                    | 功能描述                       |
| ------------------------------------------- | ------------------------------ |
| `CURRENT_DATE()`                            | 返回当前日期                   |
| `CURRENT_TIME()`                            | 返回当前时间                   |
| `CURRENT_TIMESTAMP()`                       | 返回当前时间戳（年月日时分秒） |
| `DATE(datetime)`                            | 提取日期部分                   |
| `DATE_ADD(date, INTERVAL expr unit)`        | 日期/时间加法                  |
| `DATE_SUB(date, INTERVAL expr unit)`        | 日期/时间减法                  |
| `DATEDIFF(date1, date2)`                    | 日期差（返回天数）             |
| `TIMEDIFF(time1, time2)`                    | 时间差（返回时:分:秒）         |
| `NOW()`                                     | 返回当前日期和时间             |
| `YEAR(date)`                                | 提取年份                       |
| `MONTH(date)`                               | 提取月份                       |
| `DAY(date)`                                 | 提取日份                       |
| `UNIX_TIMESTAMP()`                          | 返回 1970-01-01 到现在的秒数   |
| `FROM_UNIXTIME(UNIX_TIMESTAMP()[, format])` | Unix 时间戳转日期              |

> 日期加减法的单位可使用：YEAR, MONTH, DAY, HOUR, MINUTE, SECOND

## 加密函数

| 函数名称        | 功能描述                                 |
| --------------- | ---------------------------------------- |
| `USER()`        | 返回 MySQL 登陆的用户                    |
| `DATABASE()`    | 返回当前使用的数据库                     |
| `MD5(str)`      | 字符串转换为 MD5 加密 32 位串            |
| `PASSWORD(str)` | MySQL 数据库的用户密码就使用这个进行加密 |

## 流程控制

| 表达式                                                       | 描述                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| `IF(expr1, expr2, expr3)`                                    | 如果 `expr1` 为 `True`，则返回 `expr2`，否则返回 `expr3`     |
| `IFNULL(expr1, expr2)`                                       | 如果 `expr1` 不为空 `NULL`，则返回 `expr1`，否则返回 `expr2` |
| SELECT CASE <br>WHEN expr1 THEN expr2 <br>WHEN expr3 THEN expr4 <br>ELSE expr5 <br>END; | 如果 `expr1` 为 `True`，则返回 `expr2`，<br>如果 `expr2` 为 `t`，返回 `expr4`，<br>否则返回 `expr5` |

# MySQL 查询

## 单表查询

### 比较日期

格式需要与原数据格式一致

```sql
WHERE date > '1992-01-01';
```

### 模糊查询

- % 表示 0 到多个任意字符
- \_ 表示单个任意字符

```sql
-- 显示 周 开头的名字
WHERE name LIKE '周%';
```

### 判断空值

```sql
WHERE name IS NULL;

WHERE name IS NOT NULL;
```

### GROUP BY

对查询结果进行分组

```sql
-- 显示每个组最高工资和平均工资
SELECT MAX(sal), AVG(sal), group_id
FROM salary
GROUP BY group_id;
```

### HAVING

对分组结果进行过滤

```sql
-- 显示平均工资小于2000的组最高工资和平均工资
SELECT MAX(sal), AVG(sal) AS sal_avg, group_id
FROM salary
GROUP BY group_id
HAVING sal_avg < 2000;
```

### 结果排序

位于 SELECT 语句结尾，用于排序结果：

- ASC：升序
- DESC：降序

```sql
...
ORDER BY column1 ASC | DESC[, column2 ASC | DESC ...]
```

### 分页查询

```sql
-- 从 START + 1 行开始，取 ROW 行
SELECT *
FROM student
LIMIT START, ROW;

- 每页显示数 * (第 n 页 - 1), 每页显示数
```

已知每页显示 $n$ 条记录，要求显示第 $m$ 页
$$
START = n * (m - 1)
$$

## 多表查询

两张表查询没有限制条件时，默认是笛卡尔积。

```sql
SELECT name, student.class_id
FROM student, class
WHERE student.class_id = class.class_id
```

### 自连接

```sql
-- 显示公司员工和他上级的名字
SELECT emp1.ename AS '职员名', emp2.ename AS '上级名'
FROM emp emp1, emp emp2
WHERE emp1.mgr = emp2.empno;
```

### 子查询

```sql
-- 单行子查询：查询与 smith 同一部门的所有员工
SELECT *
FROM emp
WHERE deptno = (
  SELECT deptno
  FROM emp
  WHERE ename = 'smith'
);

-- 多行子查询：查询和 10 号部门工作相同的雇员，不包含 10 号部门
SELECT ename, job, sal, deptnop
FROM emp
WHERE job IN (
  SELECT DISTINCT job
  FROM emp
  WHERE deptno = 10
) AND deptno <> 10;
```

### 临时表

```sql
-- 查询每个类别中价格最高的商品的信息
SELECT goods_id, temp.cat_id, goods_name, shop_price
FROM (
	SELECT cat_id, MAX(shop_price) AS max_price
  FROM ecs_goods
  GROUP BY cat_id
) temp, ecs_goods
WHERE temp.cat_id = ecs_goods.cat_id
AND temp.max_price = ecs_goods.shop_price;
```

### ALL

```sql
-- 显示工资比部门 30 的所有员工的工资都高的员工
SELECT ename, sal, deptno
FROM emp
WHERE sal > ALL(
	SELECT sal
  FROM emp
  WHERE deptno = 30
);
```

### ANY

```sql
-- 显示工资比部门 30 其中一个员工的工资高的员工
SELECT ename, sal, deptno
FROM emp
WHERE sal > ANY(
	SELECT sal
  FROM emp
  WHERE deptno = 30
);
```

### 多列子查询

返回多个列数据的子查询语句

```sql
-- 查询与 smith 同部门同岗位的其他员工信息
SELECT *
FROM emp
WHERE (deptno, job) = (
  SELECT deptno, job
  FROM emp
  WHERE ename = 'smith'
) AND ename != 'smith';
```

## 合并查询

### UNION ALL

合并两个查询结果，不去重

```sql
SELECT ename, sal, job
FROM emp
WHERE sal > 2500
UNION ALL
SELECT ename, sal, job
FROM emp
WHERE job = 'MANAGER';
```

### UNION

合并两个查询结果，去重

```sql
SELECT ename, sal, job
FROM emp
WHERE sal > 2500
UNION
SELECT ename, sal, job
FROM emp
WHERE job = 'MANAGER';
```

## 连接查询

### 左外连接

左侧表完全显示，即使左边表部分记录没有与右侧表相匹配

```sql
-- 显示全部学生，即使该学生没有成绩
SELECT name, stu.id, grade
FROM stu
LEFT JOIN exam
ON stu.id = exam.id;
```

### 右外连接

右侧表完全显示，即使右边表部分记录没有与左侧表相匹配

```sql
-- 显示全部成绩，即使没有学生表中不存在的学生
SELECT name, stu.id, grade
FROM stu
RIGHT JOIN exam
ON stu.id = exam.id;
```

### 内连接

```sql
SELECT name, stu.id, grade
FROM stu
JOIN exam
ON stu.id = exam.id;
```

# MySQL 约束

## 主键约束

`PRIMARY KEY`

- 主键在同一张表中只有一个
- 可以有复合主键，保证组合唯一
- 主键字段的数据不能重复，不能为空

```sql
-- 单一主键
CREATE TABLE table_name (
	id INT PRIMARY KEY,
  name VARCHAR(12)
);

-- 复合主键
CREATE TABLE table_name (
	id INT,
  name VARCHAR(12)，
  PRIMARY KEY (id, name)
);
```

## 非空约束

`NOT NULL` 限制指定字段值不能为 NULL

```sql
CREATE TABLE table_name (
	id INT PRIMARY KEY,
  name VARCHAR(12) NOT NULL
);
```

## 唯一约束

`UNIQUE` 限制指定字段值不能重复

- 如果被 `UNIQUE` 约束的字段，没有被 `NOT NULL` 约束，那么可以有多个 `NULL`。
- 如果一个字段既被 `UNIQUE` 约束，又被 `NOT NULL` 约束，那么非常接近主键。

```sql
CREATE TABLE table_name (
	id INT PRIMARY KEY,
  name VARCHAR(12) NOT NULL,
  phone, VARCHAR(11) UNIQUE
);
```

## 外键约束

`FOREIGN KEY` 外键，指一个表中的字段（或字段集合），它的值必须匹配另一个表的**主键（或唯一键）**的值。

- 子表（从表）：包含外键的表。
- 父表（主表）：被外键引用的表。子表中的外键值必须来源于父表的主键值。

```sql
CREATE TABLE stu (
	id INT PRIMARY KEY,
  name VARCHAR(12) NOT NULL,
  phone VARCHAR(11) UNIQUE,
  class_id INT,
  FOREIGN KEY (class_id) REFERENCES class(class_id)
);
```

**注意事项：**

- 外键指向的主表的字段必须为主键或唯一键
- 表的类型是 innodb 支持外键
- 外键字段类型，要与被引用的字段类型一致（长度可以不同）
- 外键字段值，要在被引用字段中存在，或为 `NULL`
- 父表中的某条记录被子表所引用，数据库默认会阻止删除这条父表记录

## 检查约束

> MySQL  8.0.16 版本之前不支持 `CHECK`，只做语法校验。

`CHECK()` 根据一个逻辑表达式来验证列中的值，确保数据符合特定的业务规则。

```sql
CREATE TABLE table_name (
	sal DOUBLE CHECK(sal > 2000 AND sal < 10000),
  sex VARCHAR(8) CHECK(sex IN('male', 'female'))
);
```

## 默认约束

`DEFAULT ` 当向表中插入新记录但没有为该列指定值时，数据库会自动使用指定的**默认值**。

```sql
CREATE TABLE table_name (
	registration_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);
```

## 自增长

`AUTO_INCREMENT` 

- 一个表最多只能有一个自增长列，且该列必须被定义为主键或唯一键
- 查找最后插入的 ID `SELECT LAST_INSERT_ID();`
- 指定自增长 `ALTER TABLE table_name AUTO_INCREMENT = new_value;`
- 自增长只保证唯一和递增，不保证连续

```sql
CREATE TABLE table_name (
	id INT PRIMARY KEY AUTO_INCREMENT-- 将id列设置为自增长主键
);
```

# MySQL 索引

索引相当于书的目录，提升查询数据的速度，本质是以空间换时间。

索引只对被索引的字段的数据优有效，对其他字段数据无效。

## 索引代价

- 多占用磁盘空间
- 影响 UPDATE DELETE INSERT 语句效率，因为索引的变更会导致索引树数据结构发生重建

## 索引原理

当没有索引时，查询数据默认全表扫描，时间复杂度为 $O(n)$。

当建立索引时，DBMS 为表格字段创建一个二叉树，时间复杂度为 $O(log_2n)$

## 索引类型

- 主键索引：PRIMARY KEY
- 唯一索引：UNIQUE
- **普通索引（常用）**：INDEX 可重复
- 全文索引：FULLTEXT（开发中，全文搜索使用 Solr 和 ElasticSearch 框架）

## 索引使用

### 查询索引

```sql
SHOW INDEXE FROM table_name;

SHOW INDEXES FROM table_name;

SHOW KEY FROM table_name;
```

### 创建索引

```sql
CREATE [UNIQUE] INDEX index_name
ON table_name(filed_name);

-- 添加索引
ALTER TABLE table_name
ADD [UNIQUE] INDEX index_name (column_name);

-- 添加主键索引
ALTER TABLE table_name
ADD PRIMARY KEY (column_name);
```

### 删除索引

```sql
DROP INDEX index_name
ON table_name
```

## 索引设计

- 频繁作为查询条件字段应该创建索引
- 唯一性太差的字段不适合创建索引
- 更新频繁的字段不适合创建索引
- 不会出现在 WHERE 子句中的字段不该创建索引

# MySQL 事务

事务使多个 DML 语句当做一个整体，保证 SQL 语句要么全部成功，要么全部失败。常用在支付、交易业务中，以保证数据一致性。

## 事务语法

MySQL 事务依赖 `innodb` 存储引擎，MyISAM 不支持事务。

```sql
-- 开始事务
START TRANSACTION
-- 设置保存点 a
SAVEPOINT a
-- 执行语句 1
INSERT INTO T1 VALUES(200, 'ZXB');
-- 设置保存点 b
SAVEPOINT b
-- 执行语句 2
INSERT INTO T1 VALUES(100, 'ZHOUXINBIN');
-- 回滚到保存点 a
ROLLBACK TO a
-- 回滚到事务的开始
ROLLBACK
-- 提交事务：提交之后不能回滚，提交之后 SQL 语句真正生效
COMMIT
```

## 事务开启

事务开启方式有两种：

- `START TRANSACTION`：事务的提交和回滚都会导致本事务结束。
- `SET AUTOCOMMIT = OFF`：本种方式开启事务后，提交或回滚之后自动开启新的事务；结束事务需要手动打开自动提交，或会话结束。

## 事务隔离

多个连接开启各自事务操作数据库中数据时，数据库系统要负责隔离操作，以保证各个连接获取数据的准确性。

- **脏读**：当一个事务读取另一事务尚未提交的修改时
- **不可重复读**：在同一事务中多次进行同一查询，由于其他提交事务作出了修改或删除，每次返回不同的结果
- **幻读**：在同一事物中多次进行同一查询，由于其他提交事务作出了插入操作，每次返回不同的结果集

## 隔离级别

隔离级别：事务与事务之间个隔离程度。

| 隔离级别（$\checkmark$ 可能出现，$\texttimes$ 不会出现） | 脏读         | 不可重复读   | 幻读         | 加锁读 |
| -------------------------------------------------------- | ------------ | ------------ | ------------ | ------ |
| 读未提交（READ UNCOMMITTED）                             | $\checkmark$ | $\checkmark$ | $\checkmark$ | 不加锁 |
| 读已提交（READ COMMITTED）                               | $\texttimes$ | $\checkmark$ | $\checkmark$ | 不加锁 |
| 可重复读（REPEATABLE READ）                              | $\texttimes$ | $\texttimes$ | $\texttimes$ | 不加锁 |
| 可串行化（SERIALIZABLE）                                 | $\texttimes$ | $\texttimes$ | $\texttimes$ | 加锁   |

## 隔离指令

**查询系统事务隔离级别：**

```sql
SELECT @@global.tx_isolation;
```

**设置系统事务隔离级别：**

```sql
SET GLOBAL TRANSACTION ISOLATION LEVEL
REPEATABLE READ;
```

------

**查询当前会话事务隔离级别：**

```sql
SELECT @@tx_isolation;
```

**设置当前会话事务隔离级别：**

```sql
SET SESSION TRANSACTION ISOLATION LEVEL
READ UNCOMMITTED;
```

------

**默认全局事务隔离级别：**

MySQL 默认事务隔离级别是 `REPEATABLE READ`。

如果需要修改 MySQL 默认全局事务隔离级别，需要修改 `my.ini` 配置文件。

```ini
transaction-isolation = REPEATABLE READ
```

## ACID

**原子性 (Atomicity)：**事务是一个不可分割的最小工作单元。这意味着事务中的所有操作要么全部成功完成并提交，要么全部失败并回滚到事务开始前的状态。

**一致性 (Consistency)：**事务执行前后，数据库必须从一个有效的一致状态转换到另一个有效的一致状态。这意味着事务必须遵守所有的预定义规则、约束和业务逻辑。

**隔离性 (Isolation)：**多个并发执行的事务之间互不干扰，就好像它们是串行执行的一样。一个事务的中间状态对其他事务是不可见的。

**持久性 (Durability)：**一旦事务成功提交，其对数据库的修改就是永久性的，即使系统发生故障（如断电、崩溃），这些修改也不会丢失。

# MySQL 存储引擎

MySQL 表类型由存储引擎决定。

存储引擎有：MyISAM, innoDB, Memory

表类型有：CSV, MEmory, ARCHIVE, MRG_MYISAM, MYISAM, InnoBDB

| 特性/引擎                 | **InnoDB**                                        | **MyISAM**                                           | **Memory (HEAP)**                  | **CSV**                           | **Archive**                          |
| :------------------------ | :------------------------------------------------ | :--------------------------------------------------- | :--------------------------------- | :-------------------------------- | :----------------------------------- |
| **主要用途**              | 事务型应用，高并发，数据完整性要求高              | 读密集型应用，简单查询，数据仓库（旧）               | 临时表，高速缓存，数据不需持久化   | 导入/导出数据，与外部程序交换数据 | 大量历史数据存储，日志记录，只写不读 |
| **事务支持**              | **支持 (ACID)**                                   | **不支持**                                           | 不支持                             | 不支持                            | 不支持                               |
| **行级锁**                | **支持**                                          | **不支持 (表级锁)**                                  | 表级锁                             | 表级锁                            | 表级锁                               |
| **外键约束**              | **支持**                                          | **不支持**                                           | 不支持                             | 不支持                            | 不支持                               |
| **崩溃恢复**              | **支持 (通过事务日志)**                           | **不支持 (可能数据损坏)**                            | 不支持 (数据丢失)                  | 不支持 (数据丢失)                 | 支持 (通过日志)                      |
| **MVCC (多版本并发控制)** | **支持**                                          | 不支持                                               | 不支持                             | 不支持                            | 不支持                               |
| **全文索引**              | **支持 (MySQL 5.6+)**                             | **支持**                                             | 不支持                             | 不支持                            | 不支持                               |
| **空间数据索引 (GIS)**    | **支持 (MySQL 5.7.5+)**                           | **支持**                                             | 不支持                             | 不支持                            | 不支持                               |
| **数据存储**              | 表数据和索引存储在 `.ibd` 文件中（或共享表空间）  | 表数据 `.MYD`，表结构 `.frm`，索引 `.MYI`            | 内存中                             | `.csv` 文件                       | `.ARZ` 文件 (高度压缩)               |
| **数据压缩**              | **支持 (MySQL 5.1+)**                             | 不支持                                               | 不支持                             | 不支持                            | **支持 (自动压缩)**                  |
| **B树索引**               | **支持**                                          | **支持**                                             | 支持 (哈希索引是默认，B树可选)     | 不支持                            | 不支持                               |
| **哈希索引**              | **自适应哈希索引 (自动)**                         | 不支持                                               | **支持 (默认)**                    | 不支持                            | 不支持                               |
| **计数 (COUNT(*))**       | 慢 (需要扫描索引或表)                             | 快 (直接读取元数据)                                  | 快                                 | 慢                                | 慢                                   |
| **适用场景**              | OLTP (在线事务处理)，高并发读写，数据一致性要求高 | OLAP (在线分析处理) 的部分场景，日志记录，网站计数器 | 临时数据，会话管理，高速查找，测试 | 与电子表格或外部系统交换数据      | 大量不常访问的归档数据，日志数据     |
| **默认引擎**              | **MySQL 5.5.5+ 的默认引擎**                       | MySQL 5.5.5 之前的默认引擎                           |                                    |                                   |                                      |

**查看存储引擎**

```sql
SHOW ENGINE;
```

**修改存储引擎**

```sql
ALTER TABLE table_name
ENGINE = Innodb;
```

# MySQL 视图

视图是一个虚拟表，数据来源基表，**映射关系**。

通过视图修改基表的数据，基表改变也会同步改变视图的数据。

## 创建视图

```SQL
CREATE VIEW view_name
AS
SELECT
```

## 修改视图

```sql
ALTER VIEW view_name
AS
SELECT
```

## 查看视图语句

```sql
SHOW CREATE VIEW view_name
```

## 删除视图

```sql
DROP VIEW view_1[, view2...]
```

# MySQL 管理

## 用户管理

MySQL 所有用户信息存储在 mysql.user 表中，

- host: 允许登陆的位置
- user: 用户名
- authentication_string: 密码，通过 password() 函数加密的密码

### 创建用户

```sql
CREATE USER 'user'@'host' IDENTIFIED BY 'password';
```

### 删除用户

```sql
DROP USER 'user'@'host';
```

### 修改自己密码

```sql
SET PASSWORD = PASSWORD('pwd');
```

### 修改别人密码

需要拥有权限

```sql
SET PASSWORD FOR 'user'@'host' = PASSWORD('pwd');
```

### host

```sql
-- 所有 IP 均可连接
CREATE USER 'user' IDENTIFIED BY 'password';

-- 指定网段可连接
CREATE USER 'user'@'192.168.0.%' IDENTIFIED BY 'password';

-- 指定网段可连接
CREATE USER 'user'@'192.168.0.%' IDENTIFIED BY 'password';
```

## 权限管理

### 授予权限

```sql
GRANT 权限列表 ON 库.对象（表，视图，存储过程）
TO 'user'@'host'
[IDENTIFIED BY 'password']
-- 如果用户存在，同时修改密码
-- 如果用户不存在，同时创建用户
```

### 回收权限

```sql
-- 如果用户 host 不是 % 需指定 host
REVOKE 权限列表 ON 库.对象 FROM 'user'@'host'
[FLUSH PRIVILEGES]
```







