## JUnit

JUnit 是 Java 语言的单元测试类，经常在 IDE 中被用来执行单元测试。

- 使用方法：在被测试的方法前加上 `@Test`。
- 使用条件：被测试方法必须是非静态的、无参的、无返回的。

```java
import org.junit.jupiter.api.Test;
```

### 测试代码

```java
package com.generics_;

import org.junit.jupiter.api.Test;
import java.util.*;

@SuppressWarnings({"all"})

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/22 19:18
 * @Description: P565
 * 定义个泛型类DAO<T>,在其中定义一个Map成员变量，Map的键为String类型，值为T类
 * 分别创建以下方法：
 * (1)public void save(String id,T entity):保存T类型的对象到Map成员变量中
 * (2)public T get(String id):从 map 中获取id对应的对象
 * (3)public void update(String id,T entity):替换map中ky为id的内容，改为entity对象
 * (A)public List<T>Iist():返回 map 中存放的所有T对象
 * (5)public void delete(String id):删除指定id对象
 * 定义一个User类：
 * 该类包含：private成员变量(int类型)id,age;(String类型)
 * name.
 * 创建DAO类的对象，分别调用其save、get、update、Iist、delete方法来操作User对象，
 * 使用Junit单元测试类进行测试。
 */
public class Homework01 {
    public static void main(String[] args) {

    }

    @Test
    public void test() {
        User user1 = new User(1, 22, "zxb");
        User user2 = new User(2, 16, "zxk");
        User user3 = new User(3, 44, "hsp");

        DAO<User> userDAO = new DAO<User>();
        userDAO.save("1", user1);
        userDAO.save("2", user2);
        userDAO.save("3", user3);

        System.out.println(userDAO.get("1"));

        userDAO.update("1", new User(1, 22, "xb"));

        List<User> list = userDAO.list();
        System.out.println(list);

        userDAO.delete("1");

        list = userDAO.list();
        System.out.println(list);
    }
}

class DAO<T> {
    Map<String, T> map = new HashMap<>();

    public void save(String id, T entity) {
        map.put(id, entity);
    }
    public T get(String id) {
        return map.get(id);
    }
    public void update(String id, T entity) {
        map.put(id, entity);
    }

    public List<T> list() {
        List<T> list = new ArrayList<>();
        Set<String> keys = map.keySet();
        for (String key : keys) {
            list.add(get(key));
        }
        return list;
    }
    public void delete(String id) {
        map.remove(id);
    }
}

class User {
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

```

