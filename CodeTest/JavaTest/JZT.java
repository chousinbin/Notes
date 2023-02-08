import java.util.Scanner;

public class JZT {
	public static void main (String[] args) {
		Scanner myScanner = new Scanner(System.in);
		int n = myScanner.nextInt();

		for(int i=1;i<=n;i++) {

			for(int k=1;k<=(n-i);k++)
				System.out.print(" ");

			for(int j=1;j<=2*i-1;j++) {
				if(i!=n) {
					if(j==1 || j==2*i-1) System.out.print("*");
					else System.out.print(" ");
				}
				else
					System.out.print("*");
			}

			for(int k=1;k<=(n-i);k++)
				System.out.print(" ");

			System.out.println();
		}
	}
}