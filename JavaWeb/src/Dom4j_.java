import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import java.io.*;
import java.util.List;

public class Dom4j_ {
    @Test
    public void loadXML() throws DocumentException {
        // 创建解析器
        SAXReader reader = new SAXReader();
        // XML Document
        Document document = reader.read(
                new File("/Users/sinpin/Desktop/GitHub/MyCode/JavaWeb/04XML/students.xml"));
        // 在此设置断点，执行调试，可以发现 Document 对象是一个树形结构，对应 XML 文件内容
        System.out.println(document);
    }

    // 遍历 Students
    @Test
    public void listStudents() throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(
                new File("/Users/sinpin/Desktop/GitHub/MyCode/JavaWeb/04XML/students.xml"));
        // 获取根节点
        Element rootElement = document.getRootElement();
        // 获取根节点的子节点
        List<Element> student = (List<Element>) rootElement.elements("student");
        // 输出信息
        System.out.println(student.size());
        for (Element o : student) {
            System.out.print(o.attributeValue("id") + " ");
            Element name = o.element("name");
            Element gender = o.element("gender");
            Element age = o.element("age");
            System.out.println(name.getText() + " " + age.getText() + " " + gender.getText());
        }
    }

    @Test
    public void addStudent() throws DocumentException, IOException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(
                new File("/Users/sinpin/Desktop/GitHub/MyCode/JavaWeb/04XML/students.xml"));
        // 在内存中添加节点
        Element student = DocumentHelper.createElement("student");
        student.addAttribute("id", "03");

        Element name = DocumentHelper.createElement("name");
        name.setText("宋江");
        student.add(name);

        Element gender = DocumentHelper.createElement("gender");
        gender.setText("男");
        student.add(gender);

        Element age = DocumentHelper.createElement("age");
        age.setText("55");
        student.add(age);

        document.getRootElement().add(student);

        // 解决乱码
        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("UTF-8");
        // XML 文件更新
        XMLWriter xmlWriter = new XMLWriter(
                new FileOutputStream(
                        new File("/Users/sinpin/Desktop/GitHub/MyCode/JavaWeb/04XML/students.xml")), outputFormat);
        xmlWriter.write(document);
        xmlWriter.close();
        // 遍历
        listStudents();
    }

    @Test
    public void removeStudent() throws DocumentException, IOException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(
                new File("/Users/sinpin/Desktop/GitHub/MyCode/JavaWeb/04XML/students.xml"));

        Element rootElement = document.getRootElement();
        List<Element> student = (List<Element>) rootElement.elements("student");
        Element element = student.get(0);
        element.getParent().remove(element);
        // 解决乱码
        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("UTF-8");
        // XML 文件更新
        XMLWriter xmlWriter = new XMLWriter(
                new FileOutputStream(
                        new File("/Users/sinpin/Desktop/GitHub/MyCode/JavaWeb/04XML/students.xml")), outputFormat);
        xmlWriter.write(document);
        xmlWriter.close();
        // 遍历
        listStudents();
    }

    @Test
    public void updateStudent() throws DocumentException, IOException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(
                new File("/Users/sinpin/Desktop/GitHub/MyCode/JavaWeb/04XML/students.xml"));

        Element rootElement = document.getRootElement();
        List<Element> students = (List<Element>) rootElement.elements("student");
        Element student = students.get(0);
        int age = Integer.parseInt(student.element("age").getText());
        age += 3;
        student.element("age").setText(String.valueOf(age));
        // 解决乱码
        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("UTF-8");
        // XML 文件更新
        XMLWriter xmlWriter = new XMLWriter(
                new FileOutputStream(
                        new File("/Users/sinpin/Desktop/GitHub/MyCode/JavaWeb/04XML/students.xml")), outputFormat);
        xmlWriter.write(document);
        xmlWriter.close();
        // 遍历
        listStudents();
    }
}
