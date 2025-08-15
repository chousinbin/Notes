class Box {
    int length;
    int width;
    int height;

    void setBox(int l, int w, int h) {
        length = l;
        width = w;
        height = h;
    }

    int volume() {
        return length * width * height;
    }
}

public class main {
    public static void main(String[] args) {
        Box b = new Box();
        b.setBox(5, 4, 3);
        int volume = b.volume();
        System.out.println("The volume of the box is " + volume);
    }
}
