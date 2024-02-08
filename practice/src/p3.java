import java.util.Scanner;
public class p3 {
    // 백준 p11659
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int query = sc.nextInt();
        long[] iNums = new long[N];
        long[] iSums = new long[N];
        iNums[0] = sc.nextLong();
        iSums[0] = iNums[0];

        for(int i = 1; i < N; i++){
            iNums[i] = sc.nextLong();
            iSums[i] = iSums[i-1] + iNums[i];
        }

        for(int i = 0; i < query; i++){
            int start = sc.nextInt() - 1;
            int end = sc.nextInt() - 1;
            if(start == end) {
                System.out.println(iNums[end]);
                continue;
            }
            if(start == 0) {
                System.out.println(iSums[end]);
                continue;
            }
            System.out.println(iSums[end] - iSums[start-1]);
        }
    }
}
