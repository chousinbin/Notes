# 简介

JDBC 是使用 Java 语言操作关系型数据库的一套 API。全称 Java Data Base Connectivity

数据库厂商实现 JDBC 接口, 提供数据库驱动的 jar 包, 真正执行代码的是驱动 jar 包中的实现类。

**优点：**

- 各个数据库厂商使用相同的 Java 接口, Java 代码不需要针对不同数据库厂商分别开发。·
- 可随时替换底层数据库, 访问数据库的 Java 代码不变。

# Quick Start

1. 创建工程, 导入`mysql-connector-j-8.0.33.jar` 包

2. 注册驱动

   ```java
   Class.forName("com.mysql.cj.jdbc.Driver");
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

## 示例代码

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

JDK 1.5 之后支持自动注册驱动：

<img src="https://cdn.jsdelivr.net/gh/chousinbin/Image/202509291620123.png" alt="image-20250929162039068" style="zoom:33%;" />

## 使用配置文件

`mysql.properties`

```java
public void type5() throws ClassNotFoundException, SQLException, IOException {
    // 获取配置信息
    Properties properties = new Properties();
    properties.load(new FileInputStream("src/com/sinbin/jdbc_/mysql.properties"));
    String user = properties.getProperty("user");
    String password = properties.getProperty("password");
    String url = properties.getProperty("url");
    String driver = properties.getProperty("driver");
    // 注册驱动
    Class.forName(driver);
    // 获取连接对象
    Connection connection = DriverManager.getConnection(url, user, password);
    Statement statement = connection.createStatement();
    // 执行 SQL
    String sql = "insert into users values(null, 'xxb', '23', 'xxb@neu.com')";
    int res = statement.executeUpdate(sql);
    System.out.println(res > 0 ? "成功" : "失败");
    // 关闭连接
    statement.close();
    connection.close();
}
```

# JDBC API

## ResultSet

```java
String sql = "select * from users";
// 结果集
ResultSet resultSet = statement.executeQuery(sql);
while (resultSet.next()) {
    // 可以使用列序号
    int id = resultSet.getInt(1);
    String name = resultSet.getString(2);
  	// 也可以使用列名
    int age = resultSet.getInt("age");
    String mail = resultSet.getString(3);
    System.out.println(id + " " + name + " " + age + " " + mail);
}
```

## Statement

接口，用于执行静态 SQL 语句，并返回其生成的结果的对象。但存在 SQL 注入风险。

```java
// 获取用户参数
/*
    1' OR
    OR '1' = '1
 */
Scanner scanner = new Scanner(System.in);
String adminName = scanner.nextLine();
String adminPassword = scanner.nextLine();
// 执行 SQL
String sql = "select * from admin where name = '" + adminName + "' and password = '" + adminPassword + "'";
// 结果集
ResultSet resultSet = statement.executeQuery(sql);
if (resultSet.next()) {
    System.out.println("用户存在");
} else {
    System.out.println("用户不存在");
}
```

## SQL 注入

```sql
-- 原 SQL 语句
SELECT *
FROM users
WHERE name = 'zxb' AND pwd = '123';

-- 注入如下
-- 用户名输入：1' OR
-- 密码输入：OR '1' = '1

-- 导致 SLQ 语句变为
SELECT *
FROM users
WHERE name = '1' OR 'AND pwd = ' OR '1' = '1';
```

## PreparedStatement

- 不再拼接字符串，用问号代替参数值
- 解决 SQL 注入
- 减少编译次数

```java
public class PrepareStatement_ {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        // 获取用户参数
        Scanner scanner = new Scanner(System.in);
        String adminName = scanner.nextLine();
        String adminPassword = scanner.nextLine();
        // 读取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/com/sinbin/jdbc_/mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        // 注册驱动
        Class.forName(driver);
        // 获取连接对象
        Connection connection = DriverManager.getConnection(url, user, password);
        // 获取 PreparedStatement
        String sql = "select * from admin where name = ? AND password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // 设置参数
        preparedStatement.setString(1, adminName);
        preparedStatement.setString(2, adminPassword);
        // 结果集
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            System.out.println("用户存在");
        } else {
            System.out.println("用户不存在");
        }
        // 关闭连接
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
```

## CallableStatement

它是 PreparedStatement 的子接口，专门用于调用数据库中的存储过程或函数。

# JDBC Utils

降低代码冗余度。

```java
public class Utils {
    private static String user;
    private static String password;
    private static String url;
    private static String driver;
    // 获取配置文件信息
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/com/sinbin/jdbc_/mysql.properties"));
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
        } catch (IOException e) {
            // 将编译异常转为运行异常
            // 调用者可以捕获异常，也可以默认处理异常
            throw new RuntimeException(e);
        }
    }
    // 获取连接
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // 关闭资源
    public static void close(ResultSet rs, Statement st, Connection con) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
```

# 事务

让多个 SQL 语句作为一个整体。

```java
public class Transaction_ {
    public static void main(String[] args) {
        String sql1 = "update account set balance = balance - 100 where id = ?";
        String sql2 = "update account set balance = balance + 100 where id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = Utils.getConnection();
            // 关闭默认自动提交，开启事务
            connection.setAutoCommit(false);
            // 转账 1
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.setDouble(1, 1);
            preparedStatement.executeUpdate();
            // 转账 2
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.setDouble(1, 2);
            preparedStatement.executeUpdate();
          	// 提交事务
            connection.commit();
        } catch (SQLException e) {
            try {
                // 默认回滚到事务开启时
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {
            Utils.close(resultSet, preparedStatement, connection);
        }
    }
}
```

# 批处理

使用批处理时，需要在 URL 中添加参数

```
?rewriteBatchedStatements=true
```

## 代码对比

```java
public class Batch_ {
    @Test
    public void defaultMode() throws SQLException {
        Connection connection = Utils.getConnection();
        String sql = "insert into admin2 values(null, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1, "zxb" + i);
            preparedStatement.setString(2, "123");
            preparedStatement.executeUpdate();
        }
        long end = System.currentTimeMillis();
        System.out.println("普通耗时 " + (end - start)); //513
        Utils.close(null, preparedStatement, connection);
    }
    @Test
    public void batchMode() throws SQLException {
        Connection connection = Utils.getConnection();
        String sql = "insert into admin2 values(null, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1, "zxb" + i);
            preparedStatement.setString(2, "123");
            preparedStatement.addBatch();
            // 每 1000 执行一次
            if ((i + 1) % 1000 == 0) {
                preparedStatement.executeBatch();
                preparedStatement.clearBatch();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("批处理耗时 " + (end - start)); //55
        Utils.close(null, preparedStatement, connection);
    }
}

```

# 数据库连接池

普通方式连接数据库关闭数据库模式，浪费系统资源，不能控制连接数量。

如果遇到程序出现异常，连接不能释放，导致内存泄漏。

## 连接池原理

维护一个连接对象的池子，里面有一定数量的连接对象。

当程序需要连接对象时，从池子中获取一个连接对象，使用完毕后，不关闭连接，把对象放回。

当需求大于池子所提供的连接对象个数时，程序进入等待队列。

## 连接池种类

JDBC 的数据库连接池使用 javax.sql.DataSource 来表示，DataSource 只是一个接口，该接口通常由第三方提供实现

- **C3P0** 数据库连接池，速度相对较慢，稳定性不错 (hibernate, spring)
- DBCP 数据库连接池，速度相对c3p0较快，但不稳定
- Proxool 数据库连接池，有监控连接池状态的功能，稳定性较c3p0差一点
- BoneCP 数据库连接池，速度快
- **Druid**(德鲁伊) 是阿里提供的数据库连接池，集DBCP、C3P0、Proxool 优点于一身的数据库连接池

## C3P0

### lib 文件

`c3p0-0.9.1.2.jar`

### 配置文件

配置文件放在 src 目录下，名字为 `c3p0-config.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<c3p0-config name="zxb_c3p0">
    <default-config>
        <!-- MySQL 8.x 驱动 -->
        <property name="driverClass">com.mysql.cj.jdbc.Driver</property>
        <!-- MySQL 8.x URL (注意时区参数) -->
        <property name="jdbcUrl">jdbc:mysql://localhost:3306/mysql_test?useUnicode=true&amp;characterEncoding=utf8&amp;serverTimezone=Asia/Shanghai</property>
        <!-- 数据库用户名 -->
        <property name="user">root</property>
        <!-- 数据库密码 -->
        <property name="password">zxb19990079994...</property>

        <!-- 连接池初始化时创建的连接数 -->
        <property name="initialPoolSize">5</property>
        <!-- 连接池中最小的连接数 -->
        <property name="minPoolSize">5</property>
        <!-- 连接池中最大的连接数 -->
        <property name="maxPoolSize">20</property>
        <!-- 连接池在获得新连接时，一次性获得的最大连接数 -->
        <property name="acquireIncrement">3</property>

        <!-- 连接的最大空闲时间，单位秒。如果连接在池中空闲了maxIdleTime秒，则将其丢弃。0表示永不丢弃。 -->
        <property name="maxIdleTime">1800</property> <!-- 30分钟 -->

        <!-- 连接在池中保持的最长时间，单位秒。0表示永不丢弃。 -->
        <!-- <property name="maxConnectionAge">14400</property> --> <!-- 4小时 -->

        <!-- 当连接池用完时，c3p0获取新连接的等待时间，单位毫秒。0表示无限等待。 -->
        <property name="checkoutTimeout">30000</property> <!-- 30秒 -->

        <!-- 连接失败重试次数 -->
        <property name="acquireRetryAttempts">30</property>
        <!-- 连接失败重试间隔时间，单位毫秒 -->
        <property name="acquireRetryDelay">1000</property>

        <!-- 是否在获取连接失败时打印堆栈跟踪信息 -->
        <property name="breakAfterAcquireFailure">false</property>

        <!-- 每隔多少秒检查所有连接池中的空闲连接，单位秒。 -->
        <property name="idleConnectionTestPeriod">60</property> <!-- 1分钟 -->

        <!-- 验证连接是否有效。如果为true，则在每次从连接池中获取连接时都对其进行测试。 -->
        <!-- 建议设置为true，以确保获取到的连接是可用的。 -->
        <property name="testConnectionOnCheckin">false</property>
        <property name="testConnectionOnCheckout">true</property>

        <!-- 连接测试查询语句。如果数据库支持，建议使用一个简单的查询，如 "SELECT 1"。 -->
        <!-- MySQL/PostgreSQL -->
        <property name="preferredTestQuery">SELECT 1</property>
        <!-- Oracle -->
        <!-- <property name="preferredTestQuery">SELECT 1 FROM DUAL</property> -->

        <!-- 是否自动提交事务，默认为true -->
        <!-- <property name="autoCommitOnClose">true</property> -->

        <!-- 连接池的名称，用于日志输出 -->
        <property name="dataSourceName">myAppDataSource</property>

        <!-- C3P0日志级别，可选值：OFF, SEVERE, WARNING, INFO, CONFIG, FINE, FINER, FINEST, ALL -->
        <!-- <property name="debugUnreturnedConnectionStackTraces">true</property> -->
        <!-- <property name="unreturnedConnectionTimeout">60</property> -->
    </default-config>
</c3p0-config>
```

### 代码使用

```java
public void C3P0Mode2() throws SQLException {
    ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("zxb_c3p0");
    Connection connection = comboPooledDataSource.getConnection();
    System.out.println("success");
    connection.close();
}
```

## Druid

### lib 文件

`druid-1.1.10.jar`

### 配置文件

配置文件放在 src 目录下，名字为 `druid.properties`

```properties
# key=value
driverClassName=com.mysql.cj.jdbc.Driver
url=jdbc:mysql://localhost:3306/mysql_test?rewriteBatchedStatements=true
username=root
password=zxb19990079994...
# initial connection Size
initialSize=10
# min idle connecton size
minIdle=5
# max active connection size
maxActive=20
# max wait time (5000 mil seconds)
maxWait=5000
```

### 代码使用

```java
public class Druid_ {
    @Test
    public void testDruid() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();
        System.out.println("success");
        connection.close();
    }
}
```

# JDBC Utils Druid

最常用的连接池的工具包。

```java
public class JDBCUtilsByDruid {
    private static final DataSource ds;
    // DS 初始化
    static {
        Properties properties = new Properties();
        try {
            properties.load(Files.newInputStream(Paths.get("src/druid.properties")));
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            System.err.println("druid.properties 文件加载失败，请检查路径和文件内容！");
            throw new RuntimeException(e);
        }
    }
    // 获取连接对象
    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // 关闭连接：并非真正关闭连接，只是把连接对象放回连接池
    public static void close(ResultSet rs, Statement st, Connection connection) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
```

# Apache DB Utils

## 手动封装

之前的问题：

- 关闭 Connection 之后 resultSet 结果集无法使用
- resultSet 不利于数据管理

现在，把表中的记录对象化，每一行数据对应一个实体对象，把这些对象放在 ArrayList 集合中。

```java
public void dateToArrayList() {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    ArrayList<Account> accounts = new ArrayList<>();

    connection = JDBCUtilsByDruid.getConnection();
    String sql = "select * from account";
    try {
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            double balance = resultSet.getDouble(3);
            accounts.add(new Account(id, name, balance));
        }
        System.out.println(accounts);
    } catch (SQLException e) {
        throw new RuntimeException(e);
    } finally {
        JDBCUtilsByDruid.close(resultSet, preparedStatement, connection);
    }
}
```

## 介绍

需要引入 `commons-dbutils-1.8.1.jar` 包

Apache DBUtils 的引入，简化了 JDBC 代码，方便了操作查询结果。

以后使用 JDBC 推荐使用 Apache DB Utils + Druid 连接池。

## 查询

### 多行多列

```java
// 使用 Apache DBUtils + Druid
@Test
public void apacheQuery() throws SQLException {
    Connection connection = JDBCUtilsByDruid.getConnection();
    QueryRunner queryRunner = new QueryRunner();
    String sql = "select * from account where id >= ?";
    // 执行查询，返回结果集封装到集合
    List<Account> list = queryRunner.query(connection, sql, new BeanListHandler<>(Account.class), 0);
    for (Account account : list) {
        System.out.println(account);
    }
    JDBCUtilsByDruid.close(null, null, connection);
}
```

### 单行多列

```java
// 使用 Apache DBUtils + Druid
// 返回的结果是单条对象
@Test
public void apacheQuerySingleResult() throws SQLException {
    Connection connection = JDBCUtilsByDruid.getConnection();
    QueryRunner queryRunner = new QueryRunner();
    String sql = "select * from account where id = ?";
    // 执行查询
    Account account = queryRunner.query(connection, sql,
            new BeanHandler<>(Account.class), 1);

    System.out.println(account);

    JDBCUtilsByDruid.close(null, null, connection);
}
```

### 单行单列

```java
// 使用 Apache DBUtils + Druid
// 返回的结果是单条对象，且单列数据
@Test
public void apacheQuerySingleColumn() throws SQLException {
    Connection connection = JDBCUtilsByDruid.getConnection();
    QueryRunner queryRunner = new QueryRunner();
    String sql = "select name from account where id = ?";
    // 执行查询
    Object obj = queryRunner.query(connection, sql,
            new ScalarHandler(), 2);

    System.out.println(obj);

    JDBCUtilsByDruid.close(null, null, connection);
}
```

## DML

### Update

```java
public void update() throws SQLException {
    Connection connection = JDBCUtilsByDruid.getConnection();
    QueryRunner queryRunner = new QueryRunner();
    String sql = "update account set balance = ? where id = ?";
    // 执行更新，返回受影响的行数
    int affectedRow = queryRunner.update(connection, sql, 999.9, 1);
    System.out.println(affectedRow == 1 ? "更新成功" : "没有影响数据库");

    JDBCUtilsByDruid.close(null, null, connection);
}
```

### Delete

```java
public void delete() throws SQLException {
    Connection connection = JDBCUtilsByDruid.getConnection();
    QueryRunner queryRunner = new QueryRunner();
    String sql = "delete from account where id = ?";
    // 执行更新，返回受影响的行数
    int affectedRow = queryRunner.update(connection, sql, 3);
    System.out.println(affectedRow > 0 ? "执行成功" : "没有影响数据库");

    JDBCUtilsByDruid.close(null, null, connection);
}
```

### Insert

```java
public void insert() throws SQLException {
    Connection connection = JDBCUtilsByDruid.getConnection();
    QueryRunner queryRunner = new QueryRunner();
    String sql = "insert into account values(null, ?, ?)";
    // 执行更新，返回受影响的行数
    int affectedRow = queryRunner.update(connection, sql, "zxb", "100");
    System.out.println(affectedRow > 0 ? "执行成功" : "没有影响数据库");

    JDBCUtilsByDruid.close(null, null, connection);
}
```

# Basic DAO

Apache-DBUtils + Druid 简化了 JDBC 开发，但还有不足：

- SQL 语句固定，不能指定参数
- 查询语句返回值数据类型不能固定，需要使用范型
- 面对多表，多业务，一个 Java 类无法满足业务需求

所以引出 BasicDAO

- BasicDAO 抽象出各个 DAO 的共同操作，作为父类。
- 每一张表对应一个专属的 DAO 用于对表进行操作。
- Domain / JabaBean/ pojo 是各个表对应的实体类。

## DAO

> Data Access Object

### BasicDAO

```java
package com.sinbin.basic_dao_.dao;

import com.sinbin.basic_dao_.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 其他 DAO 的父类
 */
public class BasicDAO<T> {
    private QueryRunner qr = new QueryRunner();

    // DML
    public int update(String sql, Object... parameters) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            int res = qr.update(connection, sql, parameters);
            return res;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    // 多行多列
    public List<T> queryMulti(String sql, Class<T> cls, Object... parameters) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection, sql, new BeanListHandler<T>(cls), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    // 单行多列
    public T querySingle(String sql, Class<T> cls, Object... parameters) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection, sql, new BeanHandler<T>(cls), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    // 单行单列
    public Object queryScalar(String sql, Object... parameters) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection, sql, new ScalarHandler(), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }
}
```

### AccountDAO

```java
package com.sinbin.basic_dao_.dao;

import com.sinbin.basic_dao_.domain.Account;

public class AccountDAO extends BasicDAO<Account> {
    // 可以编写特有的方法
}

```

## Domain

又称 JavaBean 也称 fojo 是表对应的实体类

```java
package com.sinbin.basic_dao_.domain;

public class Account {
    private Integer id;
    private String name;
    private double balance;

    public Account() {

    }

    public Account(Integer id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
```

## Utils

```java
package com.sinbin.basic_dao_.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtilsByDruid {
    private static final DataSource ds;
    // DS 初始化
    static {
        Properties properties = new Properties();
        try {
            properties.load(Files.newInputStream(Paths.get("src/druid.properties")));
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            System.err.println("druid.properties 文件加载失败，请检查路径和文件内容！");
            throw new RuntimeException(e);
        }
    }
    // 获取连接对象
    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // 关闭连接：并非真正关闭连接，只是把连接对象放回连接池
    public static void close(ResultSet rs, Statement st, Connection connection) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
```

## Test

以后项目在 Service 层调用各个 DAO

```java
package com.sinbin.basic_dao_.test;

import com.sinbin.basic_dao_.dao.AccountDAO;
import com.sinbin.basic_dao_.domain.Account;
import org.junit.Test;

import java.util.List;

public class TestDAO {
    @Test
    public  void testAccountDAO() {
        AccountDAO accountDAO = new AccountDAO();
        // 查询多行多列
        String sql = "select * from account";
        List<Account> accounts = accountDAO.queryMulti(sql, Account.class);
        // iter
        for (Account account : accounts) {
            System.out.println(account);
        }
        // 查询单行多列
        sql = "select * from account where id = ?";
        Account account = accountDAO.querySingle(sql, Account.class, 1);
        System.out.println(account);
        // 单行单列
        sql = "select name from account where id = ?";
        Object obj = accountDAO.queryScalar(sql,1);
        System.out.println(obj);
        // DML 操作
        sql = "insert into account values(null, ?, ?)";
        int res = accountDAO.update(sql, "zxb", 888.8);
        System.out.println(res > 0 ? "success" : "error");
    }
}
```













