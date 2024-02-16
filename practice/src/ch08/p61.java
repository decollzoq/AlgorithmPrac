package ch08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p61 {
    // 백준 p11404
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());    // 노드 개수
        int m = Integer.parseInt(bf.readLine());    // 에지 개수

        int[][] distance = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i == j) distance[i][j] = 0;      // 인접 행렬 초기화
                else distance[i][j] = 10000001;
            }
        }

        StringTokenizer st;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(distance[a][b] > c)
                distance[a][b] = c;
        }

        for(int k = 1; k <= n; k++) {    // 경유지
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(distance[i][j] == 10000001)
                    System.out.print(0+" ");
                else
                    System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }
    }
}
