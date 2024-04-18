package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

class q20728 {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("res/sin.txt"));
        int N = Integer.parseInt(br.readLine()); // 첫 번째 줄에서 테스트 케이스의 수를 읽어옵니다.

        for (int i = 0; i < N; i++) {

            String[] line = br.readLine().split(" "); // 다음 줄을 읽어서 공백을 기준으로 분리합니다.
            int size = Integer.parseInt(line[1]); // 주머니 크기

            String[] line1 = br.readLine().split(" ");
            long[] candies = new long[line1.length];
            for (int j = 0; j < line1.length; j++) {
                candies[j] = Long.parseLong(line1[j]); // 사탕 배열을 long 타입으로 파싱하여 저장
            }

            Arrays.sort(candies); // 사탕 배열 정렬

            long MIN = Long.MAX_VALUE; int idx=candies.length-1;
            while (idx >=0) {

                if (idx - size + 1 < 0) break;
                long temp = candies[idx] - candies[idx - size + 1];
                if (temp < MIN) MIN = temp;
                idx--;
            }
            System.out.println(MIN); // 최소 차이를 출력
        }

        br.close(); // 리소스 해제
    }
}
