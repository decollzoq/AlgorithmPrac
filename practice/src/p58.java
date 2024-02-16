import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p58 {
    // 백준 p1854
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(st.nextToken());   // 노드 개수
        int M = Integer.parseInt(st.nextToken());   // 엣지 개수
        int K = Integer.parseInt(st.nextToken());   // 몇 번째 최단 경로여야 하는지
        int[][] W = new int[N + 1][N + 1];
        PriorityQueue<Integer>[] distQ = new PriorityQueue[N + 1];    // 1번 노드에서 각 노드에 도달하는 경로
        Comparator<Integer> cp = new Comparator<Integer>() {    // 오름차순 정렬
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? 1 : -1;
            }
        };

        for (int i = 0; i <= N; i++) {
            distQ[i] = new PriorityQueue<>(K, cp);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            W[a][b] = c;    // 인접 행렬 초기화
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));  // 시작 노드 추가
        distQ[1].add(0);    // 1번째 노드에서 1번째 노드로 가는 최단 경로의 소요 시간 = 1
        while(!pq.isEmpty()){
            Node now = pq.poll();
            for(int adjNode = 1; adjNode <= N; adjNode++){
                if(W[now.node][adjNode] != 0){
                    if(distQ[adjNode].size() < K){
                        distQ[adjNode].add(now.cost + W[now.node][adjNode]);
                        pq.add(new Node(adjNode,now.cost + W[now.node][adjNode]));
                    }
                    else if(distQ[adjNode].peek() > now.cost + W[now.node][adjNode]){
                        distQ[adjNode].poll();      // 기존 큐에서 최대값(K번째 값) 삭제
                        distQ[adjNode].add(now.cost + W[now.node][adjNode]);    // 새로운 K번째 값 추가
                        pq.add(new Node(adjNode,now.cost + W[now.node][adjNode]));
                    }
                }
            }
        }

        for(int i = 1; i <= N; i++){
            if(distQ[i].size() < K){
                bw.write(-1+"\n");
            }else{
                bw.write(distQ[i].peek() + "\n");
            }
        }
        bw.flush();
        bw.close();
        bf.close();
    }
}

    class Node implements Comparable<Node>{
        int node;
        int cost;
        Node(int n, int c){
            this.node = n;
            this.cost = c;
        }

        @Override
        public int compareTo(Node o){
            return this.cost < o.cost ? -1 : 1;
        }
    }



