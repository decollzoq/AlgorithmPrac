import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p54 {
    // 백준 1516
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());   // 건물 개수
        ArrayList<Integer>[] build = new ArrayList[N+1];    // 인접 리스트
        for(int i = 0; i <= N; i++){
            build[i] = new ArrayList<>();
        }
        int[] indegree = new int[N+1];  // 진입 차수 배열
        int[] selfBuild = new int[N+1];   // 자기 자신을 짓는데 걸리는 시간


        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            selfBuild[i] = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            while(n != -1){
                build[n].add(i);    // 인접 리스트에 추가하기
                indegree[i]++;      // 진입 차수 증가하기
                n = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Integer> q = new LinkedList<>();  // 위상 정렬
        for(int i = 1; i <= N; i++){
            if(indegree[i] == 0){   // 진입 차수가 0인 건물을 위상 정렬에 추가한다
                q.offer(i);
            }
        }

        int[] ans = new int[N+1];
        while(!q.isEmpty()){
            int now = q.poll(); // 진입 차수가 0인 건물 1
            for(int i : build[now]){
                indegree[i]--;  // 진입 차수 감소시키기
                ans[i] = Math.max(ans[i], ans[now] + selfBuild[now]);   // 건물 짓는 데 걸리는 최소시간 업데이트
                if(indegree[i] == 0){
                    q.offer(i);
                }
            }

        }

        for(int i = 1; i <= N; i++){
            System.out.println(ans[i]+selfBuild[i]);
        }
    }
}
