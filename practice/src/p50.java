import java.util.Scanner;

public class p50 {
    // 백준 p1717
    public static int[] arr;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[n+1];
        for(int i = 0; i <= n; i++){
            arr[i] = i;
        }
        for(int i = 0; i < m; i++){
            int question = sc.nextInt();
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            if(question == 0){
                union(n1, n2);
            }else{
                checkSame(n1, n2);
            }
        }
    }
    public static void union(int n1, int n2){
        int n1_p = find(n1);
        int n2_p = find(n2);
        if(n1_p != n2_p){
            arr[n2_p] = n1_p;
        }
    }

    public static int find(int n){
        if(arr[n] == n) {
            return n;
        }
        else {
            return find(arr[n]);
        }
    }

    public static void checkSame(int n1, int n2){
        int n1_p = find(n1);
        int n2_p = find(n2);
        if(n1_p == n2_p){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
