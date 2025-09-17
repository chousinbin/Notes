package threadLocal;

public class Share {
    private int id;
    private String name;

    public Share(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Share() {
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
}
