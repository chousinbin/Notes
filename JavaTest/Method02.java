public class Method02 {
	public static void main(String[] args) {
		int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		Tools myTools = new Tools();
		
		myTools.bianli(arr);
	}
}

class Tools {

	public void bianli(int[][] ans) {
		for(int i = 0; i < ans.length; i++)
		{
			for(int j = 0; j<ans[i].length; j++)
				System.out.print(ans[i][j] + " ");
			System.out.println();
		}
	}
}