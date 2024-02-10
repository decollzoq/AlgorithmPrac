import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p7 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        int[] array = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        int count = 0;
        int start = 0, end = N-1;
        while(start < end){
            int sum = array[start] + array[end];
            if(sum < M) start++;
            else if(sum > M) end--;
            else {
                start++;
                end--;
                count++;
            }
        }
        System.out.print(count);
        bf.close();
    }
}
