package ch08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p56 {
    // 백준 p1753
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());   // 노드 개수
        int E = Integer.parseInt(st.nextToken());   // 에지 개수
        int start = Integer.parseInt(bf.readLine());   // 시작 노드

        int[] distance = new int[N+1];              // 최단 거리
        boolean[] visited = new boolean[N+1];       // 방문 확인 배열
        ArrayList<Edge>[] list = new ArrayList[N+1];    // 인접 리스트
        PriorityQueue<Edge> q = new PriorityQueue<>();  // 방문 가능한 노드
        for(int i = 0; i < N+1; i++){
            list[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;        // 최단 거리를 모두 무한으로 초기화
        }
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(v, w));    // 인접 배열 초기화
        }

        q.add(new Edge(start,0));
        distance[start] = 0;

        while(!q.isEmpty()){
            Edge now = q.poll();
            int now_v = now.vertex;

            if(visited[now_v]) continue;
            else visited[now_v] = true;

            for(Edge next : list[now_v]){
                int next_v = next.vertex;
                int next_w = next.value;

                if(distance[next_v] > distance[now_v] + next_w){
                    distance[next_v] = distance[now_v] + next_w;
                    q.add(new Edge(next_v, distance[next_v]));
                }
            }
        }
        for(int i = 1; i <= N; i++){
            if(visited[i]){
                System.out.println(distance[i]);
            }else{
                System.out.println("INF");
            }
        }



    }

    static class Edge implements Comparable<Edge>{
        int vertex, value;
        Edge(int vertex, int value){
            this.vertex = vertex;
            this.value = value;
        }
        /* 우선순위 큐를 위해 두 엣지를 비교하는 compareTo 추가 */
        public int compareTo(Edge e){
            if(this.value > e.value) return 1;
            else return -1;
        }
    }
}

