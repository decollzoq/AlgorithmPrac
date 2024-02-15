import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p10 {
    // 백준 11003
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());   // 데이터 개수
        int L = Integer.parseInt(st.nextToken());   // 슬라이딩 도어 범위

        st = new StringTokenizer(bf.readLine());

        Deque<Node> deq = new LinkedList<>();       // 데이터를 담을 덱

        for(int i = 0; i < N; i++){
            int now = Integer.parseInt(st.nextToken()); // 새로운 값
            
            // 덱에 마지막부터 새로운 값과 비교하여 새로운 값보다 큰 경우 덱에서 제거하기
            while(!deq.isEmpty() && deq.getLast().value > now){
                deq.removeLast();
            }

            // 덱 마지막에 새로운 값 추가하기
            deq.addLast(new Node(i, now));

            // 덱의 맨 앞 값이 슬라이딩 도어 범위에 넘어간다면 제거하기
            if(deq.getFirst().index <= i-L) deq.removeFirst();

            // 덱의 맨 앞에는 슬라이딩 도어 범위 안의 최소값이 있게 됨
            bw.write(deq.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }
    static class Node{
        public int index;
        public int value;

        Node(int index, int value){
            this.index = index;
            this.value = value;
        }
    }
}
