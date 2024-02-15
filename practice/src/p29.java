import java.util.Arrays;
import java.util.Scanner;
public class p29 {
    // 백준 p1920
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] data = new int[N];
        for(int i = 0; i < N; i++){
            data[i] = sc.nextInt();
        }
        Arrays.sort(data);

        int M = sc.nextInt();
        for(int i = 0; i < M; i++){
            boolean find = false;
            int target = sc.nextInt();
            int start = 0;
            int end = N-1;
            while(start <= end){
                int mid = (start + end) / 2;
                if(data[mid] > target){
                    end = mid-1;
                }
                else if(data[mid] < target){
                    start = mid+1;
                }
                else{
                    find = true;
                    break;
                }
            }

            if(find){
                System.out.println(1);
            }else {
                System.out.println(0);
            }
        }

    }

}
