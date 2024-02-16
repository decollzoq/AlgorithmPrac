package ch03;

import java.util.Scanner;
public class p5 {
    // 백준 p10986
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        long cnt = 0;

        long[] S = new long[N]; // 합 배열
        long[] D = new long[M]; // D[i] = 나머지가 i인 합의 개수

        S[0] = sc.nextInt();
        for(int i = 1; i < N; i++){
            S[i] = S[i-1] + sc.nextInt();
        }
        for(int i = 0; i < N; i++){
            int remainder = (int)(S[i] % M);    // 0 <= remainder < 1000
            D[remainder]++;
        }

        cnt += D[0];

        for(int i = 0; i < M; i++){
            if(D[i] > 1){
                cnt += D[i] * (D[i]-1) / 2; // 오버플로우 발생 할 수 있으므로 cnt 타입은 long
            }
        }

        System.out.print(cnt);
    }

}
