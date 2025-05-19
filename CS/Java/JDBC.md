# JDBC

## 概念

#### 简介

JDBC是使用Java语言操作关系型数据库的一套API. 全称: JavaDataBaseConnectivity. 

#### 本质

数据库厂商实现JDBC接口, 提供数据库驱动的jar包, 真正执行代码的是驱动jar包中的实现类.

#### 优点

个数据库厂商使用相同的接口, Java代码不需要针对不同数据库厂商分别开发

可随时替换底层数据库, 访问数据库的Java代码不变

## 步骤

1. 创建工程, 导入jar包

2. 注册驱动

   ```java
   Class.forName("com.mysql.jdbc.Driver");
   ```

   Driver类里面静态代码块调用DriverManager.registDriver()进行注册驱动

   <img src="https://cdn.jsdelivr.net/gh/chousinbin/Image/202307061344419.png" alt="image-20230706134458362" style="zoom:33%;" />

   MySQL jar包5版本后, 也可以省略注册驱动的代码, 因为驱动包/services/java.sql.Driver里面记录了驱动类的名称

3. 获取连接

   ```java
   Connection conn = DriverManager.getConnection(url, username, password);
   ```

4. 定义SQL语句

   ```java
   String sql = "...";
   ```

5. 获取执行SQL对象

   ```java
   Statement stmt = conn.createStatement();
   ```

6. 发送SQL语句

   ```java
   stmt.executeUpdate(sql);
   ```

7. 处理返回结果

8. 释放资源