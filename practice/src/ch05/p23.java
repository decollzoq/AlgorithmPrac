package ch05;

import java.util.ArrayList;
import java.util.Scanner;

public class p23 {
    // 백문 p11724
    static boolean[] isVisited;
    static ArrayList<Integer>[] graph;
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();   // 노드 개수
        int E = sc.nextInt();   // 에지 개수

        graph = new ArrayList[V+1];  // 그래프

        for(int i = 1; i < V+1; i++){
            graph[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < E; i++){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            // 무방향 그래프
            graph[n1].add(n2);
            graph[n2].add(n1);
        }

        isVisited = new boolean[V+1];   // 방문 체크 배열
        isVisited[0] = true;
        int count = 0;  // 연결 요소 (connected component)

        for(int i = 1; i < V+1; i++){
            if(!isVisited[i]){
                count++;
                DFS(i);
            }
        }
        System.out.print(count);
        sc.close();
    }

    public static void DFS(int v){
        // 방문한 노드는 건너 뛴다.
        if(isVisited[v]) return;

        // 방문하지 않았다면 방문 체크를 한다.
        isVisited[v] = true;
        // 깊이 탐색을 시작한다.
        for(int i : graph[v])
            DFS(i);

    }

}
