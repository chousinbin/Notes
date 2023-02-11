public class VarParameter {
    public static void main(String[] args) {
        VP myVP = new VP();
        System.out.println(myVP.sum());
        System.out.println(myVP.sum(1, 2, 3,4));

        int[] arr1 = {4, 5, 6};
        System.out.println(myVP.sum(arr1));

        System.out.println(myVP.showScore("Sun", 90 , 80));
    }
}

class VP {
    /*
     * ���ؿɱ����֮��
     */
    public int sum(int... n) {
        int res = 0;
        for(int i = 0; i < n.length; i++) {
            res += n[i];
        }
        return res;
    }
    /*
     * ����ѧ�����������������ܳɼ��Ŀɱ��������
     */
    public String showScore(String name, int... scores) {
        double res = 0;
        for(int i = 0; i < scores.length; i++) {
            res += scores[i];
        }
        return name + " " + res;
    }
    
}