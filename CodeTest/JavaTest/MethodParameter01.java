public class MethodParameter01 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        A myA = new A();
        myA.swap(a, b);
        System.out.println("after after sawp a=" + a +  "b=" + b);

        int[] arr2 = new int[2];
        arr2[0] = 1;
        arr2[1] = 2;

        A myb = new A();
        myb.swapArr(arr2);

        for(int i = 0; i < arr2.length; i++)
            System.out.print(arr2[i] + " ");

    }
}

class A {
    public void swap(int a, int b) {
        int temp;
        temp = a;
        a = b;
        b = temp;
        System.out.println("after swap a=" + a +"b=" + b);
    }

    public void swapArr(int[] arr) {
        int temp;
        temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;
        
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
