package ch06;

import java.util.Scanner;

public class p36 {
    // 백준 p1541
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String data = sc.next();
        String[] str = data.split("-");
        int ans = 0;
        for(int i = 0; i < str.length; i++){
            int sum = add(str[i]);
            if(i == 0) ans += sum;
            else ans -= sum;
        }
        System.out.println(ans);
    }

    public static int add(String str){
        String[] arr = str.split("[+]");
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += Integer.parseInt(arr[i]);
        }
        return sum;
    }
}
