package ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p9 {
    // 백준 p12891
    static int check[]; // 부분 문자열에 포함돼야 할 각 문자(A,C,G,T)의 최소 개수
    static int door[];  // 슬라이딩 도어 안에 포함된 각 문자(A,C,G,T)의 개수를 저장할 배열
    static int checkPW; // 총 몇개의 문자를 충족시켰는지 확인
    public static void main(String[] args) throws IOException {
        // (A,0) (C,1) (G,2) (T,3)
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int lenDNA = Integer.parseInt(st.nextToken());  // DNA 문자열의 길이
        int lenPW = Integer.parseInt(st.nextToken());   // 부분 문자열의 길이
        int count = 0; // 만들 수 있는 비밀번호의 수
        checkPW = 0;

        st = new StringTokenizer(bf.readLine());
        char[] DNA = st.nextToken().toCharArray(); // DNA 문자열을 배열로 저장

        st = new StringTokenizer(bf.readLine());
        check = new int[4];

        for(int i = 0; i < 4; i++){
            check[i] = Integer.parseInt(st.nextToken());
            if (check[i] == 0) checkPW++;
        }

        door = new int[4];

        for(int i = 0; i < lenPW; i++){
            Add(DNA[i]);
        }
        if(checkPW == 4) count++;

        for(int end = lenPW; end < lenDNA; end++){
            int start = end - lenPW;
            Remove(DNA[start]);
            Add(DNA[end]);
            if(checkPW == 4) count++;
        }

        System.out.println(count);
        bf.close();

    }

    public static void Add(char c){ // 새로운 문자를 추가하는 경우 사용
        switch (c){
            case 'A':
                door[0]++;
                if(door[0] == check[0]) checkPW++;
                break;
            case 'C':
                door[1]++;
                if(door[1] == check[1]) checkPW++;
                break;
            case 'G':
                door[2]++;
                if(door[2] == check[2]) checkPW++;
                break;
            case 'T':
                door[3]++;
                if(door[3] == check[3]) checkPW++;
                break;
        }
    }

    public static void Remove(char c){  // 기존 맨 앞 문자를 삭제하는 경우 사용
        switch (c){
            case 'A':
                if(door[0] == check[0]) checkPW--;
                door[0]--;
                break;
            case 'C':
                if(door[1] == check[1]) checkPW--;
                door[1]--;
                break;
            case 'G':
                if(door[2] == check[2]) checkPW--;
                door[2]--;
                break;
            case 'T':
                if(door[3] == check[3]) checkPW--;
                door[3]--;
                break;
        }
    }
}
