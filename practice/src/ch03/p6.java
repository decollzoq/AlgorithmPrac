package ch03;

import java.util.Scanner;
public class p6 {
    // 백준 p2018
    public static void main(String[] args){
        int N = new Scanner(System.in).nextInt();
        int start = 1;
        int end = 1;
        int sum = 1;
        int count = 1;
        while(end != N){
            if(sum == N){
                count++;
                end++;
                sum += end;
            }
            else if(sum > N){
                sum -= start;
                start++;
            }
            else if(sum < N) {
                end++;
                sum += end;
            }
        }
        System.out.println(count);
    }
}
