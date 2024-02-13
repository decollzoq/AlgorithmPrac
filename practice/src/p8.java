import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p8 {
    // 백준 p1253
    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int count = 0;
        long A[] = new long[N];
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        for(int i = 0; i < N; i++){
            long goal = A[i];
            int start = 0;
            int end = N-1;
            while(start < end){
                long sum = A[start] + A[end];
                if (sum == goal) {
                    if(start != i && end != i) {
                        count++;
                        break;
                    }
                    else if(start == i) start++;
                    else if(end == i) end--;
                } else if (sum < goal) {
                    start++;
                } else {
                    end--;
                }

            }
        }

        System.out.println(count);

    }
}
