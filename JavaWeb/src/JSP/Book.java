package JSP;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Book {
    private String name;
    private String[] author;
    private List<String> reader;
    private Map<String, String> comment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getAuthor() {
        return author;
    }

    public void setAuthor(String[] author) {
        this.author = author;
    }

    public List<String> getReader() {
        return reader;
    }

    public void setReader(List<String> reader) {
        this.reader = reader;
    }

    public Map<String, String> getComment() {
        return comment;
    }

    public void setComment(Map<String, String> comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author=" + Arrays.toString(author) +
                ", reader=" + reader +
                ", comment=" + comment +
                '}';
    }
}
