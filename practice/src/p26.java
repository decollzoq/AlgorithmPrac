import java.awt.*;
import java.util.*;

public class p26 {
    // 백문 p1260
    static ArrayList<Integer>[] graph;
    static boolean[] isVisited;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();       // 노드 개수
        int E = sc.nextInt();       // 에지 개수
        int start = sc.nextInt();   // 시작점
        graph = new ArrayList[V+1]; // 그래프
        isVisited = new boolean[V+1];   // 방문 체크 배열

        for(int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < E; i++){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            graph[n1].add(n2);
            graph[n2].add(n1);
        }

        // 크기가 작은 순서대로 방문하기 위해 오름차순 정렬
        for(int i = 1; i <= V; i++){
            Collections.sort(graph[i]);
        }

        DFS(start); // DFS 탐색
        System.out.println();

        isVisited = new boolean[V+1];   // 방문 체크 배열 초기화

        BFS(start); // BFS 탐색
    }

    public static void DFS(int v){
        isVisited[v] = true;
        System.out.print(v + " ");
        for(int i : graph[v]){
            if(!isVisited[i]){
                DFS(i);
            }
        }
    }
    public static void BFS(int v){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(v);
        isVisited[v] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            System.out.print(now + " ");
            for(int i : graph[now]){
                if(!isVisited[i]){
                    isVisited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
