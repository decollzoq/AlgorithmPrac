package ch04;

import java.util.Scanner;

public class p15 {
    // 백준 p2750
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < N-1; i++){
            for(int j = 0; j < N-i-1; j++){
                int now = arr[j];
                int next = arr[j+1];
                if(now > next){
                    arr[j+1] = now;
                    arr[j] = next;
                }
            }
        }

        for(int i = 0; i < N; i++){
            System.out.println(arr[i]);
        }
    }
}
