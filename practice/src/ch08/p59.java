package ch08;

import java.io.*;
import java.util.StringTokenizer;

public class p59 {
    // 백준 p11657
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 노드 개수
        int M = Integer.parseInt(st.nextToken());   // 에지 개수

        long[] distance = new long[N+1];
        Edge[] edges = new Edge[M];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a,b,c);
        }

        for(int i = 0; i <= N; i++){
            distance[i] = Integer.MAX_VALUE;
        }

        distance[1] = 0;
        for(int i = 0; i < N-1; i++){
            for(int j = 0; j < M; j++){
                int s = edges[j].start;
                int e = edges[j].end;
                int t = edges[j].time;
                if(distance[s] != Integer.MAX_VALUE && distance[s]+t < distance[e]){
                    distance[e] = distance[s]+t;
                }
            }
        }

        boolean isCycle = false;
        for(int j = 0; j < M; j++){
            int s = edges[j].start;
            int e = edges[j].end;
            int t = edges[j].time;
            if(distance[s] != Integer.MAX_VALUE && distance[s]+t < distance[e]){
                isCycle = true;
                break;
            }
        }
        if(isCycle){
            System.out.println(-1);
        }
        else{
            for(int i = 2; i <= N; i++){
                if(distance[i] != Integer.MAX_VALUE){
                    System.out.println(distance[i]);
                }else{
                    System.out.println(-1);
                }
            }
        }

    }
    static class Edge{
        int start, end, time;
        public Edge(int s, int e, int t){
            this.start = s;
            this.end = e;
            this.time = t;
        }

    }

}
