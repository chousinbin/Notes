import java.util.Scanner;
public class ArrayAdd {
	public static void main(String[] args) {
		Scanner scanf = new Scanner(System.in);
		/*
		数组扩容
		*/

		int[] arr = {1, 2, 3};
		do
		{
			int[] newarr = new int[arr.length + 1];
			for(int i = 0; i < arr.length; i ++)
				newarr[i] = arr[i];

			System.out.print("write the number what you want to add:");
			
			int res = scanf.nextInt();
			newarr[newarr.length - 1] = res;

			arr = newarr;
			
			for(int i = 0; i < arr.length; i ++)
				System.out.print(arr[i] + "\t");

			System.out.println("out?(y/N)");
			char key = scanf.next().charAt(0);
			if(key == 'y') break;

		}while(true);
	}
}