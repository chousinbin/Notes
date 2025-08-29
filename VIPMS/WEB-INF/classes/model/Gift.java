package model;
import java.util.Date;
import java.math.BigDecimal;

public class Gift {
    private int id;
    private String name;
    private int stock;
    private int value;

    public Gift() {}

    public Gift(int id, String name, int stock, int value) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
