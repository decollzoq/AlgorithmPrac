package ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p3 {
    // 백준 p11659
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        /* StringTokenizer : 문자열을 delim(delimiter) 으로 나눠 저장하는 것
            토큰 : 쪼개어진 문자
            delim : 디폴트로는 \n, \t, \r 등이 있고, 직접 정할 수도 있다.
         */

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int numsNo = Integer.parseInt(stringTokenizer.nextToken());
        int quizNo = Integer.parseInt(stringTokenizer.nextToken());
        long[] iSums = new long[numsNo + 1];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for(int i = 1; i <= numsNo; i++){
            iSums[i] = iSums[i-1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        for(int i = 0; i < quizNo; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(iSums[end] - iSums[start-1]);
        }
    }
}
