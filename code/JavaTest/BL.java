public class BL {
	public static void main(String[] args) {
        int i = 1;
        i = i ++;
        System.out.println(i);
        // ����'='��ֵ�����ȼ����ڼ��㣬�����ں�����
		// 1.������ʱ����tmp������=�ұߵ���ʽi=1��ֵ��tmp��tmp=i=1
		// 2.i������i=2
		// 3.����tmp��ֵ��i
    }
}