package json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

public class JavaJson {
    public static void main(String[] args) {
        Gson gson = new Gson();
        Book book = new Book(1, "zxb");

        String strBook = gson.toJson(book);
        System.out.println("strBook: " + strBook);

        Book book1 = gson.fromJson(strBook, Book.class);
        System.out.println("book1: " + book1);

        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(new Book(1, "zxb"));
        bookList.add(new Book(2, "xbb"));

        String strBookList = gson.toJson(bookList);
        System.out.println("strBookList: " + strBookList);

        Type type = new TypeToken<ArrayList<Book>>() {
        }.getType();
        System.out.println("type: " + type);
        ArrayList<Book> bookList2 = gson.fromJson(strBookList, type);
        System.out.println("bookList2: " + bookList2);


        HashMap<String, Book> bookMap = new HashMap<>();
        bookMap.put("b1", new Book(1, "zxb"));
        bookMap.put("b2", new Book(2, "xbb"));

        String strBookMap = gson.toJson(bookMap);
        System.out.println("strBookMap: " + strBookMap);

        Type type2 = new TypeToken<HashMap<String, Book>>() {
        }.getType();
        System.out.println("type2: " + type2);
        HashMap<String, Book> bookMap2 = gson.fromJson(strBookMap, type2);
        System.out.println("bookMap2: " + bookMap2);
    }
}
