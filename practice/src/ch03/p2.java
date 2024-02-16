package ch03;

import java.util.Scanner;
public class p2 {
    // 백준 p1546
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] iNum = new int[N];
        long sum = 0;
        long max = 0;
        for(int i = 0; i < N; i++){
            iNum[i] = sc.nextInt();
            if(iNum[i] > max) max = iNum[i];
            sum += iNum[i];
        }

        System.out.print(sum*100.0 / max / N);
    }
}
