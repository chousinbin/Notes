public class BL {
	public static void main(String[] args) {
        int i = 1;
        i = i ++;
        System.out.println(i);
        // 由于'='赋值的优先级低于计算，优先于后自增
		// 1.创建临时变量tmp，并把=右边的算式i=1赋值给tmp，tmp=i=1
		// 2.i自增，i=2
		// 3.最后把tmp赋值给i
    }
}